//import java.awt.Color;
//import java.awt.TextField;
//import javax.imageio.ImageIO;
//import java.awt.image.BufferedImage;
//import java.awt.image.WritableRaster;
//import java.io.File;
//import java.io.IOException;
//import java.util.Vector;
//
//public class SteganoPVD {
//    BufferedImage img;
//    int width;
//    int height;
//    int[] pixels;
//    Color c;
//
//    Vector<Integer> vecRed;
//    Vector<Integer> vecGreen;
//    Vector<Integer> vecBlue;
//
//    Vector<Integer> vecASCII;
//
//    Vector<String> vecBinaryWord;
//
//    TextField txtInputFile;
//    TextField txtInputMsg;
//
//    int colIndex, rowIndex;
//    int low, high, cek;
//
//    void getPixelRGB() {
//        try {
//            vecRed.clear();
//            vecGreen.clear();
//            vecBlue.clear();
//            img = ImageIO.read(new File(txtInputFile.getText()));
//            width = img.getWidth();
//            height = img.getHeight();
//            pixels = img.getRGB(0, 0, img.getWidth(), img.getHeight(), null, 0, img.getWidth());
//            for (int i = 0; i < pixels.length; i++) {
//                c = new Color(pixels[i]);
//                vecRed.add(c.getRed());
//                vecGreen.add(c.getGreen());
//                vecBlue.add(c.getBlue());
//            }
//        } catch (IOException ex) {
//            System.out.println(ex);
//        }
//    }
//
//    void setBinaryText() {
//        vecASCII.clear();
//        String tmp = "";
//        tmp = txtInputMsg.getText();
//        for (int i = 0; i < tmp.length(); i++) {
//            char temp = tmp.charAt(i);
//            vecASCII.add((int) temp);
//        }
//        for (int i = 0; i < vecASCII.size(); i++) {
//            String old_biner = Integer.toBinaryString(vecASCII.get(i));
//            int min = 8 - old_biner.length();
//            String new_biner = "";
//            for (int j = 0; j < min; j++) {
//                new_biner += "0";
//            }
//            new_biner += old_biner;
//            vecBinaryWord.add(new_biner);
//        }
//    }
//
//    void resetAll() {
//        vecDI.clear();
//        vecLJ.clear();
//        vecWJ.clear();
//        vecUJ.clear();
//        vecTI.clear();
//        vecTI2.clear();
//        vecDI2.clear();
//        vecM.clear();
//    }
//
//    void PVDProcess() {
//        colIndex = rowIndex = 0;
//        for (int a = 0; a < vecBinaryWord.size(); a++) {
//            for (int b = 0; b < 8; b += 2) {
//                vecDI.add(Math.abs(vecRed.get(colIndex) - vecRed.get(colIndex + 1)));
//                low = high = cek = 0;
//                for (int i = 0; i < vecTable.size(); i++) {
//                    high += vecTable.get(i);
//                    --high;
//                    if (vecDI.get(vecDI.size() - 1) >= low && vecDI.get(vecDI.size() - 1) <= high) {
//                        cek = i;
//                        vecLJ.add(low);
//                        vecUJ.add(high);
//                    }
//                    low = ++high;
//                }
//                vecWJ.add(vecUJ.get(vecUJ.size() - 1) - vecLJ.get(vecLJ.size() - 1) + 1);
//                vecTI.add(Math.log(vecWJ.get(vecWJ.size() - 1)) / Math.log(2));
//                int sizeBit = vecTI.get(vecTI.size() - 1).intValue();
//                int angka = Integer.parseInt(vecBinaryWord.get(a).substring(b, b + sizeBit), sizeBit);
//                vecTI2.add(angka);
//                vecDI2.add(vecTI2.get(vecTI2.size() - 1) + vecLJ.get(vecLJ.size() - 1));
//                vecM.add(Math.abs(vecDI2.get(vecDI2.size() - 1) - vecDI.get(vecDI.size() - 1)));
//                if (vecRed.get(colIndex) >= vecRed.get(colIndex + 1)) {
//                    if (vecDI2.get(vecDI2.size() - 1) > vecDI.get(vecDI.size() - 1)) {
//                        vecRed.set(colIndex, vecRed.get(colIndex) + (int) Math.ceil(vecM.get(vecM.size() - 1) / 2f));
//                        vecRed.set(colIndex + 1, vecRed.get(colIndex + 1) - (int) Math.floor(vecM.get(vecM.size() - 1) / 2f));
//                    } else {
//                        vecRed.set(colIndex, vecRed.get(colIndex) - (int) Math.ceil(vecM.get(vecM.size() - 1) / 2f));
//                        vecRed.set(colIndex + 1, vecRed.get(colIndex + 1) + (int) Math.floor(vecM.get(vecM.size() - 1) / 2f));
//                    }
//                } else {
//                    if (vecDI2.get(vecDI2.size() - 1) > vecDI.get(vecDI.size() - 1)) {
//                        vecRed.set(colIndex, vecRed.get(colIndex) - (int) Math.floor(vecM.get(vecM.size() - 1) / 2f));
//                        vecRed.set(colIndex + 1, vecRed.get(colIndex + 1) + (int) Math.ceil(vecM.get(vecM.size() - 1) / 2f));
//                    } else {
//                        vecRed.set(colIndex, vecRed.get(colIndex) + (int) Math.ceil(vecM.get(vecM.size() - 1) / 2f));
//                        vecRed.set(colIndex + 1, vecRed.get(colIndex + 1) - (int) Math.floor(vecM.get(vecM.size() - 1) / 2f));
//                    }
//                }
//                colIndex += 2;
//            }
//        }
//    }
//
//    void setMessage(){
//        setBinaryText();
//        resetAll();
//        PVDProcess();
//    }
//
//    void setImage() {
//        BufferedImage image = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);
//        WritableRaster raster = image.getRaster();
//        for (int i = 0; i < pixels.length; i++)
//            pixels[i] = ((vecRed.get(i) & 0x0ff) << 16) | ((vecGreen.get(i) & 0x0ff) << 8) | (vecBlue.get(i) & 0x0ff);
//        raster.setDataElements(0, 0, img.getWidth(), img.getHeight(), pixels);
//        jLabel6.setIcon(new ImageIcon(image));
//        try {
//            img = ImageIO.read(new File(txtInputFile.getText()));
//            jLabel1.setIcon(new ImageIcon(img));
//        } catch (IOException ex) {
//            System.out.println(ex);
//        }
//        jLabel1.setText("");
//    }
//
//    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
//        
//    }
//
//    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
//        if (txtInputFile.getText().length() == 0)
//            JOptionPane.showMessageDialog(null, "Image must be chosen");
//        else {
//            for (int i = 0; i < 64; i++)
//                vecTable.add(4);
//            getPixelRGB();
//            setMessage();
//            setImage();
//            jLabel5.setVisible(true);
//            jLabel6.setVisible(true);
//            jLabel1.setVisible(true);
//        }
//    }
//
//    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
//        colIndex = rowIndex = 0;
//        String new_biner = "";
//        vecBinaryDecrypt.clear();
//        resetAll();
//        for (int i = 0; i < txtInputMsg.getText().length() * 8; i += 2) {
//            vecDI.add(Math.abs(vecRed.get(i) - vecRed.get(i + 1)));
//            low = high = cek = 0;
//            for (int j = 0; j < vecTable.size(); j++) {
//                high += vecTable.get(j);
//                --high;
//                if (vecDI.get(vecDI.size() - 1) >= low && vecDI.get(vecDI.size() - 1) <= high) {
//                    cek = i;
//                    vecLJ.add(low);
//                    vecUJ.add(high);
//                }
//                low = ++high;
//            }
//            vecWJ.add(vecUJ.get(vecUJ.size() - 1) - vecLJ.get(vecLJ.size() - 1) + 1);
//            vecTI.add(Math.log(vecWJ.get(vecWJ.size() - 1)) / Math.log(2));
//            vecDI2.add(vecDI.get(vecDI.size() - 1) - vecLJ.get(vecLJ.size() - 1));
//            String old_biner = Integer.toBinaryString(vecDI2.get(vecDI2.size() - 1));
//            int min = 2 - old_biner.length();
//            for (int j = 0; j < min; j++) {
//                new_biner += "0";
//            }
//            new_biner += old_biner;
//            if ((i + 2) % 8 == 0 && i != 0) {
//                vecBinaryDecrypt.add(new_biner);
//                new_biner = "";
//            } else if ((i + 2) >= txtInputMsg.getText().length() * 8) {
//                vecBinaryDecrypt.add(new_biner);
//                new_biner = "";
//            }
//        }
//        String Result = "";
//        for (int i = 0; i < vecBinaryDecrypt.size(); i++) {
//            String tmp = Integer.toString(Integer.parseInt(vecBinaryDecrypt.get(i), 2));
//            char tmp2 = (char) Integer.parseInt(tmp);
//            Result += tmp2;
//        }
//        txtResultMsg.setText(Result);
//    }
//}