/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.IMainUI;
import view.ISettingsUI;
import view.MainUI;
import view.SettingsUI;

/**
 *
 * @author Monkey-private
 */
public class SettingsUIController {
    private final ISettingsUI settingsUI;
    private MainUIController mainUIController;
    private int stateLanguagePre;
    public SettingsUIController(MainUIController mainUIController){
        this.mainUIController=mainUIController;
        settingsUI = new SettingsUI();
        if(settingsUI.getBtnVietNamese().isSelected()) stateLanguagePre=2;
        else stateLanguagePre=1;
        setActionBtnCancelLanguage();
        setActionBtnSaveLanguage();
        setActionCancelFont();
        setActionSaveFont();
    }
    public void hideUI(){
        settingsUI.hideUI();
    }
    public void displayUI(){
        settingsUI.displayUI();
    }
    public void setActionBtnSaveLanguage(){
        settingsUI.setActionBtnSaveLanguage(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(settingsUI.getBtnVietNamese().isSelected()){
                    mainUIController.setTextVietNam();
                    stateLanguagePre=2;
                    
                }
                else{
                    mainUIController.setTextEnglish();
                    stateLanguagePre=1;
                }
            }
        });
    }
    public void setActionBtnCancelLanguage(){
        settingsUI.setActionBtnCancelLanguage(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(stateLanguagePre==2) settingsUI.getBtnVietNamese().doClick();
                else settingsUI.getBtnEnglish().doClick();
                //settingsUI.hideUI();
            }
        });
    }
    public void setActionSaveFont(){
        settingsUI.setActionBtnSaveFont(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
    public void setActionCancelFont(){
        settingsUI.setActionBtnCancelFont(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
    public void setTextEnglish(){
        settingsUI.setTextEnglish();
        
    }
    public void setTextVietNam(){
        settingsUI.setTextVietnamese();
    }
    
}
