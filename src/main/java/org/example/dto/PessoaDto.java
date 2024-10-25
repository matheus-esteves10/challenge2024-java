package org.example.dto;

import java.time.LocalDate;

public record PessoaDto(Long id, String nome, LocalDate dataNacimento,String cpf, String email, String senha) {
}
