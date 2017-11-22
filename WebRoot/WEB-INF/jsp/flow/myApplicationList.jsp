<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>
<title>经我审批</title>
<%@include file="/WEB-INF/jsp/public/header.jsp"%>

</head>
<body>

	<div id="Title_bar">
		<div id="Title_bar_Head">
			<div id="Title_Head"></div>
			<div id="Title">
				<!--页面标题-->
				<img border="0" width="13" height="13"
					src="${pageContext.request.contextPath}/style/images/title_arrow.gif" />
				经我审批
			</div>
			<div id="Title_End"></div>
		</div>
	</div>


	<div id="QueryArea">
		<div style="height: 30px">
			<s:form id="pageForm" action="flow_myApplicationList" namespace="/"
				method="post">
				<table border=0 cellspacing=3 cellpadding=5>
					<tr>
						<td>按条件查询：</td>
						<td><s:select cssClass="SelectStyle" name="templateId"
								list="templateList" listKey="id" listValue="name" headerKey=""
								headerValue="查看全部模板"></s:select></td>
						<td><s:select cssClass="SelectStyle" name="status"
								list="%{ {'审批中','未通过','已通过'} }" headerKey=""
								headerValue="查看全部状态"></s:select></td>
						<td><a href=""><input type="IMAGE"
								src="${pageContext.request.contextPath}/style/blue/images/button/query.PNG" /></a></td>
					</tr>
				</table>
			</s:form>
		</div>
	</div>

	<div id="MainArea">
		<table cellspacing="0" cellpadding="0" class="TableStyle">
			<!-- 表头-->
			<thead>
				<tr align="CENTER" valign="MIDDLE" id="TableTitle">
					<td width="250">主题</td>
					<td width="115">申请人</td>
					<td width="115">申请日期</td>
					<td width="150">我的意见</td>
					<td width="100">当前状态</td>
					<td>相关操作</td>
				</tr>
			</thead>
			<!--显示数据列表-->
			<tbody id="TableData" class="dataContainer" datakey="formList">
				<s:iterator value="recordList">
					<tr class="TableDetail1 template">
						<td>${title}</td>
						<td>${applicant.name}&nbsp;</td>
						<td>
						    <s:date name="applyTime" format="yyyy-MM-dd  HH:mm:ss"/>
						&nbsp;</td>
						<td>同意</td>
						<td>${form.status}&nbsp;</td>
						<td>
						    <s:a action="flow_download?applicationId=%{id}" namespace="/">查看申请信息</s:a> 
						    <!-- 1.点击‘查看流转记录’，调用flowAction中的historyApprovedList方法。传入点击的applicationId -->
						    <s:a action="flow_historyApprovedList?applicationId=%{id}" namespace="/">查看流转记录</s:a>
						</td>
					</tr>
				</s:iterator>
			</tbody>
		</table>

		<!-- 其他功能超链接 -->
		<div id="TableTail">
			<div id="TableTail_inside"></div>
		</div>
	</div>

	<!--分页信息-->
	<!-- 包含分页信息 -->
	<%@include file="/WEB-INF/jsp/public/pageView.jsp"%>


	<div class="description">
		说明：<br /> 1，按申请时间降序排列，第1页看到的是最近的申请。
	</div>

</body>
</html>
