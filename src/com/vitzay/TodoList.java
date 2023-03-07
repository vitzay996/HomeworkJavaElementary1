package com.vitzay;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TodoList {
    public static Scanner SCANNER = new Scanner(System.in);
    public static List<Task> LIST_ALL_TASK = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            launchMenu();
        }
    }

    public static void actionSetFromTheMenu() {
        int numberOperation = readNumberOperation();
        if (numberOperation < 1 || numberOperation > 6) {
            System.out.println("Incorrect number entered");
            System.out.println("Press Enter to go to the menu");
            SCANNER.nextLine();
        } else if (numberOperation == 1) {
            launchOfTheFirstItem();
        } else if (numberOperation == 2) {
            launchOfTheSecondItem();
        } else if (numberOperation == 3) {
            launchOfTheThirdItem();
        } else if (numberOperation == 4) {
            launchOfTheFourthItem();
        } else if (numberOperation == 5) {
            launchOfTheFifthItem();
        } else  {
            System.exit(0);
        }
    }

    private static void checkingTheListForStatusCompleted() {
        for (int i = 0; i < LIST_ALL_TASK.size(); i++) {
            if (LIST_ALL_TASK.get(i).getState().equals("completed")) {
                int number = i + 1;
                System.out.println(number + ". " + LIST_ALL_TASK.get(i));
            }
        }
    }
//
    private static void checkingTheListForStatusUncompleted() {
        for (int i = 0; i < LIST_ALL_TASK.size(); i++) {
            if (LIST_ALL_TASK.get(i).getState().equals("uncompleted")) {
                int number = i + 1;
                System.out.println(number + ". " + LIST_ALL_TASK.get(i));
            }
        }
    }

    public static void launchMenu() {
        System.out.println("1.Add task\n" +
                "2.See a list of all tasks\n" +
                "3.See the list of completed tasks\n" +
                "4.See the list of uncompleted tasks\n" +
                "5.Mark the task as completed\n" +
                "6.To exit");
        actionSetFromTheMenu();
    }

    public static int readNumberOperation() {
        System.out.println("Please enter number desired operation");
        int numberOperation = SCANNER.nextInt();
        String str1 = SCANNER.nextLine(); //scanner bug fix
        return numberOperation;
    }

    public static void launchOfTheFirstItem() {
        System.out.println("Please write down your task: ");
        String writeTask = SCANNER.nextLine();
        if (writeTask.equals("")) {
            System.out.println("You haven't written anything down.");
        } else {
            LIST_ALL_TASK.add(new Task(writeTask));
            System.out.println("Task is listed.");
        }
        System.out.println("Press Enter to go to the menu.");
        SCANNER.nextLine();
    }

    public static void launchOfTheSecondItem() {
        for (int i = 0; i < LIST_ALL_TASK.size(); i++) {
            int number = i + 1;
            System.out.println(number + ".  " + LIST_ALL_TASK.get(i));
        }
        System.out.println("Press Enter to go to the menu");
        SCANNER.nextLine();
    }

    public static void launchOfTheThirdItem() {
        checkingTheListForStatusCompleted();
        System.out.println("Press Enter to go to the menu.");
        SCANNER.nextLine();
    }

    public static void launchOfTheFourthItem() {
        checkingTheListForStatusUncompleted();
        System.out.println("Press Enter to go to the menu");
        SCANNER.nextLine();
    }

    public static void launchOfTheFifthItem() {
        String state = "completed";
        System.out.println("Please enter the number of the task from the list of not completed, \n" +
                "which you would like to mark as completed: ");
        int numberTask = SCANNER.nextInt() - 1;
        String str2 = SCANNER.nextLine(); //scanner bug fix
        if (LIST_ALL_TASK.size() == 0) {
            System.out.println("Task list is empty.");
        } else if (numberTask < 0 || numberTask > LIST_ALL_TASK.size()) {
            System.out.println("Incorrect number entered");
        } else {
            LIST_ALL_TASK.get(numberTask).setState(state);
            System.out.println("Task marked as completed");
        }
        System.out.println("Press Enter to go to the menu.");
        SCANNER.nextLine();
    }
}