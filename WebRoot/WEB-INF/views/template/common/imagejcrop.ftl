<link href="${contextPath}/image/jquery.Jcrop.css" type="text/css" rel="stylesheet" />
<script src="${contextPath}/image/jquery.Jcrop.js" type="text/javascript"></script>
<script type="text/javascript">
   
   $(function(){ 
	    setTimeout(function(){
			 $(".jcrop-tracker").next().next().show();
			 
			 $("#imageSrc").Jcrop({ 
			    aspectRatio : 1.56,  
				onChange:showCoords, //当选择区域变化的时候，执行对应的回调函数 
				onSelect:showCoords, //当选中区域的时候，执行对应的回调函数
			   // minSize :[172,110],
			    setSelect: [0,0,320,205]
		       }); 
		       
		       var imgSrc = $("#imageSrc").attr("src");
			   $("#preview01").attr("src",imgSrc);
			   $("#preview02").attr("src",imgSrc);
			   $("#preview03").attr("src",imgSrc);
		   
		},300)
	 
   }); 
   
   function showCoords(coords) { 
   if (parseInt(coords.w) > 0) {
			   //计算预览区域图片缩放的比例，通过计算显示区域的宽度(与高度)与剪裁的宽度(与高度)之比得到  
			    var rx1 = $("#preview_box1").width() / coords.w;  
                var ry1 = $("#preview_box1").height() / coords.h;  
                var rx2 = $("#preview_box2").width() / coords.w;  
                var ry2 = $("#preview_box2").height() / coords.h;  
                var rx3 = $("#preview_box3").width() / coords.w;  
               	var ry3 = $("#preview_box3").height() / coords.h;  
                //通过比例值控制图片的样式与显示  
                $("#preview01").css( {  
                    width : Math.round(rx1 * $("#imageSrc").width()) + "px", //预览图片宽度为计算比例值与原图片宽度的乘积  
                    height : Math.round(rx1 * $("#imageSrc").height()) + "px", //预览图片高度为计算比例值与原图片高度的乘积  
                    marginLeft : "-" + Math.round(rx1 * coords.x) + "px",  
                    marginTop : "-" + Math.round(ry1 * coords.y) + "px"  
                });  
                 $("#preview02").css( {  
                    width : Math.round(rx2 * $("#imageSrc").width()) + "px", //预览图片宽度为计算比例值与原图片宽度的乘积  
                    height : Math.round(rx2 * $("#imageSrc").height()) + "px", //预览图片高度为计算比例值与原图片高度的乘积  
                    marginLeft : "-" + Math.round(rx2 * coords.x) + "px",  
                    marginTop : "-" + Math.round(ry2 * coords.y) + "px"  
                });  
                 $("#preview03").css( {  
                    width : Math.round(rx3 * $("#imageSrc").width()) + "px", //预览图片宽度为计算比例值与原图片宽度的乘积  
                    height : Math.round(rx3 * $("#imageSrc").height()) + "px", //预览图片高度为计算比例值与原图片高度的乘积  
                    marginLeft : "-" + Math.round(rx3 * coords.x) + "px",  
                    marginTop : "-" + Math.round(ry3 * coords.y) + "px"  
                });  
		}
		 
		    $('#image_x').val(coords.x);  
		    $('#image_y').val(coords.y);  
		    $('#image_w').val(coords.w);  
		    $('#image_h').val(coords.h);
  }
</script>  