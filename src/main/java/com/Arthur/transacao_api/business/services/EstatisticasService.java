package com.Arthur.transacao_api.business.services;


import com.Arthur.transacao_api.controller.dtos.EstatisticasResponseDTO;
import com.Arthur.transacao_api.controller.dtos.TransasaoRequestDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.DoubleSummaryStatistics;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j

public class EstatisticasService {
    public final TransacaoService transacaoService;

    public EstatisticasResponseDTO calcularEstatisticasTransações(Integer intervalorBusca){

        log.info("Iniciada a busca de estatisticas de transações pelo periodo de tempo" + intervalorBusca);

      List<TransasaoRequestDTO> transacoes = transacaoService.buscarTransacoes(intervalorBusca);
        DoubleSummaryStatistics estatisticasTransacoes = transacoes.stream()
                                                                    .mapToDouble(TransasaoRequestDTO::valor)
                                                                    .summaryStatistics();
        if (transacoes.isEmpty()) {
            return new EstatisticasResponseDTO(0L, 0.0, 0.0, 0.0, 0.0);
        }
                log.info("Estatisticas retornadas com sucesso");

        return new EstatisticasResponseDTO(estatisticasTransacoes.getCount(),
                                            estatisticasTransacoes.getSum(),
                                            estatisticasTransacoes.getAverage(),
                                            estatisticasTransacoes.getMin(),
                                            estatisticasTransacoes.getMax());
    };
}
