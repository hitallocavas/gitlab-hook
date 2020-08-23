package br.ufpe.cin.hcs3.opencartapi.v1.domain.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String description;

}
