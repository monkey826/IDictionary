/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionListener;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

/**
 *
 * @author Monkey-private
 */
public interface ITranslateUI {

    public void setBtnTranslateActionListener(ActionListener listener);
    
    public void setRbtnEVActionListener(ActionListener listener);
       
    public void setRbtnVEActionListener(ActionListener listener);
    
    public JTextArea getTaSource();

    public JTextArea getTaResults();

    public JRadioButton getRbtnEV();

    public JRadioButton getRbtnVE();
    public void setTextVietnamese();
    public void setTextEnglish();
    public void displayUI();
    public void hideUI();
}
