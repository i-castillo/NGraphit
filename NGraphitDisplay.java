/* This file handles all the displaying and managing of Events. */
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;


public class NGraphitDisplay implements ActionListener{

  /* NEW AGE CONSTANTS */
  private static final int CANVAS_WIDTH = 600;
  private static final int CANVAS_HEIGHT = 600;

  private static final int MAX_NUM_LINES = 6;

  private static final String PROGRAM_NAME = "NGraphit";
  private static final String GRAPH_STRING = "Graphit!";
  private static final String RESET_STRING = "Resetit!";
  private static final String ORIGIN_STRING = "Origin!";

  private static NGraphitGraphPane graph;
  private static JPanel bottomPanel;
  private static JButton graphBtn;
  private static JButton resetBtn;


  /* END NEW AGE CONSTANTS */
  public static void addComponents(Container pane){

    if (!(pane.getLayout() instanceof BorderLayout)) {
      pane.add(new JLabel("Container doesn't use BorderLayout!"));
      return;
    }

    JScrollPane scroll = new JScrollPane(new NGraphitGraphPane());
    pane.add(scroll, BorderLayout.CENTER);
    
    JPanel bottomPanel = new JPanel();
    pane.add(bottomPanel, BorderLayout.SOUTH);

    graphBtn = new JButton(GRAPH_STRING);
    resetBtn = new JButton(RESET_STRING);

    bottomPanel.add(graphBtn);
    bottomPanel.add(resetBtn);


  }
  public static void createAndShowGUI(){

    //the main graph frame
    JFrame mainFrame = new JFrame(PROGRAM_NAME);
    mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    mainFrame.setSize(CANVAS_WIDTH, CANVAS_HEIGHT);
    addComponents(mainFrame);
   // mainFrame.setSize(CANVAS_WIDTH, CANVAS_HEIGHT);

    mainFrame.pack();
    mainFrame.setLocationRelativeTo(null);
    mainFrame.setVisible(true);

  }

  public void actionPerformed(ActionEvent evt) {

    switch(evt.getActionCommand()){

      case GRAPH_STRING:
        graph();
        break;
      case RESET_STRING:
        reset();
        break;

      case ORIGIN_STRING:
        origin();
        break;

      default:

    }

  }

  public void graph(){  }

  public void reset(){  }

  public void origin(){  }


  public Dimension getPreferredSize() {
    return new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT);
  }

  private class KeyHandler implements KeyListener {


    public void keyTyped(KeyEvent ke) {    }
    public void keyPressed(KeyEvent ke) {    }
    public void keyReleased(KeyEvent ke) {    }

  }

  private class MouseHandler implements MouseMotionListener, MouseListener {
    public void mouseDragged(MouseEvent evt) {   }

    public void mouseMoved(MouseEvent evt){    }
    public void mouseClicked(MouseEvent evt){    }
    public void mouseEntered(MouseEvent evt){    }
    public void mouseReleased(MouseEvent evt){    }
    public void mousePressed(MouseEvent evt){    }
    public void mouseExited(MouseEvent evt){    }

  }

}
