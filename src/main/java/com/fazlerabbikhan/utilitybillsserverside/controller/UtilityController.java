package com.fazlerabbikhan.utilitybillsserverside.controller;

import com.fazlerabbikhan.utilitybillsserverside.entity.UtilityEntity;
import com.fazlerabbikhan.utilitybillsserverside.model.response.UtilityResponse;
import com.fazlerabbikhan.utilitybillsserverside.repository.UtilityRepository;
import com.fazlerabbikhan.utilitybillsserverside.service.UtilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/utilities")
public class UtilityController {

    @Autowired
    private UtilityService utilityService;

    @Autowired
    private UtilityRepository utilityRepository;

    //Get all utilities
    @GetMapping("all")
    public List<UtilityEntity> getAllUtilities(){
        return utilityRepository.findAll();
    }

    //Create a utility
    @PostMapping("save")
    public UtilityEntity createUtility(@RequestBody UtilityEntity utilityEntity){
        return utilityService.createUtility(utilityEntity);
    }

    //Get a utility by ID
    @GetMapping("{id}")
    public UtilityResponse getUtilityById(@PathVariable long id){
        return utilityService.getUtilityById(id);
    }

    // Update a utility
    @PutMapping("{id}")
    public UtilityResponse updateUtility(@PathVariable long id, @RequestBody UtilityEntity utilityEntity) {
        return utilityService.updateUtility(id, utilityEntity);
    }

    // Delete a utility
    @DeleteMapping("{id}")
    public String deleteUtility(@PathVariable long id) {
        return utilityService.deleteUtility(id);
    }

}