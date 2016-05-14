/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyListener;
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
<<<<<<< HEAD
    public void setListMouseAction(MouseAdapter listener);
    public void setListKeyAction(KeyAdapter listener);
    public void setListResultMouseAction(MouseAdapter listener);
    public void setListResultKeyAction(KeyAdapter listener);
    public void setTfSearchKeyListener(java.awt.event.KeyListener evt);
=======
    public void setListIndexValueChanged(javax.swing.event.ListSelectionListener listener);

    public void setTfSearchKeyListener(java.awt.event.KeyListener listener);
>>>>>>> origin/master

    public void setBtnSettingsActionListener(java.awt.event.ActionListener listener);                                           

    public void setBtnPrintActionListener(java.awt.event.ActionListener listener);
    public void setBtnAboutActionListener(java.awt.event.ActionListener listener);

    public void setBtnTranslateSentenceActionListener(java.awt.event.ActionListener listener);

<<<<<<< HEAD
    public void setBtnVEActionListener(java.awt.event.ActionListener evt);

    public void setBtnEVActionListener(java.awt.event.ActionListener evt);
    public void setBtnCopyActionListener(java.awt.event.ActionListener evt);
    
    public void setBtnHelpContentsActionListener(java.awt.event.ActionListener evt);
=======

    public void setBtnVEActionListener(java.awt.event.ActionListener listener);

    public void setBtnEVActionListener(java.awt.event.ActionListener listener);

    


    public void setBtnHelpContentsActionListener(java.awt.event.ActionListener listener);
>>>>>>> origin/master
    public void setStateEV();
    public void setStateVE();
    public void setBtnSoundActionListener(ActionListener listener);
    public void setBtnListenActionListener(ActionListener listener);
    public void setTaMeaningAction(MouseAdapter listener);
    public JList getListIndex();
    public JTextPane getTaMeaning();
    public JTextField getTfSearch();
    public JLabel getLabelWord();
    public JList getListRerult();
    public void setTextEng();
    public void setTextViet();
    public void updateUI();
}
