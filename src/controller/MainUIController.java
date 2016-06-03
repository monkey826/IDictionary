/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Color;
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
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import model.Dictionary;
import model.IDictionary;
import view.IMainUI;
import view.MainUI;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.ListModel;
import model.IManageStatus;
import model.IStatus;
import model.ManageStatus;

/**
 *
 * @author Monkey-private
 */
public final class MainUIController implements IMainUIController{

    private final IMainUI mainUI;
    private IDictionary dictDataEV;
    private IDictionary dictDataVE;
    private ISettingUIController settingsController;
    private ITranslateUIController translateController;
    private DefaultListModel modelHistory;
    private ISoundParagraphController soundParagraphController;
    private IQuickViewUIController quickViewUIController;
    private IDictionary currentDict;
    private TextPaneController textPaneController;
    private IManageStatus manageStatus;
    private ListModel modelVE;
    private ListModel modelEV;
    private ISoundManage soundManage;
    //construct
    public MainUIController() {
        //load data
        copyFile();
        dictDataEV = new Dictionary(1);
        dictDataVE = new Dictionary(2);
        modelVE=new StaticListModel(dictDataVE.getListWord());
        modelEV=new StaticListModel(dictDataEV.getListWord());
        //create some GUI or Controller
        modelHistory = new DefaultListModel();
        mainUI = new MainUI();
        mainUI.getListHistory().setModel(modelHistory);
        soundParagraphController = new SoundParagraphController(this);
        quickViewUIController = new QuickViewUIController();
        textPaneController = new TextPaneController();
        settingsController = new SettingsUIController(this);
        translateController = new TranslateUIController();
        soundManage=new SoundManage();
        //load last worked
        loadLastSession();
        mainUI.displayUI();
        //set Action:
        setActionSounds();
        setActionSearch();
        setBtnTranslateAction();
        setBtnSettingAction();
        setBtnListenAction();
        setTpMeaningAction();
        setBtnEVAction();
        setBtnVEAction();
        setListHistoryAction();
        setAboutAction();
        setBtnHelpAction();
    }
    
    public void loadLastSession(){
        manageStatus=new ManageStatus();
        IStatus s=manageStatus.getStatus();
        if(s.getTypeDictionary()==2){
            currentDict = dictDataVE;
            setListModel(modelVE);
           
          //  mainUI.updateUI();
        }
        else{
            currentDict=dictDataEV;
            setListModel(modelEV);
        }
        if(s.getLanguageDisplay()==2){
            setTextVietNam();
            settingsController.setLastWorkLanguage(2);
        }
        else{
            setTextEnglish();
            settingsController.setLastWorkLanguage(1);
        }
        Color colorSpell = new Color(Integer.parseInt(s.getColorSpell()));
        Color colorType = new Color(Integer.parseInt(s.getColorType()));
        Color colorMean = new Color(Integer.parseInt(s.getColorMean()));
        Color colorPhrase = new Color(Integer.parseInt(s.getColorPhrase()));
        int sizeSpell=s.getSizeSpell();
        int sizeType=s.getSizeType();
        int sizeMean=s.getSizeMean();
        int sizePhrase=s.getSizePhrase();
        textPaneController.setColor(colorSpell, colorType, colorMean, colorPhrase);
        textPaneController.setSize(sizeSpell, sizeType, sizeMean, sizePhrase);
        settingsController.setLastWordColor(colorSpell, colorType, colorMean, colorPhrase);
        settingsController.setLastWordSize(sizeSpell, sizeType, sizeMean, sizePhrase);
    }
    public void setAboutAction() {
        mainUI.setBtnAboutActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Icon icon = new ImageIcon(MainUIController.class.getResource("/icon/get_info.png"));
                String about="";
                String title="";
                if(manageStatus.getStatus().getLanguageDisplay()==1){
                    about="This program was powered by Java \n"
                        + "Authors: Đào Nam Tiến & Nguyễn Thúc Huynh \n"
                        + "University: Ha Noi University of Science and Technology. \n"
                        + "Release: Version 1.0 \n"
                        + "Time: 10/5/2016";
                    title="About us !";
                }
                else{ 
                    about="Chương trình viết bởi ngôn ngữ Java \n"
                            + "Tác giả: Đào Nam Tiến & Nguyễn Thúc Huynh \n"
                            + "Đại Học Bách Khoa Hà Nội \n"
                            + "Phiên bản: 1.0 \n"
                            + "Bản cập nhật ngày: 10/5/2016";
                    title="Thông tin tác giả!";
                }
                JOptionPane.showMessageDialog(null, about, title, JOptionPane.INFORMATION_MESSAGE, icon);
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

    public void setListHistoryAction() {
        mainUI.setListHistoryKeyAction(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    int index = mainUI.getListHistory().getSelectedIndex();
                    String value = (String) modelHistory.get(index);
                    String meaning = currentDict.loadMeaning(value);
                    mainUI.getLabelWord().setText(value);
                    mainUI.getTpMeaning().setText(textPaneController.setStyleMean(meaning, value));
                    addItemToListHistory(value);

                }
            }
        });
        mainUI.setListHistoryMouseAction(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                if (evt.getClickCount() == 1) {
                    int index = mainUI.getListHistory().getSelectedIndex();
                    String value = (String) modelHistory.get(index);
                    String meaning = currentDict.loadMeaning(value);
                    mainUI.getLabelWord().setText(value);
                    mainUI.getTpMeaning().setText(textPaneController.setStyleMean(meaning, value));
                    addItemToListHistory(value);
                }
            }
        });
    }

    public void addItemToListHistory(String item) {
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
                        mainUI.getTpMeaning().setText(textPaneController.setStyleMean(meaning, value));
                        addItemToListHistory(value);
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
                    Vector<model.Word> vectorHistory = currentDict.getListWord();
                    for (index = 0; index < vectorHistory.size(); index++) {
                        String it = vectorHistory.get(index).getWord().toLowerCase();
                        byte textIt[] = it.getBytes("UTF-8");
                        if (checkWord(textValue, textIt)) {
                            listWords.setSelectedIndex(index);
                            listWords.ensureIndexIsVisible(index);
                            long size = listWords.getModel().getSize();
                            long num;
                        //this code set the item was selected in list at top
                            if (index + 1000 > size) {
                                num = size - index - 1;
                            } else {
                                num = 1000;
                            }
                            listWords.scrollRectToVisible(listWords.getCellBounds(index, (int) (index + num)));
                        //////////////////////////////
                            break;
                        }
                    }
                } catch (UnsupportedEncodingException ex) {
                    Logger.getLogger(MainUIController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        mainUI.setListMouseAction(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                if (evt.getClickCount() == 1) {
                    int index = mainUI.getListIndex().getSelectedIndex();
                    Vector<model.Word> vectorHistory = currentDict.getListWord();
                    if (index != -1) {
                        String value = vectorHistory.get(index).getWord();
                        String meaning = currentDict.loadMeaning(value);
                        mainUI.getLabelWord().setText(value);
                        mainUI.getTpMeaning().setText(textPaneController.setStyleMean(meaning, value));
                        addItemToListHistory(value);
                    }
                }
            }
        });
        mainUI.setListKeyAction(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    int index = mainUI.getListIndex().getSelectedIndex();
                    Vector<model.Word> vectorHistory = currentDict.getListWord();
                    String value = vectorHistory.get(index).getWord();
                    String meaning = currentDict.loadMeaning(value);
                    mainUI.getLabelWord().setText(value);
                    //set style for string mean to show
                    mainUI.getTpMeaning().setText(textPaneController.setStyleMean(meaning, value));
                    addItemToListHistory(value);
                }
            }
        });
    }

    public boolean checkWord(byte[] s1, byte[] s2) {
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
    public void setBtnHelpAction(){
        mainUI.setBtnHelpContentsActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Icon icon = new ImageIcon(MainUIController.class.getResource("/icon/dialog_question.png"));
                String help="";
                String title="";
                if(manageStatus.getStatus().getLanguageDisplay()==1){
                    help=" Help. "
                        + "\n Two buttons Viet-Eng and Eng-Vie are used for change type of dictionary ! "
                        + "\n Button Settings is used for set Size,color for Pane Meaning "
                        + "\n You can translate online by Bing Dictionary with Button Translate Online "
                        + "\n You can listen a quotation by click button Listen"
                        + "\n Thank you! We hope you enjoy it.";
                    title="help";
                }
                else {
                    help= "Trợ giúp! \n"
                            + "2 nút Việt-Eng và Eng-Vie được sử dụng để chuyển đổi từ điển dịch \n"
                            + "Nút \"Cài đặt \" được sử dụng để thay đổi kích thước, màu sắc của các từ hiển thì trong"
                            + " phần nghĩa và thay đổi ngôn ngữ của chương trình \n"
                            + "Bạn có thể chọn chức năng dịch online với nút \"Dịch Online \" \n"
                            + "Bạn có thể nghe phát âm một đoạn văn do bạn nhập vào \n"
                            + "Cám ơn bạn đã sử dụng phần mềm. \n"
                            + "Hy vọng nó sẽ giúp ích nhiều cho bạn !";
                    title="Hướng dẫn sử dụng!";
                }
                JOptionPane.showMessageDialog(null, help, title, JOptionPane.INFORMATION_MESSAGE,icon );
            }
        });
    }
    public void setBtnVEAction() {
        mainUI.setBtnVEActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                mainUI.getTfSearch().setText("");
                mainUI.getTpMeaning().setText("");
                mainUI.setLbWordText("");
                currentDict = dictDataVE;
                setListModel(modelVE);
                mainUI.setStateVE();
                manageStatus.setDictionaryStatus(2);
                manageStatus.writeStatus();
            }
        });
    }

    public void setBtnEVAction() {
        mainUI.setBtnEVActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                mainUI.getTfSearch().setText("");
                mainUI.getTpMeaning().setText("");
                mainUI.setLbWordText("");
                currentDict = dictDataEV;
                setListModel(modelEV);
                mainUI.setStateEV();
                manageStatus.setDictionaryStatus(1);
                manageStatus.writeStatus();
            }
        });
    }

    public void setActionSounds() {
        mainUI.setBtnSoundActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String value = "";
                value=mainUI.getLabelWord().getText();
                soundManage.doSpeak(value, "kevin16");
            }
        });
    }

    
    public void setBtnListenAction() {
        mainUI.setBtnListenActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                soundParagraphController.showUI();
            }
        });
    }

    

    public void copyFile() {
        InputStream is = null;
        OutputStream os = null;
        try {
            File aFile = new File(this.getClass().getClassLoader().getResource("data/speech.properties").toString().substring(6));
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public long searchWord(String word, IDictionary dict) {

        // Loops to find where this word on dictionary
        Vector<model.Word> vectorHistory = dict.getListWord();
        int size = dict.getListWord().size();
        for (int index = 0; index < size; index++) {
            if (vectorHistory.get(index).getWord().toLowerCase().equals(word)) {
                return index;
            }
        }
        return -1;
    }

    public void setTpMeaningAction() {
        mainUI.setTpMeaningAction(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    if (mainUI.getTpMeaning().getSelectedText() != null) {
                        String word = mainUI.getTpMeaning().getSelectedText();

                        long search1 = searchWord(word, dictDataEV);
                        if (search1 >= 0) {
                            String mean = textPaneController.setStyleMean(dictDataEV.loadMeaning(word), word);
                            quickViewUIController.displayQuickView(word, mean);
                        } else {
                            long search2 = searchWord(word, dictDataVE);
                            if (search2 >= 0) {
                                String mean = textPaneController.setStyleMean(dictDataVE.loadMeaning(word), word);
                                quickViewUIController.displayQuickView(word, mean);
                            }
                        }
                    }
                }
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
    public IManageStatus getManageStatus(){
        return this.manageStatus;
    }
    public TextPaneController getTextPaneController(){
        return this.textPaneController;
    }
    public void setListModel(ListModel model) {
        mainUI.getListIndex().setModel(model);
    }
    public ISoundManage getSoundManage(){
        return  this.soundManage;
    }
    
}
