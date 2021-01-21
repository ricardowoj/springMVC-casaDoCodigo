package br.com.casadocodigo.loja.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import br.com.casadocodigo.loja.controllers.HomeController;
import br.com.casadocodigo.loja.daos.ProductDAO;

@EnableWebMvc
@ComponentScan(basePackageClasses = { HomeController.class, ProductDAO.class })
public class AppWebConfiguration extends WebMvcConfigurerAdapter {
	/*
	 * O objetivo principal dela � expor para a Servlet do Spring MVC quais s�o as
	 * classes que devem ser lidas e carregadas.
	 * 
	 * @ComponentScan. Atrav�s dela indicamos quais pacotes devem ser lidos.
	 * EnableWebMvc habilita v�rias funcionalidades: � Convers�o de objetos para XML
	 * � Convers�o de objetos para JSON � Valida��o usando a especifica��o � Suporte
	 * a gera��o de RSS
	 */
	@Bean
	public InternalResourceViewResolver internalResorceViewResolver() {
		/*
		 * InternalResourceViewResolver, como pode ser lido no pr�prio c�digo, guarda as
		 * configura��es da pasta base e do sufixo que devem ser adicionados para
		 * qualquer caminho que seja retornado por m�todos dos controllers. A
		 * annotation @Bean indica para o Spring que o retorno desse m�todo deve ser
		 * registrado como um objeto gerenciado pelo container.
		 */
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
}