package com.company;

import java.util.Random;

public class Thanos {
    int health;
    int hit;
    int hitType;

    public void changeHitType() {
        Random random = new Random();
        int randomInt = random.nextInt(4) + 1;
        this.hitType = randomInt;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHit() {
        return hit;
    }

    public void setHit(int hit) {
        this.hit = hit;
    }

    public int getHitType() {
        return hitType;
    }

    public void setHitType(int hitType) {
        this.hitType = hitType;
    }
}
