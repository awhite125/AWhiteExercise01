package com.andrewwhite.project_01;
import java.util.Scanner;
public class Main {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int userSelection;
        int index;

        String newTask;
        String[] tasks = {};

        userSelection = menu();

        while (userSelection !=0) {
            switch (userSelection) {
                case 1:
                    System.out.println("Enter a description of the new task.");
                    newTask = sc.nextLine();
                    tasks = addTask(tasks, newTask);
                    break;
                case 2:
                    System.out.println("Enter the index of the task to remove.");
                    index = sc.nextInt();
                    tasks = removeTask(tasks, index);
                    break;
                case 3:
                    System.out.println("Enter the index of the task to update.");
                    index = Integer.parseInt(sc.nextLine());
                    System.out.println("Enter the new description of the task.");
                    newTask = sc.nextLine();
                    tasks = updateTask(tasks, newTask, index);
                    break;
                case 4:
                    listTasks(tasks);
                    break;
            }
            userSelection = menu();
        }
    }
    static int menu(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Please choose an option:");
        System.out.println("(1) Add a task.");
        System.out.println("(2) Remove a task.");
        System.out.println("(3) Update a task.");
        System.out.println("(4) List all tasks.");
        System.out.println("(0) Exit.");

        int selection = sc.nextInt();
        return selection;
    }

    static String[] addTask(String[] taskList, String item) {

        String[] newArray = new String[taskList.length + 1];

        for (int i=0; i<taskList.length; i++) {
            newArray[i] = taskList[i];
        }

        newArray[taskList.length] = item;
        return newArray;
    }

    static String[] removeTask(String[] taskList, int removeIndex){
        String[] newArray = new String[taskList.length-1];

        for (int i=0; i<removeIndex; i++) {
            newArray[i] = taskList[i];
        }
        for (int i=removeIndex; i<newArray.length; i++) {
            newArray[i] = taskList[i+1];
        }

        return newArray;
    }

    static String[] updateTask(String[] tasks, String newTaskText, int indexNum){
        tasks[indexNum] = newTaskText;
        return tasks;
    }

    static void listTasks(String[] tasks){
        for (int i=0; i<tasks.length; i++){
            System.out.println(tasks[i]);
        }
    }

}
