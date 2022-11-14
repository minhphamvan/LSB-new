import cv2
import numpy as np 
import string
import secrets

def msg_to_bin(msg):  
    if type(msg) == str:  
        return ''.join([format(ord(i), "08b") for i in msg])  
    elif type(msg) == bytes or type(msg) == np.ndarray:  
        return [format(i, "08b") for i in msg]  
    elif type(msg) == int or type(msg) == np.uint8:  
        return format(msg, "08b")  
    else:  
        raise TypeError("Input type not supported")

def hide_data(img, secret_msg):    
    secret_msg += '#####'         
    
    dataIndex = 0  
      
    bin_secret_msg = msg_to_bin(secret_msg)   
    dataLen = len(bin_secret_msg)  

    for values in img:  
        for pixels in values:  
            r, g, b = msg_to_bin(pixels)  
              
            if dataIndex < dataLen:    
                pixels[0] = int(r[:-1] + bin_secret_msg[dataIndex], 2)  
                dataIndex += 1  
            if dataIndex < dataLen:    
                pixels[1] = int(g[:-1] + bin_secret_msg[dataIndex], 2)  
                dataIndex += 1  
            if dataIndex < dataLen:    
                pixels[2] = int(b[:-1] + bin_secret_msg[dataIndex], 2)  
                dataIndex += 1  
              
            if dataIndex >= dataLen:  
                break  
      
    return img  

def encodeText(srcimg, newimg):  
    img = cv2.imread(srcimg)
    
    length_data = int(img.size * 3 // 8 * 0.3)
    data = "a" * length_data       

    encodedImage = hide_data(img, data)  
    cv2.imwrite(newimg, encodedImage)

def tiLeMauGanNhauChiaMauDacBiet(src):
    image  = cv2.imread(src)
    img = cv2.cvtColor(image, cv2.COLOR_BGR2RGB)
    n = img.shape[0]    # height
    m = img.shape[1]    # width
    R =  img[:, :, 0]   # RED
    G =  img[:, :, 1]   # GREEN
    B =  img[:, :, 2]   # BLUE
    
    capMauGanNhau = 0
    for i in range(0, n):
        for j in range(0, m):
            if( i < n-1 and j < m-1):
                    if abs(int(R[i][j]) - int(R[i+1][j])) == 1 and abs(int(G[i][j]) - int(G[i+1][j])) == 1 and abs(int(B[i][j]) - int(B[i+1][j])) == 1:
                        capMauGanNhau = capMauGanNhau + 1
                        
    print("\nSố lượng cặp màu gần nhau: ", capMauGanNhau)
    
    capMauDacBiet = 0
    for i in range(0, n):
        for j in range(0, m):
            if( i < n-1 and j < m-1):
                    if abs(int(R[i][j]) - int(R[i+1][j])) == 1 or abs(int(G[i][j]) - int(G[i+1][j])) == 1 or abs(int(B[i][j]) - int(B[i+1][j])) == 1:
                        capMauDacBiet = capMauDacBiet + 1
    
    print("Số lượng cặp màu đặc biệt: ", capMauDacBiet)
    
    tiLe = capMauGanNhau/capMauDacBiet
    print("Tỉ lệ màu gần nhau / màu đặc biệt là: ", tiLe)
    
    return tiLe

def kiemTra():
    print()
    print("===== Close Color Pair =====")
    img_name = input("Nhập ảnh cần kiểm tra: ") 
    img_name_tmp= "ccp_" + img_name 
    
    encodeText(img_name, img_name_tmp)
    
    a = tiLeMauGanNhauChiaMauDacBiet(img_name)
    b = tiLeMauGanNhauChiaMauDacBiet(img_name_tmp)
    
    print("\nNgưỡng phân biệt ảnh m=(R-R')*100/R: ", (a - b)*100/a)
    print("Tỉ lệ R/R': ", a/b)
    
    if float (a/b) <= 1.001:
        print("==> Stegano Image")
    else:
        print("==> Cover Image")

kiemTra()


