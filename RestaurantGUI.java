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

public class RestaurantGUI extends CenterFrame {
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

      String categories[] = {"MAIN", "DESSERT", "SIDE", "DRINK"};

      categoryCB = new JComboBox(categories);
      categoryCB.setPreferredSize(new Dimension(150, 24));

      allItemsCB = new JCheckBox("All Items");
      wholesalePriceCB = new JCheckBox("Wholesale Price");
      objectFileCB = new JCheckBox("Object File");

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

      inputPanelBag.fillCellAlignWithinCell(14, 1, GridBagConstraints.WEST, allItemsCB);
      inputPanelBag.fillCellAlignWithinCell(14, 2, GridBagConstraints.WEST, wholesalePriceCB);
      inputPanelBag.fillCellAlignWithinCell(15, 1, GridBagConstraints.WEST, objectFileCB);

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
      statusBtn.addActionListener(new ButtonListener());

      allItemNamesBtn = new JButton("All Item Names");
      allItemNamesBtn.addActionListener(new ButtonListener());

      sortBtn = new JButton("Sort");
      sortBtn.addActionListener(new ButtonListener());

      helpBtn = new JButton("Help");
      helpBtn.addActionListener(new ButtonListener());

      addBtn = new JButton("+");
      addBtn.addActionListener(new ButtonListener());

      removeBtn = new JButton("-");
      addBtn.addActionListener(new ButtonListener());

      activateBtn = new JButton("Activate");
      activateBtn.addActionListener(new ButtonListener());

      discontinueBtn = new JButton("Discontinue");
      discontinueBtn.addActionListener(new ButtonListener());

      orderBtn = new JButton("Order");
      orderBtn.addActionListener(new ButtonListener());

      rateItemBtn = new JButton("Raise Item");
      rateItemBtn.addActionListener(new ButtonListener());

      updatePriceBtn = new JButton("Update Price");
      updatePriceBtn.addActionListener(new ButtonListener());

      profitBtn = new JButton("Profit");
      profitBtn.addActionListener(new ButtonListener());

      avgRatingBtn = new JButton("Average Rating");
      avgRatingBtn.addActionListener(new ButtonListener());

      writeFileBtn = new JButton("Write File");
      writeFileBtn.addActionListener(new ButtonListener());

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

   private class ButtonListener implements ActionListener {
         public void actionPerformed(ActionEvent e) {

            switch(e.getActionCommand) {
               case "Status":
                  System.out.println(theRestaurant);
               break;

               case "All Item Names":
                  doNames(theRestaurant);
               break;

               case "Sort":
                  doSortWork(theRestaurant);
               break;

               case "help":

               break;

               case "+":
                  doAddItem(theRestaurant);
               break;

               case "-":
                  doRemoveItem(theRestaurant);
               break;

               case "Activate":
                  doActivateItem(theRestaurant);
               break;

               case "Discontinue":
                  doDiscontinueItem(theRestaurant);
               break;

               case "Order":
                  doOrderItem(theRestaurant);
               break;

               case "Raise Item":

               break;

               case "Update Price":
                  doUpdatePrice(theRestaurant);
               break;

               case "Average Rating":
                  doAverageItemRating(theRestaurant);
               break;

               case "Write File":
                  doWriteFile(theRestaurant);
               break;

               default:
               break; 
            }
         }
   }

   private static void doNames(Restaurant rest)
    {
        ArrayList<String> names = rest.getAllItemNames();
        System.out.println("The restaurant item names are as follows:");
        for (String name: names)
        {
            System.out.println(name);
        }        
    }
    
    private static void doAddItem(Restaurant rest)
    {
        System.out.println("Processing add...");
        String name = key.readString("Please enter the item name. ");
        MenuCategory[] categories = MenuCategory.values();
        System.out.println("Category choices:");
        for (MenuCategory mc : categories)
        {
            System.out.println(" " + mc);
        }
        String cat = key.readString("Please enter the item category. ");
        try
        {
           MenuCategory category = MenuCategory.valueOf(cat.toUpperCase());
           int servingSize = key.readInt("Please enter the serving size in ounces. ");
           int numCalories = key.readInt("Please enter the number of calories. ");          
           double price = key.readDouble("Please enter the retail price. ");
           double wholesale = key.readDouble("Please enter the wholesale cost. ");
           boolean success = rest.addToMenu(name, category, servingSize, numCalories, price, wholesale);
           if (success)
           {
               System.out.println("Item " + name + " added successfully.");
           }
           else
           {
               System.out.println("Item " + name + " not added successfully.");
           }
        }
        catch (RestaurantException re)
        {
            System.out.println(re.getMessage());
            System.out.println("Item " + name + " not added to menu.");
        }
        catch (IllegalArgumentException iae)
        {
            System.out.println("Invalid category -- item " + name + " not added to menu.");
        }
    }
    
    private static void doRemoveItem(Restaurant rest)
    {
        System.out.println("Processing remove...");
        String name = key.readString("Please enter the name of the item to be removed from the menu. ");
        if (rest.removeFromMenu(name))
        {
            System.out.println(name + " successfully removed from menu.");
        }
        else
        {
            System.out.println(name + " unsuccessfully removed from menu.");
        }
    }
    
    private static void doActivateItem(Restaurant rest)
    {
        System.out.println("Processing activate...");
        String choice = key.readString("Activate all? (y/n): ");
        if (choice.equalsIgnoreCase("n"))
        {
            String name = key.readString("Please enter the name of the item to be activated on the menu. ");
            if (rest.activate(name))
            {
                System.out.println(name + " successfully activated on menu.");
            }
            else
            {
                System.out.println(name + " unsuccessfully activated on menu.");
            }
        }
        else if (choice.equalsIgnoreCase("y"))
        {
            rest.activate();
            System.out.println("Activated all items on menu.");
        }
        else
        {
            System.out.println("Invalid choice.  Need y or n.");
        }
    }
    
    private static void doDiscontinueItem(Restaurant rest)
    {
        System.out.println("Processing discontinue...");
        String choice = key.readString("Discontinue all? (y/n): ");
        if (choice.equalsIgnoreCase("n"))
        {
            String name = key.readString("Please enter the name of the item to be discontinued on the menu. ");
            if (rest.discontinue(name))
            {
                System.out.println(name + " successfully discontinued on menu.");
            }
            else
            {
                System.out.println(name + " unsuccessfully discontinued on menu.");
            }
        }
        else if (choice.equalsIgnoreCase("y"))
        {
            rest.discontinue();
            System.out.println("Discontinued all items on menu.");
        }
        else
        {
            System.out.println("Invalid choice. Need y or n.");
        }
    }
    
    private static void doUpdatePrice(Restaurant rest)
    {
        System.out.println("Processing price update...");
        int percent = key.readInt("Please enter the price change percentage. ");
        String wholesale = key.readString("Wholesale? (y/anything else): ");
        boolean isWholesale = false;
        if (wholesale.equalsIgnoreCase("y"))
        {
            isWholesale = true;
        }
        String choice = key.readString("Update all prices? (y/n): ");
        if (choice.equalsIgnoreCase("n"))
        {
            String name = key.readString("Please enter the name of the item to have its price changed. ");
            if (rest.updatePrice(isWholesale, name, percent))
            {
                System.out.println("Price for " + name + " successfully changed.");
            }
            else
            {
                System.out.println("Price for " + name + " unsuccessfully changed.");
            }
        }
        else if (choice.equalsIgnoreCase("y"))
        {
            if (rest.updatePrice(isWholesale, percent))
            {
                System.out.println("Successfully changed prices for all items on menu.");
            }
            else
            {
                System.out.println("Unsuccessfully changed prices for all items on menu.");
            }
        }
        else
        {
            System.out.println("Invalid choice. Need y or n.");
        }
    }
    
    private static void doRateItem(Restaurant rest)
    {
        System.out.println("Processing item rating...");
        String itemName = key.readString("Please enter the item name. ");
        String reviewerName = key.readString("Please enter the reviewer name. ");
        String date = key.readString("Please enter the date (mm/dd/yyyy). ");
        int rating = key.readInt("Please enter the rating. ");
        try
        {
            boolean success = rest.addRating(itemName, reviewerName, date, rating);
            if (success)
            {
                System.out.println("Rating successfully added for " + itemName);
            }
            else
            {
                System.out.println("Rating unsuccessfully added for " + itemName);
            }
        }
        catch (RestaurantException re)
        {
            System.out.println(re.getMessage());
            System.out.println("Rating unsuccessfully added for " + itemName);
        }
    }
    
    private static void doOrderItem(Restaurant rest)
    {
        System.out.println("Processing item ordering...");
        String itemName = key.readString("Please enter the item name. ");
        int numOrders = key.readInt("Please enter the number of orders. ");
        boolean success = rest.order(itemName, numOrders);
        if (success)
        {
            System.out.println(numOrders + " of " + itemName + " successfully processed.");
        }
        else
        {
            System.out.println(numOrders + " of " + itemName + " unsuccessfully processed.");
        }
    }
    
    private static void doProfit(Restaurant rest)
    {
        System.out.println("Processing profit...");
        System.out.println("The total profit of restaurant " + rest.getName() + " is " + FMT.format(rest.getTotalProfit()) + ".");
    }
    
    private static void doAverageItemRating(Restaurant rest)
    {
        System.out.println("Processing average item rating...");
        System.out.println("The average rating for menu items at restaurant " + rest.getName() + " is " + FMT.format(rest.getAverageItemRating()).substring(1) + ".");
    }
    
    private static void doWriteFile(Restaurant rest)
    {
        //System.out.println("Processing write file...");
        String fileName = key.readString("Please enter the name of the output file.");
        boolean isObject = key.readString("Is the file to be an object file? (y/anything else): ").equalsIgnoreCase("Y") ? true : false;
        try
        {
            rest.writeToFile(fileName, isObject);
            //System.out.println((isObject ? "Object" : "Text") + " file " + fileName + " written successfully.");
        }
        catch (RestaurantException re)
        {
            System.out.println(re.getMessage());
            //System.out.println("File written unsuccessfully.");
        }        
    }
    
    private static void doSortWork(Restaurant rest)
    {
        System.out.println("Processing sort...");
        int sortField;
        do
        {
            showSortFieldMenu();          
            sortField = key.readInt("Enter the sort field: ");
        } while (sortField < 1 || sortField > 3);
        int sortAlg;
        do
        {
            showSortAlgorithmMenu();
            sortAlg = key.readInt("Enter the algorithm number: ");
        } while (sortAlg < 1 || sortAlg > 2);
        String result = rest.sort(sortField, sortAlg);
        System.out.println("Sort results:\n" + result);
    }

    private static void doSortWork(Restaurant rest)
    {
        System.out.println("Processing sort...");
        int sortField;
        do
        {
            showSortFieldMenu();          
            sortField = key.readInt("Enter the sort field: ");
        } while (sortField < 1 || sortField > 3);
        int sortAlg;
        do
        {
            showSortAlgorithmMenu();
            sortAlg = key.readInt("Enter the algorithm number: ");
        } while (sortAlg < 1 || sortAlg > 2);
        String result = rest.sort(sortField, sortAlg);
        System.out.println("Sort results:\n" + result);
    }
    
}