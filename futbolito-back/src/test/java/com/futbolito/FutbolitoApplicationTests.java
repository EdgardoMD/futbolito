package com.futbolito;

import java.util.Properties;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FutbolitoApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void imprimirSystemProperties() {
		Properties properties = System.getProperties();
		properties.forEach((k, v) -> System.out.println(k + ": " + v));
	}

}
