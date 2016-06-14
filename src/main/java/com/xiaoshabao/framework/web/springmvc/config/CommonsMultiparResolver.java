package com.xiaoshabao.framework.web.springmvc.config;
/**
 * 实现自己的spring上传设置
 */
public class CommonsMultiparResolver extends org.springframework.web.multipart.commons.CommonsMultipartResolver{
	
	@Override  
    public boolean isMultipart(javax.servlet.http.HttpServletRequest request) {  
          
        String uri = request.getRequestURI();  
        //过滤使用百度EmEditor的URI  
        /*
        if (uri.indexOf("ueditor/dispatch.html") > 0) {   
            return false;  
        } 
        */ 
        return super.isMultipart(request);  
    }  
}
