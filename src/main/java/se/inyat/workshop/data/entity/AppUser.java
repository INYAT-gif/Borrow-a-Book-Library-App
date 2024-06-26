package se.inyat.workshop.data.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString

@Entity
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Setter
    @Column(nullable = false, unique = true)
    private String username;

    @Setter
    @Column(nullable = false)
    private String password;

    @Setter
    @Column
    private LocalDate regDate;

    @Setter
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "details_id")
    private Details userDetails;

    @OneToMany(mappedBy = "borrower")
    private List<BookLoan> bookLoans;

    public AppUser(String username, String password) {
        this.username = username;
        this.password = password;
        this.regDate = LocalDate.now();
    }

    protected void addBookLoan(BookLoan loan) {
        bookLoans.add(loan);
        loan.setBorrower(this);
    }

    //more constructors and methods as needed

}
