package com.i2i.customer_management.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "CUSTOMERS") // Oracle veritabanında oluşacak tablonun adı
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_seq_gen")
    @SequenceGenerator(name = "customer_seq_gen", sequenceName = "CUSTOMER_SEQ", allocationSize = 1)
    private Long id; // Her müşterinin benzersiz numarası (Primary Key)

    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName; // Müşterinin adı

    @Column(name = "LAST_NAME", nullable = false)
    private String lastName; // Müşterinin soyadı

    @Column(name = "EMAIL")
    private String email; // Müşterinin e-posta adresi

    // --- Boş Yapıcı Metot (Constructor) ---
    public Customer() {
    }

    // --- Parametreli Yapıcı Metot ---
    public Customer(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    // --- GETTER VE SETTER METOTLARI ---
    // (Java'nın bu değişkenleri okuyup yazabilmesi için gerekli standart kodlar)

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}