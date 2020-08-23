package br.ufpe.cin.hcs3.opencartapi.v1.entrypoints.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Builder @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class AddressDTO {

    @NotBlank
    private String publicArea;

    @NotBlank
    private String postCode;

    @NotBlank
    private String city;

    @NotBlank
    private String state;

    @NotBlank
    private String country;

}
