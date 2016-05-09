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
    public final String pathIndex = System.getProperty("user.dir").concat("/data/anhviet109K.index");
    public final String pathMeaning = System.getProperty("user.dir").concat("/data/anhviet109K.dict");
    public Vector<String> getListWord();
    public String loadMeaning(String word);
}
