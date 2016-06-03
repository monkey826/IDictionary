/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import view.IQuickViewUI;
import view.QuickViewUI;

/**
 *
 * @author HOANG_HUYNH
 */
public class QuickViewUIController implements IQuickViewUIController{
    private IQuickViewUI quickViewUI;
    public QuickViewUIController(){
        quickViewUI=new QuickViewUI();
    }
    public void displayQuickView(String word,String mean){
        quickViewUI.display();
        quickViewUI.setLbWordText(word);
        quickViewUI.setTaMeaningText(mean);
    }
    public void setTextEnglish(){
        quickViewUI.setTextEnglish();
        
    }
    public void setTextVietNam(){
        quickViewUI.setTextVietnamese();
    }
}
