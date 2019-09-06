<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title></title>
</head>
<body>
	<form name="icform" method="post">
		<div id="menubar">
			<div id="middleMenubar">
				<div id="innerMenubar">
					<div id="navMenubar">
						<ul>
							<li id="view"><a href="#" onclick="formSubmit('toview.action','_self');this.blur();">查看</a></li>
							<li id="new"><a href="#" onclick="formSubmit('tocreate.action','_self');this.blur();">新增</a></li>
							<li id="update"><a href="#" onclick="formSubmit('toupdate.action','_self');this.blur();">修改</a></li>
							<li id="delete"><a href="#" onclick="formSubmit('deleteById.action','_self');this.blur();">删除</a></li>
							<li id="delete"><a href="#" onclick="formSubmit('delete.action','_self');this.blur();">删除N</a></li>
							<li id="new"><a href="#" onclick="formSubmit('start.action','_self');this.blur();">启用</a></li>
							<li id="new"><a href="#" onclick="formSubmit('stop.action','_self');this.blur();">停用</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>

		<div class="textbox" id="centerTextbox">
			<div class="textbox-header">
				<div class="textbox-inner-header">
					<div class="textbox-title">
							生产厂家列表
					</div>
				</div>
			</div>
		</div>

		<span class="noprint">
			<div id="find_div" style="width:98%;">
				<fieldset>
					<legend>
						<font color="000">查询条件&nbsp;</font>
					</legend>
					<div style="width:98%;padding-top:7px;text-align:left;">
						类型：
						<select name="f_type" style="width:130px;heigh:30px;" dataType="下拉列表" dispName="查询条件">
							<option value='' selected>--请选择--</option>
							<option value='fullName'>全称</option>
							<option value='factoryName'>简称</option>
							<option value='contractor'>联系人</option>
							<option value='phone'>电话</option>
							<option value='mobile'>手机</option>
							<option value='fax'>传真</option>
							<option value='cnote'>说明</option>
						</select>
						内容：
						<input type="text" name="f_conditionStr" value="" size="30"
							onFocus="this.select();"
							onKeyDown="javascript:if(event.keyCode==13){ document.getElementById('btnFind').onclick(); }"
						/>
						<input id="btnFind" type="button" name="查询" value="查询">
						<input type="button" name="清空" value="清空" onclick="findReset();this.blur();">
					</div>
				</fieldset>
			</div>
		</span>

		<div>
			<input type="hidden"  name="size"  value="10" />
			<input type="hidden"  name="page"  value="1" />
		</div>

		<div class="eXtremeTable" >
			<table id="ec_table" class="tableRegion" width="98%" >
				<thead>
				<tr style="padding: 0px;" >
					<td colspan="10" >
						<table border="0"  cellpadding="0"  cellspacing="0"  width="100%" >
							<tr>
								<td class="statusBar" >找到${pageInfo.total}条记录, 显示 ${pageInfo.startRow} 到 ${pageInfo.endRow} </td>
								<td class="compactToolbar"  align="right" >
									<table border="0"  cellpadding="1"  cellspacing="2" >
										<tr>
											<td><a href="${ctx}/basicinfo/factory/list.action?page=1&size=${pageInfo.pageSize}" ><img src="${ctx}/images/table/firstPageDisabled.gif" style="border:0"/></a></td>
											<td><a href="${ctx}/basicinfo/factory/list.action?page=${pageInfo.pageNum-1}&size=${pageInfo.pageSize}"><img src="${ctx}/images/table/prevPageDisabled.gif"  style="border:0"/></a></td>
											<td><a href="${ctx}/basicinfo/factory/list.action?page=${pageInfo.pageNum+1}&size=${pageInfo.pageSize}"><img src="${ctx}/images/table/nextPage.gif"  style="border:0"  title="下一页"   /></a></td>
											<td><a href="${ctx}/basicinfo/factory/list.action?page=${pageInfo.pages}&size=${pageInfo.pageSize}"><img src="${ctx}/images/table/lastPage.gif"  style="border:0"  title="最后页"   /></a></td>
											<td><img src="${ctx}/images/table/separator.gif"  /></td>
											<td>
												<select name="ec_rd"  onchange="javascript:document.forms.icform.size.value=this.options[this.selectedIndex].value;document.forms.icform.page.value='1';document.forms.icform.setAttribute('action', '${ctx}/basicinfo/factory/list.action');document.forms.icform.setAttribute('method', 'post');document.forms.icform.submit()" >
													<option value="10"  <c:if test="${pageInfo.pageSize==10}">selected='selected'</c:if>>10</option>
													<option value="50"  <c:if test="${pageInfo.pageSize==50}">selected='selected'</c:if>>50</option>
													<option value="100" <c:if test="${pageInfo.pageSize==100}">selected='selected'</c:if>>100</option>
												</select>
											</td>
											<td><img src="../../images/table/separator.gif"  style="border:0"  alt="Separator" /></td>
											<td><a href="#"><img src="../../images/table/xls.gif"  style="border:0"  title="Export Excel"  alt="Excel" /></a></td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
						<td class="tableHeader"><input type="checkbox" name="selid" onclick="checkAll('id',this)"></td>
						<td class="tableHeader">序号</td>
						<td class="tableHeader">厂家全称</td>
						<td class="tableHeader">缩写</td>
						<td class="tableHeader">联系人</td>
						<td class="tableHeader">电话</td>
						<td class="tableHeader">手机</td>
						<td class="tableHeader">传真</td>
						<td class="tableHeader">验货员</td>
						<td class="tableHeader">状态</td>
					</tr>
				</thead>
				<tbody class="tableBody" >
					<c:forEach items="${pageInfo.list}" var="o" varStatus="status">
						<tr class="odd" onmouseover="this.className='highlight'" onmouseout="this.className='odd'" >
							<td><input type="checkbox" name="id" value="${o.id}"/></td>
							<td>${status.index+1}</td>
							<td><a href="toview.action?id=${o.id}">${o.fullName}</a></td>
							<td>${o.factoryName}</td>
							<td>${o.contacts}</td>
							<td>${o.phone}</td>
							<td>${o.mobile}</td>
							<td>${o.fax}</td>
							<td>${o.inspector}</td>
							<td>
								<c:if test="${o.state==1}"><a href="stop.action?id=${o.id}"><span style="color:green ">启用</span></a></c:if>
								<c:if test="${o.state==0}"><a href="start.action?id=${o.id}">停用</a></c:if>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</form>
</body>
</html>

