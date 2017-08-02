# WebCamFaceDetection
WebCam em Java com OpenCV - FaceDetection &amp; EyesDetection

Projeto desenvolvido com a interface OpenCV para Java.

Classpath do projeto --> -Djava.library.path="C:\opencv310\build\java\x64"

Para detecção de olhos
this.classificer = new CascadeClassifier("haarcascade_eye.xml");

Para detecção de faces        
this.classificer = new CascadeClassifier("haarcascade_frontalcatface.xml");
