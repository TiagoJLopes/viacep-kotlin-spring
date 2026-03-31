package com.tiagolopes.cep_api.repository

import com.tiagolopes.cep_api.model.Endereco
import org.springframework.data.jpa.repository.JpaRepository

interface EnderecoRepository : JpaRepository<Endereco, Long> {
    fun findByCep(cep: String): Endereco?
}