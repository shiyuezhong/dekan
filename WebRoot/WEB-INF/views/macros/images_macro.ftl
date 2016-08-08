<#macro upload isFlag , imageId>
  <#assign contextPath="${request.getContextPath()}"> 
	<script type="text/javascript" src="${contextPath}/common/ajaxfileupload.js"></script>
	<script type="text/javascript" src="${contextPath}/common/uploadswf/swfuploadIcon.js"></script>
	<script type="text/javascript" src="${contextPath}/common/uploadswf/swfupload.queue.js"></script>
	<script type="text/javascript" src="${contextPath}/common/uploadswf/fileprogress.js"></script>
	<script type="text/javascript" src="${contextPath}/common/uploadswf/handlers.js"></script> 
 <script type="text/javascript">  
    var swfupload;
	$(function() {
			swfupload = new SWFUpload({
				// Backend Settings
				use_query_string:true,
				upload_url: "${contextPath}/common/imageuploads.do",
				file_post_name: "file",
			    post_params: {},
			
				// File Upload Settings
				file_size_limit : "500KB",	// 5MB
				file_types : "*.jpg;*.gif;*.png;*.bmp",
				file_types_description : "All Files",
				file_upload_limit : "200",
				file_queue_limit : "200",

				// Event Handler Settings (all my handlers are in the Handler.js file)
				file_dialog_start_handler : fileDialogStart,
			 	//file_queued_handler : fileQueued,
				file_queue_error_handler : fileQueueError,
				file_dialog_complete_handler : fileDialogComplete,
				//上传进度条
				// upload_start_handler : uploadStart,
				// upload_progress_handler : uploadProgress,
				upload_error_handler : uploadError,
				upload_success_handler : myUploadSuccess,
				upload_complete_handler : uploadComplete,

				// Button Settings
				button_image_url : "${contextPath}/common/uploadswf/XPButtonUploadText_61x22.png",
				button_placeholder_id : "spanButtonPlaceholder",
				button_width: 61,
				button_height: 22,
				button_text:"选择图片",
				button_text_left_padding:5,
				
				// Flash Settings
				flash_url : "${contextPath}/common/uploadswf/swfupload.swf",

				custom_settings : {
					progressTarget : "fsUploadProgress",
					cancelButtonId : "btnCancel"
				},
				// Debug Settings
				debug: false
			});
		

		function myUploadSuccess(file, serverData) {
		 try {
				var jsonData = eval("("+serverData+")");
				<#if isFlag>
				$("#${imageId}").val(jsonData.fileName);
				$("#imageSrc").attr('src','${contextPath}/upload/'+jsonData.fileName);
				<#else>
				$("#${imageId}").val(jsonData.fileName);
				</#if>
				$("#imageSrcDiv").show();
				$(".imgShowUpdateAf").show();
				
				var progress = new FileProgress(file, this.customSettings.progressTarget);
				progress.setComplete();
				progress.toggleCancel(true,this);
			} catch (ex) {
				this.debug(ex);
			}
		}
	});  
    </script>
</#macro>



<#macro uploadImg isFlag,imageId,index>
 <script type="text/javascript">   
    var swfupload;
	$(function() {
			swfupload = new SWFUpload({
				// Backend Settings
				use_query_string:true,
				upload_url: "${contextPath}/common/imageuploads.do",
				file_post_name: "file",
			    post_params: {},
			
				// File Upload Settings
				file_size_limit : "500KB",	// 5MB
				file_types : "*.jpg;*.gif;*.png;*.bmp",
				file_types_description : "All Files",
				file_upload_limit : "200",
				file_queue_limit : "200",

				// Event Handler Settings (all my handlers are in the Handler.js file)
				file_dialog_start_handler : fileDialogStart,
			 	//file_queued_handler : fileQueued,
				file_queue_error_handler : fileQueueError,
				file_dialog_complete_handler : fileDialogComplete,
				//上传进度条
				// upload_start_handler : uploadStart,
				// upload_progress_handler : uploadProgress,
				upload_error_handler : uploadError,
				upload_success_handler : myUploadSuccess,
				upload_complete_handler : uploadComplete,

				// Button Settings
				button_image_url : "${contextPath}/common/uploadswf/XPButtonUploadText_61x22.png",
				button_placeholder_id : "spanButtonPlaceholder${index}",
				button_width: 61,
				button_height: 22,
				button_text:"选择图片",
				button_text_left_padding:5,
				
				// Flash Settings
				flash_url : "${contextPath}/common/uploadswf/swfupload.swf",

				custom_settings : {
					progressTarget : "fsUploadProgress",
					cancelButtonId : "btnCancel${index}"
				},
				// Debug Settings
				debug: false
			});
		

		function myUploadSuccess(file, serverData) {
		 try {
				var jsonData = eval("("+serverData+")");
				<#if isFlag>
				$("#pimgUrls${index}").val(jsonData.fileName);
				$("#${imageId}${index}").attr('src','${contextPath}/upload/'+jsonData.fileName);
				<#else>
				$("#${imageId}${index}").val(jsonData.fileName);
				</#if>
				$(".imgShowUpdateAf").show();
				var progress = new FileProgress(file, this.customSettings.progressTarget);
				progress.setComplete();
				
				progress.toggleCancel(true,this);
				
			} catch (ex) {
				this.debug(ex);
			}
		}
		
	});  
    </script>
</#macro>



<#macro uploadjcrop isFlag , imageId>
  <#assign contextPath="${request.getContextPath()}"> 
	<script type="text/javascript" src="${contextPath}/common/ajaxfileupload.js"></script>
	<script type="text/javascript" src="${contextPath}/common/uploadswf/swfuploadIcon.js"></script>
	<script type="text/javascript" src="${contextPath}/common/uploadswf/swfupload.queue.js"></script>
	<script type="text/javascript" src="${contextPath}/common/uploadswf/fileprogress.js"></script>
	<script type="text/javascript" src="${contextPath}/common/uploadswf/handlers.js"></script> 
	
 <script type="text/javascript">  
    var swfupload;
	$(function() {
			swfupload = new SWFUpload({
				// Backend Settings
				use_query_string:true,
				upload_url: "${contextPath}/common/imageuploads.do",
				file_post_name: "file",
			    post_params: {},
			
				// File Upload Settings
				file_size_limit : "500KB",	// 5MB
				file_types : "*.jpg;*.png;*.bmp",
				file_types_description : "All Files",
				file_upload_limit : "200",
				file_queue_limit : "200",

				// Event Handler Settings (all my handlers are in the Handler.js file)
				file_dialog_start_handler : fileDialogStart,
			 	//file_queued_handler : fileQueued,
				file_queue_error_handler : fileQueueError,
				file_dialog_complete_handler : fileDialogComplete,
				//上传进度条
				// upload_start_handler : uploadStart,
				// upload_progress_handler : uploadProgress,
				upload_error_handler : uploadError,
				upload_success_handler : myUploadSuccess,
				upload_complete_handler : uploadComplete,

				// Button Settings
				button_image_url : "${contextPath}/common/uploadswf/XPButtonUploadText_61x22.png",
				button_placeholder_id : "spanButtonPlaceholder",
				button_width: 61,
				button_height: 22,
				button_text:"选择图片",
				button_text_left_padding:5,
				
				// Flash Settings
				flash_url : "${contextPath}/common/uploadswf/swfupload.swf",

				custom_settings : {
					progressTarget : "fsUploadProgress",
					cancelButtonId : "btnCancel"
				},
				// Debug Settings
				debug: false
			});
		

		function myUploadSuccess(file, serverData) {
		 try {
				var jsonData = eval("("+serverData+")");
				
				$('#image_x').val("");  
		    	$('#image_y').val("");  
		   		$('#image_w').val("");  
		   		$('#image_h').val("");
		   		
		   		
		   	   // var imagew = parseInt(jsonData.srcWidth);
		       // var imageh = parseInt(jsonData.srcHeight);
		        
		        //if((imagew<172 && imagew > 0) || (imageh < 110 && imageh > 0)){
		         //  alert("您选择的图片尺寸不能小于172*110！");
		          // return;
		       // }
		   		
		   		if(parseInt(jsonData.srcWidth)<=455 && parseInt(jsonData.srcHeight)<=291){
		   		    $("#imageSrc").attr('width',parseInt(jsonData.srcWidth)).show();
		   		    $("#imageSrc").attr('height',parseInt(jsonData.srcHeight));
		   		}else if(parseFloat(jsonData.srcWidth)/parseFloat(jsonData.srcHeight)<455.0/291.0){
		   		    //var imagewq = parseInt(291*parseFloat(jsonData.srcWidth)/parseFloat(jsonData.srcHeight));
		   		    //if(imagewq<172 && imagewq > 0){
		            //alert("您选择的图片尺寸不能小于172*110！");
		            //return;
		   		    $("#imageSrc").attr('width',291*parseFloat(jsonData.srcWidth)/parseFloat(jsonData.srcHeight)).show();
		   		    $("#imageSrc").attr('height','291');
		   		}else{
		   		   // var imagehq = parseInt(455*parseFloat(jsonData.srcHeight)/parseFloat(jsonData.srcWidth));
			       // if(imagehq < 110 && imagehq > 0){
			        //   alert("您选择的图片尺寸不能小于172*110！");
			        //   return;
			      //  }
		   		    $("#imageSrc").attr('height',455*parseFloat(jsonData.srcHeight)/parseFloat(jsonData.srcWidth)).show();
		   		    $("#imageSrc").attr('width','455');
		   		}
		       
		        <#if isFlag>
				$("#imageSrc").attr('src','${contextPath}/upload/'+jsonData.fileName);
				<#else>
				</#if>
				$("#imageSrcDiv").show();
				$(".imgShowUpdateAf").show();
		        
				$(".jcrop-holder").remove();
				$("#imgUploadPath").val(jsonData.imgUploadPath);
				$("#imagehidden").load("${contextPath}/common/imagejcrop.do");
				
				var progress = new FileProgress(file, this.customSettings.progressTarget);
				progress.setComplete();
				progress.toggleCancel(true,this);
			} catch (ex) {
				this.debug(ex);
			}
		}
	});  
    </script>
</#macro>