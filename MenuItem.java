public class MenuItem {
  private String item_name;
  private int num_calories;
  private String price;
  private boolean heart_healthy;

  public MenuItem (String item_name, int num_calories,
                   String price, boolean heart_healthy) {

    this.item_name = item_name;
    this.num_calories = num_calories;
    this.price = price;
    this.heart_healthy = heart_healthy;
  }

  public String getitem_name(){
    return item_name;
  }
  public int getnum_calories(){
    return num_calories;
  }
  public String getPrice(){
    return price;
  }

  public boolean isHeartHealthy() {
    return heart_healthy;
  }


  public String toString() {

    String heartHealthyLabel = (heart_healthy) ? "(Heart Healthy)" : "";
    return String.format("%s (%d cal.) $%s %s", item_name, num_calories, price, heartHealthyLabel);
  }

}
