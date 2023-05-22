import java.util.Scanner;

public class Food {
    private int itemno ;
    private int quantitiy;
    private float price ;
    static Scanner in = new Scanner(System.in);

    public Food(int itemno, int quantitiy ) {
        this.itemno = itemno;
        this.quantitiy = quantitiy;
        if(itemno == 1)
            price=quantitiy*3;
        else if(itemno == 2)
            price=quantitiy*10;
        else if(itemno==3)
            price= quantitiy*6;
        else if(itemno == 4)
            price=quantitiy*2;
        else {
            System.out.println("Invalid Option..!");
        }
    }

    public int getItemno() {
        return itemno;
    }

    public int getQuantitiy() {
        return quantitiy;
    }

    public float getPrice() {
        return price;
    }
   static void order(int r_no,int r_type){
       int i,j;
       char q;
       try {
           System.out.println("\n==========\n   Menu:  \n==========\n\n1.Sandwich\tEGP3.00\n2.Pasta\t\tEGP10.00\n3.Noodles\tEGP6.00\n4.Coke\t\tEGP2.00\n");
           do {
               System.out.print("\nEnter your choice- ");
               i = in.nextInt();
               System.out.print("\nFQuantity- ");
               j=in.nextInt();
               if(r_type==1)
                   Holder.getArr1()[r_no].getFood().add(new Food(i,j));
               else if(r_type==2)
                   Holder.getArr2()[r_no].getFood().add(new Food(i,j));
               else if(r_type==3)
                   Holder.getArr3()[r_no].getFood().add(new Food(i,j));
               else if(r_type==4)
                   Holder.getArr4()[r_no].getFood().add(new Food(i,j));
               System.out.println("\nDo you want to order anything else ? (y/n)");
               q=in.next().charAt(0);
           }while(q=='y'||q=='Y');
       }
       catch (NullPointerException e) {
           System.out.println("\nRoom not booked");
       }
       catch (Exception e){
           System.out.println("Cannot be done");
       }
   }
}
