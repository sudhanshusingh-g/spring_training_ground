package org.example.spring_training_ground;

import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("/user")
public class SampleController {
//    @GetMapping("/sayHi")
    public String sayHi(){
        return "Hi from ";
    }
//    @GetMapping("/sayBye/{name}")
    public String sayBye(@PathVariable("name") String name){
        return "Bye, from "+name;
    }
}
