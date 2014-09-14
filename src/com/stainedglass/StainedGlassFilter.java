package com.stainedglass;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.imageio.ImageIO;

import edu.wlu.cs.levy.CG.KDTree;

public class StainedGlassFilter {
    private BufferedImage inputImage = null;
    private List<Point> centerPoints;
    KDTree tree = new KDTree(2);
    
    StainedGlassFilter(File input, File output, int points){
        try {
            inputImage = ImageIO.read(input);
        } catch (IOException e) {
        }
        centerPoints = new ArrayList<>();
        Random random = new Random();
        for(int i = 0; i < points; i++) {
            centerPoints.add(new Point(random.nextInt(inputImage.getWidth()), random.nextInt(inputImage.getHeight())));
        }
    }

    public void export(File output) {
        System.out.println(centerPoints);
        BufferedImage outputImage = inputImage;
        for(Point p: centerPoints){
            outputImage.setRGB(p.x, p.y, 255);
        }
        try {
            ImageIO.write(outputImage, "jpg", output);
        } catch (IOException e) {
        }
    }
    
    
}
