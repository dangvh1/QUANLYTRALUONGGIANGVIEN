package school;
import java.util.Scanner;
public class Main {
    public static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        QLgiangday[] ql = new QLgiangday[100];
        Monhoc[] monhocs = new Monhoc[100];
        Giangvien[] giangviens = new Giangvien[100];
        service sv = new service();
        int lc = 0;

        do {
            System.out.println("************************");
            System.out.println("Moi lua chon");
            System.out.println("1. Nhap mon hoc moi");
            System.out.println("2. Nhap giang vien moi");
            System.out.println("3. Hien thi danh sach mon hoc");
            System.out.println("4. Hien thi danh sach giang vien");
            System.out.println("5. Lap bang ke khai giang day");
            System.out.println("6. Sap xep danh sach ke khai giang day theo ten giang vien");
            System.out.println("7. Sap xep danh sach ke khai giang day theo so tiet giang day");
            System.out.println("8. Tinh toan va lap bang tinh tien");
            System.out.println("0. Exit");
            System.out.println("***********************");
            boolean choose;
            do {

                String digit = "[0-8]";
                String input = QLgiangday.in.next();
                choose = input.matches(digit);

                if (!choose) {
                    System.out.println("nhap sai!, moi nhap lai");
                    continue;
                }
                lc = Integer.parseInt(input);

            } while (!choose);
            //lc = Management.in.nextInt();
            switch (lc) {
                case 1:
                    sv.inputmonhoc(monhocs);
                    break;
                case 2:
                    sv.inputgiangvien(giangviens);
                    break;
                case 3:
                    sv.showMonHoc(monhocs);
                    break;
                case 4:
                    sv.showGiangVien(giangviens);
                    break;
                case 5:
                    ql = sv.bangKeKhai(ql,giangviens, monhocs );
                    sv.bangkekhaigiangday(ql);
                    break;
                case 6:
                    System.out.println("Bang quan ly sap xep theo ten giao vien :");
                    ql = sv.sortbytengiangvien(ql);
                    sv.bangkekhaigiangday(ql);

                    break;
                case 7:
                    System.out.println("Bang quan ly sap xep theo so tiet giang day moi mon :");
                    ql = sv.sortBysotietgiangday(ql);
                    sv.bangkekhaigiangday(ql);
                    break;
                case 8:
                    System.out.println("tien luong giang vien : ");
                    sv.tienconggiaovien(ql);
                    break;

                case 0:
                    System.out.println("ket thuc chuong trinh");
                    break;
            }

        }while (lc != 0) ;

    }
}
