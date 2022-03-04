package com.AddressBook.controller;

import com.AddressBook.model.AddressBook;
import com.AddressBook.repository.AddressBookRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AddressBookRestController {

    final AddressBookRepository abr;

    public AddressBookRestController(AddressBookRepository abr) {
        this.abr = abr;
    }

    @GetMapping("addressBookService")
    public List<AddressBook> getBook(){
        Iterable<AddressBook> ab = abr.findAll();
        List<AddressBook> target = new ArrayList<>();
        ab.forEach(target::add);
        return target;
    }
}
