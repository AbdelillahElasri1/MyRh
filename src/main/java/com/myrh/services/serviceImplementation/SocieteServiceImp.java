package com.myrh.services.serviceImplementation;


import com.myrh.dto.request.SocieteDto;
import com.myrh.entities.Postule;
import com.myrh.entities.Societe;
import com.myrh.repositories.SocieteRepository;
import com.myrh.services.service.SocieteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@Service
public class SocieteServiceImp implements SocieteService {

    @Value("${app.imagePath}")
    private String directoryPath;

    private final ModelMapper modelMapper;
    private final SocieteRepository societeRepository;

    public SocieteServiceImp(ModelMapper modelMapper,  SocieteRepository societeRepository) {
        this.modelMapper = modelMapper;
        this.societeRepository = societeRepository;
    }

    @Override
    public boolean login(String email, String password) {
        return false;
    }

    @Override
    public SocieteDto Create(SocieteDto societeDto) {

        societeDto.image = saveImage(societeDto.file);
        Societe societe = modelMapper.map(societeDto,Societe.class);
        Societe societe1 =  societeRepository.save(societe);
        SocieteDto societeDto1 = modelMapper.map(societe1,SocieteDto.class);
        return societeDto1;

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
