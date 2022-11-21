import cv2
import numpy as np
from PIL import Image
import string
import secrets

# Chuyển data sang binary
def data2binary(data):
    if type(data) == str:
        p = ''.join([format(ord(i), '08b')for i in data])
    elif type(data) == bytes or type(data) == np.ndarray:
        p = [format(i, '08b')for i in data]
    return p


# Giấu tin vào trong ảnh
def hidedata(img, data):
    data += '$$'
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

def encode():
    img_name = input("\nNhập ảnh cần nhúng tin: ")
    image = cv2.imread(img_name)
    img = Image.open(img_name, 'r')
    w, h = img.size

    # Dung lượng tin giấu ==> tỉ lệ 50%
    length_data = int (w * h * 3 // 8 * 0.5)
    print(length_data)
    data = 'a' * int (length_data)

    enc_img = input("Đặt tên ảnh sau khi nhúng tin: ")
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


def decode():
    img_name = input("Nhập ảnh cần tách tin: ")
    image = cv2.imread(img_name)
    img=Image.open(img_name, 'r')
    msg = find_data(image)

    print(len(msg))
    return msg


def steganography():
    x = 1
    while x != 0:
        print()
        print("===== Image Steganography LSB =====")
        print("1. Nhúng tin")
        print("2. Tách tin")
        print("0. Thoát")
        
        luaChon = int(input("Nhập vào lựa chọn: "))
        
        if luaChon == 1:
            encode()
        elif luaChon == 2:
            ans = decode()
            print("Tin được nhúng là: " + ans)
        elif luaChon == 0:
            print("Exit !!")
            break
        else:
            print("Nhập sai định dạng !!")

        x = int(input("\nNhập 1 để tiếp tục (hoặc 0 để thoát): "))

steganography()
