<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<% 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<c:set var="webRoot" value="<%=path%>" />
<link href="${webRoot}/resources/admin/css/bootstrap.min.css?v=3.3.5" rel="stylesheet">
<link href="${webRoot}/resources/admin/css/font-awesome.min.css?v=4.4.0" rel="stylesheet">
<link href="${webRoot}/resources/admin/css/animate.min.css" rel="stylesheet">
<link href="${webRoot}/resources/admin/css/style.min.css?v=4.0.0" rel="stylesheet">
<link rel="shortcut icon" href="${webRoot}/resources/admin/img/favicon.ico">