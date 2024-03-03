package org.ramg.store.repository;

import org.ramg.store.entity.Product;
import org.ramg.store.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
