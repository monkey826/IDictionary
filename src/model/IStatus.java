/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
/**
 *
 * @author HOANG_HUYNH
 */
@XmlRootElement
public interface IStatus {
    public int getTypeDictionary();
    @XmlElement
    public void setTypeDictionary(int typeDictionary);
    public int getLanguageDisplay();
    @XmlElement
    public void setLanguageDisplay(int languageDisplay);
    public int getSizeSpell();
    @XmlElement
    public void setSizeSpell(int sizeSpell);
    public int getSizeType();
    @XmlElement
    public void setSizeType(int sizeType);
    public int getSizeMean();
    @XmlElement
    public void setSizeMean(int sizeMean);
    public int getSizePhrase();
    @XmlElement
    public void setSizePhrase(int sizePhrase);
    public String getColorSpell();
    @XmlElement
    public void setColorSpell(String colorSpell);
    public String getColorType();
    @XmlElement
    public void setColorType(String colorType);
    public String getColorMean();
    @XmlElement
    public void setColorMean(String colorMean);
    public String getColorPhrase();
    @XmlElement
    public void setColorPhrase(String colorPhrase);
}
