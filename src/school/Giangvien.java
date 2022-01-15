package school;

public class Giangvien {
    private static int maGV = 100;
    private String hoten;
    private String diachi;
    private int sodienthoai;
    private String trinhdo;
    private int solopday;

    public String gettrinhdo() {
        return trinhdo;
    }

    public int getmaGV() {
        return maGV;
    }

    public String gethoten() {
        return hoten;
    }

    public void sethoten(String gethoten) {
        this.hoten = gethoten;
    }

    public String getdiachi() {
        return diachi;
    }

    public void setdiachi(String diachi) {
        this.diachi = diachi;
    }

    public int getsodienthoai() {
        return sodienthoai;
    }

    public void setsodienthoai(int sodienthoai) {
        this.sodienthoai = sodienthoai;
    }

    public int getSolopday() {
        return solopday;
    }

    public void setSolopday(int solopday) {
        this.solopday = solopday;
    }

    public void nhapgiangvien(){
        QLgiangday.in.nextLine();
        System.out.println("nhap thong tin sach: ");
        System.out.println("nhap ten giang vien: ");
        this.sethoten(QLgiangday.in.nextLine());
        System.out.println("nhap dia chi giang vien: ");
        this.setdiachi(QLgiangday.in.nextLine());
        System.out.println("nhap so dien thoai giang vien: ");
        this.setsodienthoai(QLgiangday.in.nextInt());
        System.out.println("nhap so lop day cua giang vien");
        this.setSolopday(QLgiangday.in.nextInt());
    }
    public Giangvien(){
        maGV++;
    }

    @Override
    public String toString() {
        return "Giangvien{" +
                "hoten='" + hoten + '\'' +
                ", diachi='" + diachi + '\'' +
                ", sodienthoai=" + sodienthoai + '\'' +
                ", solopday=" + solopday + '\'' +
                '}';
    }

}
