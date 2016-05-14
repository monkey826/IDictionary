/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.*;

/**
 *
 * @author HOANG_HUYNH
 */
public class HistoryListController {
    private String[] historyWord;
    private String[] historyMean; 
    private int count;
    public HistoryListController(){
        this.count=0;
    }
    public void setHistory(String word,String mean){
        if(count>=20){
            count=0;
        }
        historyWord[count] = word;
        historyMean[count] = mean;
        count++;
    }
    
    public String getHistoryWord(int index){
        return historyWord[index];
    }
    public String getHistoryMean(int index){
        return historyMean[index];
    }
}
