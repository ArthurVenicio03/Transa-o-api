package com.Arthur.transacao_api.controller;


import com.Arthur.transacao_api.business.services.TransacaoService;
import com.Arthur.transacao_api.controller.dtos.TransasaoRequestDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/transacao")

public class TransacaoController {
    private final TransacaoService transacaoService;

    @PostMapping
    @Operation(description = "Endpoint responsavel por adicionar transações")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Transação gravada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Campos não atendem os requisitos da transação"),
            @ApiResponse(responseCode = "400", description = "erro de requisição"),
            @ApiResponse(responseCode = "500", description = "erro interno do servidor")
    })
    public ResponseEntity<Void> adicionarTransacao(@RequestBody TransasaoRequestDTO dto){
        transacaoService.adicionarTransacao(dto);

        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    @DeleteMapping
    @Operation(description = "Endpoint responsavel por deletar transações")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Transação deletadas com sucesso"),
            @ApiResponse(responseCode = "400", description = "erro de requisição"),
            @ApiResponse(responseCode = "500", description = "erro interno do servidor")
    })
    public ResponseEntity<Void> deletarTransacao(@RequestBody TransasaoRequestDTO dto){
      transacaoService.limparTransacoes();
      return ResponseEntity.ok().build();
    };
}
