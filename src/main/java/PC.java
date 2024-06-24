public class PC extends PC2{
    int a;
    public PC(int i) {// here we have created a constructor for the variable that will be passed when object is created
        super(i);          // here super is used to define the varialbe in PC2 as it is inherited in this class
        this.a=i;         //this. is used to call the variable used in the current class
    }

    public int increment(){
        a=a+1;
        return a;
    }
    public int decrement(){
        a=a-1;
        return a;
    }


}
