package br.com.cursosudemy.resource;

import br.com.cursosudemy.domain.service.CambioService;
import br.com.cursosudemy.dto.CambioDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@Tag(name = "Cambio Service API")
@RestController
@RequestMapping("cambio-service")
public class CambioResource {

    @Autowired
    private CambioService cambioService;

    @Operation(summary = "Obter Cambio por moeda")
    @GetMapping("{amount}/{from}/{to}")
    public ResponseEntity<CambioDTO> getCambio(@PathVariable("amount")BigDecimal amount,
                                               @PathVariable("from") String from,
                                               @PathVariable("to") String to){
        return ResponseEntity.ok(cambioService.findByFromAndTo(from,to,amount));
    }
}
