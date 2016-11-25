package com.mamad.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mamad.model.administration.Workgroup;
import com.mamad.service.WorkgroupService;
import com.mamad.service.WorkgroupServiceImpl;



/**
 * This class subsititute the [nameservlet]-servlet.xml for the configuration
 * of all redirection, database configuration, session ...
 * config... test commit
 * @author Mamadou
 *
 */
/**
 * @author Mamad
 *
 */
@Configuration
@ComponentScan("com.mamad.*")
@EnableTransactionManagement
public class ContextConfiguration {
	
	/**
	 * initialisation des dossiers
	 * @return
	 */
    @Bean(name = "viewResolver")
    public InternalResourceViewResolver getViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
     
    /**
     * define the parameters to connect to the database
     * @return
     */
    @Bean(name = "dataSource")
    public DataSource getDataSource() {
    	BasicDataSource dataSource = new BasicDataSource();
    	dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    	dataSource.setUrl("jdbc:sqlserver://192.168.0.134:1433;databaseName=medisys");
    	dataSource.setUsername("sa");
    	dataSource.setPassword("Lounis2015");
    	return dataSource;
    }
    
    /**
     * getting hibernate properties
     * @return
     */
    private Properties getHibernateProperties() {
    	Properties properties = new Properties();
    	properties.put("hibernate.show_sql", "true");
    	properties.put("hibernate.dialect", "org.hibernate.dialect.SQLServerDialect");
    	return properties;
    }
    
    @Autowired
    @Bean(name = "sessionFactory")
    public SessionFactory getSessionFactory(DataSource dataSource) {
    	LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
    	sessionBuilder.addProperties(getHibernateProperties());
    	sessionBuilder.addAnnotatedClasses(Workgroup.class);
    	return sessionBuilder.buildSessionFactory();
    }
    
	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(
			SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(
				sessionFactory);

		return transactionManager;
	}
    /*@Autowired
    @Bean(name = "workgroupDao")
    public WorkgroupDao getWorkgroupDao(SessionFactory sessionFactory) {
    	return new WorkgroupDaoImpl(sessionFactory);
    }*/
	/**
	 * using service, for get dao access to the database
	 * @param sessionFactory
	 * @return
	 */
    @Autowired
    @Bean(name = "workgroupService")
    public WorkgroupService getWorkgroupService(SessionFactory sessionFactory) {
    	return new WorkgroupServiceImpl(sessionFactory);
    }
}
