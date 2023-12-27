package com.myrh.controllers;
import com.myrh.dto.request.OffreDto;
import com.myrh.entities.Offre;
import com.myrh.services.service.OffreService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/offre")
public class OffreController {

    private OffreService offreService;
    @Autowired
    public OffreController(OffreService offreService){
        this.offreService = offreService;
    }
    @PostMapping("")
    public ResponseEntity<OffreDto> create(@RequestBody OffreDto offreDto){

        return ResponseEntity.ok(offreService.create(offreDto));

    }
    @PutMapping("")
    public ResponseEntity<OffreDto> update(@RequestBody OffreDto offreDto){
        return ResponseEntity.ok(offreService.update(offreDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable int id){
        if(offreService.delete(id)){
            return ResponseEntity.ok("offre deleted");
        }else{
            return ResponseEntity.ok("offre doesnt exist");
        }
    }

}
