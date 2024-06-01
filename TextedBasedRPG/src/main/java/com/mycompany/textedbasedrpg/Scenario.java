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
public class Scenario {
    public static void forgetName(Character character) {
        Scanner scanner = new Scanner(System.in);
     if("Kratos".equals(character.name)){
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("Kratos, the Ghost of Sparta, was once a fearsome general who became God-Killer.\nWith his bottomless strength, he single-handedly killed all the gods of Olympus, quenching his anger against them.\nNow, with his new-found purpose, he wanted to protect his son Atreus from the evil gods that decided to pursue them.");
        System.out.println("-------------------------------------------------------------------------------");
        System.out.print("Enter Thy name: ");
        String nickname = scanner.nextLine();
        character.name = nickname;
     }else if("Freyja".equals(character.name)){
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("Freya, Witch of the Woods, Lady of the Vanir.\nA goddess with bottomless knowledge of magic, no spell deemed impossible to achieve,\nnor trickery of the enemy, can make a fool of her. A witch that rivals even the magic of Odin the All-Father.");
        System.out.println("-------------------------------------------------------------------------------");
        System.out.print("Enter Thy name: ");
        String nickname = scanner.nextLine();
        character.name = nickname;
     }else if("Atreus".equals(character.name)){
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("Atreus, Loki’s reincarnation, son of Kratos.\nA god who has unlimited potential with the bow. With his agility, marksmanship,\nand battle sense that he inherited from his father,\nhe can grow to be a god who will shake the balance of power over the nine realms.");
        System.out.println("-------------------------------------------------------------------------------");
        System.out.print("Enter Thy name: ");
        String nickname = scanner.nextLine();
        character.name = nickname;
     }else if("Khai The Conqueror".equals(character.name)){
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("In the twilight of his conquests, Khai faced an enigmatic prophecy demanding\n the ultimate test: to kill Odin, the All-Father. Reluctantly, Khai embarked on the perilous journey,\n determined to confront the godly patriarch. As clashes between mortal and divine ensued,\n Khai's indomitable spirit clashed with Odin's omnipotence. In a climactic showdown, Khai emerged triumphant,\n forever altering the cosmic order. The once-conqueror, now a godslayer,\n shaped Eldoria's destiny in a final act that resonated through the realms.");
        System.out.println("-------------------------------------------------------------------------------");
     }
  }
    public static void travel(Random random,Character character) {
        System.out.println("\n-----------------------Travelling....---------------------------");
        System.out.println("You are traveling through the mystical lands...");

        int eventChance = random.nextInt(100);
        

        if (eventChance < 20) { // 20% ang chance ani ma hitabo
            System.out.println("You encountered a friendly traveler named Sir Khai!");
            System.out.println("They share valuable information with you.");
            character.mana+=30;
            System.out.println("+30 Mana");
            // maka add pata ani suggestion naku kay e name siya sir kay ang traveler nya mo ingo nsiyag mga quotes niya for the past sem
        } else if (eventChance < 40) { // 20% gihapon ang ma hitabo ani dili 40% kay basta sabot ramo
            System.out.println("You found a hidden treasure chest!");
            System.out.println("You gained the sword of Fable.");
            character.attack+=10;
            System.out.println("+10 Attack");
            // add lang tah more ani
        } else if (eventChance < 60) { // 20% gihapon ang ma hitabo ani dili 40% kay basta sabot ramo
            System.out.println("You found a hidden treasure chest!");
            System.out.println("You gained some Tears of the Gods.");
            character.health+=20;
            System.out.println("+20 Health");
            // add lang tah more ani
        } else if (eventChance < 70) { // 20% gihapon ang ma hitabo ani dili 40% kay basta sabot ramo
            System.out.println("You Found The Sword of Olympus");
            character.attack+=30;
            System.out.println("+30 Attack");
            // add lang tah more ani
        }else if (eventChance < 80) { // 20% gihapon ang ma hitabo ani dili 40% kay basta sabot ramo
            System.out.println("You Found an Itembox");
            System.out.println("Inside is the Blade of Despair");
            character.attack+=20;
            System.out.println("+20 Attack");
            // add lang tah more ani
        }
        
    }
}
//so naay chance mo gawas ani before maka encounter tag monster
