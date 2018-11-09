package com.company;

public class Item {
    public String name;
    private boolean itemUsed = false;
    public Item(String name){
        this.name = name;
    }

    public void useItem(){
        if(!itemUsed){
            if(this.name.equals("Food")){
                System.out.println("You have eaten the food, you are no longer hungry.");
                System.out.println();
            }
            if(this.name.equals("Tools")){
                System.out.println("You have used your tools to clear the obstruction.");
                System.out.println();
            }
            if(this.name.equals("Artifact")){
                System.out.println("You grab your friends hand and squeeze the artifact. It teleports you outside of the cave, where you are safe.");
                System.out.println("THE END");
            }
            this.itemUsed = true;
        }
        else{
            System.out.println("You have already used this item.");
        }

    }

}
