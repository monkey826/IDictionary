/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
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
import java.io.UnsupportedEncodingException;
import static java.nio.charset.StandardCharsets.ISO_8859_1;
import static java.nio.charset.StandardCharsets.UTF_8;
import java.util.Iterator;
import java.util.Locale;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import model.Dictionary;
import model.IDictionary;
import view.IMainUI;
import view.MainUI;
import javax.speech.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.speech.synthesis.*;
import javax.swing.Icon;
import javax.swing.ImageIcon;

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
    private DefaultListModel modelEV;
    private DefaultListModel modelVE;
    private DefaultListModel modelHistory;
    private SoundParagraphController soundParagraphController;
    private QuickViewUIController quickViewUIController;
    private IDictionary currentDict;
    private TextPaneController textPaneController;
    private HistoryListController historyListController;

    public MainUIController() {
        //load data
        copyFile();
        dictDataEV = new Dictionary(1);
        modelEV = new DefaultListModel();
        loadListModelEV();

        dictDataVE = new Dictionary(2);
        modelVE = new DefaultListModel();
        loadListModelVE();

        modelHistory = new DefaultListModel();

        mainUI = new MainUI();
        mainUI.getListRerult().setModel(modelHistory);
        soundParagraphController = new SoundParagraphController(this);
        quickViewUIController = new QuickViewUIController();
        textPaneController = new TextPaneController();
        settingsController = new SettingsUIController(this);
        translateController = new TranslateUIController();
        historyListController = new HistoryListController();
        //set First display:
        currentDict = dictDataEV;
        setListModel(modelEV);

        //set Action:
        setSounds();
        setActionSearch();
        setBtnTranslateAction();
        setBtnSettingAction();
        setBtnListenAction();
        setTaMeaningAction();
        setBtnEVAction();
        setBtnVEAction();
        setListResultAction();
        setAboutAction();
    }

    public void setAboutAction() {
        mainUI.setBtnAboutActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Icon icon = new ImageIcon(MainUIController.class.getResource("/icon/get_info.png"));
                System.out.println(icon);
                JOptionPane.showMessageDialog(null, "This program was powered by Java \n"
                        + "Authors: Đào Nam Tiến & Nguyễn Thúc Huynh \n"
                        + "University: Ha Noi University of Science and Technology. \n"
                        + "Release: Version 1.0 \n"
                        + "Time: 10/5/2016", "About us !", JOptionPane.INFORMATION_MESSAGE, icon);
            }
        });
    }

    public void setBtnTranslateAction() {
        mainUI.setBtnTranslateSentenceActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                translateController.displayUI();
            }
        });
    }

    public void setBtnSettingAction() {
        mainUI.setBtnSettingsActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settingsController.displayUI();
            }
        }
        );
    }

    public void setListResultAction() {
        mainUI.setListResultKeyAction(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    int index = mainUI.getListRerult().getSelectedIndex();
                    String value = (String) modelHistory.get(index);
                    String meaning = currentDict.loadMeaning(value);
                    mainUI.getLabelWord().setText(value);
                    mainUI.getTaMeaning().setText(setStyleMean(meaning, value));
                    addItemToListResult(value);

                }
            }
        });
        mainUI.setListResultMouseAction(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                if (evt.getClickCount() == 1) {
                    int index = mainUI.getListRerult().getSelectedIndex();
                    String value = (String) modelHistory.get(index);
                    String meaning = currentDict.loadMeaning(value);
                    mainUI.getLabelWord().setText(value);
                    mainUI.getTaMeaning().setText(setStyleMean(meaning, value));
                    addItemToListResult(value);
                }
            }
        });
    }

    public void addItemToListResult(String item) {
        try {
            int size = modelHistory.size();
            modelHistory.add(0, item);
            for (int i = 1; i <= size; i++) {
                String s = (String) modelHistory.get(i);
                if (s.equals(item)) {
                    modelHistory.remove(i);
                }
            }
            if (modelHistory.size() > 20) {
                modelHistory.remove(20);
            }
        } catch (Exception e) {
            //nothing
        }
    }

    public void setActionSearch() {
        mainUI.setTfSearchKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                /// nothing
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    String value = mainUI.getTfSearch().getText().toLowerCase().trim();
                    long index = searchWord(value, currentDict);
                    if (index == -1) {
                        JOptionPane.showMessageDialog(null, "This word \"" + value + "\" "
                                + "doesn't existed in dictionary.", "Search failed", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        String meaning = currentDict.loadMeaning(value);
                        mainUI.getLabelWord().setText(value);
                        mainUI.getTaMeaning().setText(setStyleMean(meaning, value));
                        addItemToListResult(value);
                    }

                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                try {
                    String value = mainUI.getTfSearch().getText().toLowerCase().trim();
                    byte textValue[] = value.getBytes("UTF-8");

                    //String val = new String(ptext, UTF_8);
                    JList listWords = mainUI.getListIndex();
                    int index;
                    Vector<model.Word> vectorResult = currentDict.getListWord();
                    for (index = 0; index < vectorResult.size(); index++) {
                        String it = vectorResult.get(index).getWord().toLowerCase();
                        byte textIt[] = it.getBytes("UTF-8");
                        //String i = new String(text, UTF_8);
                        if (checkList(textValue, textIt)) {
                            listWords.setSelectedIndex(index);
                            listWords.ensureIndexIsVisible(index);
                            long size = listWords.getModel().getSize();
                            long num;
                            if (index + 1000 > size) {
                                num = size - index - 1;
                            } else {
                                num = 1000;
                            }
                            listWords.scrollRectToVisible(listWords.getCellBounds(index, (int) (index + num)));
                            break;
                        }
                    }
//                    if(index!=-1){
//                        System.out.println(index);
//                        listWords.setSelectedIndex(index);
//                        listWords.ensureIndexIsVisible(index);
//                    }
                    // Set word on top of list

                } catch (UnsupportedEncodingException ex) {
                    Logger.getLogger(MainUIController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        mainUI.setListMouseAction(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                if (evt.getClickCount() == 1) {
                    int index = mainUI.getListIndex().getSelectedIndex();
                    Vector<model.Word> vectorResult = currentDict.getListWord();
                    if (index != -1) {
                        String value = vectorResult.get(index).getWord();
                        String meaning = currentDict.loadMeaning(value);
                        mainUI.getLabelWord().setText(value);
                        mainUI.getTaMeaning().setText(setStyleMean(meaning, value));
                        addItemToListResult(value);
                    }
                }
            }
        });
        mainUI.setListKeyAction(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    int index = mainUI.getListIndex().getSelectedIndex();
                    Vector<model.Word> vectorResult = currentDict.getListWord();
                    String value = vectorResult.get(index).getWord();
                    String meaning = currentDict.loadMeaning(value);
                    mainUI.getLabelWord().setText(value);
                    //set style for string mean to show
                    mainUI.getTaMeaning().setText(setStyleMean(meaning, value));
                    addItemToListResult(value);
                }
            }
        });
    }

    public boolean checkList(byte[] s1, byte[] s2) {
        int size1 = s1.length;
        if (size1 == 0) {
            return false;
        }

        int size2 = s2.length;
        if (size2 == 0) {
            return false;
        }

        if (size2 < size1) {
            return false;
        }
        for (int i = 0; i < size1; i++) {
            if (s1[i] != s2[i]) {
                return false;
            }
        }
        return true;
    }

    public void setBtnVEAction() {
        mainUI.setBtnVEActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                mainUI.getTfSearch().setText("");
                mainUI.getTaMeaning().setText("");
                currentDict = dictDataVE;
                setListModel(modelVE);
                mainUI.setStateVE();
            }
        });
    }

    public void setBtnEVAction() {
        mainUI.setBtnEVActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                mainUI.getTfSearch().setText("");
                mainUI.getTaMeaning().setText("");
                currentDict = dictDataEV;
                setListModel(modelEV);
                mainUI.setStateEV();
            }
        });
    }

    public void setSounds() {
        mainUI.setBtnSoundActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String value = "";
                int index = mainUI.getListIndex().getSelectedIndex();

                value = currentDict.getListWord().get(index).getWord();

                doSpeak(value, "kevin16");
            }
        });
    }

    public void loadListModelEV() {
        int i = 0;
        for (Iterator<model.Word> it = dictDataEV.getListWord().iterator(); it.hasNext(); i++) {
            modelEV.add(i, it.next().getWord());
        }
    }

    public void setListModel(DefaultListModel model) {
        mainUI.getListIndex().setModel(model);
    }

    public void loadListModelVE() {
        int i = 0;
        for (Iterator<model.Word> it = dictDataVE.getListWord().iterator(); it.hasNext(); i++) {
            modelVE.add(i, it.next().getWord());
        }

    }

    public String setStyleMean(String mean, String word) {
        return textPaneController.setStyleMean(mean, word);
    }

    public void setBtnListenAction() {
        mainUI.setBtnListenActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                soundParagraphController.showUI();
            }
        });
    }

    public void doSpeak(String speaktext, String voicename) {
        // speaktext=speak;
        String voiceName = voicename;
        try {
            SynthesizerModeDesc desc = new SynthesizerModeDesc(null, "general", Locale.US, null, null);
            Synthesizer synthesizer = Central.createSynthesizer(desc);
            synthesizer.allocate();
            synthesizer.resume();
            desc = (SynthesizerModeDesc) synthesizer.getEngineModeDesc();
            Voice[] voices = desc.getVoices();
            Voice voice = null;

            for (int i = 0; i < voices.length; i++) {
                if (voices[i].getName().equals(voiceName)) {
                    voice = voices[i];
                    break;
                }
            }
            synthesizer.getSynthesizerProperties().setVoice(voice);
            //System.out.print("Speaking : "+speaktext);
            synthesizer.speakPlainText(speaktext, null);
            synthesizer.waitEngineState(Synthesizer.QUEUE_EMPTY);
            //synthesizer.deallocate();
        } catch (Exception e) {
            String message = " missing speech.properties in " + System.getProperty("user.home") + "\n";
            System.out.println("" + e);
            System.out.println(message);
        }
    }

    public void copyFile() {
        InputStream is = null;
        OutputStream os = null;
        try {
            File aFile = new File("lib/freetts-1.2/speech.properties");
            File bFile = new File(System.getProperty("user.home") + "\\speech.properties");
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

    public long searchWord(String word, IDictionary dict) {

        // Loops to find where this word on dictionary
        Vector<model.Word> vectorResult = dict.getListWord();
        int size = dict.getListWord().size();
        for (int index = 0; index < size; index++) {
            if (vectorResult.get(index).getWord().toLowerCase().equals(word)) {
                return index;
            }
        }
        return -1;
    }

    public void setTaMeaningAction() {
        mainUI.setTaMeaningAction(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    if (mainUI.getTaMeaning().getSelectedText() != null) {
                        String word = mainUI.getTaMeaning().getSelectedText();

                        long search1 = searchWord(word, dictDataEV);
                        if (search1 >= 0) {
                            String mean = setStyleMean(dictDataEV.loadMeaning(word), word);
                            quickViewUIController.displayQuickView(word, mean);
                        } else {
                            long search2 = searchWord(word, dictDataVE);
                            if (search2 >= 0) {
                                String mean = setStyleMean(dictDataVE.loadMeaning(word), word);
                                quickViewUIController.displayQuickView(word, mean);
                            }
                        }
                    }
                }
            }

            @Override
            public void mouseDragged(MouseEvent event) {
                System.out.println("huynh");
            }

            public void mouseMoved(MouseEvent event) {
                System.out.println("huynh");
            }

        });
    }

    public void setTextEnglish() {
        mainUI.setTextEng();
        quickViewUIController.setTextEnglish();
        translateController.setTextEnglish();
        settingsController.setTextEnglish();
    }

    public void setTextVietNam() {
        mainUI.setTextViet();
        quickViewUIController.setTextVietNam();
        translateController.setTextVietNam();
        settingsController.setTextVietNam();
    }
}
