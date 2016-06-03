/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.memetix.mst.language.Language;
import com.memetix.mst.translate.Translate;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
//import model.ITranslateOnline;
//import model.TranslateOnline;
import view.ITranslateUI;
import view.TranslateUI;

/**
 *
 * @author Monkey-private
 */
public class TranslateUIController implements ITranslateUIController{

    private final ITranslateUI translateUI;
//    private ITranslateOnline translateOnline;
    private final String CLIENT_ID = "Dictionary1";
    private final String CLIENT_SECRET_KEY ="maUQXnGo1OiClwMB391jMku4Yynnk3KqImUZbH/fL5M=";
    public TranslateUIController() {
        translateUI = new TranslateUI(); // New object UI Translate
        Translate.setClientId(CLIENT_ID);
        Translate.setClientSecret(CLIENT_SECRET_KEY);
//        translateOnline = new TranslateOnline(); // New Model data Translate online provided by Bing Translator.
        setRbtnEVAction();
        setRbtnVEAction();
        setBtnTranslateClickAction();
    }
    public void setRbtnEVAction(){
        translateUI.setRbtnEVActionListener(new ActionListener() { // Set action listener for Radio Button English-Vietnamese
            @Override
            public void actionPerformed(ActionEvent e) {
                translateUI.getTaResults().setText("");
                translateUI.getTaSource().setText("");
            }
        });
    }
    public void setRbtnVEAction(){
        translateUI.setRbtnVEActionListener(new ActionListener() { // // Set action listener for Radio Button VietNamese-English
            @Override
            public void actionPerformed(ActionEvent e) {
                translateUI.getTaResults().setText("");
                translateUI.getTaSource().setText("");
            }
        });
    }
    public void setBtnTranslateClickAction(){
        translateUI.setBtnTranslateActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String key = translateUI.getTaSource().getText(); // Get text
                if (key.equals("")) {
                    JOptionPane.showMessageDialog(null, "No sentences input. Please put it on box! ");
                } else { // If text not equals null 
                    String value = "";
                    if (translateUI.getRbtnEV().isSelected()) { // IF English-Vietnamese 
                        value = translateEV(key); // Translate EV
                    } else if (translateUI.getRbtnVE().isSelected()) { // If Vietnamese - English 
                        value = translateVE(key); // Translate VE;
                    }
                    translateUI.getTaResults().setText(value); // Return results
                }

            }
        });
    }
    public void setTextEnglish(){
        translateUI.setTextEnglish();
        
    }
    public void setTextVietNam(){
        translateUI.setTextVietnamese();
    }
    public void displayUI(){
        translateUI.displayUI();
    }
    public void hideUI(){
        translateUI.hideUI();
    }
    public String translateVE(String key) {
        String value="";
        try {
            value = Translate.execute(key, Language.VIETNAMESE, Language.ENGLISH);// Execute translating from vietnamese to english
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return value;
    }
    /**
     * (non-Javadoc)
     *
     * @see model.ITranslateOnline#translateEV(java.lang.String) ;
     */

    public String translateEV(String key) {
        String value="";
        try {
            value = Translate.execute(key, Language.ENGLISH, Language.VIETNAMESE); // Execute translating from english to vietnamese
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return value;
    }
}
