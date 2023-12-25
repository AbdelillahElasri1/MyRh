package com.example.hiringmanagment.Dao;

import com.example.hiringmanagment.Entitiy.Offre;
import com.example.hiringmanagment.Entitiy.Societe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OffreRepository extends JpaRepository<Offre,Integer> {

    List<Offre> findAllBySociete(Societe societe);

}
