/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Action;
import javax.swing.JColorChooser;
import model.IManageStatus;
import model.IStatus;
import model.ManageStatus;
import model.Status;
import view.IMainUI;
import view.ISettingsUI;
import view.MainUI;
import view.SettingsUI;

/**
 *
 * @author Monkey-private
 */
public class SettingsUIController implements ISettingUIController{
    private final ISettingsUI settingsUI;
    private MainUIController mainUIController;
    private int stateLanguagePre;
    private Color[] stateColorPre;
    public SettingsUIController(MainUIController mainUIController){
        this.mainUIController=mainUIController;
        settingsUI = new SettingsUI();
        if(settingsUI.getBtnVietNamese().isSelected()) stateLanguagePre=2;
        else stateLanguagePre=1;
        setActionBtnCancelLanguage();
        setActionBtnSaveLanguage();
        setActionCancelFont();
        setActionSaveFont();
        setActionBtnColorSpell();
        setActionBtnColorType();
        setActionBtnColorMean();
        setActionBtnColorPhrase();
        setBtnDefaultAction();
        
    }
    public void setLastWorkLanguage(int language){
        settingsUI.setLastWorkLanguage(language);
    }
    public void setLastWordSize(int sizeSpell,int sizeWordType,int sizeWordMean,int sizePhrase){
        settingsUI.setLastWordSize(sizeSpell, sizeWordType, sizeWordMean, sizePhrase);
    }
    public void setLastWordColor(Color colorSpell,Color colorWordType,Color colorWordMean,Color colorPhrase){
        settingsUI.setLastWordColor(colorSpell, colorWordType, colorWordMean, colorPhrase);
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
                    IManageStatus m=mainUIController.getManageStatus();
                    m.setLanguageStatus(2);
                    m.writeStatus();
                }
                else{
                    mainUIController.setTextEnglish();
                    stateLanguagePre=1;
                    IManageStatus m=mainUIController.getManageStatus();
                    
                    m.setLanguageStatus(1);
                    m.writeStatus();
                }
            }
        });
    }
    public void setActionBtnCancelLanguage(){
        settingsUI.setActionBtnCancelLanguage(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                settingsUI.hideUI();
            }
        });
    }
    public void setActionSaveFont(){
        settingsUI.setActionBtnSaveFont(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                IManageStatus m=mainUIController.getManageStatus();
                m.setSizeStatus(settingsUI.getSizeSpell(), settingsUI.getSizeType(), settingsUI.getSizeMean(), settingsUI.getSizePhrase());
                m.setColorStatus(settingsUI.getColorSpell(), settingsUI.getColorType(), settingsUI.getColorMean(), settingsUI.getColorPhrase());
                mainUIController.getTextPaneController().setColor(new Color(Integer.parseInt(settingsUI.getColorSpell())), new Color(Integer.parseInt(settingsUI.getColorType())), new Color(Integer.parseInt(settingsUI.getColorMean())), new Color(Integer.parseInt(settingsUI.getColorPhrase())));
                mainUIController.getTextPaneController().setSize(settingsUI.getSizeSpell(), settingsUI.getSizeType(), settingsUI.getSizeMean(), settingsUI.getSizePhrase());
                m.writeStatus();
            }
        });
    }
    public void setActionCancelFont(){
        settingsUI.setActionBtnCancelFont(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                settingsUI.hideUI();
            }
        });
    }
    public void setBtnDefaultAction(){
        settingsUI.setBtnDefaultAction(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                settingsUI.setDefaultColor();
                settingsUI.setDefaultSize();
                IManageStatus m=mainUIController.getManageStatus();
                m.setSizeStatus(settingsUI.getSizeSpell(), settingsUI.getSizeType(), settingsUI.getSizeMean(), settingsUI.getSizePhrase());
                m.setColorStatus(settingsUI.getColorSpell(), settingsUI.getColorType(), settingsUI.getColorMean(), settingsUI.getColorPhrase());
                mainUIController.getTextPaneController().setColor(new Color(Integer.parseInt(settingsUI.getColorSpell())), new Color(Integer.parseInt(settingsUI.getColorType())), new Color(Integer.parseInt(settingsUI.getColorMean())), new Color(Integer.parseInt(settingsUI.getColorPhrase())));
                mainUIController.getTextPaneController().setSize(settingsUI.getSizeSpell(), settingsUI.getSizeType(), settingsUI.getSizeMean(), settingsUI.getSizePhrase());
                m.writeStatus();
            }
        });
    }
    public void setTextEnglish(){
        settingsUI.setTextEnglish();
        
    }
    public void setTextVietNam(){
        settingsUI.setTextVietnamese();
    }
    public void setActionBtnColorSpell(){
        settingsUI.setActionBtnColorSpell(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                Color background = JColorChooser.showDialog(null, "JColorChooser Sample", null);
                settingsUI.setBackGroundBtnColorSpell(background);
            }
        });
    }
    public void setActionBtnColorType(){
        settingsUI.setActionBtnColorType(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Color background = JColorChooser.showDialog(null, "JColorChooser Sample", null);
                settingsUI.setBackGroundBtnColorType(background);
            }
        });
    }
    public void setActionBtnColorMean(){
        settingsUI.setActionBtnColorMean(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Color background = JColorChooser.showDialog(null, "JColorChooser Sample", null);
                settingsUI.setBackGroundBtnColorMean(background);
            }
        });
    }
    public void setActionBtnColorPhrase(){
        settingsUI.setActionBtnColorPhrase(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Color background = JColorChooser.showDialog(null, "JColorChooser Sample", null);
                settingsUI.setBackGroundBtnColorPhrase(background);
            }
        });
    }
    
    
}
