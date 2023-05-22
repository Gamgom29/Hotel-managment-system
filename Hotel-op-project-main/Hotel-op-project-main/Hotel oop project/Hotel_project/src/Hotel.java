import java.util.Scanner;

public class Hotel {
    static Scanner in = new Scanner(System.in);
    static String hotel_name = "HEX_CLAN";
    private static int revenue = 0;

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
           Holder.getArr1()[r_no]=new Doubleroom(name,contact,gender,name2,contact2,gender2,true);
       }
       else if(i==2){
           Holder.getArr2()[r_no]=new Doubleroom(name,contact,gender,name2,contact2,gender2,false);
       }
       else if(i==3){
           Holder.getArr3()[r_no]=new Singleroom(name,contact,gender,true);
       }
       else if(i==4){
           Holder.getArr4()[r_no]=new Singleroom(name,contact,gender,false);
       }
   }
   static void displayFeatures(int choice){
       Integer type;
       boolean type2 = false;
       System.out.println("\nChoose room type :\n1. VIP Room \n2. Eco Room");
       type = in.nextInt();
       if (type == 1 ) type2 = true;
       else if (type == 2 ) type2 = false;
       if (choice == 1){
           Singleroom singleroom = new Singleroom(type2);
           singleroom.features();
       }
       else if (choice == 2){
           Doubleroom doubleroom = new Doubleroom(type2);
           doubleroom.features();
       }
   }

   static void bookroom (int j)
   {
       int r_no;
       System.out.println("\nThe valid room number is: ");
       switch (j){
           case 1:
               for(int i = 0; i< Holder.getArr1().length; i++)
                       System.out.print(i + 1 + ",");
               System.out.print("\n\nEnter room number: ");
               try{
                   r_no=in.nextInt();
                   r_no--;
                   if(Holder.getArr1()[r_no]!=null) {
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
               for(int i = 0; i< Holder.getArr2().length; i++)
               {
                       System.out.print(i+11+",");
               }
               System.out.print("\n\nEnter room number: ");
               try{
                   r_no=in.nextInt();
                   r_no=r_no-11;
                   if(Holder.getArr2()[r_no]!=null)
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
               for(int i = 0; i< Holder.getArr3().length; i++)
               {
                       System.out.print(i+31+",");
               }
               System.out.print("\n\nEnter room number: ");
               try{
                   r_no=in.nextInt();
                   r_no=r_no-31;
                   if(Holder.getArr3()[r_no]!=null) {
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
               for(int i = 0; i< Holder.getArr4().length; i++)
               {
                       System.out.print(i+41+",");
               }
               System.out.print("\n\nEnter room number: ");

               // Exception handling
               try{
                   r_no=in.nextInt();
                   r_no=r_no-41;
                   if(Holder.getArr4()[r_no]!=null)
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
               return;
       }
                System.out.println("\n--Room Booked--");
   }
    static void availability(int j)
    {
        switch (j) {
            case 1:
                Holder.doubleRoomAvailability(Holder.getArr1());
                break;
            case 2:
                Holder.doubleRoomAvailability(Holder.getArr2());
                break;
            case 3:
                Holder.singleRoomAvailability(Holder.getArr3());
                break;
            case 4:
                Holder.singleRoomAvailability(Holder.getArr4());
                break;
            default:
                System.out.println("Enter valid option");
                break;
        }
    }
     static void display(int r_no ,int r_type){
       double amount=0;
       if(r_type==1){
           Doubleroom.roomDetails(Holder.getArr1(),r_no);
       }
       else if (r_type==2){
           Doubleroom.roomDetails(Holder.getArr2(),r_no);
           }

       else if (r_type==3){
           Singleroom.roomDetails(Holder.getArr3(),r_no);
       }
       else if (r_type==4){
          Singleroom.roomDetails(Holder.getArr4(),r_no);
       }
       else
          /* System.out.println("NOT VALID");*/
         System.out.println("\nTOTAL AMOUT- EGP"+amount);
     }
     static void deallocate(int r_no,int r_type){
    char q;
    if(r_type==1){
        if(Holder.getArr1()[r_no]!=null)
            System.out.println("Room used by "+ Holder.getArr1()[r_no].getName());
        else {
            System.out.println("Already Empty");
            return;
        }
        System.out.println("\nDo you want to checkout ?(y/n)");
        q=in.next().charAt(0);
        if(q=='y'||q=='Y') {
            System.out.println("\n********************************");
            System.out.println("            CHECK OUT :-");
            System.out.println("********************************");
            Doubleroom.roomDetails(Holder.getArr1(),r_no);
            revenue+=Doubleroom.calcAmount(Holder.getArr1(),r_no);
            Holder.getArr1()[r_no]=null;
            System.out.println("\n--Deallocated succesfully--");
        }
    }
    else if(r_type==2){
        if(Holder.getArr2()[r_no]!=null)
            System.out.println("Room used by "+ Holder.getArr2()[r_no].getName());
        else {
            System.out.println("Already Empty");
            return;
        }
        System.out.println("\nDo you want to checkout ?(y/n)");
        q=in.next().charAt(0);
        if(q=='y'||q=='Y') {
            System.out.println("\n********************************");
            System.out.println("            CHECK OUT :-");
            System.out.println("********************************");
            Doubleroom.roomDetails(Holder.getArr2(),r_no);
            revenue+=Doubleroom.calcAmount(Holder.getArr2(),r_no);
            Holder.getArr2()[r_no]=null;
            System.out.println("\n--Deallocated succesfully--");
        }
    }
    else if(r_type==3){
        if(Holder.getArr3()[r_no]!=null)
            System.out.println("Room used by "+ Holder.getArr3()[r_no].getName());
        else {
            System.out.println("Already Empty");
            return;
        }
        System.out.println("\nDo you want to checkout ?(y/n)");
        q=in.next().charAt(0);
        if(q=='y'||q=='Y') {
            System.out.println("\n********************************");
            System.out.println("            CHECK OUT :-");
            System.out.println("********************************");
            Singleroom.roomDetails(Holder.getArr3(),r_no);
            revenue+=Singleroom.calcAmount(Holder.getArr3(),r_no);
            Holder.getArr3()[r_no]=null;
            System.out.println("\n--Deallocated succesfully--");
        }
    }
    else if(r_type==4){
        if(Holder.getArr4()[r_no]!=null)
            System.out.println("Room used by "+ Holder.getArr4()[r_no].getName());
        else {
            System.out.println("Already Empty");
            return;
        }
        System.out.println("\nDo you want to checkout ?(y/n)");
        q=in.next().charAt(0);
        if(q=='y'||q=='Y') {
            System.out.println("\n********************************");
            System.out.println("            CHECK OUT :-");
            System.out.println("********************************");
            Singleroom.roomDetails(Holder.getArr4(),r_no);
            revenue+=Singleroom.calcAmount(Holder.getArr4(),r_no);
            Holder.getArr4()[r_no]=null;
            System.out.println("\n--Deallocated succesfully--");
        }
    }
    else
        System.out.println("\nEnter valid option : ");
     }
    public static int getRevenue() {
       return revenue;
    }
}