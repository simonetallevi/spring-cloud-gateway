package it.try2catch.spingcloudgateway.hello.controller

import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import javax.websocket.server.PathParam

@RestController
@RequestMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
class HelloController {

    @GetMapping("/hello/api/v1/salutation/{name}")
    @ResponseStatus(HttpStatus.OK)
    fun salutation(@PathVariable name: String): Map<String, String> {
        return mapOf("salutation" to "Hello $name");
    }

    @GetMapping("/hello/api/v1/error")
    @ResponseStatus(HttpStatus.OK)
    fun error(): Map<String, String> {
        return mapOf("salutation" to "ERROR!");
    }
}
