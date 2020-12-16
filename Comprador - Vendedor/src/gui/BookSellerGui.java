package gui;

import gui.*;
import agents.BookSellerAgent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;
import javax.swing.JOptionPane;

public class BookSellerGui extends javax.swing.JFrame {

    private final BookSellerAgent bookSellerAgent;
    private int tableRows = 0;

    public BookSellerGui(BookSellerAgent bookSellerAgent) {
        super(bookSellerAgent.getLocalName());
        this.bookSellerAgent = bookSellerAgent;
        initComponents();
        lbSellerName.setText(bookSellerAgent.getLocalName());
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                bookSellerAgent.doDelete();
            }
        });
        
    }

    public void printCatalogue(HashMap<String, Integer> catalogue) {
        cleanTable();
        for (String book : catalogue.keySet()) {
            tbCatalogue.setValueAt(book, tableRows, 0);
            tbCatalogue.setValueAt(catalogue.get(book), tableRows, 1);
            tableRows++;
        }
    }
    
    public void reload(){
        printCatalogue(bookSellerAgent.getCatalogue());
    }

    public void cleanTable() {
        for (int i = 0; i < tableRows; i++) {
            tbCatalogue.setValueAt("", i, 0);
            tbCatalogue.setValueAt("", i, 1);
        }
        tableRows = 0;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbSellerName = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtTitle = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbCatalogue = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.BorderLayout());

        lbSellerName.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        lbSellerName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lbSellerName, java.awt.BorderLayout.NORTH);

        jPanel6.setLayout(new java.awt.BorderLayout());

        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new java.awt.GridLayout(2, 2));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("Title");
        jPanel1.add(jLabel2);

        txtTitle.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel1.add(txtTitle);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("Price");
        jPanel1.add(jLabel3);

        txtPrice.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel1.add(txtPrice);

        jPanel3.add(jPanel1, java.awt.BorderLayout.CENTER);

        btnSave.setText("Save");
        btnSave.setHideActionText(true);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel3.add(btnSave, java.awt.BorderLayout.SOUTH);

        jPanel6.add(jPanel3, java.awt.BorderLayout.NORTH);

        jScrollPane1.setBorder(null);
        jScrollPane1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        tbCatalogue.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tbCatalogue.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbCatalogue.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tbCatalogue);

        jPanel6.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel6, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        String title = txtTitle.getText().trim();
        String price = txtPrice.getText().trim();
        try {
            bookSellerAgent.update(title, Integer.parseInt(price));
            txtTitle.setText("");
            txtPrice.setText("");
            printCatalogue(bookSellerAgent.getCatalogue());

        } catch (Exception e) {
            JOptionPane.showMessageDialog(BookSellerGui.this, "Try other values" + e.getMessage().toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSaveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbSellerName;
    private javax.swing.JTable tbCatalogue;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtTitle;
    // End of variables declaration//GEN-END:variables
}
