/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author HOANG_HUYNH
 */
public interface ISoundManage {
    /**
     * this method will setting for speaking a text with a voice name
     * @param speaktext:text need to speak
     * @param voicename:voice name 
     */
    public void doSpeak(String speaktext, String voicename);
}
