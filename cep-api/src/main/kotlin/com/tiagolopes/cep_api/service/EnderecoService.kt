package com.tiagolopes.cep_api.service

import com.tiagolopes.cep_api.model.Endereco
import com.tiagolopes.cep_api.repository.EnderecoRepository
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class EnderecoService(
    private val enderecoRepository: EnderecoRepository
) {

    fun buscarEsalvarCep(cep: String): Endereco {
        val cepLimpo = cep.replace("-", "").trim()

        val enderecoExistente = enderecoRepository.findByCep(cepLimpo)
        if (enderecoExistente != null) {
            return enderecoExistente
        }

        val restTemplate = RestTemplate()
        val url = "https://viacep.com.br/ws/$cepLimpo/json/"
        val viaCepResponse = restTemplate.getForObject(url, ViaCepResponse::class.java)
            ?: throw RuntimeException("CEP não encontrado: $cepLimpo")

        val endereco = Endereco(
            cep = cepLimpo,
            logradouro = viaCepResponse.logradouro,
            bairro = viaCepResponse.bairro,
            cidade = viaCepResponse.localidade,
            estado = viaCepResponse.uf
        )

        return enderecoRepository.save(endereco)
    }

    fun listarTodos(): List<Endereco> {
        return enderecoRepository.findAll()
    }
}

data class ViaCepResponse(
    val cep: String = "",
    val logradouro: String = "",
    val bairro: String = "",
    val localidade: String = "",
    val uf: String = ""
)