//index.js
//获取应用实例
const app = getApp()

Page({
  data: {
    isMe : true,
    iconUrl: "../resource/images/noneface.jpg",
    videoSelClass: "video-info",
    isSelectedWork: "video-info-selected"
  },

  //注销
  logout:function(){
    var serviceUrl = app.serverUrl + "/logout?userID=" + app.globalData.userInfo.id;
    wx.showLoading({
          title: '请稍等！',
        })
    wx.request({
          url: serviceUrl,
          method: "POST",
          success: function(res){
            wx.hideLoading();
            if(200 == res.data.status){
            	app.globalData.userInfo = null;
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

        })
  },

  //更换头像
  changeFace:function(){
  	var that = this;
  	console.log("changeFace");
  	wx.chooseImage({
	  count: 1,
	  sizeType: ['compressed'],
	  sourceType: ['album', 'camera'],
	  success(res) {
	    // tempFilePath可以作为img标签的src属性显示图片
	  const tempFilePaths = res.tempFilePaths;
	  var serverUrl = app.serverUrl + "/uploadFace?userID=" + app.globalData.userInfo.id;
	  console.log(serverUrl);
	  wx.showLoading({
	  	title:"上传中..."
	  });

	  wx.uploadFile({
	      url: serverUrl, 
	      filePath: tempFilePaths[0],
	      name: 'file',
	      formData: {
	        user: 'test'
	      },
	      success(res) {
	      	console.log(res);
	      	wx.hideLoading();
	        var data = JSON.parse(res.data);
	        if(200 == data.status){
	        	wx.showToast({
	        		title : "上传成功",
	        		icon : "success"
	        	});
	        	console.log(data.data);
	        	//直接赋值无法改变页面的状态，需调用微信官方的setData将数据从逻辑层发送到视图层（异步），同时改变对应的 this.data 的值（同步）
	        	that.setData({
		        	iconUrl : app.serverUrl + data.data
	        	});
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
  }
})
