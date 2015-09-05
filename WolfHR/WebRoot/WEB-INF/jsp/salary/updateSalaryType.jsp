<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>
<html>
<head>
	<title>薪资标准设置</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/salary.js"></script>
</head>
<body> 

<!-- 标题显示 -->
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/css/images/title_arrow.gif"/> 修改薪资标准
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<!--显示表单内容-->
<div id="MainArea">
    <s:form action="salaryTypeAction_update.action" >
        <s:hidden name="id"></s:hidden>
        <div class="ItemBlock_Title1">  <!--<DIV CLASS="ItemBlock_Title1">
        	<IMG BORDER="0" WIDTH="4" HEIGHT="7" SRC="${pageContext.request.contextPath}/css/blue/images/item_point.gif" /> 岗位信息 </DIV>  -->
        </div>
        
        <!-- 表单内容显示 -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
                <table cellpadding="0" cellspacing="0" class="mainForm">
                    <tr>
                        <td width="100">员工类别</td>
                        <td><s:textfield name="category" cssClass="InputStyle"></s:textfield></td>
                    </tr>
                    <tr>
                        <td width="100">基本薪资</td>
                        <td><s:textfield name="baseSalary" cssClass="InputStyle" id="baseSalary" ></s:textfield>
                        	<font color="red">元</font>
                        </td>
                    </tr>
                    <tr>
                        <td width="100">岗位薪资</td>
                        <td><s:textfield name="postSalary" cssClass="InputStyle" id="postSalary"></s:textfield>
                        	<font color="red">元</font>
                        </td>
                    </tr>
                    <tr>
                        <td width="100">加班薪资</td>
                        <td><s:textfield name="addWorkMoney" cssClass="InputStyle" id="addWorkMoney"></s:textfield>
                        	<font color="red">元/小时</font>
                        </td>
                    </tr>
                    <tr>
                        <td width="100">旷工扣缴</td>
                        <td><s:textfield name="absentMoney" cssClass="InputStyle" id="absentMoney"></s:textfield>
                        	<font color="red">元/小时</font>
                        </td>
                    </tr>
                    <tr>
                        <td width="100">迟到扣缴</td>
                        <td><s:textfield name="lateMoney" cssClass="InputStyle" id="lateMoney"></s:textfield>
                        	<font color="red">元/小时</font>
                        </td>
                    </tr>
                    <tr>
                        <td width="100">早退扣缴</td>
                        <td><s:textfield name="leaveMoney" cssClass="InputStyle" id="leaveMoney"></s:textfield>
                        	<font color="red">元/小时</font>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
        
        <!-- 表单操作 -->
        <div id="InputDetailBar">
            <input type="image" src="${pageContext.request.contextPath}/css/images/save.png" />
            <a href="javascript:history.go(-1);"><img src="${pageContext.request.contextPath}/css/images/goBack.png"/></a>
        </div>
    </s:form>
</div>

</body>
</html>

