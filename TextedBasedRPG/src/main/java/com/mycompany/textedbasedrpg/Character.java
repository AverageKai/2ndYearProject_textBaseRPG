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
public class Character extends CharacterUtil{
    //global virables ni
    public int noMana;
    public String name;
    public int health;
    public int attack;
    public int level;
    public int mana;
    public List<Skill> skills;
    public int defeatedMonstersCount;
    //mao ni tig initialize sa mga variables
     private static final Scanner scanner = new Scanner(System.in);
     public Character(String name, int health, int attack, int level, int mana) {
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.level = level;
        this.mana = mana;
        this.defeatedMonstersCount = 0;
        this.skills = new ArrayList<>();//basically himo array, <> gamit ani kay mura ge specify kana ra mga data type sud sa Skill pwede
    }
     //mao ni tig add skill and ma gamit ni sa charachter util kay para mo add ug costome skills
     public void addSkill(Skill skill) {
        skills.add(skill);
     }
     //kani mao ni katong mo pili ka asa nga skill so array mn mga skill gi butang meaning diffrent index diffrent skill
     public void useSkill(int skillIndex, Monster target) {
         //tig check ni if sakto bah impong input
        if (skillIndex >= 0 && skillIndex < skills.size()) {
            Skill selectedSkill = skills.get(skillIndex);
            //kani tig check sa mana nimo or sa charachter kay ma spam if wala ni and basically after this kay ma gamit nah ang skill
            if (mana >= selectedSkill.manaCost) {
                System.out.println("----------------------------------------");
                System.out.println(name + " used " + selectedSkill.name + "!");
                target.receiveDamage(selectedSkill.damage);
                mana -= selectedSkill.manaCost;
            } else {
                System.out.println("Not enough mana to use this skill.");
                System.out.print("Do you wish to run away?(y/n): ");
                 char choice = scanner.next().charAt(0);
                 if(choice=='y'||choice=='Y'){
                     noMana=1;
                 }else{
                     noMana=0;
                 }
                
            }
        } else {
            System.out.println("Invalid skill selection.");
        }
    }
     private void healHealth() {
        // Tabangi kog balance plz tenks
        health += 10;
        System.out.println(name + " healed health. Current health: " + health);
    }
     private void increaseAttack() {
        // Kani sad arigato
        Random random = new Random();
        int increase = random.nextInt(5) + 1;
        attack += increase;
        System.out.println(name + " increased attack by " + increase);
    }
     private void recoverMana() {
         //same sad ani pero okay nman guro ni
        Random random = new Random();
        int increase = random.nextInt(5) + 1;
        mana += increase;
        System.out.println(name + " recovered mana. Current mana: " + mana);
        System.out.println("----------------------------------------");
    }
     //mao ning tig tamage sa player depende sad sa random number mo gawas sa monster.java attack nga function
    public void receiveDamage(int damage) {
        health -= damage;
        if (health < 0) {
            health = 0;
        }
    }
    public boolean NoMana(){
        return mana==1;
    }
    //sabot ramu ani oip 
     public boolean isDefeated() {
        return health <= 0;
    }
    //max mn 3 nga level kay kapoy nah kong daghan op na kaayu HAHAHA
     public boolean canLevelUp() {
        return level < 3;
    }
    //ge kaput naku ani unya nalang ni oip chuy kaayu kay mo dagan ka kay mo level up ka HAHAAHHAH
     public void levelUp() {
        if (level < 3) {
            defeatedMonstersCount++;
            
            if (defeatedMonstersCount==2||defeatedMonstersCount==5||defeatedMonstersCount==7) {
                level++;
                System.out.println("----------------------------------------");
                System.out.println(name + " leveled up to level " + level + "!");
                System.out.println("Choose an upgrade:");
                System.out.println("1. Heal health");
                System.out.println("2. Increase attack");
                System.out.print("Choice : ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        healHealth();
                        break;
                    case 2:
                        increaseAttack();
                        break;
                    default:
                        System.out.println("Invalid choice. Defaulting to healing health.");
                        healHealth();
                }
                // ge defalut nalang naku ang mana nga mo recover siyag iyaha kay ge try naku ganinah daku lagi akong health pero mana gamay
                recoverMana();
            } else {
                System.out.println("Not enough monsters defeated to level up.");
            }
        } else {
            System.out.println(name + " is already at the max level.");
        }
    }
}
