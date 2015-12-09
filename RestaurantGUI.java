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
      String name = ""; String fileName = ""; Boolean isObject;

      if (args.length >= 3) {
         name = args[0];
         fileName = args[1];
         isObject = Boolean.parseBoolean(args[2]);
      }
      else if (args.length == 2) {
         name = args[0];
         fileName = args[1];
         isObject = false;
      }
      else {
         System.out.println("Usage: java RestaurantDriver restName fileName isObject");
         return;
      }
      RestaurantGUI rg = new RestaurantGUI(800, 480, name, fileName, isObject);
	}

   private JPanel windowPanel;
   private JPanel topPanel;
   private JPanel inputPanel;
   private JPanel buttonPanel;

   private JLabel reviewerNameLbl;
   private JLabel reviewerRatingLbl;
   private JLabel reviewDateLbl;
   private JLabel itemNameLbl;
   private JLabel numOrdersLbl;
   private JLabel categoryLbl;
   private JLabel servingSizeLbl;
   private JLabel numCaloriesLbl;
   private JLabel retailPriceLbl;
   private JLabel wholesalePriceLbl;
   private JLabel priceChangeLbl;
   private JLabel sortFieldLbl;
   private JLabel sortAlgorithmLbl;

   private JTextField reviewerName;
   private JTextField reviewerRating;
   private JTextField reviewDate;
   private JTextField itemName;
   private JTextField numOrders;
   private JTextField servingSize;
   private JTextField numCalories;
   private JTextField retailPrice;
   private JTextField wholesalePrice;
   private JTextField priceChange;
   private JTextField sortField;
   private JTextField sortAlgorithm;

   private JButton statusBtn;
   private JButton allItemNamesBtn;
   private JButton sortBtn;
   private JButton helpBtn;
   private JButton addBtn;
   private JButton removeBtn;
   private JButton activateBtn;
   private JButton discontinueBtn;
   private JButton orderBtn;
   private JButton rateItemBtn;
   private JButton updatePriceBtn;
   private JButton profitBtn;
   private JButton avgRatingBtn;
   private JButton writeFileBtn;

   private JComboBox categoryCB;

   private JRadioButton allItemsRB;
   private JRadioButton wholesalePriceRB;
   private JRadioButton objectFileRB;

   private JScrollPane outputScrollPane;

   public RestaurantGUI(int width, int height, String name, String fileName, Boolean isObject) {

      super(width, height, name);
      // Create Restaurant Object to manipulate!
      try {
         Restaurant theRestaurant =new Restaurant(name, fileName, isObject);
      } catch (RestaurantException re) {
         System.out.println(re.getMessage());
         System.out.println("Problem creating Restaurant - exiting program.");
         return;
      }

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

      topPanel = new JPanel();
      topPanel.setBackground(Color.green);
      topPanel.setLayout(new GridLayout(1, 2));
      windowPanel.add(topPanel);

      


   }

   // actionPerformed definition for ActionListener interface
   public void actionPerformed(ActionEvent ae) {
      // TODO
   }  
}