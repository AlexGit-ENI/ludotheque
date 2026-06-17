package fr.eni.ludotheque.bo;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor

public class Client {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "no_client")

    private int noClient;


@NonNull
    private String nom;
@NonNull
    private String prenom;
@NonNull
    private String email;
@NonNull
    private String telephone;
}
