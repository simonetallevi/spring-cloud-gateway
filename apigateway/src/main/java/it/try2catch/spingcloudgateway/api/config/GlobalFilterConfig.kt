package it.try2catch.spingcloudgateway.api.config

import it.try2catch.spingcloudgateway.api.utils.Utils.Companion.getLogger
import org.springframework.cloud.gateway.filter.GatewayFilterChain
import org.springframework.cloud.gateway.filter.GlobalFilter
import org.springframework.cloud.gateway.route.Route
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.server.ServerWebExchange
import reactor.core.publisher.Mono
import java.time.Instant

@Configuration
class GlobalFilterConfig {

    var log = getLogger(GlobalFilterConfig::class.java)

    @Bean
    fun globalFilter(): GlobalFilter {
        return GlobalFilter { exchange: ServerWebExchange, chain: GatewayFilterChain ->

            val startTime = Instant.now()
            val request = exchange.request.methodValue + " " + exchange.request.uri.path
            val route = exchange.getAttribute<Route>(ServerWebExchangeUtils.GATEWAY_ROUTE_ATTR)

            log.info("Request {} routed to: {}", request, route)

            chain.filter(exchange).then(
                    Mono.fromRunnable {
                        val elapsed = Instant.now().minusMillis(startTime.toEpochMilli()).toEpochMilli()
                        log.info("Result: {} completed in {} ms with status code: {}", request, elapsed, exchange.response.statusCode)
                    })
        }
    }
}
