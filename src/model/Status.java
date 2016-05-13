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
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
/**
 *
 * @author HOANG_HUYNH
 */
@XmlRootElement
public class Status implements IStatus{
    private int typeDictionary;
    private int languageDisplay;
    private int sizeSpell;
    private int sizeType;
    private int sizeMean;
    private int sizePhrase;
    private String colorSpell;
    private String colorType;
    private String colorMean;
    private String colorPhrase;

    public int getTypeDictionary() {
        return typeDictionary;
    }
    @XmlElement
    public void setTypeDictionary(int typeDictionary) {
        this.typeDictionary = typeDictionary;
    }

    public int getLanguageDisplay() {
        return languageDisplay;
    }
    @XmlElement
    public void setLanguageDisplay(int languageDisplay) {
        this.languageDisplay = languageDisplay;
    }

    public int getSizeSpell() {
        return sizeSpell;
    }
    @XmlElement
    public void setSizeSpell(int sizeSpell) {
        this.sizeSpell = sizeSpell;
    }

    public int getSizeType() {
        return sizeType;
    }
    @XmlElement
    public void setSizeType(int sizeType) {
        this.sizeType = sizeType;
    }

    public int getSizeMean() {
        return sizeMean;
    }
    @XmlElement
    public void setSizeMean(int sizeMean) {
        this.sizeMean = sizeMean;
    }
    
    public int getSizePhrase() {
        return sizePhrase;
    }
    @XmlElement
    public void setSizePhrase(int sizePhrase) {
        this.sizePhrase = sizePhrase;
    }

    public String getColorSpell() {
        return colorSpell;
    }
    @XmlElement
    public void setColorSpell(String colorSpell) {
        this.colorSpell = colorSpell;
    }

    public String getColorType() {
        return colorType;
    }
    @XmlElement
    public void setColorType(String colorType) {
        this.colorType = colorType;
    }

    public String getColorMean() {
        return colorMean;
    }
    @XmlElement
    public void setColorMean(String colorMean) {
        this.colorMean = colorMean;
    }

    public String getColorPhrase() {
        return colorPhrase;
    }
    @XmlElement
    public void setColorPhrase(String colorPhrase) {
        this.colorPhrase = colorPhrase;
    }
}
