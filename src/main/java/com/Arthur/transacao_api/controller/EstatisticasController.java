package com.Arthur.transacao_api.controller;


import com.Arthur.transacao_api.business.services.EstatisticasService;
import com.Arthur.transacao_api.controller.dtos.EstatisticasResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estatistica")
@RequiredArgsConstructor
public class EstatisticasController {

    private final EstatisticasService estatisticasService;

    @GetMapping
    @Operation(description = "Endpoint responsavel por Buscar Estatisticas de transações")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "busca efetuada com sucesso"),
            @ApiResponse(responseCode = "400", description = "erro na busca de transações"),
            @ApiResponse(responseCode = "500", description = "erro interno do servidor")
    })

    public ResponseEntity<EstatisticasResponseDTO> buscarEstatisticas(
            @RequestParam(value = "Intervalo de busca", required = false, defaultValue = "60") Integer intervaloBusca){
       return ResponseEntity.ok( estatisticasService.calcularEstatisticasTransações(intervaloBusca));
    }


}
