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
    public final String pathIndexAV = System.getProperty("user.dir").concat("/data/anhviet109K.index");
    public final String pathMeaningAV = System.getProperty("user.dir").concat("/data/anhviet109K.dict");
    public final String pathIndexVA = System.getProperty("user.dir").concat("/data/vietanh.index");
    public final String pathMeaningVA = System.getProperty("user.dir").concat("/data/vietanh.dict");
    public Vector<String> getListWord();
    public String loadMeaning(String word);
    public void setTypeDictionary(String filePathIndex,String filePathDict);
    public String getPathIndexAV();
    public String getPathIndexVA();
    public String getPathDictAV();
    public String getPathDictVA();
    
}
