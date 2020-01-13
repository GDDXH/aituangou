<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: DKnight
  Date: 2018/12/9
  Time: 12:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

    <!-- Required Stylesheets -->
    <link rel="stylesheet" type="text/css" href="../css/reset.css" media="screen" />
    <link rel="stylesheet" type="text/css" href="../css/text.css" media="screen" />
    <link rel="stylesheet" type="text/css" href="../css/fonts/ptsans/stylesheet.css" media="screen" />
    <link rel="stylesheet" type="text/css" href="../css/fluid.css" media="screen" />

    <link rel="stylesheet" type="text/css" href="../css/mws.style.css" media="screen" />
    <link rel="stylesheet" type="text/css" href="../css/icons/icons.css" media="screen" />

    <!-- Demo and Plugin Stylesheets -->
    <link rel="stylesheet" type="text/css" href="../css/demo.css" media="screen" />

    <link rel="stylesheet" type="text/css" href="../plugins/colorpicker/colorpicker.css" media="screen" />
    <link rel="stylesheet" type="text/css" href="../plugins/jimgareaselect/css/imgareaselect-default.css" media="screen" />
    <link rel="stylesheet" type="text/css" href="../plugins/fullcalendar/fullcalendar.css" media="screen" />
    <link rel="stylesheet" type="text/css" href="../plugins/fullcalendar/fullcalendar.print.css" media="print" />
    <link rel="stylesheet" type="text/css" href="../plugins/tipsy/tipsy.css" media="screen" />
    <link rel="stylesheet" type="text/css" href="../plugins/sourcerer/Sourcerer-1.2.css" media="screen" />
    <link rel="stylesheet" type="text/css" href="../plugins/jgrowl/jquery.jgrowl.css" media="screen" />
    <link rel="stylesheet" type="text/css" href="../plugins/spinner/spinner.css" media="screen" />
    <link rel="stylesheet" type="text/css" href="../css/jui/jquery.ui.css" media="screen" />

    <!-- Theme Stylesheet -->
    <link rel="stylesheet" type="text/css" href="../css/mws.theme.css" media="screen" />

    <!-- JavaScript Plugins -->

    <script type="text/javascript" src="../js/jquery-1.7.1.min.js"></script>

    <script type="text/javascript" src="../plugins/jimgareaselect/jquery.imgareaselect.min.js"></script>
    <script type="text/javascript" src="../plugins/jquery.dualListBox-1.3.min.js"></script>
    <script type="text/javascript" src="../plugins/jgrowl/jquery.jgrowl.js"></script>
    <script type="text/javascript" src="../plugins/jquery.filestyle.js"></script>
    <script type="text/javascript" src="../plugins/fullcalendar/fullcalendar.min.js"></script>
    <script type="text/javascript" src="../plugins/jquery.dataTables.js"></script>
    <!--[if lt IE 9]>
    <script type="text/javascript" src="../plugins/flot/excanvas.min.js"></script>
    <![endif]-->
    <script type="text/javascript" src="../plugins/flot/jquery.flot.min.js"></script>
    <script type="text/javascript" src="../plugins/flot/jquery.flot.pie.min.js"></script>
    <script type="text/javascript" src="../plugins/flot/jquery.flot.stack.min.js"></script>
    <script type="text/javascript" src="../plugins/flot/jquery.flot.resize.min.js"></script>
    <script type="text/javascript" src="../plugins/colorpicker/colorpicker.js"></script>
    <script type="text/javascript" src="../plugins/tipsy/jquery.tipsy.js"></script>
    <script type="text/javascript" src="../plugins/sourcerer/Sourcerer-1.2.js"></script>
    <script type="text/javascript" src="../plugins/jquery.placeholder.js"></script>
    <script type="text/javascript" src="../plugins/jquery.validate.js"></script>
    <script type="text/javascript" src="../plugins/jquery.mousewheel.js"></script>
    <script type="text/javascript" src="../plugins/spinner/ui.spinner.js"></script>
    <script type="text/javascript" src="../js/jquery-ui.js"></script>

    <script type="text/javascript" src="../plugins/elrte/js/elrte.min.js"></script>
    <script type="text/javascript" src="../plugins/elfinder/js/elfinder.min.js"></script>

    <link rel="stylesheet" type="text/css" href="../plugins/elrte/css/elrte.full.css" media="screen" />
    <link rel="stylesheet" type="text/css" href="../plugins/elfinder/css/elfinder.css" media="screen" />

    <script type="text/javascript" src="../js/mws.js"></script>
    <script type="text/javascript" src="../js/demo.js"></script>
    <script type="text/javascript" src="../js/themer.js"></script>

    <script type="text/javascript" src="../js/demo.formelements.js"></script>

    <title>修改密码</title>

</head>

<body>
<s:if test="%{#session.changePassError.equals(\"oldPass\")}">
    <script language="JavaScript" type="text/javascript">
        alert("旧密码不能为空")
    </script>
</s:if>
<s:elseif test="%{#session.changePassError.equals(\"oldPassError\")}">
    <script language="JavaScript" type="text/javascript">
        alert("旧密码错误")
    </script>
</s:elseif>
<s:elseif test="%{#session.changePassError.equals(\"password\")}">
    <script language="JavaScript" type="text/javascript">
        alert("新密码不能为空")
    </script>
</s:elseif>
<s:elseif test="%{#session.changePassError.equals(\"repassword\")}">
    <script language="JavaScript" type="text/javascript">
        alert("再次输入不能为空")
    </script>
</s:elseif>
<s:elseif test="%{#session.changePassError.equals(\"not_equal\")}">
    <script language="JavaScript" type="text/javascript">
        alert("两次密码不一致")
    </script>
</s:elseif>
<s:set name="changePassError" value="" scope="session"/>

<s:if test="%{#session.changePass.equals(\"success\")}">
    <script language="JavaScript" type="text/javascript">
        alert("密码修改成功")
    </script>
</s:if>
<s:elseif test="%{#session.changePass.equals(\"fail\")}">
    <script language="JavaScript" type="text/javascript">
        alert("密码修改失败")
    </script>
</s:elseif>
<s:set name="changePass" value="" scope="session"/>

<div id="mws-themer">
    <div id="mws-themer-hide"></div>
    <div id="mws-themer-content">
        <div class="mws-themer-section">
            <label for="mws-theme-presets">Presets</label> <select id="mws-theme-presets"></select>
        </div>
        <div class="mws-themer-separator"></div>
        <div class="mws-themer-section">
            <ul>
                <li><span>Base Color</span> <div id="mws-base-cp" class="mws-cp-trigger"></div></li>
                <li><span>Text Color</span> <div id="mws-text-cp" class="mws-cp-trigger"></div></li>
                <li><span>Text Glow Color</span> <div id="mws-textglow-cp" class="mws-cp-trigger"></div></li>
            </ul>
        </div>
        <div class="mws-themer-separator"></div>
        <div class="mws-themer-section">
            <ul>
                <li><span>Text Glow Opacity</span> <div id="mws-textglow-op"></div></li>
            </ul>
        </div>
        <div class="mws-themer-separator"></div>
        <div class="mws-themer-section">
            <button class="mws-button red small" id="mws-themer-getcss">Get CSS</button>
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

<div id="mws-header" class="clearfix">
    <div id="mws-logo-container">
        <div id="mws-logo-wrap">
            <img src="../images/mws-logo.png" alt="mws admin" />
        </div>
    </div>

    <div id="mws-user-tools" class="clearfix">
        <div id="mws-user-info" class="mws-inset">
            <div id="mws-user-photo">
                <img src="../example/profile.jpg" alt="User Photo" />
            </div>
            <div id="mws-user-functions">
                <div id="mws-username">
                    Hello,
					<s:if test="%{#session.loginSeller.name!=null}">
                        <s:property value="#session.loginSeller.name"/>
                    </s:if>
                    <s:else>
                        <s:property value="#session.loginSeller.id"/>
                    </s:else>
                </div>
                <ul>
                    <li><a href="./person.jsp">个人中心</a></li>
                    <li><a href="./changePass.jsp">修改密码</a></li>
                    <li><a href="./login.jsp">登出</a></li>
                </ul>
            </div>
        </div>
    </div>
</div>

<div id="mws-wrapper">
    <div id="mws-sidebar-stitch"></div>
    <div id="mws-sidebar-bg"></div>
    <div id="mws-sidebar">
        <div id="mws-searchbox" class="mws-inset">
            <form action="http://www.malijuwebshop.com/themes/mws-admin/form_elements.html">
                <input type="text" class="mws-search-input" />
                <input type="submit" class="mws-search-submit" />
            </form>
        </div>
        <div id="mws-navigation">
            <ul>
                <li class="active"><a href="dashboard.jsp" class="mws-i-24 i-home">主页</a></li>
                <li><a href="allGoodInfo" class="mws-i-24 i-table-1">商品信息</a></li>
                <li><a href="allOrderInfo" class="mws-i-24 i-table-1">订单信息</a></li>
                <li>
                    <a href="#" class="mws-i-24 i-list">注册商品</a>
                    <ul>
                        <li><a href="./registerGood.jsp">注册商品</a></li>
                        <li><a href="goodCheck">审核情况</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>

    <div id="mws-container" class="clearfix">
        <div class="container">
            <form class="mws-form" action="changePass" method="post">
                <div class="mws-panel grid_4">
                    <div class="mws-panel-header">
                        <span class="mws-i-24 i-pencil">修改密码</span>
                    </div>
                    <div class="mws-panel-body">
                        <div class="mws-form-inline">
                            <div class="mws-form-row">
                                <label>旧密码</label>
                                <div class="mws-form-item large">
                                    <input type="password" name="oldPass" class="mws-textinput"/>
                                </div>
                            </div>

                            <div class="mws-form-row">
                                <label>新密码</label>
                                <div class="mws-form-item large">
                                    <input type="password" name="password" class="mws-textinput"/>
                                </div>
                            </div>

                            <div class="mws-form-row">
                                <label>再次输入</label>
                                <div class="mws-form-item large">
                                    <input type="password" name="repassword" class="mws-textinput"/>
                                </div>
                            </div>

                            <div class="mws-form-row">
                                <input type="submit" value="提交" style="float:right;" class="mws-button black"/>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
