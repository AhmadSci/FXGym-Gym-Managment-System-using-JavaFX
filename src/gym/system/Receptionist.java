/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gym.system;

/**
 *
 * @author Lenovo
 */
public class Receptionist extends Employee{
    
    public Receptionist(String name, int Age , int ID, int PhoneNum, int NationalID, String Address , int WorkingHrs){
        this.name = name;
        this.Age = Age;
        this.ID = ID;
        this.WorkingHrs = WorkingHrs;
        this.setPhoneNum(PhoneNum);
        this.setNationalID(NationalID);
        this.setAddress(Address);
        this.setRate(25);
    }
    
    public void viewProfile(){
        System.out.println("Name: "+this.name+"\n"+"ID : "+this.ID+"\n"+"WorkingHrs: "+this.WorkingHrs+"\n"+"PhoneNum: "+this.getPhoneNum()+"\n"+"NationalID: "+this.getNationalID()+"\n"+"Address: "+this.getAddress()+"\n"+"Salary: "+this.SalaryChk());  
    }
}
