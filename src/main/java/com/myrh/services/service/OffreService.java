package com.myrh.services.service;

import com.myrh.entities.Offre;

import java.util.List;

public interface OffreService {

    List<Offre> fetch();
    Offre create(Offre offre);
    Offre update(Offre offre);
    Offre delete(Offre offre);

}
