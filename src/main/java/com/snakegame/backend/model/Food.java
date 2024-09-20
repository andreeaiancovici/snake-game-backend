package com.snakegame.backend.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Food {
    private int x;
    private int y;

    public Food(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
