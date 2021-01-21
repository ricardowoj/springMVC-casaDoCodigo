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
	 * A annotation @Bean, usada em cima dos m�todos, � para indicar que os objetos
	 * criados por eles v�o ser gerenciados pelo Spring e podem ser injetados em
	 * qualquer ponto do c�digo.
	 */
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		/*
		 * cria alguns objetos que s�o importantes para o nosso entendimento do que
		 * realmente est� acontecendo. A classe LocalContainerEntityManagerFactoryBean �
		 * a abstra��o do arquivo persistence.xml, que geralmente � necess�rio para
		 * termos a JPA funcionando no nosso projeto.
		 */
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource());
		em.setPackagesToScan(new String[] {"br.com.casadocodigo.loja.models"});
		
		/*
		 * A classe HibernateJpaVendorAdapter representa a nossa escolha de
		 * implementa��o da JPA que, no nosso projeto, ser� o Hibernate. O m�dulo de ORM
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
		 * O m�todo dataSource() serve para configurarmos os par�metros de conex�o com o
		 * banco de dados. Voc� vai usar esse mesmo estilo de configura��o mesmo que
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
