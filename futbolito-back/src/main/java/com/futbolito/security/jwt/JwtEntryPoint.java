package com.futbolito.security.jwt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class JwtEntryPoint {

    private final static Logger logger = LoggerFactory.getLogger(JwtEntryPoint.class);

	public static Logger getLogger() {
		return logger;
	}
    
    


}
