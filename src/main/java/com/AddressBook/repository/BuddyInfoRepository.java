package com.AddressBook.repository;

import com.AddressBook.model.BuddyInfo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BuddyInfoRepository extends CrudRepository<BuddyInfo, Long> {
    List<BuddyInfo> findByLastName(String lastName);

    BuddyInfo findById(long id);
}
