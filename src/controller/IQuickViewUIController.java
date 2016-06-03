/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author HOANG_HUYNH
 */
public interface IQuickViewUIController {
    /**
     * this method will display Quick View Interface for word that user has seen
     * @param word: word that user has seen
     * @param mean: mean of that word 
     */
    public void displayQuickView(String word,String mean);
    /**
     * this method will set text of all components in Quick View Interface in English
     */
    public void setTextEnglish();
    /**
     * this method will set text of all components in Quick View Interface in VietNamese
     */
    public void setTextVietNam();
}
