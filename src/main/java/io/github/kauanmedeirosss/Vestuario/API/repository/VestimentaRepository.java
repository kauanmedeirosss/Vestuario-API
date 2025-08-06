package io.github.kauanmedeirosss.Vestuario.API.repository;

import io.github.kauanmedeirosss.Vestuario.API.model.Vestimenta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VestimentaRepository extends JpaRepository<Vestimenta, Long> {
}
