package com.myrh.controllers;


import com.myrh.dto.request.SocieteDto;
import com.myrh.services.service.SocieteService;
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
    public ResponseEntity create(@RequestParam("file")MultipartFile file, SocieteDto societeDto){





        //Societe societe = SocieteMapper.SM.toEntity(societeDto);
        //societe.setImage(imageName);

        //Societe societe = SocieteMapper.SM.toEntity(societeDto);
        //societe.setImage(imageName);
        //return ResponseEntity.ok(societeService.Create(societe));

        return ResponseEntity.ok(societeDto);

    }

}
