import java.util.Scanner;

public class HotelSystem {
    private static class admin {
        private static String Username = "Hexclan";
        private static String Password= "123";

        public static boolean checkUsername(String user) {
            return (user.equals(Username));
        }
        public static boolean checkPassword(String pass) {
            return (pass.equals(Password));
        }
    }
    public static void main(String[] args){
        System.out.println("\n---------------------------------------------------------");
        System.out.printf("              Welcome to %s hotel\n ",Hotel.hotel_name);
        System.out.println(" -----------------------------------------------------------");
        System.out.println("\n--Please log in to the system--");

        try {
            char question ;
            do {
                Scanner input = new Scanner(System.in);
                System.out.println("\nEnter Username : ");
                String username = input.next();

                System.out.println("\nEnter Password : ");
                String password = input.next();
                if (admin.checkUsername(username) && admin.checkPassword(password)) {

                    System.out.println("\n--Access Granted! Welcome!--");
                    break;
                } else if (admin.checkUsername(username)) {
                    System.out.println("\nInInvalid Password! You cannot log in to the system. Please try again.");
                } else if (admin.checkPassword(password)) {
                    System.out.println("\nInvalid Username! You cannot log in to the system. Please try again.");

                } else {
                    System.out.println("\nInvalid Username & Password! You cannot log in to the system. Please try again.");
                }
                System.out.println("\nContinue : (y/n) ");
                question=input.next().charAt(0);
                if(!(question=='y'||question=='Y'||question=='n'||question=='N')){
                    System.out.println("Invalid Option");
                    System.out.println("\nContinue : (y/n)");
                    question=input.next().charAt(0);
                }
                if(question=='n'||question=='N')return;
            }
            while(question=='y'||question=='Y');

            Scanner in=new Scanner(System.in);
            int in1,in2;
            x:
            do {
                System.out.println("\nEnter your choice :\n1.Display room details\n2.Display room availability \n3.Book\n4.Order food\n5.Checkout\n6.Display reservation details\n7.Revenue\n8.Exit ");
                in1 = in.nextInt();
                switch(in1){
                    case 1: System.out.println("\nChoose room type :\n1. Single Room \n2. Double Room");
                        in2=in.nextInt();
                        Hotel.displayFeatures(in2);
                        break;
                    case 2:System.out.println("\nChoose room type :\n1.VIP Double Room \n2.Eco Double Room \n3.VIP Single Room\n4.Eco Single Room\n");
                        in2 = in.nextInt();
                        Hotel.availability(in2);
                        break;
                    case 3:System.out.println("\nChoose room type :\n1.VIP Double Room \n2.Eco Double Room \n3.VIP Single Room\n4.Eco Single Room\n");
                        in2 = in.nextInt();
                        Hotel.bookroom(in2);
                        break;
                    case 4:
                        System.out.print("\nRoom Number- ");
                        in2 = in.nextInt();
                        if(in2>60)
                            System.out.println("Room doesn't exist");
                        else if(in2>40)
                            Food.order(in2-41,4);
                        else if(in2>30)
                            Food.order(in2-31,3);
                        else if(in2>10)
                            Food.order(in2-11,2);
                        else if(in2>0)
                            Food.order(in2-1,1);
                        else
                            System.out.println("Room doesn't exist");
                        break;
                    case 5:
                        System.out.print("\nRoom Number- ");
                        in2 = in.nextInt();
                        if(in2>60)
                            System.out.println("Room doesn't exist");
                        else if(in2>40)
                            Hotel.deallocate(in2-41,4);
                        else if(in2>30)
                            Hotel.deallocate(in2-31,3);
                        else if(in2>10)
                            Hotel.deallocate(in2-11,2);
                        else if(in2>0)
                            Hotel.deallocate(in2-1,1);
                        else
                            System.out.println("Room doesn't exist");
                        break;
                    case 6:
                        System.out.print("\n=====================\nReservation details- \n======================\n\nEnter room number: ");
                        in2 = in.nextInt();
                        if(in2>60)
                            System.out.println("Room doesn't exist");
                        else if(in2>40)
                            Hotel.display(in2-41,4);
                        else if(in2>30)
                            Hotel.display(in2-31,3);
                        else if(in2>10)
                            Hotel.display(in2-11,2);
                        else if(in2>0)
                            Hotel.display(in2-1,1);
                        else
                            System.out.println("Room doesn't exist");
                        break;
                    case 7:
                        System.out.println("Enter Password");
                            String key;
                            key=in.next();
                            if (admin.checkPassword(key)){
                                System.out.println("Total revenue is : " +Hotel.getRevenue()+ "EGP");
                            }
                            else {
                                System.out.println("Wrong Password..!");
                            }
                            break;
                    case 8:break x;
                }
                    System.out.println("\nContinue : (y/n) ");
                    question=in.next().charAt(0);
                    if(!(question=='y'||question=='Y'||question=='n'||question=='N')){
                        System.out.println("Invalid Option");
                        System.out.println("\nContinue : (y/n)");
                        question=in.next().charAt(0);
                    }

            }while(question=='y'||question=='Y');

        }
        catch(Exception e)
        {
            System.out.println("*******NOT VALID INPUT*******");
        }
    }
}
