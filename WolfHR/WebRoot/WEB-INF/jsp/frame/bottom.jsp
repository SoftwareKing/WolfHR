<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Bottom</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link type="text/css" rel="stylesheet" href="css/blue/statusbar.css" />
	
</head>
<body leftmargin="0" topmargin="0" onload="onLoad()" marginheight="0" marginwidth="0"> 

<div id="StatusBar">
    <div id="Online">
    	在线人员：共 <span class="OnlineUser" id="onlineUserNum">${applicationScope.num }</span> 人
    </div>
    <div id="Info">
    	<a href="http://www.qqhru.edu.cn/" title = "齐齐哈尔大学首页" target="_blank">齐齐哈尔大学首页</a> |
        <a href="http://jkxy.qqhru.edu.cn/" title = "齐齐哈尔大学计控学院" target="_blank">齐齐哈尔大学计控学院</a> 
    </div>
    <div id="DesktopText">
      
        <span id=TryoutInfo></span>
        <span id="Version">
            <a href="javascript:window.alert('当前版本为WolfHR24')">
            	<img border="0" width="40" height="11" src="css/blue/images/top/version.gif" />
            </a>
        </span>
    </div>
</div>
<div style="display: none; font-family: Verdana; font-size: 11px; border: 1px solid rgb(0, 204, 0); background-color: rgb(164, 255, 164); padding: 1px; position: absolute; right: 1px; top: 1px; width: 0px; height: 0px; z-index: 10000;" id="buffalo_loading"></div>

</body>
</html>