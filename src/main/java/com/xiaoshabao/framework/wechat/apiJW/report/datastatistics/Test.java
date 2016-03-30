package com.xiaoshabao.framework.wechat.apiJW.report.datastatistics;

import java.io.UnsupportedEncodingException;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.xiaoshabao.framework.wechat.apiJW.core.exception.WexinReqException;
import com.xiaoshabao.framework.wechat.apiJW.report.datastatistics.graphicanalysis.JwGraphicAnalysisAPI;
import com.xiaoshabao.framework.wechat.apiJW.report.datastatistics.graphicanalysis.model.GraphicAnalysisRtnInfo;
import com.xiaoshabao.framework.wechat.apiJW.report.datastatistics.useranalysis.JwUserAnalysisAPI;
import com.xiaoshabao.framework.wechat.apiJW.report.datastatistics.useranalysis.model.UserAnalysisRtnInfo;


public class Test {

	private static String appid = "wxa842e07813a1380a";
	private static String appscret = "33df24d6e663b9ec31e4f6347ce3c256";
	
	public static void main(String[] args) throws WexinReqException, UnsupportedEncodingException {
		Test t = new Test();
		//测试 获取用户增减数据
//		t.getUserSummary();
		//测试 获取累计用户数据
//		t.getUserCumulate();
		//测试  获取图文群发每日数据
//		t.getArticleSummary();
		//获取图文群发总数据
		//t.getArticleTotal();
		//获取图文统计数据
		t.getUserRead();
		//获取图文统计分时数据
//		t.getUserReadHour();
		//获取图文分享转发数据
//		t.getUserShare();
		//获取图文分享转发分时数据
//		t.getUserShareHour();
	}
	
	public String getAccessToken() throws WexinReqException{
//		return TokenAPI.getAccessToken(appid, appscret);
		return null;//本来是获得token
	}
	//测试 获取用户增减数据
	@SuppressWarnings("static-access")
	public void getUserSummary() throws WexinReqException{
		JwUserAnalysisAPI jua = new JwUserAnalysisAPI();
		List<UserAnalysisRtnInfo> userAnalysisList = jua.getUserSummary(getAccessToken(), "2015-01-27", "2015-01-30");
		
		for (UserAnalysisRtnInfo userAnalysisRtnInfo : userAnalysisList) {
			System.out.println(JSON.toJSON(userAnalysisRtnInfo));
		}
	}
	//测试 获取累计用户数据
	@SuppressWarnings("static-access")
	public void getUserCumulate() throws WexinReqException{
		JwUserAnalysisAPI jua = new JwUserAnalysisAPI();
		List<UserAnalysisRtnInfo> userAnalysisRtnInfoList = jua.getUserCumulate(getAccessToken(), "2015-01-24", "2015-01-30");
		
		for (UserAnalysisRtnInfo userAnalysisRtnInfo : userAnalysisRtnInfoList) {
			System.out.println(JSON.toJSON(userAnalysisRtnInfo));
		}
	}
	//获取图文群发每日数据
	@SuppressWarnings("static-access")
	public void getArticleSummary() throws WexinReqException, UnsupportedEncodingException{
		JwGraphicAnalysisAPI jga = new JwGraphicAnalysisAPI();
		List<GraphicAnalysisRtnInfo> graphicAnalysisRtnInfoList = jga.getArticleSummary(getAccessToken(), "2015-03-02", "2015-03-02");
		
		for (GraphicAnalysisRtnInfo graphicAnalysisRtnInfo : graphicAnalysisRtnInfoList) {
			System.out.println(JSON.toJSON(graphicAnalysisRtnInfo));
		}
	}
	//获取图文群发总数据
	@SuppressWarnings("static-access")
	public void getArticleTotal() throws WexinReqException, UnsupportedEncodingException{
		JwGraphicAnalysisAPI jga = new JwGraphicAnalysisAPI();
		List<GraphicAnalysisRtnInfo> graphicAnalysisRtnInfoList = jga.getArticleTotal(getAccessToken(), "2015-03-03", "2015-03-03");
		
		for (GraphicAnalysisRtnInfo graphicAnalysisRtnInfo : graphicAnalysisRtnInfoList) {
			System.out.println(JSON.toJSONString(graphicAnalysisRtnInfo));
		}
	}
	//获取图文统计数据
	@SuppressWarnings("static-access")
	public void getUserRead() throws WexinReqException{
		JwGraphicAnalysisAPI jga = new JwGraphicAnalysisAPI();
		List<GraphicAnalysisRtnInfo> graphicAnalysisRtnInfoList = jga.getUserRead(getAccessToken(), "2015-05-09", "2015-05-11");
		
		for (GraphicAnalysisRtnInfo graphicAnalysisRtnInfo : graphicAnalysisRtnInfoList) {
			System.out.println(JSON.toJSON(graphicAnalysisRtnInfo));
		}
	}
	//获取图文统计分时数据
	@SuppressWarnings("static-access")
	public void getUserReadHour() throws WexinReqException{
		JwGraphicAnalysisAPI jga = new JwGraphicAnalysisAPI();
		List<GraphicAnalysisRtnInfo> graphicAnalysisRtnInfoList = jga.getUserReadHour(getAccessToken(), "2015-01-30", "2015-01-30");
		
		for (GraphicAnalysisRtnInfo graphicAnalysisRtnInfo : graphicAnalysisRtnInfoList) {
			System.out.println(JSON.toJSON(graphicAnalysisRtnInfo));
		}
	}
	//获取图文分享转发数据
	@SuppressWarnings("static-access")
	public void getUserShare() throws WexinReqException{
		JwGraphicAnalysisAPI jga = new JwGraphicAnalysisAPI();
		List<GraphicAnalysisRtnInfo> graphicAnalysisRtnInfoList = jga.getUserShare(getAccessToken(), "2015-01-24", "2015-01-30");
		
		for (GraphicAnalysisRtnInfo graphicAnalysisRtnInfo : graphicAnalysisRtnInfoList) {
			System.out.println(JSON.toJSON(graphicAnalysisRtnInfo));
		}
	}
	//获取图文分享转发分时数据
	@SuppressWarnings("static-access")
	public void getUserShareHour() throws WexinReqException{
		JwGraphicAnalysisAPI jga = new JwGraphicAnalysisAPI();
		List<GraphicAnalysisRtnInfo> graphicAnalysisRtnInfoList = jga.getUserShareHour(getAccessToken(), "2015-01-30", "2015-01-30");
		
		for (GraphicAnalysisRtnInfo graphicAnalysisRtnInfo : graphicAnalysisRtnInfoList) {
			System.out.println(JSON.toJSON(graphicAnalysisRtnInfo));
		}
	}
}
