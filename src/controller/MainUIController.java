/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import javax.swing.DefaultListModel;
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
    public MainUIController(){
        
        dictData = new Dictionary();
        mainUI = new MainUI();
        
        setListWord();
        mainUI.setVisibleUI(true);
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
    }
    public void setListWord(){
        int i = 0;
        for (Iterator<String> it = dictData.getListWord().iterator(); it.hasNext(); i++) {
            model.add(i, it.next());
        }
        mainUI.getListIndex().setModel(model);
    }
}
