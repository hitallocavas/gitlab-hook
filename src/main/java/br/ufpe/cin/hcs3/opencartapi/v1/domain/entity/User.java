package br.ufpe.cin.hcs3.opencartapi.v1.domain.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "OC_USER")
@Builder @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String mail;

    @Column(nullable = false, length = 14)
    private String cpf;

    @Column(nullable = false, length = 15)
    private String phone;

    @Embedded
    private Address address;

}
