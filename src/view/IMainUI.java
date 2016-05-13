/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;

/**
 *
 * @author Monkey
 */
public interface IMainUI {
    public void setListIndexValueChanged(javax.swing.event.ListSelectionListener listener);

    public void setTfSearchKeyListener(java.awt.event.KeyListener listener);

    public void setBtnSettingsActionListener(java.awt.event.ActionListener listener);                                           

    public void setBtnPrintActionListener(java.awt.event.ActionListener listener);
    public void setBtnAboutActionListener(java.awt.event.ActionListener listener);

    public void setBtnTranslateSentenceActionListener(java.awt.event.ActionListener listener);


    public void setBtnVEActionListener(java.awt.event.ActionListener listener);

    public void setBtnEVActionListener(java.awt.event.ActionListener listener);

    


    public void setBtnHelpContentsActionListener(java.awt.event.ActionListener listener);
    public void setStateEV();
    public void setStateVE();
    public void setBtnSoundActionListener(ActionListener listener);
    public void setBtnListenActionListener(ActionListener listener);
    public void setTaMeaningAction(MouseAdapter listener);
    public JList getListIndex();
    public JTextPane getTaMeaning();
    public JTextField getTfSearch();
    public JLabel getLabelWord();
    public void setTextEng();
    public void setTextViet();
    public void updateUI();
    public void displayUI();
}
