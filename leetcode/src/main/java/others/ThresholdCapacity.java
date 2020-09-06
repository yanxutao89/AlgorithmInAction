package others;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.TimeZone;
import java.text.ParseException;


public class ThresholdCapacity {
    public static void main(String[] args){
        Integer i = 1<<30;
        System.out.println(i-Integer.MAX_VALUE);
        System.out.println((int)5/2);
        System.out.println(Integer.parseInt(Character.toString('1')) - 1);
        System.out.println(Math.pow(10, -1));
        System.out.println(10.0/1);
        System.out.println(new Date().getTime());
        System.out.println("2018-11-14T04:38:38.000+0000");

    }

    public static String parseDate(String dateStr) throws ParseException{
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss.SSSZ");
        Date result;
        result = df.parse(dateStr);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        return sdf.format(result);

    }
}
