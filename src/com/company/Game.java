package com.company;

import java.util.Scanner;

public class Game {
    // instance variables
    public static Item[] backpack = new Item[3];
    private static Room[] cave = new Room[3];

    public static void createCave(){
        cave[0] = new Room("UndergroundLake", false, "The lake was stunning. How it got there no one knows. You are mesmerized by its color, but then you snap out of it. You notice a shiny rock. You pick it up.");
        cave[1] = new Room("DeadEnd", false, "A dead end. Not much to see but a pile of rocks.");
        cave[2] = new Room("OldCaveDwelling", false, "A large dwelling with a pile of straw and someone laying in it.");
    }

    public static void createItems(){
        Item food = new Item("Food");
        Item tools = new Item("Tools");
        Item artifact = new Item("Artifact");
        fillBackpack(food, tools, artifact);
    }

    public static void fillBackpack(Item item1, Item item2, Item item3){
        backpack[0] = item1;
        backpack[1] = item2;
        backpack[2] = item3;
    }

    public static void printIntro(){
        System.out.println("Welcome to the cave game");
        System.out.println("Your mission, should you choose to accept it, is rescue your friend");
        System.out.println("Good luck!");
        System.out.println();
        System.out.println();
    }

    public static void pickRoom(int roomChoice){
        if(cave[roomChoice - 1].isVisited()){
            System.out.println("You have already been here. Pick another room");
            roomChoose();
        }
        else{
            enterRoom(cave[roomChoice - 1]);
        }
    }

    public static void enterRoom(Room room){
        System.out.println(room.description);
        room.visited = true;
        if(room.name.equals("OldCaveDwelling")){
            finalRoom();
        }
        roomChoose();
    }

    public static void finalRoom(){
        System.out.println();
        System.out.println("You have found your friend, laying on the stack. As you spot him, the entrance behind you collapses. Wondering on how to get out, you remember the artifact you always kept in your bag. 'Squeeze it, and you will come straight home', Grandma always says. You grab your friend and use it");
        backpack[2].useItem();
        System.exit(0);
    }

    public static void caveEntry(){
        Scanner userInput = new Scanner(System.in);
        System.out.print("Venturing inside the cave, you get hungry. Thankfully, you packed food. Would you like to eat? (y/n)");
        String userEating = userInput.next();
        if(userEating.equals("y")){
            backpack[0].useItem();
        }
        System.out.println("You come across a large room. From there, lead three tunnels.");
        System.out.print("Do you pick 1,2,or 3? ");
        int userChoice = userInput.nextInt();
        pickRoom(userChoice);
    }

    public static void roomChoose(){
        System.out.println();
        Scanner userInput = new Scanner(System.in);
        System.out.println("You are back at the large room. From there, lead the three tunnels.");
        System.out.print("Do you pick 1,2,or 3? ");
        int userChoice = userInput.nextInt();
        pickRoom(userChoice);
    }

    public static void main(String[] args) {
        createItems();
        createCave();
        printIntro();
        caveEntry();

    }
}
