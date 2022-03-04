package com.AddressBook.controller;

import com.AddressBook.model.AddressBook;
import com.AddressBook.repository.AddressBookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AddressBookController {

    final
    AddressBookRepository abr;

    public AddressBookController(AddressBookRepository abr) {
        this.abr = abr;
    }

    @RequestMapping("/")
    public @ResponseBody String def() {
        return "Hello AddressBook User!";
    }

    @GetMapping("/addressBook")
    public String addressBookForm(Model model) {
        model.addAttribute("existingBooks", abr.findAll());
        model.addAttribute("addressBook", new AddressBook());
        return "addressBookForm";
    }

    @PostMapping("/addressBook")
    public String addressBookSubmit(@ModelAttribute("ab") AddressBook ab, Model model, final RedirectAttributes rdAtt) {
        rdAtt.addFlashAttribute("ab", ab);
        model.addAttribute("addressBook", ab);
        if (ab.getId() == null)
            abr.save(ab);

        return "addressBookResult";
    }

    @GetMapping("getAddressBook")
    public String getAddressBook() {
        return "getAllAddressBook";
    }
}
