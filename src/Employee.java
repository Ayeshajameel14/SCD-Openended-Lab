public class Employee extends Person{
    private  int employeeId;
    private String duty;
    private int salary;
    private String shiftSchedule;
    public Employee(String name, String contact_info,int age,String gender,int employeeId,int salary,String shiftSchedule){
        super(name,contact_info,age,gender);
        this.employeeId = employeeId;
        this.duty = "Not Assigned";
        this.salary = salary;
        this.shiftSchedule = shiftSchedule;
    }
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Duty: " + duty);
        System.out.println("Salary: " + salary);
        System.out.println("Shift Schedule: " + shiftSchedule);
    }
    public int getEmployeeId() {
        return employeeId;
    }

    public String getDuty() {
        return duty;
    }

    public int getSalary() {
        return salary;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public void setSalary(int salary) {

        this.salary = salary;
    }

    public void setShiftSchedule(String shiftSchedule) {
        this.shiftSchedule = shiftSchedule;
    }

    public String getShiftSchedule() {
        return shiftSchedule;
    }
    public  String toString(){
        return "Name : " + name +
                "Contact Information : "+ contact_info +
                "Age :" + age +
                "Gender : " + gender +
                "Employee Id :" + employeeId +
                "Employee Duty :" + duty +
                "Salary : " + salary + "Rupees" +
                "Shift Schedule :" + shiftSchedule;
    }
}