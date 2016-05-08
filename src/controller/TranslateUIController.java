/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.ITranslateOnline;
import model.TranslateOnline;
import view.ITranslateUI;
import view.TranslateUI;

/**
 *
 * @author Monkey-private
 */
public class TranslateUIController {

    private final ITranslateUI translateUI;
    private ITranslateOnline translateOnline;

    public TranslateUIController() {
        translateUI = new TranslateUI(); // New object UI Translate
        translateOnline = new TranslateOnline(); // New Model data Translate online provided by Bing Translator.
        translateUI.setRbtnEVActionListener(new ActionListener() { // Set action listener for Radio Button English-Vietnamese
            @Override
            public void actionPerformed(ActionEvent e) {
                translateUI.getTaResults().setText("");
                translateUI.getTaSource().setText("");
            }
        });
        translateUI.setRbtnVEActionListener(new ActionListener() { // // Set action listener for Radio Button VietNamese-English
            @Override
            public void actionPerformed(ActionEvent e) {
                translateUI.getTaResults().setText("");
                translateUI.getTaSource().setText("");
            }
        });
        translateUI.setBtnTranslateActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String key = translateUI.getTaSource().getText(); // Get text
                if (key.equals("")) {
                    JOptionPane.showMessageDialog(null, "No sentences input. Please put it on box! ");
                } else { // If text not equals null 
                    String value = "";
                    if (translateUI.getRbtnEV().isSelected()) { // IF English-Vietnamese 
                        value = translateOnline.translateEV(key); // Translate EV
                    } else if (translateUI.getRbtnVE().isSelected()) { // If Vietnamese - English 
                        value = translateOnline.translateVE(key); // Translate VE;
                    }
                    translateUI.getTaResults().setText(value); // Return results
                }

            }
        });
    }
}
