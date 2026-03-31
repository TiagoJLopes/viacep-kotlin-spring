package com.tiagolopes.cep_api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CepApiApplication

fun main(args: Array<String>) {
	runApplication<CepApiApplication>(*args)
}
