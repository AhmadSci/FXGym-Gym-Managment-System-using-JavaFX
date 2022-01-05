package gym.system;

public class Employee extends People {
//this is attributes :)
    private int Salary;
    public int WorkingHrs = 8;
    private int WorkingDays = 30;
    private int Rate = 25;
    private int DiscountF = 25;
    private int Discount = 20;
    private String Address;

    // this is functions ;(
    public int SalaryChk() {
        Salary = WorkingHrs*Rate*WorkingDays;
        return Salary;
    }
// this is getter and setter :P
    public int getWorkingHrs() {
        return WorkingHrs;
    }

    public void setWorkingHrs(int workingHrs) {
        WorkingHrs = workingHrs;
    }

    public int getWorkingDays() {
        return WorkingDays;
    }

    public void setWorkingDays(int workingDays) {
        WorkingDays = workingDays;
    }

    public int getRate() {
        return Rate;
    }

    public void setRate(int rate) {
        Rate = rate;
    }

    public int getDiscountF() {
        return DiscountF;
    }

    public void setDiscountF(int discountF) {
        DiscountF = discountF;
    }

    public int getDiscount() {
        return Discount;
    }

    public void setDiscount(int discount) {
        Discount = discount;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public int getSalary() {
        return Salary;
    }

    public void setSalary(int Salary) {
        this.Salary = Salary;
    }
    
    
    
}
