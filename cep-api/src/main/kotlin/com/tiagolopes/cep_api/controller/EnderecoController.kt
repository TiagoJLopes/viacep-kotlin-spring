package com.tiagolopes.cep_api.controller

import com.tiagolopes.cep_api.model.Endereco
import com.tiagolopes.cep_api.service.EnderecoService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/enderecos")
class EnderecoController(
    private val enderecoService: EnderecoService
) {

    @GetMapping
    fun listarTodos(): ResponseEntity<List<Endereco>> {
        val enderecos = enderecoService.listarTodos()
        return ResponseEntity.ok(enderecos)
    }

    @GetMapping("/{cep}")
    fun buscarPorCep(@PathVariable cep: String): ResponseEntity<Endereco> {
        val endereco = enderecoService.buscarEsalvarCep(cep)
        return ResponseEntity.ok(endereco)
    }
}