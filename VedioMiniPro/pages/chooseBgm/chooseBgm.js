const app = getApp()

Page({
    data: {
      bgmList: [],
      serverUrl: "",
      videoParams: {}
    },

    onLoad:function(params){
      var that = this;  
      that.setData({
        videoParams : params
      });
      console.log(params);
      wx.request({
         url: app.serverUrl + "/bgm/list",
          method: "GET",
          success: function(res){
            wx.hideLoading();
            if(200 == res.data.status){
              that.setData({
                bgmList : res.data.data,
                serverUrl : app.serverUrl
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

    upload:function(e){

      var that = this;
      var bgmID = e.detail.value.bgmId;
      var userID = app.getGlobalUser().id;
      var userToken = app.getGlobalUser().userToken;
      var desc = e.detail.value.desc;
      var videoFilePath = this.data.videoParams.tempFilePath;
      var videoHeight = this.data.videoParams.height;
      var videoWidth = this.data.videoParams.width;
      var videoSeconds = this.data.videoParams.duration;

      wx.showLoading({
        title:"上传中"
      });

      wx.uploadFile({
        url:app.serverUrl+"/video/upload",
        filePath:videoFilePath,
        name:'videoFile',
        header:{
          userID:userID,
          userToken:userToken
        },
        formData:{
          bgmID:bgmID,
          userID:userID,
          desc:desc,
          videoSeconds:videoSeconds,
          videoHeight:videoHeight,
          videoWidth:videoWidth,
        },
        success:function(res){
          wx.hideLoading();
          wx.reLaunch({
              url: "/pages/index/index"
            });
        }
       
      })

    }

})

