//index.js
//获取应用实例
const app = getApp();

const template = require('../template/template.js');

Page({
  data: {
  	totalPage : 1,
  	correntPage : 1,
  	videos : [],
  	screenWidth: 350,
  	serverUrl : app.serverUrl,
  	searchContent : ""
  },
  
  onLoad: function (params) {
  	var that = this;
  	template.buildBar('tabbar', 0, this);
  	if(null != params.search && "" != params.search && undefined != params.search){
  		that.setData({
  			searchContent: params.search
  		});
  	}
  	wx.getSystemInfo({
		success(res) {
			that.setData({
				screenWidth : res.windowWidth,
			})
		}
	})
  	this.getAllVideos(1);
  	
  },

  getAllVideos: function(page){
  	 var that = this;
  	 var serverUrl = app.serverUrl + "/video/queryAll?page=" + page;
  	if(null != that.data.searchContent && "" != that.data.searchContent && undefined != that.data.searchContent){
  		serverUrl += "&searchWord=" + that.data.searchContent;
  	}
	 wx.showNavigationBarLoading();
  	 wx.request({
  		url : serverUrl,
  		method: "GET",
  		success : function(res){
        var oldvideos = that.data.videos;
        var newvideos = res.data.data.videos;
        var newlist = oldvideos.concat(newvideos);
        wx.hideNavigationBarLoading();
  			 that.setData({
		      videos: newlist,
		      correntPage:  res.data.data.page.currentPage,
		      totalPage: res.data.data.page.totalPage,
		      serverUrl: app.serverUrl
		    });
  			if(null == res.data.data.videos || 0 == res.data.data.videos.length){
  				wx.showToast({
  					title:"没有找到相关的视频！~",
  					icon:"none"
  				})
  			}
  		}
  	})

  },

  onPullDownRefresh: function() {
    wx.showNavigationBarLoading();
    this.getAllVideos(1);
  },

  gotoNextPage:function() {
  	var correntPage = this.data.correntPage ;
  	var totalPage = this.data.totalPage;

  	if(correntPage == totalPage){
  		wx.showToast({
	  		title: '已经没有视频啦~~',
	        icon: "none"
  		})
  	}else{
  		this.getAllVideos(correntPage + 1);
  	}

  },

  gotoSearch: function(){
  	wx.navigateTo({
  		url:"/pages/searchView/searchView"
  	})
  },

  showVideoInfo: function(e){
  	var videoIdx =  e.target.dataset.arrindex;
  	var video = JSON.stringify(this.data.videos[videoIdx]);
  	wx.navigateTo({
  		url:"/pages/videoInfo/videoInfo?video=" + video
  	})
  },

  select: app.select
})
