package com.green.orderservice.order.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CatalogRepository extends JpaRepository<CatalogEntity, Long> {

    Optional<CatalogEntity> findByEmail(String reqEmail);

    Optional<CatalogEntity> findByEmailAndPassword(String email, String password);
}
