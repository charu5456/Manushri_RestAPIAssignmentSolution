package com.greatlearning.employeemanagement.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket libraryApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(ApiInfo())
				.groupName("Employee-Api").select()
				.apis(RequestHandlerSelectors.basePackage("com.greatlearning.employeemanagement.controller")).build();
	}
	private ApiInfo ApiInfo() {
		return new ApiInfoBuilder().title("Employee Management UI").version("1.0.0").description("Management").build();
	}
}