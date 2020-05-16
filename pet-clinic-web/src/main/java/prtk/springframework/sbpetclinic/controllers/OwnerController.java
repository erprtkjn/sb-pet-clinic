package prtk.springframework.sbpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/owners")
@Controller
public class OwnerController {

    @RequestMapping({"", "/", "/index", "s/index.html"})
    public String listOwners(){
        return "owners/index";
    }
}