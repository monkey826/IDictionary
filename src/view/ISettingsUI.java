/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.JRadioButton;

/**
 *
 * @author Monkey-private
 */
public interface ISettingsUI {
    /**
     * set a action listener for button save in tab language
     * @param listener: an listener when user click this button 
     */
    public void setActionBtnSaveLanguage(ActionListener listener);
    /**
     * set a action listener for button cancel in tab language
     * @param listener: an listener when user click this button 
     */
    public void setActionBtnCancelLanguage(ActionListener listener);
    /**
     * set a action listener for button save in tab font
     * @param listener: an listener when user click this button 
     */
    public void setActionBtnSaveFont(ActionListener listener);
    /**
     * set a action listener for button cancel in tab font
     * @param listener: an listener when user click this button 
     */
    public void setActionBtnCancelFont(ActionListener listener);
    /**
     * display SettingUI Interface
     */
    public void displayUI();
    /**
     * get Radio Button VietNamese
     * @return :radio button
     */
    public JRadioButton getBtnVietNamese();
    /**
     * get Radio Button English
     * @return :radio button
     */
    public JRadioButton getBtnEnglish();
    /**
     * set text of all component in SettingUI Interface in VietNamese
     */
    public void setTextVietnamese();
     /**
     * set text of all component in SettingUI Interface in English
     */
    public void setTextEnglish();
    /**
     * hide SettingUI Interface
     */
    public void hideUI();
     /**
     * set a action listener for button color spell in tab font
     * @param listener: an listener when user click this button 
     */
    public void setActionBtnColorSpell(ActionListener listener);
    /**
     * set a action listener for button color type in tab font
     * @param listener: an listener when user click this button 
     */
    public void setActionBtnColorType(ActionListener listener);
    /**
     * set a action listener for button color mean in tab font
     * @param listener: an listener when user click this button 
     */
    public void setActionBtnColorMean(ActionListener listener);
    /**
     * set a action listener for button color phrase in tab font
     * @param listener: an listener when user click this button 
     */
    public void setActionBtnColorPhrase(ActionListener listener);
    /**
     * set color for button color spell in tab font
     * @param color :color
     */
    public void setBackGroundBtnColorSpell(Color color);
     /**
     * set color for button color type in tab font
     * @param color :color
     */
    public void setBackGroundBtnColorType(Color color);
     /**
     * set color for button color mean in tab font
     * @param color :color
     */
    public void setBackGroundBtnColorMean(Color color);
     /**
     * set color for button color phrase in tab font
     * @param color :color
     */
    public void setBackGroundBtnColorPhrase(Color color);
     /**
     * set a action listener for button default in tab font
     * @param listener: an listener when user click this button 
     */
    public void setBtnDefaultAction(ActionListener listener);
    /**
     * set last word language: if English radio button English will click, else button Vietnamese will click
     * @param language :language(1: English or 2:Vietnamese)
     */
    public void setLastWorkLanguage(int language);
    /**
     * set size of last working for now working
     * @param sizeSpell:size spell
     * @param sizeWordType:size type
     * @param sizeWordMean: size mean
     * @param sizePhrase: size phrase 
     */
    public void setLastWordSize(int sizeSpell,int sizeWordType,int sizeWordMean,int sizePhrase);
   /**
    * set color of last working for now working
    * @param colorSpell:color spell
    * @param colorWordType: color type
    * @param colorWordMean:color mean
    * @param colorPhrase :color phrase
    */
    public void setLastWordColor(Color colorSpell,Color colorWordType,Color colorWordMean,Color colorPhrase);
    /**
     * get size of spell
     * @return :size
     */
    public Integer getSizeSpell();
     /**
     * get size of type
     * @return :size
     */
    public Integer getSizeType();
     /**
     * get size of mean
     * @return :size
     */
    public Integer getSizeMean();
     /**
     * get size of phrase
     * @return :size
     */
    public Integer getSizePhrase();
    /**
     * get color of spell
     * @return : color
     */
    public String getColorSpell();
    /**
     * get color of type
     * @return : color
     */
    public String getColorType();
    /**
     * get color of mean
     * @return : color
     */
    public String getColorMean();
    /**
     * get color of phrase
     * @return : color
     */
    public String getColorPhrase();
    /**
     * set size default
     */
    public void setDefaultSize();
    /**
     * set color default
     */
    public void setDefaultColor();
}
