package br.ufpe.cin.hcs3.opencartapi.v1.domain.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "OC_PRODUCT")
@Builder @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "OC_CATEGORY_ID", nullable = false)
    private Category category;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private Integer stock;

}
