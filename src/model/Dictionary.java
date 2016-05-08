/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Hashtable;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.swing.DefaultListModel;

/**
 *
 * @author Monkey-private
 */
public class Dictionary implements  IDictionary,Runnable {

//    public Hashtable<String, String> mapWord;
    private final File indexesFile;
    private final File meansFile;
    private Vector<String> words = new Vector<>();
//    private DefaultListModel model;
    //Constructor 
    public Dictionary() {
//        this.mapWord = new Hashtable<>();
        // Indexes file
        indexesFile = new File(System.getProperty("user.dir").concat("/data/anhviet109K.index"));
        // Meanning file
        meansFile = new File(System.getProperty("user.dir").concat("/data/anhviet109K.dict"));
        // Load index file 
//        loadIndex();
        // New thread for read meannings file
        new Thread(this).start();
    }

//     Read file index
    @Override
    public void run() {
        loadIndex();
    }

    public void loadIndex() {
//        model = new DefaultListModel();
//        int numberWords = 0;
        long begin = System.currentTimeMillis();
        try {
            // Using StringBuilder 
            StringBuilder strBuilder = new StringBuilder();
            try (FileInputStream input = new FileInputStream(indexesFile)) {
                byte[] buffer = new byte[1024];
                while (input.read(buffer) != -1) // Loops until indexes file end.
                {
                    strBuilder.append(new String(buffer));
                }
                // Read data index
                String data = strBuilder.toString();
                StringTokenizer tokenizer = new StringTokenizer(data, "\n");
                while (tokenizer.hasMoreTokens()) {
                    String line = tokenizer.nextToken();
                    // divided string 
                    String elements[] = line.split("\t");
                    if (elements.length == 3) { // If enough word,off,length
//                        String word = mapWord.get(elements[0]);
                        int offset = base64ToBase10(elements[1]);
                        int length = base64ToBase10(elements[2]);
                        words.add(elements[0]);
//                        model.add(numberWords,elements[0]);
//                        numberWords++;
//                        if ( word == null){
//                            // If word is not on list.
//                        }
                                
                    }
                }
            }
        } catch (IOException ioe) {
            System.out.println("Error IO " + ioe.getMessage());;
        }
        long end = System.currentTimeMillis();
        System.out.println("Load indexes file took " + (end-begin) +" ms");
//        return model;
    }

    public void loadMeaning(String word) {
        
    }

    public int base64ToBase10(String val) {
        int number = 0;
        int length = val.length();
        String opcode = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
        for (int i = 0; i < length; i++) {
            number += opcode.indexOf(val.charAt(i)) * Math.pow(64, length - i - 1);
        }
        return number;
    }

    /**
     *
     * @return
     */
    @Override
    public Vector<String> getListWord(){
//        System.out.println(words);
        return words;
        
    }
}
