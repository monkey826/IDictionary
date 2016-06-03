/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JTextPane;

/**
 *
 * @author Monkey
 */
public interface IMainUI {
    /**
     * Set Mouse ActionListener in List index word
     * @param listener 
     */
    public void setListMouseAction(MouseAdapter listener);
    /**
     * Set Enter Action Listener when typing at Text field search
     * @param listener 
     */
    public void setListKeyAction(KeyAdapter listener);
    /**
     * Set Mouse Action Listener in List history word 
     * @param listener 
     */
    public void setListHistoryMouseAction(MouseAdapter listener);
    /**
     * Set Enter Action Listener in List history word
     * @param listener 
     */
    public void setListHistoryKeyAction(KeyAdapter listener);
    /**
     * Set Text Field Search KeyListener 
     * @param listener 
     */
    public void setTfSearchKeyListener(java.awt.event.KeyListener listener);
    /**
     * Set Button Settings Action Listener <br>
     * Open Settings window
     * @param listener 
     */
    public void setBtnSettingsActionListener(java.awt.event.ActionListener listener);                                           
    /**
     * Set Button About Action Listener <br>
     * Open a new window to display information about us.
     * @param listener 
     */
    public void setBtnAboutActionListener(java.awt.event.ActionListener listener);
    /**
     * Set Button Translate Sentence Action Listener <br>
     * Open a new window for translating online function
     * @param listener 
     */
    public void setBtnTranslateSentenceActionListener(java.awt.event.ActionListener listener);
    /**
     * Set Button Viet-English Action Listener <br>
     * Change type of dictionary : Translate from Vietnamese to English
     * @param listener 
     */
    public void setBtnVEActionListener(java.awt.event.ActionListener listener);
    /**
     * Set Button English-Vietnamese Action Listener <br>
     * Change type of dictionary : Translate from English to Vietnamese
     * @param listener
     */
    public void setBtnEVActionListener(java.awt.event.ActionListener listener);
    /**
     * Set button Help Contents Action Listener
     * Show a window for helping user use dictionary
     * @param listener 
     */
    public void setBtnHelpContentsActionListener(java.awt.event.ActionListener listener);
    /**
     * Set Label Word Text title
     * @param text 
     */
    public void setLbWordText(String text);
    /**
     * If this dictionary is English , Button Sound Visible (for listening this word be chosen) is True.
     */
    public void setStateEV();
    /**
     * If this dictionary is English , Button Sound Visible (for listening this word be chosen) is False
     */
    public void setStateVE();
    /**
     * Set button Sound Action Listener  <br>
     * for listening this word be chosen 
     * @param listener 
     */
    public void setBtnSoundActionListener(ActionListener listener);
    /**
     * Set Button Listen Action Listener <br>
     * For opening a window and listening some sentences by Java Library Voice
     * @param listener 
     */
    public void setBtnListenActionListener(ActionListener listener);
    /**
     * Set Text Panel Meaning Mouse Listener <br>
     * When user selected a word, show a quick meaning window.
     * @param listener 
     */
    public void setTpMeaningAction(MouseAdapter listener);
    /**
     * Get JList word for MainUIController. <br>
     * @return JList listIndex 
     */
    public JList getListIndex();
    /**
     * Get Text Pane Meaning for MainUIController  <br>
     * @return JTextPane tpMeaning
     */
    public JTextPane getTpMeaning();
    /**
     * Get Text Field Search for MainUIController <br>
     * Get Text user typed.
     * @return JTextField tfSearch
     */
    public JTextField getTfSearch();
    /**
     * Get this word was chosen and display it into JLabel lbWord.
     * 
     * @return JLabel lbWord
     */
    public JLabel getLabelWord();
    /**
     * Get List Result for controller
     * @return JList listResult.
     */
    public JList getListHistory();
    /**
     * Set all title is English
     */
    public void setTextEng();
     /**
     * Set all title is Vietnamese
     */
    public void setTextViet();
    /**
     * Re-update graphics
     */
    public void updateUI();
    /**
     * Set Visible UI is true.
     */
    public void displayUI();
}
