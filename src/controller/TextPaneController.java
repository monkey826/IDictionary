/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.StringReader;

/**
 *
 * @author HOANG_HUYNH
 */
public class TextPaneController implements ITextPaneController{

    private int sizeSpell;
    private int sizeWordType;
    private int sizeWordMean;
    private int sizePhrase;
    private Color colorSpell;
    private Color colorWordType;
    private Color colorWordMean;
    private Color colorPhrase;

    public void setColor(Color colorSpell,Color colorWordType,Color colorWordMean,Color colorPhrase){
        this.colorPhrase=colorPhrase;
        this.colorSpell=colorSpell;
        this.colorWordMean=colorWordMean;
        this.colorWordType=colorWordType;
    }
    public void setSize(int sizeSpell,int sizeWordType,int sizeWordMean,int sizePhrase){
        this.sizePhrase=sizePhrase;
        this.sizeSpell=sizeSpell;
        this.sizeWordMean=sizeWordMean;
        this.sizeWordType=sizeWordType;
    }
    public String setStyleMean(String mean, String word) {
        String meanStyle = "";
        String newMean = "";
        try {
            int lenWord = word.length();
            meanStyle = mean.substring(lenWord + 1);
        } catch (Exception e) {
            meanStyle = null;
        }
        if (meanStyle != null) {
            String line;
            try (BufferedReader reader = new BufferedReader(new StringReader(meanStyle))) {
                while ((line = reader.readLine()) != null) {
                    //System.out.println(line);
                    if (line.contains("/")) {
                        line = "<img src=\"" + this.getClass().getClassLoader().getResource("icon/spell.png").toString() + "\"/>" +"&nbsp; &nbsp;<span style = \" font-size : "+sizeSpell+"px; color: rgb("+colorSpell.getRed()+","+colorSpell.getGreen()+","+colorSpell.getBlue()+"); \"><b><i>" + line + "</i></b></span>";
                        newMean = newMean + line + "<br/>";
                    } else if (line.contains("*")) {
                        line=line.substring(1);
                        line = "&nbsp; &nbsp; <img src=\"" + this.getClass().getClassLoader().getResource("icon/typeword.png").toString() + "\"/>" +"&nbsp; &nbsp;<span style = \" font-size : "+sizeWordType+"px; color: rgb("+colorWordType.getRed()+","+colorWordType.getGreen()+","+colorWordType.getBlue()+"); \"><b><i>" + line + "</i></b></span>";
                        newMean = newMean + line + "<br>";
                    } else if (line.contains("-")) {
                        line=line.substring(1);
                        line = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src=\"" + this.getClass().getClassLoader().getResource("icon/mean.png").toString() + "\"/>" +"&nbsp;&nbsp;<span style = \" font-size : "+sizeWordMean+"px; color: rgb("+colorWordMean.getRed()+","+colorWordMean.getGreen()+","+colorWordMean.getBlue()+"); \"><b><i>" + line + "</span>";
                        newMean = newMean + line + "<br>";
                    } else if (line.contains("=")) {
                        int pos = getPostionCharacter(line);
                        String linePre = line.substring(1, pos);
                        String lineNext = line.substring(pos + 1, line.length());
                        newMean = newMean + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src=\"" + this.getClass().getClassLoader().getResource("icon/phrase.png").toString() + "\"/>" +"&nbsp;&nbsp;<span style = \" font-size : "+sizePhrase+"px; color: rgb("+colorPhrase.getRed()+","+colorPhrase.getGreen()+","+colorPhrase.getBlue()+"); \"><b><i>" + linePre + ":" + lineNext + "</b></span>" + "<br>";
                    } else {
                        newMean = newMean + line + "<br>";
                    }
                }
            } catch (Exception e) {

            }

        }
        return newMean;
    }

    public int getPostionCharacter(String line) {
        char[] s = line.toCharArray();
        int size = s.length;
        for (int i = 0; i < size; i++) {
            if (s[i] == '+') {
                return i;
            };
        }
        return -1;
    }
}
