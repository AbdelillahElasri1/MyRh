package com.example.hiringmanagment.Service.ServiceIterface;

import com.example.hiringmanagment.Entitiy.Postule;
import com.example.hiringmanagment.Entitiy.Societe;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface SocieteService {

    boolean login(String email,String password);
    Societe Create(Societe societe);
    List<Postule> consulte(Postule postule);

    String saveImage(MultipartFile file);


}