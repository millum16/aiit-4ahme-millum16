/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stoppuhr.gui;

import java.awt.Dimension;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import stoppuhr.ConnectionWorker;
import stoppuhr.Server.Response;

/**
 *
 * @author lukasmilhalm
 */
public class GUIStoppuhr extends javax.swing.JFrame {

    /**
     * Creates new form GUI_Stoppuhr
     */
    public GUIStoppuhr() {
        initComponents();
        setTitle("GUI");
        setMaximumSize(new Dimension(400, 350));
        setLocationRelativeTo(null);

        jButtonConnect.setEnabled(true);
        jButtonDisconnect.setEnabled(false);
        jButtonStart.setEnabled(false);
        jButtonStop.setEnabled(false);
        jButtonClear.setEnabled(false);
        jButtonEnd.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanNorth = new javax.swing.JPanel();
        jSlider1 = new javax.swing.JSlider();
        Refreshrate = new javax.swing.JLabel();
        ms = new javax.swing.JLabel();
        jPanEast = new javax.swing.JPanel();
        jButtonConnect = new javax.swing.JButton();
        jButtonDisconnect = new javax.swing.JButton();
        jButtonStart = new javax.swing.JButton();
        jButtonStop = new javax.swing.JButton();
        jButtonClear = new javax.swing.JButton();
        jButtonEnd = new javax.swing.JButton();
        jPanWest = new javax.swing.JPanel();
        jLabCounter = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanNorth.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 50;
        jPanNorth.add(jSlider1, gridBagConstraints);

        Refreshrate.setText("Refreshrate  1s");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        jPanNorth.add(Refreshrate, gridBagConstraints);

        ms.setText("1ms");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        jPanNorth.add(ms, gridBagConstraints);

        getContentPane().add(jPanNorth, java.awt.BorderLayout.NORTH);

        jPanEast.setLayout(new java.awt.GridBagLayout());

        jButtonConnect.setText("Connect");
        jButtonConnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConnectActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 15);
        jPanEast.add(jButtonConnect, gridBagConstraints);

        jButtonDisconnect.setText("Disconnect");
        jButtonDisconnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDisconnectActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 15);
        jPanEast.add(jButtonDisconnect, gridBagConstraints);

        jButtonStart.setText("Start");
        jButtonStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStartActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 15);
        jPanEast.add(jButtonStart, gridBagConstraints);

        jButtonStop.setText("Stop");
        jButtonStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStopActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 15);
        jPanEast.add(jButtonStop, gridBagConstraints);

        jButtonClear.setText("Clear");
        jButtonClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClearActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 15);
        jPanEast.add(jButtonClear, gridBagConstraints);

        jButtonEnd.setText("End");
        jButtonEnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEndActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 15);
        jPanEast.add(jButtonEnd, gridBagConstraints);

        getContentPane().add(jPanEast, java.awt.BorderLayout.EAST);

        jPanWest.setLayout(new java.awt.GridBagLayout());

        jLabCounter.setFont(new java.awt.Font("Lucida Grande", 0, 48)); // NOI18N
        jLabCounter.setText("0.000");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanWest.add(jLabCounter, gridBagConstraints);

        getContentPane().add(jPanWest, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonConnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConnectActionPerformed
        System.out.println("Button pressed" + Thread.currentThread().getId());
        ConnectionWorker worker = null;
        try {
            worker = new MyConnectionWorker(8080, "127.0.0.1");
            worker.execute();
        } catch (IOException ex) {
            Logger.getLogger(GUIStoppuhr.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Verbindung konnte nicht hergestellt werden!", "Fehler", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonConnectActionPerformed

    private void jButtonDisconnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDisconnectActionPerformed

    }//GEN-LAST:event_jButtonDisconnectActionPerformed

    private void jButtonStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStartActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonStartActionPerformed

    private void jButtonStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStopActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonStopActionPerformed

    private void jButtonClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonClearActionPerformed

    private void jButtonEndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEndActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonEndActionPerformed

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
            java.util.logging.Logger.getLogger(GUIStoppuhr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIStoppuhr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIStoppuhr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIStoppuhr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIStoppuhr().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Refreshrate;
    private javax.swing.JButton jButtonClear;
    private javax.swing.JButton jButtonConnect;
    private javax.swing.JButton jButtonDisconnect;
    private javax.swing.JButton jButtonEnd;
    private javax.swing.JButton jButtonStart;
    private javax.swing.JButton jButtonStop;
    private javax.swing.JLabel jLabCounter;
    private javax.swing.JPanel jPanEast;
    private javax.swing.JPanel jPanNorth;
    private javax.swing.JPanel jPanWest;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JLabel ms;
    // End of variables declaration//GEN-END:variables

    private class MyConnectionWorker extends ConnectionWorker {

        public MyConnectionWorker(int port, String hostname) throws IOException {
            super(port, hostname);
        }

        @Override
        protected void done() {

            try {
                get();
                System.out.println("Thread beendet" + Thread.currentThread().getId());
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(GUIStoppuhr.this, "Fehler beim Beenden", "Fehler", JOptionPane.ERROR_MESSAGE);
            }
        }

        @Override
        protected void process(List<Response> chunks) {
            for (Response x : chunks) {
                System.out.println("Process " + x + "Thread " + Thread.currentThread().getId());
                if (x.isMaster()) {
                    jButtonStart.setEnabled(true);
                    jButtonStop.setEnabled(true);
                    jButtonClear.setEnabled(true);
                    jButtonEnd.setEnabled(true);
                    jButtonDisconnect.setEnabled(true);
                    jButtonConnect.setEnabled(false);
                } else {
                    jButtonStart.setEnabled(false);
                    jButtonStop.setEnabled(false);
                    jButtonClear.setEnabled(false);
                    jButtonEnd.setEnabled(false);
                    jButtonDisconnect.setEnabled(true);
                    jButtonConnect.setEnabled(false);
                }

                if (x.isRunning()) {
                    jButtonStart.setEnabled(false);
                    jButtonStop.setEnabled(true);
                    jButtonClear.setEnabled(true);
                } else {
                    jButtonStart.setEnabled(true);
                    jButtonStop.setEnabled(false);
                    jButtonClear.setEnabled(false);
                }

                //jLabCounter.setText(x.time);
            }
        }
    }
}
