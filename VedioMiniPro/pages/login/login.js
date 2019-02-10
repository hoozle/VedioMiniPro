//index.js
//获取应用实例
const app = getApp()

Page({
  data: {
   
  },

  doLogin: function(e){
  	var formObj = e.detail;
  	var username = formObj.value.username;
  	var password = formObj.value.password;
  	if(0 == username.length || 0 == password.length)
      {
        wx.showToast({
          title: '用户名或密码不能为空！',
          icon: 'none',
          duration: 2000
        });        
      }else{
        var serviceUrl = app.serverUrl + '/login';
        wx.showLoading({
          title: '请稍等！',
        })
        wx.request({
          url: serviceUrl,
          method: "POST",
          dataType: "json",
          header: {
            'content-type': 'application/json',
          },
          data: {
            username: username,
            password: password
          },
          success: function(res){
            wx.hideLoading();
            if(res.data.status == 200){
            	app.setGlobalUser(res.data.data);
  	        	wx.navigateTo({
  	        		url : '../mine/mine'
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
      }

  },

  goRegisterPage: function() {
    wx.navigateTo({
      url: '../register/register',
    })
  },
 


 
})
