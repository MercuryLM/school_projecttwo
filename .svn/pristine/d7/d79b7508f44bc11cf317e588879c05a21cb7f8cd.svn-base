<!DOCTYPE HTML>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="pragma" content="no-cache" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="expires" content="0" />
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
<meta http-equiv="description" content="This is my page" />
<link rel="stylesheet" type="text/css" href="<%=path %>/css/base.css" />
<script src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.cookie.js"></script>
		
    <script language="javascript">
	  function addProduct(){
		window.location.href = "<%=path %>/adminProduct_addPage.action";
	  }
       
       function deleteProduct(pid){
       	$.ajax("ajax-selectOrderitem",{
   	        data: {
   	        	pidValue: pid,
   	        },
   	        async: true,
   	        datatype: "json",
   	        success: function(data){
   	        	var a = "";
   	            if(data){
   	            	alert("该商品已被下单，不能删除！")
   	            }else{
   	            	window.location.href = "<%=path %>/adminProduct_delete.action?pid=" + pid;
   	            }
   	        },
   	        error: function(request) {
                   alert("系统异常 ");
               },
   	    })
       }
      </script>
</head>
	<body leftmargin="2" topmargin="2" background='<%=path %>/images/allbg.gif'>
		<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
			<tr bgcolor="#E7E7E7">
				<td height="14" colspan="7" align="center" background="<%=path %>/images/tbg.gif">&nbsp;商品列表&nbsp;</td>
			</tr>
			<tr align="center" style="bgcolor: #FAFAF1; height: 22">
				<td align="center" width="18%">序号</td>
				<td align="center" width="17%">商品图片</td>
				<td align="center" width="17%">商品名称</td>
				<td align="center" width="17%">商品价格</td>
				<td align="center" width="17%">是否热门</td>
				<td width="7%" align="center">编辑</td>
				<td width="7%" align="center">删除</td>
	        </tr>	
			<s:iterator var="p" value="pageBean.list" status="status">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" style="height:22" >
					<td style="bgcolor: #FFFFFF; HEIGHT: 22px" align="center"
						width="18%">
						<s:property value="#status.count"/>
					</td>
					<td style="bgcolor: #FFFFFF; HEIGHT: 22px" align="center"
						width="17%">
						<img width="40" height="45" src="<%=path %>/<s:property value="#p.image"/>" />
					</td>
					<td style="bgcolor: #FFFFFF; HEIGHT: 22px" align="center"
						width="17%">
						<s:property value="#p.pname"/>
					</td>
					<td style="bgcolor: #FFFFFF; HEIGHT: 22px" align="center"
						width="17%">
						<s:property value="#p.shop_price"/>
					</td>
					<td style="bgcolor: #FFFFFF; HEIGHT: 22px" align="center"
						width="17%">
						<s:if test="#p.is_hot==1">
							是
						</s:if>
						<s:else>
							否
						</s:else>
					</td>
					<td align="center" style="HEIGHT: 22px">
						<a href="<%=path %>/adminProduct_edit.action?pid=<s:property value="#p.pid"/>">
							<img src="<%=path %>/images/i_edit.gif" border="0" style="CURSOR: hand" />
						</a>
					</td>
			
					<td align="center" style="HEIGHT: 22px">
						<a href="#" onclick="deleteProduct('<s:property value="#p.pid"/>')">
							<img src="<%=path %>/images/i_del.gif" width="16" height="16" border="0" style="CURSOR: hand" />
						</a>
					</td>
				</tr>
			</s:iterator>	
		</table>
		
		<table width='98%'  border='0'style="margin-top:8px;margin-left: 5px;">
		  <tr>
		    <td>
		      <input type="button" value="添加" style="width: 80px;" onclick="addProduct()" />
		    </td>
		  </tr>
		  
		  <tr align="center">
				<td colspan="4">
					第<s:property value="pageBean.page"/>/<s:property value="pageBean.totalPage"/>页  
					<s:if test="pageBean.page != 1">
						<a href="${pageContext.request.contextPath }/adminProduct_findAll.action?page=1">首页</a> |
						<a href="${pageContext.request.contextPath }/adminProduct_findAll.action?page=<s:property value="pageBean.page-1"/>">上一页</a> |
					</s:if>
					<s:if test="pageBean.page != pageBean.totalPage">
					<a href="${pageContext.request.contextPath }/adminProduct_findAll.action?page=<s:property value="pageBean.page+1"/>">下一页</a> |
					<a href="${pageContext.request.contextPath }/adminProduct_findAll.action?page=<s:property value="pageBean.totalPage"/>">尾页</a> 
					</s:if>
				</td>
			</tr>
	    </table>
	</body>
</html>
