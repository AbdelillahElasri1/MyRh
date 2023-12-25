package com.myrh.services.serviceImplementation;


import com.myrh.entities.Postule;
import com.myrh.entities.Societe;
import com.myrh.services.service.SocieteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Service
public class SocieteServiceImp implements SocieteService {

    @Value("${app.imagePath}")
    private String directoryPath;


    @Override
    public boolean login(String email, String password) {
        return false;
    }

    @Override
    public Societe Create(Societe societe) {
        return null;
    }

    @Override
    public List<Postule> consulte(Postule postule) {
        return null;
    }

    @Override
    public String saveImage(MultipartFile file) {
        return null;
    }
}
