package org.example.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "publisher")
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "publisher_id", columnDefinition = "serial")
    private Long id;
    @Column(name = "publisher_name")
    private String name;

    @Column(name = "establishmentYear")
    private int establishment_Year;

    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "publisher")
    private List<Book>bookList;


    public Publisher() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEstablishment_Year() {
        return establishment_Year;
    }

    public void setEstablishment_Year(int establishment_Year) {
        this.establishment_Year = establishment_Year;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", establishment_Year=" + establishment_Year +
                ", address='" + address + '\'' +
               // ", bookList=" + bookList +
                '}';
    }
}
