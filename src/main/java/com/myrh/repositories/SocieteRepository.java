package com.myrh.repositories;
import com.myrh.entities.Societe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SocieteRepository extends JpaRepository<Societe,Integer> {
    Societe findByEmail(String email);
}
