<!DOCTYPE HTML>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<meta http-equiv="pragma" content="no-cache" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="expires" content="0" />
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
<meta http-equiv="description" content="This is my page" />
<link rel="stylesheet" type="text/css" href="<%=path %>/css/base.css" />
<script src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.cookie.js"></script>
		<script type="text/javascript">
			function showDetail(oid){
				var but = $("#but"+oid);
				var div1 = $("#div"+oid);
				if(but.val() == "订单详情"){
					// 1.创建异步对象
					var xhr = createXmlHttp();
					// 2.设置监听
					xhr.onreadystatechange = function(){
						if(xhr.readyState == 4){
							if(xhr.status == 200){
								div1.html(xhr.responseText);
							}
						}
					}
					// 3.打开连接
					xhr.open("GET","<%=path %>/adminOrder_findOrderItem.action?oid="+oid+"&time="+new Date().getTime(),true);
					// 4.发送
					xhr.send(null);
					but.val("关闭");
				}else{
					div1.html("");
					but.val("订单详情");
				}
				
			}
			function createXmlHttp(){
				   var xmlHttp;
				   try{ // Firefox, Opera 8.0+, Safari
				        xmlHttp=new XMLHttpRequest();
				    }
				    catch (e){
					   try{// Internet Explorer
					         xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
					      }
					    catch (e){
					      try{
					         xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
					      }
					      catch (e){}
					      }
				    }

					return xmlHttp;
				 }
		</script>
	</HEAD>
	<body>
		<br>
		<form id="Form1" name="Form1" action="${pageContext.request.contextPath}/user/list.jsp" method="post">
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
			<tr bgcolor="#E7E7E7">
				<td height="14" colspan="7" align="center" background="<%=path %>/images/tbg.gif">&nbsp;订单列表&nbsp;</td>
			</tr>
						<tr align="center" style="bgcolor: #FAFAF1; height: 22">
								<tr align="center" style="bgcolor: #FAFAF1; height: 22">
									<td align="center" width="5%">
										序号
									</td>
									<td align="center" width="5%">
										订单编号
									</td>
									<td align="center" width="5%">
										订单金额
									</td>
									<td align="center" width="5%">
										收货人
									</td>
									<td align="center" width="10%">
										订单状态
									</td>
									<td align="center" width="70%">
										订单详情
									</td>
								</tr>
									<s:iterator var="o" value="pageBean.list" status="status">
										<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" style="height:22" >
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="15%">
												<s:property value="#status.count"/>
											</td>
											<td style="bgcolor: #FFFFFF; HEIGHT: 22px" align="center"
												width="15%">
												<s:property value="#o.oid"/>
											</td>
											<td style="bgcolor: #FFFFFF; HEIGHT: 22px" align="center"
												width="15%">
												<s:property value="#o.total"/>
											</td>
											<td style="bgcolor: #FFFFFF; HEIGHT: 22px" align="center"
												width="15%">
												<s:property value="#o.name"/>
											</td>
											<td style="bgcolor: #FFFFFF; HEIGHT: 22px" align="center"
												width="15%">
												<s:if test="#o.state==1">
													未付款
												</s:if>
												<s:if test="#o.state==2">
													<a href="<%=path %>/adminOrder_updateState.action?oid=<s:property value="#o.oid"/>"><font color="blue">发货</font></a>
												</s:if>
												<s:if test="#o.state==3">
													等待确认收货
												</s:if>
												<s:if test="#o.state==4">
													订单完成
												</s:if>
											
											</td>
											<td align="center" style="HEIGHT: 22px">
												<input type="button" value="订单详情" id="but<s:property value="#o.oid"/>" onclick="showDetail(<s:property value="#o.oid"/>)"/>
												<div id="div<s:property value="#o.oid"/>">
												</div>
											</td>
							
										</tr>
									</s:iterator>
					<tr align="center" style="bgcolor: #FFFFFF">
						<td colspan="7">
							第<s:property value="pageBean.page"/>/<s:property value="pageBean.totalPage"/>页 
							<s:if test="pageBean.page != 1">
								<a href="${ pageContext.request.contextPath }/adminOrder_findAll.action?page=1">首页</a>|
								<a href="${ pageContext.request.contextPath }/adminOrder_findAll.action?page=<s:property value="pageBean.page-1"/>">上一页</a>|
							</s:if>
							<s:if test="pageBean.page != pageBean.totalPage">
								<a href="${ pageContext.request.contextPath }/adminOrder_findAll.action?page=<s:property value="pageBean.page+1"/>">下一页</a>|
								<a href="${ pageContext.request.contextPath }/adminOrder_findAll.action?page=<s:property value="pageBean.totalPage"/>">尾页</a>|
							</s:if>
						</td>
					</tr>
				</TBODY>
			</table>
		</form>
	</body>
</HTML>

