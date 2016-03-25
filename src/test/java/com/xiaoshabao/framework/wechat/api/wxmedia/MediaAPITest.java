package com.xiaoshabao.framework.wechat.api.wxmedia;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.xiaoshabao.framework.wechat.api.core.exception.WexinReqException;
import com.xiaoshabao.framework.wechat.api.wxmedia.model.Article;
import com.xiaoshabao.framework.wechat.api.wxmedia.model.DwonloadResult;
import com.xiaoshabao.framework.wechat.api.wxmedia.model.UploadResult;


public class MediaAPITest {
	
	private String accessToken="HobMAcvEwPui80_3FGUz-9seo1gNqpGGhGebK3ERMDg8pONgLHYSXYMvE0pSGWGxs-X_k8c4e2rEnS2YtvmLLqymFWvHgr0lpuMDmX9zIVYK5lk0uRlrT9zNLhRnLLB8ABAbAAAIJI";
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	/**
	 *  微信--上传临时文件接口
	 * @throws Exception 
	 */
	@Test
	public void testUploadTempMedia() throws Exception {
		try {
			UploadResult bean=MediaAPI.uploadTempMedia(accessToken, MediaType.IMAGE, "E:\\test\\img01.jpg");
			System.out.println("media_id:"+bean.getMedia_id());
			System.out.println("created_at:"+bean.getCreated_at());
		} catch (WexinReqException e) {
			e.printStackTrace();
			throw new Exception(e);
		}
	}
	
	/**
	 *  微信--下载临时文件接口
	 * @throws Exception 
	 */
	@Test
	public void testDownTempMedia() throws Exception {
		try {
			DwonloadResult bean=MediaAPI.downTempMedia(accessToken, "0mdsOYmWzZEiPolK4KlS1lrH0HIGj3SJVL4jZv3jHjNcOlamP86T1IVGdwzdXIEg", "E:\\test");
			System.out.println("FileName:"+bean.getFileName());
			System.out.println("Filepath:"+bean.getFilePath());
		} catch (WexinReqException e) {
			e.printStackTrace();
			throw new Exception(e);
		}
	}
	/**
	 *  永久素材上传文件接口
	 * @throws Exception 
	 */
	@Test
	public void testUploadMedia() throws Exception {
		try {
			UploadResult bean=MediaAPI.uploadMedia(accessToken, MediaType.IMAGE, "E:\\test\\img01.jpg");
			System.out.println("media_id:"+bean.getMedia_id());
			System.out.println("created_at:"+bean.getCreated_at());
		} catch (WexinReqException e) {
			e.printStackTrace();
			throw new Exception(e);
		}
	}
	/**
	 *  上传永久图文-图片接口
	 *  <p>用于永久图文消息内容等</p>
	 * @throws Exception 
	 */
	@Test
	public void testUploadNewsImg() throws Exception {
		try {
			 String url=MediaAPI.uploadNewsImg(accessToken,"E:\\test\\img01.jpg");
			System.out.println("图片地址为:"+url);
			//http://mmbiz.qpic.cn/mmbiz/BibYy0opVNUoYxKKjibGQDew0w0nu3BPYVgVWBEiaN3zEQgAdH34wksndLibpiclWYN0rRp309YuVhrurqsibu5fJ0mA/0
		} catch (WexinReqException e) {
			e.printStackTrace();
			throw new Exception(e);
		}
	}
	/**
	 * 上传永久图文消息素材
	 * @throws Exception
	 */
	@Test
	public void testUploadNews() throws Exception {
		try {
			List<Article> articles=new ArrayList<Article>();
			Article a1=new Article();
			a1.setAuthor("manxx");
			a1.setTitle("测试");
			a1.setThumb_media_id("");
			 String media_id=MediaAPI.uploadNews(accessToken, articles);
			System.out.println("图文素材media_id:"+media_id);
		} catch (WexinReqException e) {
			e.printStackTrace();
			throw new Exception(e);
		}
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
