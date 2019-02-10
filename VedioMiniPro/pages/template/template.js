//template.js
//获取应用实例
//初始化数据
function tabbarinit() {
  return [
    {
      "isSelected": false,
      "iconPath": "/pages/resource/images/home_icon.png",
      "text": "首页"
    },
    {
      "isSelected": false,
      "iconPath": "/pages/resource/images/upload_icon.png",
      "text": ""
    },
    {
      "isSelected": false,
      "iconPath": "/pages/resource/images/my_icon.png",
      "text": "我的"  
    },
  ]
}

function tabbarMain(bindName = 'tarbar', idx, target){
	if(null == target){
		return ;
	}

	if(idx < 0 || idx > 2 ||null == idx || undefined == idx){
		idx = 0;
	}

	var that = target;
	var bindData = {};
	var tabbarObj = tabbarinit();

	tabbarObj[idx]['isSelected'] = true;
	bindData[bindName] = tabbarObj;
	that.setData({bindData}); 
}

module.exports = {
	buildBar : tabbarMain
}
