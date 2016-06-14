package com.xiaoshabao.wxweb.controller.module;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.baidu.ueditor.ActionEnter;
import com.xiaoshabao.framework.web.springmvc.exception.DaoException;

@Controller
//@RequestMapping(value="/resources/js/plugins/ueditor")
@RequestMapping(value="/ueditor")
public class UeditorController {
	
	
	@RequestMapping(value="/dispatch")
	public void reqURL (ModelMap model,HttpServletRequest request,HttpServletResponse response,String action) throws DaoException{
		response.setContentType("application/json");
		Map<String,Object> params=new HashMap<>();
		Enumeration<String> paramnames = request.getParameterNames();
		while (paramnames.hasMoreElements()) {
			String paramname = paramnames.nextElement();
			params.put(paramname,request.getParameter(paramname));
		}
		String rootPath = request.getSession().getServletContext().getRealPath("/");
		try {
			request.setCharacterEncoding( "utf-8" );
			response.setHeader("Content-Type" , "text/html");
			String exec = new ActionEnter(request, rootPath).exec();
			PrintWriter writer = response.getWriter();
			writer.write(exec);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
