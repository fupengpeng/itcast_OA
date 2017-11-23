<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>
    <title>Bottom</title>
    <%@include file="/WEB-INF/jsp/public/header.jsp"%>
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/style/blue/statusbar.css" />
</head>
<body style="margin:0"> 

<div id="StatusBar">
    <div id="Online">
    	在线人员：共 <span class="OnlineUser" id="onlineUserNum"></span> 人
        <span class="OnlineView"><a href="javascript:void(0)">[查看在线名单]</a></span>
    </div>
    <div id="Info">
    	<a href="http://www.itcast.cn" title = "九点连线首页" target="_blank">九点连线首页</a> |
        <a href="http://bbs.itcast.cn" title = "九点连线BBS" target="_blank">九点连线BBS</a> 
    </div>
    <div id="DesktopText">
        <a href="javascript:void(0)"><img border="0" src="${pageContext.request.contextPath}/style/images/top/text.gif"/>便笺</a>
        <span id=TryoutInfo></span>
        <span id="Version">
            <a href="javascript:void(0)">
            	<img border="0" width="11" height="11" src="${pageContext.request.contextPath}/style/images/top/help.gif" /> 
                <img border="0" width="40" height="11" src="${pageContext.request.contextPath}/style/blue/images/top/version.gif" />
            </a>
        </span>
    </div>
</div>

</body>
</html>

