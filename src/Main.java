import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.videoio.VideoCapture;
import org.opencv.highgui.HighGui;

import javax.swing.*;
import java.awt.image.BufferedImage;
import java.util.*;

public class Main {
        static {
            System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        }
/*
    public static void main(String[] args) {
        JFrame window = new JFrame("Просмотр видео");
        window.setSize(1000, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        JLabel label = new JLabel();
        window.setContentPane(label);
        window.setVisible(true);
        VideoCapture capture = new VideoCapture(
                "d:\\video_tutorial.mp4");
        if (!capture.isOpened()) {
            System.out.println("Не удалось открыть видео");
            return;
        }
        Mat frame = new Mat();
        BufferedImage img = null;
        while (capture.read(frame)) {
            Imgproc.resize(frame, frame, new Size(960, 540));
// Здесь можно вставить код обработки кадра
            img = (BufferedImage) HighGui.toBufferedImage(frame);
            if (img != null) {
                ImageIcon imageIcon = new ImageIcon(img);
                label.setIcon(imageIcon);
                label.repaint();
                window.pack();
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {}
        }
        capture.release();
    }
*/

    public static void main(String[] args) {
        Mat mat1 = Imgcodecs.imread("d:\\Lenna.png");
        if (mat1.empty()) {
            System.out.println("Не удалось загрузить изображение");
            return;
        }
        Mat mat2 = new Mat(mat1.width(), mat1.height(), CvType.CV_8UC3);
        Mat mat3 = new Mat();


        Core.repeat(mat1, 3, 3, mat3);

//        List<Mat> list1 = new ArrayList<Mat>();
//        List<Mat> list2 = new ArrayList<Mat>();
//        list1.add(mat2);
//        list1.add(mat1);
//
//        Core.vconcat(list1, mat3);





        showImage(mat3, "Текст в заголовке окна");
    }

    public static void showImage(Mat img, String title) {
        BufferedImage im = (BufferedImage) HighGui.toBufferedImage(img);
        if (im == null) return;
        int w = 1000, h =800;
        JFrame window = new JFrame(title);
        window.setSize(w, h);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setContentPane(new JScrollPane(new JLabel(new ImageIcon(im))));

        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}
