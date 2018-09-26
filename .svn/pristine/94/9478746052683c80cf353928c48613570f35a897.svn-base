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
        function addCategorySecond(){
			window.location.href = "${pageContext.request.contextPath}/adminCategorySecond_addPage.action";
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
					<td height="14" colspan="7" background="<%=path %>/images/tbg.gif">&nbsp;二级分类管理&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="20%">序号</td>
					<td width="35%">二级级分类名称</td>
					<td width="8%">编辑</td>
					<td width="8%">删除</td>
		        </tr>	
				<s:iterator var="cs" value="pageBean.list" status="status">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#status.count"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#cs.csname"/>
					</td>
					
					<td bgcolor="#FFFFFF" align="center">
						<a href="<%=path %>/adminCategorySecond_edit.action?csid=<s:property value="#cs.csid"/>">
						<img src="<%=path %>/images/i_edit.gif" border="0" style="CURSOR: hand" />
						</a>
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    <a href="<%=path %>/adminCategorySecond_delete.action?csid=<s:property value="#cs.csid"/>">
					    <img src="<%=path %>/images/i_del.gif" width="16" height="16" border="0" style="CURSOR: hand" />
					    </a>
					</td>
				</tr>
				</s:iterator>
			</table>
			
			<table width='98%'  border='0'style="margin-top:8px;margin-left: 5px;">
			  <tr>
			    <td>
			      <input type="button" value="添加" style="width: 80px;" onclick="addCategorySecond()" />
			    </td>
			  </tr>
			  
			  <tr align="center">
						<td colspan="4">
							第<s:property value="pageBean.page"/>/<s:property value="pageBean.totalPage"/>页  
							<s:if test="pageBean.page != 1">
								<a href="${pageContext.request.contextPath }/adminCategorySecond_findAll.action?page=1">首页</a> |
								<a href="${pageContext.request.contextPath }/adminCategorySecond_findAll.action?page=<s:property value="pageBean.page-1"/>">上一页</a> |
							</s:if>
							<s:if test="pageBean.page != pageBean.totalPage">
							<a href="${pageContext.request.contextPath }/adminCategorySecond_findAll.action?page=<s:property value="pageBean.page+1"/>">下一页</a> |
							<a href="${pageContext.request.contextPath }/adminCategorySecond_findAll.action?page=<s:property value="pageBean.totalPage"/>">尾页</a> 
							</s:if>
						</td>
					</tr>
		    </table>
	</body>
</html>
