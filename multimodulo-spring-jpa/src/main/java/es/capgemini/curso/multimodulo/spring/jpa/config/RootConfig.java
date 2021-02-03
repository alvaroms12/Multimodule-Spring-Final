package es.capgemini.curso.multimodulo.spring.jpa.config;

import javax.persistence.EntityManagerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/*
 * Configuracion componentes NO web aplicacion Spring MVC
 */
@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = { "es.capgemini.curso.multimodulo.spring.jpa"})
@EnableJpaRepositories(basePackages = { "es.capgemini.curso.multimodulo.spring.jpa.modelo" })
public class RootConfig {

	@Bean
	public LocalEntityManagerFactoryBean entityManagerFactory() {
		LocalEntityManagerFactoryBean factory = new LocalEntityManagerFactoryBean();

		factory.setPersistenceUnitName("jpa-mysql");

		return factory;
	}

	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		JpaTransactionManager txManager = new JpaTransactionManager();

		txManager.setEntityManagerFactory(entityManagerFactory);

		return txManager;
	}

}
