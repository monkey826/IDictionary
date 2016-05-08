/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Monkey-private
 */
public interface ITranslateOnline {
    /**
     * Translate sentences.
     * @param key
     * @return Vietnamese sentences to English
     */
    public String translateVE(String key);
    /**
     * Translate sentences.
     * @param key
     * @return English sentences to Vietnamese
     */
    public String translateEV(String key);
}
