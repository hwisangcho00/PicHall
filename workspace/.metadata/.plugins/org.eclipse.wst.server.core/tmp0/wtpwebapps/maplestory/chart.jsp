<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table, th, td{
		border: 1px #000 solid;
		border-collapse: collapse;
		text-align:center;
	}
	
	table{
		width:1000px;
	}
	
	th{
		background-color: #C9C9C9
	}
</style>
</head>
<body>
	<h2>위습의 원더베리</h2>
	<h5>아이템을 클릭하면 해당 아이템만 그래프로 조회됩니다.</h5>
	
	<table>
		<tr>
			<th>아이템</th>
			<th>고지확률</th>
			<th>실제확률</th>
			<th>오차(%p)</th>
			<th>오차(%)</th>
		<tr>
		
		<tr>
			<td>고농축 프리미엄 생명의 물 (5689005)</td>
			<td>15.02 %</td>
			<td>15.061 %</td>
			<td class=pp>+0.041 %</td>
			<td class=p>+0.271 %</td>
		</tr>
		<tr>
			<td>오가닉 원더 쿠키 (5240169)</td>
			<td>15.02 %</td>
			<td>15.049 %</td>
			<td class=pp>+0.029 %</td>
			<td class=p>+0.191 %</td>
		</tr>
		<tr>
			<td>붕어빵단팥이 (5002229)</td>
			<td>12 %</td>
			<td>11.992 %</td>
			<td class=pp>-0.008 %</td>
			<td class=p>-0.067 %</td>
		</tr>
		<tr>
			<td>붕어빵크림이 (5002230)</td>
			<td>12 %</td>
			<td>12.016 %</td>
			<td class=pp>+0.016 %</td>
			<td class=p>-0.131 %</td>
		</tr>
		
	</table>
</body>
<script>

	window.onload = function() {
		var ppList = document.getElementsByClassName('pp')
		var pList = document.getElementsByClassName('p')
		
		Array.prototype.forEach.call(ppList, function(item){
			var text = item.innerHTML
			if(Number(text.substring(0,6))>0){
				item.style.color = "red";
			} else {
				item.style.color = "blue";
			}
		})
		
		Array.prototype.forEach.call(pList, function(item){
			var text = item.innerHTML
			if(Number(text.substring(0,6))>0){
				item.style.color = "red";
			} else {
				item.style.color = "blue";
			}
		})
	}
	
</script>
</html>