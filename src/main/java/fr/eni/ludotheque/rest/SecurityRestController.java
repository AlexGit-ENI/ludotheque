package fr.eni.ludotheque.rest;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityRestController {

    @GetMapping("/hello")
    public String helloWorld(){
        return "bonjour";
    }

    @GetMapping("/ressourcePrivee")
    public String ressourcePrivee(){
        return "ressourcePrivee";
    }

    @GetMapping("/ressourcePublique")
    public String ressourcePublique(){
        return "ressourcePublique";
    }


}
