package gym.system;


public class People extends Gym{

    public int Age;
    private int NationalID;
    private int PhoneNum;


    public void Report(String msg) {
        System.out.println(msg);
    }

    public int getNationalID() {
        return NationalID;
    }

    public void setNationalID(int nationalID) {
        NationalID = nationalID;
    }

    public int getPhoneNum() {
        return PhoneNum;
    }

    public void setPhoneNum(int phoneNum) {
        PhoneNum = phoneNum;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }
    
    
    
    
}
