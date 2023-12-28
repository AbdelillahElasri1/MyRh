package com.myrh.services.serviceImplementation;


import com.myrh.dto.request.OffreDto;
import com.myrh.entities.Offre;
import com.myrh.repositories.OffreRepository;
import com.myrh.services.service.Agent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AgentServiceImp implements Agent {

    private final OffreRepository offreRepository;

    @Autowired
    public AgentServiceImp(OffreRepository offreRepository) {
        this.offreRepository = offreRepository;
    }

    @Override
    public boolean login(Agent agent) {
        return false;
    }

    @Override
    public boolean valideOrRefuse(int offreId, OffreDto offredto) {
        Optional<Offre> existingOffreOptional = offreRepository.findById(offreId);
        if (existingOffreOptional.isPresent()){
            Offre existingOffre = existingOffreOptional.get();

            existingOffre.setStatus(offredto.getStatus());

            offreRepository.save(existingOffre);
            return true;
        } else {
            return false;
        }

    }
}
