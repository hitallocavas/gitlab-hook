package br.ufpe.cin.hcs3.opencartapi.v1.entrypoints.rest;

import br.ufpe.cin.hcs3.opencartapi.v1.entrypoints.converters.impl.UserConverterImpl;
import br.ufpe.cin.hcs3.opencartapi.v1.entrypoints.dto.UserDTO;
import br.ufpe.cin.hcs3.opencartapi.v1.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "users")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserRest {

    private final UserService userService;
    private final UserConverterImpl userConverter;

    @PostMapping
    public ResponseEntity save(@Valid @RequestBody UserDTO UserDTO){
        this.userService.save(userConverter.toEntity(UserDTO));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAll(){
        var users = this.userService.list();
        var usersDto =  users.stream()
                             .map(userConverter::toDTO)
                             .collect(Collectors.toList());

        return ResponseEntity.ok(usersDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getById(@PathVariable Long id){
        var user = this.userService.findById(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(this.userConverter.toDTO(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable Long id){
        var user = this.userService.findById(id);
        this.userService.delete(user);
        return ResponseEntity.ok().build();
    }

}
