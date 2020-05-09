package it.try2catch.spingcloudgateway.hello.controller

import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
class HelloController{

    @GetMapping("/api/v1/salutation")
    @ResponseStatus(HttpStatus.OK)
    fun salutation(): Map<String, String> {
        return mapOf("salutation" to "Hello");
    }
}
