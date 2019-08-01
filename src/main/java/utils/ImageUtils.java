package utils;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.net.URL;
import javax.swing.*;

public class ImageUtils extends JFrame{


    private JLabel jlb = new JLabel();
    private ImageIcon image;
    private int width = 600, height = 600;
    public ImageUtils() {
        this.setSize(800, 600);
        this.setLayout(null);

        image = new ImageIcon("C:\\Users\\ASUS\\Desktop\\untitled\\src\\main\\java\\微信图片_20190801214331.jpg");
        // image.setImage(image.getImage().getScaledInstance(width, height,Image.SCALE_DEFAULT));
        Image img = image.getImage();
        img = img.getScaledInstance(width, height, Image.SCALE_DEFAULT);
        image.setImage(img);
        jlb.setIcon(image);

        this.add(jlb);
        jlb.setSize(width, height);
        this.setVisible(true);


    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ImageUtils showImage=new ImageUtils();
    }

}