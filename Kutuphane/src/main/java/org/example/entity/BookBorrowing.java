package org.example.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "bookborrowing")
public class BookBorrowing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bookborrowing_id", columnDefinition = "serial")
    private Long id;
    @Column(name = "bookborrowing_borrower_name")
    private String borrower_name;

    @Column(name = "bookborrowing_return_date")
    private LocalDate return_date;

    @Column(name = "bookborrowing_borrowing_date")
    private LocalDate borrowing_date;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "bookborrowing_book_id",referencedColumnName ="book_id")
    private Book book;

    public BookBorrowing() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBorrower_name() {
        return borrower_name;
    }

    public void setBorrower_name(String borrower_name) {
        this.borrower_name = borrower_name;
    }

    public LocalDate getReturn_date() {
        return return_date;
    }

    public void setReturn_date(LocalDate return_date) {
        this.return_date = return_date;
    }

    public LocalDate getBorrowing_date() {
        return borrowing_date;
    }

    public void setBorrowing_date(LocalDate borrowing_date) {
        this.borrowing_date = borrowing_date;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "BookBorrowing{" +
                "id=" + id +
                ", borrower_name='" + borrower_name + '\'' +
                ", return_date=" + return_date +
                ", borrowing_date=" + borrowing_date +
                ", book=" + book +
                '}';
    }
}
