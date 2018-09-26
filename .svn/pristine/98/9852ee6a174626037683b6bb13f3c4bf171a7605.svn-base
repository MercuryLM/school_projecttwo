<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
%>
<HTML>
	<HEAD>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="<%=path %>/css/base.css" />
	</HEAD>
	
	<body>
		<form id="adminProductAction_save_do" name="Form1" action="<%=path %>/adminProduct_save.action" method="post" enctype="multipart/form-data">
			&nbsp;
			<table cellSpacing="1" cellPadding="5" width="100%" align="center" bgcolor="#D1DDAA" style="margin-top:8px">
			   <tr bgcolor="#E7E7E7">
					<td height="14" colspan="7" background="<%=path %>/images/tbg.gif">&nbsp;添加商品&nbsp;</td>
				</tr>
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						商品名称：
					</td>
					<td class="ta_01" bgColor="#FFFFFF">
						<input type="text" name="pname" value="" id="adminProductAction_save_do_logonName"/>
					</td>
					<td width="18%" align="center" bgColor="#f5fafe">
						是否热门：
					</td>
					<td class="ta_01" bgColor="#FFFFFF">
						<select name="is_hot">
							<option value="1">是</option>
							<option value="0">否</option>
						</select>
					</td>
				</tr>
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe">
						市场价格：
					</td>
					<td class="ta_01" bgColor="#FFFFFF">
						<input type="text" name="market_price" value="" id="adminProductAction_save_do_logonName"/>
					</td>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						商城价格：
					</td>
					<td class="ta_01" bgColor="#FFFFFF">
						<input type="text" name="shop_price" value="" id="adminProductAction_save_do_logonName"/>
					</td>
				</tr>
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe">
						商品图片：
					</td>
					<td class="ta_01" bgColor="#FFFFFF" colspan="3">
						<input type="file" name="upload" />
					</td>
				</tr>
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe">
						所属的二级分类：
					</td>
					<td class="ta_01" bgColor="#FFFFFF" colspan="3">
						<select name="csid">
							<s:iterator var="cs" value="csList">
								<option value="<s:property value="#cs.csid"/>"><s:property value="#cs.csname"/></option>
							</s:iterator>
						</select>
					</td>
				</tr>
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						商品描述：
					</td>
					<td class="ta_01" bgColor="#FFFFFF" colspan="3">
						<textarea name="pdesc" rows="5" cols="30"></textarea>
					</td>
				</tr>
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						    <td colspan="1" width="25%" bgcolor="#f5fafe" align="right">
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
</HTML>