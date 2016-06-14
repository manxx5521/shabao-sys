<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>添加文章</title>
<title>select</title>
<%@include file="../../../context/headAdmin.jsp"%>
<script src="${webRoot}/resources/js/jquery-1.11.0.min.js"></script>
<script src="${webRoot}/resources/js/jquery-ui.js"></script>
<script src="${webRoot}/resources/js/custom/jquery.select.js"></script>
<link href="${webRoot}/resources/js/plugins/select2/css/select2.min.css"
	rel="stylesheet">
<script src="${webRoot}/resources/js/plugins/select2/select2.min.js"></script>
<script src="${webRoot}/resources/js/plugins/select2/zh-CN.js"></script>
<style>
html, body {
	background: none;
}
</style>
</head>
<body>
	11111
	<p>
		<select id='select1' class="js-states form-control"
			style="width: 200px"></select>
	</p>
	2222
	<p>
		<select id='select2' class="js-states form-control"
			style="width: 200px"></select>
	</p>
	<p>
		<input id='text1' value='555' />
	</p>
	<script type="text/javascript">
		//$('#select1').asiainfoSelect({id:'#select1',element_id:12345678,listeners:['select2']});
		//$('#select2').asiainfoSelect({id:'#select2',element_id:1234567});
		$('#select2').select2({

			ajax : {
				url : '/shabao-sys/select/select.html',
				dataType : 'json',
				delay : 250,
				data : function(params) {
					return {
						element_id : 12345678
					};
				},
				//服务端返回数据处理
				/*processResults : function(data, params) {
					console.debug("ajax返回的对象是:")
					console.debug(JSON.stringify(data))
					return data
				},*/
				processResults : function(data, params) {
					params.page = params.page || 1;
					return {
						results : data.items,
						pagination : {
							more : (params.page * 30) < data.total_count
						}
					};
				},
			},
			placeholder : "请选择",
			 minimumResultsForSearch: Infinity
		});
	</script>
</body>
</html>