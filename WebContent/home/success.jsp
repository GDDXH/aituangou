<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
<title>付款成功页面</title>
<link rel="stylesheet"  type="text/css" href="../AmazeUI-2.4.2/assets/css/amazeui.css"/>
<link href="../AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet" type="text/css">
<link href="../basic/css/demo.css" rel="stylesheet" type="text/css" />
<link href="../css/sustyle.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../basic/js/jquery-1.7.min.js"></script>
</head>
<body>
<!--顶部导航条 -->
<div class="am-container header">
  <ul class="message-l">
    <div class="topMessage">
     <div class="menu-hd">
      <div class="menu-hd">
							<s:if test="%{#session.loginUser.name!=null}">
                                欢迎您，<s:property value="#session.loginUser.name"/>！
                                <a href="./buyerExit.action">退出登录</a>
                            </s:if>
                            <s:elseif test="%{#session.loginUser.id!=null}">
                                欢迎您，<s:property value="#session.loginUser.id"/>！
                                <a href="./buyerExit.action">退出登录</a>
                            </s:elseif>
                            <s:else>
                                <a href="/home/login.jsp" target="_top" class="h">亲，请登录</a>
                                <a href="/home/register.jsp" target="_top">免费注册</a>
                            </s:else>
		</div>
     </div>
    </div>
  </ul>
  <ul class="message-r">
    <div class="topMessage home"><div class="menu-hd"><a href="./home.jsp" target="_top" class="h">商城首页</a></div></div>
    <div class="topMessage my-shangcheng"><div class="menu-hd MyShangcheng"><a href="../person/information.jsp" target="_top"><i class="am-icon-user am-icon-fw"></i>个人中心</a></div></div>
    <div class="topMessage mini-cart"><div class="menu-hd"><a id="mc-menu-hd" href="./findCarts" target="_top"><i class="am-icon-shopping-cart  am-icon-fw"></i><span>购物车</span><strong id="J_MiniCartNum" class="h">0</strong></a></div></div>
    <div class="topMessage favorite"><div class="menu-hd"><a href="#" target="_top"><i class="am-icon-heart am-icon-fw"></i><span>收藏夹</span></a></div>
  </ul>
</div>

<!--悬浮搜索框-->

<div class="nav white">
	<div class="logo"><img src="../images/logo.png" /></div>
    <div class="logoBig">
      <li><img src="../images/logobig.png" /></li>
    </div>
    
    <div class="search-bar pr">
        <a name="index_none_header_sysc" href="#"></a>       
					<form action="search?sort=main" method="post">
						<input id="searchInput" name="name" type="text" placeholder="搜索" autocomplete="off">
						<input id="ai-topsearch" class="submit am-btn" value="搜索" index="1" type="submit">
					</form>
    </div>     
</div>

<div class="clear"></div>



<div class="take-delivery">
 <div class="status">
   <h2>您已成功付款</h2>
   <div class="successInfo">
     <ul>
       <div class="user-info">
         <p>收货人：<s:property value="#session.loginUser.name"/></p>
         <p>联系电话：<s:property value="#session.loginUser.telephone"/></p>
         <p>收货地址：<s:property value="#session.loginUser.address"/></p>
       </div>
             请认真核对您的收货信息，如有错误联系客服                       
     </ul>
    </div>
  </div>
</div>
</body>
</html>
