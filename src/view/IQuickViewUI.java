/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionListener;

/**
 *
 * @author HOANG_HUYNH
 */
public interface IQuickViewUI {
    public void display();
    public void setLbWordText(String word);
    public void setTaMeaningText(String meaning);
    public void setBtnNextAction(ActionListener listener);
    public void setBtnPreAction(ActionListener listener);
}
