public class Check {
  private MenuItem[] orders;
  private final double tax_rate = 0.06;
  private int current_index = 0;
  private String price;

  public Check() {
    orders = new MenuItem[4];
    
    for(int i = 0; i < orders.length; i++)
      orders[i] = null;
  }
//No idea why formatting is messed up here, sorry.
  public void add(MenuItem item) throws NumOrdersExceededException
                     {
                       try{
                         for(int i=0; i<orders.length; i++){
      if(orders[i] == null){
        orders[i] = item;
        return;
      }
    }}catch(Exception e){
                         throw new NumOrdersExceededException("Orders array is full");
    }
  }

  public double getTaxRate(){
    return tax_rate;
  }

  public double total() {
    double sum = 0;
    for(MenuItem order : orders){
      if(order!=null){
        sum+= Double.parseDouble(order.getPrice()); //converts price to double
      }
    }
    return sum + (sum*tax_rate);
    
  }
  public void reset() {
    current_index = 0;
  }

  public boolean hasNext() {
    return current_index < orders.length && orders[current_index] != null;
  }

  public MenuItem nextOrder() {
    if(hasNext()){
      return orders[current_index++];
    }
    return null;
  }
}
