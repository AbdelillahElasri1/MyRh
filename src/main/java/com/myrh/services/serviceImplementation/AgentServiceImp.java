package com.example.hiringmanagment.Service;

import com.example.hiringmanagment.Entitiy.Offre;
import com.example.hiringmanagment.Service.ServiceIterface.Agent;

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
