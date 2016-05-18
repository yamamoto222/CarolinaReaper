<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Event,java.util.List" %>
<!DOCTYPE html >
<html>
<head>
<meta charset=UTF-"8">

 <script language=javascript>
 function view(){
 var obj=document.getElementById('count');
 var str="";
 for(i=0;i<obj.value;i++){
 str+=document.getElementById('hiddenArea').innerHTML;
 }
 document.getElementById('viewArea').innerHTML=str;
 }
 </script>

<title>タイトル</title>
<STYLE type="text/css">
 <!--
.scr {
   overflow: scroll;   /* スクロール表示 */
   width : 600px;
   height: 200px;
 }
-->
</STYLE>
</head>
 <body onLoad="view()">
 <h1>タイトル</h1>
<h2>イベント一覧</h2>
<DIV class="scr">

<table border="1">
<thead>
	<tr>
		<th width="150">イベント名</th>
		<th width="100">幹事名</th>
		<th width="100">場所</th>
		<th width="80">締切日</th>
		<th width="400">備考</th>
	</tr>
</thead>
<tbody>

</tbody>

	</table>
</DIV>
<h2>イベント作成</h2>
<form action="/CarolinaReaper/EventCreation"  method="post">
<table>
<tr>
		<th>イベント名：</th>
		<td><input type="text" name="eventName" size="40" required maxlength="20">必須</td>
	</tr>
		<tr>
		<th>幹事者名：</th>
		<td><input type="text" name="organizarName" size="40" required maxlength="20">必須</td >
	</tr>
	<tr>
		<th>イベント作成者</th>
		<td><input type="text" name="autherName" size="40"  maxlength="20"></td >
	</tr>
	<tr>
		<th>場所：</th>
		<td> <input type="text" name="eventVenue" size="40" maxlength="20"></td>
	</tr>
	<tr>
		<th>一人分費用：</th>
		<td><input type="text" name="pricePerPerson" size="40" maxlength="20"><td>
	</tr>
	<tr>
		<th>投稿締切日：</th>
		<td><input type="number" name="deadlineYear" size="4" maxlength="4">年
			<input type="number" name="deadlineDayMonth" size="2"maxlength="2">月
			<input type="number" name="deadlineDay" size="2" maxlength="2">日
	</tr>

	<tr>
		<th> 備考：</th>
 		<td><textarea name="autherRemark" rows="3" cols="30"></textarea></td>
	</tr>
		<tr>
		<th>イベント一覧に載せる</th>
		<td>yes<input type="radio" name="eventOpenFlag" required value="1">
			no<input type="radio" name="eventOpenFlag" required value="0"></td>
	</tr>
	<tr>
		<th>幹事者用パスワード：</th>
		<td><input type="text" name="autherPass" size="20" required maxlength="20">必須</td>
	</tr>

		<th>候補日数</th></table>
		<tr>
		<td><select id="count" onChange="view()">
		<option value="1">1日分</option>
		<option value="2">2日分</option>
		<option value="3">3日分</option>
		<option value="4">4日分</option>
		<option value="5">5日分</option>
		<option value="6">6日分</option>
		<option value="7">7日分</option>
		<option value="8">8日分</option>
		<option value="9">9日分</option>
		<option value="10">10日分</option>
		<option value="11">11日分</option>
		<option value="12">12日分</option>
		<option value="13">13日分</option>
		<option value="14">14日分</option>
		<option value="15">15日分</option>
		<option value="16">16日分</option>
		<option value="17">17日分</option>
		<option value="18">18日分</option>
		<option value="19">19日分</option>
		<option value="20">20日分</option>
		<option value="21">21日分</option>
		<option value="22">22日分</option>
		<option value="23">23日分</option>
		<option value="24">24日分</option>
		<option value="25">25日分</option>
		<option value="26">26日分</option>
		<option value="27">27日分</option>
		<option value="28">28日分</option>
		<option value="29">29日分</option>
		<option value="30">30日分</option>
		</select><td>
		<div id="hiddenArea" style="display:none;">
		</tr>
		<tr>
		<table>
	 		<td><input type="number" name="year"  size="4" maxlength="4">年
				<input type="number"  name="month"  size="2" maxlength="2">月
				<input type="number"  name="day"  size="2"  maxlength="2">日
				<input type="number"  name="hour"  size="2" maxlength="2">時必須</td>
			</table>

		</tr>
 		</div>
 <div id="viewArea"></div>
<input  type="submit" value="イベントを作成する" >
</form>
 </body>