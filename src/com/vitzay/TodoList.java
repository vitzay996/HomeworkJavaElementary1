package com.vitzay;

import java.util.Scanner;

public class TodoList {
    public static Scanner SCANNER = new Scanner(System.in);
    public static void main(String[] args) {

    }

    public static void actionSetFromTheMenu() {
        int numberOperation = readNumberOperation();

    }

    public static int readNumberOperation() {
        System.out.println("Please enter number desired operation");
        int numberOperation = SCANNER.nextInt();
        String str1 = SCANNER.nextLine(); //scanner bug fix
        return numberOperation;
    }
}