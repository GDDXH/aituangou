<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<s:head />

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>管理</title>
<link rel="stylesheet" type="text/css" href="css/reset.css"
	media="screen" />
<link rel="stylesheet" type="text/css" href="css/text.css"
	media="screen" />
<link rel="stylesheet" type="text/css"
	href="css/fonts/ptsans/stylesheet.css" media="screen" />
<link rel="stylesheet" type="text/css" href="css/fluid.css"
	media="screen" />

<link rel="stylesheet" type="text/css" href="css/core/login.css"
	media="screen" />
<link rel="stylesheet" type="text/css" href="css/core/core.css"
	media="screen" />
<link rel="stylesheet" type="text/css" href="css/core/panels.css"
	media="screen" />
<link rel="stylesheet" type="text/css" href="css/core/table.css"
	media="screen" />
<link rel="stylesheet" type="text/css" href="css/core/gallery.css"
	media="screen" />
<link rel="stylesheet" type="text/css" href="css/core/button.css"
	media="screen" />
<link rel="stylesheet" type="text/css" href="css/core/report.css"
	media="screen" />
<link rel="stylesheet" type="text/css" href="css/core/error.css"
	media="screen" />
<link rel="stylesheet" type="text/css" href="css/core/misc.css"
	media="screen" />
<link rel="stylesheet" type="text/css" href="css/core/themer.css"
	media="screen" />


<link rel="stylesheet" type="text/css" href="css/icons/icons.css"
	media="screen" />

<!-- Demo and Plugin Stylesheets -->
<link rel="stylesheet" type="text/css" href="css/demo.css"
	media="screen" />




<link rel="stylesheet" type="text/css"
	href="plugins/colorpicker/colorpicker.css" media="screen" />
<link rel="stylesheet" type="text/css"
	href="plugins/jimgareaselect/css/imgareaselect-default.css"
	media="screen" />
<link rel="stylesheet" type="text/css"
	href="plugins/fullcalendar/fullcalendar.css" media="screen" />
<link rel="stylesheet" type="text/css"
	href="plugins/fullcalendar/fullcalendar.print.css" media="print" />
<link rel="stylesheet" type="text/css" href="plugins/tipsy/tipsy.css"
	media="screen" />
<link rel="stylesheet" type="text/css"
	href="plugins/sourcerer/Sourcerer-1.2.css" media="screen" />
<link rel="stylesheet" type="text/css"
	href="plugins/jgrowl/jquery.jgrowl.css" media="screen" />
<link rel="stylesheet" type="text/css"
	href="plugins/spinner/spinner.css" media="screen" />
<link rel="stylesheet" type="text/css" href="css/jui/jquery.ui.css"
	media="screen" />

<!-- Theme Stylesheet -->
<link rel="stylesheet" type="text/css" href="css/mws.theme.css"
	media="screen" />

<!-- JavaScript Plugins -->

<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>

<script type="text/javascript"
	src="plugins/jimgareaselect/jquery.imgareaselect.min.js"></script>
<script type="text/javascript"
	src="plugins/jquery.dualListBox-1.3.min.js"></script>
<script type="text/javascript" src="plugins/jgrowl/jquery.jgrowl.js"></script>
<script type="text/javascript" src="plugins/jquery.filestyle.js"></script>
<script type="text/javascript"
	src="plugins/fullcalendar/fullcalendar.min.js"></script>
<script type="text/javascript" src="plugins/jquery.dataTables.js"></script>
<!--[if lt IE 9]>
<script type="text/javascript" src="plugins/flot/excanvas.min.js"></script>
<![endif]-->
<script type="text/javascript" src="plugins/flot/jquery.flot.min.js"></script>
<script type="text/javascript" src="plugins/flot/jquery.flot.pie.min.js"></script>
<script type="text/javascript"
	src="plugins/flot/jquery.flot.stack.min.js"></script>
<script type="text/javascript"
	src="plugins/flot/jquery.flot.resize.min.js"></script>
<script type="text/javascript" src="plugins/colorpicker/colorpicker.js"></script>
<script type="text/javascript" src="plugins/tipsy/jquery.tipsy.js"></script>
<script type="text/javascript" src="plugins/sourcerer/Sourcerer-1.2.js"></script>
<script type="text/javascript" src="plugins/jquery.placeholder.js"></script>
<script type="text/javascript" src="plugins/jquery.validate.js"></script>
<script type="text/javascript" src="plugins/jquery.mousewheel.js"></script>
<script type="text/javascript" src="plugins/spinner/ui.spinner.js"></script>
<script type="text/javascript" src="js/jquery-ui.js"></script>

<script type="text/javascript" src="js/mws.js"></script>
<script type="text/javascript" src="js/demo.js"></script>
<script type="text/javascript" src="js/themer.js"></script>

</head>
<body>
	
	<div id= "mws-themer">
		<div id="mws-themer-hide"></div>
		<div id="mws-themer-content">
			<div class="mws-themer-section">
				<label for="mws-theme-presets">Presets</label> <select
					id="mws-theme-presets"></select>
			</div>
			<div class="mws-themer-separator"></div>
			<div class="mws-themer-section">
				<ul>
					<li><span>Base Color</span>
						<div id="mws-base-cp" class="mws-cp-trigger"></div></li>
					<li><span>Text Color</span>
						<div id="mws-text-cp" class="mws-cp-trigger"></div></li>
					<li><span>Text Glow Color</span>
						<div id="mws-textglow-cp" class="mws-cp-trigger"></div></li>
				</ul>
			</div>
			<div class="mws-themer-separator"></div>
			<div class="mws-themer-section">
				<ul>
					<li><span>Text Glow Opacity</span>
						<div id="mws-textglow-op"></div></li>
				</ul>
			</div>
			<div class="mws-themer-separator"></div>
			<div class="mws-themer-section">
				<button class="mws-button red small" id="mws-themer-getcss">Get
					CSS</button>
			</div>
		</div>
		<div id="mws-themer-css-dialog">
			<div class="mws-form">
				<div class="mws-form-row" style="padding:0;">
					<div class="mws-form-item">
						<textarea cols="auto" rows="auto" readonly="readonly"></textarea>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Themer End -->


	<!-- Header Wrapper -->
	<div id="mws-header" class="clearfix">

		<!-- Logo Wrapper -->
		<div id="mws-logo-container">
			<div id="mws-logo-wrap">
				<img src="images/mws-logo.png" alt="mws admin" />
			</div>
		</div>

		<!-- User Area Wrapper -->
		<div id="mws-user-tools" class="clearfix">

			

			<!-- User Functions -->
			<div id="mws-user-info" class="mws-inset">
				<div id="mws-user-photo">
					<img src="example/profile.jpg" alt="User Photo" />
				</div>
				<div id="mws-user-functions">
					<div id="mws-username">
						Hello 
						<s:if test="%{#session.loginUser.aname!=null}">
							<s:property value="#session.loginUser.aname" />
						</s:if>
						<s:else>
							<s:property value="#session.loginUser.id" />
						</s:else>
					</div>
					<ul>
						
						<li><a href="./login.jsp">退出</a></li>
					</ul>
				</div>
			</div>
			<!-- End User Functions -->

		</div>
	</div>

	<!-- Main Wrapper -->
	<div id="mws-wrapper">
		<!-- Necessary markup, do not remove -->
		<div id="mws-sidebar-stitch"></div>
		<div id="mws-sidebar-bg"></div>

		<!-- Sidebar Wrapper -->
		<div id="mws-sidebar">

			
			<!-- Main Navigation -->
			<div id="mws-navigation">
				<ul>
					<li class="active"><a href=# class="mws-i-24 i-home">维护会员信息</a>
						<ul>
							<li><a href="./findBuyer.action">查询/删除会员信息</a></li>
							<li><a href="./addBuyer.jsp">添加会员信息</a></li>
							<li><a href="./beforeUpdate.action">更新会员信息</a></li>
						</ul>
					</li>


					<li><a href=# class="mws-i-24 i-chart">维护商家信息</a>
						<ul>
							<li><a href="./findSeller.action">查询/删除商家信息</a></li>
							<li><a href="./addSeller.jsp">添加商家信息</a></li>
							<li><a href="./beforeUpdateS.action">更新商家信息</a></li>
						</ul>
					</li>

					<li><a href="./findGoods.action"
						class="mws-i-24 i-day-calendar">维护商品信息</a>
						<ul>
							<li><a href="./findGoods.action">查询/删除商品信息</a></li>
							<li><a href="./findGoodchecks.action">审核商品</a>
							<li>
							<li><a href="./beforeUpdateG.action">更新商品信息</a></li>
						</ul>
					</li>
					<li><a href="./exit.action" class="mws-i-24 i-file-cabinet">退出登录</a></li>

				</ul>
			</div>
			<!-- End Navigation -->

		</div>





	</div>

</body>
</html>
