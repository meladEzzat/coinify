/**
 * @author Melad.Ezzat.Aziz
 *
 * @date   JUL 5, 2018
 * @action File Created
 *
 */

package com.coinify.atm.config.swager;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Melad.Ezzat.Aziz
 * @class SwaggerConfig.java
 * @tags
 */
@Configuration
@EnableSwagger2
@PropertySource("classpath:application.properties")
public class SwaggerConfig extends WebMvcConfigurerAdapter {

	/**
	 * 
	 * @return
	 */
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build().apiInfo(apiInfo());
	}

	/**
	 * 
	 * @return
	 */
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Coinify ATM")
				.description("Coinify ATM Documentation").version("V1")
				.termsOfServiceUrl("http://terms-of-services.url").license("LICENSE")
				.licenseUrl("http://url-to-license.com").build();
	}
}