<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">

		<title>商品页面</title>

		<link href="../AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet" type="text/css" />
		<link href="../AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css" />
		<link href="../basic/css/demo.css" rel="stylesheet" type="text/css" />
		<link type="text/css" href="../css/optstyle.css" rel="stylesheet" />
		<link type="text/css" href="../css/style.css" rel="stylesheet" />

		<script type="text/javascript" src="../basic/js/jquery-1.7.min.js"></script>
		<script type="text/javascript" src="../basic/js/quick_links.js"></script>

		<script type="text/javascript" src="../AmazeUI-2.4.2/assets/js/amazeui.js"></script>
		<script type="text/javascript" src="../js/jquery.imagezoom.min.js"></script>
		<script type="text/javascript" src="../js/jquery.flexslider.js"></script>
		<script type="text/javascript" src="../js/list.js"></script>

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
					<div class="menu-hd MyShangcheng"><a href="../person/information.jsp" target="_top"><i class="am-icon-user am-icon-fw"></i>个人中心</a></div>
				</div>
				<div class="topMessage mini-cart">
					<div class="menu-hd"><a id="mc-menu-hd" href="./findCarts" target="_top"><i class="am-icon-shopping-cart  am-icon-fw"></i><span>购物车</span><strong id="J_MiniCartNum" class="h"></strong></a></div>
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
            <b class="line"></b>
			<div class="listMain">

				<!--分类-->
			<div class="nav-table">
					   <div class="long-title"><span class="all-goods">全部分类</span></div>
					   <div class="nav-cont">
							<ul>
								<li class="index"><a href="/home/home.jsp">首页</a></li>
                                <li class="qc"><a href="#">闪购</a></li>
                                <li class="qc"><a href="#">限时抢</a></li>
                                <li class="qc"><a href="#">团购</a></li>
                                <li class="qc last"><a href="#">大包装</a></li>
							</ul>
						    <div class="nav-extra">
						    	<i class="am-icon-user-secret am-icon-md nav-user"></i><b></b>我的福利
						    	<i class="am-icon-angle-right" style="padding-left: 10px;"></i>
						    </div>
						</div>
			</div>
				<ol class="am-breadcrumb am-breadcrumb-slash">
					<li><a href="/home/home.jsp">首页</a></li>
					<li><a href="#">分类</a></li>
					<li class="am-active">内容</li>
				</ol>
				<script type="text/javascript">
					$(function() {});
					$(window).load(function() {
						$('.flexslider').flexslider({
							animation: "slide",
							start: function(slider) {
								$('body').removeClass('loading');
							}
						});
					});
				</script>
				<div class="scoll">
					<section class="slider">
						<div class="flexslider">
							<ul class="slides">
								<li>
									<img src="..${good.picture}350x350.jpg" title="pic" />
								</li>
								<li>
									<img src="../images/03.jpg" />
								</li>
							</ul>
						</div>
					</section>
				</div>

				<!--放大镜-->

				<div class="item-inform">
					<div class="clearfixLeft" id="clearcontent">

						<div class="box">
							<script type="text/javascript">
								$(document).ready(function() {
									$(".jqzoom").imagezoom();
									$("#thumblist li a").click(function() {
										$(this).parents("li").addClass("tb-selected").siblings().removeClass("tb-selected");
										$(".jqzoom").attr('src', $(this).find("img").attr("mid"));
										$(".jqzoom").attr('rel', $(this).find("img").attr("big"));
									});
								});
							</script>

							<div class="tb-booth tb-pic tb-s310">
								<a href="..${good.picture}800x800.jpg"><img src="..${good.picture}350x350.jpg" alt="细节展示放大镜特效" rel="..${good.picture}800x800.jpg" class="jqzoom" /></a>
							</div>
							<ul class="tb-thumb" id="thumblist">
								<li class="tb-selected">
									<div class="tb-pic tb-s40">
										<a href="#"><img src="..${good.picture}60x60.jpg" mid="..${good.picture}350x350.jpg" big="../${good.picture}800x800.jpg"></a>
									</div>
								</li>
								<li>
									<div class="tb-pic tb-s40">
										<a href="#"><img src="../images/03_small.jpg" mid="../images/03_mid.jpg" big="../images/03.jpg"></a>
									</div>
								</li>
							</ul>
						</div>

						<div class="clear"></div>
					</div>

					<div class="clearfixRight">

						<!--规格属性-->
						<!--名称-->
						<div class="tb-detail-hd">
							<h1>	
				                <s:property value="good.name"/>
                            </h1>
						</div>
						<div class="tb-detail-list">
							<!--价格-->
							<div class="tb-detail-price">
								<li class="price iteminfo_price">
									<dt>促销价</dt>
									<dd><em>¥</em><b class="sys_item_price"><s:property value="good.price"/> </b>  </dd>
								</li>
								<li class="price iteminfo_mktprice">
									<dt>原价</dt>
									<dd><em>¥</em><b class="sys_item_mktprice"><s:property value="good.price"/></b></dd>									
								</li>
								<div class="clear"></div>
							</div>

							<!--地址-->
							<dl class="iteminfo_parameter freight">
								<dt>配送至</dt>
								<div class="iteminfo_freprice">
									<div class="am-form-content address">
										<select data-am-selected>
											<option value="a">浙江省</option>
											<option value="b">湖北省</option>
										</select>
										<select data-am-selected>
											<option value="a">温州市</option>
											<option value="b">武汉市</option>
										</select>
										<select data-am-selected>
											<option value="a">瑞安区</option>
											<option value="b">洪山区</option>
										</select>
									</div>
									<div class="pay-logis">
										快递<b class="sys_item_freprice">10</b>元
									</div>
								</div>
							</dl>
							<div class="clear"></div>

							<!--销量-->
							<ul class="tm-ind-panel">
								<li class="tm-ind-item tm-ind-sumCount canClick">
									<div class="tm-indcon"><span class="tm-label">累计销量</span><span class="tm-count"><s:property value="good.sales"/> </span></div>
								</li>
								<li class="tm-ind-item tm-ind-reviewCount canClick tm-line3">
									<div class="tm-indcon"><span class="tm-label">累计评价</span><span class="tm-count">640</span></div>
								</li>
							</ul>
							<div class="clear"></div>
						</div>

						<div class="pay">
					
							<!-- 店铺id：<s:property value="good.shop.shopid"/> -->
							库存:<s:property value="good.num"/>
							<br>
								<s:form action="buyNow" method="post" theme="simple" >
									<s:hidden name="order.gid" value="%{good.id}" />
									数量:<s:textfield style="width:10%;" name="order.num" type="text" value="1"/>
									<s:hidden name="order.bid" value="%{#session.loginUser.id}" />
									<s:hidden name="order.shopid" value="%{good.shop.shopid}" />
									<s:hidden name="order.price" value="%{good.price}" />
									<s:submit value="立即购买"/>
								</s:form>
							<br>
								<s:form action="addGoods" method="post" theme="simple">
									<s:hidden name="good.id" value="%{good.id}" />
									数量:<s:textfield style="width:10%;" name="cart.num" type="text" value="1"/>
									<s:hidden name="cart.price" value="%{good.price}" />
									<s:submit  value="加入购物车"/>
								</s:form>
							<br>
							<s:if test="%{good.state!=1}">
	                                <s:form action="#" method="post" theme="simple">
										<s:hidden name="good.id" value="%{good.id}" />
										<s:submit value="请求开团"/>
									</s:form>           
                        	</s:if>
                        	<s:else>
	                           		<s:form action="addGroup" method="post" theme="simple">
										<s:hidden name="group.goodId" value="%{good.id}" />
										<s:hidden name="order.gid" value="%{good.id}" />
										团购价格:<s:property value="gGoods.gprice"/>&nbsp;&nbsp;
										购买数量:1
										<s:hidden name="order.bid" value="%{#session.loginUser.id}" />
										<s:hidden name="group.bid1" value="%{#session.loginUser.id}" />
										<s:hidden name="order.shopid" value="%{good.shop.shopid}" />
										
										<s:submit value="发起团购"/>
									</s:form>
                        	</s:else>
						</div>

					</div>

					<div class="clear"></div>

				</div>

				<!--拼团信息-->
				<div class="match">
					<div class="match-title">目前拼团信息</div>
					<div class="match-comment">
							<s:if test="%{#session.groups!=null}">
	                            <s:iterator value="#session.groups" var="group">
		                            <ul class="like_list">
										<li>
										
										<s:form action="joinGroup" method="post" theme="simple">
											<s:property value="%{#group.bid1}"/> 还差1人拼成
											<s:hidden name="group.groupId" value="%{#group.groupId}"/>
											<s:hidden name="group.goodId" value="%{good.id}" />
											<s:hidden name="order.gid" value="%{good.id}" />
											<s:hidden name="order.bid" value="%{#session.loginUser.id}" />
											<s:hidden name="group.bid2" value="%{#session.loginUser.id}" />
											<s:hidden name="order.shopid" value="%{good.shop.shopid}" />
											<s:submit value="去拼团" theme="simple"/>
										</s:form>
										</li>
									</ul>
								</s:iterator>
	                        </s:if>
	                        <s:else>
	                                尚未有人拼团
	                        </s:else>
                     </div>
				</div>	
	</body>
</html>