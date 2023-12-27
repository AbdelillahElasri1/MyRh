package com.myrh.repositories;

import com.myrh.entities.Offre;
import com.myrh.entities.Societe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OffreRepository extends JpaRepository<Offre,Integer> {

    List<Offre> findAllBySociete(Societe societe);


}
