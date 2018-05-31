<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();//
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>用户</div>
<form action="/login" method="post" target="_self">
	用户名:<input type="text" name="username"><br>
	密码:<input type="text" name="password"><br>
	<input type="submit" value="登录">	
</form>
<form action="/sigup" method="post" target="_self">
	用户名:<input type="text" name="username"><br>
	密码:<input type="text" name="password"><br>
	地址:<input type="text" name="address"><br>
	<input type="submit" value="注册">	
</form>
<!-- <form action="/userUpdata" method="post" target="_self">
	id:<input type="text" name="id"><br>
	用户名:<input type="text" name="username"><br>
	密码:<input type="text" name="password"><br>
	地址:<input type="text" name="address"><br>
	<input type="submit" value="修改">	
</form><form action="/userSelect" method="post" target="_self">
	id:<input type="text" name="id"><br>
	<input type="submit" value="查询">	
</form> -->

<div>交易记录</div>
<form action="/saveTransaction" method="post" target="_self">
	发送人:<input type="text" name="sender"><br>
	接收人:<input type="text" name="recepient"><br>
	数量:<input type="text" name="ammount"><br>
	合约名:<input type="text" name="name"><br>
	合约类型:<input type="text" name="type"><br>
	<input type="submit" value="创建交易记录">	
</form>
<form action="/transactions" method="get" target="_self">
	<input type="submit" value="查询交易记录">	
</form>
<!-- <form action="/tradingRecordSelectSender" method="get" target="_self">
	发送人:<input type="text" name="sender"><br>
	<input type="submit" value="根据发送人查询">	
</form>
<form action="/tradingRecordSelectRecepient" method="get" target="_self">
	接收人:<input type="text" name="recepient"><br>
	<input type="submit" value="根据接收人查询">	
</form>
<form action="/tradingRecordSelectName" method="get" target="_self">
	合约名:<input type="text" name="name"><br>
	<input type="submit" value="根据合约名查询">	
</form> -->
<div>合约</div>
<form action="/saveContract" method="post" target="_self">
	发布人:<input type="text" name="publisher"><br>
	合约名:<input type="text" name="name"><br>
	合约功能:<input type="text" name="descriptioin"><br>
	合约地址:<input type="text" name="address"><br>
	合约类型:<input type="text" name="type"><br>
	<input type="submit" value="创建合约">	
</form>
<form action="/contracts" method="get" target="_self">
	<input type="submit" value="查询合约">	
</form>
<form action="/token" method="get" target="_self">
	<input type="submit" value="查询代币">	
</form>
<!-- <form action="/contractUpdate" method="post" target="_self">
	id:<input type="text" name="id"><br>
	发布人:<input type="text" name="publisher"><br>
	合约名:<input type="text" name="name"><br>
	合约功能:<input type="text" name="descriptioin"><br>
	合约地址:<input type="text" name="address"><br>
	合约类型:<input type="text" name="type"><br>
	<input type="submit" value="修改合约">	
</form>
<form action="/contractSelectPublisher" method="get" target="_self">
	发布人:<input type="text" name="publisher"><br>
	<input type="submit" value="根据发布人查询">	
</form>
<form action="/contractSelectName" method="get" target="_self">
	合约名:<input type="text" name="name"><br>
	<input type="submit" value="根据合约名查询">	
</form>
<form action="/contractSelectAddress" method="get" target="_self">
	合约地址:<input type="text" name="address"><br>
	<input type="submit" value="根据合约地址查询">	
</form> -->
</body>
</html>