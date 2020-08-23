package br.ufpe.cin.hcs3.opencartapi.v1.service;

import br.ufpe.cin.hcs3.opencartapi.v1.domain.entity.User;
import br.ufpe.cin.hcs3.opencartapi.v1.domain.repository.UserRepository;
import br.ufpe.cin.hcs3.opencartapi.v1.entrypoints.exception.EntityAlreadExistsException;
import br.ufpe.cin.hcs3.opencartapi.v1.entrypoints.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserService {

    private final UserRepository repository;

    public User findById(Long id) {
        return this.repository.findById(id)
                              .orElseThrow(NotFoundException::new);
    }

    public List<User> list() {
        var users = this.repository.findAll();

        if(users.isEmpty()){
            throw new NotFoundException();
        }

        return users;
    }

    public void save(User user) {
        String mail = user.getMail();
        boolean existsUserByMail = this.repository.existsUserByMail(mail);

        if (existsUserByMail) {
            throw new EntityAlreadExistsException();
        }

        this.repository.save(user);
    }

    public void delete(User user){
        this.repository.delete(this.findById(user.getId()));
    }

}
