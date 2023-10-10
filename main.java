import java.util.*;

class Main {
  public static void main(String[] args) {
    
    Menu restaurant_menu = new Menu();
    Check restaurant_check = new Check();
    populateMenu(restaurant_menu);

    Scanner s = new Scanner(System.in);
    boolean runner = false;

    while(!runner){
      System.out.println("Menu options:");
      System.out.println("1 - View all menu items");
      System.out.println("2 - View heart-healthy items");
      System.out.println("3 - Place order");
      System.out.println("4 - Display check");
      System.out.println("5 - Exit");
      System.out.print("Enter your choice: ");
      int picker = s.nextInt();

      switch(picker){
        case 1:
          displayMenuItems(restaurant_menu);
          break;
        case 2:
          displayHeartHealthyItems(restaurant_menu);
          break;
        case 3:
          placeOrder(restaurant_menu, restaurant_check, s);
          break;
        case 4:
          displayCheck(restaurant_check);
          break;
        case 5:
          runner = true;
          break;
        default:
          System.out.println("Invalid choice. Please try again.");
          break;
      }
      s.nextLine();
    }
    s.close(); 
    
  }

  public static void populateMenu(Menu menu) {
    final boolean heart_healthy = true;
    final boolean not_heart_healthy = false;
    
    menu.add(new MenuItem("Meat Loaf", 450, 
                          "14.50", not_heart_healthy));

		menu.add(new MenuItem("Baked Salmon", 260,
		                      "19.50", heart_healthy));
    menu.add(new MenuItem("Burnt Leftover Steak", 200, "2.50", not_heart_healthy));
    menu.add(new MenuItem("Deep Fried Ice Cream", 320, "8", not_heart_healthy));
    menu.add(new MenuItem("Caeser Salad", 120, "12.50", heart_healthy));
    menu.add(new MenuItem("Fried Rat", 50, ".50", not_heart_healthy));
    menu.add(new MenuItem("Baking sheet wax paper", 3, "200", heart_healthy));
    menu.add(new MenuItem("The Gluttons deluxe special", 3000, "85.50", heart_healthy)); 
	}
  
   public static void displayMenuItems(Menu menu){
     int i=1;
     menu.reset();
     System.out.println();
     while(menu.hasNext()){
       MenuItem item = menu.nextOrder();
       System.out.println(i+" - "+item);
       i++;
     }
   }
  
  public static void placeOrder(Menu menu, Check check, Scanner s) {
    int i=1;
    menu.reset();
    System.out.println("\nAvailable items: ");
    ArrayList<MenuItem> menuItems = new ArrayList<>();
    while(menu.hasNext()){
        MenuItem item = menu.nextOrder();
        menuItems.add(item);
        System.out.println(i+" - "+item);
        i++;
    }
    System.out.println("Enter the number of the item you wish to order: ");
    try {
        int itemNumber = s.nextInt();
        if(itemNumber > 0 && itemNumber <= menuItems.size()){
            MenuItem selectedItem = menuItems.get(itemNumber - 1);
            try{
                check.add(selectedItem);
                System.out.println("Item added to order");
            } catch(Exception e){
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("Invalid choice. Please reenter.");
        }
    } catch (InputMismatchException e) {
        System.out.println("Please enter a valid number.");
        s.next();  // Clear the invalid input
    }
}
  public static void displayHeartHealthyItems(Menu menu){
    int i = 1;
    menu.reset();
    System.out.println();
    while(menu.hasNext()){
        MenuItem item = menu.nextOrder();
        if(item.isHeartHealthy()){
            System.out.println(i+" - "+item);
        }
        i++;
    }
}


  public static void displayCheck(Check check) {
        check.reset();
        double subtotal = 0;
        System.out.println("\nORDERS");
        while (check.hasNext()) {
            MenuItem item = check.nextOrder();
            System.out.println(item);
            subtotal += Double.parseDouble(item.getPrice());
        }
        double tax = subtotal * check.getTaxRate();
        double total = subtotal + tax;
        System.out.printf("SUBTOTAL (before tax)   $%.2f\n", subtotal);
        System.out.printf("TAX (6%%)                $%.2f\n", tax);
        System.out.printf("TOTAL                   $%.2f\n", total);
        System.out.println();
        System.out.printf("RECOMMENDED TIPS\n");
        System.out.printf("10%% tip                 $%.2f\n", total * 1.10);
        System.out.printf("15%% tip                 $%.2f\n", total * 1.15);
        System.out.printf("20%% TIP                 $%.2f\n", total * 1.20);
    }
}
  
