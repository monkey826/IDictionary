/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Iterator;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import model.Dictionary;
import model.IDictionary;
import view.IMainUI;
import view.MainUI;

/**
 *
 * @author Monkey-private
 */
public final class MainUIController {

    private final IMainUI mainUI;
    private IDictionary dictData;
    private SettingsUIController settingsController;
    private TranslateUIController translateController;
    private DefaultListModel model = new DefaultListModel();

    public MainUIController() {

        dictData = new Dictionary();
        mainUI = new MainUI();

        setListWord();
        mainUI.setBtnSettingsActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settingsController = new SettingsUIController();
            }
        }
        );
        mainUI.setBtnTranslateSentenceActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                translateController = new TranslateUIController();
            }
        });
        mainUI.setTfSearchKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                /// nothing
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER){
                    String value = mainUI.getTfSearch().getText().toLowerCase().trim();
                    boolean isFind = false; // Check have results or not.
                    // Loops to find where this word on dictionary
                    for (int index = 0 ; index < dictData.getListWord().size(); index ++){
                        String it = dictData.getListWord().get(index).toLowerCase();
                        if (it.startsWith(value)){
                            isFind = true; // If find, break loops 
                            break;
                        }
                    }
                    if (isFind == false)
                        JOptionPane.showMessageDialog(null, "This word \"" + value + "\" "
                                + "doesn't existed in dictionary.","Search failed",JOptionPane.INFORMATION_MESSAGE);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                String value = mainUI.getTfSearch().getText().toLowerCase().trim();
                JList listWords = mainUI.getListIndex();
                int index;
                for ( index  = 0; index < dictData.getListWord().size(); index ++){
                    String it = dictData.getListWord().get(index).toLowerCase();
                    if (it.startsWith(value) || it.compareTo(value) > 0){
                        break;
                    }
                }
                listWords.setSelectedIndex(index);
                listWords.ensureIndexIsVisible(index);
                // Set word on top of list
                long size = listWords.getModel().getSize();
                long num;
                if (index + 1000 > size){
                    num = size - index - 1;
                } else {
                    num = 1000;
                }
                listWords.scrollRectToVisible(listWords.getCellBounds(index, (int) (index + num)));
            }
        });
        mainUI.setListIndexValueChanged(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int index = mainUI.getListIndex().getSelectedIndex();
                if (index != -1 ){
                    String value = dictData.getListWord().get(index);
                    String meaning = dictData.loadMeaning(value);
                    mainUI.getTaMeaning().setText(meaning);
                }
            }
        });
    }

    public void setListWord() {
        int i = 0;
        for (Iterator<String> it = dictData.getListWord().iterator(); it.hasNext(); i++) {
            model.add(i, it.next());
        }
        mainUI.getListIndex().setModel(model);
    }
}
