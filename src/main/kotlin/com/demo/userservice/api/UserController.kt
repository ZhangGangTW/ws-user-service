package com.demo.userservice.api

import com.demo.userservice.model.User
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/users")
class UserController(
    @Value("\${adapter.api-key}")
    private val apiKey: String
) {
    @GetMapping("{id}")
    fun getUserById(
        @PathVariable("id") id: String,
        @RequestHeader("api-key") requestApiKey: String
    ): Mono<User> {
        if (apiKey != requestApiKey) {
            throw IllegalAccessException()
        }
        return Mono.just(
            User(
                id = id,
                username = "user-$id",
                role = "USER",
                email = "user$id@test.com",
                groupId = "g1"
            )
        )
    }
}