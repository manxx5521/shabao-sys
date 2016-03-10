package com.xiaoshabao.framework.wechat.api.wxmedia;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.xiaoshabao.framework.wechat.api.core.exception.WexinReqException;
import com.xiaoshabao.framework.wechat.api.wxmedia.model.WxUpload;

public class MediaAPITest {

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
		String accessToken="W5bumOO9sNu6UvA2hLeHkBQYMq2MsRaQ6NPISnrf4Ul7G6AUkszp5_58Ja8yWHvtEjBTKI3TaK7DIcOhfCAwMHp2zTASfzKmmTH5guzgIYaOR3IzlI-Am7POrzwiq6pNDEPhADAJKV";
		try {
			WxUpload bean=MediaAPI.uploadTempMedia(accessToken, MediaType.IMAGE, "E:\\test\\img01.jpg");
			System.out.println("media_id:"+bean.getMedia_id());
			System.out.println("created_at:"+bean.getCreated_at());
		} catch (WexinReqException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testDownTempMedia() {
		fail("Not yet implemented");
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
