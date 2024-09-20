package com.snakegame.backend.service;

import com.snakegame.backend.model.GameBoard;
import com.snakegame.backend.model.Snake;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    private final GameBoard gameBoard;

    public GameService() {
        this.gameBoard = new GameBoard(20, 20); // 20x20 board size
    }

    public GameBoard getGameState() {
        return gameBoard;
    }

    public void moveSnake(String direction) {
        Snake snake = gameBoard.getSnake();
        int[] head = snake.getBody().getFirst();

        int newX = head[0];
        int newY = head[1];

        switch (direction) {
            case "UP" -> newY--;
            case "DOWN" -> newY++;
            case "LEFT" -> newX--;
            case "RIGHT" -> newX++;
        }

        // Check collision with walls
        if (newX < 0 || newX >= gameBoard.getWidth() || newY < 0 || newY >= gameBoard.getHeight()) {
            gameBoard.setGameOver(true);
            return;
        }

        // Check collision with food
        if (newX == gameBoard.getFood().getX() && newY == gameBoard.getFood().getY()) {
            snake.grow();
            gameBoard.generateFood();
        } else {
            snake.move(new int[]{newX, newY});
        }

        // Check self-collision
        for (int i = 1; i < snake.getBody().size(); i++) {
            if (newX == snake.getBody().get(i)[0] && newY == snake.getBody().get(i)[1]) {
                gameBoard.setGameOver(true);
                return;
            }
        }
    }

    public boolean isGameOver() {
        return gameBoard.isGameOver();
    }

    public void resetGame() {
        // Reset the game state variables
        Snake snake = new Snake(gameBoard.getWidth() / 2, gameBoard.getWidth() / 2); // Recreate the snake

        gameBoard.setSnake(snake);
        gameBoard.generateFood();
        gameBoard.setGameOver(false);
    }

}

//#35de00 #fd0200 #000000
