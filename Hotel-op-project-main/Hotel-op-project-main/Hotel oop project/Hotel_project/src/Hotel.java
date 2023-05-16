import java.util.Scanner;

public class Hotel {
    static Holder hold = new Holder();
    static Scanner in = new Scanner(System.in);

    static String hotel_name = "HEX_CLAN";

   static void Cust_Details(int i , int r_no){
       String name , contact , gender , name2 = null, contact2=null, gender2=null;
       System.out.print("\n--Please fill in customer details--\n");
       System.out.print("\nEnter customer name: ");
       name = in.next();
       System.out.print("Enter contact number: ");
       contact=in.next();
       System.out.print("Enter gender: ");
       gender = in.next();
       if(i<3){
           System.out.print("\nEnter second customer name: ");
           name2 = in.next();
           System.out.print("Enter contact number: ");
           contact2=in.next();
           System.out.print("Enter gender: ");
           gender2 = in.next();
       }

       if( i == 1){
           hold.arr1[r_no]=new Doubleroom(name,contact,gender,name2,contact2,gender2);
       }
       else if(i==2){
           hold.arr2[r_no]=new Doubleroom(name,contact,gender,name2,contact2,gender2);
       }
       else if(i==3){
           hold.arr3[r_no]=new Singleroom(name,contact,gender);
       }
       else if(i==4){
           hold.arr4[r_no]=new Singleroom(name,contact,gender);
       }
   }

   static void bookroom (int j)
   {
       int r_no;
       System.out.println("\nThe valid room number is: ");
       switch (j){
           case 1:
               for(int i=0;i<hold.arr1.length;i++)
               {
                       System.out.print(i+1+",");
               }
               System.out.print("\n\nEnter room number: ");
               try{
                   r_no=in.nextInt();
                   r_no--;
                   if(hold.arr1[r_no]!=null) {
                       throw new NotAvailable();
                   }
                   Cust_Details(j,r_no);
               }
               catch(NotAvailable e)
               {
                   System.out.println(e.toString());
                   return;
               }
               break;
           case 2:
               for(int i=0;i<hold.arr2.length;i++)
               {
                   if(hold.arr2[i]==null)
                   {
                       System.out.print(i+11+",");
                   }
               }
               System.out.print("\n\nEnter room number: ");
               try{
                   r_no=in.nextInt();
                   r_no=r_no-11;
                   if(hold.arr2[r_no]!=null)
                       throw new NotAvailable();
                   Cust_Details(j,r_no);
               }
               catch(NotAvailable e)
               {
                   System.out.println(e.toString());
                   return;
               }
               break;
           case 3:
               for(int i=0;i<hold.arr3.length;i++)
               {
                       System.out.print(i+31+",");
               }
               System.out.print("\n\nEnter room number: ");
               try{
                   r_no=in.nextInt();
                   r_no=r_no-31;
                   if(hold.arr3[r_no]!=null) {
                       throw new NotAvailable() ;
                   }
                   Cust_Details(j,r_no);
               }
               catch(NotAvailable e)
               {
                   System.out.println(e.toString());
                   // invalid option
                   return;
               }
               break;
           case 4:
               for(int i=0;i<hold.arr4.length;i++)
               {
                   if(hold.arr4[i]==null)
                   {
                       System.out.print(i+41+",");
                   }
               }
               System.out.print("\n\nEnter room number: ");

               // Exception handling
               try{
                   r_no=in.nextInt();
                   r_no=r_no-41;
                   if(hold.arr4[r_no]!=null)
                       throw new NotAvailable();
                   Cust_Details(j,r_no);
               }
               catch(NotAvailable e)
               {
                   System.out.println(e.toString());
                   return;
               }
               break;
           default:
               System.out.println("Enter valid option");
               break;
       }
                System.out.println("\n--Room Booked--");
   }
   static void features(int i) {
        switch (i) {
            case 1:System.out.println("\nNumber of double beds : 1\nAC : Yes\nFree breakfast : Yes\nCharge per day: 3000EGP ");
                break;
            case 2:System.out.println("\nNumber of double beds : 1\nAC : No\nFree breakfast : Yes\nCharge per day: 2000EGP  ");
                break;
            case 3:System.out.println("\nNumber of single beds : 1\nAC : Yes\nFree breakfast : Yes\nCharge per day: 1500EGP  ");
                break;
            case 4:System.out.println("\nNumber of single beds : 1\nAC : No\nFree breakfast : Yes\nCharge per day: 900EGP ");
                break;
            default:
                System.out.println("Enter valid option");
                break;
        }
 }
    static void availability(int j)
    {
        int count=0;
        switch (j) {
            case 1:
                for(int i=0;i<10;i++)
                {
                    if(hold.arr1[i]==null)
                        count++;
                }
                break;
            case 2:
                for(int i=0;i<hold.arr2.length;i++)
                {
                    if(hold.arr2[i]==null)
                        count++;
                }
                break;
            case 3:
                for(int i=0;i<hold.arr3.length;i++)
                {
                    if(hold.arr3[i]==null)
                        count++;
                }
                break;
            case 4:
                for(int i=0;i<hold.arr4.length;i++)
                {
                    if(hold.arr4[i]==null)
                        count++;
                }
                break;
            default:
                System.out.println("Enter valid option");
                break;
        }
        System.out.println("Number of rooms available : "+count);
    }
     static void bill (int r_no, int r_type){
       int amount=0;
       String list[]={"Sandwich","Pasta","Noodles","Coke"};
         System.out.println("\n***********");
         System.out.println("   Bill:-");
         System.out.println("***********");
         if(r_type==1){
             amount+=3000;
             System.out.println("\nRoom Charge - EGP"+3000);
             System.out.println("\nFood Charges:- ");
             System.out.println("Item   Quantity    Price");
             System.out.println("-------------------------");
             for(Food obb:hold.arr1[r_no].food ){
                 amount+=obb.price;
                 System.out.printf("%-10s%-10s%-10s%n",list[obb.itemno-1],obb.quantitiy,obb.price);

             }

         }
         else if(r_type==2){
             amount+=2000;
             System.out.println("\nRoom Charge - EGP"+2000);
             System.out.println("\nFood Charges:- ");
             System.out.println("Item   Quantity    Price");
             System.out.println("-------------------------");
             for(Food obb:hold.arr2[r_no].food ){
                 amount+=obb.price;
                 System.out.printf("%-10s%-10s%-10s%n",list[obb.itemno-1],obb.quantitiy,obb.price);

             }
         }
         else if(r_type==3){
             amount+=1500;
             System.out.println("\nRoom Charge - EGP"+1500);
             System.out.println("\nFood Charges:- ");
             System.out.println("Item   Quantity    Price");
             System.out.println("-------------------------");
             for(Food obb:hold.arr3[r_no].food ){
                 amount+=obb.price;
                 System.out.printf("%-10s%-10s%-10s%n",list[obb.itemno-1],obb.quantitiy,obb.price);


             }}

         else if(r_type==4){
                 amount+=900;
                 System.out.println("\nRoom Charge - EGP"+900);
                 System.out.println("\nFood Charges:- ");
                 System.out.println("Item   Quantity    Price");
                 System.out.println("-------------------------");
                 for(Food obb:hold.arr4[r_no].food ){
                     amount+=obb.price;
                     System.out.printf("%-10s%-10s%-10s%n",list[obb.itemno-1],obb.quantitiy,obb.price);
                 }
         }
         else
             System.out.println("NOT VALID ");
         System.out.println("\nTOTAL AMOUNT- EGP "+amount);

     }

     static void display(int r_no ,int r_type){
       double amount=0;
       String list[]={"Sandwich","Pasta","Noodles","Coke"};
       if(r_type==1){
           amount+=3000;
           System.out.println("Customer name: "+hold.arr1[r_no].name);
           System.out.println("\nRoom Charge - EGP"+3000);
           System.out.println("\nFood Charges - ");
           System.out.println("Item     Quantity    Price");
           System.out.println("-------------------------");
           for(Food obb:hold.arr1[r_no].food)
           {
               amount+=obb.price;
               String format = "%-10s%-10s%-10s%n";
               System.out.printf(format,list[obb.itemno-1],obb.quantitiy,obb.price);
           }


       }
       else if (r_type==2){
           amount+=2000;
           System.out.println("Customer name: "+hold.arr2[r_no].name);
           System.out.println("\nRoom Charge - EGP"+2000);
           System.out.println("\nFood Charges - ");
           System.out.println("Item     Quantity    Price");
           System.out.println("-------------------------");
           for(Food obb:hold.arr2[r_no].food)
           {
               amount+=obb.price;
               String format = "%-10s%-10s%-10s%n";
               System.out.printf(format,list[obb.itemno-1],obb.quantitiy,obb.price );
           }
       }
       else if (r_type==3){
           amount+=1500;
           System.out.println("Customer name: "+hold.arr3[r_no].name);
           System.out.println("\nRoom Charge - EGP"+1500);
           System.out.println("\nFood Charges - ");
           System.out.println("Item     Quantity    Price");
           System.out.println("-------------------------");
           for(Food obb:hold.arr3[r_no].food)
           {
               amount+=obb.price;
               String format = "%-10s%-10s%-10s%n";
               System.out.printf(format,list[obb.itemno-1],obb.quantitiy,obb.price );
           }
       }
       else if (r_type==4){
           amount+=900;
           System.out.println("Customer name: "+hold.arr4[r_no].name);
           System.out.println("\nRoom Charge - EGP"+900);
           System.out.println("\nFood Charges - ");
           System.out.println("Item     Quantity    Price");
           System.out.println("-------------------------");
           for(Food obb:hold.arr4[r_no].food)
           {
               amount+=obb.price;
               String format = "%-10s%-10s%-10s%n";
               System.out.printf(format,list[obb.itemno-1],obb.quantitiy,obb.price );
           }
       }
       else
           System.out.println("NOT VALID");
         System.out.println("\nTOTAL AMOUT- EGP"+amount);
     }
     static void deallocate(int r_no,int r_type){
    char q;
    if(r_type==1){
        if(hold.arr1[r_no]!=null)
            System.out.println("Room used by "+hold.arr1[r_no].name);
        else {
            System.out.println("Already Empty");
            return;
        }
        System.out.println("\nDo you want to checkout ?(y/n)");
        q=in.next().charAt(0);
        if(q=='y'||q=='Y') {
            bill(r_no,r_type);
            hold.arr1[r_no]=null;
            System.out.println("\n--Deallocated succesfully--");
        }
    }
    else if(r_type==2){
        if(hold.arr2[r_no]!=null)
            System.out.println("Room used by "+hold.arr2[r_no].name);
        else {
            System.out.println("Already Empty");
            return;
        }
        System.out.println("\nDo you want to checkout ?(y/n)");
        q=in.next().charAt(0);
        if(q=='y'||q=='Y') {
            bill(r_no,r_type);
            hold.arr2[r_no]=null;
            System.out.println("\n--Deallocated succesfully--");
        }
    }
    else if(r_type==3){
        if(hold.arr3[r_no]!=null)
            System.out.println("Room used by "+hold.arr3[r_no].name);
        else {
            System.out.println("Already Empty");
            return;
        }
        System.out.println("\nDo you want to checkout ?(y/n)");
        q=in.next().charAt(0);
        if(q=='y'||q=='Y') {
            bill(r_no,r_type);
            hold.arr3[r_no]=null;
            System.out.println("\n--Deallocated succesfully--");
        }
    }
    else if(r_type==4){
        if(hold.arr4[r_no]!=null)
            System.out.println("Room used by "+hold.arr4[r_no].name);
        else {
            System.out.println("Already Empty");
            return;
        }
        System.out.println("\nDo you want to checkout ?(y/n)");
        q=in.next().charAt(0);
        if(q=='y'||q=='Y') {
            bill(r_no,r_type);
            hold.arr4[r_no]=null;
            System.out.println("\n--Deallocated succesfully--");
        }
    }
    else
        System.out.println("\nEnter valid option : ");

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
                   hold.arr1[r_no].food.add(new Food(i,j));
                   else if(r_type==2)
                   hold.arr2[r_no].food.add(new Food(i,j));
                       else if(r_type==3)
                   hold.arr3[r_no].food.add(new Food(i,j));
                           else if(r_type==4)
                   hold.arr4[r_no].food.add(new Food(i,j));
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

