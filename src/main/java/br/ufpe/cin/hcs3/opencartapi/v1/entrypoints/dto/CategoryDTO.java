package br.ufpe.cin.hcs3.opencartapi.v1.entrypoints.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Builder @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class CategoryDTO {

    private Long id;

    @NotBlank
    private String description;

}
