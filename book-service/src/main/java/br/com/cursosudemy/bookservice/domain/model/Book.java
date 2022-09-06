package br.com.cursosudemy.bookservice.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "author", nullable = false, length = 180)
    private String author;

    @Column(name = "launch_date",nullable = false)
    @Temporal(TemporalType.DATE)
    private Date launchDate;

    @Column(name = "price",nullable = false)
    private Double price;

    @Column(name = "title",nullable = false, length = 250)
    private String title;
}
