package org.test.boot;

import org.springframework.context.annotation.Bean;

public class AAAConfiguration {

	@Bean
	public AAA AAA() {
		return new AAA();
	}
}
