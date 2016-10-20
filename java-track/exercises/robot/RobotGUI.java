package robot;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RobotGUI {

  private JFrame frmComputerMenuVersion;
  private DefaultListModel<Robot> listModel;
  private JList list;
  private JFrame frmRobot;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          RobotGUI window = new RobotGUI();
          window.frmRobot.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the application.
   */
  public RobotGUI() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frmRobot = new JFrame();
    frmRobot.setTitle("Robot");
    frmRobot.setBounds(100, 100, 924, 271);
    frmRobot.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frmRobot.getContentPane().setLayout(null);
    
    
    JButton btnAddRobot = new JButton("Add Robot");
    btnAddRobot.setBounds(12, 12, 171, 25);
    btnAddRobot.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        String name = getString("What is the robot's name?", "Add Robot");
        int posX = (int)getPositiveValue("What is the x position of the robot?", "X Position");
        int posY = (int)getPositiveValue("What is the y position of the robot?", "Y Position");
        int speed = (int)getPositiveValue("What is the robot's speed?", "Speed");
        Direction direction = getDirection("What direction is the robot facing?[north, south, east, or west]", "Direction");
        Robot r = new Robot(name, posX, posY, speed, direction);
        System.out.println(r.toString());
        System.out.println("size before add: " + listModel.size());
        listModel.add(listModel.size(), r);
        System.out.println("size after add: " + listModel.size());
        System.out.println(listModel.get(0).toString());
      }
    });
    frmRobot.getContentPane().add(btnAddRobot);
    
    JButton btnMoveRobot = new JButton("Move Robot");
    btnMoveRobot.setBounds(12, 49, 171, 25);
    btnMoveRobot.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        int selected = list.getSelectedIndex();
        listModel.get(selected).toString();
        listModel.get(selected).move();
      }
    });
    frmRobot.getContentPane().add(btnMoveRobot);
    
    JButton btnRotateRobot = new JButton("Rotate Robot");
    btnRotateRobot.setBounds(12, 86, 171, 25);
    btnRotateRobot.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        //use yes_no_cancel, yes = left, no = right. replace text obviously.
      }
    });
    frmRobot.getContentPane().add(btnRotateRobot);
    
    JButton btnComputeDistance = new JButton("Compute Distance");
    btnComputeDistance.setBounds(12, 123, 171, 25);
    btnComputeDistance.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // open up a dialog window with a list to select the second robot
      }
    });
    frmRobot.getContentPane().add(btnComputeDistance);
    
    listModel = new DefaultListModel<Robot>();
    list = new JList(listModel);
    list.setBounds(195, 12, 708, 136);
    frmRobot.getContentPane().add(list);
    
  }
  
  private String getString(String prompt, String title)
  {
    String s = (String)JOptionPane.showInputDialog(
               frmComputerMenuVersion,
               prompt,
               title, JOptionPane.PLAIN_MESSAGE,
               null,
               null,
               "");
    while (s.equals("")) {
      s = (String)JOptionPane.showInputDialog(
           frmComputerMenuVersion,
           prompt + "(Please enter a non-empty name.)",
           title, JOptionPane.PLAIN_MESSAGE,
           null,
           null,
           "");
    }
    return s;
  }
  
  private double getPositiveValue(String prompt, String title)
  {
    String s = (String)JOptionPane.showInputDialog(
               frmComputerMenuVersion,
               prompt,
               title, JOptionPane.PLAIN_MESSAGE,
               null,
               null,
               "");
    double d = Double.parseDouble(s);
    while (d < 0) {
      s = (String)JOptionPane.showInputDialog(
           frmComputerMenuVersion,
           prompt + "(Please enter a positive value.)",
           title, JOptionPane.PLAIN_MESSAGE,
           null,
           null,
           "");
      d = Double.parseDouble(s);
    }
    return d;
  }
  
  private Direction getDirection(String prompt, String title)
  {
    String s = (String)JOptionPane.showInputDialog(
               frmComputerMenuVersion,
               prompt,
               title, JOptionPane.PLAIN_MESSAGE,
               null,
               null,
               "");
    boolean isDirection = false;
    for (Direction d : Direction.values()) {
      if (s.toUpperCase().equals(d.toString())) {
        isDirection = true;
        break;
      }
    }
    while (!isDirection) {
      s = (String)JOptionPane.showInputDialog(
           frmComputerMenuVersion,
           prompt ,
           title, JOptionPane.PLAIN_MESSAGE,
           null,
           null,
           "");
      for (Direction d : Direction.values()) {
        if (s.toUpperCase().equals(d.toString())) {
          isDirection = true;
          break;
        }
      }
    }
    if (s.toUpperCase().equals("NORTH")) {
      return Direction.NORTH;
    } else if (s.toUpperCase().equals("SOUTH")) {
      return Direction.SOUTH;
    } else if (s.toUpperCase().equals("EAST")) {
      return Direction.EAST;
    } else {
      return Direction.WEST;
    }
      
  }
}
