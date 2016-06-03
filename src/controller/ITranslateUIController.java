/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author monkey
 */
public interface ITranslateUIController {
    /**
     * Do Radio Button Eng-Viet Action <br>
     * Choose translate from English to Vietnamese and reset TextArea source
     */
    public void setRbtnEVAction();
    /**
     * Do Radio Button Viet-Eng Action <br>
     * Choose translate from Vietnamese to English and reset TextArea Source
     */
    public void setRbtnVEAction();
    /**
     * Do button Translate Click Action <br>
     * Translate sentence online by Bing Translator.
     */
    public void setBtnTranslateClickAction();
    /**
     * Set all title in TranslateUI is English
     */
    public void setTextEnglish();
    /**
     * Set all title in TranslateUI is Vietnamese
     */
    public void setTextVietNam();
    /**
     * Set visible TranslateUI is true
     */
    public void displayUI();
    /**
     *  Set visible TranslateUI is false
     */
    public void hideUI();
    /**
     * Translate From Vietnamese to English sentence <br>
     * Function provided by Bing Translator
     * @param key
     * @return 
     */
    public String translateVE(String key) ;
    /**
     * Translate From English to Vietnamese sentence <br>
     * Function provided by Bing Translator
     * @param key
     * @return 
     */
    public String translateEV(String key);
}
