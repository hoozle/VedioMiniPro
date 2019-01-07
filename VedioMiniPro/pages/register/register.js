//index.js
//获取应用实例
const app = getApp()

Page({
  data: {
   
  },

  doRegister: function(e){
      var formObj = e.detail;
      var username = formObj.value.username;
      var password = formObj.value.password;
      var goLoginFun = this.goLoginPage;
      if(0 == username.length || 0 == password.length)
      {
        wx.showToast({
          title: '用户名或密码不能为空！',
          icon: 'none',
          duration: 2000
        });        
      }else{
        var ServiceUrl = app.serverUrl + '/register';
        wx.showLoading({
          title: '请稍等！',
        })
        wx.request({
          url: ServiceUrl,
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
            if(res.data.status == 200)
            {
               wx.showToast({
                  title: '注册成功！',
                  icon: "success",
                  duration: 3000
                });
                setTimeout(goLoginFun, 3000);     
            }else{
                wx.showToast({
                  title: res.data.msg,
                  icon: "none",
                  duration: 2000
                });

            }
          },

        })
      }

  },

  goLoginPage: function() {
    wx.navigateTo({
      url: '../login/login',
    })
  },
 
})
