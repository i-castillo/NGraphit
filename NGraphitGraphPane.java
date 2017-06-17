import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

public class NGraphitGraphPane extends JPanel {

  private static Graphics2D g2;
  private static final int GRAPH_WIDTH = 600;
  private static final int GRAPH_HEIGHT = 600;
  private Point origin = new Point(GRAPH_WIDTH / 2, GRAPH_HEIGHT / 2);

  public void paintComponent(Graphics g){
    super.paintComponent(g);
    System.out.println(getWidth() + " s" + origin.x);
    System.out.println(getHeight() + " s" + origin.y);
    g2 =(Graphics2D) g;

    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON);
    //line thickness width
    g2.setStroke(new BasicStroke(2));

    g2.drawLine(0, origin.y, getWidth(), origin.y);
    g2.drawLine(origin.x, 0, origin.x, getHeight());

    g2.setStroke(new BasicStroke(1));

    g2.drawString("AMRI AND ISAAC \u00a9", 10, 20);
  }

  public Dimension getPreferredSize() {
    return new Dimension(GRAPH_WIDTH, GRAPH_HEIGHT);
  }

}
