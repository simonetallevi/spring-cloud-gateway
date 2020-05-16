package it.try2catch.spingcloudgateway.api.config

import org.springframework.cloud.gateway.route.RouteLocator
import org.springframework.cloud.gateway.route.builder.GatewayFilterSpec
import org.springframework.cloud.gateway.route.builder.PredicateSpec
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import java.net.URI

@Configuration
class RouteConfig {

    companion object {
        private val WORLD_URI: URI = URI.create("http://localhost:8081")
        private val HELLO_URI: URI = URI.create("http://localhost:8082")
    }

    @Bean
    fun apiRoutes(builder: RouteLocatorBuilder): RouteLocator {
        return builder.routes()
                .route { p: PredicateSpec ->
                    p.method(HttpMethod.GET)
                            .and()
                            .path("/world/api/v1/salutation/it")
                            .uri(WORLD_URI)
                }
                .route { p: PredicateSpec ->
                    p.method(HttpMethod.GET)
                            .and()
                            .path("/hello/api/v1/salutation/it/{name}")
                            .uri(HELLO_URI)
                }
                .route { p: PredicateSpec ->
                    p.method(HttpMethod.GET)
                            .and()
                            .path("/ciao/{name}")
                            .filters {
                                it.rewritePath("/ciao/(.*)", "/hello/api/v1/salutation/it/$1")
                            }
                            .uri(HELLO_URI)
                }
                .build()
    }
}
