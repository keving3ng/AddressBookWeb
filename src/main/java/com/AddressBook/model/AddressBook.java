package com.AddressBook.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AddressBook {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @OneToMany
    private List<BuddyInfo> buddyList;

    public AddressBook(){
        this.buddyList = new ArrayList<>();
    }

    public AddressBook(ArrayList<BuddyInfo> buddyList) {
        this.buddyList = buddyList;
    }

    public AddressBook(String name, ArrayList<BuddyInfo> buddyList) {
        this.name = name;
        this.buddyList = buddyList;
    }

    public String getName() {
        return name;
    }

    public Integer len() {
        return this.buddyList.size();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public List<BuddyInfo> getBuddyList() {
        return buddyList;
    }

    public void addBuddy(BuddyInfo buddy){
        this.buddyList.add(buddy);
    }

    @Override
    public String toString() {
        return "Address Book " + this.id.toString() + " - name: " + this.getName() + " entries: " + this.len();
    }
}
