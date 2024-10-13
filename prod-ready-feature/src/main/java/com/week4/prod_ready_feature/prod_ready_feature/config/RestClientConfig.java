package com.week4.prod_ready_feature.prod_ready_feature.config;

import com.week4.prod_ready_feature.prod_ready_feature.exceptions.ResourceNotFound;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.client.RestClient;

import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@Configuration
public class RestClientConfig {

    @Value("${employeeService.base.url}")
    private String Base_Url;

    @Bean
    @Qualifier("getEmployeeServiceRestClient")
    RestClient getEmployeeServiceRestClient(){
        return RestClient.builder()
                .baseUrl(Base_Url)
                .defaultHeader(CONTENT_TYPE, APPLICATION_JSON_VALUE)
                .defaultStatusHandler(HttpStatusCode::is5xxServerError, (req, res)->{
                    throw new RuntimeException("Server Not  found");
                })
                .build();
    }
}
