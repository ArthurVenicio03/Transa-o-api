package com.Arthur.transacao_api.business.services;


import com.Arthur.transacao_api.controller.dtos.TransasaoRequestDTO;
import com.Arthur.transacao_api.infrastruture.exceptions.UnprocessableEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class TransacaoService {
    //vou usar uma forma simples em array list pois no desafio deixou claro Que não pode usar banco de dados
    //fora que arraylist é uma forma simples pois ele é facil de lidar
    //Preciso calcular estatisticas, deletar transações e armazenar transações em memoria
    //vou criar uma lista chamada listadetransações e vamos dar um newarraylist pra gravar os dados dessa lista, .add pra adicionar os dados da lista e o .clear para apaagr os dados
    private final List<TransasaoRequestDTO> listaTransacoes = new ArrayList<>();

    public void adicionarTransacao(TransasaoRequestDTO dto) {
        log.info("Iniciando o processamento de gravar transações" + dto);
        if (dto.dataHora().isAfter(OffsetDateTime.now())) {
            log.error("Data e hora maior que a data atual");
            throw new UnprocessableEntity("Data e hora maior que a data e hora atual ");
        }
        if (dto.valor() < 0){
            log.error("Valor negativo");
            throw new UnprocessableEntity("Valor deve ser maior que zero");
        }


        listaTransacoes.add(dto);
        log.info("transações adicionadas com sucesso");
    }

    public void limparTransacoes() {
        log.info("Iniciado processamento para deletar transações");
        listaTransacoes.clear();
        log.info("transações deletadas com sucesso");
    }
    //metodo que busca transações de acordo com o intervalo de tempo
    // intervalo é a data e hora atual - os segundos do intervalo de busca
    //
    public List<TransasaoRequestDTO> buscarTransacoes(Integer intervaloBusca) {
        log.info("Iniciadas as buscas de transações por tempo" + intervaloBusca);
        OffsetDateTime dataHoraIntervalo = OffsetDateTime.now().minusSeconds(intervaloBusca);
        log.info("retorno de transações com sucesso");
        return listaTransacoes.stream()
                .filter(transacoes -> transacoes.dataHora()
                     .isAfter(dataHoraIntervalo)).toList();
    }
    //lista de transações que aconteceram nos ultimos 60 segundos
}
