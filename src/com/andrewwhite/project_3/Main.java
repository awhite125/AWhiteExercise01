package com.andrewwhite.project_3;

import java.util.*;
import java.lang.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ListContainerClass items = new ListContainerClass();
        int userSelection;

        userSelection = menu();

        while (userSelection != 0) {
            menuOptions(items, userSelection);
            userSelection = menu();
        }
    }

    static int menu() {
        Scanner sc = new Scanner(System.in);
        String menuStringSelection;
        int selection = 0;

        System.out.println("Please choose an option:");
        System.out.println("(1) Add a task.");
        System.out.println("(2) Remove a task.");
        System.out.println("(3) Update a task.");
        System.out.println("(4) List all tasks.");
        System.out.println("(5) List all tasks of a certain priority.");
        System.out.println("(0) Exit.");


        menuStringSelection = sc.nextLine();

        boolean isInt = false;
        while (!isInt) {
            try {
                selection = Integer.parseInt(menuStringSelection);
                isInt = true;
            }
            catch (NumberFormatException e) {
                System.out.println("Please choose an option.");
                menuStringSelection = sc.nextLine();
            }
        }

        return selection;
    }

    static ListContainerClass menuOptions(ListContainerClass items, int userSelection){

        Scanner sc = new Scanner(System.in);

        int priority = 0, index = 0;
        String name, description, inputPriority;
        boolean isInt;

        switch (userSelection) {
            case 1:

                System.out.println("Enter the new task's name.");
                name = sc.nextLine();
                System.out.println("Enter the new task's description.");
                description = sc.nextLine();
                System.out.println("Enter the new task's priority.");
                inputPriority = sc.nextLine();
                isInt = false;
                while (!isInt) {
                    try {
                        priority = Integer.parseInt(inputPriority);
                        isInt = true;
                    }
                    catch (NumberFormatException e) {
                        System.out.println("Enter the new task's priority.");
                        inputPriority = sc.nextLine();
                    }
                }

                items.add(new ListItem(name, description, priority));

                break;
            case 2:
                String removeStringIndex;
                int removeIndex;
                System.out.println("Enter the index of the task to remove.");

                removeStringIndex = sc.nextLine();

                isInt = false;
                while (!isInt) {
                    try {
                        removeIndex = Integer.parseInt(removeStringIndex);
                        if (removeIndex<items.size()) {
                            items.remove(removeIndex);
                        }
                        isInt = true;
                    }
                    catch (NumberFormatException e) {
                        System.out.println("Enter the index of the task to remove.");
                        removeStringIndex = sc.nextLine();
                    }
                }
                break;
            case 3:
                String indexString;

                System.out.println("Enter the index of the task to update.");
                indexString = sc.nextLine();

                isInt = false;
                while(!isInt) {
                    try {
                        index = Integer.parseInt(indexString);
                        isInt = true;
                    }
                    catch (NumberFormatException e){
                        System.out.println("Enter the index of the task to update.");
                        indexString = sc.nextLine();
                    }
                }
                if (index<items.size()){
                    System.out.println("Enter the new task's name.");
                    name = sc.nextLine();
                    System.out.println("Enter the new task's description.");
                    description = sc.nextLine();
                    System.out.println("Enter the new task's priority.");
                    inputPriority = sc.nextLine();

                    isInt = false;
                    while (!isInt) {
                        try {
                            priority = Integer.parseInt(inputPriority);
                            isInt = true;
                        }
                        catch (NumberFormatException e) {
                            System.out.println("Enter the new task's priority.");
                            inputPriority = sc.nextLine();
                        }
                    }

                    items.set(index, new ListItem(name, description, priority));
                }
                break;
            case 4:
                items.display();
                break;
            case 5:
                String priorityString;
                System.out.println("Enter a priority");
                priorityString = sc.nextLine();
                isInt = false;
                while (!isInt) {
                    try {
                        priority = Integer.parseInt(priorityString);
                        isInt = true;
                    }
                    catch (NumberFormatException e) {
                        System.out.println("Enter the new task's priority.");
                        priorityString = sc.nextLine();
                    }
                }

                items.displaySelectedPriority(priority);
                break;
        }
        return items;
    }

}


class ListItem implements Comparable<ListItem>  {
    private String name;
    private String description;
    private int priority;

    @Override
    public int compareTo(ListItem i) {
        if (!name.equals(i.name)) {
            return name.compareTo(i.name);
        }
        else {
            return Integer.compare(priority, i.priority);
        }
    }

    public void display(int index){
        System.out.println("Task index: " + index + ", Name: " + name + ", Description: " +
              description + ", Priority: " + priority);
    }

    public void displaySelectedPriority(int submittedPriority, int index){
        if(priority == submittedPriority) {
            System.out.println("Task index: " + index + ", Name: " + name + ", Description: " +
                    description + ", Priority: " + priority);
        }
    }

    ListItem(String name, String description, int priority){
        setName(name);
        setDescription(description);
        setPriority(priority);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}

class ListContainerClass
{
    List<ListItem> items = new ArrayList<>();

    public void add(ListItem i)
    {
        items.add(i);
    }

    public void display()
    {

        Collections.sort(items);
        for (ListItem i: items)
        {
            i.display(items.indexOf(i));
        }
    }

    public void displaySelectedPriority(int priority){
        Collections.sort(items);
        for(ListItem i: items)
        {
            i.displaySelectedPriority(priority, items.indexOf(i));
        }

    }

    public int size(){

        return items.size();
    }
    public void remove(int index){
        items.remove(index);
    }
    public int indexOf(ListItem item) {
        return items.indexOf(item);
    }
    public void set(int index, ListItem newListItem){
        items.set(index, newListItem);
    }
}

