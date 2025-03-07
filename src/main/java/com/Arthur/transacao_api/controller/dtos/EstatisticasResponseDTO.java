package com.Arthur.transacao_api.controller.dtos;

public record EstatisticasResponseDTO(long count,
                                      Double sun,
                                      Double avg,
                                      Double min,
                                      Double max) {
}
