package com.myrh.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Societe {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private int id;

    private String email;
    private String password;
    private String adresse;
    private String image;

    @OneToMany(mappedBy = "societe")
    private List<Offre> offre;
}
