<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0 ,minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">

		<title>结算页面</title>

		<link href="../AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css" />

		<link href="../basic/css/demo.css" rel="stylesheet" type="text/css" />
		<link href="../css/cartstyle.css" rel="stylesheet" type="text/css" />

		<link href="../css/jsstyle.css" rel="stylesheet" type="text/css" />

		<script type="text/javascript" src="../js/address.js"></script>

	</head>

	<body>

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
					<div class="menu-hd MyShangcheng"><a href="../person/inforation.jsp" target="_top"><i class="am-icon-user am-icon-fw"></i>个人中心</a></div>
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
			<div class="concent">
				<!--地址 -->
				<div class="paycont">
					<div class="address">
						<div class="clear"></div>
						<ul>
							<li class="user-addresslist defaultAddr">

								<div class="address-left">
									<div class="user DefaultAddr">

										<span class="buy-address-detail">   
                   <span class="buy-user"><s:property value="#session.loginUser.name"/></span>
										<span class="buy-phone"><s:property value="#session.loginUser.telephone"/></span>
										</span>
									</div>
									<div class="default-address DefaultAddr">
										<span class="buy-line-title buy-line-title-type">收货地址：</span>
										<span class="buy--address-detail">
								   			<span class="province"><s:property value="#session.loginUser.address"/></span>
										</span>
									</div>
								</div>
								<div class="clear"></div>
							</li>
						</ul>
						<div class="clear"></div>
					</div>
					

					<!--订单 -->
					<div class="concent">
						<div id="payTable">
							<h3>确认订单信息</h3>
							<div class="cart-table-th">
								<div class="wp">

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
									<div class="th th-oplist">
										<div class="td-inner">配送方式</div>
									</div>

								</div>
							</div>
							<div class="clear"></div>

							<tr class="item-list">
								<div class="bundle  bundle-last">
									<div class="bundle-main">
										<ul class="item-content clearfix">
											<div class="pay-phone">
												<li class="td td-item">
													<div class="item-pic">
														<a href="#" class="J_MakePoint">
															<img  src="..<s:property value="%{#session.submitOrderGood.picture}"/>80x80.jpg" class="itempic J_ItemImg"></a>
													</div>
													<div class="item-info">
														<div class="item-basic-info">
															<a href="#" class="item-title J_MakePoint" data-point="tbcart.8.11"><s:property value="%{#session.submitOrderGood.name}"/></a>
														</div>
													</div>
												</li>
												<li class="td td-info">
													<div class="item-props">
														<s:property value="name"/>
													</div>
												</li>
												<li class="td td-price">
													<div class="item-price price-promo-promo">
														<div class="price-content">
															<em class="J_Price price-now" tabindex="0"><s:property value="order.price"/></em>
														</div>
													</div>
												</li>
											</div>
											<li class="td td-amount">
												<div class="amount-wrapper ">
													<div class="item-amount ">
														<span class="phone-title">购买数量</span>
														<div class="sl">
															<em class="J_Price price-now" tabindex="0"><s:property value="order.num"/></em>
														</div>
													</div>
												</div>
											</li>
											<li class="td td-sum">
												<div class="td-inner">
													<s:property value="order.sumPrice"/>
												</div>
											</li>
											<li class="td td-oplist">
												<div class="td-inner">
													<span class="phone-title">配送方式</span>
													<div class="pay-logis">
														<b class="sys_item_freprice">免邮</b>
													</div>
												</div>
											</li>

										</ul>
										<div class="clear"></div>

									</div>
							</tr>
							<div class="clear"></div>
							</div>

							</div>

							<!--含运费小计 -->
							<div class="buy-point-discharge ">
								<p class="price g_price ">
									合计 <span>¥</span><em class="pay-sum"><s:property value="order.sumPrice"/></em>
								</p>
							</div>

							<!--信息 -->
							<div class="order-go clearfix">
								<div class="pay-confirm clearfix">
									<div class="box">
										<div tabindex="0" id="holyshit267" class="realPay"><em class="t">实付款：</em>
											<span class="price g_price ">
                                    <span>¥</span> <em class="style-large-bold-red " id="J_ActualFee"><s:property value="order.sumPrice"/></em>
											</span>
										</div>
									</div>

									<div id="holyshit269" class="submitOrder">
										<div class="go-btn-wrap">
										<s:form action="submitOrder"  method="post"  theme="simple">
											<!-- <a  href="/aituangou/submitOrder?order.gid=0" class="btn-go" tabindex="0" title="点击此按钮，提交订单">提交订单</a>  -->
											<s:submit value="提交订单"/>
										</s:form>
										</div>
									</div>
									<div class="clear"></div>
								</div>
							</div>
						</div>

						<div class="clear"></div>
					</div>
				</div>
			</div>
	</body>

</html>