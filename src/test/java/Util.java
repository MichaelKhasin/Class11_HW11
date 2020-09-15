import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {

    private static String OS = null;

    public static String getOS (){
        OS = System.getProperty("os.name");
        //System.out.println(OS);
        return OS;
    }

    public static String getcurrentDate (){
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");
        Date date = new Date();
        String date1= dateFormat.format(date);
        //System.out.println(date1);
        return date1;
    }
}
