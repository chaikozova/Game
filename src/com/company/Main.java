package com.company;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Player player1 = new Player();
        player1.health = 250;
        player1.hits = 20;
        player1.hitType = 1;

        Player player2 = new Player();
        player2.health = 250;
        player2.hits = 20;
        player2.hitType = 2;

        Player player3 = new Player();
        player3.health = 250;
        player3.hits = 20;
        player3.hitType = 3;

        Player player4 = new Player();
        player4.health = 250;
        player4.hits = 20;
        player4.hitType = 4;

        Thanos thanos = new Thanos();
        thanos.health = 700;
        thanos.hit = 50;


        int health[] = {thanos.health, player1.health, player2.health, player3.health, player4.health };
        int hits[] = {thanos.hit, player1.hits, player2.hits, player3.hits, player4.hits};
        int hitTypes[] = { thanos.hitType, player1.hitType, player2.hitType, player3.hitType, player4.hitType};


        fighting (health, hits, hitTypes, thanos);

    }

    private static void fighting(int[] health, int[] hits, int[] hitTypes, Thanos thanos) {
        while (isNotFinish(health, true)) {
            round (health, hits, hitTypes, thanos);
            printStatistics(health);
        }
    }

    private static void printStatistics(int[] health) {
        System.out.println("Thanos health: "+health[0]);
        System.out.println("Thor health: "+health[1]);
        System.out.println("Capitan health: "+health[2]);
        System.out.println("Stark health: "+health[3]);
        System.out.println("Doctor health: "+health[4]);
        System.out.println("________________");
    }

    private static void round(int[] health, int[] hits, int[] hitTypes, Thanos thanos) {
        HerosBitBoss(health, hits, hitTypes);
        if (!isNotFinish(health, false)) {
            return;
        }
        if (health[4] != 0) {
            for (int i = 1; i < 4; i++) {
                health[i] = health [i] + hits [4];
            }
        }
        BossBitsHeros(health, hits);
        thanos.changeHitType();
        //changeBossHitTypes(hitTypes);
    }

    private static void changeBossHitTypes(String[] hitTypes) {
        Random random = new Random();
        int randomInt = random.nextInt(4) + 1;
        hitTypes [0] = hitTypes [randomInt];
    }

    private static void HerosBitBoss(int[] health, int[] hits, int[] hitTypes) {
        for (int i = 1; i < 4; i++) {
            if (health[0] != 0) {
                health[0] = playerHit(hitTypes, i, hits, health);
            }
        }
    }

    private static void BossBitsHeros(int[] health, int[] hits) {
        for (int i = 1; i < 5; i++) {
           if (health[i] != 0) {
               health[i] = health[i] - hits[0];
               if (hits[0] > health [i]) {
                   health[i] = 0;
               }
           }
        }
    }

    private static int playerHit(int[] hitTypes, int playerNumber, int[] hits, int[] health) {
        Random random = new Random();
        int randomInt = random.nextInt(6) + 2;
        int playerHit;
        if (hitTypes[0] == hitTypes[playerNumber]) {
            playerHit = hits[playerNumber]* randomInt;
        } else {
            playerHit = hits[playerNumber];
        }
        if (health[0] > playerHit) {
            return health[0] - playerHit;
        }  else {
            return health[0] - health[0];
        }
    }

    private static boolean isNotFinish(int health [], boolean showWin) {
        if (health [0] <= 0) {
            if (showWin)
                System.out.println("Avangers WIN!!!");
            return false;
        }
        if (health[1] <= 0 && health[2] <=0  && health[3] <= 0) {
            if (showWin)
                System.out.println("Thanos WIN!!!");
            return false;
        }
        return true;
    }
}