# Jetson nano

![](https://velog.velcdn.com/images/danbibibi/post/373aa9aa-a2e3-41d7-9da4-9692d094dc85/image.png)


## 1. Python 환경 

[관련 link](https://pyimagesearch.com/2019/05/06/getting-started-with-the-nvidia-jetson-nano/)

```shell
$ wget https://bootstrap.pypa.io/get-pip.py
$ sudo python3 get-pip.py
$ rm get-pip.py
$ wget https://bootstrap.pypa.io/pip/3.6/get-pip.py
``` 

## 2. vscode 설치

```shell
$ git clone https://github.com/JetsonHacksNano/installVSCode.git
$ cd installVSCode
$ ./installVSCode.sh
$ ./installVSCodeWithPython.sh
``` 

-  `code .` 로 vs code 실행

## 3. USB-Camera 테스트

```shell
# ubuntu terminal 에서 실행

git clone https://github.com/jetsonhacks/USB-Camera.git

# 이동하기
cd USB-Camera

# vs code 터미널에서
#camera 실행코드
python3 usb-camera-simple.py

# q 로 빠져나오기
q

# 얼굴 인식
$ python3 face-detect-usb.py

# failed to load module canberra-gtk-module error시
sudo apt-get install libcanberra-gtk-modul
``` 


## 4. LED 켜기(IoT)

```shell
# NVIDIA GPIO 라이브러리 설치
% sudo pip3 install Jetson.GPIO
% sudo groupadd -f -r gpio
% sudo usermod -a -G gpio jetson
% sudo reboot
```

```python
# python 키고 라이브러리 설치 확인
% GPIO.VERSION
```

아래 파일 만들고 실행 

```python
# GPIO library
import Jetson.GPIO as GPIO
import time
# Pin Definition
led_pin = 7
# Set up the GPIO channel
GPIO.setmode(GPIO.BOARD)
GPIO.setup(led_pin, GPIO.OUT, initial=GPIO.HIGH)

# Blink the LED
while True:
	time.sleep(2)
	GPIO.output(led_pin, GPIO.HIGH)
	print("LED is ON")
	time.sleep(2)
	GPIO.output(led_pin, GPIO.LOW)
	print("LED is OFF")
```

![image](https://user-images.githubusercontent.com/55095806/185393623-5c774659-f69b-4576-899c-98b0f994b623.png)

