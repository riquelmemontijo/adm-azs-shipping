package com.azs.admazsshipping.adapter.outbound.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FreteRepository extends JpaRepository<FreteEntity, Long> {
    @Query(value = "SELECT * FROM frete WHERE indice @@ plainto_tsquery('portuguese', :parametro);", nativeQuery = true)
    Page<FreteEntity> buscarFretes(Pageable pageable, String parametro);
}
