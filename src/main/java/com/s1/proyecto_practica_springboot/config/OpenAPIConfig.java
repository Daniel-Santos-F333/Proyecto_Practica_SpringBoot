package com.s1.proyecto_practica_springboot.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {
    @Bean

    public OpenAPI customOpenApi(){
        return new OpenAPI()
                .info(new Info()
                        .title("API DOCUMENTADA PRACTICA SPRINGBOOT")
                        .version("1.0")
                        .description("Esta API, se construyó para mostrar el manejo de Swagger y aplicar conocimientos de springboot"));
    }
}
