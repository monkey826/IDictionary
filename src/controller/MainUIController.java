/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.Locale;
import java.util.StringTokenizer;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import model.Dictionary;
import model.IDictionary;
import view.IMainUI;
import view.MainUI;
import javax.speech.*;
import java.util.*;
import javax.speech.synthesis.*;

/**
 *
 * @author Monkey-private
 */
public final class MainUIController {

    private final IMainUI mainUI;
    private IDictionary dictDataEV;
    private IDictionary dictDataVE;
    private SettingsUIController settingsController;
    private TranslateUIController translateController;
    private DefaultListModel modelEV = new DefaultListModel();
    private DefaultListModel modelVE = new DefaultListModel();
    private SoundParagraphController soundParagraphController;
    private QuickViewUIController quickViewUIController;
    private IDictionary currentDict;
    
    public final String pathIndexEV = System.getProperty("user.dir").concat("/data/anhviet109K.index");
    public final String pathMeaningEV = System.getProperty("user.dir").concat("/data/anhviet109K.dict");
    public final String pathIndexVE = System.getProperty("user.dir").concat("/data/vietanh.index");
    public final String pathMeaningVE = System.getProperty("user.dir").concat("/data/vietanh.dict");

    public MainUIController() {

        dictDataEV = new Dictionary(pathIndexEV,pathMeaningEV);
        dictDataVE=new Dictionary(pathIndexVE, pathMeaningVE);
        currentDict=dictDataEV;
        mainUI = new MainUI();
        loadListModelEV();
        loadListModelVE();
        setListModel(modelEV);
        copyFile();
        setSounds();
        soundParagraphController=new SoundParagraphController(this);
        quickViewUIController=new QuickViewUIController();
        setActionSearch();
        setBtnTranslateAction();
        setBtnSettingAction();
        setBtnListenAction();
        setTaMeaningAction();
        setBtnEVAction();
        setBtnVEAction();
    }
    public void setBtnTranslateAction(){
        mainUI.setBtnTranslateSentenceActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                translateController = new TranslateUIController();
            }
        });
    }
    public void setBtnSettingAction(){
        mainUI.setBtnSettingsActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settingsController = new SettingsUIController();
            }
        }
        );
    }
    public void setActionSearch(){
        mainUI.setTfSearchKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                /// nothing
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER){
                    String value = mainUI.getTfSearch().getText().toLowerCase().trim();
                    boolean isFind = false; // Check have results or not.
                    // Loops to find where this word on dictionary
                    for (int index = 0 ; index < currentDict.getListWord().size(); index ++){
                        String it = currentDict.getListWord().get(index).toLowerCase();
                        if (it.startsWith(value)){
                            isFind = true; // If find, break loops 
                            break;
                        }
                    }
                    if (isFind == false)
                        JOptionPane.showMessageDialog(null, "This word \"" + value + "\" "
                                + "doesn't existed in dictionary.","Search failed",JOptionPane.INFORMATION_MESSAGE);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                String value = mainUI.getTfSearch().getText().toLowerCase().trim();
                JList listWords = mainUI.getListIndex();
                int index;
                for ( index  = 0; index < currentDict.getListWord().size(); index ++){
                    String it = currentDict.getListWord().get(index).toLowerCase();
                    if (it.startsWith(value) || it.compareTo(value) > 0){ /// Cho nay sao ay'
                        System.out.println(value);
                        break;
                    }
                }
                listWords.setSelectedIndex(index);
                listWords.ensureIndexIsVisible(index);
                // Set word on top of list
                long size = listWords.getModel().getSize();
                long num;
                if (index + 1000 > size){
                    num = size - index - 1;
                } else {
                    num = 1000;
                }
                listWords.scrollRectToVisible(listWords.getCellBounds(index, (int) (index + num)));
            }
        });
        mainUI.setListIndexValueChanged(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int index = mainUI.getListIndex().getSelectedIndex();
                if (index != -1 ){
                    String value = currentDict.getListWord().get(index);
                    String meaning = currentDict.loadMeaning(value);
                    mainUI.getLabelWord().setText(value);
                    mainUI.getTaMeaning().setText(setStyleMean(meaning, value));
                }
            }
        });
    }
    public void setBtnVEAction(){
        mainUI.setBtnVEActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("1");
                currentDict=dictDataVE;
                setListModel(modelVE);
                System.out.println("3");
                mainUI.getListIndex().repaint();
            }
        });
    }
    public void setBtnEVAction(){
        mainUI.setBtnEVActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("1");
                currentDict=dictDataEV;
                setListModel(modelEV);
                System.out.println("4");
                mainUI.getListIndex().repaint();
            }
        });
    }
    public void setSounds(){
        mainUI.setBtnSoundActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String value="";
                int index = mainUI.getListIndex().getSelectedIndex();
                
                value = currentDict.getListWord().get(index);
                
                doSpeak(value, "kevin16");
            }
        });
    }
    
    public void loadListModelEV() {
        int i = 0;
        for (Iterator<String> it = dictDataEV.getListWord().iterator(); it.hasNext(); i++) {
            modelEV.add(i, it.next());
        }
    }
    public void setListModel(DefaultListModel model){
        mainUI.getListIndex().setModel(model);
    }
    public void loadListModelVE() {
        int i = 0;
        for (Iterator<String> it = dictDataVE.getListWord().iterator(); it.hasNext(); i++) {
            modelVE.add(i, it.next());
        }
       
    }
    public String setStyleMean(String mean,String word){
        String meanStyle="";
        int lenWord=word.length();
        meanStyle=mean.substring(lenWord+1);
        return meanStyle;
    }
    
    public void setBtnListenAction(){
        mainUI.setBtnListenActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                soundParagraphController.showUI();
            }
        });
    }
     public void doSpeak(String speaktext,String voicename)
    {
       // speaktext=speak;
        String voiceName =voicename;
        try
        {
            SynthesizerModeDesc desc = new SynthesizerModeDesc(null,"general",  Locale.US,null,null);
            Synthesizer synthesizer =  Central.createSynthesizer(desc);
            synthesizer.allocate();
            synthesizer.resume();
            desc = (SynthesizerModeDesc)  synthesizer.getEngineModeDesc();
            Voice[] voices = desc.getVoices();
            Voice voice = null;
           
            for (int i = 0; i < voices.length; i++)
            {
                if (voices[i].getName().equals(voiceName))
                {
                    voice = voices[i];
                    break;
                }
            }
            synthesizer.getSynthesizerProperties().setVoice(voice);
            //System.out.print("Speaking : "+speaktext);
            synthesizer.speakPlainText(speaktext, null);
            //synthesizer.waitEngineState(Synthesizer.QUEUE_EMPTY);
            //synthesizer.deallocate();
        }
        catch (Exception e)
        {
            String message = " missing speech.properties in " + System.getProperty("user.home") + "\n";
            System.out.println(""+e);
            System.out.println(message);
        }
    }
    public void copyFile(){
        InputStream is = null;
        OutputStream os = null;
        try {
            File aFile = new File("lib/freetts-1.2/speech.properties");
            File bFile = new File(System.getProperty("user.home")+"\\speech.properties");
            is = new FileInputStream(aFile);
            os = new FileOutputStream(bFile);
            byte[] buffer = new byte[1024];
            int length;
            // copy the file content in bytes
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
            is.close();
            os.close();
            
            System.out.println("Fileopied successful!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void setTaMeaningAction(){
        mainUI.setTaMeaningAction(new MouseAdapter() {
//            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount() == 2) { 
                        if(mainUI.getTaMeaning().getSelectedText()!=null){
                            String word=mainUI.getTaMeaning().getSelectedText();
                            String mean=setStyleMean(currentDict.loadMeaning(word), word);
                            quickViewUIController.displayQuickView(word,mean);
                        }
                    } 
            }
        });
    }
}
