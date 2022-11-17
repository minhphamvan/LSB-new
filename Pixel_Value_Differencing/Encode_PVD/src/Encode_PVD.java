
import java.awt.Color;
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
    int width;
    int height;
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
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtInputFile = new javax.swing.JTextField();
        btnChoose = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtInputMsg = new javax.swing.JTextArea();
        btnEncode = new javax.swing.JButton();
        labelCleanImage = new javax.swing.JLabel();
        stegoImage = new javax.swing.JLabel();
        cleanImage = new javax.swing.JLabel();
        labelStegoImage = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNameStegoImage = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel1.setText("PVD Stegano Encode");

        jLabel2.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        jLabel2.setText("Clean image:");

        jLabel3.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        jLabel3.setText("Message:");

        txtInputFile.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N

        btnChoose.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        btnChoose.setText("Choose");
        btnChoose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChooseActionPerformed(evt);
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

        labelStegoImage.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        labelStegoImage.setText("Stego image:");

        jLabel4.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        jLabel4.setText("Save name:");

        txtNameStegoImage.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cleanImage, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                                        .addComponent(btnChoose))
                                    .addComponent(txtNameStegoImage, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelStegoImage)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnEncode, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(stegoImage, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(jLabel1)))
                .addGap(27, 27, 27))
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
                                    .addComponent(btnChoose)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(txtNameStegoImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(btnEncode)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelCleanImage)
                    .addComponent(labelStegoImage))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(stegoImage, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cleanImage, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
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
                setImage();
                labelCleanImage.setVisible(true);
                cleanImage.setVisible(true);
                stegoImage.setVisible(true);
            } catch (IOException ex) {
                Logger.getLogger(Encode_PVD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnEncodeActionPerformed

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

    void setBinaryText() {
        vecASCII.clear();
        String tmp = "";
        tmp = txtInputMsg.getText();
        for (int i = 0; i < tmp.length(); i++) {
            char temp = tmp.charAt(i);
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

    void setImage() throws IOException {
        BufferedImage image = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);
        WritableRaster raster = image.getRaster();
        for (int i = 0; i < pixels.length; i++) {
            pixels[i] = ((vecRed.get(i) & 0x0ff) << 16) | ((vecGreen.get(i) & 0x0ff) << 8) | (vecBlue.get(i) & 0x0ff);
        }
        raster.setDataElements(0, 0, img.getWidth(), img.getHeight(), pixels);
        stegoImage.setIcon(new ImageIcon(image));

        File outputfile = new File(txtInputFile.getText().substring(0, txtInputFile.getText().lastIndexOf("/") + 1) + txtNameStegoImage.getText().toString() + ".png");
        ImageIO.write(image, "png", outputfile);
        System.out.println(outputfile.toPath());
        try {
            img = ImageIO.read(new File(txtInputFile.getText()));
            cleanImage.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new Encode_PVD();
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                frame.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChoose;
    private javax.swing.JButton btnEncode;
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
