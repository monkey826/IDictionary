/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Vector;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;
import model.Word;

/**
 *
 * @author HOANG_HUYNH
 */
public class StaticListModel implements ListModel<String>{
    private Vector<Word> data;
    
    public StaticListModel(Vector<Word> data){
        this.data=data;
    }
    @Override
    public String getElementAt(int index) {
      return data.elementAt(index).getWord();
    }

    @Override
    public int getSize() {
      return data.size();
    }

    public void addListDataListener(ListDataListener ldl) {
        //nothing
    }

    public void removeListDataListener(ListDataListener ldl) {
        //nothing
    }
  
}
