
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;


public class Bill {
    private LinkedList<String> foodBill = null;
    private HashMap<LinkedList<String>, Integer> countBill = new HashMap<LinkedList<String>, Integer>();
    private double[] totalsum;
    
    public Bill() {
        this.foodBill = new LinkedList<String>();
    }
    
    public Bill(LinkedList<String> foodBill) {
        this.foodBill = foodBill;
    }

    public LinkedList<String> getFoodBill() {
        return foodBill;
    }

    public void setFoodBill(LinkedList<String> foodBill) {
        this.foodBill = foodBill;
    }
    public void addFoodToBill(String food) {
        foodBill.add(food);
}
    
    
    
    public void countBill(){
         countBill.clear(); // ล้างค่าใน countBill ก่อนที่จะนับใหม่

        for (String food : foodBill) {
            LinkedList<String> foodItem = new LinkedList<String>();
            foodItem.add(food);

            int count = countBill.getOrDefault(foodItem, 0);
            countBill.put(foodItem, count + 1);
    }
    }

    public HashMap<LinkedList<String>, Integer> getCountBill() {
        return countBill;
    }

    public void setCountBill(HashMap<LinkedList<String> ,Integer> countBill) {
        this.countBill = countBill;
    }
    
    
    
    public double convertLinkedListToIntArray(LinkedList<String> linkedList) {
        double[] doubleArray = new double[linkedList.size()];
        double sum = 0.0;
        for (int i = 0; i < linkedList.size(); i++) {
            String element = linkedList.get(i);
            doubleArray[i] = Double.parseDouble(element.split("\\s+")[1]);
        }
        System.out.println(Arrays.toString(doubleArray));
        for (double number : doubleArray) {
            sum += number;
     }

    return sum;
    }

    public double[] getTotalsum() {
        return totalsum;
    }

    public void setTotalsum(double[] totalsum) {
        this.totalsum = totalsum;
    }

   
    
    

}
