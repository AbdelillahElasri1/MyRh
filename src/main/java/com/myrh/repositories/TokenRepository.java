package com.myrh.repositories;

import com.myrh.entities.TokenVerification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TokenRepository extends JpaRepository<TokenVerification,String> {

    Optional<TokenVerification> findFirstByEmailOrderByTimeDesc(String email);

}
