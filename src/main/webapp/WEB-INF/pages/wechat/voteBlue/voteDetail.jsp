<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!--微信分享-->
<script src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
<script>
	wx.config({
		debug : false,
		appId : 'wxf022fc156026a511',
		timestamp : 1456839962,
		nonceStr : 'O2ciojBfI3KwBtKk',
		signature : '2cabe0a811a8d58284f7ae62aa2060ae50cd3e33',
		jsApiList : [ 'checkJsApi', 'onMenuShareTimeline',
				'onMenuShareAppMessage', 'onMenuShareQQ', 'onMenuShareWeibo',
				'hideMenuItems', 'showMenuItems', 'hideAllNonBaseMenuItem',
				'showAllNonBaseMenuItem', 'translateVoice', 'startRecord',
				'stopRecord', 'onRecordEnd', 'playVoice', 'pauseVoice',
				'stopVoice', 'uploadVoice', 'downloadVoice', 'chooseImage',
				'previewImage', 'uploadImage', 'downloadImage',
				'getNetworkType', 'openLocation', 'getLocation',
				'hideOptionMenu', 'showOptionMenu', 'closeWindow',
				'scanQRCode', 'chooseWXPay', 'openProductSpecificView',
				'addCard', 'chooseCard', 'openCard' ]
	});
</script>
<script type="text/javascript">
	wx
			.ready(function() {
var shareData = {
					title : '斯雪佳-懒人经典蓝色-性感美女投票测试',
					desc : '记得投我哦！',
					link : 'http://tp.lanrenmb.com/Home/index.php/Index/content/id/217021/fid/10537/subscribe/0.html',
					imgUrl : 'http://demo4.cn.aijia798.com/Home//Public/upload/3/c/0/9/559a9f4e41523.jpg'
				};
				wx.onMenuShareAppMessage(shareData);
				wx.onMenuShareTimeline(shareData);
				wx.onMenuShareQQ(shareData);
				wx.onMenuShareWeibo(shareData);
			});
	wx.error(function(res) {
		//alert(res.errMsg); 
	}

	);
</script>
<!--END 微信分享-->
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/html">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<meta
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"
	name="viewport">
<meta content="yes" name="apple-mobile-web-app-capable">
<meta content="black" name="apple-mobile-web-app-status-bar-style">
<meta content="telephone=no" name="format-detection">
<title>${player.player_name} 投票</title>
<%@include file="../../../context/headWechat.jsp"%>
<link rel="stylesheet" href="${webRoot}/resources/wechat/voteBlue/touch.css">
<script src="${webRoot}/resources/js/jquery-2.1.3.min.js" type="text/javascript"></script>
<script src="${webRoot}/resources/wechat/voteBlue/app.js" type="text/javascript"></script>
<script src="${webRoot}/resources/js/jquery.masonry.min.js" type="text/javascript"></script>
<link rel="stylesheet" href="${webRoot}/resources/wechat/voteBlue/colorbox.css">
<script src="${webRoot}/resources/js/jquery.colorbox.js" type="text/javascript"></script>
<style>
.slider {
	display: none;
}

.focus span {
	width: 5px;
	height: 5px;
	margin-left: 5px;
	border-radius: 50%;
	background: #CDCDCD;
	font-size: 0
}

.focus span.current {
	background: red;
}
</style>
</head>
<body>
	<header>
		<div class="m_head clearfix">
			<div class="slider">
				<ul>
					<li><a href="#"><img
							src="${webRoot}/resources/wechat/voteBlue/images/568358a53332e.png" /></a></li>
					<li><a href="#"><img
							src="${webRoot}/resources/wechat/voteBlue/images/568357a9a4d81.png" /></a></li>
				</ul>
			</div>
			<div class="search">
				<form action="/Home/index.php/Index/content.html" id="search_form"
					method="get">
					<input type="hidden" name="id" value="217021" /><input
						type="hidden" name="subscribe" value="0" />
					<div class="search_con">
						<div class="btn">
							<input type="submit" name="seachid" id="searchBtn" value="搜索">
						</div>
						<div class="text_box">
							<input type="search" id="searchText" value="" name="keyword"
								placeholder="搜名字或编号" autocomplete="off">
						</div>
					</div>
					<input type="hidden" name="__hash__"
						value="6bc64adbc82fb783488aabec063bce17_f8c79fd1d7f9add6dbbe1422d11dab21" />
				</form>
			</div>
		</div>
	</header>
	<section class="content" id="get_info" data-rid="503" data-sort=""
		data-kw="" data-page="">
		<div class="detial_box">
			<p class="num clearfix">
				<span class="fl" id="baby_info" itid_id="5" data-rule_id="503"
					data-vote_num="1">&nbsp;${player.player_num}号&nbsp;${player.player_name}</span>
				<span class="fr">&nbsp;&nbsp;&nbsp;&nbsp;票数：${player.vote_num}</span>
			</p>
			<div class="blank10"></div>
			<p>描述：${player.des}</p>
			<div class="blank10"></div>
			<img
				src="${webRoot}/resources/upload/images/vote/${player.image}" />
		</div>
		<div class="blank10"></div>
		<div class="abtn_box">
			<a href="javascript:void(0);" class="a_btn toupiao vote"
				onclick="loaddzp()">我要投票</a><a
				href="voteBuleBaoMing.html"
				class="a_btn canjia">我也来参加</a><a
				href="./voteBlue.html?vote_id=${player.vote_id}" class="a_btn look">点击查看更多</a>
		</div>
	</section>
	<img class="bg"
		src="${webRoot}/resources/wechat/voteBlue/images/mw_005.jpg" />
	<section class="rules">
		<div class="text">
			<div class="prize">活动规则</div>
			<div class="neirong">
				<p>
					<strong>投票说明</strong><span style="line-height: 1.5;">：</span>
				</p>
				<p>奖品设置：</p>
				<p>
					<img alt=""
						src="${webRoot}/resources/wechat/voteBlue/images/55ec2d38ae11d.jpg" />
				</p>
				<p>
					<img alt=""
						src="${webRoot}/resources/wechat/voteBlue/images/55ec2daa83e50.jpg" />
				</p>
			</div>
			<div style="text-align: center;">
				<a href="http://www.lanrenmb.com"
					style="color: #5e5e5e; font-size: 1.2em;">Copyright (c)
					2014-2016 沙包娱乐 版权所有</a>
			</div>
		</div>
		<div style="height: 60px; width: 100%; display: block;"></div>
	</section>
	<section>
		<div class="pop" id="guanzhu" style="display: none">
			<div class="mengceng"></div>
			<div class="pop_up">
				<span class="closed close_pop_up">&nbsp;</span>
				<p class="tit_p">如何参与活动</p>
				<p class="tit_txt">添加我们后,回复【蓝色】参与活动</p>
				<a
					href="http://mp.weixin.qq.com/s?__biz=MjM5NjA0MTI0OQ==&mid=200068987&idx=1&sn=1de5daeaae94c66a3c46a13e20e8011e#rd"
					class="gz_btn">详细了解参与方法</a>
			</div>
		</div>
		<div class="pop" id="voted" style="display: none;">
			<div class="mengceng"></div>
		</div>
		<div class="pop" id="voting" style="display: none;">
			<div class="mengceng"></div>
			<div class="pop_up">
				<span class="closed close_pop_up">&nbsp;</span>
				<p class="tit_p" id="voting_title"></p>
				<p class="tit_txt" id="voting_content"></p>
			</div>
		</div>
		<div class="share_overmask" style="display: none;">
			<div class="share_arrow"></div>
			<div class="share_words"></div>
		</div>
	</section>
	<link rel="stylesheet" type="text/css"
		href="${webRoot}/resources/wechat/voteBlue/daohang.css" />
	  <div class="bot_main">
		<ul>
			<li class="ico_3"><a
				href="./voteBuleBaoMing.html?vote_id=${vote_id}"><span
					class="ico"><img
						src="${webRoot}/resources/wechat/voteBlue/images/i11.png" /></span><span
					class="txt" style="color: #333;">报名</span></a></li>
			<li class="ico_1"><a href="tel:18164081140"><span
					class="ico"><img
						src="${webRoot}/resources/wechat/voteBlue/images/i1.png" /></span><span
					class="txt" style="color: #333;">咨询</span></a></li>
			<li class="ico_2"><a id="paihang"
				href="./voteBulePaiHang.html?vote_id=${vote_id}"><span class="ico"><img
						src="${webRoot}/resources/wechat/voteBlue/images/i3.png" /></span><span
					class="txt" style="color: #333;">排行</span></a></li>
			<li class="ico_4"><a onclick="_system._guide(true)"><span
					class="ico"><img
						src="${webRoot}/resources/wechat/voteBlue/images/i4.png" /></span><span
					class="txt" style="color: #333;">点击拉票</span></a></li>
		</ul>
	</div>
	<script
		src="${webRoot}/resources/wechat/voteBlue/yxMobileSlider.js"
		type="text/javascript"></script>
	<script type="text/javascript">
		$(".slider").yxMobileSlider({
			during : 5000,
			height : 300
		});

		function loaddzp() {
			$("#guanzhu").show();
		}

		$(function() {
			$("#paihang").click(function() {
				$(this).colorbox({
					iframe : true,
					width : "90%",
					height : "90%"
				});
			});

		});

		function showVerify(vid, id) {
			$.colorbox({
				top : "10px",
				innerWidth : 220,
				innerHeight : 220,
				iframe : true,
				href : "/Home/index.php?m=Public&a=lanren_verify&mid=62&vid="
						+ vid + "&id=" + id
			});
		}
	</script>
	<style type="text/css">
#cover {
	display: none;
	position: absolute;
	left: 0;
	top: 0;
	z-index: 18888;
	background-color: #000000;
	opacity: 0.7;
}

#guide {
	display: none;
	position: absolute;
	right: 18px;
	top: 5px;
	z-index: 19999;
}

#guide img {
	width: 260px;
	height: 180px;
}
</style>
	<div id="cover"></div>
	<div id="guide">
		<img src="${webRoot}/resources/wechat/voteBlue/images/guide1.png">
	</div>
	<script type="text/javascript">
		var _system = {

			$$ : function(id) {
				return document.getElementById(id);
			},

			_client : function() {
				return {
					w : document.documentElement.scrollWidth,
					h : document.documentElement.scrollHeight,
					bw : document.documentElement.clientWidth,
					bh : document.documentElement.clientHeight
				};
			},

			_scroll : function() {
				return {
					x : document.documentElement.scrollLeft ? document.documentElement.scrollLeft
							: document.body.scrollLeft,
					y : document.documentElement.scrollTop ? document.documentElement.scrollTop
							: document.body.scrollTop
				};
			},

			_cover : function(show) {
				if (show) {
					this.$$("cover").style.display = "block";
					this.$$("cover").style.width = (this._client().bw > this
							._client().w ? this._client().bw : this._client().w)
							+ "px";
					this.$$("cover").style.height = (this._client().bh > this
							._client().h ? this._client().bh : this._client().h)
							+ "px";
				} else {
					this.$$("cover").style.display = "none";
				}

			},

			_guide : function(click) {
				this._cover(true);
				this.$$("guide").style.display = "block";
				this.$$("guide").style.top = (_system._scroll().y + 5) + "px";
				window.onresize = function() {
					_system._cover(true);
					_system.$$("guide").style.top = (_system._scroll().y + 5)
							+ "px";
				};

				if (click) {
					_system.$$("cover").onclick = function() {
						_system._cover();
						_system.$$("guide").style.display = "none";
						_system.$$("cover").onclick = null;
						window.onresize = null;
					};
				}

			},

			_zero : function(n) {
				return n < 0 ? 0 : n;
			}

		}
	</script>
</body>
</html>
