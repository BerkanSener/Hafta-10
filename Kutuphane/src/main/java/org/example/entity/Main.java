package org.example.entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("kutuphane");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();


        Author author = new Author();
        author.setName("Ahmet Şerif İzgören");
        author.setBirthDate(LocalDate.of(1955,01,12));
        author.setCountry("Almanya");
        entityManager.persist(author);
        //transaction.commit();

        Publisher publisher = new Publisher();
        publisher.setName("Ateş Yayınevi");
        publisher.setAddress("İstanbul");
        publisher.setEstablishment_Year(2015);
        entityManager.persist(publisher);
        //transaction.commit();

        Category category = new Category();
        category.setDescription("Dram");
        category.setName("Dram romanlar, üzücü olaylar.");
        entityManager.persist(category);
       // transaction.commit();



        Book book = new Book();
        book.setName("Ferrarisini Satan Bilge");
        book.setStock(5);
        book.setPublicationYear(1952);
        book.setAuthor(author);
        book.setPublisher(publisher);
        entityManager.persist(book);



        BookBorrowing bookBorrowing = new BookBorrowing();
        bookBorrowing.setBorrower_name("Berkan Şener");
        bookBorrowing.setBook(book);
        bookBorrowing.setBorrowing_date(LocalDate.now());
        bookBorrowing.setReturn_date(LocalDate.of(2024,2,18));

        entityManager.persist(bookBorrowing);

        //transaction.commit();


        Author author1 = entityManager.find(Author.class,1);
        System.out.println(author1);
        transaction.commit();


    }
 }