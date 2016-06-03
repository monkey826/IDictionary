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
public interface ISettingUIController {
    /**
     * this method will set SettingUI Interface select language at last worked
     * @param language:language at last worked 
     */
    public void setLastWorkLanguage(int language);
    /**
     * 
     * @param sizeSpell
     * @param sizeWordType
     * @param sizeWordMean
     * @param sizePhrase 
     */
    public void setLastWordSize(int sizeSpell,int sizeWordType,int sizeWordMean,int sizePhrase);
    /**
     * 
     * @param colorSpell
     * @param colorWordType
     * @param colorWordMean
     * @param colorPhrase 
     */
    public void setLastWordColor(Color colorSpell,Color colorWordType,Color colorWordMean,Color colorPhrase);
    /**
     * this method will display SettingUI Interface
     */
    public void displayUI();
    /**
     * setting an action listener for button Save in tab set Language in SettingUI interface
     */
    public void setActionBtnSaveLanguage();
    /**
     * setting an action listener for button Cancel in tab set Language in SettingUI interface
     */
    public void setActionBtnCancelLanguage();
    /**
     * setting an action listener for button Cancel in tab set Font in SettingUI interface
     */
    public void setActionCancelFont();
    /**
     * setting an action listener for button Save in tab set Font in SettingUI interface
     */
    public void setActionSaveFont();
    /**
     * setting an action listener for button Color Spell in SettingUI interface
     */
    public void setActionBtnColorSpell();
    /**
     * setting an action listener for button Color Type in SettingUI interface
     */
    public void setActionBtnColorType();
    /**
     * setting an action listener for button Color Mean in SettingUI interface
     */
    public void setActionBtnColorMean();
    /**
     * setting an action listener for button Color Phrase in SettingUI interface
     */
    public void setActionBtnColorPhrase();
    /**
     * setting an action listener for button Default in SettingUI interface
     */
     public void setBtnDefaultAction();
    /**
     * this method will set text of all component in this interface in English
     */
    public void setTextEnglish();
    /**
     * this method will set text of all component in this interface in VietNamese
     */
    public void setTextVietNam();
}
