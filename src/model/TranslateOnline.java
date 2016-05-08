/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.memetix.mst.language.Language;
import com.memetix.mst.translate.Translate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Monkey-private
 */
public class TranslateOnline implements ITranslateOnline{
    // Using Bing Translator for translating sentence.
    private final String CLIENT_ID = "Dictionary1";
    private final String CLIENT_SECRET_KEY ="maUQXnGo1OiClwMB391jMku4Yynnk3KqImUZbH/fL5M=";
    /**
     * Initiate key API Bing Translator Client
     */
    public TranslateOnline(){
        Translate.setClientId(CLIENT_ID);
        Translate.setClientSecret(CLIENT_SECRET_KEY);
    }
    /**
     * (non-Javadoc)
     *
     * @see model.ITranslateOnline#translateVE(java.lang.String) ;
     */
    @Override
    public String translateVE(String key) {
        String value="";
        try {
            value = Translate.execute(key, Language.VIETNAMESE, Language.ENGLISH);// Execute translating from vietnamese to english
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return value;
    }
    /**
     * (non-Javadoc)
     *
     * @see model.ITranslateOnline#translateEV(java.lang.String) ;
     */
    @Override
    public String translateEV(String key) {
        String value="";
        try {
            value = Translate.execute(key, Language.ENGLISH, Language.VIETNAMESE); // Execute translating from english to vietnamese
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return value;
    }
}
