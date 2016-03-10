<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=0">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="format-detection" content="telephone=no">
<title>兰博机器人俱乐部简介</title>
<%@include file="../../../context/headWechat.jsp"%>
<link rel="stylesheet" type="text/css"
	href="${webRoot}/resources/wechat/article/page_mp_article_improve2a7a3f.css">
<!--[if lt IE 9]>
<link rel="stylesheet" type="text/css" href="https://res.wx.qq.com/mmbizwap/zh_CN/htmledition/style/page/appmsg/page_mp_article_improve_pc2a7a3f.css">
<![endif]-->

<link rel="stylesheet" type="text/css"
	href="${webRoot}/resources/wechat/article/not_in_mm2a7a3f.css">
<link rel="stylesheet" type="text/css"
						href="${webRoot}/resources/wechat/article/page_mp_article_improve_combo2a7a3f.css" />
</head>
<style type="text/css" id="1287849071"></style>
<body id="activity-detail" class="zh_CN mm_appmsg not_in_mm"
	ontouchstart="">

	<div id="js_article" class="rich_media">

		<div id="js_top_ad_area" class="top_banner"></div>
		<div class="rich_media_inner">
			<div id="page-content">
				<div id="img-content" class="rich_media_area_primary">
					<h2 class="rich_media_title" id="activity-name">${article.title}</h2>
					<div class="rich_media_meta_list">
						<em id="post-date" class="rich_media_meta rich_media_meta_text"><fmt:formatDate value="${article.create_time}" pattern="yyyy-MM-dd" /></em>

						<a
							class="rich_media_meta rich_media_meta_link rich_media_meta_nickname"
							href="javascript:void(0);" id="post-user">${appName}</a> <span
							class="rich_media_meta rich_media_meta_text rich_media_meta_nickname">${appName}</span>
					</div>
<!-- 
					<div class="rich_media_thumb_wrp" id="media">

						<img class="rich_media_thumb" id="js_cover"
							onerror="this.parentNode.removeChild(this)"
							data-backsrc="http://mmbiz.qpic.cn/mmbiz/KROiadZDlTgb0fu850FX17BEtyhFrqKicHWqEQ7y2eickS2mjV0yYZtibbdzs7OX11sIfJLl7x9peYpwLsfO03Nd4w/0?wx_fmt=jpeg"
							data-s="300,640" src="./兰博机器人俱乐部简介_files/640">
					</div>
 -->
					<div class="rich_media_content " id="js_content">
						<c:out value="${article.content}" escapeXml="false" />
						<!-- <p>
							<img data-s="300,640" data-type="jpeg"
								data-src="http://mmbiz.qpic.cn/mmbiz/KROiadZDlTgZgKVnNBO7DjRyPj2qp6icwnWRdOoQb25siaVTMBnLfOJqQ7nEtaOnLwpC9ZQKBty0M09azG4T8uicEQ/0?wx_fmt=jpeg"
								data-ratio="1.8093525179856116" data-w=""
								src="./兰博机器人俱乐部简介_files/640(1)"
								style="width: auto !important; visibility: visible !important; height: auto !important;"><br>
						</p> -->
					</div>
					
				</div>
			</div>
		</div>
	</div>
	<%-- 
<script src="${webRoot}/resources/js/plugins/require/require.js"
	type="text/javascript" async="" crossorigin="true"></script>
<script src="${webRoot}/resources/wechat/article/ios275627.js"
	type="text/javascript" async="" crossorigin="true"></script>
<script src="${webRoot}/resources/wechat/article/a2b6c8f.js"
	type="text/javascript" async="" crossorigin="true">
</script>
<script src="${webRoot}/resources/wechat/article/qqmusic2ab8bd.js"
	type="text/javascript" async="" crossorigin="true"></script>
<script src="${webRoot}/resources/wechat/article/device2b3aae.js"
	type="text/javascript" async="" crossorigin="true">
</script>
<script src="${webRoot}/resources/wechat/article/index2a9baf.js"
	type="text/javascript" async="" crossorigin="true"></script>
	 --%>
	
</body>
</html>