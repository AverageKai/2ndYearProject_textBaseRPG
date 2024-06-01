/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.textedbasedrpg;

/**
 *
 * @author Miklos Bolarde
 */
import java.util.Scanner;
import java.util.Random;

public class TextedBasedRPG {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();

    public static void main(String[] args) {
    char Lchoice;
     do{
        ScoreRecorder scoreRecorder = new ScoreSystem();
        Character playerCharacter = CharacterUtil.chooseCharacter();
        Scenario.forgetName(playerCharacter);
        Monster[] monsters = MonsterUtil.generateMonsters(random);
        int count=0;
        System.out.println("\nWelcome, " + playerCharacter.name + "! To Ragnoroak: Quest of Heros! Let the adventure begin!");
        //mao ning mga senario
        for (Monster monster : monsters) {//ning ani siya kay kapoy seg count2 ge search ni naku basically mura ra siya mo count pila ka index
            //random ni nga senario mo desplay nya mga senario ani naa sa scenario.java
            Scenario.travel(random,playerCharacter);
            // naa ni diri ang encounter sa monster kay ma encounter mn jud siya ug ungo after each senario
            System.out.println("You encountered a " + monster.name + "!");
            System.out.println("-------------------------------------------------------------------------------");
            System.out.println("What will you do?");
            System.out.println("1. Fight");
            System.out.println("2. Run");
            System.out.print("Input Choice:");
            int choice = scanner.nextInt();
            int exit;
              if (choice == 1) {
                System.out.println("You chose to fight!");
                // Battle System
                while (!playerCharacter.isDefeated() && !monster.isDefeated() && playerCharacter.noMana==0) {
                    
                    BattleSystem.displayBattleStatus(playerCharacter, monster);
                    //mao ni tig display sa mga skills sa charachter
                    do{
                        System.out.println("Available Skills:");
                        for (int i = 0; i < playerCharacter.skills.size(); i++) {
                            Skill skill = playerCharacter.skills.get(i);
                            System.out.println(i + 1 + ". " + skill.name + " (Damage: " + skill.damage + ", Mana Cost: " + skill.manaCost + ")");
                        }
                    //diri ka mo pick ug skill or input.
                        System.out.print("Choose a skill (1-" + playerCharacter.skills.size() + "): ");
                        int skillChoice = scanner.nextInt() - 1;
                            if(skillChoice<playerCharacter.skills.size()){
                                //mao ni ika homan nimo pick ug skill mo damage sa monster
                                playerCharacter.useSkill(skillChoice, monster);
                                exit=1;
                            }else{
                                System.out.println("You Tried Using a Skill but Failed Try Again!");
                                exit = 0;
                            }
                        }while(exit!=1);
                    // mao ning turn sa monster
                    if (!monster.isDefeated()) {
                        monster.attack(playerCharacter);
                    }
                }

                // Display final battle result
                BattleSystem.displayBattleResult(playerCharacter, monster);
                // mo level up gihapon siya even if run pilion/defeated sad (need fixing)
                if (monster.isDefeated()) {
                    count++;
                }
                if(!playerCharacter.isDefeated()&&!playerCharacter.NoMana()&&monster.isDefeated()){
                   if (playerCharacter.canLevelUp()) {
                        playerCharacter.levelUp();
                   }
                }else if(playerCharacter.isDefeated()){
                    break;
                }
            } else {
                System.out.println("You chose to run away.");
                // kuan kuwang diri code kong mo run away ka kay another scene nasad or senario.
            }
        }
        if(!playerCharacter.isDefeated()){
            scoreRecorder.saveToFile(count,playerCharacter);
            System.out.println("Congratulations! You've completed the adventure.");
             System.out.println("--------------------SCORE BOARD---------------------");
             scoreRecorder.loadFromFile();
             System.out.println("----------------------------------------------");
        }else{
            scoreRecorder.saveToFile(count,playerCharacter);
             System.out.println("--------------------SCORES BOARD---------------------");
             scoreRecorder.loadFromFile();
             System.out.println("----------------------------------------------");
        }
        // if naa moy e add chat lang
         System.out.print("Do you Wish to play Again?(y/n)\nEnter Choice: ");
            Lchoice = scanner.next().charAt(0);
     }while(Lchoice!='n'&&Lchoice!='N');
    }
}

