package se.inyat.workshop.data.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString


@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private int id;

    @Setter
    @Column(nullable = false, unique = true)
    private String isbn;

    @Setter
    @Column(nullable = false)
    private String title;

    @Setter
    @ManyToMany
    @JoinTable(name = "book_authors",
    joinColumns = @JoinColumn(name = "book_id"),
    inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> authors;

    @Setter
    @Column
    private int maxLoanDays;

    @Setter
    @OneToMany
    private List<BookLoan> loans;

    public Book(String isbn, String title, int maxLoanDays) {
        this.isbn = isbn;
        this.title = title;
        this.maxLoanDays = maxLoanDays;
    }
}
