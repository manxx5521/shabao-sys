<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>文件上传</title>
<%@include file="../../context/headAdmin.jsp"%>
<script src="${webRoot}/resources/js/jquery-1.11.0.min.js"></script>
<script src="${webRoot}/resources/js/jquery-ui.js"></script>

<script src="${webRoot}/resources/js/plugins/uploadify/jquery.uploadify.min.js"></script>
<link href="${webRoot}/resources/js/plugins/uploadify/css/uploadify.css" rel="stylesheet">
<script src="${webRoot}/resources/js/custom/jquery.file.js"></script>


<style>
html, body {
	background: none;
}
</style>
</head>
<body>
	http://localhost:8080/asiainfo-workflow/file/demo.jhtml 测试
	<hr/>
	<!-- <input type="file" name="file_upload" id="file_upload" />
	1111 -->
	
	<div id="test1"></div>
	
	<script type="text/javascript">
	$('#test1').asiainfoFile({
		id:'#test1',
		element_id:10000006,
		url:'/file/upload.html',
		swf: '${webRoot}/resources/js/plugins/uploadify/uploadify.swf',
		button_image_url: '${webRoot}/resources/js/plugins/uploadify/img/kong.png',
		default_value:'file_haha.doc:测试.doc|file_123.xls:哈哈.xls'
	});
	/*
	  $(function() {
	        $('#test1').uploadify({
	            'swf'      : '${ctx}/resources/js/uploadify/uploadify.swf',
	            'uploader' : './upload.jhtml',
	            'buttonText' : '上传附件',
	            'button_image_url': '${ctx}/resources/js/uploadify/img/kong.png',
	            // Your options here
	        });
	    });
	*/
	</script>
</body>
</html>