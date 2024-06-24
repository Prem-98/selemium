import org.testng.annotations.Test;

public class CC extends data {

    @Test
    public void getData(){
    doThis();}

    @Test
    public void calculate(){
      PC pc=new PC(4);  // here we are passing 4 as a variable and it will be passed into cuntructor in PC class ans will be used globally
        System.out.println(pc.increment());
        System.out.println(pc.decrement());
        System.out.println(pc.multiplyWith2()); // here multiplyWith2 method can be accessed from PC object only because we have inherited PC2 in PC class

    }
}
