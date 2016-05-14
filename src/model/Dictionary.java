/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.Vector;

/**
 *
 * @author Monkey-private
 */
public class Dictionary implements IDictionary {

    private Vector<Word> words = new Vector<>();
    private int type;//type of dictionary(VE is 2- or EV is 1)
    //construct
    public Dictionary(int type) {
        // Init hashtable
        this.type=type;
        loadIndex();
    }

    public void loadIndex() {
        String filePathIndex;
        if(type==1)
            filePathIndex=pathIndexEV;
        else
            filePathIndex=pathIndexVE;
        
        long begin = System.currentTimeMillis();
        
        try {
            // Using StringBuilder 
            StringBuilder strBuilder = new StringBuilder();
            try (FileInputStream input = new FileInputStream(new File(filePathIndex))) {
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
                        int offset = base64ToBase10(elements[1]);
                        int length = base64ToBase10(elements[2]);
                        // Add to vector words.
                        // Create a new word;
                        Word word = new Word(elements[0], offset, length);
                        // Add to hashtable;
                        words.add(word);
                    }
                }
                
            }
        } catch (IOException ioe) {
            System.out.println("Error IO " + ioe.getMessage());;
        }
        for(int i=0;i<29;i++) words.remove(0);
        long end = System.currentTimeMillis();
        System.out.println("Load indexes file took " + (end - begin) + " ms");
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

    @Override
    public String loadMeaning(String word) {
        String filePathDict;
        if(type==1)
            filePathDict=pathMeaningEV;
        else filePathDict=pathMeaningVE;
        RandomAccessFile raf = null;
        String meaning = "";
        try {
            raf = new RandomAccessFile(new File(filePathDict), "r");
            Word wordSearch = getWord(word);
            for (int i = 0; i < wordSearch.getLength(); i++) {
                byte[] buff = new byte[wordSearch.getLength()];
                raf.seek(wordSearch.getOffset());
                raf.read(buff, 0, wordSearch.getLength());
                meaning = new String(buff, "UTF8").replaceAll("\0+", "");
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
        return meaning;
    }
    public Word getWord(String wordSource){
        Word word = null;
        Iterator it = words.iterator();
        while (it.hasNext()){
            word = (Word) it.next();
            if (word.getWord().equals(wordSource))
                return word;
        }
        return word;
    }
    /**
     *
     * @return
     */
    @Override
    public Vector<Word> getListWord() {
        return words;

    }
}
