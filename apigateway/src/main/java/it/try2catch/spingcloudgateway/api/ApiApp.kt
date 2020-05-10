package it.try2catch.spingcloudgateway.api

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class ApiApp {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(ApiApp::class.java, *args)
        }
    }
}
