package com.myrh.services.serviceImplementation;


import com.myrh.dto.request.SocieteDto;
import com.myrh.entities.Postule;
import com.myrh.entities.Societe;
import com.myrh.entities.TokenVerification;
import com.myrh.repositories.SocieteRepository;
import com.myrh.repositories.TokenRepository;
import com.myrh.services.service.SocieteService;
import org.apache.commons.io.FilenameUtils;
import org.modelmapper.ModelMapper;
import org.modelmapper.internal.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class SocieteServiceImp implements SocieteService {

    @Autowired
    private JavaMailSender javaMailSender;

    private final TokenRepository tokenRepository;

    @Value("${app.imagePath}")
    private String directoryPath;




    private final ModelMapper modelMapper;
    private final SocieteRepository societeRepository;
    private SocieteDto societeDtoHolder;

    public SocieteServiceImp(TokenRepository tokenRepository, ModelMapper modelMapper, SocieteRepository societeRepository) {
        this.tokenRepository = tokenRepository;
        this.modelMapper = modelMapper;
        this.societeRepository = societeRepository;
    }

    @Override
    public boolean SendGeneratedToken(SocieteDto societeDto) {

        //todo : got to check if email isnt valide

        this.societeDtoHolder = societeDto;
        System.out.println("the company dto " +  this.societeDtoHolder);
        String randomCode = RandomString.make(30);
        LocalDateTime generatedAt = LocalDateTime.now();

        TokenVerification tokenVerification = new TokenVerification();
        tokenVerification.token = randomCode;
        tokenVerification.time = generatedAt;
        tokenVerification.email = societeDto.email;
        tokenRepository.save(tokenVerification);

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(societeDto.email);
        message.setSubject("Verification");
        message.setText(generatedAt.toString() +  "\n please use this verification code " +  randomCode + "\n to create your account "  );
        javaMailSender.send(message);
        return true;
    }
    @Override
    public boolean verifieToken(String token,String email) {
        if (this.societeDtoHolder == null && this.societeDtoHolder.file == null) {
            throw new RuntimeException("File in SocieteDto is null");
        }
        Optional<TokenVerification> tokenOptinal =  tokenRepository.findFirstByEmailOrderByTimeDesc(email);
        System.out.println(tokenOptinal.get().token);
        if(tokenOptinal.isPresent()){
            TokenVerification token1 =  tokenOptinal.get();

            LocalDateTime tempsValid = token1.time.plusMinutes(1);
            System.out.println("time where the token has generated " + tempsValid );
            if(LocalDateTime.now().isBefore(tempsValid)){
                if(token1.token.equals(token)){
                    System.out.println("verified successfully");
                    Create(this.societeDtoHolder);
                    return true;
                }else {
                    System.out.println("not verified due to token invalid");
                    return false;
                }
            } else{
                System.out.println("time expired ");
                return false;
            }

        }
        return false;


    }
    @Override
    public SocieteDto Create(SocieteDto societeDto) {


        societeDto.image = saveImage(societeDto.file);
        System.out.println("the image name on the last layer before creating " + societeDto.image);
        Societe societe = modelMapper.map(societeDto,Societe.class);
        Societe societe1 =  societeRepository.save(societe);
        SocieteDto societeDto1 = modelMapper.map(societe1,SocieteDto.class);
        return societeDto1;

    }

    @Override
    public boolean login(String email, String password) {
        return false;
    }



    @Override
    public List<Postule> consulte(Postule postule) {
        return null;
    }

    @Override
    public String saveImage(MultipartFile file) {


        try {
            String fileName = file.getOriginalFilename();
            System.out.println("the file name is :" + fileName);
            String ImagePath = directoryPath + fileName;
            System.out.println("the image Path" + ImagePath );
            file.transferTo(new File(ImagePath));

            return ImagePath;

        }catch (Exception e){
            e.printStackTrace();
        }


        return null;
    }
}
