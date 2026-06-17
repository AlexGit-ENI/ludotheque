package fr.eni.ludotheque.bo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor

public class Client {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

@NonNull
    private String nom;
@NonNull
    private String prenom;
}
