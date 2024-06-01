/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.textedbasedrpg;
import java.util.*;
/**
 *
 * @author Miklos Bolarde
 */
//diri nah ang monster 
public class Monster extends MonsterUtil{
    String name;
    int health;
    int attack;

    public Monster(String name, int health, int attack) {
        this.name = name;
        this.health = health;
        this.attack = attack;
    }
    //mao ni ingon naku nga mag base siya diri
   public void attack(Character character) {
        System.out.println(name + " attacks " + character.name + "!");
        int damage = calculateDamage();
        character.receiveDamage(damage);
        System.out.println(character.name + " takes " + damage + " damage.");

        if (character.isDefeated()) {
            System.out.println(character.name + " is defeated!");
        }
    }
   private int calculateDamage() {
        // simple rani oip katong random generattor number e balance lang natu damage nila
        Random random = new Random();
        return attack + random.nextInt(3) + 1;
    }
   //mao ning damage natu sa monster
    public void receiveDamage(int damage) {
        health -= damage;
         System.out.println(name + " took " + damage + " damage!");
        if (health <= 0) {
            System.out.println(name + " has been defeated!");
        } else {
            System.out.println(name + " has " + health + " health remaining.");
        }
    }
     public boolean isDefeated() {
        return health <= 0;
    }
}