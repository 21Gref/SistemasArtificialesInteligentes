package gui;

import agents.BookBuyerAgent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;

public class BookBuyerGui extends javax.swing.JFrame {

    private BookBuyerAgent bookBuyerAgent;

    public BookBuyerGui(BookBuyerAgent bookBuyerAgent) {
        super(bookBuyerAgent.getLocalName());
        this.bookBuyerAgent = bookBuyerAgent;
        initComponents();
        lbBuyerName.setText(bookBuyerAgent.getLocalName());
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                //this.sellerAgent.doDelete();
                dispose();
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbBuyerName = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtTitle = new javax.swing.JTextField();
        btnBuy = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(240, 144));
        getContentPane().setLayout(new java.awt.BorderLayout());

        lbBuyerName.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        lbBuyerName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lbBuyerName, java.awt.BorderLayout.NORTH);
        lbBuyerName.getAccessibleContext().setAccessibleName("");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setText("Title");
        getContentPane().add(jLabel4, java.awt.BorderLayout.WEST);

        txtTitle.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        getContentPane().add(txtTitle, java.awt.BorderLayout.CENTER);

        btnBuy.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnBuy.setText("Buy");
        btnBuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuyActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuy, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Do the buyout
     * @param evt 
     */
    private void btnBuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuyActionPerformed
        String bookTitle = txtTitle.getText().trim();
        try {
            bookBuyerAgent.buy(bookTitle);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(BookBuyerGui.this, "Error" + e.getMessage().toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnBuyActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuy;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lbBuyerName;
    private javax.swing.JTextField txtTitle;
    // End of variables declaration//GEN-END:variables
}
