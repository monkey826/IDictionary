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
public interface IWord {
    /**
     * Get offset of this word
     * @return offset
     */
    public int getOffset();
    /**
     * Get length of meaning 
     * @return length
     */
    public int getLength();
}
