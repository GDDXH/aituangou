<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

	<head lang="en">
		<meta charset="UTF-8">
		<title>登录</title>
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<metad name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
		<meta name="format-detection" content="telephone=no">
		<meta name="renderer" content="webkit">
		<meta http-equiv="Cache-Control" content="no-siteapp" />

		<link rel="stylesheet" href="../AmazeUI-2.4.2/assets/css/amazeui.css" />
		<link href="../css/dlstyle.css" rel="stylesheet" type="text/css">
        <script language="JavaScript" type="text/javascript">
            function submit() {
                document.getElementById("loginForm").submit();
                $("#loginForm").submit();
            }
        </script>
	</head>

	<body>
        <s:if test="%{#session.loginError.equals(\"id\")}">
            <script language="JavaScript" type="text/javascript">
                alert("账号不能为空")
            </script>
        </s:if>
        <s:elseif test="%{#session.loginError.equals(\"password\")}">
            <script language="JavaScript" type="text/javascript">
                alert("密码不能为空")
            </script>
        </s:elseif>
        <s:elseif test="%{#session.loginError.equals(\"fail\")}">
            <script language="JavaScript" type="text/javascript">
                alert("账号或密码错误")
            </script>
        </s:elseif>
        <s:set name="loginError" value="" scope="session"/>
		<div class="login-boxtitle">
			<a href="home.jsp"><img alt="logo" src="../images/logobig.png" /></a>
		</div>

		<div class="login-banner">
			<div class="login-main">
				<div class="login-banner-bg"><span></span><img src="../images/big.jpg" /></div>
				<div class="login-box">

					<h3 class="title">登录商城</h3>

                    <div class="clear"></div>

                    <div class="login-form">
                        <form id="loginForm" action="buyerLogin" method="post">
                           <div class="user-name">
                                <input type="text" name="loginUser.id" id="user" placeholder="用户名">
                           </div>
                            <div class="user-pass">
                                <input type="password" name="loginUser.password" id="password" placeholder="请输入密码">
                            </div>
                        </form>
                    </div>

                    <div class="login-links">
                        <label for="remember-me"><input id="remember-me" type="checkbox">记住密码</label>
                        <a href="#" class="am-fr">忘记密码</a>
                        <a href="register.jsp" class="zcnext am-fr am-btn-default">注册</a>
                        <br />
                    </div>
                    <div class="am-cf">
                        <input type="button" name="" value="登 录" class="am-btn am-btn-primary am-btn-sm" onclick="submit()">
                    </div>
				</div>
			</div>
		</div>


        <div class="footer ">
            <div class="footer-hd ">
            </div>
            <div class="footer-bd ">
            </div>
        </div>
	</body>

</html>