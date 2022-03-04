package com.AddressBook.controller;

import com.AddressBook.model.AddressBook;
import com.AddressBook.model.BuddyInfo;
import com.AddressBook.repository.AddressBookRepository;
import com.AddressBook.repository.BuddyInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class BuddyInfoController {

    final
    BuddyInfoRepository bir;

    public BuddyInfoController(BuddyInfoRepository bir) {
        this.bir = bir;
    }

    @GetMapping("/buddyInfo")
    public String buddyInfoForm(@ModelAttribute("ab") final AddressBook ab, Model model) {
        model.addAttribute("buddyInfo", new BuddyInfo());
        model.addAttribute("addressBook", ab);
        return "buddyInfoForm";
    }

    @PostMapping("/buddyInfo")
    public String buddyInfoSubmit(@ModelAttribute("ab") final AddressBook ab, @ModelAttribute BuddyInfo bi, Model model) {
        model.addAttribute("buddyInfo", bi);
        bir.save(bi);
        ab.addBuddy(bi);
        return "buddyInfoResult";
    }
}
