<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>
<HTML xmlns="http://www.w3.org/1999/xhtml">
<HEAD> 
   
	<TITLE>人力资源管理系统登录</TITLE>
	<LINK HREF="css/blue/login.css" type=text/css rel=stylesheet />
	
   <script type="text/javascript">
    	$(function () {    
      //点击图片更换验证码  
       $("#Verify").click(function(){  
            $(this).attr("src","SecurityCodeImageAction.action?timestamp="+new Date().getTime());  
        });  
     });  

    </script>
    
    <script type="text/javascript">
		$(function(){
			document.forms[0].username.focus();
		});
	</script>
	
</HEAD>

<BODY LEFTMARGIN=0 TOPMARGIN=0 MARGINWIDTH=0 MARGINHEIGHT=0 CLASS=PageBody >
<s:form name="form" action="loginAction_login.action">
    <DIV ID="CenterAreaBg">
        <DIV ID="CenterArea">
         
            <DIV ID="LoginInfo">
                <TABLE BORDER=0 CELLSPACING=0 CELLPADDING=0 width=100%>
                <tr>
                		<td colspan="3"><!-- 显示错误 -->
							<font color="red"><s:fielderror><s:param>login1</s:param></s:fielderror></font>
							<font color="red"><s:fielderror><s:param>login2</s:param></s:fielderror></font>
                		</td>
                		<td>
                		</td>
                		
                </tr>
                    <TR>
                       
                        <TD CLASS="td1">用户名:</TD>
                        
                        <TD>
                           <input tableindex="1" class="userName" type="text" name="username" maxlength="19" onfocus="inputFocus(this)" onblur="inputBlur(this)"/>
                            
                        
                        </TD>
                        
                        
                    </TR>
                    <TR>
                        
                        <td class="td1">密　码:</td>
                        <td><input tableindex="2" class="password" type="password" name="password" maxlength="16" onfocus="inputFocus(this)" onblur="inputBlur(this)"/></td>
                        
                        
                    </TR>
                     <TR>
                        <td class="td1">验证码:</td>
                        <td>
                        <input tableindex="3" class="validate" type="text" name="validate" id="validate" maxlength="4" />
					    &nbsp;&nbsp;
					    <img style="cursor: pointer;" alt="点击图片修改验证码" align="absmiddle" id="Verify" name="random" src="SecurityCodeImageAction.action" /> 
					    
					    </td>
                    </TR>
                    <TR>
                        <td></td>
                          
                        <td>
                           <input tableindex="4" class="submit" value="" type="submit" />
                           &nbsp;&nbsp;&nbsp;&nbsp;
                           <input tableindex="5" class="reset" value="" type="reset" />
                        </td>
                    </TR>
                </TABLE>
            </DIV>
               <DIV ID="CopyRight"><A HREF="javascript:void(0)">&copy; 2014 版权所有 烽火狼</A></DIV>
        </DIV>
      
    </DIV>
</s:form>
</BODY>
</HTML>
