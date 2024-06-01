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
public class CharacterUtil{
  public static Character chooseCharacter() {
      Scanner scanner = new Scanner(System.in);
        System.out.println("-----------------------------------------");
        System.out.println("| Welcome to Ragnoraok: Quest of Heros! |");
        System.out.println("-----------------------------------------");
        System.out.println("\n---------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("There was a God who planned to rule all nine realms. Blinded by power and fear, he wanted to have control over all nine realms in his palms.\nOdin, the All Father, sent his minions and generals for the conquest of the nine realms, leaving no living being to escape his grasp.\nBut there are three gods who opposed this grasp, not wanting Odin, the All Father, to meddle in their lives.\nThey journey onward to confront Odin and put an end to his tyranny.");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Choose your Character Essence:");
        System.out.println("1. Kratos");
        System.out.println("2. Freyja");
        System.out.println("3. Atreus");
        System.out.print("Input Choice:");
        int choice = scanner.nextInt();
        return createCharacter(choice);
    }
  //help balance plz
  public static Character createCharacter(int choice) {
        switch (choice) {
            case 1:
                Character warrior = new Character("Kratos", 200, 25, 0, 100);//makita rman asa health ug uban
                KratosSkills(warrior);
                return warrior;
            case 2:
                Character witch = new Character("Freyja", 150, 12, 0, 200);
                FreyjaSkills(witch);
                return witch;
            case 3:
                Character archer = new Character("Atreus", 165, 20, 0, 150);
                AtreusSkills(archer);
                return archer;
            default:
                 Character khai = new Character("Khai The Conqueror", 500, 30,99,500);
                 KhaiSkills(khai);
                 return khai;
        }
    }
  //diri nah ang mga skill kamo lang add diri nya e balance lang
    private static void KratosSkills(Character warrior) {
          warrior.addSkill(new Skill("Slash", 30, 10));
          warrior.addSkill(new Skill("Shield Bash", 20, 5));
          warrior.addSkill(new Skill("Spartan Rage", 50, 50));
      }

      private static void FreyjaSkills(Character witch) {
          witch.addSkill(new Skill("Fireball", 30, 20));
          witch.addSkill(new Skill("Ice Shard", 25, 15));
          witch.addSkill(new Skill("Poison Touch", 15, 10));
          witch.addSkill(new Skill("Vine Whip", 25, 10));
          witch.addSkill(new Skill("Gravity Manipulation",55, 80));
      }

      private static void AtreusSkills(Character archer) {
          archer.addSkill(new Skill("Power Shot", 25, 10));
          archer.addSkill(new Skill("Snipe", 30, 20));
          archer.addSkill(new Skill("Dagger Strike", 15, 5));
          archer.addSkill(new Skill("Focus Fire", 50, 60));
      }
      private static void KhaiSkills(Character khai) {
          khai.addSkill(new Skill("Lair ninyooo!!!", 69420, 1));
          khai.addSkill(new Skill("CodeChum ninyoo!!!", 911, 1));
      }
}
