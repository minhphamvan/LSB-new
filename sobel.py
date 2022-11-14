
import numpy as np
import cv2
import string
import secrets

def data2binary(data):
    if type(data) == str:
        p = ''.join([format(ord(i), '08b')for i in data])
    elif type(data) == bytes or type(data) == np.ndarray:
        p = [format(i, '08b')for i in data]
    
    return p

def sobelOperator(img):
    container = np.copy(img)
    size = container.shape
    for i in range(1, size[0] - 1):
        for j in range(1, size[1] - 1):
            gx = (img[i - 1][j - 1] + 2*img[i][j - 1] + img[i + 1][j - 1]) - (img[i - 1][j + 1] + 2*img[i][j + 1] + img[i + 1][j + 1])
            gy = (img[i - 1][j - 1] + 2*img[i - 1][j] + img[i - 1][j + 1]) - (img[i + 1][j - 1] + 2*img[i + 1][j] + img[i + 1][j + 1])
            container[i][j] = min(255, np.sqrt(gx**2 + gy**2))
    return container
    pass

def calculate_template_space(temp_side_length):
        return int(temp_side_length/2)

def dilation(image, template_side_length, template):
    new_image = np.zeros(image.shape, image.dtype)
    # Coordinates are provided as (y,x), where the origin is at the top left of the image
    # So always remember that (-) is used instead of (+) to iterate
    template_space = calculate_template_space(template_side_length)
    half_template = int((template_side_length - 1) / 2)

    for x in range(template_space, new_image.shape[1] - template_space):
        for y in range(template_space, new_image.shape[0] - template_space):
            maximum = 0
            for c in range(0, template_side_length):
                for d in range(0, template_side_length):
                    a = x - half_template - 1 + c
                    b = y - half_template - 1 + d
                    sub = image[b, a] - template[d, c]
                    if sub > maximum:
                        if sub > 0:
                            maximum = sub
            new_image[y, x] = int(maximum)
    return new_image

# image = cv2.imread("clean_1.png", cv2.COLOR_BGR2RGB)
# print(image[0][0])
# print(image[0][1])
# print(image[0][2])


img_sobel = cv2.cvtColor(cv2.imread("clean_1.png"), cv2.COLOR_RGB2GRAY)
img_sobel = sobelOperator(img_sobel)
cv2.imwrite("sobel_1.png", img_sobel)

# print(img[0][0])
# print(img[0][1])
# print(img[0][2])

# Dilation
# img = cv2.imread("clean_1.png", cv2.IMREAD_GRAYSCALE)
filter_size = 1
temp = np.zeros(img_sobel.shape, img_sobel.dtype)
new_img = dilation(img_sobel, filter_size, temp)
cv2.imwrite("dilation_1" + str(filter_size) + "_.png", new_img)

image_data = np.asarray(new_img)

# for i in range(len(image_data)):
#     for j in range(len(image_data[0])):
#         print(image_data[i][j]) 


print(image_data[0][0])
print(image_data[0][1]) 
print(image_data[0][2]) 
