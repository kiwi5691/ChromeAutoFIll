package utils;

/**
 * @auther kiwi
 * @Date 2019/8/1 23:42
 */
public class ValidUtils {
    public static String vaild(String tel){

        int b = Integer.valueOf(tel);
        int count=0; //计数
        while(b>=1) {
            b/=10;
            count++;
        }
        if(count<10){
            return "0595-"+ tel;
        }
        else {
            return tel;
        }


    }
}
