package com.myrh.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RegisterRequestDTO {
    private String email;
    private String password;
    private String adresse;
    private String image;
}
