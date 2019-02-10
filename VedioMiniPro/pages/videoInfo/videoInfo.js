//index.js
//获取应用实例
const app = getApp();

Page({
  data: {
    serverUrl:"",
    videoFit: "cover",
    videoUrl: "",
    videoDesc:"",
    faceIconUrl:"",
    nickname:"",
    videoID:"",
    userID:"",
    userLikeVideo:false,
    commentFocus:false,
    contentValue:"",
    commentsList:[],
    commentsPage:1,
    placeholder:"说点什么吧",
    commentsTotalPage:1

  },
  
  onLoad: function (params) {
    var that = this;
    var videoObject = JSON.parse(params.video);

    this.setData({
      serverUrl:app.serverUrl,
      videoUrl:app.serverUrl + videoObject.videoPath,
      videoDesc:videoObject.videoDesc,
      faceIconUrl:app.serverUrl + videoObject.faceImage,
      nickname:videoObject.nickname,
      videoID:videoObject.id,
      userID:videoObject.userId
    });

    if(app.getGlobalUser()){
      wx.request({
        url: app.serverUrl + "/video/getLikeStatus?userID="+app.getGlobalUser().id+"&videoID="+videoObject.id,
        method: "GET",
        success : function(res){
          that.setData({
           userLikeVideo: res.data.data
          })
        }
      }); 
    }

    this.getComments(1);
  },

  onShareAppMessage:function(res){
  
  },

  showSearch: function(){
      wx.navigateTo({
        url: "/pages/searchView/searchView"
      })
  },

  showIndex:function(){
      wx.reLaunch({
        url: "/pages/index/index"
      });
  },

  showMine:function(){
    var that = this;
    if(app.getGlobalUser()){
      wx.navigateTo({
        url:"/pages/mine/mine"
      })
    }else{
      wx.navigateTo({
        url:"/pages/login/login"
      })
    }
  },

  likeVideoOrNot:function(){
    var that = this;
    var loginUser = app.getGlobalUser();
    var setLikeStatus = !(this.data.userLikeVideo);
    var videoID = this.data.videoID;
    var userID = "";
    var userToken = "";
    if(null != loginUser){
      userID = loginUser.id;
      userToken = loginUser.userToken;
    }
     wx.request({
        url: app.serverUrl + "/video/likeVideo?userID=" + userID + "&videoID=" + videoID + "&isLike="+ setLikeStatus,
        method: "POST", 
        header:{
            userID: userID,
            userToken: userToken
        },
        success : function(res){
          if(200 == res.data.status){
            that.setData({
             userLikeVideo:setLikeStatus
            });
          }else{
            wx.navigateTo({
              url:"/pages/login/login"
            })
          }
        }
      })
  },

  showPublisher:function(){
      wx.navigateTo({
        url : '../mine/mine?userID=' + this.data.userID
      })   
  
  },

  goComment:function(){
      this.setData({
        commentFocus:true
      })
  },

  saveComment:function(e){
    var that = this;
    var content = e.detail.value;
    var fatherCommentId = e.currentTarget.dataset.replyfathercommentid;
    var toUserId = e.currentTarget.dataset.replytouserid;
    var loginUser = app.getGlobalUser();
    wx.request({
       url: app.serverUrl + "/video/commentVideo",
        method: "POST", 
        header:{
            userID: loginUser.id,
            userToken: loginUser.userToken
        },
        data:{
            comment: content,
            fatherCommentId: fatherCommentId,
            fromUserId: this.data.userID,
            toUserId: toUserId,
            videoId: this.data.videoID
        },
        success : function(res){
          if(200 == res.data.status){
            that.setData({
              contentValue:"",
              commentsList:[]
            });
            that.getComments(1);
          }else if(502 == res.data.status){
            wx.navigateTo({
              url:"/pages/login/login"
            })
          }else{
          }
        }
  })
  },

  getComments:function(page){
    var that = this;
    var videoID = this.data.videoID;
    wx.request({
      url: app.serverUrl + "/video/queryComments?videoID=" + videoID + "&page=" + page,
        method: "GET", 
        success : function(res){
          console.log(res);
          if(200 == res.data.status){
            var lastList = that.data.commentsList;
            var newlist = lastList.concat(res.data.data.comments);
            that.setData({
              commentsPage:res.data.data.page.currentPage,
              commentsTotalPage:res.data.data.page.totalPage,
              commentsList: newlist
            })
          }else if(502 == res.data.status){
            wx.navigateTo({
              url:"/pages/login/login"
            })
          }else{
  
          }
        }
    })

  },

   replyFocus: function(e) {
    console.log(e);
    var fatherCommentId = e.currentTarget.dataset.fathercommentid;
    var toUserId = e.currentTarget.dataset.touserid;
    var toNickname = e.currentTarget.dataset.tonickname;
 
    this.setData({
      placeholder: "回复  " + toNickname,
      replyFatherCommentId: fatherCommentId,
      replyToUserId: toUserId,
      commentFocus: true
    });
  },

 onReachBottom: function() {
    var currentPage = this.data.commentsPage;
    var totalPage = this.data.commentsTotalPage;
    if (currentPage === totalPage) {
      return;
    }
    var page = currentPage + 1;
    this.getComments(page);
  },


  uploadVideo : app.uploadVideo
})
