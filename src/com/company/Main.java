package com.company;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int health[] = {700, 250, 250, 250, 250};
        int hits[] = {50, 20, 20, 20, 20};
        String hitTypes[] = {"Physical", "Physical", "Magical", "Psyho", "Doctor"};

        fighting (health, hits, hitTypes);

    }

    private static void fighting(int[] health, int[] hits, String[] hitTypes) {
        while (isNotFinish(health, true)) {
            round (health, hits, hitTypes);
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

    private static void round(int health [], int hits [],String hitTypes []) {
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
        changeBossHitTypes(hitTypes);
    }

    private static void changeBossHitTypes(String[] hitTypes) {
        Random random = new Random();
        int randomInt = random.nextInt(4) + 1;
        hitTypes [0] = hitTypes [randomInt];
    }

    private static void HerosBitBoss(int[] health, int[] hits, String[] hitTypes) {
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

    private static int playerHit(String[] hitTypes, int playerNumber, int[] hits, int[] health) {
        Random random = new Random();
        int randomInt = random.nextInt(6) + 2;
        int playerHit;
        if (hitTypes[0].equals(hitTypes[playerNumber])) {
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