package fr.eni.ludotheque.bo;

import fr.eni.ludotheque.dal.ClientRepository;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name="ClientOTM")

public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int noClient;


    @NonNull
    private String nom;
    @NonNull
    private String prenom;
    @NonNull
    private String email;
    @NonNull
    private String telephone;

//    public void addAdresse(Adresse a) {adresses.add(a);}

@Override
    public String toString() {
    return noClient + " " + nom + " " + prenom + " " + email + " " + telephone;

    }
}
