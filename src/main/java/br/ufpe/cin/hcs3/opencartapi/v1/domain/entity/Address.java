package br.ufpe.cin.hcs3.opencartapi.v1.domain.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Builder @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Address {

    @Column(nullable = false)
    private String publicArea;

    @Column(nullable = false)
    private String postCode;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String state;

    @Column(nullable = false)
    private String country;

}
