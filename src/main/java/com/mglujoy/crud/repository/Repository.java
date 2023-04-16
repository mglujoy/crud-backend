package com.mglujoy.crud.repository;

import com.mglujoy.crud.models.Education;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository <Education, Long> {
    
}
