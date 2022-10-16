package com.example.babetown.Repositories;

import com.example.babetown.Models.Arrivage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArrivageRepository extends CrudRepository<Arrivage, Integer> {

}

