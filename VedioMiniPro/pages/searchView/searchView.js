//index.js
//获取应用实例
const app = getApp();

const template = require('../template/template.js');

Page({
  data: {
    hotWords: ["java","redis","springboot","小程序"],
    tipWords: [],
    history: [],
    view: {
      barHeight: 45,
      seachHeight: 0
    },
  	value:""
  },
  
  onLoad: function () {
  	this.initSearch();
    getHistory(this);

  },

  initSearch: function(){
    var that = this;
     wx.getSystemInfo({
      success: function (res) {
        var wHeight = res.windowHeight;
        var barView = that.data.view;
        var seachHeight = wHeight - barView.barHeight;
        barView.seachHeight = seachHeight;
        that.setData({
          view: barView
        });
      }
    });
     wx.request({
      url : app.serverUrl + "/video/queryHotWord",
      method: "GET",
      success : function(res){
         that.setData({
          hotWords: res.data.data,
        });
      }
     })
  },

  //输入文本框
  searchInput: function(e){
    var that = this;
    var inputValue = e.detail.value;
    var keycode = e.detail.keyCode;
     wx.request({
      url : app.serverUrl + "/video/queryTipWord?content="+inputValue,
      method: "GET",
      success : function(res){
         that.setData({
          tipWords: res.data.data,
        });
      }
     })
    this.setData({
      value: inputValue
    })
  },

  clearInput: function(){
      this.setData({
      value: "",
      tipWords:""
    })
  },

  beginSearch: function(e){
    var that = this;
    var inputValue = that.data.value;
     if((!inputValue) || (0 == inputValue.length)){
        return;
      }

    that.addHistory(inputValue);

    wx.reLaunch({
      url:"/pages/index/index?search=" + inputValue
    })
  },

  addHistory: function(inputValue){
      if((!inputValue) || (0 == inputValue.length)){
        return;
      }

      var that = this;
      var history = wx.getStorageSync('searchHis');

      if(history){
        if(-1 == history.indexOf(inputValue)){
          history.unshift(inputValue);
        }

         wx.setStorage({
          key: "searchHis",
          data: history,
          success: function () {
            getHistory(that);
          }
        })
      }else{
         history = [];
         history.unshift(inputValue);
         wx.setStorage({
          key: "searchHis",
          data: history,
          success: function () {
            getHistory(that);
          }
       })
    }
  },

  searchKeyTap:function(e){
     var that = this;
     var inputValue = e.target.dataset.key;
     if((!inputValue) || (0 == inputValue.length)){
        return;
      }

    that.addHistory(inputValue);

    wx.reLaunch({
      url:"/pages/index/index?search=" + inputValue
    })


  },

  clearHistory: function(){
    var that = this;
    wx.setStorage({
      key: "searchHis",
      success:function(){
        that.setData({
          history:[]
        })
      }
    });
  },

});




// 读取缓存的历史纪录
function getHistory(that) {
  var history = [];
  try {
    history = wx.getStorageSync('searchHis')
    if (history) {
      that.setData({
        history: history
      });
    }
  } catch (e) {
  }
}
