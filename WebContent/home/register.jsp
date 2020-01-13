<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

	<head lang="en">
		<meta charset="UTF-8">
		<title>注册</title>
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
		<meta name="format-detection" content="telephone=no">
		<meta name="renderer" content="webkit">
		<meta http-equiv="Cache-Control" content="no-siteapp" />

		<link rel="stylesheet" href="../AmazeUI-2.4.2/assets/css/amazeui.min.css" />
		<link href="../css/dlstyle.css" rel="stylesheet" type="text/css">
		<script src="../AmazeUI-2.4.2/assets/js/jquery.min.js"></script>
		<script src="../AmazeUI-2.4.2/assets/js/amazeui.min.js"></script>
        <script language="JavaScript" type="text/javascript">
            function register() {
                document.getElementById("registerForm").submit();
                $("#registerForm").submit();
            }
        </script>

	</head>

	<body>
        <s:if test="%{#session.registerError.equals(\"id\")}">
            <script language="JavaScript" type="text/javascript">
                alert("账号不能为空")
            </script>
        </s:if>
        <s:elseif test="%{#session.registerError.equals(\"password\")}">
            <script language="JavaScript" type="text/javascript">
                alert("密码不能为空")
            </script>
        </s:elseif>
        <s:elseif test="%{#session.registerError.equals(\"repassword\")}">
            <script language="JavaScript" type="text/javascript">
                alert("两次密码不一致")
            </script>
        </s:elseif>
        <s:elseif test="%{#session.registerError.equals(\"fail\")}">
            <script language="JavaScript" type="text/javascript">
                alert("账号已存在")
            </script>
        </s:elseif>
        <s:set name="registerError" value="" scope="session"/>

		<div class="login-boxtitle">
			<a href="home.jsp"><img alt="" src="../images/logobig.png" /></a>
		</div>

		<div class="res-banner">
			<div class="res-main">
				<div class="login-banner-bg"><span></span><img src="../images/big.jpg" /></div>
				<div class="login-box">

						<div class="am-tabs" id="doc-my-tabs">
							<ul class="am-tabs-nav am-nav am-nav-tabs am-nav-justify">
								<li class="am-active"><a href="">邮箱注册</a></li>
								<li><a href="">手机号注册</a></li>
							</ul>

							<div class="am-tabs-bd">
								<div class="am-tab-panel am-active">
									<form action="register" method="post" id="registerForm">
										
                                        <div class="user-email">
                                                <label for="email"><i class="am-icon-envelope-o"></i></label>
                                                <input type="email" name="registerUser.id" id="email" placeholder="请输入邮箱账号">
                                        </div>
                                        <div class="user-pass">
                                            <label for="password"><i class="am-icon-lock"></i></label>
                                            <input type="password" name="registerUser.password" id="password" placeholder="设置密码">
                                        </div>
                                        <div class="user-pass">
                                            <label for="passwordRepeat"><i class="am-icon-lock"></i></label>
                                            <input type="password" name="registerUser.repassword" id="passwordRepeat" placeholder="确认密码">
                                        </div>
                                    </form>
                                    <div class="login-links">
										<label for="reader-me">
											<input id="reader-me" type="checkbox"> 点击表示您同意商城《服务协议》
										</label>
							  	    </div>
                                    <div class="am-cf">
                                        <input type="submit" name="" value="注册" class="am-btn am-btn-primary am-btn-sm am-fl" onclick="register()">
                                    </div>
								</div>

								<div class="am-tab-panel">
                                <form method="post">
                                    <div class="user-phone">
                                <label for="phone"><i class="am-icon-mobile-phone am-icon-md"></i></label>
                                <input type="tel" name="" id="phone" placeholder="请输入手机号">
                                    </div>
                                    <div class="verification">
                                        <label for="code"><i class="am-icon-code-fork"></i></label>
                                        <input type="tel" name="" id="code" placeholder="请输入验证码">
                                        <a class="btn" href="javascript:void(0);" onclick="sendMobileCode();" id="sendMobileCode">
                                            <span id="dyMobileButton">获取</span>
                                        </a>
                                    </div>
                                    <div class="user-pass">
                                        <label for="password"><i class="am-icon-lock"></i></label>
                                        <input type="password" name="" id="password" placeholder="设置密码">
                                    </div>
                                    <div class="user-pass">
                                        <label for="passwordRepeat"><i class="am-icon-lock"></i></label>
                                        <input type="password" name="" id="passwordRepeat" placeholder="确认密码">
                                    </div>
                                </form>
                            <div class="login-links">
                                <label for="reader-me">
                                    <input id="reader-me" type="checkbox"> 点击表示您同意商城《服务协议》
                                </label>
                            </div>
                            <div class="am-cf">
                                <input type="submit" name="" value="注册" class="am-btn am-btn-primary am-btn-sm am-fl">
                            </div>
								
                            <hr>
                        </div>

                        <script>
                            $(function() {
                                $('#doc-my-tabs').tabs();
                              })
                        </script>
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