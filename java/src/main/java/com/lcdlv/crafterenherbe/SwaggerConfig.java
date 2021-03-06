package com.lcdlv.crafterenherbe;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(SwaggerConfig.class);

    @Bean
    public Docket restAPI() {
        LOGGER.debug("initializing Swagger Docket...");

        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                .forCodeGeneration(true)
                .genericModelSubstitutes(ResponseEntity.class).select()
                .paths(regex("/.*"))
                .build()
                .useDefaultResponseMessages(false);
    }

    /**
     * API Info as it appears on the swagger-ui page
     */

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Harry potter Library").description("Buy the best books ever!")
                .termsOfServiceUrl("").licenseUrl("")
                .version("1.0").build();
    }
}