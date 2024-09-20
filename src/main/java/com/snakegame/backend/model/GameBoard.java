package com.snakegame.backend.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GameBoard {
    private int width;
    private int height;
    private Snake snake;
    private Food food;
    private boolean gameOver;

    public GameBoard(int width, int height) {
        this.width = width;
        this.height = height;
        this.snake = new Snake(width / 2, height / 2);
        generateFood();
        this.gameOver = false;
    }

    // Generate food at a random position
    public void generateFood() {
        int foodX = (int) (Math.random() * width);
        int foodY = (int) (Math.random() * height);
        this.food = new Food(foodX, foodY);
    }
}
