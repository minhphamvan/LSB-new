import cv2
import numpy as np
from PIL import Image
import string
import random
import secrets

def get_random_string(length):
    letters = string.ascii_lowercase
    result_str = ''.join(random.choice(letters) for i in range(length))
    print("Random string of length", length, "is:", result_str)

    return result_str

def data2binary(data):
    if type(data) == str:
        p = ''.join([format(ord(i), '08b')for i in data])
    elif type(data) == bytes or type(data) == np.ndarray:
        p = [format(i, '08b')for i in data]

    return p

def xor(a, b):
    if a == 0 & b == 0:
        return 0
    elif a == 1 & b == 1:
        return 0
    elif a == 1 & b == 0:
        return 1
    elif a == 0 & b == 1:
        return 1

def hidedata(img, data, secret_key):
    data += '$$'

    d_index = 0
    b_data = data2binary(data)
    len_data = len(b_data)

    s_index = 0
    b_secret_key = data2binary(secret_key)
    len_secret_data = len(b_secret_key)

    # Giấu tin vào các pixel
    for value in img:
        for pix in value:
            r, g, b = data2binary(pix)

            if s_index == len_secret_data - 1:
                s_index = 0

            if xor(int(r[-1:]), int(b_secret_key[s_index])) == 1: 
                if d_index < len_data:
                    pix[1] = int(g[:-1] + b_data[d_index], 2)
                    d_index += 1
                    s_index += 1
            elif xor(int(r[-1:]), int(b_secret_key[s_index])) == 0:
                if d_index < len_data:
                    pix[2] = int(b[:-1] + b_data[d_index], 2)
                    d_index += 1
                    s_index += 1
            
            if d_index >= len_data:
                break
    
    # print(d_index)

    return img

def encode():
    img_name = input("\nNhập ảnh cần nhúng tin: ")
    image = cv2.imread(img_name)
    img = Image.open(img_name, 'r')
    w, h = img.size

    # Dung lượng tin giấu ==> tỉ lệ 10%
    length_data = int (w * h // 8 * 0.2)
    print(length_data)
    data = get_random_string(int (length_data))
    # data = input("Nhập nội dung cần nhúng: ")

    secret_key = input("Nhập secret key: ")

    enc_img = input("Đặt tên ảnh sau khi nhúng tin: ")
    enc_data = hidedata(image, data, secret_key)

    cv2.imwrite(enc_img, enc_data)

# ================== Giải mã ==================
def find_data(img, secret_key):
    s_index = 0
    b_secret_key = data2binary(secret_key)
    len_secret_data = len(b_secret_key)

    bin_data = ""
    for value in img:
        for pix in value:
            r, g, b = data2binary(pix)

            if s_index == len_secret_data - 1:
                s_index = 0

            if xor(int(r[-1:]), int(b_secret_key[s_index])) == 1:
                bin_data += g[-1]
                s_index += 1
            elif xor(int(r[-1:]), int(b_secret_key[s_index])) == 0:
                bin_data += b[-1]
                s_index += 1

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

    secret_key = input("Nhập secret key: ")
    msg = find_data(image, secret_key)

    # print(len(msg))
    return msg

# ================== MAIN ==================
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