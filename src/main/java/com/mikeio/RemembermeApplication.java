package com.mikeio;

import com.mikeio.config.MikeIoProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
@EnableConfigurationProperties({MikeIoProperties.class})
public class RemembermeApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(RemembermeApplication.class, args);
	}


	/**
	 * Used when run as WAR
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(RemembermeApplication.class);
	}


}
