package robot;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RobotGUI {

  private JFrame frmRobot;

  /**
public class RobotGUI {

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
    frmRobot.setBounds(100, 100, 685, 246);
    frmRobot.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frmRobot.getContentPane().setLayout(null);
    
    JList list = new JList();
    list.setBackground(Color.WHITE);
    list.setBounds(667, 203, -451, -188);
    frmRobot.getContentPane().add(list);
    
    JButton btnAddRobot = new JButton("Add Robot");
    btnAddRobot.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
      }
    });
    btnAddRobot.setBounds(12, 12, 171, 25);
    frmRobot.getContentPane().add(btnAddRobot);
    
    JButton btnMoveRobot = new JButton("Move Robot");
    btnMoveRobot.setBounds(12, 49, 171, 25);
    frmRobot.getContentPane().add(btnMoveRobot);
    
    JButton btnRotateRobot = new JButton("Rotate Robot");
    btnRotateRobot.setBounds(12, 86, 171, 25);
    frmRobot.getContentPane().add(btnRotateRobot);
    
    JButton btnComputeDistance = new JButton("Compute Distance");
    btnComputeDistance.setBounds(12, 123, 171, 25);
    frmRobot.getContentPane().add(btnComputeDistance);
  }
}