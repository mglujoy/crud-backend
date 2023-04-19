package com.mglujoy.crud.Controller;

import com.mglujoy.crud.exceptions.ResourceNotFoundException;
import com.mglujoy.crud.models.About;
import com.mglujoy.crud.models.Education;
import com.mglujoy.crud.models.Home;
import com.mglujoy.crud.models.Skills;
import com.mglujoy.crud.models.Work;
import com.mglujoy.crud.repository.AboutRepository;
import com.mglujoy.crud.repository.HomeRepository;
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
    @Autowired
    private HomeRepository homeRepository;
    @Autowired
    private AboutRepository aboutRepository;
    
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

    @GetMapping("/home")
    public List<Home> listHome() {
        return homeRepository.findAll();
    }
    
    @GetMapping("/about")
    public List<About> listAbout() {
        return aboutRepository.findAll();
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
    
    @PostMapping("/home")
    public Home saveHome(@RequestBody Home home) {
        return homeRepository.save(home);
    }
    
    @PostMapping("/about")
    public About saveAbout(@RequestBody About about) {
        return aboutRepository.save(about);
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
    
        @DeleteMapping("/skills/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteSkillById(
    @PathVariable Long id) {
        Skills skills = skillsRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("No such skill exists"));
        
        skillsRepository.delete(skills);
        Map<String, Boolean> response = new HashMap<>();
        response.put("delete", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }    
    
    @PutMapping("/work/{id}")
    public ResponseEntity<Work> putWorkId(
    @PathVariable Long id, @RequestBody Work dataWork) {
        Work work = workRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("No such work exists"));
        
        work.setDuration(dataWork.getDuration());
        work.setInstitution(dataWork.getInstitution());
        work.setName(dataWork.getName());
        
        Work updatedWork = workRepository.save(work);
        return ResponseEntity.ok(updatedWork);
    }
    @GetMapping("/work/{id}")
    public ResponseEntity<Work> getWorkbyId(
    @PathVariable Long id) {
        Work work = workRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("No such work exists"));
        return ResponseEntity.ok(work);
    }
    
    @PutMapping("/skills/{id}")
    public ResponseEntity<Skills> putSkillsById(
    @PathVariable Long id, @RequestBody Skills dataSkills) {
        Skills skills = skillsRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("No such skill exists"));
        
        skills.setProgress(dataSkills.getProgress());
        skills.setName(dataSkills.getName());
        
        Skills updatedSkills = skillsRepository.save(skills);
        return ResponseEntity.ok(updatedSkills);
    }
    @GetMapping("/skills/{id}")
    public ResponseEntity<Skills> getSkillsById(
    @PathVariable Long id) {
        Skills skills = skillsRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("No such skill exists"));
        return ResponseEntity.ok(skills);
    }
    
    @PutMapping("/home/{id}")
    public ResponseEntity<Home> putHomeById(
    @PathVariable Long id, @RequestBody Home dataHome) {
        Home home = homeRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("No such info exists"));
        
        home.setName(dataHome.getName());
        home.setBirth(dataHome.getBirth());
        home.setDescription(dataHome.getDescription());
        home.setEmail(dataHome.getEmail());
        home.setGithub(dataHome.getGithub());
        home.setInstagram(dataHome.getInstagram());
        home.setLinkedin(dataHome.getLinkedin());
        home.setLocation(dataHome.getLocation());
        home.setPhone(dataHome.getPhone());
        home.setTwitter(dataHome.getTwitter());        
        
        Home updatedHome = homeRepository.save(home);
        return ResponseEntity.ok(updatedHome);
    }
    @GetMapping("/home/{id}")
    public ResponseEntity<Home> getHomeById(
    @PathVariable Long id) {
        Home home = homeRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("No such info exists"));
        return ResponseEntity.ok(home);
    }
    
    @PutMapping("/about/{id}")
    public ResponseEntity<About> putAboutById(
    @PathVariable Long id, @RequestBody About dataAbout) {
        About about = aboutRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("No such info exists"));
        
        about.setAbout(dataAbout.getAbout());
        about.setItem1(dataAbout.getItem1());
        about.setItem2(dataAbout.getItem2());
        about.setItem3(dataAbout.getItem3());
        about.setItem4(dataAbout.getItem4());      
        
        About updatedAbout = aboutRepository.save(about);
        return ResponseEntity.ok(updatedAbout);
    }
    @GetMapping("/about/{id}")
    public ResponseEntity<About> getAbputById(
    @PathVariable Long id) {
        About about = aboutRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("No such info exists"));
        return ResponseEntity.ok(about);
    }
}
