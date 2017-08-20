package com.indra.shoppingbackend.configuration;



import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = "com.indra.shoppingbackend.dto")
@EnableTransactionManagement
public class HibernateConfig {

	private static final String DATABASE_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String DATABASE_URL = "jdbc:oracle:thin:@//localhost:1521/pdborcl";
	private static final String USER_NAME = "hr";
	private static final String PASSWORD = "hr";
	private static final String HIBERNATE_DIALECT = "org.hibernate.dialect.Oracle12cDialect";
	private static final String SHOW_SQL = "true";

	@Bean
	public DataSource getDataSource() {
		BasicDataSource datasource = new BasicDataSource();
		datasource.setDriverClassName(DATABASE_DRIVER);
		datasource.setUrl(DATABASE_URL);
		datasource.setUsername(USER_NAME);
		datasource.setPassword(PASSWORD);
			
		return datasource;
	}
	
	@Bean
	public SessionFactory getSessionFactory(DataSource datasource)
	{
		LocalSessionFactoryBuilder builder=new LocalSessionFactoryBuilder(datasource);
		builder.addProperties(getHibernateProperties());
		builder.scanPackages("com.indra.shoppingbackend.dto");
		return builder.buildSessionFactory();
	}

	private Properties getHibernateProperties() {
		Properties prop=new Properties();
		prop.put("hibernate.dialect",HIBERNATE_DIALECT);
		prop.put("hibernate.show_sql",SHOW_SQL);
		prop.put("hibernate.hbm2ddl.auto", "update");
		return prop;
		
	}
	
	@Bean
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory)
	{
		HibernateTransactionManager transactionManager=new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}
	
	
}
