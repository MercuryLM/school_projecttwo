<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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
        function addCategory(){
			window.location.href = "${pageContext.request.contextPath}/admin/category/add.jsp";
		}
       </script>
	</head>

	<body leftmargin="2" topmargin="2" background='<%=path %>/images/allbg.gif'>
			
			<table width='98%'  border='0'style="margin-top:8px;margin-left: 5px;">
			  <tr>
			    <td>
			       <%--  <form action="<%=path %>/banjiSearch.action" name="" method="post">
			           班级编号：<input type="text" name="classno" size="20"/>
			           <input type="submit" name="" value="查询"/>
			        </form> --%>
			    </td>
			  </tr>
		    </table>
		    
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="7" background="<%=path %>/images/tbg.gif">&nbsp;一级分类管理&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="20%">序号</td>
					<td width="35%">一级分类名称</td>
					<td width="8%">编辑</td>
					<td width="8%">删除</td>
		        </tr>	
				<s:iterator var="c" value="cList" status="status">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#status.count"/>
					</td>
					<td bgcolor="#FFFFFF"	 align="center">
						<s:property value="#c.cname"/>
					</td>
					
					<td bgcolor="#FFFFFF" align="center">
						<a href="<%=path %>/adminCategory_edit.action?cid=<s:property value="#c.cid"/>">
						<img src="<%=path %>/images/i_edit.gif" border="0" style="CURSOR: hand" />
						</a>
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    <a href="<%=path %>/adminCategory_delete.action?cid=<s:property value="#c.cid"/>">
					    <img src="<%=path %>/images/i_del.gif" width="16" height="16" border="0" style="CURSOR: hand" />
					    </a>
					</td>
				</tr>
				</s:iterator>
			</table>
			
			<table width='98%'  border='0'style="margin-top:8px;margin-left: 5px;">
			  <tr>
			    <td>
			      <input type="button" value="添加" style="width: 80px;" onclick="addCategory()" />
			    </td>
			  </tr>
		    </table>
	</body>
</html>
