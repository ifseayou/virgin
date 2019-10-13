import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author isea_you
 * @date 2019/9/3
 * @time 20:09
 * @target:
 */
public class Test {
    public static void main(String[] args) {

        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd" );
        Date d= new Date();
        String str = sdf.format(d);
        System.out.println("当前时间通过 yyyy-MM-dd HH:mm:ss SSS 格式化后的输出: "+str);
    }
}
