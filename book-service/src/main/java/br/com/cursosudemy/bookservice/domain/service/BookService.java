package br.com.cursosudemy.bookservice.domain.service;

import br.com.cursosudemy.bookservice.client.service.CambioClient;
import br.com.cursosudemy.bookservice.domain.model.Book;
import br.com.cursosudemy.bookservice.domain.repository.BookRepository;
import br.com.cursosudemy.bookservice.dto.BookDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private Environment environment;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CambioClient cambioClient;

    public BookDTO findById(Long id,String currency){

       Book book = bookRepository.findById(id).orElseThrow(()-> new RuntimeException("id não encontrado"));
       BookDTO bookDTO =  modelMapper.map(book,BookDTO.class);


       var cambio= cambioClient.getCambio(book.getPrice(),"USD", currency);
       bookDTO.setEnvironment("Book Port: " + environment.getProperty("local.server.port") + " Cambio Port: " + cambio.getBody().getEnvirionment());

       bookDTO.setPrice(cambio.getBody().getConvertedValue().doubleValue());
       bookDTO.setCurrency(currency);

       return bookDTO;
    }
}
