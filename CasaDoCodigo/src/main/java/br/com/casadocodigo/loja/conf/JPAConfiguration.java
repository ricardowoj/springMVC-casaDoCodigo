package br.com.casadocodigo.loja.conf;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

public class JPAConfiguration {
	
	/*
	 * A annotation @Bean, usada em cima dos métodos, é para indicar que os objetos
	 * criados por eles vão ser gerenciados pelo Spring e podem ser injetados em
	 * qualquer ponto do código.
	 */
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		/*
		 * cria alguns objetos que são importantes para o nosso entendimento do que
		 * realmente está acontecendo. A classe LocalContainerEntityManagerFactoryBean é
		 * a abstração do arquivo persistence.xml, que geralmente é necessário para
		 * termos a JPA funcionando no nosso projeto.
		 */
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource());
		em.setPackagesToScan(new String[] {"br.com.casadocodigo.loja.models"});
		
		/*
		 * A classe HibernateJpaVendorAdapter representa a nossa escolha de
		 * implementação da JPA que, no nosso projeto, será o Hibernate. O módulo de ORM
		 * do Spring suporta ainda, nativamente, o EclipseLink e a OpenJPA.
		 */
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		em.setJpaProperties(additionalProperties());
		
		return em;
	}
	
	@Bean
	public DataSource dataSource() {
		/*
		 * O método dataSource() serve para configurarmos os parâmetros de conexão com o
		 * banco de dados. Você vai usar esse mesmo estilo de configuração mesmo que
		 * esteja usando JDBC puro, ou qualquer outro framework de acesso a dados.
		 */
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/casadocodigo");
		dataSource.setUsername("root");
		dataSource.setPassword("");
		return dataSource;
	}
	
	private Properties additionalProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		properties.setProperty("hibernate.show_sql", "true");
		return properties;
	}
}
