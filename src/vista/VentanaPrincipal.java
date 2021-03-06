/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ViviendaDAO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Vivienda;

/**
 *
 * @author Matio_000
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form VentanaPrincipal
     */
    public VentanaPrincipal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        mnqVivienda = new javax.swing.JMenu();
        mnuVenta = new javax.swing.JMenuItem();
        mnuDepartamentos = new javax.swing.JMenuItem();
        mnqVer = new javax.swing.JMenu();
        mnuTotal = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mnqVivienda.setText("Vivienda");

        mnuVenta.setText("Vender Vivienda");
        mnuVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuVentaActionPerformed(evt);
            }
        });
        mnqVivienda.add(mnuVenta);

        mnuDepartamentos.setText("Cantidad de Departamentos Vendidos");
        mnuDepartamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuDepartamentosActionPerformed(evt);
            }
        });
        mnqVivienda.add(mnuDepartamentos);

        jMenuBar1.add(mnqVivienda);

        mnqVer.setText("Ver");

        mnuTotal.setText("Ventas Realizadas");
        mnuTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuTotalActionPerformed(evt);
            }
        });
        mnqVer.add(mnuTotal);

        jMenuBar1.add(mnqVer);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 277, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuVentaActionPerformed
        VentanaIngreso ven=new VentanaIngreso();
        ven.setVisible(true);
        ven.setLocationRelativeTo(null);
        ven.setTitle("Ingreso Venta");
        ven.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }//GEN-LAST:event_mnuVentaActionPerformed

    private void mnuDepartamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuDepartamentosActionPerformed
        ViviendaDAO vivDAO=new ViviendaDAO();
        ArrayList <Vivienda>viv=vivDAO.mostrartodos();
        int cont=0;
        for (int i = 0; i < viv.size(); i++) {
            if(viv.get(i).getTipovivienda().compareToIgnoreCase("Departamento")==0)
                cont++;
        }
        JOptionPane.showMessageDialog(this, "Hay "+cont+" Departamentos Vendidos", "TOTAL DEPARTAMENTOS VENDIDOS", JOptionPane.INFORMATION_MESSAGE);
        
        
        
    }//GEN-LAST:event_mnuDepartamentosActionPerformed

    private void mnuTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuTotalActionPerformed
        VentanaMostrar ven=new VentanaMostrar();
        ven.setVisible(true);
        ven.setLocationRelativeTo(null);
        ven.setTitle("Ventas");
        ven.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE); 
    }//GEN-LAST:event_mnuTotalActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu mnqVer;
    private javax.swing.JMenu mnqVivienda;
    private javax.swing.JMenuItem mnuDepartamentos;
    private javax.swing.JMenuItem mnuTotal;
    private javax.swing.JMenuItem mnuVenta;
    // End of variables declaration//GEN-END:variables
}
