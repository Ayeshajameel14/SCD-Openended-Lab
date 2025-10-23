public class Person {
    protected String name;
    protected String contact_info;
    protected  int age;
    protected String gender;
    public Person(String name,String contact_info,int age,String gender){
        this.name = name;
        this.contact_info = contact_info;
        this.age = age;
        this.gender = gender;
    }
    public void displayInfo(){
        System.out.println("Name : " + this.name);
        System.out.println("Age: " + age);
        System.out.println("Gender: " + gender);
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setContact_info(String contact_info) {
        this.contact_info = contact_info;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getName(){
        return name;
    }
    public String getContact_info(){
        return contact_info;
    }
    public int getAge(){
        return age;
    }
    public String getGender(){
        return gender;
    }
}