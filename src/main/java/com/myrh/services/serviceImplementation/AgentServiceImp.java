package com.myrh.services.serviceImplementation;


import com.myrh.entities.Offre;
import com.myrh.services.service.Agent;

public class AgentServiceImp implements Agent {


    @Override
    public boolean login(Agent agent) {
        return false;
    }

    @Override
    public boolean valide(Offre offre) {
        return false;
    }

    @Override
    public boolean refuse(Offre offre) {
        return false;
    }
}
