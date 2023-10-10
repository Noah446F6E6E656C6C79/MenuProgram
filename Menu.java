public class Menu {
  private MenuItem[] menu_items;
  private final double tax_rate = 0.06;
  private int current_index = 0;
  private int needed;
  // Constructor
  public Menu() {
    menu_items = new MenuItem[10];
    
    for(int i = 0; i < menu_items.length; i++)
      menu_items[i] = null;
  }

  public void add(MenuItem item) throws NumOrdersExceededException {
    try{
    menu_items[current_index] = item;
    current_index++;}catch(Exception e){
      throw new NumOrdersExceededException("Menu is full.");
    }
    
  }
  public int setNeeded(){
    return this.needed = menu_items.length;
  }
  public int getNeeded(){
    return needed;
  }

  public void reset() {
    current_index = 0;
  }

  public boolean hasNext() {
    return current_index < menu_items.length && menu_items[current_index]!=null;
  }

  public MenuItem nextOrder() {
    if(hasNext()){
      MenuItem order = menu_items[current_index];
      current_index++;
      return order;
    }
    return null;
    
  }
  
}
