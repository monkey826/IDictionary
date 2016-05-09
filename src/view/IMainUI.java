/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Monkey
 */
public interface IMainUI {
    public void setListIndexValueChanged(javax.swing.event.ListSelectionListener evt);

    public void setTfSearchKeyListener(java.awt.event.KeyListener evt);

    public void setBtnSettingsActionListener(java.awt.event.ActionListener evt);                                           

    public void setBtnPrintActionListener(java.awt.event.ActionListener evt);
    public void setBtnAboutActionListener(java.awt.event.ActionListener evt);

    public void setBtnTranslateSentenceActionListener(java.awt.event.ActionListener evt);


    public void setBtnPrevEntryActionListener(java.awt.event.ActionListener evt);

    public void setBtnNextEntryActionListener(java.awt.event.ActionListener evt);

    public void setBtnListenActionListener(java.awt.event.ActionListener evt);

    public void setBtnCopyActionListener(java.awt.event.ActionListener evt);

    public void setBtnHelpContentsActionListener(java.awt.event.ActionListener evt);
    public JList getListIndex();
    public JTextArea getTaMeaning();
    public JTextField getTfSearch();
}
