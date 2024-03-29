package com.fazlerabbikhan.utilitybillsserverside.controller;

import com.fazlerabbikhan.utilitybillsserverside.entity.FieldEntity;
import com.fazlerabbikhan.utilitybillsserverside.model.response.FieldResponse;
import com.fazlerabbikhan.utilitybillsserverside.repository.FieldRepository;
import com.fazlerabbikhan.utilitybillsserverside.service.FieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fields")
public class FieldController {

    @Autowired
    private FieldService fieldService;

    @Autowired
    private FieldRepository fieldRepository;

    //Get all fields
    @GetMapping("all")
    public List<FieldEntity> getAllFields(){
        return fieldRepository.findAll();
    }

    //Create a field
    @PostMapping("save")
    public FieldEntity createField(@RequestBody FieldEntity fieldEntity){
        return fieldService.createField(fieldEntity);
    }

    //Get a field by ID
    @GetMapping("{id}")
    public FieldResponse getFieldById(@PathVariable long id){
        return fieldService.getFieldById(id);
    }

    // Update a field
    @PutMapping("{id}")
    public FieldResponse updateField(@PathVariable long id, @RequestBody FieldEntity fieldEntity) {
        return fieldService.updateField(id, fieldEntity);
    }

    // Delete a field
    @DeleteMapping("{id}")
    public String deleteField(@PathVariable long id) {
        return fieldService.deleteField(id);
    }

}
