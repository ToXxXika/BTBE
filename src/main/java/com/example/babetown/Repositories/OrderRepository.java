package com.example.babetown.Repositories;

import com.example.babetown.Models.Commande;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Commande, Integer> {

}

