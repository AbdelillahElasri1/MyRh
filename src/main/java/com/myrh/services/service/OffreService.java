package com.myrh.services.service;

import com.myrh.dto.request.OffreDto;
import com.myrh.entities.Offre;

import java.util.List;

public interface OffreService {

    List<Offre> fetch();
    OffreDto create(OffreDto offre);
    OffreDto update(OffreDto offreDto);
    boolean delete(int  offreid);

    OffreDto MuteOffre(OffreDto offreDto);

}
