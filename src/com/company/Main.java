package com.company;

import Entities.Kid;
import Parser.XMLWriter;

import java.util.Scanner;

import static Parser.SAXPars.getResult;

public class Main {
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int selectId = 0;
        while (selectId != 3) {
            System.out.println("Выберите действие: \n 1)Добавить ребенка \n 2)Посмотреть всех \n 3)Выйти \n");
            switch (selectId = in.nextInt()) {
                case 1:
                    addChild();
                    break;
                case 2:
                    for(Kid kid:getResult()){
                        kid.print();
                }
                    break;
                case 3:
                    break;
            }
        }
    }

    public static void addChild() {
        Kid kid = new Kid();
        System.out.println("Введите id:");
        kid.setId(in.nextInt());
        System.out.println("Введите id группы:");
        kid.setGroupId(in.nextInt());
        in.nextLine();
        System.out.println("Введите имя:");
        kid.setFirstName(in.nextLine());
        System.out.println("Введите фамилию:");
        kid.setSecondName(in.nextLine());
        System.out.println("Введите отчество:");
        kid.setMiddleName(in.nextLine());
        System.out.println("Введите имя матери:");
        kid.setMothersName(in.nextLine());
        System.out.println("Введите id шкафчика:");
        kid.setBoxId(in.nextInt());
        System.out.println("Введите возраст:");
        kid.setAge(in.nextInt());
        XMLWriter writer = new XMLWriter();
        writer.addKid(kid);
    }
}



