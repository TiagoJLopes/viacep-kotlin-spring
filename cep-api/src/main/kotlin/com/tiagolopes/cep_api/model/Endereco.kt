package com.tiagolopes.cep_api.model

import jakarta.persistence.*

@Entity
@Table(name = "enderecos")
data class Endereco(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false, unique = true)
    val cep: String,

    val logradouro: String,
    val bairro: String,
    val cidade: String,
    val estado: String
)