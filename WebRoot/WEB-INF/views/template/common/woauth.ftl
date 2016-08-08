<!DOCTYPE html PUBLIC "-//WAPFORUM//DTD XHTML Mobile 1.0//EN" "http://www.wapforum.org/DTD/xhtml-mobile10.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="Cache-control" />
    <meta name="format-detection" content="telephone=no" />
    <meta content="yes" name="apple-mobile-web-app-capable" />
    <meta content="black" name="apple-mobile-web-app-status-bar-style" />
    <meta content="telephone=no" name="format-detection" />
    <meta name="viewport" content="width=device-width; maximum-scale=1.0;  user-scalable=no; initial-scale=1.0" />
    <title>加载中</title>
    <script type="text/javascript" src="${contextPath}/js/jquery-1.7.2.min.js"></script>
</head>
<body>
	<script type="text/javascript">
	  $(function() {  
	    var url = "${redirectUrl}"; 
       	 if(url == "" || url == null || url == "undefined" || typeof(url) == "undefined"){
		      alert("地址错误,请核实");
		 }else{
		      if((url.indexOf("http://")>=0) || (url.indexOf("https://")>=0)){
		      	window.location.href=url;
			  }else{
			  	alert("地址格式错误");
			  }
		 }    
     }); 
	</script>
</body>
</html>
