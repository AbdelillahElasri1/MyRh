package com.example.hiringmanagment.Controller;

import com.example.hiringmanagment.Dto.SocieteDto;
import com.example.hiringmanagment.Entitiy.Offre;
import com.example.hiringmanagment.Entitiy.Societe;
import com.example.hiringmanagment.Mapper.SocieteMapper;
import com.example.hiringmanagment.Service.ServiceIterface.SocieteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/societe")
public class SocieteController {

    private SocieteService societeService;
    @Autowired
    public SocieteController(SocieteService societeService){
        this.societeService = societeService;
    }


    @PostMapping("")
    public ResponseEntity create(@RequestParam("file")MultipartFile file,SocieteDto societeDto){


        String imageName = societeService.saveImage(file);


        //Societe societe = SocieteMapper.SM.toEntity(societeDto);
        //societe.setImage(imageName);

        //Societe societe = SocieteMapper.SM.toEntity(societeDto);
        //societe.setImage(imageName);
        //return ResponseEntity.ok(societeService.Create(societe));

        return ResponseEntity.ok(societeDto);

    }

}
