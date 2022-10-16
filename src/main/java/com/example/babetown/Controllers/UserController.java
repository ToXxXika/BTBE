package com.example.babetown.Controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;


@RestController
//identify Cross Origin
@CrossOrigin("4200")
//this BBTXTTDFG tag is just used to change typical Api Naming
@RequestMapping("BBTXTTDFG")
//this userController is created to identify Admin Behaviour on the Website
//TODO: need to implement Spring Security and use JWT token so our admin is secured
//TODO: need to Help admin in Front to Check which items are sold the most so he can decide what ******
public class UserController {

    //this tag is used for login
    @PostMapping("/BBTXTTFGL")
  public Principal login(Principal p){
      return p;
  }

}
