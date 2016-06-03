/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.swing.ListModel;
import model.IDictionary;
import model.IManageStatus;

/**
 *
 * @author HOANG_HUYNH
 */
public interface IMainUIController {
    /**
     * Load all status of last session dictionary include : word, color, type of dict ... <br>
     * And save it into XML file.
     */
    public void loadLastSession();
    /**
     * Set Button About action Listener <br>
     * Show a new window, some information from us.
     */
    public void setAboutAction();
    /**
     * Do action with Button Translate <br>
     * Open a new window, for translating online function
     */
    public void setBtnTranslateAction();
    /**
     * Do action with Button Setting <br>
     * Open a new window, for setting dictionary
     */
    public void setBtnSettingAction();
    /**
     * Do action with JList listResult <br>
     * Event: Click and Enter.
     */
    public void setListHistoryAction();
    /**
     * Do action with Button Viet-Eng <br>
     * Change dictionary : translate Viet to English
     */
    public void setBtnVEAction();
    /**
     * Do action with Button Eng-Vie <br>
     * Change dictionary : translate English to Viet
     */
    public void setBtnEVAction();
    /**
     * Do button sounds action <br>
     * Speak this word was chosen by user from listWord. or Enter JTextField Search
     */
    public void setActionSounds();
    /**
     * Do action with Button Listen <br>
     * Open a new Window for listening a quotation.
     */
    public void setBtnListenAction();
    /**
     * Do action with Button Help <br>
     * Show a new window, some information can help you
     */
    public void setBtnHelpAction();
    /**
     * Do action with TextPaneMeaning  <br>
     * Include : Mouse Click  to Quick View Function.
     */
    public void setTpMeaningAction();
    /**
     * Set All title in dictionary is English
     */
    public void setTextEnglish();
    /**
     * Set All title in dictionary is Vietnamese
     */
    public void setTextVietNam();
    /**
     * Set List Model for List Word.
     * @param model: 
     */
    public void setListModel(ListModel model);
    /**
     * Get ManageStatus.
     * @return 
     */
    public IManageStatus getManageStatus();
    /**
     * Get Text Pane controller.
     * @return 
     */
    public TextPaneController getTextPaneController();
    /**
     * Copy file for speaking JAVA library
     */
    public void copyFile();
    /**
     * setting search position of a word in list word of dictionary
     * @param word:word need to search
     * @param dict:dictionary that user selected
     * @return: position of word 
     */
    public long searchWord(String word, IDictionary dict);
    /**
     * setting add a word that user has just view in to list history
     * @param item: word that user has just view
     */
    public void addItemToListHistory(String item);
    /**
     * setting action search a word
     */
    public void setActionSearch();
    /**
     * compare a word s1 with word s2 
     * @param s1: word s1
     * @param s2: word s2
     * @return true if word s1 as well as word s2. else return false 
     */
    public boolean checkWord(byte[] s1, byte[] s2);
    /**
     * get SoundManage Object from this class
     * @return:SoundManage Object
     */
    public ISoundManage getSoundManage();
}
