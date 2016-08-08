 <script type="text/javascript">
	 function tip_show(operating, text){
		$(".elastic_layer").css("display", "block");
		$("#erroCode").val('');
		if(operating == "y"){
			$(".show_tip_infor").css("background-image", "url(../../css/images/savesuccess.png)");
		}else if(operating == "n"){
			$(".show_tip_infor").css("background-image", "url(../../css/images/saveWrong.png)");
		}else if(operating == "w"){
			$(".show_tip_infor").css("background-image", "url(../../css/images/saveWait.gif)");
		}else{
			$(".show_tip_infor").css("background-image", "url(../../css/images/savesuccess.png)");
		}
		$("#erroCode").val(operating);
		$(".tip_text").text(text);
	}
	function tip_hide_w(){
		$(".elastic_layer").css("display", "none");
	}

   $(function(){ 
     $("#imagehidden").html("");
	 $('#image_x').val("");  
	 $('#image_y').val("");  
	 $('#image_w').val("");  
	 $('#image_h').val("");
     var imgSrcType = '${(imgSrc)}';
     if(typeof(imgSrcType) == "undefined" || imgSrcType == null || imgSrcType == ""){
    
     }else{
       $("#imagehidden").load("${contextPath}/common/imagejcrop.do?navTabId=${(navTabId)!}");
       $("#imageSrc").attr('src','${(imgSrc)}');
       $("#preview01").attr("src",'${(imgSrc)}');
	   $("#preview02").attr("src",'${(imgSrc)}');
	   $("#preview03").attr("src",'${(imgSrc)}');
     }
   }); 
   
    function svaeImg(){ 
	       if($("#imageSrc").attr("src") == "../../css/images/no_pic.png"){
	         alert("请上传图片");
	         return;
	       }
	       
	         
            var x = jQuery("#image_x").val();  
            var y = jQuery("#image_y").val();  
            var w = jQuery("#image_w").val();  
            var h = jQuery("#image_h").val();           
              
            if(w == 0 || h == 0 || x <0 || y<0 ){  
                alert("图片的剪切区域不对,不能进行剪切图片!");  
                return;  
            }     
            if(confirm("确定按照当前大小剪切图片吗")){                 
              // $("#imgForm").submit();
              tip_show('w', "图片保存中...");
              var obj = {
                    "imageX":$("#image_x").val(),
                    "imageY":$("#image_y").val(),
                    "imageW":$("#image_w").val(),
                    "imageH":$("#image_h").val(),
                    "imageIdshow":"${(imageIdshow)}",
                    "imageSrcshow":"${(imageSrcshow)}",
                    "oldImgPath":$("#imgUploadPath").val()
              };
              $.ajax({
    			url : '${contextPath}/common/saveimage.do?navTabId=${(navTabId)!}',
    			type : 'POST',
    			async : false,
    			dataType : "json",
    			async : false,
    			data : obj,
    			success : function(data) {
    			        $("#"+data.imageIdshow+"").val(data.imageId);
    				    $("#"+data.imageSrcshow+"").attr('src','${contextPath}/upload/640_'+data.imageId);
    				    $("#pageContent").show();
  						$("#imageload").hide();
						tip_hide_w(); 
    				}
        	    });
        	}  
         }
         
         function cancleImg(){
             $("#pageContent").show();
      		 $("#imageload").html("").hide();
         }
</script>  
	
<@i.uploadjcrop true,'productImg'/>
<div class="cont_right_new">
		<div class="cont_left_inLeft">
			<span class="reviewPic">
	        	<div id="preview_fake" class="pic"><img id="imageSrc" width="455" height="291"></div>
	        </span>
	        <div class="new_area_putImg">
	        	<a class="file_update_area n_addPaddingRight" style="float:left">
					<div class="updateLayer"><span id="spanButtonPlaceholder"  onmousedown ="clearId(this)"></span><input id="btnCancel" type="button" value="取消上传" onclick="cancelQueue(upload1);" disabled="disabled" style="margin-left: 2px; height: 22px; font-size: 8pt; display:none" /></div>
				</a>
				<a id="cropButton" onclick="svaeImg()" class="new_btn_saveThis">保存</a>
				<a id="cropButton" onclick="cancleImg()" class="new_btn_cancleThis">取消</a>
			</div>
		</div>
        <div class="cont_right_inRight">
        	<b class="new_tip_updateImg">您上传的图片将会自动生成三种尺寸，请注意小尺寸图片是否清晰。</b>
        	<div class="new_preBoxTop">
        		<div id="preview_box1">  
				    <img id="preview01" src="" width="290px"/>  
				</div>  
				<p class="tip_updataImgFont">  
				    生成640*410的图片
				</p>
        	</div>
        	<div class="new_preBoxBottom">
        		<div class="new_preBoxB_left">
        			<div id="preview_box2">  
					    <img id="preview02" src="" width="232px"/>  
					</div>
					<p class="tip_updataImgFont">
					    生成232*148的图片
					</p> 
        		</div>
        		<div class="new_preBoxB_right">
        			<div id="preview_box3">  
					    <img id="preview03" src="" width="172px"/>  
					</div>
					<p class="tip_updataImgFont">
					    生成172*110的图片
					</p>
        		</div>
        	</div>
		</div>
		<div class="hidden_thisDiv">
	      <form action="${contextPath}/common/saveimage.do" name="clipForm" id="imgForm">
			<input name="imageX" id="image_x"/>
			<input name="imageY" id="image_y"/>
			<input name="imageW" id="image_w"/>
			<input name="imageH" id="image_h"/>
			<input name="oldImgPath" id="imgUploadPath" value="${oldImgPath}"/>
		  </form>        
	    </div>
<div  id="imagehidden"> </div>
</div>
