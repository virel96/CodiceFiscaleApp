
package view;

import java.awt.GraphicsEnvironment;

/**
 * Finestra grafica per introdurre i dati anagrafici e richiamare il calcolo
 * del codice fiscale
 * @author Sandro
 */
public class GuiInterface extends javax.swing.JFrame {

    public GuiInterface() {
        initComponents();
        this.setCenter();
        fldCognome.setText("ROSSI");
        fldNome.setText("MARIO");
        fldDataNas.setText("01/01/2013");
        fldComune.setText("ROMA");
    }
    
    private void setCenter() {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        java.awt.Point center = ge.getCenterPoint();
        java.awt.Rectangle bounds = ge.getMaximumWindowBounds();
        int w = Math.max(bounds.width/2, Math.min(this.getWidth(), bounds.width));
        int h = Math.max(bounds.height/2, Math.min(this.getHeight(), bounds.height));
        int x = center.x - w/2, y = center.y - h/2;
        this.setBounds(x, y, w, h);
        if (w == bounds.width && h == bounds.height) this.setExtendedState(this.MAXIMIZED_BOTH);
        this.pack();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupSesso = new javax.swing.ButtonGroup();
        lblCognome = new javax.swing.JLabel();
        fldCognome = new javax.swing.JTextField();
        lblNome = new javax.swing.JLabel();
        fldNome = new javax.swing.JTextField();
        lblDataNas = new javax.swing.JLabel();
        fldDataNas = new javax.swing.JTextField();
        lblSesso = new javax.swing.JLabel();
        rbSessoM = new javax.swing.JRadioButton();
        rbSessoF = new javax.swing.JRadioButton();
        lblComuneNas = new javax.swing.JLabel();
        lblCodiceFiscale = new javax.swing.JLabel();
        btnEsci = new javax.swing.JButton();
        btnCalcola = new javax.swing.JButton();
        lblLogo = new javax.swing.JLabel();
        fldComune = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Calcolo del Codice Fiscale - Careware App");

        lblCognome.setLabelFor(fldCognome);
        lblCognome.setText("Cognome");

        fldCognome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fldCognomeActionPerformed(evt);
            }
        });

        lblNome.setLabelFor(fldNome);
        lblNome.setText("Nome");

        fldNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fldNomeActionPerformed(evt);
            }
        });

        lblDataNas.setText("Data di nascita");

        fldDataNas.setToolTipText("inserire una data nel formato gg/mm/aaaa");

        lblSesso.setText("Sesso");

        buttonGroupSesso.add(rbSessoM);
        rbSessoM.setSelected(true);
        rbSessoM.setText("Maschio");
        rbSessoM.setToolTipText("");
        rbSessoM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbSessoMActionPerformed(evt);
            }
        });

        buttonGroupSesso.add(rbSessoF);
        rbSessoF.setText("Femmina");

        lblComuneNas.setLabelFor(fldComune);
        lblComuneNas.setText("Comune di nascita");

        lblCodiceFiscale.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblCodiceFiscale.setForeground(new java.awt.Color(0, 0, 204));
        lblCodiceFiscale.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCodiceFiscale.setToolTipText("Codice Fiscale");
        lblCodiceFiscale.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnEsci.setText("Esci");
        btnEsci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEsciActionPerformed(evt);
            }
        });

        btnCalcola.setText("Calcola");
        btnCalcola.setToolTipText("esegue il calcolo del codice fiscale");
        btnCalcola.setName("btnCalcola"); // NOI18N
        btnCalcola.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcolaActionPerformed(evt);
            }
        });

        lblLogo.setIcon(new javax.swing.ImageIcon("E:\\Dropbox\\ComputerScience\\NetBeansProjects\\CodiceFiscaleApp\\logo.gif")); // NOI18N

        fldComune.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fldComuneActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCognome)
                            .addComponent(lblNome)
                            .addComponent(lblDataNas)
                            .addComponent(lblComuneNas)
                            .addComponent(lblSesso))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(fldDataNas, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(rbSessoF)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(rbSessoM))
                                        .addComponent(fldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(fldCognome, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(fldComune))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblLogo)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(btnEsci, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(36, 36, 36)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnCalcola, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblCodiceFiscale, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(32, 32, 32))))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnCalcola, btnEsci});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCognome)
                            .addComponent(fldCognome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNome)
                            .addComponent(fldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSesso)
                            .addComponent(rbSessoM)
                            .addComponent(rbSessoF))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDataNas)
                            .addComponent(fldDataNas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 9, Short.MAX_VALUE)
                        .addComponent(btnEsci, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblLogo)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblComuneNas)
                    .addComponent(btnCalcola)
                    .addComponent(fldComune, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addComponent(lblCodiceFiscale, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnCalcola, btnEsci});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbSessoMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbSessoMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbSessoMActionPerformed

    private void btnCalcolaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcolaActionPerformed
        String cognome, nome, sesso, dataNas, comNas;
        cognome = fldCognome.getText();
        nome = fldNome.getText();
        sesso = ( rbSessoM.isSelected() ? "M" : "F" );
        dataNas = fldDataNas.getText();
        comNas = fldComune.getText();
        model.Anagrafica ana = new model.Anagrafica(cognome, nome, sesso, dataNas, "Italy", comNas);
        model.CodiceFiscale cf = new model.CodiceFiscale(ana);
        lblCodiceFiscale.setText(cf.getCodice());
    }//GEN-LAST:event_btnCalcolaActionPerformed

    private void fldCognomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fldCognomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fldCognomeActionPerformed

    private void fldNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fldNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fldNomeActionPerformed

    private void btnEsciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEsciActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnEsciActionPerformed

    private void fldComuneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fldComuneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fldComuneActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GuiInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GuiInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GuiInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GuiInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GuiInterface().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalcola;
    private javax.swing.JButton btnEsci;
    private javax.swing.ButtonGroup buttonGroupSesso;
    private javax.swing.JTextField fldCognome;
    private javax.swing.JTextField fldComune;
    private javax.swing.JTextField fldDataNas;
    private javax.swing.JTextField fldNome;
    private javax.swing.JLabel lblCodiceFiscale;
    private javax.swing.JLabel lblCognome;
    private javax.swing.JLabel lblComuneNas;
    private javax.swing.JLabel lblDataNas;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblSesso;
    private javax.swing.JRadioButton rbSessoF;
    private javax.swing.JRadioButton rbSessoM;
    // End of variables declaration//GEN-END:variables
}
