package com.capp.batchcertcreator;

import java.io.File;
import java.io.FileOutputStream;
import java.math.BigInteger;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.DERUTF8String;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.BasicConstraints;
import org.bouncycastle.asn1.x509.ExtendedKeyUsage;
import org.bouncycastle.asn1.x509.Extension;
import org.bouncycastle.asn1.x509.GeneralName;
import org.bouncycastle.asn1.x509.GeneralNames;
import org.bouncycastle.asn1.x509.KeyPurposeId;
import org.bouncycastle.asn1.x509.KeyUsage;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cert.X509v3CertificateBuilder;
import org.bouncycastle.cert.jcajce.JcaX509CertificateConverter;
import org.bouncycastle.cert.jcajce.JcaX509ExtensionUtils;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;

/**
 *
 * @author mucahit.yilmaz
 */
public class BatchCertificateCreatePanel extends javax.swing.JPanel {

    public static final ASN1ObjectIdentifier MSUPN_OID = new ASN1ObjectIdentifier("1.3.6.1.4.1.311.20.2.3");
    private static final char[] EMPTY_PASSWORD = new char[0];
    KeyPairGenerator keyGen;
    private PrivateKey issuerPrivateKey;
    private X509Certificate issuerCertificate;

    /**
     * Creates new form BatchCertificateCreatePanel
     */
    public BatchCertificateCreatePanel() {
        initComponents();
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        validFromDatePicker.setDate(c.getTime());
        c.add(Calendar.YEAR, 1);
        validUntilDatePicker.setDate(c.getTime());
    }

    private KeyStore createEmptyKeyStore() throws Exception {
        KeyStore keyStore = KeyStore.getInstance("PKCS12");
        keyStore.load(null, EMPTY_PASSWORD);
        return keyStore;
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The
     * content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        extensionBtnGrp = new javax.swing.ButtonGroup();
        javax.swing.JPanel userInfoPanel = new javax.swing.JPanel();
        javax.swing.JLabel cnPrefixLbl = new javax.swing.JLabel();
        cnPrefixTf = new javax.swing.JTextField();
        domainTf = new javax.swing.JTextField();
        javax.swing.JLabel domainLbl = new javax.swing.JLabel();
        startIndexTf = new javax.swing.JTextField();
        javax.swing.JLabel startIndexLbl = new javax.swing.JLabel();
        javax.swing.JLabel endIndexLbl = new javax.swing.JLabel();
        endIndexTf = new javax.swing.JTextField();
        javax.swing.JLabel organizationLbl = new javax.swing.JLabel();
        organizationTf = new javax.swing.JTextField();
        javax.swing.JLabel countryLbl = new javax.swing.JLabel();
        countryTf = new javax.swing.JTextField();
        javax.swing.JPanel certInfoPanel = new javax.swing.JPanel();
        javax.swing.JLabel keyStorePathLbl = new javax.swing.JLabel();
        keyStorePathTf = new javax.swing.JTextField();
        keyStoreSelectBtn = new javax.swing.JButton();
        javax.swing.JLabel caFilePathLbl = new javax.swing.JLabel();
        caFilePathTf = new javax.swing.JTextField();
        caFilePathSelectBtn = new javax.swing.JButton();
        javax.swing.JLabel keySizeLbl = new javax.swing.JLabel();
        keySizeSpn = new javax.swing.JSpinner();
        javax.swing.JLabel sigAlgLbl = new javax.swing.JLabel();
        sigAlgCmb = new javax.swing.JComboBox<>();
        javax.swing.JLabel validDateStartLbl = new javax.swing.JLabel();
        javax.swing.JLabel validDateEndLbl = new javax.swing.JLabel();
        javax.swing.JLabel caCertPasswordLbl = new javax.swing.JLabel();
        caCertPasswordTf = new javax.swing.JTextField();
        validFromDatePicker = new org.jdesktop.swingx.JXDatePicker();
        validUntilDatePicker = new org.jdesktop.swingx.JXDatePicker();
        certPasswordLbl = new javax.swing.JLabel();
        certPasswordTf = new javax.swing.JTextField();
        certExtensionLbl = new javax.swing.JLabel();
        certExtensionPfxRd = new javax.swing.JRadioButton();
        certExtensionP12Rd = new javax.swing.JRadioButton();
        certSaveFolderLbl = new javax.swing.JLabel();
        certSaveFolder = new javax.swing.JTextField();
        certSaveFolderSelectBtn = new javax.swing.JButton();
        createBtn = new javax.swing.JButton();

        setName("Form"); // NOI18N

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("com/capp/batchcertcreator/Bundle"); // NOI18N
        userInfoPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, bundle.getString("BatchCertificateCreatePanel.userInfoPanel.border.title"), javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION)); // NOI18N
        userInfoPanel.setName("userInfoPanel"); // NOI18N

        cnPrefixLbl.setText(bundle.getString("BatchCertificateCreatePanel.cnPrefixLbl.text")); // NOI18N
        cnPrefixLbl.setName("cnPrefixLbl"); // NOI18N

        cnPrefixTf.setText("testuser"); // NOI18N
        cnPrefixTf.setName("cnPrefixTf"); // NOI18N

        domainTf.setName("domainTf"); // NOI18N

        domainLbl.setText(bundle.getString("BatchCertificateCreatePanel.domainLbl.text")); // NOI18N
        domainLbl.setName("domainLbl"); // NOI18N

        startIndexTf.setText("1"); // NOI18N
        startIndexTf.setName("startIndexTf"); // NOI18N

        startIndexLbl.setText(bundle.getString("BatchCertificateCreatePanel.startIndexLbl.text")); // NOI18N
        startIndexLbl.setName("startIndexLbl"); // NOI18N

        endIndexLbl.setText(bundle.getString("BatchCertificateCreatePanel.endIndexLbl.text")); // NOI18N
        endIndexLbl.setName("endIndexLbl"); // NOI18N

        endIndexTf.setText("100"); // NOI18N
        endIndexTf.setName("endIndexTf"); // NOI18N

        organizationLbl.setText(bundle.getString("BatchCertificateCreatePanel.organizationLbl.text")); // NOI18N
        organizationLbl.setName("organizationLbl"); // NOI18N

        organizationTf.setName("organizationTf"); // NOI18N

        countryLbl.setText(bundle.getString("BatchCertificateCreatePanel.countryLbl.text")); // NOI18N
        countryLbl.setName("countryLbl"); // NOI18N

        countryTf.setName("countryTf"); // NOI18N

        javax.swing.GroupLayout userInfoPanelLayout = new javax.swing.GroupLayout(userInfoPanel);
        userInfoPanel.setLayout(userInfoPanelLayout);
        userInfoPanelLayout.setHorizontalGroup(
            userInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userInfoPanelLayout.createSequentialGroup()
                .addGroup(userInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(userInfoPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(userInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(domainLbl)
                            .addComponent(startIndexLbl)
                            .addComponent(endIndexLbl)))
                    .addGroup(userInfoPanelLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(cnPrefixLbl))
                    .addGroup(userInfoPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(organizationLbl))
                    .addGroup(userInfoPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(countryLbl)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(userInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cnPrefixTf)
                    .addComponent(domainTf)
                    .addComponent(startIndexTf)
                    .addComponent(endIndexTf)
                    .addComponent(organizationTf)
                    .addComponent(countryTf))
                .addContainerGap())
        );
        userInfoPanelLayout.setVerticalGroup(
            userInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userInfoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(userInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cnPrefixLbl)
                    .addComponent(cnPrefixTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(userInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(domainTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(domainLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(userInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(startIndexTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(startIndexLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(userInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(endIndexLbl)
                    .addComponent(endIndexTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(userInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(organizationLbl)
                    .addComponent(organizationTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(userInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(countryLbl)
                    .addComponent(countryTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        certInfoPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, bundle.getString("BatchCertificateCreatePanel.certInfoPanel.border.title"), javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION)); // NOI18N
        certInfoPanel.setName("certInfoPanel"); // NOI18N

        keyStorePathLbl.setText(bundle.getString("BatchCertificateCreatePanel.keyStorePathLbl.text")); // NOI18N
        keyStorePathLbl.setName("keyStorePathLbl"); // NOI18N

        keyStorePathTf.setEditable(false);
        keyStorePathTf.setName("keyStorePathTf"); // NOI18N

        keyStoreSelectBtn.setText(bundle.getString("BatchCertificateCreatePanel.keyStoreSelectBtn.text")); // NOI18N
        keyStoreSelectBtn.setName("keyStoreSelectBtn"); // NOI18N
        keyStoreSelectBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keyStoreSelectBtnActionPerformed(evt);
            }
        });

        caFilePathLbl.setText(bundle.getString("BatchCertificateCreatePanel.caFilePathLbl.text")); // NOI18N
        caFilePathLbl.setName("caFilePathLbl"); // NOI18N

        caFilePathTf.setEditable(false);
        caFilePathTf.setName("caFilePathTf"); // NOI18N

        caFilePathSelectBtn.setText(bundle.getString("BatchCertificateCreatePanel.caFilePathSelectBtn.text")); // NOI18N
        caFilePathSelectBtn.setName("caFilePathSelectBtn"); // NOI18N
        caFilePathSelectBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caFilePathSelectBtnActionPerformed(evt);
            }
        });

        keySizeLbl.setText(bundle.getString("BatchCertificateCreatePanel.keySizeLbl.text")); // NOI18N
        keySizeLbl.setName("keySizeLbl"); // NOI18N

        keySizeSpn.setModel(new javax.swing.SpinnerNumberModel(1024, 1024, 4096, 1024));
        keySizeSpn.setEditor(new javax.swing.JSpinner.NumberEditor(keySizeSpn, ""));
        keySizeSpn.setName("keySizeSpn"); // NOI18N

        sigAlgLbl.setText(bundle.getString("BatchCertificateCreatePanel.sigAlgLbl.text")); // NOI18N
        sigAlgLbl.setName("sigAlgLbl"); // NOI18N

        sigAlgCmb.setModel(com.capp.batchcertcreator.SignatureAlgorithm.createComboboxModel());
        sigAlgCmb.setName("sigAlgCmb"); // NOI18N

        validDateStartLbl.setText(bundle.getString("BatchCertificateCreatePanel.validDateStartLbl.text")); // NOI18N
        validDateStartLbl.setName("validDateStartLbl"); // NOI18N

        validDateEndLbl.setText(bundle.getString("BatchCertificateCreatePanel.validDateEndLbl.text")); // NOI18N
        validDateEndLbl.setName("validDateEndLbl"); // NOI18N

        caCertPasswordLbl.setText(bundle.getString("BatchCertificateCreatePanel.caCertPasswordLbl.text")); // NOI18N
        caCertPasswordLbl.setName("caCertPasswordLbl"); // NOI18N

        caCertPasswordTf.setName("caCertPasswordTf"); // NOI18N

        validFromDatePicker.setName("validFromDatePicker"); // NOI18N

        validUntilDatePicker.setName("validUntilDatePicker"); // NOI18N

        certPasswordLbl.setText(bundle.getString("BatchCertificateCreatePanel.certPasswordLbl.text")); // NOI18N
        certPasswordLbl.setName("certPasswordLbl"); // NOI18N

        certPasswordTf.setName("certPasswordTf"); // NOI18N

        certExtensionLbl.setText(bundle.getString("BatchCertificateCreatePanel.certExtensionLbl.text")); // NOI18N
        certExtensionLbl.setName("certExtensionLbl"); // NOI18N

        extensionBtnGrp.add(certExtensionPfxRd);
        certExtensionPfxRd.setSelected(true);
        certExtensionPfxRd.setText("pfx"); // NOI18N
        certExtensionPfxRd.setActionCommand(".pfx"); // NOI18N
        certExtensionPfxRd.setName("certExtensionPfxRd"); // NOI18N

        extensionBtnGrp.add(certExtensionP12Rd);
        certExtensionP12Rd.setText("p12"); // NOI18N
        certExtensionP12Rd.setActionCommand(".p12"); // NOI18N
        certExtensionP12Rd.setName("certExtensionP12Rd"); // NOI18N

        certSaveFolderLbl.setText(bundle.getString("BatchCertificateCreatePanel.certSaveFolderLbl.text")); // NOI18N
        certSaveFolderLbl.setName("certSaveFolderLbl"); // NOI18N

        certSaveFolder.setName("certSaveFolder"); // NOI18N

        certSaveFolderSelectBtn.setText(bundle.getString("BatchCertificateCreatePanel.certSaveFolderSelectBtn.text")); // NOI18N
        certSaveFolderSelectBtn.setName("certSaveFolderSelectBtn"); // NOI18N
        certSaveFolderSelectBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                certSaveFolderSelectBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout certInfoPanelLayout = new javax.swing.GroupLayout(certInfoPanel);
        certInfoPanel.setLayout(certInfoPanelLayout);
        certInfoPanelLayout.setHorizontalGroup(
            certInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(certInfoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(certInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(certPasswordLbl)
                    .addComponent(certExtensionLbl)
                    .addComponent(caFilePathLbl)
                    .addComponent(keySizeLbl)
                    .addComponent(sigAlgLbl)
                    .addComponent(validDateStartLbl)
                    .addComponent(validDateEndLbl)
                    .addComponent(caCertPasswordLbl)
                    .addComponent(keyStorePathLbl)
                    .addComponent(certSaveFolderLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(certInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(validFromDatePicker, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
                    .addComponent(validUntilDatePicker, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(caFilePathTf)
                    .addComponent(caCertPasswordTf)
                    .addComponent(keyStorePathTf)
                    .addComponent(sigAlgCmb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(certInfoPanelLayout.createSequentialGroup()
                        .addComponent(certExtensionPfxRd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(certExtensionP12Rd)
                        .addGap(0, 0, 0))
                    .addComponent(keySizeSpn)
                    .addComponent(certPasswordTf)
                    .addComponent(certSaveFolder))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(certInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(caFilePathSelectBtn)
                    .addComponent(keyStoreSelectBtn)
                    .addComponent(certSaveFolderSelectBtn))
                .addContainerGap())
        );
        certInfoPanelLayout.setVerticalGroup(
            certInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(certInfoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(certInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(keySizeLbl)
                    .addComponent(keySizeSpn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(certInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sigAlgLbl)
                    .addComponent(sigAlgCmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(certInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(validDateStartLbl)
                    .addComponent(validFromDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(certInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(validDateEndLbl)
                    .addComponent(validUntilDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(certInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(caFilePathLbl)
                    .addComponent(caFilePathTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(caFilePathSelectBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(certInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(caCertPasswordLbl)
                    .addComponent(caCertPasswordTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(certInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(certPasswordLbl)
                    .addComponent(certPasswordTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(certInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(certExtensionLbl)
                    .addComponent(certExtensionPfxRd)
                    .addComponent(certExtensionP12Rd))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(certInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(keyStorePathLbl)
                    .addComponent(keyStorePathTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(keyStoreSelectBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(certInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(certSaveFolderLbl)
                    .addComponent(certSaveFolder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(certSaveFolderSelectBtn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        createBtn.setText(bundle.getString("BatchCertificateCreatePanel.createBtn.text")); // NOI18N
        createBtn.setName("createBtn"); // NOI18N
        createBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userInfoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(certInfoPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(createBtn)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(userInfoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(certInfoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(createBtn)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void keyStoreSelectBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keyStoreSelectBtnActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("KeyStore Dosyasının Kayıt Yerini Seçiniz");
        fileChooser.setMultiSelectionEnabled(false);
        int showSaveDialog = fileChooser.showSaveDialog(this);
        if (showSaveDialog == JFileChooser.APPROVE_OPTION) {
            keyStorePathTf.setText(fileChooser.getSelectedFile().getAbsolutePath());
        }
    }//GEN-LAST:event_keyStoreSelectBtnActionPerformed

    private void caFilePathSelectBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caFilePathSelectBtnActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Kök Sertifika Seçiniz");
        fileChooser.setMultiSelectionEnabled(false);
        int showSaveDialog = fileChooser.showOpenDialog(this);
        if (showSaveDialog == JFileChooser.APPROVE_OPTION) {
            caFilePathTf.setText(fileChooser.getSelectedFile().getAbsolutePath());
        }
    }//GEN-LAST:event_caFilePathSelectBtnActionPerformed

    private long getIdentityNo() {
        int identityNoSuffixLength = endIndexTf.getText().length();
        String identityNoStr = "11111111111";
        CharSequence subSequence = identityNoStr.subSequence(0, identityNoStr.length() - identityNoSuffixLength);
        identityNoStr = subSequence + "0".repeat(identityNoSuffixLength);
        return Long.parseLong(identityNoStr);
    }

    private List<CertInfo> createCertInfos() {
        var list = new ArrayList<CertInfo>();
        int startIndex = Integer.parseInt(startIndexTf.getText());
        int endIndex = Integer.parseInt(endIndexTf.getText());
        long identityNo = getIdentityNo();
        for (int i = startIndex; i <= endIndex; i++) {
            identityNo++;
            var certInfo = new CertInfo()
                    .setCn(cnPrefixTf.getText() + i)
                    .setCountry(countryTf.getText())
                    .setOrganization(organizationTf.getText())
                    .setIdentityNo(String.valueOf(identityNo))
                    .setDomain(domainTf.getText())
                    .setKeySize(Integer.parseInt(keySizeSpn.getValue().toString()))
                    .setSerialNumber(BigInteger.valueOf(System.currentTimeMillis()))
                    .setSignatureAlgorithm(sigAlgCmb.getItemAt(sigAlgCmb.getSelectedIndex()).getValue())
                    .setValidFrom(validFromDatePicker.getDate())
                    .setValidUntil(validUntilDatePicker.getDate());
            certInfo.setIssuer(issuerCertificate == null ? certInfo.getSubject()
                    : new X500Name(issuerCertificate.getIssuerDN().getName()));
            list.add(certInfo);
        }
        return list;
    }

    private void loadIssuerCertificate() {
        try {
            var caFile = new File(caFilePathTf.getText());
            var caPwd = caCertPasswordTf.getText().toCharArray();
            var caStore = KeyStore.getInstance(caFile, caPwd);
            var alias = caStore.aliases().nextElement();
            issuerCertificate = (X509Certificate) caStore.getCertificate(alias);
            issuerPrivateKey = (PrivateKey) caStore.getKey(alias, caPwd);
        } catch (Exception ex) {
            Logger.getLogger(BatchCertificateCreatePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private GeneratedCert createCertificate(CertInfo info, ContentSigner signer) throws Exception {
        KeyPair keyPair = keyGen.generateKeyPair();

        JcaX509ExtensionUtils extensionUtils = new JcaX509ExtensionUtils();

        // The cert builder to build up our certificate information
        var builder = new X509v3CertificateBuilder(
                info.getIssuer(),
                info.getSerialNumber(),
                info.getValidFrom(),
                info.getValidUntil(),
                info.getSubject(),
                SubjectPublicKeyInfo.getInstance(keyPair.getPublic().getEncoded()));

        // subject alternative names
        if (info.getDomain() != null && !info.getDomain().isBlank()) {
            var domain = info.getDomain().contains("@") ? info.getDomain() : "@" + info.getDomain();
            var mail = info.getCn() + domain;
            GeneralName rfc822Name = new GeneralName(GeneralName.rfc822Name, mail);
            GeneralName otherName = new GeneralName(GeneralName.otherName, new DERSequence(
                    new ASN1Encodable[]{MSUPN_OID, new DERTaggedObject(0, new DERUTF8String(mail))}));
            builder.addExtension(Extension.subjectAlternativeName, false,
                    new GeneralNames(new GeneralName[]{rfc822Name, otherName}));
        }

        builder.addExtension(Extension.subjectKeyIdentifier, false,
                extensionUtils.createSubjectKeyIdentifier(keyPair.getPublic()));

        builder.addExtension(Extension.authorityKeyIdentifier, false,
                extensionUtils.createAuthorityKeyIdentifier(issuerCertificate));

        builder.addExtension(Extension.basicConstraints, true, new BasicConstraints(false));
        builder.addExtension(Extension.keyUsage, true, new KeyUsage(KeyUsage.digitalSignature | KeyUsage.keyEncipherment));
        builder.addExtension(Extension.extendedKeyUsage, false, new ExtendedKeyUsage(new KeyPurposeId[]{
            KeyPurposeId.id_kp_clientAuth,
            KeyPurposeId.id_kp_smartcardlogon,
            KeyPurposeId.id_kp_emailProtection}));

        // Finally, sign the certificate:
        X509CertificateHolder certHolder = builder.build(signer);
        X509Certificate cert = new JcaX509CertificateConverter().getCertificate(certHolder);

        return new GeneratedCert(keyPair.getPrivate(), cert);
    }

    private void exportUserCertificate(CertInfo certInfo, GeneratedCert generatedCert) {
        try {
            var keyStore = createEmptyKeyStore();
            char[] certsPassword = certPasswordTf.getText().toCharArray();
            keyStore.setKeyEntry(certInfo.getCn(), generatedCert.getPrivateKey(), certsPassword,
                        new X509Certificate[]{generatedCert.getCertificate(), issuerCertificate});
            var certFolder = certSaveFolder.getText();
            var file = certFolder + File.separator + certInfo.getCn() + extensionBtnGrp.getSelection().getActionCommand();
            try (var fos = new FileOutputStream(file)) {
                keyStore.store(fos, certsPassword);
            }
        } catch (Exception ex) {
            Logger.getLogger(BatchCertificateCreatePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void createBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createBtnActionPerformed
        try {
            loadIssuerCertificate();
            char[] certsPassword = certPasswordTf.getText().toCharArray();
            keyGen = KeyPairGenerator.getInstance("RSA");
            keyGen.initialize(Integer.parseInt(keySizeSpn.getValue().toString()), new SecureRandom());
            ContentSigner signer = new JcaContentSignerBuilder(sigAlgCmb.getItemAt(sigAlgCmb.getSelectedIndex()).getValue())
                    .build(issuerPrivateKey);
            KeyStore keyStore = createEmptyKeyStore();
            keyStore.setKeyEntry("CAKEY", issuerPrivateKey, certsPassword, new X509Certificate[]{issuerCertificate});
            var certInfos = createCertInfos();
            for (var certInfo : certInfos) {
                GeneratedCert generatedCert = createCertificate(certInfo, signer);
                keyStore.setKeyEntry(certInfo.getCn(), generatedCert.getPrivateKey(), certsPassword,
                        new X509Certificate[]{generatedCert.getCertificate(), issuerCertificate});
                exportUserCertificate(certInfo, generatedCert);
            }
            try (var fos = new FileOutputStream(keyStorePathTf.getText())) {
                keyStore.store(fos, certsPassword);
            }
        } catch (Exception ex) {
            Logger.getLogger(BatchCertificateCreatePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_createBtnActionPerformed

    private void certSaveFolderSelectBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_certSaveFolderSelectBtnActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Sertifikaların Kayıt Yerini Seçiniz");
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.setMultiSelectionEnabled(false);
        int showSaveDialog = fileChooser.showSaveDialog(this);
        if (showSaveDialog == JFileChooser.APPROVE_OPTION) {
            certSaveFolder.setText(fileChooser.getSelectedFile().getAbsolutePath());
        }
    }//GEN-LAST:event_certSaveFolderSelectBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField caCertPasswordTf;
    private javax.swing.JButton caFilePathSelectBtn;
    private javax.swing.JTextField caFilePathTf;
    private javax.swing.JLabel certExtensionLbl;
    private javax.swing.JRadioButton certExtensionP12Rd;
    private javax.swing.JRadioButton certExtensionPfxRd;
    private javax.swing.JLabel certPasswordLbl;
    private javax.swing.JTextField certPasswordTf;
    private javax.swing.JTextField certSaveFolder;
    private javax.swing.JLabel certSaveFolderLbl;
    private javax.swing.JButton certSaveFolderSelectBtn;
    private javax.swing.JTextField cnPrefixTf;
    private javax.swing.JTextField countryTf;
    private javax.swing.JButton createBtn;
    private javax.swing.JTextField domainTf;
    private javax.swing.JTextField endIndexTf;
    private javax.swing.ButtonGroup extensionBtnGrp;
    private javax.swing.JSpinner keySizeSpn;
    private javax.swing.JTextField keyStorePathTf;
    private javax.swing.JButton keyStoreSelectBtn;
    private javax.swing.JTextField organizationTf;
    private javax.swing.JComboBox<com.capp.batchcertcreator.SignatureAlgorithm> sigAlgCmb;
    private javax.swing.JTextField startIndexTf;
    private org.jdesktop.swingx.JXDatePicker validFromDatePicker;
    private org.jdesktop.swingx.JXDatePicker validUntilDatePicker;
    // End of variables declaration//GEN-END:variables

    private class GeneratedCert {

        private PrivateKey privateKey;
        private X509Certificate certificate;

        public GeneratedCert(PrivateKey privateKey, X509Certificate certificate) {
            this.privateKey = privateKey;
            this.certificate = certificate;
        }

        public PrivateKey getPrivateKey() {
            return privateKey;
        }

        public X509Certificate getCertificate() {
            return certificate;
        }

    }
}
