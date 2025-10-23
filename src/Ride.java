public class Ride {
    private String name;
    private float heightLimit;
    private int ageLimit;
    private Employee rideOperator;
    private int capacity;
    private int price;
    private String duration;
    private String schedule;

    public Ride(String name, float heightLimit, int ageLimit, Employee rideOperator, int capacity, int price, String duration, String schedule) {
        this.name = name;
        this.heightLimit = heightLimit;
        this.ageLimit = ageLimit;
        this.rideOperator = rideOperator;
        this.capacity = capacity;
        this.price = price;
        this.duration = duration;
        this.schedule = schedule;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getHeightLimit() {
        return heightLimit;
    }

    public void setHightLimit(float heightLimit) {
        this.heightLimit = heightLimit;
    }

    public int getAgeLimit() {
        return ageLimit;
    }

    public void setAgeLimit(int ageLimit) {
        this.ageLimit = ageLimit;
    }

    public Employee getRideOperator() {
        return rideOperator;
    }

    public void setRideOperator(Employee rideOperator) {
        this.rideOperator = rideOperator;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public void displayRides(){
        System.out.println("Ride Name : "+ name);
        System.out.println("Height limit : "+ heightLimit);
        System.out.println("Age limit : " + ageLimit);
        System.out.println("Employee name : "+rideOperator.getName());
        System.out.println("Employee Id : " + rideOperator.getEmployeeId());
        System.out.println("Capacity : " + capacity);
        System.out.println("Price : " + price);
        System.out.println("Duration : " + duration);
        System.out.println("Schedule : " + schedule);
    }


    public String toString(){
        return "Ride Name : "+ name+
                "Height limit : "+ heightLimit+
                "Age limit : " + ageLimit +
                "Employee name : "+rideOperator.getName() +
                "Employee Id : " + rideOperator.getEmployeeId() +
                "Capacity : " + capacity +
                "Price : " + price +
                "Duration : " + duration +
                "Schedule : " + schedule;
    }
}