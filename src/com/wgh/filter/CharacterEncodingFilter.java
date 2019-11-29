package com.wgh.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
@WebFilter(
		urlPatterns = { "/*" }, 
		initParams = { 
				@WebInitParam(name = "encoding", value = "UTF-8")
		})														//���ù�����
public class CharacterEncodingFilter implements Filter {

	protected String encoding = null; // ��������ʽ����
	protected FilterConfig filterConfig = null; // ������������ö���

	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig; // ��ʼ�����������ö���
		this.encoding = filterConfig.getInitParameter("encoding"); // ��ȡ�����ļ���ָ���ı����ʽ
	}

	// �������Ľӿڷ���������ִ�й���ҵ��
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		if (encoding != null) {
			request.setCharacterEncoding(encoding); // ��������ı���
			// ����Ӧ�������������ͣ����������ʽ��
			response.setContentType("text/html; charset=" + encoding);
		}
		chain.doFilter(request, response); // ���ݸ���һ��������
	}

	public void destroy() {
		this.encoding = null;
		this.filterConfig = null;
	}
}
