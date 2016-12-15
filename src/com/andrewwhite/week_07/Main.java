package com.andrewwhite.week_07;

class Contact
{
    private String name;
    private String email;

    Contact(String name, String email)
    {
        this.name = name;
        this.email = email;
    }

    public void display()
    {
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
    }
}

class BusinessContact extends Contact
{
    private String phoneNumber;

    BusinessContact(String name, String email, String phoneNumber)
    {
        super(name, email);
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void display()
    {
        super.display();
        System.out.println("Phone Number: " + phoneNumber);
    }
}

public class Main
{
    public static void main(String[] args)
    {
        Contact andrew = new Contact("Andrew", "awhite125@student.cscc.edu");
        andrew.display();

        BusinessContact joe = new BusinessContact("Joe", "joe@joe.com", "614-123-4567");
        joe.display();
    }
}