package br.com.cursosudemy.bookservice.domain.repository;

import br.com.cursosudemy.bookservice.domain.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
}
