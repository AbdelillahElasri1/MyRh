package com.myrh.entities;

import com.myrh.enums.NiveauEtude;
import com.myrh.enums.Status;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Offre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String titre;
    private String description;
    private String profile;
    private float salaire;
    private NiveauEtude niveau_etude;
    private Status status;

    @OneToMany(mappedBy="offre")
    private List<Postule> postule;

    @ManyToOne
    @JoinColumn(name = "offreId" ,referencedColumnName = "id")
    private Societe societe;

}
