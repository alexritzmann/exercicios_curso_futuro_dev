package br.futurodev.joinville.spring.dtos;

public record MaterialResponseDto(
        Long id,
        String nome,
        String descricao
) {
}