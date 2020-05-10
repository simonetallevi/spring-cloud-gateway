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
                            .path("/world/api/v1/salutation")
                            .uri(WORLD_URI)
                }
                .route { p: PredicateSpec ->
                    p.method(HttpMethod.GET)
                            .and()
                            .path("/hello/api/v1/salutation/{name}")
                            .uri(HELLO_URI)
                }
                .route { p: PredicateSpec ->
                    p.method(HttpMethod.GET)
                            .and()
                            .path("/hello/{name}")
                            .filters {
                                it.rewritePath("/hello/(.*)", "/hello/api/v1/salutation/$1")
                            }
                            .uri(HELLO_URI)
                }
                .route { p: PredicateSpec ->
                    p.method(HttpMethod.GET)
                            .and()
                            .path("/hello-error/{name}")
                            .filters { it ->
                                it.circuitBreaker {
                                    it.fallbackUri = URI.create("forward:/hello/api/v1/error")
                                }
                            }
                            .uri(HELLO_URI)
                }
                .build()
    }
}
