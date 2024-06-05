package se.inyat.workshop.data.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString

@Entity

public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Setter
    @Column(nullable = false, unique = true)
    private String firstName;

    @Setter
    @Column(nullable = false, unique = true)
    private String lastName;

    @Setter
    @ManyToMany
    @JoinTable(name = "book_authors",
    joinColumns = @JoinColumn(name = "author_id"),
    inverseJoinColumns = @JoinColumn(name = "book_id"))
    private Set<Book> writtenBooks;

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public Author createAuthor(String firstName, String lastName) {
        return new Author(firstName,lastName);
    }
}
