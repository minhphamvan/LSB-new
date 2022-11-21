import cv2
import numpy as np
from PIL import Image
import string
import secrets
import os

# Chuyển data sang binary
def data2binary(data):
    if type(data) == str:
        p = ''.join([format(ord(i), '08b')for i in data])
    elif type(data) == bytes or type(data) == np.ndarray:
        p = [format(i, '08b')for i in data]
    return p


# Giấu tin vào trong ảnh
def hidedata(img, data):
    data += "$$"    # ==> secret key
    d_index = 0
    b_data = data2binary(data)
    len_data = len(b_data)

    # Giấu tin vào từng pixel
    for value in img:
        for pix in value:
            r, g, b = data2binary(pix)

            if d_index < len_data:
                pix[0] = int(r[:-1] + b_data[d_index], 2)
                d_index += 1
            if d_index < len_data:
                pix[1] = int(g[:-1] + b_data[d_index], 2)
                d_index += 1
            if d_index < len_data:
                pix[2] = int(b[:-1] + b_data[d_index], 2)
                d_index += 1
            if d_index >= len_data:
                break
    
    return img

def encode(img_name):
    image = cv2.imread(img_name)
    img = Image.open(img_name, 'r')
    w, h = img.size

    # Dung lượng tin giấu ==> tỉ lệ 10%
    length_data = int (w * h * 3 // 8 * 0.1)
    data = 'a' * int (length_data)

    enc_img = "stego_" + img_name.split("_")[1].split(".")[0] + "_10.png"
    enc_data = hidedata(image, data)
    cv2.imwrite(enc_img, enc_data)

# Giải mã
def find_data(img):
    bin_data = ""
    for value in img:
        for pix in value:
            r, g, b = data2binary(pix)
            bin_data += r[-1]
            bin_data += g[-1]
            bin_data += b[-1]

    all_bytes = [bin_data[i: i + 8] for i in range(0, len(bin_data), 8)]

    readable_data = ""
    for x in all_bytes:
        readable_data += chr(int(x, 2))
        if readable_data[-2:] == "$$":
            break
    return readable_data[:-2]


def decode(img_name):
    image = cv2.imread(img_name)
    img=Image.open(img_name, 'r')
    msg = find_data(image)
    return msg

def read_text_file(file_path):
    with open(file_path, 'r') as f:
        print(f.read())

def steganography():
    print()
    print("===== Image Steganography LSB 10% =====")

    for x in range(50):
        img_name = "clean_" + str(x + 1) + ".png" # clean_1.png
        print(img_name) 
        encode(img_name)

# def steganography():
#     print()
#     print("===== Image Steganography LSB 50% =====")

#     x = input("Nhập x: ")
#     img_name = "clean_" + x + ".png" # clean_1.png
#     encode(img_name)

steganography()
