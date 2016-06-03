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
public class Word implements IWord{

    private final String word;
    private final int offset;
    private final int length;
    
    /**
     * Constructor to init a new instance of Word class.
     * @param word
     * @param offset
     * @param length 
     */
    public Word(String word, int offset, int length) {
        this.word = word;
        this.offset = offset;
        this.length = length;
    }
    /**
     * (non-Javadoc)
     * @see model.IWord#getWord() () 
     */
    @Override
    public String getWord(){
        return word;
    }
    /**
     * (non-Javadoc)
     * @see model.IWord#getOffset() 
     */
    @Override
    public int getOffset(){
        return offset;
    }
    /**
     * (non-Javadoc)
     * @see model.IWord#getLength()  
     */
    @Override
    public int getLength(){
        return length;
    }
    
}
