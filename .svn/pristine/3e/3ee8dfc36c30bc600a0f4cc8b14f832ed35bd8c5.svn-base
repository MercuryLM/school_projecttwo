<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>网上商城管理中心</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="${pageContext.request.contextPath }/adminImage/Default.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath }/adminImage/xtree.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath }/adminImage/adminLogin.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath }/css/general.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath }/css/main.css" rel="stylesheet" type="text/css" />
<script language="JavaScript">
<!--
  document.forms['theForm'].elements['username'].focus();
  
  /**
   * 检查表单输入的内容
   */
  function validate()
  {
    var validator = new Validator('theForm');
    validator.required('username', user_name_empty);
    //validator.required('password', password_empty);
    if (document.forms['theForm'].elements['captcha'])
    {
      validator.required('captcha', captcha_empty);
    }
    return validator.passed();
  }
  
//-->
</script>
<style type="text/css">
body {
  color: white;
}
</style>
</head>
<body id="userlogin_body">
<form method="post" action="${pageContext.request.contextPath }/adminUser_login.action" target="_parent" name='theForm' onsubmit="return validate()">
<div id="user_login">
<s:actionerror/>
<dl>
  <dd id="user_top" />
  <ul>
    <li class="user_top_l"></li>
    <li class="user_top_c"></li>
    <li class="user_top_r"></li>
  </ul>
  <dd id="user_main" />
  <ul>
    <li class="user_main_l"></li>
    <li class="user_main_c">
    <div class="user_main_box">
    <ul>
      <li class="user_main_text">用户名： </li>
      <li class="user_main_input"><input class="TxtUserNameCssClass" name="username" type="text" /> </li></ul>
    <ul>
      <li class="user_main_text">密 码： </li>
      <li class="user_main_input"><input class="TxtPasswordCssClass" name="password" type="password" /> </li></ul>
    <%-- <ul>
      <li class="user_main_text">身份： </li>
      <li class="user_main_input"><select class="input_text" name="usertype">
							    <option value="-1" selected="selected">请选择登陆身份</option>
								<option value="0">管理员</option>
								<option value="1">老师</option>
								<option value="2">普通学生</option>
							 </select> </li></ul> --%>
							 </div>
	 </li>
    <li class="user_main_r">
    <input type="submit" class="IbtnEnterCssClass" id="ibtnEnter" style="border-top-width: 0px; border-left-width: 0px; border-bottom-width: 0px; border-right-width: 0px" 
    type="button"  name="ibtnenter" /> 
    </li></ul>
  <dd id="user_bottom">
  <ul>
    <li class="user_bottom_l"></li>
    <li class="user_bottom_c"><span style="margin-top: 40px"></span> </li>
    <li class="user_bottom_r"></li>
   </ul>
   </dd>
</dl>
</div>
   <span id="valrusername" style="display: none; color: red">
   </span><span id="valrpassword" style="display: none; color: red"></span>
   <span id="valrvalidatecode" style="display: none; color: red"></span>
<div id="validationsummary1" style="display: none; color: red"></div>
</form>
</body>
</html>