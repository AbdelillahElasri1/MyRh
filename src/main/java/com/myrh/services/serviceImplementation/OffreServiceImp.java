package com.myrh.services.serviceImplementation;


import com.myrh.dto.request.OffreDto;
import com.myrh.entities.Offre;
import com.myrh.enums.Status;
import com.myrh.repositories.OffreRepository;
import com.myrh.services.service.OffreService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OffreServiceImp implements OffreService {

    private OffreRepository offreRepository;
    private final ModelMapper modelMapper;
    @Autowired
    public OffreServiceImp(OffreRepository offreRepository, ModelMapper modelMapper){
        this.offreRepository = offreRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<Offre> fetch() {
        return null;
    }

    @Override
    public OffreDto create(OffreDto offredto) {

        offredto.status = Status.encours;
        Offre offre = modelMapper.map(offredto,Offre.class);
        Offre savedOffre = offreRepository.save(offre);
        return modelMapper.map(savedOffre, OffreDto.class);

    }

    @Override
    public OffreDto update(OffreDto offredto) {

        Offre offre = modelMapper.map(offredto,Offre.class);
        return modelMapper.map(offreRepository.save(offre),OffreDto.class);

    }

    @Override
    public boolean delete(int id) {
        if(offreRepository.existsById(id)){
        offreRepository.deleteById(id);
        return true;
        }else{
            return false;
        }

    }

    @Override
    public OffreDto MuteOffre(OffreDto offreDto) {
        Optional<Offre> offre = offreRepository.findById(offreDto.id);


        if(offre.isPresent()){
            offre.get().setStatus(Status.mute);
            offreRepository.save(offre.get());
            return modelMapper.map(offreRepository.save(offre.get()),OffreDto.class);
        }else {
            throw new RuntimeException("error happening ");
        }

    }
}
