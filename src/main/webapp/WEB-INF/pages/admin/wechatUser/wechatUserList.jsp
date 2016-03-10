<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>无标题文档</title>
<%@include file="../../../context/head.jsp"%>
<link href="${webRoot}/resources/admin/css/style.css" rel="stylesheet"
	type="text/css" />
<script src="${webRoot}/resources/admin/js/select-ui.min.js"></script>
<link href="${webRoot}/resources/admin/css/select.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript">
	//控制select选择框大小
	$(document).ready(function(e) {
		$(".select1").uedSelect({
			width : 345
		});
		$(".select2").uedSelect({
			width : 167
		});
		$(".select3").uedSelect({
			width : 100
		});
	});
</script>
</head>
<body>
	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">首页</a></li>
			<li><a href="#">添加章节</a></li>
		</ul>
	</div>
	<div class="rightinfo">
		<ul class="classlist">
			<c:forEach var="r" items="${dataList}" varStatus="idx">

				<li>
					<div class="lright">
						<h1>bookName</h1>
						<p>
							微信用户id： ${r.wx_user_id} <br />
						</p>
						<p>
							微信帐号id： ${r.account_id} <br />
						</p>
						<p>
							用户openId： ${r.openId} <br />
						</p>
						<p>
							更新时间： ${r.update_time} <br />
						</p>
					</div>
				</li>
			</c:forEach>
		</ul>
		<div class="clear"></div>

	</div>
</body>
</html>