/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Vector;

/**
 *
 * @author Monkey-private
 */
public interface IDictionary {
    /**
     * Path index file data dictionary English-Vietnamese
     */
    public final String pathIndexEV = System.getProperty("user.dir").concat("/data/anhviet109K.index");
    /**
     * Path meaning file data dictionary English-Vietnamese
     */
    public final String pathMeaningEV = System.getProperty("user.dir").concat("/data/anhviet109K.dict");
    /**
     *  Get Vector list words
     * @return JList listWord;
     */
    public Vector<String> getListWord();
    /**
     * 
     * @param word
     * @return Meaning of this word
     */
    public String loadMeaning(String word);
    /**
     * Load JList full words from database to Vector and hashtable
     */
    public void loadIndex();
}
