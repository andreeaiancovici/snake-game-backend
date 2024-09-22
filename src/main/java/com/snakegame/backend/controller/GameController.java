package com.snakegame.backend.controller;

import com.snakegame.backend.model.GameBoard;
import com.snakegame.backend.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/snake-game")
@CrossOrigin(origins = "http://localhost:3000") // Add this to allow CORS from the React app
@RequiredArgsConstructor
public class GameController {

    private final GameService gameService;

    @GetMapping("/state")
    public GameBoard getGameState() {
        return gameService.getGameState();
    }

    @PostMapping("/move")
    public GameBoard moveSnake(@RequestParam String direction) {
        if (!gameService.isGameOver()) {
            gameService.moveSnake(direction);
        }
        return gameService.getGameState();
    }

    @PostMapping("/reset")
    public GameBoard resetGame() {
        gameService.resetGame(); // This method resets the game state in the service
        return gameService.getGameState(); // Return the reset game state
    }
}
