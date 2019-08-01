import utils.ValidUtils;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hello World!");
        System.out.print("电话:");
        Scanner sc = new Scanner(System.in);
        String tel=sc.nextLine();
        System.out.print(ValidUtils.vaild(tel));
    }
}
