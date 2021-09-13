package cl.mobdev.ejercicio.swagger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


import java.util.Collections;
import java.util.List;

@EnableSwagger2
@Configuration
public class SwaggerConfig {
	//http://localhost:8010/swagger-ui.html
    @Bean
    public Docket apiInfo() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("cl.mobdev.ejercicio"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(swaggerInfo());
    }

    @SuppressWarnings("unchecked")
    // Suprimir warnings nos previene de encontrar formas mejores de hacer las cosas
	private ApiInfo swaggerInfo() {
    	@SuppressWarnings("rawtypes")
		List<VendorExtension> vendorExtension = Collections.EMPTY_LIST;
        ApiInfo apiInfo = new ApiInfo(
                "MOBDEV",
                "Prueba consumo API",
                "1.0",
                "Terms of Service",
                new Contact("Christian", "https://localhost:8010/mobdev/v1",
                        "chr.mondaca@gmail.com"),
                "Apache License Version 2.0",
                "https://www.apache.org/licesen.html", vendorExtension
        );

        return apiInfo;
    }
}
