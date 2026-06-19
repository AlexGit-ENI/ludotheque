package fr.eni.ludotheque.bo;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;


@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name="LOCATIONS")

public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="no_location")
    @EqualsAndHashCode.Exclude

    @NonNull
    private Integer noLocation;

    @Column( length=50, nullable=false)
    @NonNull
    private Date date_debut;

    @Column(length=13, nullable=false, unique=true)
    @NonNull private Date date_retour;


    @Column(nullable=false)
    @NonNull
    private Float tarifJour;

    public Location(int noLocation, int i, int i1, float tarifJour) {
    }

//    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
//    @JoinTable(name = "LOCATIONS",
//            joinColumns = @JoinColumn(name="no_jeu"),
//            inverseJoinColumns = @JoinColumn(name = "noExemplaire"),
//            inverseJoinColumns = @JoinColumn(name="no_genre"))
//    private List<Genre> genres = new ArrayList<>();
}