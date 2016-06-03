/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Color;

/**
 *
 * @author HOANG_HUYNH
 */
public interface ITextPaneController {
    /**
     * setting color for text in text pane
     * @param colorSpell:color for text spell
     * @param colorWordType:color for text word type
     * @param colorWordMean:color for text mean
     * @param colorPhrase :color for text word phrase
     */
    public void setColor(Color colorSpell,Color colorWordType,Color colorWordMean,Color colorPhrase);
    /**
     * set size for text in text pane
     * @param sizeSpell:size for text spell
     * @param sizeWordType:size for text word type
     * @param sizeWordMean:size for text mean
     * @param sizePhrase:size for text phrase 
     */
    public void setSize(int sizeSpell,int sizeWordType,int sizeWordMean,int sizePhrase);
    /**
     * setting style display for mean of word
     * @param mean: mean of word
     * @param word: word that user has searched
     * @return:String style of that mean  
     */
    public String setStyleMean(String mean, String word);
    /**
     * get position of character '+' in a line
     * @param line: line need to get position of character '+'
     * @return:position of character '+' 
     */
    public int getPostionCharacter(String line);
}
