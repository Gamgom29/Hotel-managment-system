public class Doubleroom extends  Singleroom {
    private String name2 , contact2 , gender2;

    Doubleroom(String name,String contact,String gender,String name2,String contact2,String gender2,boolean VIP){
        super(name , contact ,gender,VIP);
        this.name2=name2;
        this.contact2=contact2;
        this.gender2=gender2;
        this.setBed(2);
        if (VIP){
            this.setPrice(3000);
        }
        else{
            this.setPrice(2000);
        }
    }
    public Doubleroom(boolean VIP){
        super(VIP);
        this.setBed(2);
        if (VIP){
            this.setPrice(3000);
        }
        else{
            this.setPrice(2000);
        }
    }
    /*Over Riding*/
    public static void roomDetails(Doubleroom arr[],int roomNumber){
        String list[]={"Sandwich","Pasta","Noodles","Coke"};
        try {
            System.out.println("Customer name: " + arr[roomNumber].getName());
            System.out.println("\nRoom Charge - EGP" + arr[roomNumber].getPrice());
            System.out.println("\nFood Charges - ");
            System.out.println("Item     Quantity    Price");
            System.out.println("-------------------------");
            for (Food obb : arr[roomNumber].getFood()) {
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
    public static int calcAmount(Doubleroom arr[], int roomNumber){
        String list[]={"Sandwich","Pasta","Noodles","Coke"};
        int amount = 0;
            amount += arr[roomNumber].getPrice();
            for (Food obb : arr[roomNumber].getFood()) {
                amount += obb.getPrice();
            }
            return amount;
    }
}


