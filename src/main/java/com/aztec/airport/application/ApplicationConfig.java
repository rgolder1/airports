package com.aztec.airport.application;

import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Main application config.
 *
 * @author robertgolder
 */
@Configuration
public class ApplicationConfig {

    @Value("${aztec.airport.username}")
    public String username;

    @Value("${aztec.airport.password}")
    private String password;

    @Bean
    public RestTemplate restTemplate() {

        HttpClientBuilder builder = HttpClientBuilder.create();

        CredentialsProvider provider = new BasicCredentialsProvider();
        AuthScope scope = new AuthScope(AuthScope.ANY_HOST, AuthScope.ANY_PORT, AuthScope.ANY_REALM);
        UsernamePasswordCredentials credentials = new UsernamePasswordCredentials(username, password);
        provider.setCredentials(scope, credentials);
        builder.setDefaultCredentialsProvider(provider);
        HttpClient client = builder.build();
        RestTemplate template = new RestTemplate(new HttpComponentsClientHttpRequestFactory(client));

        return template;
    }
}
