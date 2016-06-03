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
public interface ISoundParaghraphUI {
    /**
     * setting a action listener for button sound in SoundParaghraphUI Interface
     * @param listen : a listener when user click on this button
     */
    public void setBtnSoundAction(ActionListener listen);
    /**
     * get text of text area field 
     * @return :text that user need to hear
     */
    public String getTextNeedToHear();
}
