package de.e2security.e2netwatch.config;

import java.time.LocalDate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket mainConfig() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.ant("/um/**"))
				.build()
				.pathMapping("/")
				.directModelSubstitute(LocalDate.class, String.class)
				.genericModelSubstitutes(ResponseEntity.class);
	}

}
