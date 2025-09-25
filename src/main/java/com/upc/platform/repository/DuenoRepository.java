package com.upc.platform.repository;

import com.upc.platform.model.Dueno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DuenoRepository extends JpaRepository<Dueno, Integer> {

}
