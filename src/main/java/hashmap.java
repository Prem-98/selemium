import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashMap;
import java.util.SimpleTimeZone;

public class hashmap {
    public static void main(String[] args){
//        HashMap<String,String> map=new HashMap<>();
//        map.put("discount party1","POL-TL");
//        map.put("discount party2","POL-MG");
//        map.put("discount party3","UWR-TM");
//
//        System.out.println(map.get("discount party1"));
//        System.out.println(map.size());
//        LocalDate start = LocalDate.of(1996, 2, 29);
//        LocalDate end = LocalDate.of(2014, 2, 28); // use for age-calculation: LocalDate.now()
//        long years = ChronoUnit.YEARS.between(start, end);
//        System.out.println(years);
        Date current=new Date();
        SimpleDateFormat d=new SimpleDateFormat("dd/MM/yyyy");
        System.out.println(d.format(current));



    }
}
