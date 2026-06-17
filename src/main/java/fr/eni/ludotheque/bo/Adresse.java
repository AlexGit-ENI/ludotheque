package fr.eni.ludotheque.bo;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name="AdresseOTM")

public class Adresse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int no_adresse;

    @NonNull
    private String rue;
    @NonNull
    private String code_postal;
    @NonNull
    private String ville;

    @Override
    public String toString() {
        return no_adresse + " " + rue + " " + code_postal + " " + ville+ " ";
    }

}
