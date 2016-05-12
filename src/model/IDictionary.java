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
<<<<<<< HEAD
    public final String pathIndexAV = System.getProperty("user.dir").concat("/data/anhviet109K.index");
    public final String pathMeaningAV = System.getProperty("user.dir").concat("/data/anhviet109K.dict");
    public final String pathIndexVA = System.getProperty("user.dir").concat("/data/vietanh.index");
    public final String pathMeaningVA = System.getProperty("user.dir").concat("/data/vietanh.dict");
=======
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
>>>>>>> origin/master
    public Vector<String> getListWord();
    /**
     * 
     * @param word
     * @return Meaning of this word
     */
    public String loadMeaning(String word);
<<<<<<< HEAD
    public void setTypeDictionary(String filePathIndex,String filePathDict);
    public String getPathIndexAV();
    public String getPathIndexVA();
    public String getPathDictAV();
    public String getPathDictVA();
    
=======
    /**
     * Load JList full words from database to Vector and hashtable
     */
    public void loadIndex();
>>>>>>> origin/master
}
