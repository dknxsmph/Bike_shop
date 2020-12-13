import java.util.Scanner;
import java.util.ArrayList;

public class Bike_shop {
    private int count;
    private ArrayList<Bicycle> bicycle = new ArrayList<Bicycle>();
    Cal_price money_admin = new Cal_price();
    Scanner input = new Scanner(System.in);
    
    public Bike_shop() {
        Bicycle a = new Bicycle(Type_bike.Rlaeigh, 600);
        Bicycle b = new Bicycle(Type_bike.Freedom, 600);
        Bicycle c = new Bicycle(Type_bike.Mountain, 1000);
        Bicycle d = new Bicycle(Type_bike.Road, 1500);
        bicycle.add(a);
        bicycle.add(b);
        bicycle.add(c);
        bicycle.add(d);
        Buy();
    }

    public void Buy() {
        try {
            while (true) {
                System.out.println("--------- Welcome to bicycle shop ---------");
                System.out.println("1).Buy");
                System.out.println("2).Edit ( For admin )");
                System.out.println("0).Exit");
                System.out.println("-------------------------------------------");
                System.out.println("Enter your choice: ");
                int select_menu = input.nextInt();
                switch (select_menu) {
                    case 1:
                        if(bicycle.size()>0){
                        System.out.printf("Bicycle is available:%d  \n",bicycle.size());
                        System.out.println(toString());
                        System.out.println("Enter num of bicycle for buy :");
                        int num = input.nextInt();
                        System.out.println("Enter id of bicycle for buy :");
                        int id = input.nextInt();
                        if (match_id(num, id)) {
                            Buy_bike(num - 1);
                        } else {
                            System.out.println("Your enter id not macth num of bike!!");
                        }
                        }else System.out.println("Don't have bike");
                        break;
                    case 2:
                        Admin();
                        break;
                    case 0:
                        System.exit(0);
                    default:
                        System.out.println("Wrong number!!");
                }

            }
        } catch (Exception a) {
            System.out.println("Wrong input!!");
            input.reset();
            input.nextLine();
            Buy();
        }

    }

    public boolean match_id(int num, int id) {
        if (bicycle.get(num - 1).getId_bi() == id) {
            return true;
        } else if ((bicycle.get(num - 1).getId_bi() != id) && (bicycle.get(num - 1) != null)) {
            return false;
        }
        return false;

    }

    public void Buy_bike(int select) {
        System.out.println(bicycle.get(select).getPrice());
        System.out.println("Complete!!");
        money_admin.money += bicycle.get(select).getPrice();
        count++;
        bicycle.remove(select);
     }

    public void Admin() {
        System.out.println("Enter admin's password: ");
        String password = input.next();
        if ("s123".equals(password)) {
            Admin_menu();
        } else {
            System.out.println("Password is incorrect!!");
        }
    }

    public void Admin_menu() {
        System.out.println("  Money: "+money_admin.getMoney()+ " Bath");
        System.out.println("--------------------");
        System.out.println("1).Add bicycle");
        System.out.println("2).Delete bicycle");
        System.out.println("--------------------");
        System.out.println("Enter your choice: ");
        int select = input.nextInt();
        input.nextLine();
        switch (select) {
            case 1:
                add();
                break;
            case 2:
                delete();
                break;
            default:
                System.out.println("Wrong input");
                input.reset();
                Admin_menu();
        }
    }
       public void add() {
        System.out.println("Type of bike");
        System.out.println("1).Freedom bike");
        System.out.println("2).Mountain bike");
        System.out.println("3).Road bike");
        System.out.println("4).Rlaeigh sports");
        System.out.println("Enter your choice: ");
        int num = input.nextInt();
        if (num > 4) {
            System.out.println("Wrong input!!");
            Admin_menu();
        }
        System.out.println("Enter price of bike: ");
        double cost = input.nextDouble();
        Bicycle newBicycle = new Bicycle(Type_bike.values()[num - 1], cost);
        bicycle.add(newBicycle);
    }

    public void delete() {
        System.out.println("Enter num of bike: ");
        int slot = input.nextInt();
        System.out.println("Enter id of bike: ");
        int id = input.nextInt();
        if (match_id(slot, id)) {
            bicycle.remove(slot - 1);
            System.out.println("Complete!!");
        } else {
            System.out.println("Your enter id not macth num of bike!!");
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("-------------------------\n");
        for (int i = 0; i < bicycle.size(); i++) {
            s.append("Num of bike: ").append(i + 1).append(" ").append(bicycle.get(i)).append("\n");
            s.append("-------------------------\n");
        }
        return s.toString();
    }

}
