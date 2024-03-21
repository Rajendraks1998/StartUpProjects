package org.ramg.store.repository;

import org.ramg.store.entity.Product;
import org.ramg.store.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByUserId(Long userId);
    List<Product> findByUserName(String name);
}
