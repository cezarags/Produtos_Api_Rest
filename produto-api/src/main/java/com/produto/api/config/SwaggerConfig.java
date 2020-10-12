package com.produto.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2


public class SwaggerConfig {
		
		
	    @Bean
	    public Docket produtoapi() {
	        return new Docket(DocumentationType.SWAGGER_2)
	          .select()
	          .apis(RequestHandlerSelectors.basePackage("com.produto.api")) // caminho do spacote com todas as classes
	          .paths(PathSelectors.regex("/api.*"))                         // caminho padrão 
	          .build()
	          .apiInfo(metaInfo());                                        //armazenando no objeto informaçoes do desenvolvedor    
	    }

	    private ApiInfo metaInfo(){
	    	return new ApiInfoBuilder()
	    	.title("Produtos Api Rest")
	    	.description("API Rest de cadastro de produstos")
	    	.version("1.0")
	    	.contact(contact())
	    	.build();
	    	}
	    	private Contact contact(){
	    	return new Contact("Cezar Augusto", "cezar.ags@icloud.com",
	    	"https://github.com/cezarags/Produtos_Api_Rest");
	    	}
	}
	


