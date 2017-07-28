package com.niit.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
	@ComponentScan("com.niit")
	@EnableTransactionManagement
	public class DBConfig {
		
		
		
		@Bean(name="dataSource")
		public DataSource getOracleDataSource()
		{
			
			DriverManagerDataSource dataSource = new DriverManagerDataSource();
			dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
			dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
			dataSource.setUsername("akshat");
			dataSource.setPassword("akshat");
			
			
			Properties connectionProperties = new Properties();

			connectionProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");

			dataSource.setConnectionProperties(connectionProperties);
			
			
			return dataSource;
		}
		
		
		@Autowired
		@Bean(name = "sessionFactory")
		public SessionFactory getSessionFactory(DataSource dataSource) {

			LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
			Properties connectionProperties = new Properties();

			connectionProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");

			sessionBuilder.addProperties(connectionProperties);
			//sessionBuilder.addAnnotatedClass(User.class);

			// sessionBuilder.addAnnotatedClass(User.class);

			return sessionBuilder.buildSessionFactory();
		}

		@Autowired
		@Bean(name = "transactionManager")
		public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {

			HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);

			return transactionManager;
		}

		
		
		

}
