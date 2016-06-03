/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

/**
 *
 * @author Monkey-private
 */
public interface ITranslateUI {
    /**
     * Set ActionListener for Button Translate.
     * @param listener
     */
    public void setBtnTranslateActionListener(ActionListener listener);
    /**
     * Set ActionListener for Radio Button Eng-Vie
     * @param listener 
     */
    public void setRbtnEVActionListener(ActionListener listener);
    /**
     * Set ActionListener for Radio Button Vie-Eng
     * @param listener 
     */    
    public void setRbtnVEActionListener(ActionListener listener);
    /**
     * Get Text Area Source from user typed
     * @return JTextArea taSource
     */
    public JTextArea getTaSource();
     /**
     * Get Text Area Results for Bing Translator return results.
     * @return JTextArea taResults
     */
    public JTextArea getTaResults();
    /**
     * Get RadioButton Eng-Vie
     * @return rbtnEV
     */
    public JRadioButton getRbtnEV();
    /**
     * Get RadioButton Vie-Eng
     * @return rbtnVE
     */
    public JRadioButton getRbtnVE();
    /**
     * Set all text title is Vietnamese
     */
    public void setTextVietnamese();
    /**
     * Set all text title is English
     */
    public void setTextEnglish();
    /**
     * Set visible TranslateUI is true
     */
    public void displayUI();
    /**
     * Set visible TranslateUI is false
     */
    public void hideUI();
}
