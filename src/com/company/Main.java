package com.company;

public class Main {

    public static void main(String[] args) {
        int health[] = {700, 250, 250, 250};
        int hits[] = {50, 20, 20, 20};
        String hitTypes[] = {"Physical", "Physical", "Magical", "Psyho"};

        fighting (health, hits, hitTypes);

    }

    private static void fighting(int[] health, int[] hits, String[] hitTypes) {
        while (isNotFinish()) {
            round ();
        }
    }

    private static void round() {
    }

    private static boolean isNotFinish(int health []) {
        if ((health [0] <= 0) || (health[1] <= 0 && health[2] && health[3] <= 0)) {
            return false;
        }
        return true;
    }

}
