/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import view.ISettingsUI;
import view.SettingsUI;

/**
 *
 * @author Monkey-private
 */
public class SettingsUIController {
    private final ISettingsUI settingsUI;
    public SettingsUIController(){
        settingsUI = new SettingsUI();
    }
    
}
