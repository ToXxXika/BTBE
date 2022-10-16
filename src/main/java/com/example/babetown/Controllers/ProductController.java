package com.example.babetown.Controllers;

import com.example.babetown.Models.Arrivage;
import com.example.babetown.Models.Commande;
import com.example.babetown.Models.Product;
import com.example.babetown.Repositories.ArrivageRepository;
import com.example.babetown.Repositories.OrderRepository;
import com.example.babetown.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ArrivageRepository arrivageRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/products")
    public Iterable<Product> getProducts() {
        return productRepository.findAll();
    }

    public void saveProduct(Product product) {
        productRepository.save(product);
        Arrivage arrivage = new Arrivage();
        arrivage.setMatriculeprod(product.getMatricule());
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now();
        arrivage.setDatearrivage(dtf.format(now).toString());
        arrivageRepository.save(arrivage);
    }

    //TODO : need to use this function to set new Arrivals in the Home page of my FrontEnd Application
    //now we need to  implement methods Handle all these functions
    @PostMapping("/setarrivals")
    public boolean addProduct(@RequestBody Product product) {
        boolean isAdded = false;
        try {
            //test if the product is already in the database
            List<Product> products = productRepository.findAll();
            if (products.size() > 0) {
                for (Product p : products) {
                    if (p.getMatricule().equals(product.getMatricule())) {
                        //if the product is already in the database we need to update the quantity
                        p.setQuantite(p.getQuantite() + product.getQuantite());
                        productRepository.save(p);
                        Arrivage arrivage = new Arrivage();
                        arrivage.setMatriculeprod(product.getMatricule());
                        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                        LocalDateTime now = LocalDateTime.now();
                        arrivage.setDatearrivage(dtf.format(now));
                        arrivageRepository.save(arrivage);
                        isAdded = true;
                    } else {
                        //if the product is not in the database we need to add it
                        saveProduct(product);
                        isAdded = true;
                    }
                }
            } else {
                saveProduct(product);
                isAdded = true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return isAdded;
    }

    //TODO : an order can hold multiple products !!! need to fix this
    //this function is used to add an order to the database
    @PostMapping("/addorder")
    public boolean OrderProduct(@RequestBody Commande Commande) {
        //TODO:reduce quantity in the stock
        //TODO: send a phone Message to the client and the seller
        Product product = productRepository.findProductByMatricule(Commande.getMatriculeprod());
        try {
            //Save Commande
            orderRepository.save(Commande);
            //Reduce quantity in the stock
            product.setQuantite(product.getQuantite() - Commande.getQuantite());
            productRepository.save(product);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
