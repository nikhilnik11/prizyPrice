package com.xebia.prizy.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class PrizyConfig {
	
	//private static final String H2_JDBC_URL_TEMPLATE = "jdbc:h2:%s/target/db/sample;AUTO_SERVER=TRUE";

	
	/*@Bean
	public DataSource dataSource(Environment env) throws Exception {
	        return createH2DataSource();
	}

	private DataSource createH2DataSource() {
	    String jdbcUrl = String.format(H2_JDBC_URL_TEMPLATE, System.getProperty("user.dir"));
	    JdbcDataSource ds = new JdbcDataSource();       
	    ds.setURL(jdbcUrl);
	    ds.setUser("sa");
	    ds.setPassword("");

	    return ds;
	}*/
}
