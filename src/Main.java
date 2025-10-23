import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Visitor v1 = new Visitor("Ayesha","ayeshajameel765@gmail.com",18, "Female", 5.5f, 1001);
        Visitor v2 = new Visitor("Asiya","asiyarajpoot456@gmail.com",19,"Female",5.6f,1002);
        Visitor v3 = new Visitor("Mariyam","mariyamaltaf234@gmail.com",10,"Female",3.7f,1003);
        Visitor v4 = new Visitor("Paras","paras237@gmail.com",15,"Female",4.4f,1004);
        Visitor v5 = new Visitor("Maria","maria489@gmail.com",9,"Female",3.0f,1005);

        ArrayList<Visitor> visitors = new ArrayList<>();
        visitors.add(v1);
        visitors.add(v2);
        visitors.add(v3);
        visitors.add(v4);
        visitors.add(v5);


        Employee e1 = new Employee("Faizan","faizan152@gmail.com",27,"Male",11,50000,"10pm to 10am");
        e1.setDuty("Morning security guard!");
        Employee e2 = new Employee("Sher Muhammad","sherMuhammad852gmail.com",22,"Male", 12, 50000, "10am to 10pm");
        e2.setDuty("Night security guard!");
        Employee e3 = new Employee("Muzammil","muzammilarian25@gmail.com",30,"Male",13,100000,"10am to 1pm");
        e3.setDuty("Manager!");
        Employee e4 = new Employee("Talha","talhaarian16@gmail.com",45,"Male",14,40000,"10am to 10pm");
        e4.setDuty("Roller Coaster Ride Operator!");
        Employee e5 = new Employee("Hamza","hamza43@gmail.com",35,"Male",15,30000,"10am to 10pm");
        e5.setDuty("Bumpers Car Ride Operator!");
        Employee e6 = new Employee("Inamullah","inam158@gmail.com",45,"Male",16,25000,"10am to 10pm");
        e6.setDuty("Ferris Wheel ride Operator!");

        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);
        employees.add(e4);
        employees.add(e5);
        employees.add(e6);

        Ride r1 = new Ride("Roller Coaster",4f,10,e4,50, 100, "15 minute","10am to 10pm");
        Ride r2 = new Ride("Bumper Car",3f,18,e5,2,150,"10 minutes","10am to 10pm");
        Ride r3 = new Ride("Ferris Wheel",4.4f,25,e6,50,200,"20 minutes","10am to 10pm");

         ArrayList<Ride> rides = new ArrayList<>();
         rides.add(r1);
         rides.add(r2);
         rides.add(r3);

        TicketManagement ticketManagement = new TicketManagement("Ayesha's Amusement Park",visitors,employees,rides);

        while (true) {
            System.out.println("---->  Welcome To Ayesha's Amusement Park <----");

            System.out.println("\n==> Visitor Management");
            System.out.println("\t1. Register new visitor");
            System.out.println("\t2. Remove Visitor");
            System.out.println("\t3. Update visitor");
            System.out.println("\n==> Employee Management");
            System.out.println("\t4. Register new Employee");
            System.out.println("\t5. Remove Employee");
            System.out.println("\t6. Update Employee");
            System.out.println("\n==> Ride Management");
            System.out.println("\t7. Add new Ride");
            System.out.println("\t8. Remove Ride ");
            System.out.println("\t9. Update Ride Information");
            System.out.println("\n==> Park Management");
            System.out.println("\t10. Buy Ticket");
            System.out.println("\t11. Display Park Information");
            System.out.println("\t12. See Analytics");
            System.out.println("\n\t0. Exit");


            Scanner sc = new Scanner(System.in);
            System.out.println("Enter Choice :");
            int choice = sc.nextInt();
            switch (choice) {
                case 1 -> ticketManagement.registerVisitor();
                case 2 -> ticketManagement.removeVisitor();
                case 3 -> ticketManagement.updateVisitor();
                case 4 -> ticketManagement.addEmployee();
                case 5 -> ticketManagement.removeEmployee();
                case 6 -> ticketManagement.updateEmployee();
                case 7 -> ticketManagement.addNewRide();
                case 8 -> ticketManagement.removeRide();
                case 9 -> ticketManagement.updateRide();
                case 10 -> ticketManagement.buyTicket();
                case 11-> ticketManagement.displayParkInformation();
                case 12-> ticketManagement.seeAnalytics();
                case 0 -> System.exit(1);
                default -> System.out.println("Wrong input try again!!");
            }
        }
    }
}