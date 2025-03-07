package com.Arthur.transacao_api.controller.dtos;

import java.time.OffsetDateTime;

public record TransasaoRequestDTO(Double valor, OffsetDateTime dataHora) {
}
