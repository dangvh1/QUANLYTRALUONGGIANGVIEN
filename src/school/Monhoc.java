package school;

import monhoc.QLgiangday;


import java.util.Scanner;

public class Monhoc {
    private int id;
    private String name;
    private int tongsotiet;
    private int sotietlythuyet;
    private float muckinhphi;

    private static int AUTO_ID = 100;

    public Monhoc() {
    }

    public Monhoc(int id, String name, int tongsotiet, int sotietlythuyet, float muckinhphi) {
        this.id = id;
        this.name = name;
        this.tongsotiet = tongsotiet;
        this.sotietlythuyet = sotietlythuyet;
        this.muckinhphi = muckinhphi;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTongsotiet() {
        return tongsotiet;
    }

    public void setTongsotiet(int tongsotiet) {
        this.tongsotiet = tongsotiet;
    }

    public int getSotietlythuyet() {
        return sotietlythuyet;
    }

    public void setSotietlythuyet(int sotietlythuyet) {
        this.sotietlythuyet = sotietlythuyet;
    }

    public float getMuckinhphi() {
        return muckinhphi;
    }

    public void setMuckinhphi(float muckinhphi) {
        this.muckinhphi = muckinhphi;
    }

    public static int getAutoId() {
        return AUTO_ID;
    }

    public static void setAutoId(int autoId) {
        AUTO_ID = autoId;
    }

    public void informSubjectInfo() {
        this.setId(Monhoc.AUTO_ID);

        System.out.println("Nhập tên môn học: ");
        this.name = new Scanner(System.in).nextLine();
        boolean check = true;
        System.out.println("Nhập tổng số tiết học: ");
        do {
            this.tongsotiet = new Scanner(System.in).nextInt();
            if (this.tongsotiet <= 0) {
                System.out.print("Tổng số tiết lớn hơn 0! Nhập lại: ");
                check = false;
            }
        } while (!check);
        System.out.println("Nhập số tiết lý thuyết: ");
        do {
            this.sotietlythuyet = new Scanner(System.in).nextInt();
            if (this.sotietlythuyet <= 0) {
                System.out.print("Số tiết lý thuyết lớn hơn 0! Nhập lại: ");
                check = false;
            }
        } while (!check);
        System.out.println("Nhập mức kinh phí (lý thuyết): ");
        do {
            this.muckinhphi = new Scanner(System.in).nextInt();
            if (this.muckinhphi <= 0) {
                System.out.print("Mức kinh phí lớn hơn 0! Nhập lại: ");
                check = false;
            }
        } while (!check);
        Monhoc.AUTO_ID++;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lessonTotal=" + tongsotiet +
                ", theoryLesson=" + sotietlythuyet +
                ", expense=" + muckinhphi +
                '}';
    }
}
