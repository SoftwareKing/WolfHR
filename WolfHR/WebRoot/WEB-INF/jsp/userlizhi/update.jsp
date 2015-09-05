<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>
<script language="javascript" src="${pageContext.request.contextPath}/fckeditor/fckeditor.js"></script>
<script language="javascript" src="${pageContext.request.contextPath}/js/jquery-fckeditor.js"></script>
<script language="javascript" src="${pageContext.request.contextPath}/js/department_add.js"></script>
<html>
<head>
	<title>离职管理</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>

<!-- 标题显示 --> 
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/css/images/title_arrow.gif"/> 离职信息
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<!--显示表单内容-->
<div id=MainArea>
    <s:form action="userlizhiAction_update.action">
    	<s:hidden name="lzid"></s:hidden>
        <div class="ItemBlock_Title1"><!-- 信息说明<DIV CLASS="ItemBlock_Title1">
        	<IMG BORDER="0" WIDTH="4" HEIGHT="7" SRC="${pageContext.request.contextPath}/css/blue/images/item_point.gif" /> 部门信息 </DIV>  -->
        </div>
        
        <!-- 表单内容显示 -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
                <table cellpadding="0" cellspacing="0" class="mainForm">
                   <tr>
                    <td>工号</td>
                    <td><s:textfield name="Jobnumber" cssClass="InputStyle"></s:textfield></td>
                    </tr>
                    <tr>
                    <td>姓名</td>
                    <td><s:textfield name="username" cssClass="InputStyle"></s:textfield></td>
                    </tr>
                    <tr>
                    <td>部门名称</td>
                    <td><s:textfield name="department" cssClass="InputStyle"></s:textfield></td>
                    </tr>
                    
                    <tr>
                    <td>岗位名称</td>
                    <td><s:textfield name="post" cssClass="InputStyle"></s:textfield></td>
                    </tr>
                    
                     <tr>
                     <td>离职时间</td>
                     <td><s:textfield name="time" cssClass="InputStyle"></s:textfield></td>
                     </tr>
                     <tr>
                    <td>离职性质</td>
                    <td><s:textfield name="lizhixingzhi" cssClass="InputStyle"></s:textfield></td>
                    </tr>
                     <tr>
                     <td>离职原因</td>
                     <td><s:textfield name="reason" cssClass="InputStyle"></s:textfield></td>
                     </tr>
                    <tr>
                     <td>备注</td>
                     <td><s:textarea name="description" cssClass="TextareaStyle"></s:textarea></td>
                    </tr>
                </table>
            </div>
        </div>
        
        <!-- 表单操作 -->
        <div id="InputDetailBar">
            <input type="image" src="${pageContext.request.contextPath}/css/images/save.png"/>
            <a href="javascript:history.go(-1);"><img src="${pageContext.request.contextPath}/css/images/goBack.png"/></a>
        </div>
    </s:form>
</div>
</body>
</html>
