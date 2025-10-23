import java.util.ArrayList;
public class Visitor extends Person{
    private float height;
    private int visitorID;

    public Visitor(String name,String contact_info,int age,String gender,float height, int visitorID){
        super(name,contact_info,age,gender);
        this.height = height;
        this.visitorID = visitorID;
    }
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Visitor ID: " + visitorID);
        System.out.println("Height: " + height);
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void setVisitorID(int visitorID) {
        this.visitorID = visitorID;
    }

    public float getHeight() {
        return height;
    }
    public int getVisitorID(){
        return visitorID;
    }

    public String toString(){
        return "Name : " + name +
                "VisitorId : " + visitorID +
                "Contact Information : "+ contact_info +
                "Age :" + age + "Years" +
                "Gender : " + gender +
                "Height :" + height + "ft";
    }
}