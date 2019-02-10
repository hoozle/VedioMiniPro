//index.js
//获取应用实例
const app = getApp();

const template = require('../template/template.js');

Page({
  data: {
    serverUrl:"",
    isMe : true,
    iconUrl : "/pages/resource/images/noneface.jpg",
    videoSelClass : "video-info",
    isSelectedWork : "video-info-selected",
    isFollow : false,
  	fansCounts : 0,
  	followCounts : 0,
  	receiveLikeCounts : 0,
    queryID:"",

    myVideoList: [],
    myVideoPage: 1,
    myVideoTotal: 1,

    likeVideoList: [],
    likeVideoPage: 1,
    likeVideoTotal: 1,

    followVideoList: [],
    followVideoPage: 1,
    followVideoTotal: 1,

    myWorkFalg: false,
    myLikesFalg: true,
    myFollowFalg: true
  },

  //加载页面时查询用户信息
  onLoad: function(reqUser){
  	var that = this;
  	var user = app.getGlobalUser();
    if(null!=user){
  	   var queryID = user.id;
    }

    template.buildBar('tabbar', 0, this);

  	if(null != reqUser.userID && "" != reqUser.userID && undefined != reqUser.userID ){
  		queryID = reqUser.userID;
  		that.setData({
        queryID : queryID,
  			isMe : false
  		})
  	}

  	wx.request({
  		  url: app.serverUrl + "/user/queryUser?userID=" + queryID +"&fanID=" + user.id,
        method: "GET",
        success: function(res){
          if(200 == res.data.status){
        		var userInfo = res.data.data;
          	var iconUrl = that.data.iconUrl;

          	if(null != userInfo.faceImage && "" != userInfo.faceImage && undefined != userInfo.faceImage){
          		iconUrl =  app.serverUrl + userInfo.faceImage;
          	}

          	that.setData({
              serverUrl :app.serverUrl,
          		iconUrl : iconUrl,
          		nickname : userInfo.nickname,
          		fansCounts : userInfo.fansCounts,
          		followCounts : userInfo.followCounts,
          		receiveLikeCounts : userInfo.receiveLikeCounts,
          		isFollow : userInfo.following
          	}) 
          }else{
	            wx.redirectTo({
	               url: '../login/login'
          
             })
          }
        },
  	})
    this.getMyVideoList(1);

  },

  //注销
  logout:function(){
    var serviceUrl = app.serverUrl + "/logout?userID=" + app.getGlobalUser().id;
    wx.showLoading({
          title: '请稍等！',
        });
    wx.request({
        url: serviceUrl,
        method: "POST",
        success: function(res){
          wx.hideLoading();
          if(200 == res.data.status){
          	app.setGlobalUser(null);
        	wx.navigateTo({
        		url:'../login/login'
        	})   
          }else{
          	wx.showToast({
          	  title: res.data.msg,
		          icon: 'none',
		          duration: 2000  
          	})
          }
        },

      });
  },

  //更换头像
  changeFace:function(){
  	var that = this;
    var userID = app.getGlobalUser().id;
    var userToken = app.getGlobalUser().userToken;
    
  	wx.chooseImage({
	  count: 1,
	  sizeType: ['compressed'],
	  sourceType: ['album', 'camera'],
	  success(res) {
	    // tempFilePath可以作为img标签的src属性显示图片
	  const tempFilePaths = res.tempFilePaths;
	  var serverUrl = app.serverUrl + "/user/uploadFace?userID=" + app.getGlobalUser().id;
	  wx.showLoading({
	  	title:"上传中..."
	  });

	  wx.uploadFile({
	      url: serverUrl, 
	      filePath: tempFilePaths[0],
	      name: 'file',
        header:{
          userID:userID,
          userToken:userToken
        },
	      success(res) {
	      	wx.hideLoading();
	        var data = JSON.parse(res.data);
	        if(200 == data.status){
	        	wx.showToast({
	        		title : "上传成功",
	        		icon : "success"
	        	});
	        	//直接赋值无法改变页面的状态，需调用微信官方的setData将数据从逻辑层发送到视图层（异步），同时改变对应的 this.data 的值（同步）
	        	that.setData({
		        	iconUrl : app.serverUrl + data.data
	        	})
	        }else{
	        	wx.showToast({
	        		title : data.msg,
	        		icon : "none"
	        	});

	        }
	      }
      })

	  }
	})
  },

  doSelectWork: function () {
    this.setData({
      isSelectedWork: "video-info-selected",
      isSelectedLike: "",
      isSelectedFollow: "",

      myWorkFalg: false,
      myLikesFalg: true,
      myFollowFalg: true,

      myVideoList: [],
      myVideoPage: 1,
      myVideoTotal: 1,

      likeVideoList: [],
      likeVideoPage: 1,
      likeVideoTotal: 1,

      followVideoList: [],
      followVideoPage: 1,
      followVideoTotal: 1
    });

    this.getMyVideoList(1);
  },

  doSelectLike: function () {
    this.setData({
      isSelectedWork: "",
      isSelectedLike: "video-info-selected",
      isSelectedFollow: "",

      myWorkFalg: true,
      myLikesFalg: false,
      myFollowFalg: true,

      myVideoList: [],
      myVideoPage: 1,
      myVideoTotal: 1,

      likeVideoList: [],
      likeVideoPage: 1,
      likeVideoTotal: 1,

      followVideoList: [],
      followVideoPage: 1,
      followVideoTotal: 1
    });

    this.getLikeVideoList(1);
  },

  doSelectFollow: function () {
    this.setData({
      isSelectedWork: "",
      isSelectedLike: "",
      isSelectedFollow: "video-info-selected",

      myWorkFalg: true,
      myLikesFalg: true,
      myFollowFalg: false,

      myVideoList: [],
      myVideoPage: 1,
      myVideoTotal: 1,

      likeVideoList: [],
      likeVideoPage: 1,
      likeVideoTotal: 1,

      followVideoList: [],
      followVideoPage: 1,
      followVideoTotal: 1
    });

    this.getMyFollowList(1)
  },


  getMyVideoList: function(page){
    var that = this;
    var userID;
    if(this.data.isMe){
      userID = app.getGlobalUser().id;
    }else{
      userID = this.data.queryID;
    }
    var serverUrl = app.serverUrl + "/video/queryAll?page=" + page + "&userID=" + userID;
     wx.request({
      url : serverUrl,
      method: "GET",
      success : function(res){
         that.setData({
          myVideoList: res.data.data.videos,
          myVideoPage:  res.data.data.page.currentPage,
          myVideoTotal: res.data.data.page.totalPage,
        });
      }
    })
  },

  getLikeVideoList: function(page){
    var that = this;
    var userID;
    if(this.data.isMe){
      userID = app.getGlobalUser().id;
    }else{
      userID = this.data.queryID;
    }
    var serverUrl = app.serverUrl + "/video/queryMyLike?page=" + page + "&userID=" + userID;
     wx.request({
      url : serverUrl,
      method: "GET",
      success : function(res){
         that.setData({
          likeVideoList: res.data.data.videos,
          likeVideoPage:  res.data.data.page.currentPage,
          likeVideoTotal: res.data.data.page.totalPage,
        });
      }
    })
  },

  getMyFollowList: function(page){
     var that = this;
     var userID;
    if(this.data.isMe){
      userID = app.getGlobalUser().id;
    }else{
      userID = this.data.queryID;
    }
     var serverUrl = app.serverUrl + "/video/queryFollowerVideos?page=" + page + "&userID=" + userID;
     wx.request({
      url : serverUrl,
      method: "GET",
      success : function(res){
         that.setData({
          followVideoList: res.data.data.videos,
          followVideoPage:  res.data.data.page.currentPage,
          followVideoTotal: res.data.data.page.totalPage,
        });
      }
    })

  },

  followMe:function(){
    var that = this;
    var userToken = app.getGlobalUser().userToken;
    var userID = this.data.queryID;
    var fanID = app.getGlobalUser().id;
    var follow = !(this.data.isFollow);
    var serverUrl = app.serverUrl + "/user/followUser?userID=" + userID +"&fanID=" + fanID + "&follow=" + follow ;
    wx.request({
      url : serverUrl,
      method: "POST",
      header:{
        userID:fanID,
        userToken:userToken
      },
      success : function(res){
         if(200 == res.data.status){
           that.setData({
             fansCounts:res.data.data.fansCounts,
             isFollow:res.data.data.isFollow
           })
         }else{
           wx.showToast({
            title:res.data.msg
           })
         }
       }
     })

  },

  showVideo:function(e){
    var videoIdx =  e.target.dataset.arrindex;
    var video = JSON.stringify(this.data.myVideoList[videoIdx]);
      wx.navigateTo({
        url:"/pages/videoInfo/videoInfo?video=" + video
      })
    },

  goToNextPage:function(e){
    var myWorkFalg = this.data.myWorkFalg;
    var myLikesFalg = this.data.myLikesFalg;
    var myFollowFalg = this.data.myFollowFalg;

    if (!myWorkFalg) {
      var currentPage = this.data.myVideoPage;
      var totalPage = this.data.myVideoTotal;
      // 获取总页数进行判断，如果当前页数和总页数相等，则不分页
      if (currentPage === totalPage) {
        wx.showToast({
          title: '已经没有视频啦...',
          icon: "none"
        });
        return;
      }
      var page = currentPage + 1;
      this.getMyVideoList(page);
    } else if (!myLikesFalg) {
      var currentPage = this.data.likeVideoPage;
      var totalPage = this.data.likeVideoTotal;
      // 获取总页数进行判断，如果当前页数和总页数相等，则不分页
      if (currentPage === totalPage) {
        wx.showToast({
          title: '已经没有视频啦...',
          icon: "none"
        });
        return;
      }
      var page = currentPage + 1;
      this.getLikeVideoList(page);
    } else if (!myFollowFalg) {
      var currentPage = this.data.followVideoPage;
      var totalPage = this.data.followVideoTotal;
      // 获取总页数进行判断，如果当前页数和总页数相等，则不分页
      if (currentPage === totalPage) {
        wx.showToast({
          title: '已经没有视频啦...',
          icon: "none"
        });
        return;
      }
      var page = currentPage + 1;
      this.getMyFollowList(page);
    }

  },

  //上传视频
  upLoadVedio:app.uploadVideo,

  select: app.select

})



