
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class Decode_PVD extends javax.swing.JFrame {

    BufferedImage img;
    int width, height;
    int[] pixels;
    Color c;

    Vector<Integer> vecRed = new Vector<>();
    Vector<Integer> vecGreen = new Vector<>();
    Vector<Integer> vecBlue = new Vector<>();

    Vector<Integer> vecTable = new Vector<>();

    Vector<Integer> vecDI = new Vector<>();
    Vector<Integer> vecDI2 = new Vector<>();
    Vector<Integer> vecLJ = new Vector<>();
    Vector<Integer> vecWJ = new Vector<>();
    Vector<Integer> vecUJ = new Vector<>();
    Vector<Double> vecTI = new Vector<>();
    Vector<Integer> vecTI2 = new Vector<>();

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
        txtStegoImage = new javax.swing.JTextField();
        btnChooseFile = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtResultMessage = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        btnDecode = new javax.swing.JButton();
        stegoImage = new javax.swing.JLabel();
        txtLengthMessage = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnReset = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 51));
        jLabel1.setText("Decode - Pixel Value Differencing");

        jLabel2.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        jLabel2.setText("Stego Image:");

        txtStegoImage.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N

        btnChooseFile.setText("Choose");
        btnChooseFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChooseFileActionPerformed(evt);
            }
        });

        txtResultMessage.setColumns(20);
        txtResultMessage.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        txtResultMessage.setRows(5);
        jScrollPane2.setViewportView(txtResultMessage);

        jLabel4.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        jLabel4.setText("Length message:");

        btnDecode.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        btnDecode.setText("Decode");
        btnDecode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDecodeActionPerformed(evt);
            }
        });

        stegoImage.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtLengthMessage.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        jLabel6.setText("Result message:");

        btnReset.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtStegoImage, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnChooseFile))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(stegoImage, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnDecode, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtLengthMessage, javax.swing.GroupLayout.Alignment.LEADING)))
                .addGap(25, 25, 25))
            .addGroup(layout.createSequentialGroup()
                .addGap(185, 185, 185)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtStegoImage, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btnChooseFile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtLengthMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDecode, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(stegoImage, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDecodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDecodeActionPerformed
        btnDecode.setEnabled(false);
        btnChooseFile.setEnabled(false);
        btnReset.setEnabled(true);
        
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

        txtResultMessage.setText(result);
    }//GEN-LAST:event_btnDecodeActionPerformed

    private void btnChooseFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChooseFileActionPerformed
        JFileChooser choose = new JFileChooser("/home/minh/Desktop/LSB-new/Pixel_Value_Differencing/Image_Test");

        int rVal = choose.showOpenDialog(this);

        if (rVal == JFileChooser.APPROVE_OPTION) {
            txtStegoImage.setText(choose.getCurrentDirectory().toString() + "/" + choose.getSelectedFile().getName());
        }

        if (rVal == JFileChooser.CANCEL_OPTION) {
            txtStegoImage.setText("");
        }
    }//GEN-LAST:event_btnChooseFileActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        txtStegoImage.setText("");
        txtLengthMessage.setText("");
        txtResultMessage.setText("");

        btnDecode.setVisible(true);
        btnReset.setVisible(false);

        vecRed.clear();
        vecGreen.clear();
        vecBlue.clear();

        vecTable.clear();

        vecDI.clear();
        vecDI2.clear();
        vecLJ.clear();
        vecWJ.clear();
        vecUJ.clear();
        vecTI.clear();
        vecTI2.clear();

        vecBinaryDecrypt.clear();
    }//GEN-LAST:event_btnResetActionPerformed

    void getPixelRGB() {
        try {
            vecRed.clear();
            vecGreen.clear();
            vecBlue.clear();

            img = ImageIO.read(new File(txtStegoImage.getText()));

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
    }

    void showImage() {
        try {
            img = ImageIO.read(new File(txtStegoImage.getText()));

            stegoImage.setIcon(scaleImage(new ImageIcon(img), 600, 400));
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    private ImageIcon scaleImage(ImageIcon icon, int w, int h) {
        int nw = icon.getIconWidth();
        int nh = icon.getIconHeight();

        if (icon.getIconWidth() > w) {
            nw = w;
            nh = (nw * icon.getIconHeight()) / icon.getIconWidth();
        }

        if (nh > h) {
            nh = h;
            nw = (icon.getIconWidth() * nh) / icon.getIconHeight();
        }

        return new ImageIcon(icon.getImage().getScaledInstance(nw, nh, Image.SCALE_DEFAULT));
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new Decode_PVD();
                frame.setTitle("Decode - PVD");
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChooseFile;
    private javax.swing.JButton btnDecode;
    private javax.swing.JButton btnReset;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel stegoImage;
    private javax.swing.JTextField txtLengthMessage;
    private javax.swing.JTextArea txtResultMessage;
    private javax.swing.JTextField txtStegoImage;
    // End of variables declaration//GEN-END:variables
}
