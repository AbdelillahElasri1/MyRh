package com.myrh.services.service;

import com.myrh.entities.Offre;

public interface Agent {
    boolean login(Agent agent);
    boolean valide(Offre offre);
    boolean refuse(Offre offre);


}
