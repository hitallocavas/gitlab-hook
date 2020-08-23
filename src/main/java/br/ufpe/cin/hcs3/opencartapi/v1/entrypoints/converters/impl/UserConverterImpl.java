package br.ufpe.cin.hcs3.opencartapi.v1.entrypoints.converters.impl;

import br.ufpe.cin.hcs3.opencartapi.v1.domain.entity.Address;
import br.ufpe.cin.hcs3.opencartapi.v1.domain.entity.User;
import br.ufpe.cin.hcs3.opencartapi.v1.entrypoints.converters.IConverter;
import br.ufpe.cin.hcs3.opencartapi.v1.entrypoints.dto.AddressDTO;
import br.ufpe.cin.hcs3.opencartapi.v1.entrypoints.dto.UserDTO;
import org.springframework.stereotype.Component;

@Component
public class UserConverterImpl implements IConverter<User, UserDTO> {


    @Override
    public UserDTO toDTO(User entity) {
        return UserDTO.builder()
                      .cpf(entity.getCpf())
                      .id(entity.getId())
                      .mail(entity.getMail())
                      .name(entity.getName())
                      .password(entity.getPassword())
                      .phone(entity.getPhone())
                      .address(AddressDTO.builder()
                                         .city(entity.getAddress().getCity())
                                         .country(entity.getAddress().getCountry())
                                         .postCode(entity.getAddress().getPostCode())
                                         .publicArea(entity.getAddress().getPublicArea())
                                         .state(entity.getAddress().getState())
                                         .build())
                      .build();
    }

    @Override
    public User toEntity(UserDTO dto) {
        return User.builder()
                .cpf(dto.getCpf())
                .id(dto.getId())
                .mail(dto.getMail())
                .name(dto.getName())
                .password(dto.getPassword())
                .phone(dto.getPhone())
                .address(Address.builder()
                                .city(dto.getAddress().getCity())
                                .country(dto.getAddress().getCountry())
                                .postCode(dto.getAddress().getPostCode())
                                .publicArea(dto.getAddress().getPublicArea())
                                .state(dto.getAddress().getState())
                                .build())
                .build();
    }
}
