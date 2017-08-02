package facedetection;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Rect;
import org.opencv.objdetect.CascadeClassifier;
import org.opencv.videoio.VideoCapture;

/**
 *
 * @author YU7
 */
public class FrmWebCam extends javax.swing.JFrame implements Runnable {

    private MatOfRect facedetect;
    private CascadeClassifier classificer;
    private VideoCapture video;
    private BufferedImage buffImage;
    private Mat frame;

    public FrmWebCam() {
        initComponents();
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        this.classificer = new CascadeClassifier("haarcascade_eye.xml");
        this.facedetect = new MatOfRect();
        
    }

    @Override
    public void run() {
        this.video = new VideoCapture(0);
        frame = new Mat();
        if (video.isOpened()) {
            while (true) {
                video.read(frame);
                if (!frame.empty()) {
                    MatToBufferedImage(frame);
                    classificer.detectMultiScale(frame, facedetect);
                    this.repaint();
                }
            }
        }
    }


    public void MatToBufferedImage(Mat mat) {

        int altura = mat.width();
        int largura = mat.height();
        int canais = mat.channels();

        byte[] source = new byte[altura * largura * canais];
        mat.get(0, 0, source);
        buffImage = new BufferedImage(altura, largura, BufferedImage.TYPE_3BYTE_BGR);
        final byte[] saida = ((DataBufferByte) buffImage.getRaster().getDataBuffer()).getData();
        System.arraycopy(source, 0, saida, 0, source.length);

    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel(){
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (buffImage == null) {
                    return;
                }

                g.drawImage(buffImage, 10, 20, buffImage.getWidth(), buffImage.getHeight(), null);

                g.setColor(Color.green);

                for (Rect aux : facedetect.toArray()) {
                    g.drawRect(aux.x + 10, aux.y + 10, aux.height, aux.width);
                }

            }
        };
        jMenuBar1 = new javax.swing.JMenuBar();
        menuSair = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("WEBCAM");
        setPreferredSize(new java.awt.Dimension(600, 500));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        menuSair.setText("Sair");
        menuSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuSairMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuSair);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menuSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuSairMouseClicked
        // TODO add your handling code here:
        this.video.release();
        System.exit(0);
    }//GEN-LAST:event_menuSairMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenu menuSair;
    // End of variables declaration//GEN-END:variables

}
