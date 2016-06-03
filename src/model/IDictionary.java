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
     * Get List word from file index.
     * @return a vector store all word in data index file
     */
    public Vector<Word> getListWord();
    /**
     * Load index file and add all word into vector Word.
     */
    public void loadIndex();
    /**
     * Load meaning of this word param.
     * @param word
     * @return meaning
     */
    public String loadMeaning(String word);    
}
