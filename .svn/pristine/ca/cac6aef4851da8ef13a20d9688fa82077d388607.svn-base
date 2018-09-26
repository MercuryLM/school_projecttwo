<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page isELIgnored="false" %> 

<%
String path = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />
        
        <link rel="stylesheet" type="text/css" href="<%=path %>/css/base.css" />
        
        <script language="javascript">
        </script>
	</head>

	<body leftmargin="2" topmargin="9" background='<%=path %>/images/allbg.gif'>
			<form id="adminCategorySecondAction_save_do" name="Form1" action="<%=path %>/adminCategorySecond_save.action" method="post">
				     <table width="98%" align="center" border="0" cellpadding="4" cellspacing="1" bgcolor="#CBD8AC" style="margin-bottom:8px">
						<tr bgcolor="#EEF4EA">
					        <td colspan="4" class='title'><span>添加</span></td>
					    </tr>
						<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						    <td width="10%" bgcolor="#FFFFFF" align="left">
						        二级分类名称：
						    </td>
						    <td width="40%" bgcolor="#FFFFFF" align="left">
						        <input type="text" name="csname" value="" id="adminCategorySecondAction_save_do_logonName" size="20"/>
						    </td>
						    <td width="10%" bgColor="#FFFFFF" align="left">
							所属的一级分类：
							</td>
							<td width="40%" bgColor="#FFFFFF" >
								<select name="cid" style="width:60%">
									<s:iterator var="c" value="cList">
										<option value="<s:property value="#c.cid"/>"><s:property value="#c.cname"/></option>
									</s:iterator>
								</select>
							</td>
						</tr>
						<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						    <td colspan="1" width="25%" bgcolor="#FFFFFF" align="right">
						        &nbsp;
						    </td>
						    <td colspan="3" width="75%" bgcolor="#FFFFFF" align="left">
						       <input type="submit" value="提交"/>&nbsp; 
						       <input type="reset" value="重置"/>&nbsp;
						       <input type="button" onclick="history.go(-1)" value="返回"/>&nbsp;
						    </td>
						</tr>
					 </table>
			</form>
   </body>
</html>
