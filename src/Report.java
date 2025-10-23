import java.time.LocalDate;

public class Report {
    private LocalDate date;
    private int totalVisitors;
    private int maleVisitors;
    private int femaleVisitors;
    private int totalTicketSold;
    private int totalRevenue;

    public Report(LocalDate date, int totalVisitors, int maleVisitors, int femaleVisitors, int totalTicketSold, int totalRevenue) {
        this.date = date;
        this.totalVisitors = totalVisitors;
        this.maleVisitors = maleVisitors;
        this.femaleVisitors = femaleVisitors;
        this.totalTicketSold = totalTicketSold;
        this.totalRevenue = totalRevenue;

        
    }

    @Override
    public String toString() {
        return  "Date : " + date +
                "\nTotalVisitors : " + totalVisitors +
                "\nMaleVisitors : " + maleVisitors +
                "\nFemaleVisitors : " + femaleVisitors +
                "\nTotalTicketSold : " + totalTicketSold +
                "\nTotalRevenue : " + totalRevenue;
    }
}