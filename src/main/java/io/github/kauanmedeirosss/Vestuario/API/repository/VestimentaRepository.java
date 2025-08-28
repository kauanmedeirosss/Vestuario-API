package io.github.kauanmedeirosss.Vestuario.API.repository;

import io.github.kauanmedeirosss.Vestuario.API.model.Vestimenta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VestimentaRepository extends JpaRepository<Vestimenta, Long> {

    List<Vestimenta> findAllByAtivaTrue();

}
