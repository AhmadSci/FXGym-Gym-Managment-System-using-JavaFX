/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gym.system;

/**
 *
 * @author gamal
 */
public class Coach extends Employee {
//    this is attributes :p
    private String Private = "false";  
    public String Type = "bodybuilding";
    
    //this is constractor to make new coach ;(
    public Coach(String name, int Age , int ID, int PhoneNum, int NationalID, String Address , int WorkingHrs , String Private ){
        this.name = name;
        this.Age = Age;
        this.ID = ID;
        this.WorkingHrs = WorkingHrs;
        this.Private=Private;
        this.setPhoneNum(PhoneNum);
        this.setNationalID(NationalID);
        this.setAddress(Address);
        this.setRate(50);
    }
    
    public void viewProfile(){
        System.out.println("Name: "+this.name+"\n"+"ID : "+this.ID+"\n"+"WorkingHrs: "+this.WorkingHrs+"\n"+"Private: "+this.Private+"\n"+"PhoneNum: "+this.getPhoneNum()+"\n"+"NationalID: "+this.getNationalID()+"\n"+"Address: "+this.getAddress()+"\n"+"Salary: "+this.SalaryChk());  
    }

    public String getPrivate() {
        return Private;
    }

    public void setPrivate(String Private) {
        this.Private = Private;
    }
    
    
    
}
