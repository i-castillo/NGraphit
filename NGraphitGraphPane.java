import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

public class NGraphitGraphPane extends JPanel {

  
  private static int lineSpacing = 40;
  public NGraphitGraphPane(){
    this.addMouseMotionListener(new MouseHandler());
    this.addMouseListener(new MouseHandler());


  }

  private static Graphics2D g2;
  private static final int GRAPH_WIDTH = 2000;
  private static final int GRAPH_HEIGHT = 2000;
  private Point origin = new Point(GRAPH_WIDTH / 2, GRAPH_HEIGHT / 2);
  private Point mouseCenter;

  @Override
    public void paintComponent(Graphics g){


      super.paintComponent(g);

      g2 =(Graphics2D) g;

      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
          RenderingHints.VALUE_ANTIALIAS_ON);
      //line thickness width
      g2.setStroke(new BasicStroke(2));

      g2.drawLine(0, origin.y, getWidth(), origin.y);
      g2.drawLine(origin.x, 0, origin.x, getHeight());

      g2.setStroke(new BasicStroke(1));

      g2.drawString("AMRI AND ISAAC \u00a9", 10, 20);

      
     drawGreyLinesV2(g2);
    }

  public void drawGreyLinesV2(Graphics2D g2){
    g2.setColor(Color.LIGHT_GRAY);

    for(int i = 0; i < getWidth(); i+=lineSpacing){

    g2.drawLine(i, 0, i, getHeight());

    }
    
    for(int i = 0; i < getHeight(); i+= lineSpacing){

    g2.drawLine(0, i, getWidth(), i);
    }
     
  }
  public synchronized void drawGreyLines(Graphics2D g2) {



    
    //for initial positions of the grey line, shall the viewport be panned
    //j is the position of the first y coordinate for the first horizontal line
    //i is the postition of the frirst x coordinate for the first vertical line
    int j = (getHeight() + origin.y)%lineSpacing;
    int i = (getWidth() + origin.x)%lineSpacing;
    for(; i < getWidth() && j< getHeight(); i+=lineSpacing, j+=lineSpacing){
      //the number labels on the axis
      int hor = (i - origin.x)/lineSpacing;
      int ver = -(j - origin.y)/lineSpacing;

      g2.setColor(Color.LIGHT_GRAY);
      g2.drawLine(i, 0, i ,getHeight());
      g2.drawLine(0, j, getWidth(), j );

      g2.setColor(Color.BLUE);
      g2.setFont(new Font("TimesRoman", Font.PLAIN, 10));

    }
    for(; i < getWidth() && j< getHeight(); i+=lineSpacing, j+=lineSpacing){


      g2.setColor(Color.LIGHT_GRAY);

      g2.drawLine(i, 0, i ,getHeight());

      g2.drawLine(0, j, getWidth(), j );

    }


  }

  private class MouseHandler implements MouseMotionListener, MouseListener {

    public void mouseDragged(MouseEvent me) {

      if (mouseCenter != null) {

        JViewport viewPort = (JViewport)
          SwingUtilities.getAncestorOfClass(JViewport.class,
              NGraphitGraphPane.this);

        if (viewPort != null) {
          int deltaX = mouseCenter.x - me.getX();
          int deltaY = mouseCenter.y - me.getY();

          Rectangle view = viewPort.getViewRect();
          view.x += deltaX;
          view.y += deltaY;


          NGraphitGraphPane.this.scrollRectToVisible(view);
          
        }
      }


    }

    public void mouseMoved(MouseEvent evt){    }
    public void mouseClicked(MouseEvent evt){    }
    public void mouseEntered(MouseEvent evt){    }
    public void mouseReleased(MouseEvent evt){    }
    public void mousePressed(MouseEvent me) {
      mouseCenter = new Point(me.getPoint());
    }
    public void mouseExited(MouseEvent evt){    }

  }

  public Dimension getPreferredSize() {
    return new Dimension(GRAPH_WIDTH, GRAPH_HEIGHT);
  }

}
