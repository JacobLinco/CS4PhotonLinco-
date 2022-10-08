import java.util.*;

class Store {
  private String name;
  private double earnings;
  private ArrayList<Item> itemList;
  private static ArrayList<Store> storeList = new ArrayList();

  public Store(String name){
      this.name = name;
      this.earnings = 0;
      this.itemList = new ArrayList<>();
      storeList.add(this);
      // Initialize name to parameter and earnings to zero
      // Initialize itemList as a new ArrayList
      // add 'this' store to storeList
  }

  public String getName(){
    return name;
  }
  public double getEarnings(){
    return earnings;
  }
  public void sellItem(int index){
      if(index<=itemList.size()) {
          earnings += itemList.get(index).getCost();
          System.out.printf("You sold %s for %.2f.", itemList.get(index).getName(), itemList.get(index).getCost());
          System.out.printf("%n");
      }
      else {
          System.out.printf("there are only %d items in the store", itemList.size()+1);
          System.out.printf("%n");
      }
    // check if index is within the size of the itemList (if not, print statement that there are only x items in the store)
    // get Item at index from itemList and add its cost to earnings
    // print statement indicating the sale
  }
  
  public void sellItem(String name){
    boolean containItem = false;
    for(Item i : itemList) {
       if(name.equals(i.getName())) {
        containItem = true;
        earnings += i.getCost();
        System.out.printf("You sold %s for %.2f.%n", i.getName(), i.getCost());
        break;
       }
     }
    if(!containItem) {
      System.out.printf("Store does not sell that item.%n");
    }

  
    // check if Item with given name is in the itemList (you will need to loop over itemList) (if not, print statement that the store doesn't sell it)
    // get Item from itemList and add its cost to getEarnings
    // print statement indicating the sale
  }
  
  public void sellItem(Item i){
    if(itemList.contains(i)) {
      earnings += i.getCost();
      System.out.printf("You sold %s for %.2f.%n", i.getName(), i.getCost());
    }
    else {
      System.out.printf("Store does not sell that item.%n");
    }
    // check if Item i exists in the store (there is a method that can help with this) (if not, print statement that the store doesn't sell it)
    // get Item i from itemList and add its cost to getEarnings
    // print statement indicating the sale
  }
  public void addItem(Item i){
    itemList.add(i);
    // add Item i to store's itemList
  }
  
  public void filterType(String type){
    for( Item i : itemList) {
      if(i.getType().equalsIgnoreCase(type)) {
        System.out.printf("%s%n", i.getName());
      }
    }
    System.out.printf("%n");
    // loop over itemList and print all items with the specified type
  }
  
  public void filterCheap(double maxCost){
    for( Item i : itemList) {
      if(i.getCost()<=maxCost) {
      System.out.printf("%s%n", i.getName());
      }
    }
    System.out.printf("%n");    
    // loop over itemList and print all items with a cost lower than or equal to the specified value
  }
  
  public void filterExpensive(double minCost){
    for( Item i : itemList) {
      if(i.getCost()>=minCost) {
      System.out.printf("%s%n", i.getName());
      }
    }
    System.out.printf("%n");
    // loop over itemList and print all items with a cost higher than or equal to the specified value
  }
  public static void printStats(){
    for(Store i : storeList) {
      System.out.printf("store: %s%nearnings: %.2f%n%n",i.getName(),i.getEarnings());
    }
    // loop over storeList and print the name and the earnings'Store.java'
  }
}