/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionListener;
import javax.swing.JRadioButton;

/**
 *
 * @author Monkey-private
 */
public interface ISettingsUI {
    public void setActionBtnSaveLanguage(ActionListener listener);
    public void setActionBtnCancelLanguage(ActionListener listener);
    public void setActionBtnSaveFont(ActionListener listener);
    public void setActionBtnCancelFont(ActionListener listener);
    public void displayUI();
    public JRadioButton getBtnVietNamese();
    public JRadioButton getBtnEnglish();
    public void setTextVietnamese();
    public void setTextEnglish();
    public void hideUI();
}
