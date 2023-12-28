package com.myrh.dto.request;


import com.myrh.enums.NiveauEtude;
import com.myrh.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OffreDto {

    public int id;
    public String titre;
    public String description;
    public String profile;
    public float salaire;
    public NiveauEtude niveau_etude;
    public Status status;
    public int offreId;
}
