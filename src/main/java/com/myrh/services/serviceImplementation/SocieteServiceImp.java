package com.example.hiringmanagment.Service;

import com.example.hiringmanagment.Dao.OffreRepository;
import com.example.hiringmanagment.Dao.PostuleRepository;
import com.example.hiringmanagment.Dao.SocieteRepository;
import com.example.hiringmanagment.Dto.SocieteDto;
import com.example.hiringmanagment.Entitiy.Offre;
import com.example.hiringmanagment.Entitiy.Postule;
import com.example.hiringmanagment.Entitiy.Societe;
import com.example.hiringmanagment.Mapper.SocieteMapper;
import com.example.hiringmanagment.Service.ServiceIterface.SocieteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Service
public class SocieteServiceImp implements SocieteService {

    @Value("${app.imagePath}")
    private String directoryPath;

    private  SocieteRepository societeRepository;
    private PostuleRepository postuleRepository;
    private OffreRepository offreRepository;
    @Autowired
    public SocieteServiceImp(SocieteRepository societeRepository,PostuleRepository postuleRepository,OffreRepository offreRepository){
        this.postuleRepository = postuleRepository;
        this.societeRepository = societeRepository;
        this.offreRepository = offreRepository;
    }

    @Override
    public boolean login(String email, String password) {
        return false;
    }

    @Override
    public Societe Create(Societe societe) {

        return societeRepository.save(societe);
    }

    @Override
    public List<Postule> consulte(Postule postule) {
        Societe societe = new Societe();
        List<Offre> offres = offreRepository.findAllBySociete(societe);
        return null;
    }

    //todo:here maybe i can use restController Advice instead

    @Override
    public String saveImage(MultipartFile file) {
        try {

            String fileName = file.getOriginalFilename();
            String ImagePath = directoryPath + fileName;
            file.transferTo(new File(ImagePath));
            return ImagePath;

        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }
}
