/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionListener;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

/**
 *
 * @author Monkey-private
 */
public class TranslateUI extends javax.swing.JFrame implements ITranslateUI{

    /**
     * Creates new form TranslateUI
     */
    public TranslateUI() {
        initComponents();
        taResults.setEditable(false);
//        setVisible(true);
        setLocationRelativeTo(null);
    }

    @Override
    public void setRbtnEVActionListener(ActionListener listener){
        this.rbtnEV.addActionListener(listener);
    }
    @Override
    public void setRbtnVEActionListener(ActionListener listener){
        this.rbtnVE.addActionListener(listener);
    }
    @Override
    public void setBtnTranslateActionListener(ActionListener listener){
        this.btnTranslate.addActionListener(listener);
    }
    @Override
    public JTextArea getTaSource(){
        return taSource;
    }
    @Override
    public JTextArea getTaResults(){
        return taResults;
    }
    @Override
    public JRadioButton getRbtnEV(){
        return rbtnEV;
    }
    @Override
    public JRadioButton getRbtnVE(){
        return rbtnVE;
    }
    @Override
    public void setTextVietnamese(){
        btnTranslate.setText("Dịch");
        rbtnEV.setText("Anh-Việt");
        rbtnVE.setText("Việt-Anh");
        setTitle("Dịch online");
        this.repaint();
    }
    @Override
    public void setTextEnglish(){
        btnTranslate.setText("Translate");
        rbtnEV.setText("Eng-Viet");
        rbtnVE.setText("Viet-Eng");
        setTitle("Translate Online");
        this.repaint();
    }
    @Override
    public void displayUI(){
        this.setVisible(true);
    }
    @Override
    public void hideUI(){
        this.setVisible(false);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        taSource = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        taResults = new javax.swing.JTextArea();
        rbtnVE = new javax.swing.JRadioButton();
        rbtnEV = new javax.swing.JRadioButton();
        lbTitle = new javax.swing.JLabel();
        btnTranslate = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Translate Online by Bing Translator");

        taSource.setColumns(20);
        taSource.setLineWrap(true);
        taSource.setRows(5);
        taSource.setWrapStyleWord(true);
        jScrollPane1.setViewportView(taSource);

        taResults.setColumns(20);
        taResults.setLineWrap(true);
        taResults.setRows(5);
        taResults.setWrapStyleWord(true);
        jScrollPane2.setViewportView(taResults);

        buttonGroup1.add(rbtnVE);
        rbtnVE.setSelected(true);
        rbtnVE.setText("Việt - Anh");

        buttonGroup1.add(rbtnEV);
        rbtnEV.setText("English - Vietnamese");

        lbTitle.setText("Enter the text to be translated");

        btnTranslate.setText("Translate");

        jLabel1.setText("Choose language to translate");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(btnTranslate, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rbtnVE, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(rbtnEV))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(258, 259, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtnVE)
                    .addComponent(rbtnEV))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTranslate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(TranslateUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(TranslateUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(TranslateUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(TranslateUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTranslate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JRadioButton rbtnEV;
    private javax.swing.JRadioButton rbtnVE;
    private javax.swing.JTextArea taResults;
    private javax.swing.JTextArea taSource;
    // End of variables declaration//GEN-END:variables
}
