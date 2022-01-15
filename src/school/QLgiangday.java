package school;
import java.util.Scanner;

public class QLgiangday {
    static Scanner in = new Scanner(System.in);
    Giangvien giangvien;
    Monhoc[] monhocs = new Monhoc[100];
    int[] soLop = new int[100];



    public float tinhluong(){
        float tt = 0;
        for (int i = 0; i < monhocs.length; i++) {
            if(monhocs[i]==null) {
                break;
            }
            tt +=monhocs[i].tienmonhoc()*soLop[i];
        }
        return  tt;
    }
}
