/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionListener;

/**
 *
 * @author HOANG_HUYNH
 */
public interface IQuickViewUI {
    /**
     * display QuickViewUI Interface
     */
    public void display();
    /**
     * set word for label lbWordText
     * @param word:word 
     */
    public void setLbWordText(String word);
    /**
     * set text for text pane taMeaningText
     * @param meaning :text mean
     */
    public void setTaMeaningText(String meaning);
    /**
     * set text of all components in this interface in VietNamese
     */
    public void setTextVietnamese();
    /**
     * set text of all components in this interface in English
     */
    public void setTextEnglish();
}
