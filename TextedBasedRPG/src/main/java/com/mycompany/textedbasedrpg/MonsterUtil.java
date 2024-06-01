/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.textedbasedrpg;

import java.util.Random;

/**
 *
 * @author Miklos Bolarde
 */
public class MonsterUtil {
//gamit ani kay like mao rani iyang stats jud dili ma change kay boss mn
    public static Monster createBoss() {
        return new Monster("Odin the All Father", 250, 30);
    }
     public static Monster[] generateMonsters(Random random) {
        Monster[] monsters = new Monster[8];//basically nag himo ko array of monste[] nya ma sud sa usa ka index kay katong naa sa ge initialize sa monsters
        
        //gamit nait kay like 0 1 2 3 4kay ma sud nga monster sa each index with diffrent health and attach tungod Random generator
        for (int i = 0; i < 4; i++) {
            int randomHealth = random.nextInt(50) + 30; // Health between 10 and 29
            int randomAttack = random.nextInt(20) + 5;    // Attack between 5 and 19
            monsters[i] = new Monster("Scourge of Asgard", randomHealth, randomAttack);
        }
        //basically the same rani pro mga mid level naa sa index 5 6
            
            int randomHealth = random.nextInt(100) + 50; // Health between 50 and 99
            int randomAttack = random.nextInt(20) + 15;  // Attack between 10 and 29
            monsters[4] = new Monster("Fire Giant", randomHealth, randomAttack);
            int randomHealth1 = random.nextInt(150) + 60; // Health between 60 and 139
            int randomAttack1 = random.nextInt(25) + 20;  // Attack between 20 and 24
            monsters[5] = new Monster("Heimdall the Diviner", randomHealth1, randomAttack1);
            int randomHealth2 = random.nextInt(150) + 60; // Health between 60 and 139
            int randomAttack2 = random.nextInt(25) + 20;  // Attack between 20 and 24
             monsters[6] = new Monster("Thor God of Thunder ", randomHealth2, randomAttack2);
        //so int total mn 5 ka low level 2 ka mid level nya boss so 8 tanan pero array man so 7
        monsters[7] = createBoss();

        return monsters;
    }
}
// so basically sud sa array nga mosters[] kay index 0 1 2 3 4 kay low level nya 5 6 kay mid level nya 7 kay boss