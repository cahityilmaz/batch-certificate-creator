package com.capp.batchcertcreator;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Box;
import javax.swing.JButton;

/**
 *
 * @author mucahit.yilmaz
 */
public class DNCreatorPanel extends javax.swing.JPanel {

    private final Box container = Box.createVerticalBox();

    /**
     * Creates new form DNCreatorPanel
     */
    public DNCreatorPanel() {
        initComponents();
        add(container, BorderLayout.PAGE_START);
        NewRDNPanelAction newRDNPanelAction = new NewRDNPanelAction();
        newRDNPanelAction.actionPerformed(null);
        newRDNPanelAction.actionPerformed(null);
        newRDNPanelAction.actionPerformed(null);
        newRDNPanelAction.actionPerformed(null);
    }

    public String getSubject() {
        var subject = new StringBuilder();
        for (int i = container.getComponentCount() - 1; i >= 0; i--) {
            RDNPanel panel = (RDNPanel) container.getComponent(i);
            subject.append(panel.getRDNStringRepresentation());
        }
        return subject.substring(0, subject.length() - 1);
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The
     * content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonsPnl = new javax.swing.JPanel();
        createBtn = new org.jdesktop.swingx.JXButton();
        closeBtn = new org.jdesktop.swingx.JXButton();

        setName("Form"); // NOI18N
        setLayout(new java.awt.BorderLayout());

        buttonsPnl.setName("buttonsPnl"); // NOI18N
        buttonsPnl.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("com/capp/batchcertcreator/Bundle"); // NOI18N
        createBtn.setText(bundle.getString("DNCreatorPanel.createBtn.text")); // NOI18N
        createBtn.setName("createBtn"); // NOI18N
        createBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createBtnActionPerformed(evt);
            }
        });
        buttonsPnl.add(createBtn);

        closeBtn.setText(bundle.getString("DNCreatorPanel.closeBtn.text")); // NOI18N
        closeBtn.setName("closeBtn"); // NOI18N
        buttonsPnl.add(closeBtn);

        add(buttonsPnl, java.awt.BorderLayout.PAGE_END);
    }// </editor-fold>//GEN-END:initComponents

    private void createBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createBtnActionPerformed
        System.out.println(getSubject());
    }//GEN-LAST:event_createBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel buttonsPnl;
    private org.jdesktop.swingx.JXButton closeBtn;
    private org.jdesktop.swingx.JXButton createBtn;
    // End of variables declaration//GEN-END:variables
    private class NewRDNPanelAction extends AbstractAction {

        public NewRDNPanelAction() {
            this.putValue(NAME, "+");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            var panel = new RDNPanel();
            panel.getNewBtn().setAction(new NewRDNPanelAction());
            panel.getRemoveBtn().setAction(new RemoveRDNPanelAction());
            container.add(panel);
            container.repaint();
            container.revalidate();
        }

    }

    private class RemoveRDNPanelAction extends AbstractAction {

        public RemoveRDNPanelAction() {
            this.putValue(NAME, "-");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton) e.getSource();
            Component component = source.getParent();
            container.remove(component);
            container.repaint();
            container.revalidate();
        }

    }
}
