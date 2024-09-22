package com.snakegame.backend.model;

import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;

@Getter
@Setter
public class Snake {
    private LinkedList<int[]> body; // List of snake parts (each represented by an [x, y] coordinate)

    public Snake(int startX, int startY) {
        body = new LinkedList<>();
        body.add(new int[]{startX, startY}); // Head of the snake
    }

    public void grow() {
        body.addFirst(new int[]{body.getFirst()[0], body.getFirst()[1]});
    }

    public void move(int[] newPosition) {
        body.addFirst(newPosition);  // Move the head
        body.removeLast();           // Remove the tail
    }
}
