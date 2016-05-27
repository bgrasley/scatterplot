/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scatterplot;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author grasleb
 */
public class PointCapture extends javax.swing.JFrame {

    private int xMin = 0;
    private int xMax = 100;
    private int yMin = 0;
    private int yMax = 100;

    private Graphics plotGraph;

    /**
     * Creates new form PointCapture
     */
    public PointCapture() {
        initComponents();
        plotGraph = plotAreaLabel.getGraphics();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        messageLabel = new javax.swing.JLabel();
        plotAreaLabel = new javax.swing.JPanel();
        parameterPanel = new javax.swing.JPanel();
        xMinLabel = new javax.swing.JLabel();
        xMinField = new javax.swing.JTextField();
        yMinLabel = new javax.swing.JLabel();
        yMinField = new javax.swing.JTextField();
        saveButton = new javax.swing.JButton();
        xMaxLabel = new javax.swing.JLabel();
        xMaxField = new javax.swing.JTextField();
        yMaxLabel = new javax.swing.JLabel();
        yMaxField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1280, 720));

        messageLabel.setMinimumSize(new java.awt.Dimension(15, 15));
        getContentPane().add(messageLabel, java.awt.BorderLayout.PAGE_END);

        plotAreaLabel.setBackground(new java.awt.Color(255, 255, 255));
        plotAreaLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                plotAreaLabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout plotAreaLabelLayout = new javax.swing.GroupLayout(plotAreaLabel);
        plotAreaLabel.setLayout(plotAreaLabelLayout);
        plotAreaLabelLayout.setHorizontalGroup(
            plotAreaLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 515, Short.MAX_VALUE)
        );
        plotAreaLabelLayout.setVerticalGroup(
            plotAreaLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 276, Short.MAX_VALUE)
        );

        getContentPane().add(plotAreaLabel, java.awt.BorderLayout.CENTER);

        parameterPanel.setLayout(new java.awt.GridLayout(2, 4));

        xMinLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        xMinLabel.setText("xMin:");
        parameterPanel.add(xMinLabel);

        xMinField.setText("0");
        xMinField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xMinFieldActionPerformed(evt);
            }
        });
        parameterPanel.add(xMinField);

        yMinLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        yMinLabel.setText("yMin:");
        parameterPanel.add(yMinLabel);

        yMinField.setText("0");
        yMinField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yMinFieldActionPerformed(evt);
            }
        });
        parameterPanel.add(yMinField);

        saveButton.setText("Save Image");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });
        parameterPanel.add(saveButton);

        xMaxLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        xMaxLabel.setText("xMax:");
        parameterPanel.add(xMaxLabel);

        xMaxField.setText("100");
        xMaxField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xMaxFieldActionPerformed(evt);
            }
        });
        parameterPanel.add(xMaxField);

        yMaxLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        yMaxLabel.setText("yMax:");
        parameterPanel.add(yMaxLabel);

        yMaxField.setText("100");
        yMaxField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yMaxFieldActionPerformed(evt);
            }
        });
        parameterPanel.add(yMaxField);

        getContentPane().add(parameterPanel, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void xMinFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xMinFieldActionPerformed
        updateLimits();
    }//GEN-LAST:event_xMinFieldActionPerformed

    private void plotAreaLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_plotAreaLabelMouseClicked
        int x = evt.getX();
        int y = evt.getY();
        int h = plotAreaLabel.getHeight();
        int w = plotAreaLabel.getWidth();
        int yPos = yMin + (yMax - yMin) * (h - y) / h;
        int xPos = xMin + (xMax - xMin) * x / w;

        plotGraph.fillOval(x, y, 10, 10);
        System.out.println(xPos + "\t" + yPos);

    }//GEN-LAST:event_plotAreaLabelMouseClicked

    private void xMaxFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xMaxFieldActionPerformed
        updateLimits();
    }//GEN-LAST:event_xMaxFieldActionPerformed

    private void yMinFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yMinFieldActionPerformed
        updateLimits();
    }//GEN-LAST:event_yMinFieldActionPerformed

    private void yMaxFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yMaxFieldActionPerformed
        updateLimits();
    }//GEN-LAST:event_yMaxFieldActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        messageLabel.setText("Not implemented yet");
    }//GEN-LAST:event_saveButtonActionPerformed

    private void updateLimits() {
        int xMinTemp, xMaxTemp, yMinTemp, yMaxTemp = 0;

        try {
            xMinTemp = Integer.parseInt(xMinField.getText());
            xMaxTemp = Integer.parseInt(xMaxField.getText());
            yMinTemp = Integer.parseInt(yMinField.getText());
            yMaxTemp = Integer.parseInt(yMaxField.getText());

            if (xMinTemp < xMaxTemp && yMinTemp < yMaxTemp) {
                xMin = xMinTemp;
                xMax = xMaxTemp;
                yMin = yMinTemp;
                yMax = yMaxTemp;
                messageLabel.setText("");
            }
        } catch (NumberFormatException nfe) {
            messageLabel.setText("Scale limits are not valid");
        }
    }

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
            java.util.logging.Logger.getLogger(PointCapture.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PointCapture.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PointCapture.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PointCapture.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PointCapture().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel messageLabel;
    private javax.swing.JPanel parameterPanel;
    private javax.swing.JPanel plotAreaLabel;
    private javax.swing.JButton saveButton;
    private javax.swing.JTextField xMaxField;
    private javax.swing.JLabel xMaxLabel;
    private javax.swing.JTextField xMinField;
    private javax.swing.JLabel xMinLabel;
    private javax.swing.JTextField yMaxField;
    private javax.swing.JLabel yMaxLabel;
    private javax.swing.JTextField yMinField;
    private javax.swing.JLabel yMinLabel;
    // End of variables declaration//GEN-END:variables
}
