/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author HOANG_HUYNH
 */
public interface IManageStatus {
    /**
     * read status of program that is save in file 'savestate.xml'
     */
    public void readStatus();
    /**
     * write current program status in file file 'savestate.xml'
     */
    public void writeStatus();
    /**
     * get status
     * @return:a Status object 
     */
    public IStatus getStatus();
    /**
     * setting for a Status Object
     * @param status 
     */
    public void setStatus(IStatus status);
    /**
     * set properties size for status object
     * @param sizeSpell:size of spell
     * @param sizeWordType:size of word type
     * @param sizeWordMean:size of word mean
     * @param sizePhrase:size of word phrase 
     */
    public void setSizeStatus(int sizeSpell,int sizeWordType,int sizeWordMean,int sizePhrase);
    /**
     * setting properties color for status object
     * @param colorSpell:color of spell
     * @param colorWordType:color of word type
     * @param colorWordMean:color of word mean
     * @param colorPhrase:color of word phrase 
     */
    public void setColorStatus(String colorSpell,String colorWordType,String colorWordMean,String colorPhrase);
    /**
     * setting properties language for status object
     * @param language:language 
     */
    public void setLanguageStatus(int language);
    /**
     * setting properties type of dictionary for status object
     * @param dict: type of dictionary 
     */
    public void setDictionaryStatus(int dict);
}
