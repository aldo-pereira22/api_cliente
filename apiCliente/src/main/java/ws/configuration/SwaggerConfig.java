package ws.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2).useDefaultResponseMessages(false).groupName("v0").select()
                .apis(RequestHandlerSelectors.basePackage("ws.controller"))
                .paths(PathSelectors.any()).build().apiInfo(apiInfo());
    }
//    
//    private ApiInfo apiInfo() {
//    	ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();
//    	
//    	return apiInfoBuilder
//    			.title("Treinamento WebServices")
//    			.description("API para cadastros de alunos de um curso")
//    			.version("0.0.1")
//    			.license("Curso de Tecnologia")
//    			.build();
//    }
    
    private ApiInfo apiInfo() {
        ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();

        return apiInfoBuilder
                .title("Rasmoo Plus")
                .description("Api para atender o cadastro de alunos de CURSOS")
                .version("0.0.1")
                .license("Curso de Tecnologiia de Informação")
                .build();
    }
}
