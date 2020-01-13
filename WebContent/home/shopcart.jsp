<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>

		<title>购物车页面</title>

		<link href="../AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css" />
		<link href="../basic/css/demo.css" rel="stylesheet" type="text/css" />
		<link href="../css/cartstyle.css" rel="stylesheet" type="text/css" />
		<link href="../css/optstyle.css" rel="stylesheet" type="text/css" />

		<script type="text/javascript" src="../js/jquery.js"></script>

	</head>
		<!--顶部导航条 -->
		<div class="am-container header">
			<ul class="message-l">
				<div class="topMessage">
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
			</ul>
			<ul class="message-r">
				<div class="topMessage home">
					<div class="menu-hd"><a href="./home.jsp" target="_top" class="h">商城首页</a></div>
				</div>
				<div class="topMessage my-shangcheng">
					<div class="menu-hd MyShangcheng"><a href="../person/information.jsp" target="_top"><i class="am-icon-user am-icon-fw"></i>个人中心</a></div>
				</div>
				<div class="topMessage mini-cart">
					<div class="menu-hd"><a id="mc-menu-hd" href="./findCarts" target="_top"><i class="am-icon-shopping-cart  am-icon-fw"></i><span>购物车</span><strong id="J_MiniCartNum" class="h">0</strong></a></div>
				</div>
				<div class="topMessage favorite">
					<div class="menu-hd"><a href="#" target="_top"><i class="am-icon-heart am-icon-fw"></i><span>收藏夹</span></a></div>
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

			<!--购物车 -->
				<body>
			<div class="concent">
				<div id="cartTable">
					<div class="cart-table-th">
						<div class="wp">
							<div class="th th-chk">
								<div id="J_SelectAll1" class="select-all J_SelectAll">

								</div>
							</div>
							<div class="th th-item">
								<div class="td-inner">商品信息</div>
							</div>
							<div class="th th-price">
								<div class="td-inner">单价</div>
							</div>
							<div class="th th-amount">
								<div class="td-inner">数量</div>
							</div>
							<div class="th th-sum">
								<div class="td-inner">金额</div>
							</div>
							<div class="th th-op">
								<div class="td-inner">操作</div>
							</div>
						</div>
					</div>
					<div class="clear"></div>
					

		<s:iterator value="#session.cartGoods" status="status">
					<tr class="item-list">
						<div class="bundle  bundle-last ">
							<div class="clear"></div>
							<div class="bundle-main">
								<ul class="item-content clearfix">
									<li class="td td-chk">
										<div class="cart-checkbox ">
											<input class="check" id="J_CheckBox_170037950254" name="items[]" value="170037950254" type="checkbox">
											<label for="J_CheckBox_170037950254"></label>
										</div>
									</li>
									<li class="td td-item">
										<div class="item-pic">
											<a href="#" target="_blank" data-title="${name}" class="J_MakePoint" data-point="tbcart.8.12">
												<img src="..${picture}80x80.jpg" class="itempic J_ItemImg"></a>
										</div>
										<div class="item-info">
											<div class="item-basic-info">
											</div>
										</div>
									</li>
									<li class="td td-info">
										<div class="item-props item-props-can">
												<a href="#" target="_blank" title="${name}" class="item-title J_MakePoint" data-point="tbcart.8.11"><s:property value="name"/></a>
										</div>
									</li>
									<li class="td td-price">
										<div class="item-price price-promo-promo">
											<div class="price-content">
												<div class="price-line">
													<em class="J_Price price-now" tabindex="0"><s:property value="price"/></em>	
												</div>
											</div>
										</div>
									</li>
									<li class="td td-amount">
										<div class="amount-wrapper ">
											<div class="item-amount ">
												<div class="sl">
													<s:form action="updateCart" method="post" theme="simple">
														<s:hidden name="cart.cid" value="%{#session.carts[#status.index].cid}" />
														<s:hidden name="good.gid" value="%{id}" />
														<s:hidden name="cart.price" value="%{price}" />
														<s:textfield  style="width:20%;"  name="cart.num" value="%{#session.carts[#status.index].num}"/>
														<s:submit value="修改数量" theme="simple"/>
													</s:form>
												</div>
											</div>
										</div>
									</li>
									<li class="td td-sum">
										<div class="td-inner">
											<em tabindex="0" class="J_ItemSum number"><s:property value="%{#session.carts[#status.index].sumPrice}"/></em>
										</div>
									</li>
									<li class="td td-op">
										<div class="td-inner">									
											<s:form action="deleteCart" method="post" theme="simple">
												<s:hidden name="cart.cid" value="%{#session.carts[#status.index].cid}" />
												<s:submit value="删除"/>
											</s:form>
											
											<br/>
											<s:form action="settlement" method="post" theme="simple">
												<s:hidden name="cart.cid" value="%{#session.carts[#status.index].cid}" />
												<s:hidden name="order.gid" value="%{id}" />
												<s:hidden name="order.bid" value="%{#session.loginUser.id}" />
												<s:hidden name="order.num" value="%{#session.carts[#status.index].num}" />
												<s:hidden name="order.shopid" value="%{shop.shopid}" />
												<s:hidden name="order.price" value="%{price}" />
												<s:submit value="结算"/>
											</s:form>
										</div>
									</li>
								</ul>
							</div>
						</div>
					</tr>
					<div class="clear"></div>
	</s:iterator>

	</body>

</html>