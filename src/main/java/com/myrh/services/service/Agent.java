package com.myrh.services.service;

import com.myrh.dto.request.OffreDto;
import com.myrh.entities.Offre;

public interface Agent {
    boolean login(Agent agent);
    boolean valideOrRefuse(int offreId ,OffreDto offreDto);

}
