package com.falpema.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "goEntityManagerFactory", transactionManagerRef = "goTransactionManager", basePackages = {
		"com.falpema.go.repository" })
public class GoConfig {

	@Autowired
	private Environment env;

	@Bean
	@ConfigurationProperties(prefix = "spring.datasource.primary")
	public JndiPropertyHolder primary() {
		return new JndiPropertyHolder();
	}

	@Bean(name = "goDataSource")
	public DataSource goDatasource() {
		JndiDataSourceLookup dataSourceLookup = new JndiDataSourceLookup();
		DataSource dataSource = dataSourceLookup.getDataSource(primary().getJndiName());
		return dataSource;
	}

//	@Bean(name = "goDataSource")
//	public DataSource goDatasource() {
//		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//		dataSource.setUrl(env.getProperty("spring.datasource.url")); // aqui lo del properties
//		dataSource.setUsername(env.getProperty("spring.datasource.username"));
//		dataSource.setPassword(env.getProperty("spring.datasource.password"));
//		dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
//		return dataSource;
//	}

	@Bean(name = "goEntityManagerFactory") // va el nombr declardo al inicio
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		// se utiliza la coneccion
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(goDatasource());
		em.setPackagesToScan("com.falpema.go.entities");

		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);

		// manda propiedades declaradas en el properies.aplication
		Map<String, Object> properties = new HashMap<>();
		properties.put("hibernate.show-sql", env.getProperty("spring.jpa.show-sql")); // muestra sql en consola
		// pendiente pasar dialecto
		em.setJpaPropertyMap(properties);

		return em;
	}

	@Bean(name = "goTransactionManager") // se hace referecnia a la declaracion en la cabecera
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		// mando el metodo anterior
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());

		return transactionManager;
	}

	private static class JndiPropertyHolder {
		private String jndiName;

		public String getJndiName() {
			return jndiName;
		}

		@SuppressWarnings("unused")
		public void setJndiName(String jndiName) {
			this.jndiName = jndiName;
		}
	}
}
