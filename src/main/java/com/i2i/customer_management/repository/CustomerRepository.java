package com.i2i.customer_management.repository;

import com.i2i.customer_management.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    // Spring Data JPA bizim yerimize tüm veritabanı işlerini (CRUD) halledecek.
    // İçine ekstra hiçbir kod yazmamıza şimdilik gerek yok!
}