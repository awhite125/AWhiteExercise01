package com.andrewwhite.project_02;
import java.util.LinkedList;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        LinkedList<ListItem> items = new LinkedList<>();
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

    static LinkedList<ListItem> menuOptions(LinkedList<ListItem> items, int userSelection){

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
                for (ListItem item : items) {
                    System.out.println("Task index: " + items.indexOf(item) + ", Name: " + item.getName() + ", Description: " +
                            item.getDescription() + ", Priority: " + item.getPriority());
                }
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

                for (ListItem item : items) {
                    if(item.getPriority()== priority){
                        System.out.println("Task index: " + items.indexOf(item) + ", Name: " + item.getName() + ", Description: " +
                                item.getDescription() + ", Priority: " + item.getPriority());
                    }
                }
                break;
        }
        return items;
    }

}

class ListItem {
    private String name;
    private String description;
    private int priority;

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

    public String ListAll(){
        String bob = "fdsa";
        return bob;
    }
}
