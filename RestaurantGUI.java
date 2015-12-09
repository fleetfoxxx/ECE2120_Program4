/**
 *  This is going to be the GUI driver.
 *
 *
 * @author Charlie Thomas and Timothy Porter 
 * @date Dec 10, 2015
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RestaurantGUI extends CenterFrame implements ActionListener {

	public static void main(String[] args){
      RestaurantGUI rg = new RestaurantGUI(800, 480);
	}

   private JPanel windowPanel;
   private JPanel controlPanel;

   public RestaurantGUI(int width, int height) {
      super(width, height, "8====D~ (. Y .)");

      setResizable(false);
      setUp(width, height);
      setVisible(true);
   }

   private void setUp(int width, int height) {
      setBackground(Color.white);

      // setup GUI elements

      // panel
      windowPanel = new JPanel();
      windowPanel.setBackground(Color.pink);
      windowPanel.setLayout(new GridLayout(2, 1));
      add(windowPanel);

      controlPanel = new JPanel();
      controlPanel.setBackground(Color.green);
      controlPanel.setLayout(new GridLayout(1, 3));
      windowPanel.add(controlPanel);
   }

   // actionPerformed definition for ActionListener interface
   public void actionPerformed(ActionEvent ae) {
      // TODO
   }  
}