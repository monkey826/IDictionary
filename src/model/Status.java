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

    @Override
    public int getTypeDictionary() {
        return typeDictionary;
    }
    @XmlElement
    @Override
    public void setTypeDictionary(int typeDictionary) {
        this.typeDictionary = typeDictionary;
    }

    @Override
    public int getLanguageDisplay() {
        return languageDisplay;
    }
    @XmlElement
    @Override
    public void setLanguageDisplay(int languageDisplay) {
        this.languageDisplay = languageDisplay;
    }

    @Override
    public int getSizeSpell() {
        return sizeSpell;
    }
    @XmlElement
    @Override
    public void setSizeSpell(int sizeSpell) {
        this.sizeSpell = sizeSpell;
    }

    @Override
    public int getSizeType() {
        return sizeType;
    }
    @XmlElement
    @Override
    public void setSizeType(int sizeType) {
        this.sizeType = sizeType;
    }

    @Override
    public int getSizeMean() {
        return sizeMean;
    }
    @XmlElement
    @Override
    public void setSizeMean(int sizeMean) {
        this.sizeMean = sizeMean;
    }
    
    @Override
    public int getSizePhrase() {
        return sizePhrase;
    }
    @XmlElement
    @Override
    public void setSizePhrase(int sizePhrase) {
        this.sizePhrase = sizePhrase;
    }

    @Override
    public String getColorSpell() {
        return colorSpell;
    }
    @XmlElement
    @Override
    public void setColorSpell(String colorSpell) {
        this.colorSpell = colorSpell;
    }

    @Override
    public String getColorType() {
        return colorType;
    }
    @XmlElement
    @Override
    public void setColorType(String colorType) {
        this.colorType = colorType;
    }

    @Override
    public String getColorMean() {
        return colorMean;
    }
    @XmlElement
    @Override
    public void setColorMean(String colorMean) {
        this.colorMean = colorMean;
    }

    @Override
    public String getColorPhrase() {
        return colorPhrase;
    }
    @XmlElement
    @Override
    public void setColorPhrase(String colorPhrase) {
        this.colorPhrase = colorPhrase;
    }
}
