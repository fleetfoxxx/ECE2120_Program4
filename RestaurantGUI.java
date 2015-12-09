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

   private JCheckBox allItemsCB;
   private JCheckBox wholesalePriceCB;
   private JCheckBox objectFileCB;

   private JTextArea outputTextArea;
   private JScrollPane outputScrollPane;

   public RestaurantGUI(int width, int height, String name, String fileName, Boolean isObject) {

      super(width, height, name);
      // Create Restaurant Object to manipulate!
      try {
         Restaurant theRestaurant = new Restaurant(name, fileName, isObject);
      } catch (RestaurantException re) {
         System.out.println(re.getMessage());
         System.out.println("Problem creating Restaurant - exiting program.");
         return;
      }

      setResizable(true);
      setUp(width, height);
      setVisible(true);
   }

   private void setUp(int width, int height) {
      setBackground(Color.white);

      // setup GUI elements
      buttonPanel = new JPanel();
      add(buttonPanel, BorderLayout.SOUTH);

      inputPanel = new JPanel();
      add(inputPanel, BorderLayout.WEST);

      // input panel
      EasyGridBag inputPanelBag = new EasyGridBag(15, 2, inputPanel);
      inputPanelBag.setColumnWeight(1, 1.0);
      inputPanelBag.setColumnWeight(2, 10.0);
      inputPanel.setLayout(inputPanelBag);

      reviewerNameLbl = new JLabel("Reviewer Name");
      reviewerRatingLbl = new JLabel("Reviewer Rating");
      reviewDateLbl = new JLabel("Review Date");
      itemNameLbl = new JLabel("Item Name");
      numOrdersLbl = new JLabel("# Orders");
      categoryLbl = new JLabel("Category");
      servingSizeLbl = new JLabel("Serving Size");
      numCaloriesLbl = new JLabel("# Calories");
      retailPriceLbl = new JLabel("Retail Price");
      wholesalePriceLbl = new JLabel("Wholesale Price");
      priceChangeLbl = new JLabel("% Price Change");
      sortFieldLbl = new JLabel("Sort Field");
      sortAlgorithmLbl = new JLabel("Sort Algorithm");

      reviewerName = new JTextField();
      reviewerName.setPreferredSize(new Dimension(150, 24));
      reviewerRating = new JTextField();
      reviewerRating.setPreferredSize(new Dimension(150, 24));
      reviewDate = new JTextField();
      reviewDate.setPreferredSize(new Dimension(150, 24));
      itemName = new JTextField();
      itemName.setPreferredSize(new Dimension(150, 24));
      numOrders = new JTextField();
      numOrders.setPreferredSize(new Dimension(150, 24));
      servingSize = new JTextField();
      servingSize.setPreferredSize(new Dimension(150, 24));
      numCalories = new JTextField();
      numCalories.setPreferredSize(new Dimension(150, 24));
      retailPrice = new JTextField();
      retailPrice.setPreferredSize(new Dimension(150, 24));
      wholesalePrice = new JTextField();
      wholesalePrice.setPreferredSize(new Dimension(150, 24));
      priceChange = new JTextField();
      priceChange.setPreferredSize(new Dimension(150, 24));
      sortField = new JTextField();
      sortField.setPreferredSize(new Dimension(150, 24));
      sortAlgorithm = new JTextField();
      sortAlgorithm.setPreferredSize(new Dimension(150, 24));

      categoryCB = new JComboBox();
      categoryCB.setPreferredSize(new Dimension(150, 24));

      allItemsCB = new JCheckBox();
      wholesalePriceCB = new JCheckBox();
      objectFileCB = new JCheckBox();

      inputPanelBag.fillCellAlignWithinCell(1, 1, GridBagConstraints.WEST, reviewerNameLbl);
      inputPanelBag.fillCellAlignWithinCell(2, 1, GridBagConstraints.WEST, reviewerRatingLbl);
      inputPanelBag.fillCellAlignWithinCell(3, 1, GridBagConstraints.WEST, reviewDateLbl);
      inputPanelBag.fillCellAlignWithinCell(4, 1, GridBagConstraints.WEST, itemNameLbl);
      inputPanelBag.fillCellAlignWithinCell(5, 1, GridBagConstraints.WEST, numOrdersLbl);
      inputPanelBag.fillCellAlignWithinCell(6, 1, GridBagConstraints.WEST, categoryLbl);
      inputPanelBag.fillCellAlignWithinCell(7, 1, GridBagConstraints.WEST, servingSizeLbl);
      inputPanelBag.fillCellAlignWithinCell(8, 1, GridBagConstraints.WEST, numCaloriesLbl);
      inputPanelBag.fillCellAlignWithinCell(9, 1, GridBagConstraints.WEST, retailPriceLbl);
      inputPanelBag.fillCellAlignWithinCell(10, 1, GridBagConstraints.WEST, wholesalePriceLbl);
      inputPanelBag.fillCellAlignWithinCell(11, 1, GridBagConstraints.WEST, priceChangeLbl);
      inputPanelBag.fillCellAlignWithinCell(12, 1, GridBagConstraints.WEST, sortFieldLbl);
      inputPanelBag.fillCellAlignWithinCell(13, 1, GridBagConstraints.WEST, sortAlgorithmLbl);

      inputPanelBag.fillCellAlignWithinCell(1, 2, GridBagConstraints.WEST, reviewerName);
      inputPanelBag.fillCellAlignWithinCell(2, 2, GridBagConstraints.WEST, reviewerRating);
      inputPanelBag.fillCellAlignWithinCell(3, 2, GridBagConstraints.WEST, reviewDate);
      inputPanelBag.fillCellAlignWithinCell(4, 2, GridBagConstraints.WEST, itemName);
      inputPanelBag.fillCellAlignWithinCell(5, 2, GridBagConstraints.WEST, numOrders);
      inputPanelBag.fillCellAlignWithinCell(6, 2, GridBagConstraints.WEST, categoryCB);
      inputPanelBag.fillCellAlignWithinCell(7, 2, GridBagConstraints.WEST, servingSize);
      inputPanelBag.fillCellAlignWithinCell(8, 2, GridBagConstraints.WEST, numCalories);
      inputPanelBag.fillCellAlignWithinCell(9, 2, GridBagConstraints.WEST, retailPrice);
      inputPanelBag.fillCellAlignWithinCell(10, 2, GridBagConstraints.WEST, wholesalePrice);
      inputPanelBag.fillCellAlignWithinCell(11, 2, GridBagConstraints.WEST, priceChange);
      inputPanelBag.fillCellAlignWithinCell(12, 2, GridBagConstraints.WEST, sortField);
      inputPanelBag.fillCellAlignWithinCell(13, 2, GridBagConstraints.WEST, sortAlgorithm);

      // inputPanelBag.fillCellAlignWithinCell(14, 1, GridBagConstraints.WEST, allItemsRB);
      // inputPanelBag.fillCellAlignWithinCell(14, 2, GridBagConstraints.WEST, allItemsRB);
      // inputPanelBag.fillCellAlignWithinCell(15, 1, GridBagConstraints.WEST, allItemsRB);

      // scroll panel
      outputTextArea = new JTextArea(30, 75);
      outputTextArea.setEditable(false);
      JScrollPane outputScrollPane = new JScrollPane(outputTextArea);

      outputScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
      add(outputScrollPane, BorderLayout.EAST);

      // button panel
      EasyGridBag buttonPanelBag = new EasyGridBag(1, 15, buttonPanel);
      buttonPanel.setLayout(buttonPanelBag);

      statusBtn = new JButton("Status");
      allItemNamesBtn = new JButton("All Item Names");
      sortBtn = new JButton("Sort");
      helpBtn = new JButton("Help");
      addBtn = new JButton("+");
      removeBtn = new JButton("-");
      activateBtn = new JButton("Activate");
      discontinueBtn = new JButton("Discontinue");
      orderBtn = new JButton("Order");
      rateItemBtn = new JButton("Raise Item");
      updatePriceBtn = new JButton("Update Price");
      profitBtn = new JButton("Profit");
      avgRatingBtn = new JButton("Average Rating");
      writeFileBtn = new JButton("Write File");

      buttonPanelBag.fillCellCenterWithinCell(1, 1, statusBtn);
      buttonPanelBag.fillCellCenterWithinCell(1, 2, allItemNamesBtn);
      buttonPanelBag.fillCellCenterWithinCell(1, 3, sortBtn);
      buttonPanelBag.fillCellCenterWithinCell(1, 4, helpBtn);
      buttonPanelBag.fillCellCenterWithinCell(1, 5, addBtn);
      buttonPanelBag.fillCellCenterWithinCell(1, 6, removeBtn);
      buttonPanelBag.fillCellCenterWithinCell(1, 7, activateBtn);
      buttonPanelBag.fillCellCenterWithinCell(1, 8, discontinueBtn);
      buttonPanelBag.fillCellCenterWithinCell(1, 9, orderBtn);
      buttonPanelBag.fillCellCenterWithinCell(1, 10, rateItemBtn);
      buttonPanelBag.fillCellCenterWithinCell(1, 11, updatePriceBtn);
      buttonPanelBag.fillCellCenterWithinCell(1, 12, profitBtn);
      buttonPanelBag.fillCellCenterWithinCell(1, 13, avgRatingBtn);
      buttonPanelBag.fillCellCenterWithinCell(1, 14, writeFileBtn);

      pack();
   }

   // actionPerformed definition for ActionListener interface
   public void actionPerformed(ActionEvent ae) {
      // TODO
   }  
}