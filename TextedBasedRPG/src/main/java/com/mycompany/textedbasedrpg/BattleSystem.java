/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.textedbasedrpg;

/**
 *
 * @author Miklos Bolarde
 */
public class BattleSystem {
    public static void displayBattleStatus(Character player, Monster monster) {
        System.out.println("------ Battle Status ------");
        System.out.println(player.name + " | Level " + player.level + " | Health: " + player.health+ " | Mana: " + player.mana);
        System.out.println(monster.name + " | Health: " + monster.health);
        System.out.println("---------------------------");
    }
    public static void displayBattleResult(Character player, Monster monster) {
        if (player.isDefeated()) {
            System.out.println("You were defeated in battle. Game over!");
        } else if (monster.isDefeated()) {
            System.out.println("Congratulations! You defeated the " + monster.name + "!");
        }
    }
}
