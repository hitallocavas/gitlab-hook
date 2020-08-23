package br.ufpe.cin.hcs3.opencartapi.v1.entrypoints.rest;

import br.ufpe.cin.hcs3.opencartapi.v1.entrypoints.converters.impl.CategoryConverterImpl;
import br.ufpe.cin.hcs3.opencartapi.v1.entrypoints.dto.CategoryDTO;
import br.ufpe.cin.hcs3.opencartapi.v1.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "categories")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CategoryRest {

    private final CategoryService categoryService;
    private final CategoryConverterImpl categoryConverter;

    @PostMapping
    public ResponseEntity<Object> save(@Valid @RequestBody CategoryDTO categoryDTO){
        this.categoryService.save(categoryConverter.toEntity(categoryDTO));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> getAll(){
        var categories = this.categoryService.list();
        var categoriesDto =  categories.stream()
                                       .map(categoryConverter::toDTO)
                                       .collect(Collectors.toList());

        return ResponseEntity.ok(categoriesDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> getById(@PathVariable Long id){
        var category = this.categoryService.findById(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(this.categoryConverter.toDTO(category));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable Long id){
        var category = this.categoryService.findById(id);
        this.categoryService.delete(category);
        return ResponseEntity.ok().build();
    }

}
