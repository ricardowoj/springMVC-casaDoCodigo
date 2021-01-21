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
	 * O objetivo principal dela é expor para a Servlet do Spring MVC quais são as
	 * classes que devem ser lidas e carregadas.
	 * 
	 * @ComponentScan. Através dela indicamos quais pacotes devem ser lidos.
	 * EnableWebMvc habilita várias funcionalidades: • Conversão de objetos para XML
	 * • Conversão de objetos para JSON • Validação usando a especificação • Suporte
	 * a geração de RSS
	 */
	@Bean
	public InternalResourceViewResolver internalResorceViewResolver() {
		/*
		 * InternalResourceViewResolver, como pode ser lido no próprio código, guarda as
		 * configurações da pasta base e do sufixo que devem ser adicionados para
		 * qualquer caminho que seja retornado por métodos dos controllers. A
		 * annotation @Bean indica para o Spring que o retorno desse método deve ser
		 * registrado como um objeto gerenciado pelo container.
		 */
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
}