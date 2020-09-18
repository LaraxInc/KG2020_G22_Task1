package ru.vsu.cs.kozjutenko;

import javax.swing.*;
import java.awt.*;

public class DrawPanel extends JPanel {
    @Override
    public void paint(Graphics g) {
        Graphics2D gr = (Graphics2D) g;
        gr.setColor(new Color(135, 206, 235));
        gr.fillRect(0, 0, 800, 300);
        gr.setColor(new Color(0, 0, 128));
        gr.fillRect(0, 300, 800, 600);
        gr.setColor(new Color(160, 82, 45));
        gr.fillRect(390, 150, 10, 250);


        int[] ArrayX = {220, 580, 650, 150};
        int[] ArrayY = {500, 500, 400, 400};
        Polygon p = new Polygon(ArrayX, ArrayY, 4);
        gr.drawPolygon(p);
        gr.setColor(new Color(128, 0, 0));
        gr.fillPolygon(p);

        int[] ArrayX1 = {400, 570, 400};
        int[] ArrayY2 = {155, 350, 350};
        Polygon pl = new Polygon(ArrayX1, ArrayY2, 3);
        gr.drawPolygon(pl);
        gr.setColor(new Color(255, 248, 220));
        gr.fillPolygon(pl);

        drawWindows(gr, 240, 430, 40, 40, Color.white);
        drawSun(gr, 700, 80, 40, 90, 28, Color.yellow);

        gr.setColor(Color.BLACK);
        gr.setFont(new Font("Arial", Font.BOLD, 25));
        gr.drawString("Свобода",200,420);
    }

    public static void drawWindows(Graphics2D gr, int x, int y, int width, int height, Color color) {
        gr.setColor(color);
        for (int i = 240; i < 600; i += 140) {
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

