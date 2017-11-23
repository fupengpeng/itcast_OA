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
<title>待我审批</title>
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
				待我审批
			</div>
			<div id="Title_End"></div>
		</div>
	</div>

	<form>
		<input type="hidden" name="pageNum" value="1" />
	</form>

	<div id="MainArea">
		<table cellspacing="0" cellpadding="0" class="TableStyle">
			<!-- 表头-->
			<thead>
				<tr align="CENTER" valign="MIDDLE" id="TableTitle">
					<td width="250">标题</td>
					<td width="115">申请人</td>
					<td width="115">申请日期</td>
					<td>相关操作</td>
				</tr>
			</thead>
			<!--显示数据列表-->
			<tbody id="TableData" class="dataContainer" datakey="formList">
				<s:iterator value="list">
					<tr class="TableDetail1 template">
						<td><a href="approveUI.html">${application.title}</a></td>
						<td>${application.applicant.name}&nbsp;</td>
						<td>${application.applyTime}&nbsp;</td>
						<td>
						    <s:a action="flow_approveUI?taskId=%{task.id}&applicationId=%{application.id}" namespace="/">审批处理</s:a> 
							<s:a action="flow_historyApprovedList?applicationId=%{application.id}" namespace="/">查看流转记录</s:a></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>

		<!-- 其他功能超链接 -->
		<div id="TableTail">
			<div id="TableTail_inside"></div>
		</div>
	</div>

	<%-- <!--分页信息-->
	<!-- 1.包含分页信息 -->
	<%@include file="/WEB-INF/jsp/public/pageView.jsp"%>
	<!-- 2.提供一个分页用的表单 -->
	<s:form id="pageForm" action="myTaskList" namespace="/"></s:form> --%>
	<div id=PageSelectorBar>
		<div id=PageSelectorMemo>页次：7/13页 &nbsp; 每页显示：30条 &nbsp;
			总记录数：385条</div>
		<div id=PageSelectorSelectorArea>
			<a href="javascript:void(0)" title="首页" style="cursor: hand;"> <img
				src="${pageContext.request.contextPath}/style/blue/images/pageSelector/firstPage.png" /></a>
			<span class="PageSelectorNum" style="cursor: hand;"
				onClick="gotoPageNum(2);">3</span> <span class="PageSelectorNum"
				style="cursor: hand;" onClick="gotoPageNum(2);">4</span> <span
				class="PageSelectorNum" style="cursor: hand;"
				onClick="gotoPageNum(2);">5</span> <span class="PageSelectorNum"
				style="cursor: hand;" onClick="gotoPageNum(2);">6</span> <span
				class="PageSelectorNum PageSelectorSelected">7</span> <span
				class="PageSelectorNum" style="cursor: hand;"
				onClick="gotoPageNum(2);">8</span> <span class="PageSelectorNum"
				style="cursor: hand;" onClick="gotoPageNum(2);">9</span> <span
				class="PageSelectorNum" style="cursor: hand;"
				onClick="gotoPageNum(2);">10</span> <span class="PageSelectorNum"
				style="cursor: hand;" onClick="gotoPageNum(2);">11</span> <span
				class="PageSelectorNum" style="cursor: hand;"
				onClick="gotoPageNum(2);">12</span>

			<a href="#" title="尾页" style="cursor: hand;"><img
				src="${pageContext.request.contextPath}/style/blue/images/pageSelector/lastPage.png" /></a>
			转到： <input onFocus="this.select();" maxlength="2" class="inputStyle"
				type="text" value="1" name="currPage" tabindex="0" /> <input
				type="submit" name="goBtn" value="Go" class="MiddleButtonStyle" />
		</div>
	</div>

	<div class="Description">
		说明：<br /> 1，这里列出的所有的表单状态都为"审批中"。
	</div>

</body>
</html>
