package com.daywid.Spring.Studies.integrationTest.swagger;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.Assertions;   
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.daywid.Spring.Studies.configs.TestConfigs;
import com.daywid.Spring.Studies.integrationTest.testcontainers.AbstractIntegrationTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class SwaggerIntegrationTest extends AbstractIntegrationTest{
    
    @Test
    public void shouldDisplaySwaggerUiPage(){

        var content =   

        given()
        .basePath("/swagger-ui/index.html")
        .port(TestConfigs.SERVER_PORT)
        .when()
            .get()
        .then()
            .statusCode(200)
        .extract()
            .body()
                .asString();
    
    Assertions.assertTrue(content.contains("Swagger UI"));
    }

}