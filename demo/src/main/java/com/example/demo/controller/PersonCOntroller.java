/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

/**
 *
 * @author BUI QUOC BAO
 */
import java.util.List;
import javax.xml.ws.RequestWrapper;

@Controller
@RequesMapping("/user")
public class PersonCOntroller {
    
    @Autowired
    PersonRepository personRepository;
    
    //Search User 
    @GetMapping("/search")
    public String search(Model model){
        List<Person> users = personRepository.findALL();
        model.addAttribute("uList", users);
        
        return "user/searchUser";
    }
    @GetMapping("/create")
    public String create(){
        return "user/createUser";
    }
    @PostMapping("/create")
    public String create(@ModelAttribute Person user){
        personRepository.save(user);
        return "redirect:/user/search";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("id") int id){
        personRepository.deleteByID(id);
        return "redirect:/user/search";
    }
    @GetMapping("/edit")
    public String edit(Model model, @Param("id") int id){
        Person user = personRepository.getById(id);
        model.addAttribute("user", user);
        return "user/editUser";
    }
    @PostMapping("/edit")
    public String edit(@ModelAttribute("user") Person user){
        personRepository.save(user);
        return "redirect:/user/search";
    }
}
