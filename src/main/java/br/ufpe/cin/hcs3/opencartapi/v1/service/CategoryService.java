package br.ufpe.cin.hcs3.opencartapi.v1.service;

import br.ufpe.cin.hcs3.opencartapi.v1.domain.entity.Category;
import br.ufpe.cin.hcs3.opencartapi.v1.domain.repository.CategoryRepository;
import br.ufpe.cin.hcs3.opencartapi.v1.entrypoints.exception.EntityAlreadExistsException;
import br.ufpe.cin.hcs3.opencartapi.v1.entrypoints.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CategoryService {

    private final CategoryRepository repository;

    public Category findById(Long id) {
        return this.repository.findById(id)
                              .orElseThrow(NotFoundException::new);
    }

    public List<Category> list() {
        var categories = this.repository.findAll();

        if(categories.isEmpty()){
            throw new NotFoundException();
        }

        return categories;
    }

    public void save(Category category) {
        String description = category.getDescription();
        boolean existsCategoryByDescription = this.repository.existsCategoryByDescription(description);

        if (existsCategoryByDescription) {
            throw new EntityAlreadExistsException();
        }

        this.repository.save(category);
    }

    public void delete(Category category){
        this.repository.delete(this.findById(category.getId()));
    }

}
