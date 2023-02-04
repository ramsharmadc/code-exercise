package catalogue.web.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    public static final Set<String> DEFAULT_PRODUCES_AND_CONSUME =
            new HashSet<>(Arrays.asList("application/json"));
    private static final ApiInfo DEFAULT_API_INFO =
            new ApiInfo("EmployeePortalService",
                    "EmployeePortalService Swagger UI",
                    "0.01", "", "", "", "");

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(DEFAULT_API_INFO)
                .produces(DEFAULT_PRODUCES_AND_CONSUME).consumes(DEFAULT_PRODUCES_AND_CONSUME);
    }
}
