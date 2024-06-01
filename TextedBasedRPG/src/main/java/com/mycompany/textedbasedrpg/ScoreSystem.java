/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.textedbasedrpg;
import java.io.*;
/**
 *
 * @author Miklos Bolarde
 */
public class ScoreSystem implements ScoreRecorder {
    private static final String FILE_PATH = "defeatedMonsters.txt";
    private int count1;
    public int getCount1() {
        return count1;
    }

    public void setCount1(int count1) {
        this.count1 = count1;
    }
    @Override
    public void saveToFile(int count,Character character){
    try (FileWriter writer = new FileWriter(FILE_PATH,true)) {
             if (count > 0) {
                writer.write(character.name+" Score : ");
                writer.write(Integer.toString(count));
                writer.write("\n");
            } else {
               writer.write(character.name+" Score : 0\n");
            }
         } catch (IOException e) {
             e.printStackTrace();
     }
}
    @Override
    public void loadFromFile(){
     try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
