
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

public class Decode_PVD extends javax.swing.JFrame {

    BufferedImage img;
    int width, height;
    int[] pixels;
    Color c;

    Vector<Integer> vecRed = new Vector<>();
    Vector<Integer> vecGreen = new Vector<>();
    Vector<Integer> vecBlue = new Vector<>();

    Vector<Integer> vecASCII = new Vector<>();
    Vector<String> vecBinaryWord = new Vector<>();

    Vector<Integer> vecTable = new Vector<>();

    Vector<Integer> vecDI = new Vector<>();
    Vector<Integer> vecDI2 = new Vector<>();
    Vector<Integer> vecLJ = new Vector<>();
    Vector<Integer> vecWJ = new Vector<>();
    Vector<Integer> vecUJ = new Vector<>();
    Vector<Double> vecTI = new Vector<>();
    Vector<Integer> vecTI2 = new Vector<>();
    Vector<Integer> vecM = new Vector<>();

    int colIndex, rowIndex;
    int low, high, cek;

    Vector<String> vecBinaryDecrypt = new Vector<>();

    public Decode_PVD() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtInputFile = new javax.swing.JTextField();
        btnChoose = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtResultMsg = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        btnDecode = new javax.swing.JButton();
        stegoImage = new javax.swing.JLabel();
        txtLengthMessage = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel1.setText("PVD Stegano Decode");

        jLabel2.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        jLabel2.setText("Stego Image:");

        txtInputFile.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N

        btnChoose.setText("Choose");
        btnChoose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChooseActionPerformed(evt);
            }
        });

        txtResultMsg.setColumns(20);
        txtResultMsg.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        txtResultMsg.setRows(5);
        jScrollPane2.setViewportView(txtResultMsg);

        jLabel4.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        jLabel4.setText("Result message:");

        btnDecode.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        btnDecode.setText("Decode");
        btnDecode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDecodeActionPerformed(evt);
            }
        });

        txtLengthMessage.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        jLabel6.setText("Length message:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtInputFile, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnChoose))
                    .addComponent(stegoImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel4)
                        .addComponent(jScrollPane2)
                        .addComponent(txtLengthMessage))
                    .addComponent(jLabel6))
                .addGap(25, 25, 25))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(213, 213, 213)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(259, 259, 259)
                        .addComponent(btnDecode, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtInputFile, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(btnChoose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtLengthMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 273, Short.MAX_VALUE))
                    .addComponent(stegoImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDecode, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDecodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDecodeActionPerformed
        showImage();

        for (int i = 0; i < 64; i++) {
            vecTable.add(4);
        }

        getPixelRGB();

        int msgLength = Integer.parseInt(txtLengthMessage.getText());

        colIndex = rowIndex = 0;
        
        String new_biner = "";
        vecBinaryDecrypt.clear();
        resetAll();

        for (int i = 0; i < msgLength * 8; i += 2) {
            vecDI.add(Math.abs(vecRed.get(i) - vecRed.get(i + 1)));
            
            low = 0;
            high = 0;
            cek = 0;
            
            for (int j = 0; j < vecTable.size(); j++) {
                high += vecTable.get(j);
                --high;
                
                if (vecDI.get(vecDI.size() - 1) >= low && vecDI.get(vecDI.size() - 1) <= high) {
                    cek = i;
                    vecLJ.add(low);
                    vecUJ.add(high);
                }
                
                low = ++high;
            }
            
            vecWJ.add(vecUJ.get(vecUJ.size() - 1) - vecLJ.get(vecLJ.size() - 1) + 1);
            vecTI.add(Math.log(vecWJ.get(vecWJ.size() - 1)) / Math.log(2));
            vecDI2.add(vecDI.get(vecDI.size() - 1) - vecLJ.get(vecLJ.size() - 1));
            
            String old_biner = Integer.toBinaryString(vecDI2.get(vecDI2.size() - 1));
            
            int min = 2 - old_biner.length();
            
            for (int j = 0; j < min; j++) {
                new_biner += "0";
            }
            new_biner += old_biner;

            System.out.println(new_biner);

            if ((i + 2) % 8 == 0 && i != 0) {
                vecBinaryDecrypt.add(new_biner);
                new_biner = "";
            } else if ((i + 2) >= msgLength * 8) {
                vecBinaryDecrypt.add(new_biner);
                new_biner = "";
            }
        }

        String result = "";
        for (int i = 0; i < vecBinaryDecrypt.size(); i++) {
            String tmp = Integer.toString(Integer.parseInt(vecBinaryDecrypt.get(i), 2));
            char tmp2 = (char) Integer.parseInt(tmp);
            result += tmp2;
        }
        
        txtResultMsg.setText(result);
    }//GEN-LAST:event_btnDecodeActionPerformed

    private void btnChooseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChooseActionPerformed
        JFileChooser choose = new JFileChooser();
        int rVal = choose.showOpenDialog(this);
        if (rVal == JFileChooser.APPROVE_OPTION) {
            txtInputFile.setText(choose.getCurrentDirectory().toString() + "/" + choose.getSelectedFile().getName());
        }
        if (rVal == JFileChooser.CANCEL_OPTION) {
            txtInputFile.setText("");
        }
    }//GEN-LAST:event_btnChooseActionPerformed

    void getPixelRGB() {
        try {
            vecRed.clear();
            vecGreen.clear();
            vecBlue.clear();

            img = ImageIO.read(new File(txtInputFile.getText()));

            width = img.getWidth();
            height = img.getHeight();

            pixels = img.getRGB(0, 0, img.getWidth(), img.getHeight(), null, 0, img.getWidth());

            for (int i = 0; i < pixels.length; i++) {
                c = new Color(pixels[i]);
                
                vecRed.add(c.getRed());
                vecGreen.add(c.getGreen());
                vecBlue.add(c.getBlue());
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    void resetAll() {
        vecDI.clear();
        vecLJ.clear();
        vecWJ.clear();
        vecUJ.clear();
        vecTI.clear();
        vecTI2.clear();
        vecDI2.clear();
        vecM.clear();
    }

    void showImage() {
        try {
            img = ImageIO.read(new File(txtInputFile.getText()));
            stegoImage.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Decode_PVD().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChoose;
    private javax.swing.JButton btnDecode;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel stegoImage;
    private javax.swing.JTextField txtInputFile;
    private javax.swing.JTextField txtLengthMessage;
    private javax.swing.JTextArea txtResultMsg;
    // End of variables declaration//GEN-END:variables
}
