package com.myrh.controllers;


import com.myrh.dto.request.OffreDto;
import com.myrh.services.service.Agent;
import com.myrh.services.service.OffreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/offres")
public class AgentController {

    private final Agent agent;

    @Autowired
    public AgentController(Agent agent) {
        this.agent = agent;
    }
    @PatchMapping("/{offreId}/valide")
    public ResponseEntity<Boolean> valideOrRefuse(@PathVariable("offreId") int offreId, @RequestBody OffreDto offreDto){
        boolean validationSuccessfully = agent.valideOrRefuse(offreId, offreDto);

        if (validationSuccessfully){
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
