import java.lang.reflect.Array;
import java.util.ArrayList;

public class Singleroom{
    private String name , contact , gender;
    private int price;
    private int bed = 1;
    private boolean VIP;
    private String AC , breakfast;
    private ArrayList<Food> food = new ArrayList<>();
    private static int revenue;

    public Singleroom(String name, String contact, String gender,boolean VIP) {
        this(VIP);
        this.name = name;
        this.contact = contact;
        this.gender = gender;
    }
    public Singleroom(boolean VIP) {
        this.VIP = VIP;
        if (VIP){
            price = 1500;
            AC = "Yes";
            breakfast= "Yes";
        }
        else {
            price = 900;
            AC = "No";
            breakfast= "No";
        }
    }
    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setBed(int bed) {
        this.bed = bed;
    }
    public void features(){
        System.out.printf( "%nNumber of beds : %d bed %nAC : %s %nFree breakfast : %s %nPrice : %d%n",
                bed , AC ,breakfast,price);
    }
    public static void roomDetails(Singleroom arr[], int roomNumber){
        String list[]={"Sandwich","Pasta","Noodles","Coke"};
        try {
            System.out.println("Customer name: " + arr[roomNumber].name);
            System.out.println("\nRoom Charge - EGP" + arr[roomNumber].price);
            System.out.println("\nFood Charges - ");
            System.out.println("Item     Quantity    Price");
            System.out.println("-------------------------");
            for (Food obb : arr[roomNumber].food) {
                String format = "%-10s%-10s%-10s%n";
                System.out.printf(format, list[obb.getItemno() - 1], obb.getQuantitiy(), obb.getPrice());

            }
            System.out.println("\nTOTAL AMOUNT- EGP "+calcAmount(arr,roomNumber));
        }
        /*exception handling*/
        catch(Exception e)
        {
            System.out.println("Room Is Empty");
            return;
        }
    }
    public static int calcAmount(Singleroom arr[], int roomNumber){
        String list[]={"Sandwich","Pasta","Noodles","Coke"};
        int amount = 0;
        try {
            amount += arr[roomNumber].price;
            for (Food obb : arr[roomNumber].food) {
                amount += obb.getPrice();
            }
            return amount;
        }
        /*exception handling*/
        catch(Exception e)
        {
            System.out.println("Room Is Empty");
            return 0;
        }
    }
    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }

    public String getGender() {
        return gender;
    }

    public ArrayList<Food> getFood() {
        return food;
    }
}