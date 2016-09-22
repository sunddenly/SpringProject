<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link rel="stylesheet" type="text/css" href="Huploadify.css"/>
<script type="text/javascript" src="jquery.js"></script>
<script type="text/javascript" src="jquery.Huploadify.js"></script>
<style type="text/css">
</style>
<script type="text/javascript">
$(function(){
	$('#upload').Huploadify({
		auto:false,
		fileTypeExts:'*.jpg;*.png;*.exe',
		multi:true,
		formData:{key:123456,key2:'vvvv'},
		fileSizeLimit:9999,
		showUploadedPercent:true,//是否实时显示上传的百分比，如20%
		showUploadedSize:true,
		removeTimeout:9999999,
		uploader:'/upload',
		onUploadStart:function(){
			$("#stopUpload").removeAttr("hidden");
			},
		onInit:function(){
			alert('初始化');
			},
		onUploadComplete:function(){
			alert('上传完成');
			$("#stopUpload").attr("hidden",true);
			},
		onDelete:function(file){
			console.log('删除的文件：'+file);
			console.log(file);
		}
		});
	});
</script>
</head>

<body>
<input type="file" name="uploadify" id="upload" />
<a href="javascript:$('#upload').Huploadify('upload','*')">开始上传</a>
<a href="javascript:$('#upload').Huploadify('cancel','*')">取消上传</a>
<a href="javascript:$('#upload').Huploadify('stop','*')" hidden=true id="stopUpload">停止上传</a>
</body>
</html>
