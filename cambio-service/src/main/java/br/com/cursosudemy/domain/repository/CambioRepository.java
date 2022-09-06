package br.com.cursosudemy.domain.repository;

import br.com.cursosudemy.domain.model.Cambio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CambioRepository  extends JpaRepository<Cambio,Long> {

    Optional<Cambio> findByFromAndTo(String from, String to);
}
