package br.com.cursosudemy.bookservice.client.service;

import br.com.cursosudemy.bookservice.client.dto.CambioDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "cambio-service",path = "cambio")
public interface CambioClient {

    @GetMapping("{amount}/{from}/{to}")
    public ResponseEntity<CambioDTO> getCambio(@PathVariable("amount") Double amount,
                                               @PathVariable("from") String from,
                                               @PathVariable("to") String to);
}
