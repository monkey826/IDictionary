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
    public final String pathIndexEV = System.getProperty("user.dir").concat("/data/anhviet109K.index");
    public final String pathMeaningEV = System.getProperty("user.dir").concat("/data/anhviet109K.dict");
    public final String pathIndexVE = System.getProperty("user.dir").concat("/data/vietanh.index");
    public final String pathMeaningVE = System.getProperty("user.dir").concat("/data/vietanh.dict");
    public Vector<String> getListWord();
    public void loadIndex();
    public String loadMeaning(String word);    
}
