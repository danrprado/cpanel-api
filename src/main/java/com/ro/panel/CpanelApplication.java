package com.ro.panel;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.logging.Logger;

@SpringBootApplication
public class CpanelApplication implements InitializingBean {

	public static void main(String[] args) {
		SpringApplication.run(CpanelApplication.class, args);
	}

	private static final Logger Log
			= Logger.getLogger(String.valueOf(CpanelApplication.class));

	public CpanelApplication(){
		Log.info("Constructor");
	}

	@Override
	public void afterPropertiesSet() {
		Log.info("InitializingBean");
	}

	@PostConstruct
	public void postConstruct(){
		Log.info("PostConstruct");
	}


}
