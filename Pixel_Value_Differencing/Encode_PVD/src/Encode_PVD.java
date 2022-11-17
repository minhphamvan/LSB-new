
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Encode_PVD extends javax.swing.JFrame {

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
    Vector<Integer> vecTI2 = new Vector<>();
    Vector<Integer> vecM = new Vector<>();
    Vector<Double> vecTI = new Vector<>();

    Vector<String> vecBinaryDecrypt = new Vector<>();

    int colIndex, rowIndex;
    int low, high, cek;

    public Encode_PVD() {
        initComponents();

        btnEncode.setEnabled(true);
        btnChooseFile.setEnabled(true);
        btnReset.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtInputFile = new javax.swing.JTextField();
        btnChooseFile = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtInputMsg = new javax.swing.JTextArea();
        btnEncode = new javax.swing.JButton();
        labelCleanImage = new javax.swing.JLabel();
        stegoImage = new javax.swing.JLabel();
        cleanImage = new javax.swing.JLabel();
        labelStegoImage = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNameStegoImage = new javax.swing.JTextField();
        btnReset = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 51));
        jLabel1.setText("Encode - Pixel Value Differencing");

        jLabel2.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        jLabel2.setText("Clean image:");

        jLabel3.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        jLabel3.setText("Message:");

        txtInputFile.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N

        btnChooseFile.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        btnChooseFile.setText("Choose");
        btnChooseFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChooseFileActionPerformed(evt);
            }
        });

        txtInputMsg.setColumns(20);
        txtInputMsg.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        txtInputMsg.setRows(5);
        jScrollPane1.setViewportView(txtInputMsg);

        btnEncode.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        btnEncode.setText("Encode");
        btnEncode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEncodeActionPerformed(evt);
            }
        });

        labelCleanImage.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        labelCleanImage.setText("Clean image:");

        stegoImage.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        cleanImage.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        labelStegoImage.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        labelStegoImage.setText("Stego image:");

        jLabel4.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        jLabel4.setText("Save name:");

        txtNameStegoImage.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelCleanImage)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(txtInputFile, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnChooseFile))
                                            .addComponent(txtNameStegoImage, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(49, 49, 49))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(cleanImage, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelStegoImage)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnEncode, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnReset, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(stegoImage, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(jLabel1)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtInputFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2)
                                    .addComponent(btnChooseFile)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(txtNameStegoImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(btnEncode)
                        .addGap(18, 18, 18)
                        .addComponent(btnReset)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelCleanImage)
                    .addComponent(labelStegoImage))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(stegoImage, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cleanImage, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEncodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEncodeActionPerformed
        if (txtInputFile.getText().length() == 0)
            JOptionPane.showMessageDialog(null, "Image must be chosen");
        else {
            try {
                for (int i = 0; i < 64; i++) {
                    vecTable.add(4);
                }

                getPixelRGB();
                setMessage();
                showImage();

                cleanImage.setVisible(true);
                stegoImage.setVisible(true);

                btnEncode.setEnabled(false);
                btnChooseFile.setEnabled(false);
                btnReset.setEnabled(true);
            } catch (IOException ex) {
                Logger.getLogger(Encode_PVD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnEncodeActionPerformed

    private void btnChooseFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChooseFileActionPerformed
        JFileChooser choose = new JFileChooser("/home/minh/Desktop/LSB-new/Pixel_Value_Differencing/Image_Test");

        int rVal = choose.showOpenDialog(this);

        if (rVal == JFileChooser.APPROVE_OPTION) {
            txtInputFile.setText(choose.getCurrentDirectory().toString() + "/" + choose.getSelectedFile().getName());
        }

        if (rVal == JFileChooser.CANCEL_OPTION) {
            txtInputFile.setText("");
        }
    }//GEN-LAST:event_btnChooseFileActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnResetActionPerformed

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

    void setBinaryText() {
        vecASCII.clear();

        String message = txtInputMsg.getText();
        for (int i = 0; i < message.length(); i++) {
            char temp = message.charAt(i);
            vecASCII.add((int) temp);
        }

        for (int i = 0; i < vecASCII.size(); i++) {
            String old_biner = Integer.toBinaryString(vecASCII.get(i));
            int min = 8 - old_biner.length();

            String new_biner = "";
            for (int j = 0; j < min; j++) {
                new_biner += "0";
            }
            new_biner += old_biner;

            vecBinaryWord.add(new_biner);
        }

        System.out.println(vecBinaryWord);
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

    void PVDProcess() {
        colIndex = rowIndex = 0;
        for (int a = 0; a < vecBinaryWord.size(); a++) {
            for (int b = 0; b < 8; b += 2) {
                vecDI.add(Math.abs(vecRed.get(colIndex) - vecRed.get(colIndex + 1)));
                low = high = cek = 0;
                for (int i = 0; i < vecTable.size(); i++) {
                    high += vecTable.get(i);
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
                int sizeBit = vecTI.get(vecTI.size() - 1).intValue();
                int angka = Integer.parseInt(vecBinaryWord.get(a).substring(b, b + sizeBit), sizeBit);
                vecTI2.add(angka);
                vecDI2.add(vecTI2.get(vecTI2.size() - 1) + vecLJ.get(vecLJ.size() - 1));
                vecM.add(Math.abs(vecDI2.get(vecDI2.size() - 1) - vecDI.get(vecDI.size() - 1)));
                if (vecRed.get(colIndex) >= vecRed.get(colIndex + 1)) {
                    if (vecDI2.get(vecDI2.size() - 1) > vecDI.get(vecDI.size() - 1)) {
                        vecRed.set(colIndex, vecRed.get(colIndex) + (int) Math.ceil(vecM.get(vecM.size() - 1) / 2f));
                        vecRed.set(colIndex + 1, vecRed.get(colIndex + 1) - (int) Math.floor(vecM.get(vecM.size() - 1) / 2f));
                    } else {
                        vecRed.set(colIndex, vecRed.get(colIndex) - (int) Math.ceil(vecM.get(vecM.size() - 1) / 2f));
                        vecRed.set(colIndex + 1, vecRed.get(colIndex + 1) + (int) Math.floor(vecM.get(vecM.size() - 1) / 2f));
                    }
                } else {
                    if (vecDI2.get(vecDI2.size() - 1) > vecDI.get(vecDI.size() - 1)) {
                        vecRed.set(colIndex, vecRed.get(colIndex) - (int) Math.floor(vecM.get(vecM.size() - 1) / 2f));
                        vecRed.set(colIndex + 1, vecRed.get(colIndex + 1) + (int) Math.ceil(vecM.get(vecM.size() - 1) / 2f));
                    } else {
                        vecRed.set(colIndex, vecRed.get(colIndex) + (int) Math.ceil(vecM.get(vecM.size() - 1) / 2f));
                        vecRed.set(colIndex + 1, vecRed.get(colIndex + 1) - (int) Math.floor(vecM.get(vecM.size() - 1) / 2f));
                    }
                }
                colIndex += 2;
            }
        }
    }

    void setMessage() {
        setBinaryText();
        resetAll();
        PVDProcess();
    }

    void showImage() throws IOException {
        try {
            img = ImageIO.read(new File(txtInputFile.getText()));
            cleanImage.setIcon(scaleImage(new ImageIcon(img), 600, 400));
        } catch (IOException ex) {
            System.out.println(ex);
        }

        BufferedImage image = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);
        WritableRaster raster = image.getRaster();
        for (int i = 0; i < pixels.length; i++) {
            pixels[i] = ((vecRed.get(i) & 0x0ff) << 16) | ((vecGreen.get(i) & 0x0ff) << 8) | (vecBlue.get(i) & 0x0ff);
        }
        raster.setDataElements(0, 0, img.getWidth(), img.getHeight(), pixels);
        stegoImage.setIcon(scaleImage(new ImageIcon(image), 600, 400));

        File outputfile = new File(txtInputFile.getText().substring(0, txtInputFile.getText().lastIndexOf("/") + 1) + txtNameStegoImage.getText().toString() + ".png");
        ImageIO.write(image, "png", outputfile);
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
                JFrame frame = new Encode_PVD();
                frame.setTitle("Encode - PVD");
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChooseFile;
    private javax.swing.JButton btnEncode;
    private javax.swing.JButton btnReset;
    private javax.swing.JLabel cleanImage;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelCleanImage;
    private javax.swing.JLabel labelStegoImage;
    private javax.swing.JLabel stegoImage;
    private javax.swing.JTextField txtInputFile;
    private javax.swing.JTextArea txtInputMsg;
    private javax.swing.JTextField txtNameStegoImage;
    // End of variables declaration//GEN-END:variables
}
