package gym.system;

import java.util.ArrayList;

public class Machine extends Gym{

    private int Price;
    public String Model;
    private String Status;
    static ArrayList<Machine> Machines = new ArrayList<Machine>();


    public Machine(String name, int Price, int ID, String Model, String status){
        
        this.Price = Price;
        this.name = name;
        this.ID = ID;
        this.Model = Model;
        this.Status = status;
        Machines.add(this);
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int Price) {
        this.Price = Price;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String Model) {
        this.Model = Model;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }
    
    
    
    @Override
   public String toString() {
        return ("Machine Name: "+this.getName()+"\nMachine ID: "+ this.getID() +"\nStatus: "+ this.getStatus() +"\nModel : " + this.getModel());
   }
    
    public static void viewMachines() {
        
        Machines.forEach(machine ->{
            System.out.println(machine.toString());
        });
        
    }

}
