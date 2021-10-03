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
@EnableJpaRepositories(entityManagerFactoryRef = "coralEntityManagerFactory", transactionManagerRef = "coralTransactionManager", basePackages = {
		"com.falpema.codes.repository" })
public class CoralConfig {

	@Autowired
	private Environment env;

	@Bean
	@ConfigurationProperties(prefix = "coral.datasource.secondary")
	public JndiPropertyHolder segundary() {
		return new JndiPropertyHolder();
	}

	@Bean(name = "coralDaraSource")
	public DataSource coralDatasource() {
		JndiDataSourceLookup dataSourceLookup = new JndiDataSourceLookup();
		DataSource dataSource = dataSourceLookup.getDataSource(segundary().getJndiName());
		return dataSource;
	}

//	@Primary
//	@Bean(name = "coralDaraSource")
//	public DataSource coralDatasource() {
//		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//		dataSource.setUrl(env.getProperty("coral.datasource.url")); // aqui lo del properties
//		dataSource.setUsername(env.getProperty("coral.datasource.username"));
//		dataSource.setPassword(env.getProperty("coral.datasource.password"));
//		dataSource.setDriverClassName(env.getProperty("coral.datasource.driver-class-name"));
//		return dataSource;
//	}

	@Bean(name = "coralEntityManagerFactory") // va el nombr declardo al inicio
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		// se utiliza la coneccion
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(coralDatasource());
		em.setPackagesToScan("com.falpema.codes.entities");

		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);

		// manda propiedades declaradas en el properies.aplication
		Map<String, Object> properties = new HashMap<>();
		properties.put("hibernate.show-sql", env.getProperty("coral.jpa.show-sql")); // muestra sql en consola
		// pendiente pasar dialecto
		em.setJpaPropertyMap(properties);

		return em;
	}

	@Bean(name = "coralTransactionManager") // se hace referecnia a la declaracion en la cabecera
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
