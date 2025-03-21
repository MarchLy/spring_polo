package marchly.datn.backend.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Ecommerce API")
                        .description("Documentation Ecommerce API")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("webtutsplus")
                                .url("http://webtutsplus.com")
                                .email("contact.webtutsplus@gmail.com")
                        )
                )
                .externalDocs(new ExternalDocumentation()
                        .description("Apache 2.0 License")
                        .url("http://www.apache.org/licenses/LICENSE-2.0"));
    }
}
