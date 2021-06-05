package com.company;

import java.util.Random;

public class Main {

    public static int bossHealth = 700;
    public static int bossDamage = 70;
    public static String bossDefenceType = "";

    public static int[] heroesHealth = {200, 150, 180,150};
    public static int[] heroesDamage = {25, 20, 30,0};
    public static String[] heroesAttackType = {" Боец", " Маг", " Убийца", " Целители"};

    public static int healerHealing = 30;


    public static void main(String[] args) {

        fightInfo();
        while (!isFinished()) {
            round();
        }


    }

    public static void round() {
        changeBossDefence();
        bossHit();
        heroesHit();
        heals();
        fightInfo();
    }



    public static void changeBossDefence(){
        Random random1 = new Random();
        int randomIndex = random1.nextInt(heroesAttackType.length);
        bossDefenceType = heroesAttackType[randomIndex];
    }

    public static boolean isFinished() {
        if (bossHealth <= 0) {
            System.out.println("Герои выиграли!");
            return true;
        }
        if (heroesHealth[0] <= 0 && heroesHealth[1] <= 0 && heroesHealth[2] <= 0) {
            System.out.println("Босс выиграл!");
            return true;
        }
        return false;
    }
    public static void heals() {
        for (int i = 0; i < 3; i++) {
            heroesHealth[i] = heroesHealth[i] + healerHealing;
        }
    }

    public static void bossHit() {
        for (int i = 0; i < heroesHealth.length; i++) {
            if (heroesHealth[i] > 0 && bossHealth > 0) {
                }
                    if (heroesHealth[i] - bossDamage < 0) {
                        heroesHealth[i] = 0;
                    } else {
                        heroesHealth[i] = heroesHealth[i] - bossDamage;
                    }
                }
            }


    public static void heroesHit() {
        for (int i = 0; i < heroesDamage.length; i++) {
            if (heroesHealth[i] > 0 && bossHealth > 0) {
                if (bossDefenceType.equals(heroesAttackType[i])) {
                    Random random2 = new Random();
                    int koeff = random2.nextInt(9) + 2;
                    if (bossHealth - heroesDamage[i] * koeff < 0) {
                        bossHealth = 0;
                    } else {
                        bossHealth = bossHealth - heroesDamage[i] * koeff;

                    }
                    System.out.println(heroesAttackType[i] + " нанёс критический урон! " + heroesDamage[i] * koeff);
                } else {
                    if (bossHealth - heroesDamage[i] < 0) {
                        bossHealth = 0;
                    } else {
                        bossHealth = bossHealth - heroesDamage[i];
                    }
                }
            }
        }
    }
    //Статистика боя
    public static void fightInfo() {
        System.out.println("______________________");
        System.out.println("Здоровья Босса: " + bossHealth + bossDefenceType);
        System.out.println("Здоровья бойца:  " + heroesHealth[0]);
        System.out.println("Здоровья мага:  " + heroesHealth[1]);
        System.out.println("Здоровья убийцы   :" + heroesHealth[2]);
        System.out.println("Здоровья целителя  :" + heroesHealth[3]);
        System.out.println("______________________");
    }

}
