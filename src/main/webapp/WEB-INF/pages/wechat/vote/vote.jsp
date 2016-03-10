<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="UTF-8">
<title>“女神”与“摄郎”火拼大金山</title>
<link rel="shortcut icon" type="image/x-icon" href="favicon.ico">
<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" name="viewport">
<meta content="no-cache,must-revalidate" http-equiv="Cache-Control">
<meta content="no-cache" http-equiv="pragma">
<meta content="0" http-equiv="expires">
<meta content="telephone=no, address=no" name="format-detection">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black-translucent">
<%@include file="../../../context/headWechat.jsp"%>

<script type="text/javascript" src="${webRoot}/resources/js/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="${webRoot}/resources/wechat/vote/timeCountDown.js"></script>
<script src="${webRoot}/resources/wechat/vote/pack.js"></script>
<script src="${webRoot}/resources/wechat/vote/pbl.js"></script>
<script type="text/javascript" src="${webRoot}/resources/wechat/vote/mp3.js"></script>
<link rel="stylesheet" href="${webRoot}/resources/wechat/vote/jquery-ui.min.css" type="text/css" />
<script type="text/javascript" src="${webRoot}/resources/wechat/vote/jquery.ac.js"></script>
<link rel="stylesheet" type="text/css" media="all" href="${webRoot}/resources/wechat/vote/colorbox.css">
<link href='${webRoot}/resources/wechat/vote/dialog.css' rel='stylesheet' type='text/css' />
<script type="text/javascript" src="${webRoot}/resources/wechat/vote/jquery.colorbox.js"></script>
<script type="text/javascript" src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
<link rel="stylesheet" href="${webRoot}/resources/wechat/vote/greenw.css" type="text/css" />
<style>
::-webkit-scrollbar {
	width: 0px;
}
</style>
<script language="javascript">
	wx.config({
		debug : false,
		appId : 'wxe6447b937416eb20',
		timestamp : '1456403833',
		nonceStr : 'yTDsXGd2bWLlMzs0',
		signature : '4cbabe5e0818f83d95f0f4cbfe825f7b9489c9f3',
		jsApiList : [ "onMenuShareTimeline", "onMenuShareAppMessage",
				"onMenuShareQQ", "onMenuShareWeibo" ]
	});
	var setting = function(shareTo) {
		return {
			title : "“女神”与“摄郎”火拼大金山",
			desc : "“女神”与“摄郎”火拼大金山",
			link : "http://tp.qmhhr.com/wx/picwv-181_1.html?wid=867",
			imgUrl : "http://219.156.138.124:81/219lt/867/200_VvAFBEd2f3qmmqd19mCUzY7DjbvbJrCC.jpg",
			type : '',
			dataUrl : '',
			success : function() {
			}
		}
	};
	wx.ready(function() {
		wx.onMenuShareTimeline(setting("timeline"));
		wx.onMenuShareAppMessage(setting("friend"));
		wx.onMenuShareQQ(setting("QQ"));
		wx.onMenuShareWeibo(setting("weibo"));
	});
	wx.error(function(res) {
	});
</script>
<style>
.swiper-container {
	width: 100%;
	max-height: 200px;
	color: #fff;
	text-align: center;
}

.pagination {
	position: absolute;
	z-index: 20;
	right: 10px;
}

.swiper-pagination-switch {
	display: inline-block;
	width: 5px;
	height: 5px;
	border-radius: 5px;
	background: #222;
	margin-right: 5px;
	opacity: 0.8;
	border: 1px solid #fff;
	cursor: pointer;
}

.swiper-visible-switch {
	background: #aaa;
}

.swiper-active-switch {
	background: #fff;
}

.imgplay {
	max-height: 200px;
	width: 100%
}
</style>
<script src="${webRoot}/resources/wechat/vote/vote.js"></script>
<script>
	function pushfront() {
	};
	$(function() {
		$(window).bind("scroll", function() {
			if ($(window).scrollTop() > $("#count").offset().top) {
				$(".arrow").fadeOut(100);
			} else {
				$(".arrow").fadeIn(2000);
			}
		});
		$("#sfx").click(function() {
			$('#plug').trigger("click");
		});
		$("#hdtitle").toggle(function() {
			$("#listmore").show();
		}, function() {
			$("#listmore").hide();
		});
		var vdefault = "可输入名称编号首字...";
		$(".auto").css('color', '#b9b9b9');
		$(".auto").focus(function() {
			if ($(".auto").val() == vdefault) {
				$(".auto").val('');
				$(".auto").css('color', '#6d6d6d');
			}
		});
		$(".auto").blur(function() {
			if ($(".auto").val() == "") {
				$(".auto").val(vdefault);
				$(".auto").css('color', '#b9b9b9');
			}
		});
		$("#soname").click(
				function() {
					$("#sfxsfx").html("搜索跳转中");
					setload();
					var name = unescape($(".auto").val());
					$.get("/wx/picwv-search.html?lid=181&wid=867&name=" + name,
							function(result) {
								$('.load').css('display', 'none');
								if (result == 'bb') {
									tusi("不存在的名称");
								} else if (result == 'aa') {
									tusi("就在这一页");
								} else {
									var res = new Array();
									res = result.split("^^^^");
									window.location.href = '/wx/picwv-181_'
											+ res[0] + '.html?wid=867&nameid='
											+ res[1];
								}
							});
				});
		$(".auto").autocomplete({
			source : "/tpso/search.php?lid=181&wid=867",
			minLength : 1
		});
		$('#plug').click(function() {
			$(".dzptit").html("添加我们后,回复【投票】参与活动");
			if ($("#soso").css('display') == 'block')
				$("#soso").css('display', 'none');
			if ($("#sfx").css('display') == 'block')
				$("#sfx").css('display', 'none');
			if ($(".dzpwrap").css('display') == 'block')
				$(".dzpwrap").css('display', 'none');
			$('#share_layer').hide();
			$(this).hide();
		});
		$('#sou').click(function() {
			$('#plug').show();
			$("#soso").css('display', 'block');
		});
		$('#share')
				.click(
						function() {
							alert("点击当前屏幕右上角,三个点,选择分享到朋友圈或者发给朋友.\r\n\r\n悄悄的,在公众号中回复: 拉票   两个字,能获取更多拉票技能呢.");
							return false;
						});
		$("#jieshao").click(function() {
			if ($("#ms").css('display') == "none") {
				if ($("#ms").html() == "") {
					$("#sfxsfx").html("载入介绍中");
					setload();
					$.ajax({
						url : '/wx/pdesc.html?id=DDRbbgo5',
						error : function() {
							tusi('网络错误,请重试');
						},
						success : function(data) {
							$('.load').css('display', 'none');
							$("#ms").show();
							$("#ms").html(data);
						}
					});
				} else {
					$("#ms").show();
				}
			} else {
				$("#ms").hide();
			}
		});
	})
</script>
</head>
<body>
	<span id="playbox" class="btn_music musicplay" style="display: block"><audio
			id="audio" loop=""
			dsrc="http://tp.qmhhr.com/mp3.php?u=id1l6K12KAX9PS15tlGsAw=="></audio></span>
	<script>
		$(function() {
			if ($(document).find("#playbox")) {
				createbgmusic(1);
			}
		})
	</script>
	<div class="load"
		style="display: none; background: url('${webRoot}/resources/wechat/vote/img/tusi.png') no-repeat; max-width: 85%; min-height: 77px; min-width: 270px; position: fixed; left: -1000px; top: -1000px; text-align: center; border-radius: 10px;">
		<p style="color: #ffffff; line-height: 77px; font-size: 2.2em;">
			<span id="sfxsfx">努力投票中</span><img src="${webRoot}/resources/wechat/vote/img/pload.gif" />
		</p>
	</div>
	<div style="display: none;" id="plug"></div>
	<div id="soso">
		<div class="soubg">
			<div class="stop"></div>
			<input type='text' value="可输入名称编号首字..." class='auto'
				style="width: 70%; height: 36px; line-height: 36px; font-size: 1.5em; border-radius: 8px; padding-left: 8px; background: #f0f0f0; border: 0px;" /><a
				id='soname'>搜索</a>
			<div
				style="width: 100%; height: 48px; font-size: 1.2em; line-height: 48px">你知道么？分享搜索成功后的页面,投票更容易~</div>
		</div>
		<div style="width: 100%; padding-top: 10px; text-align: center">
			<strong class="soarrow"></strong>
		</div>
	</div>
	<div id="content" style="max-width: 640px; margin: 0 auto;">
	
	<style>
	.arrow{position:fixed;z-index:100;width:48px;height:48px;background:url("${webRoot}/resources/wechat/vote/img/up.png");
	background-size:100%;bottom:90px;left:50%;text-align:center;margin-left:-24px;
	animation:arrowUp 2s infinite ease-in;-webkit-animation:arrowUp 2s infinite ease-in}@keyframes arrowUp{0%{transform:translateY(42px);
	opacity:0}60%{transform:translateY(12px);
	opacity:1}100%{transform:translateY(0px);opacity:0}}@-webkit-keyframes arrowUp{0%{-webkit-transform:translateY(42px);
	opacity:0}60%{-webkit-transform:translateY(12px);opacity:1}100%{-webkit-transform:translateY(0px);opacity:0}}
	</style>
	
		<div class="arrow"></div>
		<img
			style="vertical-align: top; display: block; border: 0; width: 100%; padding: 0; margin: 0"
			src="${webRoot}/resources/wechat/vote/images/100.jpg"><img
			style="vertical-align: top; display: block; border: 0; width: 100%; padding: 0; margin: 0"
			src="${webRoot}/resources/wechat/vote/images/101.jpg"><img
			style="vertical-align: top; display: block; border: 0; width: 100%; padding: 0; margin: 0"
			src="${webRoot}/resources/wechat/vote/images/102.jpg"><img
			style="vertical-align: top; display: block; border: 0; width: 100%; padding: 0; margin: 0"
			src="${webRoot}/resources/wechat/vote/images/103.jpg">
		<ul id="count" style="margin: 0;">
			<li class="lf"><p>参与选手</p>
				<p style="padding: 0">
					<span>17</span>
				</p></li>
			<li class="ls" style="width: 34%"><p>累计投票</p>
				<p style="padding: 0">
					<span id="acount">45406</span>
				</p></li>
			<li style="width: 33%"><p>访问量</p>
				<p style="padding: 0">
					<span>1124924</span>
				</p></li>
		</ul>
		<div style="clear: both"></div>
		<DIV id="closed">活动已结束 !</div>
		<div id="three">
			<div style="position: relative;" id="hdtitle">
				<img class="timg timgwx" alt="" src="${webRoot}/resources/wechat/vote/img/greenw_wx.png"
					width="20">
				<p class="title">
					<span class="hdtitle"></span><small
						style="font-size: 1em; height: 30px; line-height: 31px; display: inline-block; padding-right: .2em;">"</small>女神<small
						style="font-size: 1em; height: 30px; line-height: 31px; display: inline-block; padding: 0 .2em;">"</small>与<small
						style="font-size: 1em; height: 30px; line-height: 31px; display: inline-block; padding: 0 .2em;">"</small>摄郎<small
						style="font-size: 1em; height: 30px; line-height: 31px; display: inline-block; padding: 0 .2em;">"</small>火拼大金山
				</p>
			</div>
			<div class="line"></div>
			<div id="shares" style="position: relative;">
				<img class="timg timgt" alt="" src="${webRoot}/resources/wechat/vote/img/greenw_t.png"
					width="20">
				<p class="title">
					<span></span>2015-08-03 至 2015-08-08
				</p>
				<span
					style="display: none; width: 30px; height: 18px; border-radius: 8px; position: absolute; right: 10px; top: 12px; background: url(${webRoot}/resources/wechat/vote/img/ar.png) center center no-repeat; color: #fff; text-align: center; font-weight: bold; line-height: 18px"></span>
			</div>
			<div class="line"></div>
			<div id="jieshao" style="position: relative;">
				<img class="timg" alt="" src="${webRoot}/resources/wechat/vote/img/greenw_desc.png" width="20">
				<p class="title">
					<span></span>活动介绍
				</p>
				<span class="descarrow"></span>
			</div>
			<div id="ms"></div>
			<div class="line none"></div>
		</div>
		<div style="height: 10px; max-width: 640px; width: 100%"></div>
		<div style="padding: 0 12px;">
			<div class="sorts flex">
				<a style="width: 100%" href="/wx/picwv-181.html?wid=867"><span
					class="all">随便看看</span></a><a style="width: 100%"
					href="/wx/picwv-181.html?wid=867&px=timedesc" class="active">最新参与</a>
				<a style="width: 100%; margin-right: 0px;"
					href="/wx/picwv-181.html?wid=867&px=topdesc">人气选手</a>
			</div>
			<div style="height: 10px; max-width: 640px; width: 100%"></div>
		</div>
		<div id="thumbs" class="masonry"
			style="margin: 0 auto; padding-left: 12px;">
			<div id="page_loading">
				<img src="${webRoot}/resources/wechat/vote/img/pload.gif" alt="page loading"><span
					style="margin-top: 15px; font-size: 1.4em">...给力加载中...</span>
			</div>
		</div>
		<div id="next_page" style="text-align: center;">
			<a hehe="/wx/picwv-181_2.html?wid=867&px=timedesc" class="number"></a>
		</div>
		<div class="mfooter" id="footer"
			style="width: 50%; margin: 0 auto; text-align: center; margin-top: 10px; padding-bottom: 10px;">
			<a href="http://www.weixindadang.com/reg.html"
				style="font-size: 1.2em; height: 40px; line-heigt: 30px; background: url('${webRoot}/resources/wechat/vote/img/pagec.png') no-repeat 7px 10px; background-size: 10px 14px; padding: 10px; padding-left: 22px;">www.weixindadang.com</a>
		</div>
	</div>
	<style>
.dzpwrap {
	background: none repeat scroll 0 0 #f8f8f8;
	border-radius: 1px 1px 1px 1px;
	position: fixed;
	width: 280px
}

.dzpwrap .dzptit {
	background-image: url("");
	background-position: 14px 14px;
	background-repeat: no-repeat;
	background-size: 24px auto;
	font-size: 1.5em;
	line-height: 40px;
	text-align: center;
	padding: 7px 0 0 0
}

.dzpwrapcont.dzpwrapcontent {
	background-color: #ff403a;
	background-image:
		url("${webRoot}/resources/wechat/vote/images/104.jpg");
	background-position: 0 0;
	background-repeat: no-repeat;
	background-size: 280px 130px;
	padding-top: 130px;
}

.dzpwrapcont {
	padding: 0 14px 16px;
}

.btndzp {
	border-radius: 5px 5px 5px 5px;
	display: inline-block;
	text-decoration: none;
	vertical-align: middle;
	box-shadow: 0 6px #ab3c3c
}

.dzpwrapcont .btndzp {
	-moz-border-bottom-colors: none;
	-moz-border-image: none;
	-moz-border-left-colors: none;
	-moz-border-right-colors: none;
	-moz-border-top-colors: none;
	color: #5d5d5d;
	display: block;
	font-size: 1.6em;
	line-height: 36px;
	text-align: center
}

.dzpwrapcont .btnRed {
	background: none repeat scroll 0 0 #e8e363;
	color: #5c5c5c;
	letter-spacing: 2px;
	font-weight: bold;
	margin: 16px 0 0
}
</style>
	<script>
		function loaddzp(name) {
			$('#plug').show();
			var div = $('.dzpwrap');
			div.css('zIndex', 99999999);
			div.css('display', 'block');
			div.css('left', parseInt(($(window).width() - div.width()) / 2));
			var top = parseInt(($(window).height() - div.height()) / 2 - 45);
			div.css('top', top);
		}
	</script>
	<div style="display: none">
		<img src="${webRoot}/resources/wechat/vote/img/d.png" />
	</div>
	<script>
		function bm() {
			$(".dzptit").html("添加我们后,回复【报名】参与活动");
			loaddzp();
		}
	</script>
	<div class="dzpwrap" style="display: none">
		<article>
			<header class="dzptit">添加我们后,回复【投票】参与活动</header>
			<section class="dzpwrapcont dzpwrapcontent">
				<a
					href="http://mp.weixin.qq.com/s?__biz=MzA4ODM5NTAwMg==&mid=205125573&idx=1&sn=61cd219cd0ce930d049182dc2d7e95fc&scene=18#rd"
					class="btndzp btnRed">如何添加我们 ?</a><a id="dzpclose"
					class="btndzp btnRed" onclick="$('#plug').trigger('click');">取消,继续浏览</a>
			</section>
		</article>
	</div>
	<div style="display: none">
		<input id="dialogJ_hid" type="hidden" />
	</div>
	<style type="text/css">
body {
	margin-bottom: 60px !important
}

a, button, input {
	-webkit-tap-highlight-color: rgba(255, 0, 0, 0)
}

ul, li {
	list-style: none;
	margin: 0;
	padding: 0
}

.top_bar {
	position: fixed;
	z-index: 900;
	bottom: 0;
	left: 0;
	right: 0;
	margin: auto;
	font-family: Helvetica, Tahoma, Arial, Microsoft YaHei, sans-serif
}

.top_bar .top_menu>li {
	-webkit-box-flex: 1;
	position: relative;
	text-align: center
}

.top_menu li:first-child {
	
}

.top_bar .top_menu>li>a {
	margin-right: 1px;
	display: block;
	text-align: center;
	color: #FFF;
	text-decoration: none;
	text-shadow: 0 1px rgba(0, 0, 0, 0.3);
	-webkit-box-flex: 1
}

.top_bar .top_menu>li.home a {
	position: relative;
}

.top_bar .top_menu>li>a label {
	overflow: hidden;
	margin: 0 0 0 0;
	display: block !important;
	line-height: 18px;
	text-align: center;
}

.top_bar .top_menu>li>a img {
	padding: 3px 0 0 0;
	height: 24px;
	width: 24px;
	color: #fff;
	line-height: 48px;
	vertical-align: middle
}

.top_bar li:first-child a {
	display: block
}

.menu_font {
	text-align: left;
	position: absolute;
	right: 10px;
	z-index: 500;
	background: -webkit-gradient(linear, 0 0, 0 100%, from(#524945),
		to(#48403c), color-stop(60%, #524945));
	border-radius: 5px;
	width: 120px;
	margin-top: 10px;
	padding: 0;
	box-shadow: 0 1px 5px rgba(0, 0, 0, 0.3)
}

.menu_font.hidden {
	display: none
}

.menu_font {
	top: inherit !important;
	bottom: 60px
}

.menu_font li a {
	height: 40px;
	margin-right: 1px;
	display: block;
	text-align: center;
	color: #FFF;
	text-decoration: none;
	text-shadow: 0 1px rgba(0, 0, 0, 0.3);
	-webkit-box-flex: 1
}

.menu_font li a {
	text-align: left !important
}

.top_menu li:last-of-type a {;
	overflow: hidden
}

.menu_font:after {
	top: inherit !important;
	bottom: -6px;
	border-color: #48403c rgba(0, 0, 0, 0) rgba(0, 0, 0, 0);
	border-width: 6px 6px 0;
	position: absolute;
	content: "";
	display: inline-block;
	width: 0;
	height: 0;
	border-style: solid;
	left: 80%
}

.menu_font li {
	border-top: 1px solid rgba(255, 255, 255, 0.1);
	border-bottom: 1px solid rgba(0, 0, 0, 0.2)
}

.menu_font li:first-of-type {
	border-top: 0
}

.menu_font li:last-of-type {
	border-bottom: 0
}

.menu_font li a {
	height: 40px;
	line-height: 40px !important;
	position: relative;
	color: #fff;
	display: block;
	width: 100%;
	text-indent: 10px;
	white-space: nowrap;
	text-overflow: ellipsis;
	overflow: hidden
}

.menu_font li a img {
	width: 20px;
	height: 20px;
	display: inline-block;
	margin-top: -2px;
	color: #fff;
	line-height: 40px;
	vertical-align: middle
}

.menu_font>li>a label {
	padding: 3px 0 0 3px;
	overflow: hidden;
	margin: 0
}

#menu_list0 {
	right: 0;
	left: 10px
}

#menu_list0:after {
	left: 20%
}

#sharemcover {
	position: fixed;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	background: rgba(0, 0, 0, 0.7);
	display: none;
	z-index: 20000
}

#sharemcover img {
	position: fixed;
	right: 18px;
	top: 5px;
	width: 260px;
	height: 180px;
	z-index: 20001;
	border: 0
}

.top_bar .top_menu>li>a:hover, .top_bar .top_menu>li>a:active {
	backgrounsd-color: #333
}

#sou:hover, #sou:active {
	background-color: none
}

.menu_font li a:hover, .menu_font li a:active {
	backgrousnd-color: #333
}

.menu_font li:first-of-type a {
	border-radius: 5px 5px 0 0
}

.menu_font li:last-of-type a {
	border-radius: 0 0 5px 5px
}

#plug-wrap {
	position: fixed;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	background: rgba(0, 0, 0, 0);
	z-index: 800
}

#cate18 .device {
	bottom: 49px
}

#cate18 #indicator {
	bottom: 240px
}

#cate19 .device {
	bottom: 49px
}

#cate19 #indicator {
	bottom: 330px
}

#cate19 .pagination {
	bottom: 60px
}
</style>
	<div id="sharemcover"
		onClick="document.getElementById('sharemcover').style.display='';"
		style="display: none">
		<img src="">
	</div>
	<div class="top_bar" style="-webkit-transform: translate3d(0, 0, 0)">
		<nav>
			<ul id="top_menu" class="top_menu">
				<li><a class="tabhome" href="javascript:void(0);"><label
						style="font-size: 1.1em; letter-spacing: .07em">微官网</label></a>
					<ul id="menu_list0" class="menu_font" style="display: none"></ul></li>
				<li><a class="tabtel" href="tel:15170730886"><label
						style="font-size: 1.1em; letter-spacing: .07em">电话</label></a>
					<ul id="menu_list0" class="menu_font" style="display: none"></ul></li>
				<li class="home"><a id="sou"></a></li>
				<li><a class="tabtoplist" id="paihang"
					href="/wx/picwvd-181.html"><label
						style="font-size: 1.1em; letter-spacing: .07em">排行</label></a>
					<ul id="menu_list0" class="menu_font" style="display: none"></ul></li>
				<li><a class="tabshare" onclick="shareurl('..');"><label
						style="font-size: 1.1em; letter-spacing: .07em">去分享</label></a>
					<ul id="menu_list0" class="menu_font" style="display: none"></ul></li>
			</ul>
		</nav>
	</div>
	<div id="plug-wrap" onClick="closeall()" style="display: none;"></div>
	<script>
		function displayit(n) {
			var count = document.getElementById("top_menu")
					.getElementsByTagName("ul").length;
			for (i = 0; i < count; i++) {
				if (i == n) {
					if (document.getElementById("top_menu")
							.getElementsByTagName("ul").item(n).style.display == 'none') {
						document.getElementById("top_menu")
								.getElementsByTagName("ul").item(n).style.display = '';
						document.getElementById("plug-wrap").style.display = '';
					} else {
						document.getElementById("top_menu")
								.getElementsByTagName("ul").item(n).style.display = 'none';
						document.getElementById("plug-wrap").style.display = 'none';
					}
				} else {
					document.getElementById("top_menu").getElementsByTagName(
							"ul").item(i).style.display = 'none';
				}
			}
		};
		function closeall() {
			var count = document.getElementById("top_menu")
					.getElementsByTagName("ul").length;
			for (i = 0; i < count; i++) {
				document.getElementById("top_menu").getElementsByTagName("ul")
						.item(i).style.display = 'none';
			}
			;
			document.getElementById("plug-wrap").style.display = 'none';
		}
	</script>
	<div style="display: none" id="userc">6</div>
</body>
</html>