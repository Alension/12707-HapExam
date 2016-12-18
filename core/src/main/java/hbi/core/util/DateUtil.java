package hbi.core.util;


import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Alen on 2016/12/17.
 */
public class DateUtil {
        public static String dateToString(Date date){
            SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
            return format.format(date);
        }
}
