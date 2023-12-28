package com.myrh.services.serviceImplementation;


import com.myrh.dto.request.LoginRequestDTO;
import com.myrh.dto.request.RegisterRequestDTO;
import com.myrh.dto.request.SocieteDto;
import com.myrh.entities.Postule;
import com.myrh.entities.Societe;
import com.myrh.repositories.SocieteRepository;
import com.myrh.services.service.SocieteService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SocieteServiceImp implements SocieteService {

    @Value("${app.imagePath}")
    private String directoryPath;

    private final ModelMapper modelMapper;
    private final SocieteRepository societeRepository;
    private PasswordEncoder passwordEncoder;

//    @Override
//    public boolean login(String email, String password) {
//        return false;
//    }
//
//    @Override
//    public SocieteDto Create(SocieteDto societeDto) {
//
//        societeDto.image = saveImage(societeDto.file);
//        Societe societe = modelMapper.map(societeDto,Societe.class);
//        Societe societe1 =  societeRepository.save(societe);
//        SocieteDto societeDto1 = modelMapper.map(societe1,SocieteDto.class);
//        return societeDto1;
//
//    }


    @Override
    public SocieteDto register(RegisterRequestDTO registerRequest) {
        Societe societe = new Societe();
        societe.setEmail(registerRequest.getEmail());
        societe.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        societe.setAdresse(registerRequest.getAdresse());
        societe.setImage(registerRequest.getImage());
        Societe savedSociete = societeRepository.save(societe);
        return modelMapper.map(savedSociete, SocieteDto.class);
    }

    @Override
    public SocieteDto login(LoginRequestDTO loginRequest) {

        Societe societe = societeRepository.findByEmail(loginRequest.getEmail());
        if (societe != null && passwordEncoder.matches(loginRequest.getPassword(), societe.getPassword())){
            return modelMapper.map(societe, SocieteDto.class);
        }
        return null;
    }

    @Override
    public List<Postule> consulte(Postule postule) {
        return null;
    }

    @Override
    public String saveImage(MultipartFile file) {


        try {
            String Path = "C:\\Users\\adm\\Desktop\\MyRh\\src\\main\\resources\\assets\\";
            String fileName = file.getOriginalFilename();
            String ImagePath = directoryPath + fileName;
            file.transferTo(new File(ImagePath));

            return ImagePath;

        }catch (Exception e){
            e.printStackTrace();
        }


        return null;
    }
}
