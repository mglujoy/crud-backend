package com.mglujoy.crud.Controller;

import com.mglujoy.crud.exceptions.ResourceNotFoundException;
import com.mglujoy.crud.models.Education;
import com.mglujoy.crud.models.Skills;
import com.mglujoy.crud.models.Work;
import com.mglujoy.crud.repository.Repository;
import com.mglujoy.crud.repository.SkillsRepository;
import com.mglujoy.crud.repository.WorkRepository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class Controller {
    
    @Autowired
    private Repository repository;
    @Autowired
    private WorkRepository workRepository;
    @Autowired
    private SkillsRepository skillsRepository;    
    
    @GetMapping("/education")
    public List<Education> listEducation() {
        return repository.findAll();
    }
    
    @GetMapping("/work")
    public List<Work> listWork() {
        return workRepository.findAll();
    }

    @GetMapping("/skills")
    public List<Skills> listSkills() {
        return skillsRepository.findAll();
    }
    
    @PostMapping("/education")
    public Education saveEducation(@RequestBody Education education) {
        return repository.save(education);
    }
    
    @PostMapping("/work")
    public Work saveWork(@RequestBody Work work) {
        return workRepository.save(work);
    }
    
    @PostMapping("/skills")
    public Skills saveSkills(@RequestBody Skills skill) {
        return skillsRepository.save(skill);
    }
    
    @GetMapping("/education/{id}")
    public ResponseEntity<Education> getEducationbyId(
    @PathVariable Long id) {
        Education education = repository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("No such education exists"));
        return ResponseEntity.ok(education);
    }

        @PutMapping("/education/{id}")
    public ResponseEntity<Education> putEducationbyId(
    @PathVariable Long id, @RequestBody Education dataEducation) {
        Education education = repository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("No such education exists"));
        
        education.setDuration(dataEducation.getDuration());
        education.setInstitution(dataEducation.getInstitution());
        education.setName(dataEducation.getName());
        
        Education updatedEducation = repository.save(education);
        return ResponseEntity.ok(updatedEducation);
    }
    
    @DeleteMapping("/education/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEducationbyId(
    @PathVariable Long id) {
        Education education = repository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("No such education exists"));
        
        repository.delete(education);
        Map<String, Boolean> response = new HashMap<>();
        response.put("delete", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
    
        @DeleteMapping("/work/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteWorkbyId(
    @PathVariable Long id) {
        Work work = workRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("No such work exists"));
        
        workRepository.delete(work);
        Map<String, Boolean> response = new HashMap<>();
        response.put("delete", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
