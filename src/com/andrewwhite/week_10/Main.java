package com.andrewwhite.week_10;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class AddressBook implements Iterable<Contact>
{
    private List<Contact> contacts = new ArrayList<>();

    public void add(Contact c)
    {
        contacts.add(c);
    }

    @Override
    public Iterator<Contact> iterator()
    {
        return contacts.iterator();
    }
}

class Contact implements Comparable<Contact>
{
    public String name;
    public String email;

    Contact(String name, String email)
    {
        this.name = name;
        this.email = email;
    }

    public void display()
    {
        System.out.println("Name: " + name + ", Email: " + email);
    }

    @Override
    public int compareTo(Contact o)
    {
        if (!name.equals(o.name))
        {
            return name.compareTo(o.name);
        }
        else
        {
            return email.compareTo(o.email);
        }
    }
}

public class Main
{
    public static void main(String[] args)
    {
        Contact joe = new Contact("joe", "joe@joe.com");
        Contact andrew = new Contact("Andrew", "awhite125@student.cscc.com");
        Contact andrew2 = new Contact("Andrew2", "apwhite2013@hotmail.com");

        AddressBook addressBook = new AddressBook();
        addressBook.add(joe);
        addressBook.add(andrew);
        addressBook.add(andrew2);

        for (Contact c: addressBook)
        {
            c.display();
        }
    }
}
