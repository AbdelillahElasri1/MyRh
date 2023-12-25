package com.myrh.services.service;


import com.myrh.entities.Postule;
import com.myrh.entities.Societe;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface SocieteService {

    boolean login(String email,String password);
    Societe Create(Societe societe);
    List<Postule> consulte(Postule postule);

    String saveImage(MultipartFile file);


}
