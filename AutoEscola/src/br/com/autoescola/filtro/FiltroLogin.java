package br.com.autoescola.filtro;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FiltroLogin implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
//		HttpServletRequest req = (HttpServletRequest) request;
//		HttpServletResponse res = (HttpServletResponse) response;
//		HttpSession session = req.getSession();
//
//		Funcionario admin = session.getAttribute("loginHandler") != null ? ((LoginHandler) session.getAttribute("loginHandler")).getFuncionario() : null ;
//
//		if (admin == null) {
//			res.sendRedirect("../pagLogin/login.xhtml");
//		} else {
//			chain.doFilter(request, response);
//		}
			chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}
	 

}
