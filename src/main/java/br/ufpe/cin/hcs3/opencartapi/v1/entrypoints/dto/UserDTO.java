package br.ufpe.cin.hcs3.opencartapi.v1.entrypoints.dto;

import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Builder @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class UserDTO {

    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String password;

    @NotBlank
    @Email
    private String mail;

    @NotBlank
    @CPF
    private String cpf;

    @NotBlank
    private String phone;

    @NotNull
    private AddressDTO address;

}
