<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>
<html>
<head>
    <title>员工列表</title>
   <link rel="stylesheet" href="${pageContext.request.contextPath}/css/blue/pageCommon.css" type="text/css">
    
    <jsp:include page="/WEB-INF/jsp/user/usercommon.jsp"></jsp:include>
   <script type="text/javascript" src="${pageContext.request.contextPath}/js/findUser.js"></script>
</head>
<body>
 
<div id="Title_bar">
    <div id="Title_bar_Head"> 
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/css/images/title_arrow.gif"/> 员工查询管理
        </div>
        <div id="Title_End"></div>
        <div></div>
        </div>

       </div>
       <div id="QueryArea">
	<div style="height: 30px">
		<s:form name="formUser">
		  <s:hidden name="uid"></s:hidden>
			<table border=0 cellspacing=3 cellpadding=5>
				<tr>
					<td>按条件查询：</td>
					<td>工号</td>
					<td><s:textfield name="jobnumbers" id="jobnumbers" cssClass="InputStyle"></s:textfield></td>
					
					
					<td>姓名</td>
					<td><s:textfield name="usernames" id="usernames" cssClass="InputStyle"></s:textfield></td>
					<td>
						
					</td>
					<td>部门</td>
					<td width="98px">
						<s:select list="#departmentList" listKey="did" listValue="dname" id="did" headerKey="" headerValue="请选择部门" name="did" cssClass="SelectStyle"></s:select>
					</td>
					
					
					<td><input onclick="findUser()" type="image" src="${pageContext.request.contextPath}/css/blue/images/button/query.PNG" style="cursor: pointer" /></td>
				</tr>
			</table>
		</s:form>
		
	</div>
</div>
   
<div id="MainArea">
    <table cellspacing="0" cellpadding="0" class="TableStyle">
       
        <!-- 表头-->
        <thead>
            <tr align=center valign=middle id=TableTitle>
           

            <td width="100">工号 &nbsp;<a name="" href="#"> <img alt="" src="${pageContext.request.contextPath}/css/user/wr.gif" align="middle" border="0" height="11" width="9" /></a></td>

            <td width="120">姓名 &nbsp;<a name="" href="#"><img alt="" src="${pageContext.request.contextPath}/css/user/wr.gif" align="middle" border="0" height="11" width="9" /></a></td>

            <td width="150">所属部门 &nbsp;<a name="" href="#"><img alt="" src="${pageContext.request.contextPath}/css/user/wr.gif" align="middle" border="0" height="11" width="9" /></a></td>

            <td width="150">所属岗位 &nbsp;<a name="" href="#"><img alt="" src="${pageContext.request.contextPath}/css/user/wr.gif" align="middle" border="0" height="11" width="9" /></a></td>
            <td width="80">性别 &nbsp;<a name="" href="#"><img alt="" src="${pageContext.request.contextPath}/css/user/wr.gif" align="middle" border="0" height="11" width="9" /></a></td>

          

            <td width="100">员工类型 &nbsp;<a name="" href="#"><img alt="" src="${pageContext.request.contextPath}/css/user/wr.gif" align="middle" border="0" height="11" width="9" /></a></td>

           
          </tr>

         
        </thead>
        
        <!--显示数据列表-->
        <tbody id="TableData" class="dataContainer" datakey="userList">
        	
            <s:iterator value="userList">
			 <tr align=center valign=middle id=TableTitle>
	              <td align=center> <s:property value="Jobnumber"/>
	              </td>
	                <s:hidden name="uid"></s:hidden>
	                <td align=center> <s:property value="username"/></td>
	                
	                <td align=center><s:property value="department.dname"/></td>
	                <td align=center>
						<s:iterator value="posts">
							<s:property value="pname"/>
						</s:iterator>
					</td>
	                <td align=center>
	                	<s:property value="sex"/>
	                </td>
	                <td align=center>
	                	<s:property value="employstate"/>
	                </td>
	               
	               
	            </tr>
		</s:iterator>	
        </tbody>
    </table>
    
    
</div>
<!--分页信息 -->

<%@ include file="/WEB-INF/jsp/public/pageView.jspf" %>

</body>
</html>
