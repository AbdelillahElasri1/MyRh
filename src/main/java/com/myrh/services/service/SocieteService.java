package com.myrh.services.service;


import com.myrh.dto.request.LoginRequestDTO;
import com.myrh.dto.request.RegisterRequestDTO;
import com.myrh.dto.request.SocieteDto;
import com.myrh.entities.Postule;
import com.myrh.entities.Societe;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface SocieteService {

    //boolean login(String email,String password);

    //SocieteDto Create(SocieteDto societeDto);
    SocieteDto register(RegisterRequestDTO registerRequest);
    SocieteDto login(LoginRequestDTO loginRequest);
    List<Postule> consulte(Postule postule);

    String saveImage(MultipartFile file) throws IOException;


}
