package rotation;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class RotationPlot {

    private JFrame frame;
    private RotationPanel rotPanel;

    class RotationPanel extends JPanel {

        public void paintComponent(Graphics g) {
            int width = this.getWidth();
            int height = this.getHeight();
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, width, height);            
            g.setColor(Color.GREEN);

            float a = 500.0f;
            float b = (a * a);
            int c = 300;
            int xs = 1;
            int ys = 1;
            int s = 0;
            int xOffset = width / 2;
            int yOffset = height / 2;
            float p = 0.0f;
            float q = 0.0f;
            float r = 0.0f;
            float y = 0.0f;
            float m = 0.0f;
            float n = 0.0f;

            for (int x = 0; x <= a; x = x + xs)
            {
                s = (x*x);
                p = (float)Math.sqrt(b-s);
                
                for (int i = (int)(p); i >= (int)(p * -1); i = i - (6 * ys))
                {
                    r = (float)Math.sqrt(s+(i*i))/a;
                    q = (r-1) * (float)Math.sin(24*r);
                    y = (float)(i/3.0)+(q*c);
                    
                    if (i == (int)(p))
                    {
                        m = y;
                        n = y;
                    }

                    if (y > m)
                    {
                        m = y;
                        g.drawLine((int)(x*-1) + xOffset, (int)(y) + yOffset, (int)(x*-1) + xOffset, (int)(y) + yOffset);
                        g.drawLine((int)(x) + xOffset, (int)(y) + yOffset, (int)(x) + xOffset, (int)(y) + yOffset);
                    }

                    if (y < n)
                    {
                        n = y;
                        g.drawLine((int)(x*-1) + xOffset, (int)(y) + yOffset, (int)(x*-1) + xOffset, (int)(y) + yOffset);
                        g.drawLine((int)(x) + xOffset, (int)(y) + yOffset, (int)(x) + xOffset, (int)(y) + yOffset);
                    } 
                }
            }
        }
    }

    public RotationPlot() {
        
    }

    void go() {
        rotPanel = new RotationPanel();
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(rotPanel);
        frame.setSize(1024, 800);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        RotationPlot drawing = new RotationPlot();
        drawing.go();
    }

}