import java.time.LocalDate;

public class Ticket {
    private int ticketId;
    private int ticketPrice;
    private String rideName;
    private Visitor visitor;
    private String rideTime;
    private LocalDate date;

    public Ticket(int ticketId, int ticketPrice, String rideName, Visitor visitor, String rideTime, LocalDate date) {
        this.ticketId = ticketId;
        this.ticketPrice = ticketPrice;
        this.rideName = rideName;
        this.visitor = visitor;
        this.rideTime = rideTime;
        this.date = date;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public int getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public String getRideName() {
        return rideName;
    }

    public void setRideName(String rideName) {
        this.rideName = rideName;
    }

    public Visitor getVisitor() {
        return visitor;
    }

    public void setVisitor(Visitor visitor) {
        this.visitor = visitor;
    }

    public String getRideTime() {
        return rideTime;
    }

    public void setRideTime(String rideTime) {
        this.rideTime = rideTime;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
    public void displayTicket(){
        System.out.println("Ticket Id : " + ticketId);
        System.out.println("Visitor Id : " + visitor.getVisitorID());
        System.out.println("Visitor name : " + visitor.getName());
        System.out.println("Ticket Price : " + ticketPrice);
        System.out.println("Ride name : " + rideName);
        System.out.println("Ride time : " + rideTime);
        System.out.println("Date : " + date);
    }
    public String toString(){
        return "Ticket Id :" +ticketId +
                "Visitor id : " + visitor.getVisitorID() +
                "Visitor name : " + visitor.getName() +
                "Ticket Price : " + ticketPrice +
                "Ride name : " + rideName +
                "Ride time : " + rideTime +
                "Date : " + date;
    }
}