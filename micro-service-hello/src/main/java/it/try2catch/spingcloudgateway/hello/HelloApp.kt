package it.try2catch.spingcloudgateway.hello

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class HelloApp {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(HelloApp::class.java, *args)
        }
    }
}
