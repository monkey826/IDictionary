/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Locale;
import javax.speech.Central;
import javax.speech.synthesis.Synthesizer;
import javax.speech.synthesis.SynthesizerModeDesc;
import javax.speech.synthesis.Voice;
import static javax.speech.synthesis.Voice.AGE_MIDDLE_ADULT;
import static javax.speech.synthesis.Voice.AGE_YOUNGER_ADULT;
import static javax.speech.synthesis.Voice.GENDER_FEMALE;
import static javax.speech.synthesis.Voice.GENDER_MALE;

/**
 *
 * @author HOANG_HUYNH
 */
public class SoundManage implements ISoundManage{
    public void doSpeak(String speaktext, String voicename) {
        // speaktext=speak;
        String voiceName = voicename;
        try {
            // Create a synthesizer for English
            SynthesizerModeDesc desc = new SynthesizerModeDesc(null, "general", Locale.US, null, null);
            Synthesizer synthesizer = Central.createSynthesizer(desc);
            // Get it ready to speak
            synthesizer.allocate();
            synthesizer.resume();
            // Speak
            desc = (SynthesizerModeDesc) synthesizer.getEngineModeDesc();
            
            Voice[] voices = desc.getVoices();
            synthesizer.getSynthesizerProperties().setVoice(voices[1]);
            synthesizer.speakPlainText(speaktext, null);
            // Wait till speaking is done
            synthesizer.waitEngineState(Synthesizer.QUEUE_EMPTY);
            // Clean up
            //synthesizer.deallocate();
        } catch (Exception e) {
            String message = " missing speech.properties in " + System.getProperty("user.home") + "\n";
        }
    }
}
