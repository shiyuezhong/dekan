// 获取参数
function getUrlParam(name) {
	var regex = new RegExp("[?&]" + encodeURIComponent(name) + "\\=([^&#]+)");
	var value = (location.search.match(regex) || [ "", "" ])[1];
	return decodeURIComponent(value);
}

function getUrlParamUrl(name) {
	var regex = new RegExp("[?&]" + encodeURIComponent(name)+ "\\=([^#]+)");
	var value = (location.search.match(regex) || [ "", "" ])[1];
	return decodeURIComponent(value);
}
Date.prototype.format = function(format) {
	/*
	 * format="yyyy-MM-dd hh:mm:ss";
	 */
	var o = {
		"M+" : this.getMonth() + 1,
		"d+" : this.getDate(),
		"h+" : this.getHours(),
		"m+" : this.getMinutes(),
		"s+" : this.getSeconds(),
		"q+" : Math.floor((this.getMonth() + 3) / 3),
		"S" : this.getMilliseconds()
	};
	if (/(y+)/.test(format)) {
			format = format.replace(RegExp.$1, (this.getFullYear() + "").substr(4- RegExp.$1.length));
		}
	for (var k in o) {
		if (new RegExp("(" + k + ")").test(format)){
			format = format.replace(RegExp.$1, RegExp.$1.length == 1? o[k]:("00" + o[k]).substr(("" + o[k]).length));
		}
	}
	return format;
	
};
//转化JSON日期格式
function toDate(objDate, format) {
	var date = new Date();

	date.setTime(objDate.time);

	date.setHours(objDate.hours);

	date.setMinutes(objDate.minutes);

	date.setSeconds(objDate.seconds);

	return date.format(format);
}

function setWeChatCode(){
	if(getUrlParam('weChatId') != undefined && getUrlParam('weChatId') != null && getUrlParam('weChatId') != ""){
		addCookie('weChatId',getUrlParam('weChatId'),1);
	}
}


function bubbleAlert(){
	$("body").append("<div class='bubbleAlert' style='display:block;'><div class='loadBg'></div><div class='loadPic'>正在加载</div></div>");
}
function disappearAlert(){
	$(".bubbleAlert").hide();
}