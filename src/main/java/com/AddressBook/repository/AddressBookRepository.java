package com.AddressBook.repository;

import com.AddressBook.model.AddressBook;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AddressBookRepository extends CrudRepository<AddressBook, Long> {
    List<AddressBook> findByName(String name);

    AddressBook findById(long id);
}
