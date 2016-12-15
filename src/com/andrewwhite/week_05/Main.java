package com.andrewwhite.week_05;

import java.util.ArrayList;
import java.util.List;

class Contact
{
    String name;
    String email;

    Contact(String name, String email)
    {
        this.name = name;
        this.email = email;
    }
}

class AddressBook
{
    List<Contact> contacts = new ArrayList<>();

    void add(Contact contact)
    {
        contacts.add(contact);
    }

    String searchName(String name)
    {
        for (Contact entry: contacts)
        {
            if (entry.name.equals(name))
            {
                return entry.email;
            }
        }
        return null;
    }
}

public class Main
{
    public static void main(String[] args)
    {
        AddressBook myAddressBook = new AddressBook();
        Contact arthur = new Contact("Andrew", "awhite125@student.cscc.edu");
        Contact joe = new Contact("Joe May", "joe@joe.com");

        myAddressBook.add(arthur);
        myAddressBook.add(joe);

        System.out.println("Bob's email address is " + myAddressBook.searchName("Bob Smith"));
    }
}