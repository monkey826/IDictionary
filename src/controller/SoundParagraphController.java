/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Action;
import view.SoundParagraphUI;

/**
 *
 * @author HOANG_HUYNH
 */
public class SoundParagraphController implements ISoundParagraphController{
    private SoundParagraphUI soundParagraphUI;
    private MainUIController mainUIController;
    public SoundParagraphController(MainUIController mainUIController){
       soundParagraphUI= new SoundParagraphUI();
       this.mainUIController=mainUIController;
       setBtnSoundAction();
    }
    public void setBtnSoundAction(){
        soundParagraphUI.setBtnSoundAction(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String textNeedToHear=soundParagraphUI.getTextNeedToHear();
              if(textNeedToHear!=null) 
                mainUIController.getSoundManage().doSpeak(textNeedToHear, "kevin16");
            }
        });
    }
    public void showUI(){
        soundParagraphUI.setVisible(true);
    }
}
