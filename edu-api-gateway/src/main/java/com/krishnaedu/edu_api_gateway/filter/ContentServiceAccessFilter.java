package com.krishnaedu.edu_api_gateway.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.web.server.ServerWebExchange;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@Component
public class ContentServiceAccessFilter extends AbstractGatewayFilterFactory<ContentServiceAccessFilter.Config> {

    public ContentServiceAccessFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            ServerWebExchange serverWebExchange = exchange;
            String path = serverWebExchange.getRequest().getURI().getPath();
            HttpMethod method = serverWebExchange.getRequest().getMethod();
            String token = serverWebExchange.getRequest().getHeaders().getFirst("Authorize");

            if (config.getProtectedPaths().contains(path) && config.getProtectedMethods().contains(method)) {


                HttpResponse<String> response = null;
                try {
                    HttpRequest request = HttpRequest.newBuilder()
                            .uri(URI.create("http://localhost:8080/security/auth/token/verify"))
                            .header("Content-Type", "application/text")
                            .POST(HttpRequest.BodyPublishers.ofString(token))
                            .build();

                    response = HttpClient.newHttpClient()
                            .send(request, HttpResponse.BodyHandlers.ofString());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    if(response.statusCode() != HttpStatus.OK.value()){
                        serverWebExchange.getResponse().setStatusCode(HttpStatus.FORBIDDEN);
                        return serverWebExchange.getResponse().setComplete();
                    }
                }
            }

            return chain.filter(exchange);
        };
    }

    public static class Config {
        private List<String> protectedPaths;
        private List<HttpMethod> protectedMethods;

        public List<String> getProtectedPaths() {
            return protectedPaths;
        }

        public void setProtectedPaths(List<String> protectedPaths) {
            this.protectedPaths = protectedPaths;
        }

        public List<HttpMethod> getProtectedMethods() {
            return protectedMethods;
        }

        public void setProtectedMethods(List<HttpMethod> protectedMethods) {
            this.protectedMethods = protectedMethods;
        }
    }
}
