/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.BufferedReader;
import java.io.StringReader;

/**
 *
 * @author HOANG_HUYNH
 */
public class TextPaneController {

    private int sizeSpell;
    private int sizeWordType;
    private int sizeWordMean;
    private int sizePhrase;
    private String colorSpell;
    private String colorWordType;
    private String colorWordMean;
    private String colorPhrase;
//    private String pathIcon =  System.getProperty("user.dir") + "\\src\\icon\\h1.png";

    public String setStyleMean(String mean, String word) {
        String meanStyle = "";
        String newMean = "";
        int sizeSpell, sizeWordType, sizeWordMean, sizePhrase;
        String colorSpell, colorWordType, colorWordMean, colorPhrase;
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
                        line = "<img src=\"" + this.getClass().getClassLoader().getResource("icon/spell.png").toString() + "\"/>" + "<b color=\"blue\">" + line + "</b>";
                        newMean = newMean + line + "<br/>";
                    } else if (line.contains("*")) {
                        line = "<span style = \" font-size : 18px; color: blue; \"><b><i>" + line + "</i></b></span>";
                        newMean = newMean + line + "<br>";
                    } else if (line.contains("-")) {
                        line = "<span style = \" font-size : 16px; color: red; \">" + line + "</span>";
                        newMean = newMean + line + "<br>";
                    } else if (line.contains("=")) {
//                        line = "<span style = \" font-size : 14px; color: green; \"> " + line + "</span>";
                        int pos = getPostionCharacter(line);
                        String linePre = line.substring(1, pos);
                        String lineNext = line.substring(pos + 1, line.length());
                        
                        newMean = newMean + "<span style = \" font-size : 16px; color: green; \"> " + linePre + ":" + lineNext + "</b></span>" + "<br>";
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

    public void setSizeSpell(int sizeSpell) {
        this.sizeSpell = sizeSpell;
    }

    public void setSizeWordType(int sizeWordType) {
        this.sizeWordType = sizeWordType;
    }

    public void setSizeWordMean(int sizeWordMean) {
        this.sizeWordMean = sizeWordMean;
    }

    public void setSizePhrase(int sizePhrase) {
        this.sizePhrase = sizePhrase;
    }

    public void setColorSpell(String colorSpell) {
        this.colorSpell = colorSpell;
    }

    public void setColorWordType(String colorWordType) {
        this.colorWordType = colorWordType;
    }

    public void setColorWordMean(String colorWordMean) {
        this.colorWordMean = colorWordMean;
    }

    public void setColorPhrase(String colorPhrase) {
        this.colorPhrase = colorPhrase;
    }

}
