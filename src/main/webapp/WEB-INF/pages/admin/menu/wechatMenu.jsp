<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>微信菜单</title>
<meta name="keywords" content="沙包娱乐后台管理系统">
<meta name="description" content="沙包娱乐后台管理系统是一个微信后台管理系统">
<%@include file="../../../context/headAdmin.jsp"%>
<!-- Morris显示图表 -->
<link href="${webRoot}/resources/admin/css/plugins/footable/footable.core.css" rel="stylesheet">
</head>
<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight">
            <div class="row">
                <div class="col-sm-12">
                    <div class="ibox float-e-margins">
                        <div class="ibox-title">
                            <h5>FooTable行切换，排序，分页演示</h5>

                            <div class="ibox-tools">
                                <a class="collapse-link">
                                    <i class="fa fa-chevron-up"></i>
                                </a>
                                <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                                    <i class="fa fa-wrench"></i>
                                </a>
                                <ul class="dropdown-menu dropdown-user">
                                    <li><a href="#">选项 01</a>
                                    </li>
                                    <li><a href="#">选项 02</a>
                                    </li>
                                </ul>
                                <a class="close-link">
                                    <i class="fa fa-times"></i>
                                </a>
                            </div>
                        </div>
                        <div class="ibox-content">

                            <table class="footable table table-stripped toggle-arrow-tiny" data-page-size="8">
                                <thead>
                                <tr>

                                    <th data-toggle="true">产品</th>
                                    <th>名字</th>
                                    <th>电话</th>
                                    <th data-hide="all">公司</th>
                                    <th data-hide="all">参数</th>
                                    <th data-hide="all">采购数量</th>
                                    <th data-hide="all">日期</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td>2015韩国童装韩版牛仔童短裤</td>
                                    <td>袁岳</td>
                                    <td>0800 051213</td>
                                    <td>深圳市有大福实业有限公司</td>
                                    <td><span class="pie">0.52/1.561</span></td>
                                    <td>200</td>
                                    <td>2015.09.10</td>
                                    <td><a href="#"><i class="fa fa-check text-navy"></i> 通过</a></td>
                                </tr>
                                <tr>
                                    <td>300米速进口日本原丝耐磨</td>
                                    <td>付守永</td>
                                    <td>0500 780909</td>
                                    <td>广州重兑诺贸易有限公司</td>
                                    <td><span class="pie">6,9</span></td>
                                    <td>400</td>
                                    <td>2015.10.14</td>
                                    <td><a href="#"><i class="fa fa-check text-navy"></i> 通过</a></td>
                                </tr>
                                <tr>
                                    <td>单肩包品牌外贸女包批发</td>
                                    <td>张有为</td>
                                    <td>0800 1111</td>
                                    <td>广州纳依斯商贸发展有限公司</td>
                                    <td><span class="pie">3,1</span></td>
                                    <td>750</td>
                                    <td>2015.08.22</td>
                                    <td><a href="#"><i class="fa fa-check text-navy"></i> 通过</a></td>
                                </tr>
                                <tr>
                                    <td>2015新款辣妈孙俪周迅同款</td>
                                    <td>李全福 </td>
                                    <td>(016977) 0648</td>
                                    <td>营口港荟网络科技股份有限公司</td>
                                    <td><span class="pie">4,9</span></td>
                                    <td>180</td>
                                    <td>2015.11.19</td>
                                    <td><a href="#"><i class="fa fa-check text-navy"></i> 通过</a></td>
                                </tr>
                                <tr>
                                    <td>300米速进口日本原丝耐磨</td>
                                    <td>付守永</td>
                                    <td>0500 780909</td>
                                    <td>广州重兑诺贸易有限公司</td>
                                    <td><span class="pie">6,9</span></td>
                                    <td>400</td>
                                    <td>2015.10.14</td>
                                    <td><a href="#"><i class="fa fa-check text-navy"></i> 通过</a></td>
                                </tr>
                                <tr>
                                    <td>正品印度红油
                                    </td>
                                    <td>袁岳</td>
                                    <td>0800 051213</td>
                                    <td>深圳市有大福实业有限公司</td>
                                    <td><span class="pie">0.52/1.561</span></td>
                                    <td>200</td>
                                    <td>2015.09.10</td>
                                    <td><a href="#"><i class="fa fa-check text-navy"></i> 通过</a></td>
                                </tr>
                                <tr>
                                    <td>2015新款辣妈孙俪周迅同款</td>
                                    <td>李全福 </td>
                                    <td>(016977) 0648</td>
                                    <td>营口港荟网络科技股份有限公司</td>
                                    <td><span class="pie">4,9</span></td>
                                    <td>180</td>
                                    <td>2015.11.19</td>
                                    <td><a href="#"><i class="fa fa-check text-navy"></i> 通过</a></td>
                                </tr>
                                <tr>
                                    <td>美国原装进口电子烟油
                                    </td>
                                    <td>袁岳</td>
                                    <td>0800 051213</td>
                                    <td>深圳市有大福实业有限公司</td>
                                    <td><span class="pie">0.52/1.561</span></td>
                                    <td>200</td>
                                    <td>2015.09.10</td>
                                    <td><a href="#"><i class="fa fa-check text-navy"></i> 通过</a></td>
                                </tr>
                                <tr>
                                    <td>300米速进口日本原丝耐磨</td>
                                    <td>付守永</td>
                                    <td>0500 780909</td>
                                    <td>广州重兑诺贸易有限公司</td>
                                    <td><span class="pie">6,9</span></td>
                                    <td>400</td>
                                    <td>2015.10.14</td>
                                    <td><a href="#"><i class="fa fa-check text-navy"></i> 通过</a></td>
                                </tr>
                                <tr>
                                    <td>单肩包品牌外贸女包批发</td>
                                    <td>张有为</td>
                                    <td>0800 1111</td>
                                    <td>广州纳依斯商贸发展有限公司</td>
                                    <td><span class="pie">3,1</span></td>
                                    <td>750</td>
                                    <td>2015.08.22</td>
                                    <td><a href="#"><i class="fa fa-check text-navy"></i> 通过</a></td>
                                </tr>
                                <tr>
                                    <td>2015新款辣妈孙俪周迅同款</td>
                                    <td>李全福 </td>
                                    <td>(016977) 0648</td>
                                    <td>营口港荟网络科技股份有限公司</td>
                                    <td><span class="pie">4,9</span></td>
                                    <td>180</td>
                                    <td>2015.11.19</td>
                                    <td><a href="#"><i class="fa fa-check text-navy"></i> 通过</a></td>
                                </tr>
                                <tr>
                                    <td>300米速进口日本原丝耐磨</td>
                                    <td>付守永</td>
                                    <td>0500 780909</td>
                                    <td>广州重兑诺贸易有限公司</td>
                                    <td><span class="pie">6,9</span></td>
                                    <td>400</td>
                                    <td>2015.10.14</td>
                                    <td><a href="#"><i class="fa fa-check text-navy"></i> 通过</a></td>
                                </tr>
                                <tr>
                                    <td>正品印度红油
                                    </td>
                                    <td>袁岳</td>
                                    <td>0800 051213</td>
                                    <td>深圳市有大福实业有限公司</td>
                                    <td><span class="pie">0.52/1.561</span></td>
                                    <td>200</td>
                                    <td>2015.09.10</td>
                                    <td><a href="#"><i class="fa fa-check text-navy"></i> 通过</a></td>
                                </tr>
                                <tr>
                                    <td>2015新款辣妈孙俪周迅同款</td>
                                    <td>李全福 </td>
                                    <td>(016977) 0648</td>
                                    <td>营口港荟网络科技股份有限公司</td>
                                    <td><span class="pie">4,9</span></td>
                                    <td>180</td>
                                    <td>2015.11.19</td>
                                    <td><a href="#"><i class="fa fa-check text-navy"></i> 通过</a></td>
                                </tr>
                                </tbody>
                                <tfoot>
                                <tr>
                                    <td colspan="5">
                                        <ul class="pagination pull-right"></ul>
                                    </td>
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
    <script src="${webRoot}/resources/admin/js/plugins/footable/footable.all.min.js"></script>
    <script src="${webRoot}/resources/admin/js/content.min.js?v=1.0.0"></script>
    <script>
        $(document).ready(function(){$(".footable").footable();$(".footable2").footable()});
    </script>
</body>

</html>