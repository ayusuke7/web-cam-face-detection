package facedetection;

/**
 *
 * @author YU7
 */
public class Main {
    
    public static void main(String[] args) {
        
        FrmWebCam webcam = new FrmWebCam();
        webcam.setVisible(true);
        Thread tr = new Thread(webcam);
        tr.start();
        
    }
    
}
