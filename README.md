# WebCamFaceDetection

WebCam em Java com OpenCV - FaceDetection &amp; EyesDetection

Projeto desenvolvido com a interface OpenCV para Java.

Requerimentos:
--> Pacote OpenCV para Windows ou Linux : https://opencv.org/releases.html
--> IDE de Programação Netbeans : https://netbeans.org/downloads/

Configurações:
Classpath para adicionar ao projeto
--> -Djava.library.path="C:\opencv310\build\java\x64"
--> "C:\opencv310" é o caminho do pacote instalado no computador

Para detecção de olhos
--> this.classificer = new CascadeClassifier("haarcascade_eye.xml");

Para detecção de faces
-- this.classificer = new CascadeClassifier("haarcascade_frontalcatface.xml");

