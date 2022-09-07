package br.com.cursosudemy.bookservice.resource;

import br.com.cursosudemy.bookservice.domain.service.BookService;
import br.com.cursosudemy.bookservice.dto.BookDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Book Service API")
@RestController
@RequestMapping("book")
public class BookResource {

    @Autowired
    private BookService bookService;

    @Operation(summary = "Especifica o book por id")
    @GetMapping("{id}/{currency}")
    public ResponseEntity<BookDTO> findBook(@PathVariable("id") Long id, @PathVariable("currency") String currency){
        return ResponseEntity.ok(bookService.findById(id,currency));
    }
}
