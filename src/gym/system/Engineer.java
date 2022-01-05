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
public class Engineer extends Employee{
    private int Experience;
    public boolean check;
    private int amountOfFixes;
    
    public Engineer(String name, int Age , int ID, int PhoneNum, int NationalID, String Address , int amountOfFixes, int Experience){
        this.name = name;
        this.Age = Age;
        this.ID = ID;
        this.amountOfFixes = amountOfFixes;
        this.Experience = Experience;
        this.setPhoneNum(PhoneNum);
        this.setNationalID(NationalID);
        this.setAddress(Address);
        this.setRate(100);
    }
    
    @Override
    public int SalaryChk() {
        this.setSalary(this.getRate()*amountOfFixes*Experience);
        return this.getSalary();
    }
    
    
    
    public String checkup(){
        
        
        if(check){
            return "good";
        }
        else{
            return "there is machine broked";
        }
    }
        
    
    public void repair(String Machine){
        System.out.println("this repair will take 2hr!");
        System.out.println("this machine is now good :)");
        
        
    }
    
    public void viewProfile(){
        System.out.println("Name: "+this.name+"\n"+"ID : "+this.ID+"\n"+"Fixes this Month: "+amountOfFixes+"\n"+"PhoneNum: "+this.getPhoneNum()+"\n"+"NationalID: "+this.getNationalID()+"\n"+"Address: "+this.getAddress()+"\n"+"Salary: "+this.SalaryChk());
    }
    
}
