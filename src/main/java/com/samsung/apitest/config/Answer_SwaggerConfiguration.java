//package com.samsung.apitest.config;
//
//import static springfox.documentation.builders.PathSelectors.regex;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.test.context.junit.jupiter.DisabledIf;
//
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Contact;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//@EnableSwagger2 
//@Configuration
//@ComponentScan(basePackages = {"com.samsung.apitest"})
//public class Answer_SwaggerConfiguration {
//
//	@Bean
//	public Docket api() {
//		return new Docket(DocumentationType.SWAGGER_2)
//				.apiInfo(apiInfo())
//				.select()
//				.paths(regex("/student.*"))
//				.build();
//	}
//
//	private ApiInfo apiInfo() {
//		return new ApiInfoBuilder()
//				.title("Sample API Test")
//				.description("Swagger UI sample")
//				.contact(new Contact("Martin", "myblog.com", "test@naver.com"))
//				.version("1.0")
//				.build();
//	}
//}
