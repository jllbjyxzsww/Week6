var customerId;
/**
 * @param {Object} id
 * 弹出编辑对话框
 */
function delDataDialog(id) {
	$('#delDialog').modal('show');
	customerId = id;
}
$('#delButton').on('click', function() {

});
/**
 * @param {Object} id
 * 弹出添加对话框
 */
function addDataDialog() {
	$('#addCustomerDialog').modal('show');

}

function addData() {
	var username = $("input[name=username]")[0].value;
	var job = $("input[name=job]")[0].value;
	var phone = $("input[name=phone]")[0].value;
	//json串{key：value}
	var data =JSON.stringify({ "username": username, "job":job,"phone" :"phone"});
	//jquery ajax用法
	$.ajax({
		// 请求方式
		type : "POST",
		/**
		 * 请求的媒体类型 1、 服务端需要返回一段普通文本给客户端，Content-Type="text/plain" 2
		 * 、服务端需要返回一段HTML代码给客户端 ，Content-Type="text/html" 3 、服务端需要返回一段XML代码给客户端
		 * ，Content-Type="text/xml" 4 、服务端需要返回一段javascript代码给客户端 5
		 * 、服务端需要返回一段json串给客户端
		 */
		contentType : "text/html;charset=UTF-8",
		// 请求地址
		url : "../Customer",
		//json
		dataType: "json",
		// 数据
		data : data,
		// 请求成功
		success : function(result) {
			alert("新增客户成功")
			$('#addUserDialog').modal('hide');

		},
		// 请求失败，包含具体的错误信息
		error : function(e) {
			console.log(e.status);
			console.log(e.responseText);
		}
	});
}
function getData() {
	$('#customerList')
			.DataTable(
					{
						"pagingType" : "full_numbers",
						"sLoadingRecords" : "正在加载数据...",
						"sZeroRecords" : "暂无数据",
						"ajax" : {
							"url" : "../Customer",
							"dataSrc" : ""
						},
						"columns" : [
								{
									"data" : "id"
								},
								{
									"data" : "userName"
								},
								{
									"data" : "jobs"
								},
								{
									"data" : "phone"
								},
								{
									"data" : null,
									"render" : function(data, type, row, meta) {
										var html = '<a  href="#" role="button" data-toggle="modal" onclick="editDataDialog('
												+ row.id
												+ ')"><i class="fa fa-pencil" ></i>修改</a>    '
												+ '<a href="#" role="button" data-toggle="modal"  onclick="delDataDialog('
												+ row.id
												+ ')"><i class="fa fa-trash-o"  ></i>删除</a>';
										return html;
									}
								}

						],
						"language" : {
							"processing" : "玩命加载中...",
							"lengthMenu" : "显示 _MENU_ 项结果",
							"zeroRecords" : "没有匹配结果",
							"info" : "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
							"infoEmpty" : "显示第 0 至 0 项结果，共 0 项",
							"infoFiltered" : "(由 _MAX_ 项结果过滤)",
							"infoPostFix" : "",
							"url" : "",
							"paginate" : {
								"first" : "首页",
								"previous" : "上一页",
								"next" : "下一页",
								"last" : "末页"
							}
						}
					});
}
