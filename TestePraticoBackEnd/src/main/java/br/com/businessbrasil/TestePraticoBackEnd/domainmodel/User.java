package br.com.businessbrasil.TestePraticoBackEnd.domainmodel;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private @Getter @Setter UUID id;

    @Column(name = "NAME", length = 50, nullable = false, unique = true)
    private @Getter @Setter String name;

    @Column(name = "EMAIL", length = 100, nullable = false)
    private @Getter @Setter String email;

    @Column(name = "DATA_CRIACAO", length = 50, nullable = false)
    private @Getter @Setter LocalDate creationDate;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "=== User ===" +
                "\nid: " + id +
                "\nname: " + name +
                "\nemail: " + email +
                "\ncreation date: " + creationDate;
    }
}
