package it.try2catch.spingcloudgateway.world.controller

import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
class WorldController{

    @GetMapping("/world/api/v1/salutation/en")
    @ResponseStatus(HttpStatus.OK)
    fun salutationEn(): Map<String, String> {
        return mapOf("salutation" to "Hello World");
    }

    @GetMapping("/world/api/v1/salutation/it")
    @ResponseStatus(HttpStatus.OK)
    fun salutationIt(): Map<String, String> {
        return mapOf("salutation" to "Ciao Mondo");
    }
}
