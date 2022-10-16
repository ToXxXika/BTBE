package com.example.babetown.Repositories;


import com.example.babetown.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

    @Query("select p from Product p where p.matricule = ?1")
    Product findProductByMatricule(
            String matricule);


}