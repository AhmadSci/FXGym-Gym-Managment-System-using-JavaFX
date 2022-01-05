package gym.system;

public class Customer extends People{
    public int Invitations=3;
    public int Subscription=30;
    public int FreeDrinks=2;
    public String VipLoungeEntry="true";
    

    public Customer(int ID, String name,String name2 , int Age ,int NationalID, int PhoneNum,int Invitations,int Days,  int FreeDrinks, String VipLoungeEntry){
        this.name = name;
        this.name2 = name2;
        this.Age = Age;
        this.ID = ID;
        this.Subscription=Days;
        this.setPhoneNum(PhoneNum);
        this.setNationalID(NationalID);
        this.Invitations=Invitations;
        this.FreeDrinks =FreeDrinks;
        this.VipLoungeEntry = VipLoungeEntry;
        
    }

    public int getSubscription() {
        return Subscription;
    }

    public void setSubscription(int Subscription) {
        this.Subscription = Subscription;
    }

    public int getFreeDrinks() {
        return FreeDrinks;
    }

    public void setFreeDrinks(int FreeDrinks) {
        this.FreeDrinks = FreeDrinks;
    }

    public String getVipLoungeEntry() {
        return VipLoungeEntry;
    }

    public void setVipLoungeEntry(String VipLoungeEntry) {
        this.VipLoungeEntry = VipLoungeEntry;
    }
    
    public void renewSub(Customer Customer, int Days){
        
        System.out.println(Customer.name+" Has been renewed for "+ Days+ "Days :)");
        
    }

    public int getInvitations() {
        return Invitations;
    }

    public void setInvitations(int Invitations) {
        this.Invitations = Invitations;
    }
    
    
     public void viewProfile(){
        System.out.println("Name: "+this.name+"\n"+"ID : "+this.ID+"\n"+"Subscription: "+this.Subscription+"\n"+"Invitations: "+this.Invitations+"\n"+"Free Drinks: "+this.FreeDrinks+"\n"+"Vip: "+this.VipLoungeEntry+"\n"+"PhoneNum: "+this.getPhoneNum()+"\n"+"NationalID: "+this.getNationalID()+"\n");
        
        
        
        
        
    }

}
