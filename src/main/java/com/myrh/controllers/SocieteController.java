package com.myrh.controllers;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myrh.dto.request.LoginRequestDTO;
import com.myrh.dto.request.RegisterRequestDTO;
import com.myrh.dto.request.SocieteDto;
import com.myrh.services.service.SocieteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/societe")
@RequiredArgsConstructor
public class SocieteController {

    private final SocieteService societeService;

    @PostMapping("/register")
    public ResponseEntity<SocieteDto> register(@RequestBody RegisterRequestDTO registerRequestDTO) {
        SocieteDto registerSociete = societeService.register(registerRequestDTO);
        if (registerSociete != null) {
            return new ResponseEntity<>(registerSociete, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping("/login")
    public ResponseEntity<SocieteDto> login(@RequestBody LoginRequestDTO loginRequestDTO){
        SocieteDto loginSociete = societeService.login(loginRequestDTO);
        if (loginSociete != null){
            return new ResponseEntity<>(loginSociete, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
