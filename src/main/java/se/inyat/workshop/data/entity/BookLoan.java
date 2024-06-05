package se.inyat.workshop.data.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString


@Entity
public class BookLoan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private int id;

    @Setter
    @Column
    private LocalDate loanDate;

    @Setter
    @Column
    private LocalDate dueDate;

    @Setter
    @Column
    private boolean returned;

    @Setter
    @ManyToOne
    @JoinColumn(name = "appuser_id")
    private AppUser borrower;

    @Setter
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;


}
