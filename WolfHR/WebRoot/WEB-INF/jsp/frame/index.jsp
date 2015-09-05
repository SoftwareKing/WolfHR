<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<title>HR</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<frameset rows="100,*,25" framespacing="0" border="0" frameborder="0">
    <frame src="forwardAction_top.action" name="TopMenu"  scrolling="no" noresize />
    <frameset cols="180,*" id="resize">
        <frame noresize name="menu" src="forwardAction_left.action" scrolling="yes" />
        <frame noresize name="right" src="forwardAction_right.action" scrolling="yes" />
    </frameset>
    <frame noresize name="status_bar" scrolling="no" src="forwardAction_bottom.action" />
</frameset>
<noframes>
<body>
</body>
</noframes>
</html>
