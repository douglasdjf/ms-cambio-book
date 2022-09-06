package br.com.cursosudemy.domain.service;

import br.com.cursosudemy.domain.model.Cambio;
import br.com.cursosudemy.domain.repository.CambioRepository;
import br.com.cursosudemy.dto.CambioDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class CambioService {

    @Autowired
    private CambioRepository cambioRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private Environment environment;

    public CambioDTO findByFromAndTo(String from, String to, BigDecimal amount){

        Cambio cambio = cambioRepository.findByFromAndTo(from,to).orElseThrow(()-> new RuntimeException("Cambio não existe"));
        CambioDTO cambioDTO =  modelMapper.map(cambio,CambioDTO.class);

        cambioDTO.setEnvirionment(environment.getProperty("local.server.port"));

        BigDecimal conversionFactior = cambio.getConversionFactor();
        BigDecimal convertedValue = conversionFactior.multiply(amount);
        cambioDTO.setConvertedValue(convertedValue.setScale(2, RoundingMode.CEILING));

        return cambioDTO;
    }


}
