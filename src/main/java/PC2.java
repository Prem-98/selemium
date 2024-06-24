public class PC2 {

    int a;
    public PC2(int i) {    // here we have created a constructor for the variable that will be passed when object is created
        this.a=i;         //this. is used to call the variable used in the current class
    }

    public int multiplyWith2(){
        a=a*2;
        return a;
    }
    public int multiplyWith3(){
        a=a*3;
        return a;
    }

}
