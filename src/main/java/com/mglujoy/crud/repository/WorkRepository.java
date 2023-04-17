package com.mglujoy.crud.repository;

import com.mglujoy.crud.models.Work;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkRepository extends JpaRepository <Work, Long>{
    
}
