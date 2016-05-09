/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.File;
import java.io.RandomAccessFile;

/**
 *
 * @author Monkey-private
 */
public class Word {

    private String word;
    private final int offset;
    private final int length;
    // Meanning file
    

    public Word(String word, int offset, int length) {
        this.word = word;
        this.offset = offset;
        this.length = length;
    }

    public int getOffset(){
        return offset;
    }
    public int getLength(){
        return length;
    }
}
