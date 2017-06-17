/* This file handles all the displaying and managing of Events. */
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;


public class NGraphitDisplay extends JPanel implements ActionListener{

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
  public NGraphitDisplay(){
    this.addMouseMotionListener(new MouseHandler());
    this.addMouseListener(new MouseHandler());

    graphBtn = new JButton(GRAPH_STRING);
    resetBtn = new JButton(RESET_STRING);

    this.add(graphBtn);
    this.add(resetBtn);

    graphBtn.addActionListener(this);
    resetBtn.addActionListener(this);
  }

  public static void createAndShowGUI(){

    //the main graph frame
    JFrame mainFrame = new JFrame(PROGRAM_NAME);
    mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    mainFrame.setSize(CANVAS_WIDTH, CANVAS_HEIGHT);

    NGraphitDisplay display = new NGraphitDisplay();
    mainFrame.add(display);

    graph = new NGraphitGraphPane();
    bottomPanel = new JPanel();
    display.add(graph);
    display.add(bottomPanel);
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
    public void mouseDragged(MouseEvent evt) {    }
    public void mouseMoved(MouseEvent evt){    }
    public void mouseClicked(MouseEvent evt){    }
    public void mouseEntered(MouseEvent evt){    }
    public void mouseReleased(MouseEvent evt){    }
    public void mousePressed(MouseEvent evt){    }
    public void mouseExited(MouseEvent evt){    }

  }

}
