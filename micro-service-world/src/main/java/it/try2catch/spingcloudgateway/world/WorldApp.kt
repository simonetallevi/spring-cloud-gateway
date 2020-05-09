package it.try2catch.spingcloudgateway.world

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication


@SpringBootApplication
class WorldApp{

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(WorldApp::class.java, *args)
        }
    }
}
