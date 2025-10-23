import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class TicketManagement {
    private String ParkName;
    private ArrayList<Ticket> ticketsSold = new ArrayList<>();
    private ArrayList<Visitor> visitors = new ArrayList<>();
    private ArrayList<Ride> rides = new ArrayList<>();
    private ArrayList<Employee> employees = new ArrayList<>();
    private Report todayReport = null;

    public TicketManagement(String parkName,ArrayList<Visitor> visitors,ArrayList<Employee> employees,ArrayList<Ride> rides){
        this.ParkName = parkName;
        this.visitors = visitors;
        this.employees = employees;
        this.rides = rides;
    }

    public String getParkName() {
        return ParkName;
    }

    public void setParkName(String parkName) {
        ParkName = parkName;
    }

    public Visitor registerVisitor() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name : ");
        String name = sc.nextLine();
        System.out.println("Enter id : ");
        int id = sc.nextInt();
        System.out.println("Enter Contact Information :");
        sc.skip("\\R");
        String contact_info = sc.nextLine();
        System.out.println("Enter age :");
        int age = sc.nextInt();
        System.out.println("Enter Gender :");
        sc.skip("\\R");
        String gender = sc.nextLine();
        System.out.println("Enter your height :");
        float height = sc.nextFloat();

        // check visitor list
        for (int i = 0; i < visitors.size(); i++) {
            if (visitors.get(i).getVisitorID() == id) {
                System.out.println("There is already existing visitor.");
                System.out.println("Enter new Id : ");
                id = sc.nextInt();
                break;
            }
        }
        Visitor v = new Visitor(name, contact_info, age, gender, height, id);
        visitors.add(v);
        System.out.println("Your details ");
        v.displayInfo();
        return v;
    }

    public void updateVisitor() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your Id :");
        int id = sc.nextInt();
        boolean check = false;
        for (int i = 0; i < visitors.size(); i++) {
            if (visitors.get(i).getVisitorID() == id) {
                System.out.println("Your Information\n");
                Person p = visitors.get(i);
                p.displayInfo();
                visitors.remove(visitors.get(i));
                check = true;
                break;
            }
        }
        if (check) {
            Visitor v = registerVisitor();
            System.out.println("Visitor new information\n");
            v.displayInfo();
        } else
            System.out.println("Visitor not Found!!!");
    }

    public void removeVisitor() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Id :");
        int id = sc.nextInt();
        boolean check = false;
        for (int i = 0; i < visitors.size(); i++) {
            if (visitors.get(i).getVisitorID() == id) {
                visitors.remove(visitors.get(i));
                check = true;
                break;
            }
        }
        if(check)
            System.out.println("Visitor removed from the system successfully!!!");
        else
            System.out.println("Visitor not found!!!");
    }

    public void buyTicket() {
        // display available rides
        System.out.println("Rides Available ");
        for (int i = 0; i < rides.size(); i++) {
            Ride r = rides.get(i);
            System.out.println((i + 1) + " : " + r);
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter ride no :");
        int n = sc.nextInt();
        System.out.println("Enter your id :");
        int id = sc.nextInt();
        System.out.println("Enter your rideTime :");
        sc.skip("\\R");
        String rideTime = sc.nextLine();
        Ride r = rides.get(n - 1);
        String rideName = r.getName();
        int ticketPrice = r.getPrice();
        int ageLimit = r.getAgeLimit();
        float heightLimit = r.getHeightLimit();

        Visitor v = null;
        boolean check = false;
        // check visitor
        for (int i = 0; i < visitors.size(); i++) {
            if (visitors.get(i).getVisitorID() == id) {
                v = visitors.get(i);
                check = true;
                break;
            }
        }
        if (!check) {
            System.out.println("Register yourself first!!");
            v = registerVisitor();
        }
        int age = v.getAge();
        float height = v.getHeight();
        if(age < ageLimit )
        {
            System.out.println("Sorry you can not ride this ride because your age " + age + "years that is less then the age limit " + ageLimit + "years of this ride ");
        }
        else if (height < heightLimit){
            System.out.println("Sorry you can not ride this ride because your height " + height + "ft that is less then the height limit " + heightLimit + "ft of this ride ");
        }
        else{
            LocalDate currentDate = LocalDate.now();
            Ticket t = new Ticket(ticketsSold.size() + 1, ticketPrice, rideName, v, rideTime, currentDate);
            System.out.println("Your Ticket details\n");
            t.displayTicket();
            ticketsSold.add(t);
        }
    }

    public Ride addNewRide() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter ride details :");
        System.out.println("Enter ride name :");
        String name = sc.nextLine();
        System.out.println("Enter min age limit : ");
        int ageLimit = sc.nextInt();
        System.out.println("Enter min height limit :");
        float heightLimit = sc.nextFloat();
        System.out.println("Enter capacity :");
        int capacity = sc.nextInt();
        System.out.println("Enter price :");
        int price = sc.nextInt();
        System.out.println("Enter Duration :");
        sc.skip("\\R");
        String duration = sc.nextLine();
        System.out.println("Enter Schedule :");
        String schedule = sc.nextLine();
        System.out.println("Enter Ride Operator Id :");
        int employeeId = sc.nextInt();
        Employee e = null;
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getEmployeeId() == employeeId) {
                e = employees.get(i);
            }
        }
        e.setDuty(name + " ride operator");
        Ride r = new Ride(name, heightLimit, ageLimit, e, capacity, price, duration, schedule);
        rides.add(r);
        System.out.println("Ride Details : " + r);
        return r;
    }

    public void updateRide() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Ride name :");
        String rideName = sc.nextLine();

        for (int i = 0; i < rides.size(); i++) {
            if (rides.get(i).getName().equalsIgnoreCase(rideName)) {
                System.out.println("Ride old information\n" + rides.get(i));
                rides.remove(rides.get(i));
                break;
            }
        }
        System.out.println("Enter new information of ride");
        Ride r = addNewRide();
        System.out.println("Ride new information\n" + r);
    }

    public void removeRide() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Ride name :");
        String rideName = sc.nextLine();
        for (int i = 0; i < rides.size(); i++) {
            if (rides.get(i).getName().equalsIgnoreCase(rideName)) {
                rides.remove(rides.get(i));
                break;
            }
        }
        System.out.println("Ride removed from the System successfully!!!");
    }

    public Employee addEmployee() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Employee details :");
        System.out.println("Enter Employee name :");
        String name = sc.nextLine();
        System.out.println("Enter Employee id : ");
        int employeeId = sc.nextInt();
        System.out.println("Enter Contact Information :");
        sc.skip("\\R");
        String contact_info = sc.nextLine();
        System.out.println("Enter age :");
        int age = sc.nextInt();
        System.out.println("Enter Gender :");
        sc.skip("\\R");
        String gender = sc.nextLine();
        System.out.println("Enter Employee salary :");
        int salary = sc.nextInt();
        System.out.println("Enter Shift Schedule :");
        sc.skip("\\R");
        String shiftSchedule = sc.nextLine();
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getEmployeeId() == employeeId) {
                System.out.println("this id is matched with already existing employee please change the id");
                employeeId = sc.nextInt();
                break;
            }
        }
        Employee e = new Employee(name, contact_info, age, gender, employeeId, salary, shiftSchedule);
        employees.add(e);
        System.out.println("Employee details\n");
        e.displayInfo();
        return e;
    }

    public void updateEmployee() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Employee id :");
        int employeeId = sc.nextInt();
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getEmployeeId() == employeeId) {
                System.out.println("Old Employee information\n");
                Person p = employees.get(i);
                p.displayInfo();
                employees.remove(employees.get(i));
                break;
            }
        }
        System.out.println("Enter new information of Employee :");
        Employee e = addEmployee();
    }

    public void removeEmployee() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Employee Id :");
        int employeeId = sc.nextInt();
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getEmployeeId() == employeeId) {
                employees.remove(employees.get(i));
                break;
            }
        }
        System.out.println("Employee removed from the System successfully!!!");
    }

    public int displayParkInformation() {
        while (true){
            System.out.println("-------------------------------------------------------------------");
            System.out.println("Park Name : " + ParkName);
            System.out.println("Total Registered Visitors : " + visitors.size());
            System.out.println("Total Employees : " + employees.size());
            System.out.println("Total Rides : " + rides.size());
            System.out.println("1. Display Visitors Data");
            System.out.println("2. Display Employees Data");
            System.out.println("3. Display Rides Data");
            System.out.println("0. Nothing/Exit");
            Scanner sc = new Scanner(System.in);
            int option = sc.nextInt();
            switch (option) {
                case 1 -> displayVisitors();
                case 2 -> displayEmployees();
                case 3 -> displayRides();
                case 0 -> {
                    return 0;
                }
                default -> System.out.println("Wrong input");
            }
        }
    }

    public void displayVisitors(){
        System.out.println("Visitors Data");
        for(int i = 0; i<visitors.size(); i++){
            System.out.print(i+1 + " : ");
            Person p = visitors.get(i);
            p.displayInfo();
        }
    }

    public void displayEmployees(){
        System.out.println("Employees Data");
        for(int i = 0; i<employees.size(); i++){
            System.out.print(i+1 + " : ");
            Person p = employees.get(i);
            p.displayInfo();
        }
    }

    public void displayRides(){
        System.out.println("Rides Data");
        for(int i = 0; i<rides.size(); i++){
            System.out.print(i+1 + " : ");
            rides.get(i).displayRides();
        }
    }
    public void seeAnalytics(){
        int totalVisitors = 0;
        int male = 0;
        int female = 0;
        int totalRevenue = 0;
        int totalTicketSold = ticketsSold.size();
        for (int i = 0; i<ticketsSold.size(); i++){
            Visitor v = ticketsSold.get(i).getVisitor();
            System.out.println(v.getGender());
            if(v.getGender().equalsIgnoreCase("Female")) {
                female++;
            }
            else if(v.getGender().equalsIgnoreCase("Male")) {
                male++;
            }

            totalVisitors++;
            totalRevenue += ticketsSold.get(i).getTicketPrice();
        }
        this.todayReport = new Report(LocalDate.now(),totalTicketSold, totalVisitors,male,female, totalRevenue);
        System.out.println(todayReport);
    }
}