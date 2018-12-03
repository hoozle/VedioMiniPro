//index.js
//获取应用实例
const app = getApp()

Page({
  data: {
   
  },

  doRegister: function(e){
      var formObj = e.detail;
      var username = formObj.username;
      var password = formObj.password;
      
      if(0 == username.length || 0 == password.length)
      {
        wx.showToast({
          title: '用户名或密码不能为空！',
          duration: 3000
        });        
      }else{
        var ServiceUrl = app.ServiceUrl;
        wx.showLoading({
          title: '请稍等！',
        })
        wx.request({
          url: ServiceUrl + '/register',
          method:POST,
          dataType:JSON,
          header:{
            'content-type': 'application/json',
          },
          data:{
            username: username,
            password: password
          },
          success: function(res){

          },

        })
      }

  },

  goLoginPage: function () {
    wx.navigateTo({
      url: '../login/login',
    })
  }
 
})
