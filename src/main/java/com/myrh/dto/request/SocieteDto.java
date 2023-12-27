package com.myrh.dto.request;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
@Data
public class SocieteDto {


    public int id;
    public String email;
    public String password;
    public String adresse;
    public String image;
    public MultipartFile file;

}
