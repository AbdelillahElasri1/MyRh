package com.myrh.controllers;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myrh.dto.request.SocieteDto;
import com.myrh.services.service.SocieteService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/societe")
public class SocieteController {

    private final SocieteService societeService;

    public SocieteController(SocieteService societeService) {
        this.societeService = societeService;
    }


    @PostMapping(value = "",consumes = { MediaType.APPLICATION_JSON_VALUE,
                                         MediaType.MULTIPART_FORM_DATA_VALUE })
    public ResponseEntity create(@RequestPart("societeDto") String societeDto,@RequestPart MultipartFile file) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        SocieteDto societedto = objectMapper.readValue(societeDto ,SocieteDto.class);
        societedto.file = file;
        return ResponseEntity.ok(societeService.Create(societedto));

    }

}
