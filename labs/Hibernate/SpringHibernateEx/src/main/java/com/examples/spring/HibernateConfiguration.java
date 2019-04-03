package com.examples.spring;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.dialect.H2Dialect;
import org.hibernate.dialect.MySQLDialect;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate3.HibernateTransactionManager;
import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;

import com.mysql.cj.jdbc.MysqlDataSource;

@Configuration
public class HibernateConfiguration {

//	@Value("#{dataSource}")
//	private DataSource dataSource;
	@Bean
	public MysqlDataSource dataSource() {
		MysqlDataSource dataSource = new MysqlDataSource();
		dataSource.setDatabaseName("ekart");
		dataSource.setUser("root");
		dataSource.setPassword("");
		dataSource.setServerName("localhost");	
		return dataSource;
	}

	@Bean
	public AnnotationSessionFactoryBean sessionFactoryBean() {
		Properties props = new Properties();
		props.put("hibernate.dialect", MySQLDialect.class.getName());
		props.put("show_sql", true);
		props.put("hibernate.format_sql", "true");

		AnnotationSessionFactoryBean bean = new AnnotationSessionFactoryBean();
		bean.setAnnotatedClasses(new Class[]{Item.class, Order.class});		
		bean.setHibernateProperties(props);
		bean.setDataSource(dataSource());
		bean.setSchemaUpdate(true);
		return bean;
	}
	
	

	@Bean
	public HibernateTransactionManager transactionManager() {
		return new HibernateTransactionManager( sessionFactoryBean().getObject() );
	}

}
