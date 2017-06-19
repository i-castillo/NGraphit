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
  private static final String ADD_STRING = "Add more terms!";

  private static final String[] operators = {"=", "+", "-", "*", "/" };
  /* END NEW AGE CONSTANTS */

  private JScrollPane scroll;
  private NGraphitUtils utils;
  private JTextField[] enterFunctionField;
  private JButton addBtn;
  private JComboBox[] comboboxes;
  private JPanel bottomGraphPanel; 
  private int numArguments = 1;


  public NGraphitDisplay(Container pane){


    if (!(pane.getLayout() instanceof BorderLayout)) {
      pane.add(new JLabel("Container doesn't use BorderLayout!"));
      return;
    }

    scroll = new JScrollPane(new NGraphitGraphPane());
    pane.add(scroll, BorderLayout.CENTER);
    scroll.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));


    JPanel bottomPanel = new JPanel();
    pane.add(bottomPanel, BorderLayout.SOUTH);

    addBtn = new JButton(ADD_STRING);
    JButton graphBtn = new JButton(GRAPH_STRING);
    JButton resetBtn = new JButton(RESET_STRING);
    JButton originBtn = new JButton(ORIGIN_STRING);

    enterFunctionField = new JTextField[10];
    enterFunctionField[0] = new JTextField("Enter coefficient: ");

    comboboxes = new JComboBox[10];
    comboboxes[0] = new JComboBox(operators);

    enterFunctionField[0].setPreferredSize( new Dimension( 120, 24 ) );
    GridLayout layout = new GridLayout(2, 0);
    bottomGraphPanel = new JPanel();
    JPanel bottomButtonPanel = new JPanel();

    bottomGraphPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
    bottomPanel.setLayout(layout);
    bottomPanel.add(bottomGraphPanel);
    bottomPanel.add(bottomButtonPanel);
    bottomGraphPanel.add(enterFunctionField[0]);
    bottomGraphPanel.add(comboboxes[0]);
    bottomGraphPanel.add(addBtn);
    bottomButtonPanel.add(graphBtn);
    bottomButtonPanel.add(resetBtn);
    bottomButtonPanel.add(originBtn);

    Rectangle bounds = scroll.getViewport().getViewRect();
    Dimension size = scroll.getViewport().getViewSize(); 
    int x = (size.width - bounds.width) / 2 - pane.getWidth() / 2;
    int y = (size.height - bounds.height) / 2 - pane.getHeight() / 2;
    scroll.getViewport().setViewPosition(new Point(x, y));


    addBtn.addActionListener(this);
    graphBtn.addActionListener(this);
    resetBtn.addActionListener(this);
    originBtn.addActionListener(this);

    utils = new NGraphitUtils();

  }
  public static void createAndShowGUI(){

    //the main graph frame
    JFrame mainFrame = new JFrame(PROGRAM_NAME);
    mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    mainFrame.setSize(CANVAS_WIDTH, CANVAS_HEIGHT);
    new NGraphitDisplay(mainFrame);  


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
      case ADD_STRING:
        addFields();
        break;
      case ORIGIN_STRING:
        origin();
        break;

      default:

    }

  }

  public void addFields(){
    if(numArguments < 10){
      System.out.println("ut oh");
    

    comboboxes[numArguments] = new JComboBox(operators);
    enterFunctionField[numArguments] = new JTextField();
    enterFunctionField[numArguments].setPreferredSize( new Dimension( 45, 24 ) );
    bottomGraphPanel.add(enterFunctionField[numArguments]);
    
    bottomGraphPanel.add(comboboxes[numArguments]);
    bottomGraphPanel.add(addBtn);
    numArguments++;
    bottomGraphPanel.revalidate();
    }
  }

  public void graph(){
    utils.parseString(enterFunctionField[0].getText());
  }


  public void reset(){
    
  }

  public void origin(){ 

    Rectangle bounds = scroll.getViewport().getViewRect();
    Dimension size = scroll.getViewport().getViewSize();    
    int x = (size.width - bounds.width) / 2;
    int y = (size.height - bounds.height) / 2;
    scroll.getViewport().setViewPosition(new Point(x, y));
  }


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
