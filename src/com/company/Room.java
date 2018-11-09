package com.company;

public class Room {
    public String name;
    public boolean visited;
    public String description;

    public Room(String name, boolean visited, String description){
        this.name = name;
        this.visited = visited;
        this.description = description;
    }

    public boolean isVisited() {
        return visited;
    }
}
