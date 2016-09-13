<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="js/jquery-3.1.0.min.js"></script>
</head>
<body>
	<div>
		<input id="queryData" type="text" /> <input id="btnQuery"
			type="button" value="查询" onclick="query()" />
	</div>
	<div>
		<form>
			<table id="tabShowData" border="1">
				<tr>
					<td><label id="title">名称</label></td>
					<td><label id="ratepositive">地址</label></td>
					<td><label>下载</label></td>
				</tr>
			</table>
		</form>
	</div>
</body>
<script type="text/javascript">
	$(function(){
	})
	
	function query(){
		var queryData = $("#queryData").val();
		var btn_query = $("#btnQuery");
		 $.post("<%=path%>/video/findVideo", {
			"title" : queryData
		}, function(data) {
			bingdingToTable2(data);
		}, "json");
	}

	function bingdingToTable(dataSource) {
		cleanTable();
		var table = $("#tabShowData");
		console.log(dataSource);
		for (var i = 0; i < dataSource.length; i++) {
			var tr = "<tr id="+dataSource[i].id+"><td>" + dataSource[i].title
					+ "</td><td>" + dataSource[i].Mp4Url
					+ "</td><td><input type='button' id="+dataSource[i].id+" value='下载' onclick='download("+dataSource[i].id+")'></td></tr>";
			table.append(tr);
		}
	}
	
	function bingdingToTable2(dataSource) {
		cleanTable();
		var table = $("#tabShowData");
		console.log(dataSource);
		for (var i = 0; i < dataSource.length; i++) {
			var tr = "<tr id="+dataSource[i].id+"><td>" + dataSource[i].title
					+ "</td><td><input type='button' id="+dataSource[i].id+" value='下载' onclick='openUrl("+dataSource[i].id+")'></td><td>" + dataSource[i].url
					+ "</td></tr>";
			table.append(tr);
		}
	}

	function cleanTable() {
		var table = $("#tabShowData");
		var trLength = $("div form table tr").length;
		for (var i = trLength; i > 1 ; i--){
			$("div form table tr:last").remove();
		}
	}
	
	function download(id){
		var tr = $("#"+id);
		var video ={};
		video.title = $("#"+id+" td:eq(0)").text();
		video.Mp4Url = $("#"+id+" td:eq(1)").text();
		 $.ajaxSetup({  
		        contentType : 'application/json'  
		    }); 
		 var data = JSON.stringify(video);
		$.post("<%=path%>/video/download",JSON.stringify(video),
				function(data){
			console.log(data);
		},"json"); 
	}
	
	function openUrl(id){
		var tr = $("#"+id);
		var url = $("#"+id+" td:eq(2)").text();
		window.open(url);
	};
</script>
</html>