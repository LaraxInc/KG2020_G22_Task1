package ru.vsu.cs.kozjutenko;

import javax.swing.*;
import java.awt.*;

public class DrawPanel extends JPanel {
    @Override
    public void paint(Graphics g) {
        Graphics2D gr = (Graphics2D) g;
        gr.setColor(new Color(135, 206, 235));
        gr.fillRect(0, 0, getWidth(), getHeight()/2);
        gr.setColor(new Color(0, 0, 128));
        gr.fillRect(0, getHeight()/2, getWidth(), getHeight());

        gr.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        drawBasis(gr,getWidth(), getHeight(), new Color(128, 0, 0), new Color(160, 82, 45));
        drawSail(gr, getWidth(), getHeight(), new Color(255, 248, 220));
        drawWindows(gr, (int)(0.85*getWidth()-420), (int)(0.255*getHeight()+295), 40, 40, new Color(255, 248, 220));
        drawSun(gr, 700, 80, 40, 90, 28, Color.yellow);

        gr.setColor(Color.BLACK);
        gr.setFont(new Font("Arial", Font.BOLD, 25));
        gr.drawString("Свобода",200,420);

    }

    public void drawBasis(Graphics2D gr, int width, int height, Color color, Color colorMast) {
        int[] ArrayX = {(int)(0.85*width-470), (int) (0.85*width-80), (int) (0.85*width), (int) (0.85*width-550)};
        int[] ArrayY = {(int)(0.255*height+340), (int)(0.255*height+340), (int)(0.255*height+250), (int)(0.255*height+250)};
        Polygon p = new Polygon(ArrayX, ArrayY, 4);
        gr.drawPolygon(p);
        gr.setColor(color);
        gr.fillPolygon(p);
        gr.setColor(colorMast);
        gr.fillRect((int)(0.85*width-285), (int)(0.255*height), 10, 250);
    }

    public static void drawSail(Graphics2D gr, int width, int height, Color color) {
        int[] ArrayX1 = {(int)(0.85*width-275), (int)(0.85*width-140), (int)(0.85*width-275)};
        int[] ArrayY2 = {(int)(0.255*height), (int)(0.255*height+220), (int)(0.255*height+220)};
        Polygon pl = new Polygon(ArrayX1, ArrayY2, 3);
        gr.drawPolygon(pl);
        gr.setColor(color);
        gr.fillPolygon(pl);
    }

    public static void drawWindows(Graphics2D gr, int x, int y,int width, int height, Color color) {
        gr.setColor(color);
        for (int i = (int)(0.85*width-420); i < (int)(0.85*width); i += 140) {
            gr.fillOval(i, y, width, height);
        }
    }

    public static void drawSun(Graphics2D gr, int x, int y, int r, int R, int n, Color color) {
        gr.setColor(color);
        gr.fillOval(x - r, y - r, 2 * r, 2 * r);
        double an = 2 * Math.PI / n;
        for (int i = 0; i < n; i++) {
            double dx1 = r * Math.cos(an * i);
            double dy1 = r * Math.sin(an * i);
            double dx2 = R * Math.cos(an * i);
            double dy2 = R * Math.sin(an * i);
            gr.drawLine((int)dx1+x, (int)dy1+y, (int)dx2+x, (int)dy2+y);
        }
    }
}
