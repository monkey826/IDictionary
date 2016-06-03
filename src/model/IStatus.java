/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.awt.Color;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
/**
 *
 * @author HOANG_HUYNH
 */
@XmlRootElement
public interface IStatus {
    /**
     * get type of dictionary
     * @return: type of dictionary 
     */
    public int getTypeDictionary();
    /**
     * set type for dictionary
     * @param typeDictionary 
     */
    @XmlElement
    public void setTypeDictionary(int typeDictionary);
    /**
     * get language
     * @return: language 
     */
    public int getLanguageDisplay();
    /**
     * set language
     * @param languageDisplay: language 
     */
    @XmlElement
    public void setLanguageDisplay(int languageDisplay);
    /**
     * get size of spell
     * @return:size 
     */
    public int getSizeSpell();
    /**
     * set size of spell
     * @param sizeSpell :size
     */
    @XmlElement
    public void setSizeSpell(int sizeSpell);
    /**
     * get size of word type
     * @return :size
     */
    public int getSizeType();
    /**
     * set size of word type
     * @param sizeType:size 
     */
    @XmlElement
    public void setSizeType(int sizeType);
    /**
     * get size of word type
     * @return :size
     */
    public int getSizeMean();
    /**
     * set size of word mean
     * @param sizeMean :size
     */
    @XmlElement
    public void setSizeMean(int sizeMean);
    /**
     * get size of word mean
     * @return :size
     */
    public int getSizePhrase();
    /**
     * get size of word phrase
     * @param sizePhrase :size
     */
    @XmlElement
    public void setSizePhrase(int sizePhrase);
    /**
     * get string color spell
     * @return :string of color
     */
    public String getColorSpell();
    /**
     * set string color of spell
     * @param colorSpell :string color
     */
    @XmlElement
    public void setColorSpell(String colorSpell);
    /**
     * get string color type
     * @return :string color
     */
    public String getColorType();
    /**
     * get set string color word type
     * @param colorType: string color 
     */
    @XmlElement
    public void setColorType(String colorType);
    /**
     * get string color of word mean
     * @return :string color
     */
    public String getColorMean();
    /**
     * set string color of word mean
     * @param colorMean 
     */
    @XmlElement
    public void setColorMean(String colorMean);
    /**
     * get string color of word phrase
     * @return 
     */
    public String getColorPhrase();
    /**
     * set string color of word phrase
     * @param colorPhrase : string color
     */
    @XmlElement
    public void setColorPhrase(String colorPhrase);
   
}
