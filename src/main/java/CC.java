import org.testng.annotations.Test;

public class CC extends data {

    @Test
    public void getData(){
    doThis();} // here we are able to use doThis method which is written in data class because we have extended CC class to data class

    @Test
    public void calculate(){
      PC pc=new PC(4);  // here we are passing 4 as a variable and it will be passed into constructor in PC class and will be used globally
        System.out.println(pc.increment());
        System.out.println(pc.decrement());
        System.out.println(pc.multiplyWith2()); // here multiplyWith2 method can be accessed from PC object only because we have inherited PC2 in PC class

    }
}
