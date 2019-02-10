//app.js
const template = require('/pages/template/template.js');

App({
  serverUrl: "http://192.168.0.101:8080",
  globalData: {
    userInfo: null
  },

  setGlobalUser(userInfo){
    wx.setStorageSync("userInfo",userInfo);
  },

  getGlobalUser(){
     return wx.getStorageSync('userInfo');
  },

  select: function(e){
  	if(e.currentTarget.id == "mytab-0"){
    		wx.navigateTo({
  			url : "/pages/index/index"
  		});
  	}else if(e.currentTarget.id == "mytab-1"){
       this.uploadVideo();
  	}else if(e.currentTarget.id == "mytab-2"){
      if(this.getGlobalUser()){
  			wx.navigateTo({
  				url : "/pages/mine/mine"
  			});
      }else{
        wx.navigateTo({
          url : "/pages/login/login"
        });
      }
    }
  },

  uploadVideo:function(){
    var obj = this.getGlobalUser();

    if(!(this.getGlobalUser())){
      wx.navigateTo({
        url : "/pages/login/login"
      });
    }else{
        wx.chooseVideo({
        sourceType: ['album', 'camera'],
        maxDuration: 15,
        camera: 'back',
        success(res) {
          wx.navigateTo({
          url: '../chooseBgm/chooseBgm?tempFilePath='+res.tempFilePath+'&duration='+res.duration
          +"&height="+res.height+"&width="+res.width
        })
        }
      })
    }
  }

})