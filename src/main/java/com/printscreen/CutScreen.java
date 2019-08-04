package com.printscreen;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;


public class CutScreen {
        private String saveDir;     //存放图片的路径
        private String name;        //包括后缀的图片全称
        private String imageFormat; //图片存储格式，即后缀
        private String imageName;   //图片的名字，不包括后缀
        private Dimension screen;   //屏幕
        private Rectangle screenRectangle;      //矩形框

        public CutScreen() {
            saveDir = "D:\\image";
            screen = Toolkit.getDefaultToolkit().getScreenSize();
            screenRectangle = new Rectangle(screen);
            imageFormat = "png";
        }

        public void captureScreen() {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
            imageName = sdf.format(new Date());     //默认名字
            name = imageName + "." + imageFormat;

            File imageDir = new File(saveDir);
            if (!imageDir.exists()) {   //如果路径不存在，则创建
                imageDir.mkdirs();
            }

            //截屏
            BufferedImage image = null;
            try {
                Robot robot = new Robot();  //记得抛异常
                image = robot.createScreenCapture(screenRectangle);
            } catch (AWTException e) {
                e.printStackTrace();
            }
            try {
                ImageIO.write(image, imageFormat, new File(imageDir, name));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void captureScreen(String imageName) {
            this.imageName = imageName;
            name = imageName + "." + imageFormat;

            File imageDir = new File(saveDir);
            if (!imageDir.exists()) {   //如果路径不存在，则创建
                imageDir.mkdirs();
            }

            //截屏
            BufferedImage image = null;
            try {
                Robot robot = new Robot();  //记得抛异常
                image = robot.createScreenCapture(screenRectangle);     //获取指定的图片
            } catch (AWTException e) {
                e.printStackTrace();
            }
            try {
                ImageIO.write(image, imageFormat, new File(imageDir, name));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public String getSaveDir() {
            return saveDir;
        }

        public void setSaveDir(String saveDir) {
            this.saveDir = saveDir;
        }

        public String getImageFormat() {
            return imageFormat;
        }

        public void setImageFormat(String imageFormat) {
            this.imageFormat = imageFormat;
        }

        public String getImageName() {
            return imageName;
        }

    }

