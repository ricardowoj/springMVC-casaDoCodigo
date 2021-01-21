package br.com.casadocodigo.loja.conf;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ServletSpringMVC extends AbstractAnnotationConfigDispatcherServletInitializer {
	// O objetivo de herdar dessa classe é justamente não ter que ficar fazendo
	// o registro do DispatcherServlet na mão.

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
		// Aqui é onde você diz qual é o padrão de endereço que vai ser delegado
		// para o Servlet do Spring MVC.
		return new String[] { "/" };
	}
}
