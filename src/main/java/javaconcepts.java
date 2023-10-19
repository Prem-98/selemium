import java.util.ArrayList;

public class javaconcepts {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 6, 4, 8, 10, 12, 14, 17, 20};
//        System.out.println(arr.length);
//        System.out.println(arr[0]);

//        for loop and if condition
//        for(int i=0 ;i<arr.length; i++)
//        {System.out.print(arr[i]+",");}
//        for (int o=0; o<arr.length;o++)
//        {if (arr[o]%2==0)
//        {System.out.println(arr[o]);}
//        }
//        Array list , it is a dynamic list where we can add the data afer creating the array when ever we want
        ArrayList a = new ArrayList();
        a.add(3);
        a.add(67);
        a.add(8);
        a.add("prem");
        a.add(8.99);
//        System.out.println(a.size()); // for arraylist size is used to get the length of the array list
//        System.out.println(a);
//        System.out.println(a.contains(8.99));  // to check the value present in the array list or not
//        ***********************************************************************************************************

        // STRINGS
        //String is an object in java
        String p = "Prem Kumar Reddy";
        String[] splitted = p.split(" "); // here the string is splitted with delimiter as space b/w the words and stored in array.
//        System.out.println(splitted[1]);
        for (int i = p.length() - 1; i >= 0; i--) {
//            System.out.println(p.charAt(i));
        }
        javaconcepts m = new javaconcepts();   //here object is created to call the method.
        m.getdata();
    }
//    *********************************************************************************************************************
//    Methods - methods should be created outside the class only, then we have to create an object of that method to call it.
    public String getdata(){
        System.out.println("this method will return string ");
        return "Hello all";
    }
}
