<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>
<html>
<head>
	<title>津贴扣缴设置</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/salary.js"></script>
</head>
<body> 

<!-- 标题显示 -->
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/css/images/title_arrow.gif"/> 修改津贴扣缴
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<!--显示表单内容-->
<div id="MainArea">
    <s:form action="incomeAndPaymentAction_update.action" >
        <s:hidden name="id"></s:hidden>
        <div class="ItemBlock_Title1">  <!--<DIV CLASS="ItemBlock_Title1">
        	<IMG BORDER="0" WIDTH="4" HEIGHT="7" SRC="${pageContext.request.contextPath}/css/blue/images/item_point.gif" /> 岗位信息 </DIV>  -->
        </div>
        
        <!-- 表单内容显示 -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
                <table cellpadding="0" cellspacing="0" class="mainForm">
                    <tr>
                        <td width="100">收支类别</td>
                        <td>
                      
                        	<s:radio name="state" list="%{#{'1':'津贴','0':'扣缴'}}" ></s:radio>
                        </td>
                       
                    </tr>
                    <tr>
                        <td width="100">贴扣名称</td>
                        <td><s:textfield name="activatyName" cssClass="InputStyle" id="baseSalary" ></s:textfield>
                        	<font color="red">元</font>
                        </td>
                    </tr>
                    <tr>
                        <td width="100">贴扣地区</td>
                        <td><s:textfield name="address" cssClass="InputStyle" id="postSalary"></s:textfield>
                        	<font color="red">元</font>
                        </td>
                    </tr>
                    <tr>
                        <td width="100">薪资</td>
                        <td><s:textfield name="activatyMoney" cssClass="InputStyle" id="addWorkMoney"></s:textfield>
                        	<font color="red">元</font>
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

