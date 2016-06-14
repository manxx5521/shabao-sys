package com.xiaoshabao.wxweb.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.xiaoshabao.framework.web.springmvc.exception.DaoException;
/**
 * 实例controller
 */
@Controller
@RequestMapping(value="/file")
public class FileController extends BaseController{
	
	@RequestMapping(value="/demo")
	public ModelAndView reqMap (ModelMap model) throws DaoException{
		return new ModelAndView ("/customTag/fileTest");
	}
	
	/**
	 * 文件上传
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="upload",produces="text/html;charset=UTF-8")
	@ResponseBody
	public Map<String, Object> uploadFile(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		String savePath = request.getSession().getServletContext().getRealPath("/")
				+ "attached"+File.separator;
		// localUrl
		// 文件保存目录URL
		String saveUrl = request.getContextPath() + "/attached/";

		// 定义允许上传的文件扩展名
		HashMap<String, String> extMap = new HashMap<String, String>();
		extMap.put("image", "gif,jpg,jpeg,png,bmp");
		extMap.put("flash", "swf,flv");
		extMap.put("media", "swf,flv,mp3,wav,wma,wmv,mid,avi,mpg,asf,rm,rmvb");
		extMap.put("file", "doc,docx,xls,xlsx,ppt,htm,html,txt,zip,rar,gz,bz2");
		
		//附件要上传到的目录
		extMap.put("attached", "doc,docx,xls,xlsx,ppt,htm,html,txt,zip,rar,gz,bz2,gif,jpg,jpeg,png,bmp");

		// 最大文件大小
		long maxSize = 1000000;

		response.setContentType("text/html; charset=UTF-8");

		if (!ServletFileUpload.isMultipartContent(request)) {
			return getError("请选择文件。");

		}
		// 检查目录
		File uploadDir = new File(savePath);
		if (!uploadDir.isDirectory()) {
			return getError("上传目录不存在。");

		}
		// 检查目录写权限
		if (!uploadDir.canWrite()) {
			return getError("上传目录没有写权限。");

		}

		String dirName = request.getParameter("dir");
		if (dirName == null) {
			dirName = "attached";
		}
		if (!extMap.containsKey(dirName)) {
			return getError("目录名不正确。");

		}
		// 创建文件夹
		savePath += dirName + "/";
		saveUrl += dirName + "/";
		File saveDirFile = new File(savePath);
		if (!saveDirFile.exists()) {
			saveDirFile.mkdirs();
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String ymd = sdf.format(new Date());
		savePath += ymd + "/";
		saveUrl += ymd + "/";
		File dirFile = new File(savePath);
		if (!dirFile.exists()) {
			dirFile.mkdirs();
		}
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		Iterator<String> filenames = multipartRequest.getFileNames();
		while (filenames.hasNext()) {
			String filename = filenames.next();
			List<MultipartFile> fileList = multipartRequest.getFiles(filename);
			for (MultipartFile multipartFile : fileList) {
				if (multipartFile.getSize() > maxSize) {
					return getError("上传文件大小超过限制。");

				}
				String fileName = multipartFile.getOriginalFilename();
				String fileExt = fileName.substring(
						fileName.lastIndexOf(".") + 1).toLowerCase();
				if (!Arrays.<String> asList(extMap.get(dirName).split(","))
						.contains(fileExt)) {
					return getError("上传文件扩展名是不允许的扩展名。\n只允许"
							+ extMap.get(dirName) + "格式。");

				}
				SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
				String newFileName = df.format(new Date()) + "_"
						+ new Random().nextInt(1000) + "." + fileExt;
				try {
					File uploadedFile = new File(savePath, newFileName);
					OutputStream stram = new FileOutputStream(uploadedFile);
					stram.write(multipartFile.getBytes());
					stram.close();
					returnMap.put("error", 0);
					returnMap.put("url", saveUrl + newFileName);
					returnMap.put("name", fileName);
					returnMap.put("size", multipartFile.getSize());
					//returnMap.put("id", "file_"+UUIDGenerator.generate());
				} catch (Exception e) {
					return getError("上传文件失败。");

				}

			}

		}
		return returnMap;
	}
	
	/**
	 * 错误信息
	 * @param message
	 * @return
	 */
	private Map<String, Object> getError(String message) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		// JSONObject obj = new JSONObject();
		returnMap.put("error", 1);
		returnMap.put("message", message);
		return returnMap;
	}
	
}
