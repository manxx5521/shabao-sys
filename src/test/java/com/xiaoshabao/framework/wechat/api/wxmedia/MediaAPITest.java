package com.xiaoshabao.framework.wechat.api.wxmedia;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.xiaoshabao.framework.wechat.api.core.exception.WexinReqException;
import com.xiaoshabao.framework.wechat.api.wxmedia.model.DwonloadResult;
import com.xiaoshabao.framework.wechat.api.wxmedia.model.UploadResult;


public class MediaAPITest {
	
	private String accessToken="axIQKrjIjLjds8dotPRzcMXtsp7q7VmmAi7ZirUEpaJQAtN9DUZj_SpkVIYpxofZrxI-lUYOT8Xy1PQpMQ4R6BaO7qd_-tPLZ5ChZjjnQmH_u49-JRnW4aJHU4u5NPIDDMWgAIAMVF";
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	/**
	 *  微信--上传临时文件接口
	 */
	@Test
	public void testUploadTempMedia() {
		try {
			UploadResult bean=MediaAPI.uploadTempMedia(accessToken, MediaType.IMAGE, "E:\\test\\img01.jpg");
			System.out.println("media_id:"+bean.getMedia_id());
			System.out.println("created_at:"+bean.getCreated_at());
		} catch (WexinReqException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 *  微信--下载临时文件接口
	 */
	@Test
	public void testDownTempMedia() {
		try {
			DwonloadResult bean=MediaAPI.downTempMedia(accessToken, "CWcQ0lSe3-2vyysapJ3jYb3GZdnsqhEjKbbpQffPg-nuG7JMQh1SOmrPDsTf00Ip", "E:\\test");
			System.out.println("FileName:"+bean.getFileName());
			System.out.println("Filepath:"+bean.getFilePath());
		} catch (WexinReqException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testUploadArticlesByMaterial() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMediaCount() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetArticlesByMaterial() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteArticlesByMaterial() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateArticlesByMaterial() {
		fail("Not yet implemented");
	}

	@Test
	public void testQueryArticlesByMaterial() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMediaIdByMaterial() {
		fail("Not yet implemented");
	}

	@Test
	public void testUploadMediaFileByMaterial() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMediaIdForMaterial() {
		fail("Not yet implemented");
	}

}
