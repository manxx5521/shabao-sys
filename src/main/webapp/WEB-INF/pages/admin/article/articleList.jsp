<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE>
<html lang="zh-CN">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>添加文章</title>
	<meta name="keywords" content="沙包娱乐后台管理系统">
	<meta name="description" content="沙包娱乐后台管理系统是一个微信后台管理系统">
	<%@include file="../../../context/headAdmin.jsp"%>
	<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
	<!-- Data Tables -->
	<link href="${webRoot}/resources/admin/css/plugins/dataTables/dataTables.bootstrap.css" rel="stylesheet">
	<base target="_blank">
</head>
<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight">
        <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>文章列表 <small>显示，修改</small></h5>
                        <div class="ibox-tools">
                            <a class="collapse-link">
                                <i class="fa fa-chevron-up"></i>
                            </a>
                            <a class="dropdown-toggle" data-toggle="dropdown" href="table_data_tables.html#">
                                <i class="fa fa-wrench"></i>
                            </a>
                            <ul class="dropdown-menu dropdown-user">
                                <li><a href="table_data_tables.html#">选项1</a>
                                </li>
                                <li><a href="table_data_tables.html#">选项2</a>
                                </li>
                            </ul>
                            <a class="close-link">
                                <i class="fa fa-times"></i>
                            </a>
                        </div>
                    </div>
                    <div class="ibox-content">
                    	<form class="form-inline">
  							<div class="form-group col-xs-4">
    							<label for="exampleInputName2" class="col-xs-5 control-label">用户名</label>
    							<input type="text" class="form-control col-xs-7" id="exampleInputName2" placeholder="Jane Doe">
  							</div>
  							<div class="form-group col-xs-4">
    						<label for="exampleInputEmail21 " class="col-xs-5">性别</label>
    						<input type="email" class="form-control col-xs-7" id="exampleInputEmail21" placeholder="jane.doe@example.com">
 							</div>
 							<div class="form-group col-xs-4">
    							<label for="exampleInputName22" class="col-xs-5">邮箱</label>
    							<input type="text" class="form-control col-xs-7" id="exampleInputName22" placeholder="Jane Doe">
  							</div>
  							<div class="form-group col-xs-4">
    						<label for="exampleInputEmail23" class="col-xs-5">测试长度</label>
    						<input type="email" class="form-control col-xs-7" id="exampleInputEmail23" placeholder="jane.doe@example.com">
 							</div>
 							<div class="form-group col-xs-4">
    							<label for="exampleInputName24" class="col-xs-5">用户类型细分</label>
    							<input type="text" class="form-control col-xs-7" id="exampleInputName24" placeholder="Jane Doe">
  							</div>
  							<div class="form-group col-xs-4">
    						<label for="exampleInputEmail25" class="col-xs-5">好</label>
    						<input type="email" class="form-control col-xs-7" id="exampleInputEmail25" placeholder="jane.doe@example.com">
 							</div>
                    	</form>
                    	<button type="submit" class="btn btn-default">查询</button>
						<div class="">
                            <a onclick="add();" href="javascript:void(0);" class="btn btn-primary ">添加</a>
                            <a onclick="addByUe();" href="javascript:void(0);" class="btn btn-primary ">添加</a>
                            <a onclick="select2();" href="javascript:void(0);" class="btn btn-primary ">select2插件</a>
                        </div>
                        <table class="table table-striped table-bordered table-hover dataTables-example">
                            <thead>
                                <tr>
                                    <th>文章标题</th>
                                    <th>创建时间</th>
                                    <th>创建人</th>
                                </tr>
                            </thead>
                            <tbody>
                            	<c:forEach var="r" items="${dataList}" varStatus="idx">
                                <tr class="gradeX">
                                    <td> ${r.title}</td>
                                    <td class="center"><fmt:formatDate value="${r.create_time}" pattern="yyyy-MM-dd HH:mm:ss" /> </td>
                                    <td > ${r.user_name}</td>
                                </tr>
                                </c:forEach>
                            </tbody>
                            <tfoot>
                                <tr>
                                    <th>文章标题</th>
                                    <th>创建时间</th>
                                    <th>创建人</th>
                                </tr>
                            </tfoot>
                        </table>

                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="${webRoot}/resources/admin/js/jquery.min.js?v=2.1.4"></script>
    <script src="${webRoot}/resources/admin/js/bootstrap.min.js?v=3.3.5"></script>
    <script src="${webRoot}/resources/admin/js/content.min.js?v=1.0.0"></script>
    
    <script src="${webRoot}/resources/admin/js/plugins/jeditable/jquery.jeditable.js"></script>
    <script src="${webRoot}/resources/admin/js/plugins/dataTables/jquery.dataTables.js"></script>
    <script src="${webRoot}/resources/admin/js/plugins/dataTables/dataTables.bootstrap.js"></script>
    <script>
    	//下面用来显示上下页标签
        $(document).ready(function(){$(".dataTables-example").dataTable();var oTable=$("#editable").dataTable();oTable.$("td").editable("../example_ajax.php",{"callback":function(sValue,y){var aPos=oTable.fnGetPosition(this);oTable.fnUpdate(sValue,aPos[0],aPos[1])},"submitdata":function(value,settings){return{"row_id":this.parentNode.getAttribute("id"),"column":oTable.fnGetPosition(this)[2]}},"width":"90%","height":"100%"})});
        //function fnClickAddRow(){$("#editable").dataTable().fnAddData(["Custom row","New row","New row","New row","New row"])};
        function add(){
        	window.location.href = './articleAddInit.html';
        }
        function addByUe(){
        	window.location.href = './articleAddUe.html';
        }
        function select2(){
        	window.location.href = '${webRoot}/select/demo.html';
        }
    </script>
</body>

</html>