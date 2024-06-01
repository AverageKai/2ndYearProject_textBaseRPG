/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.textedbasedrpg;

/**
 *
 * @author Miklos Bolarde
 */
public interface ScoreRecorder {
    void saveToFile(int count,Character character);
    void loadFromFile();
}
