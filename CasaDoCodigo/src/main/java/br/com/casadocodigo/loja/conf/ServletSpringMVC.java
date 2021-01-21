package br.com.casadocodigo.loja.conf;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ServletSpringMVC extends AbstractAnnotationConfigDispatcherServletInitializer {
	// O objetivo de herdar dessa classe � justamente n�o ter que ficar fazendo
	// o registro do DispatcherServlet na m�o.

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { AppWebConfiguration.class, JPAConfiguration.class };
	}

	@Override
	protected String[] getServletMappings() {
		// Aqui � onde voc� diz qual � o padr�o de endere�o que vai ser delegado
		// para o Servlet do Spring MVC.
		return new String[] { "/" };
	}
}
