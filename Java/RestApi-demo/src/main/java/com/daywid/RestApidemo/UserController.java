package com.daywid.RestApidemo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    
    @GetMapping("/listar")
    public List<Users> findAll() {
        return userRepository.findAll();
    }

    @PostMapping("/salvar")
    public Users save(@RequestBody Users user) {    
         return userRepository.save(user);
     }
     
    @GetMapping("buscar/{id}")
    public ResponseEntity<Users> searchById(@PathVariable Long id, @RequestBody Users users) { 
       
        Optional<Users> user = userRepository.findById(id);
        
        if (user.isPresent()) {
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        
     }

    // @RequestMapping("path", method=RequestMethod.GET)
    // public SomeData requestMethodName(@RequestParam String param) {
    //     return new SomeData();
    // }
    
}