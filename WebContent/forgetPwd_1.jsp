<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>找回密码第一步</title>
<script  type="text/javascript">
	function checkForm(form){
		if(form.username.value==""){
			alert("请输入用户名！");form.username.focus();return false;
		}
	}
</script>
<style>
	#forgetPwd1{
		float:left;
		list-style: none;
		padding:50px 0px 0px 200px;
	}
	#forgetPwd1 li{
		float:left;
	
	}
</style>
<body  bgcolor="#F0F0F0">
<div id="box">
<%@ include file="top.jsp" %>
<%@ include file="register.jsp" %>
 <div id="forgetPwd" style="height:356px;">
<form name="form_forgetPwd" method="post" action="UserServlet?action=forgetPwd1" onsubmit="return checkForm(this)">
<ul id="forgetPwd1">
	<li style="padding-top:5px;">请输入用户名： </li>
	<li><input type="text" name="username"> </li>
	 <li style="padding-left:10px;">
	 <input name="Submit" type="submit"  value="下一步">
	</li>
</ul>
</form>
 </div>
 <%@ include file="bottom.jsp" %>
</div>
</body>
</html>