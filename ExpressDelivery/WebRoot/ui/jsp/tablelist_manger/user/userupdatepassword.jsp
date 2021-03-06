<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>用户找回密码</title>
<jsp:include page="/ui/jsp/commont/head-script.jsp" />
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<jsp:include page="/ui/jsp/commont/head-script.jsp" />
<link href="ui/assets/css/pages/login.css" rel="stylesheet"
	type="text/css" />
</head>

<body class="login">
<% String userTelephone =(String)session.getAttribute("userTelephone");
if(userTelephone==null){
	response.setHeader("refresh", "0;" + basePath + "index.jsp");
}
%>
	<div class="content">
		<form action="user/modifyUserPassword" method="post">
			<h3>重置密码 -</h3>
			<p>新密码将作为您的登录密码</p>

			<div class="form-group">
				<label class="control-label visible-ie8 visible-ie9">密码</label>
				<div class="input-icon">
					<i class="fa fa-lock"></i>
					<input class="form-control placeholder-no-fix" type="password"
						autocomplete="off" id="register_password" placeholder="密码"
						name="password" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label visible-ie8 visible-ie9">确认密码</label>
				<div class="controls">
					<div class="input-icon">
						<i class="fa fa-check"></i>
						<input class="form-control placeholder-no-fix" type="password"
							autocomplete="off" placeholder="确认密码" name="rpassword"
							id="again_register_password" />
						<span class="Password_inconsistency"></span>
					</div>
				</div>
			</div>
			<div class="form-actions">
				<button type="reset" id="back-btn" class="btn">
					<i class="m-icon-swapleft"></i> 重置
				</button>
				<button type="submit" class="btn red pull-right" id="btn">
					确定 <i class="m-icon-swapright m-icon-white"></i>
				</button>
			</div>
		</form>
	</div>
	<jsp:include page="/ui/jsp/commont/foot-script.jsp" />
	<script type="text/javascript">
		$(function() {
			$("#btn").attr("disabled", true);
			$(".Password_inconsistency").html("");
			$("#again_register_password").bind(
					"change input",
					function() {
						var register_password = $("#register_password").val();
						var again_register_password = $(
								"#again_register_password").val();
						if (register_password == again_register_password) {
							$(".Password_inconsistency").html("");
							$("#btn").attr("disabled", false);
						} else {
							$("#btn").attr("disabled", true);
							$(".Password_inconsistency").html("两次密码不一致");
						}
					});
		});
	</script>
</body>

</html>
