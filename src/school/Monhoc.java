package school;

import monhoc.Imonhoc;

public class Monhoc implements Imonhoc {
    private static int mamonhoc = 100;
    private String tenmonhoc;
    private int tongsotiet;
    private int sotietlythuyet;
    private float muckinhphi;

    public int getMamonhoc(){
        return mamonhoc;
    }

    public Monhoc(){
        mamonhoc++;
    }

    public String getTenmonhoc() {
        return tenmonhoc;
    }

    public void setTenmonhoc(String tenmonhoc) {
        this.tenmonhoc = tenmonhoc;
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



    @Override
    public void nhapthongtinmonhoc() {
        QLgiangday.in.nextLine();
        System.out.println("nhap thong tin mon hoc: ");
        System.out.println("nhap ten mon hoc: ");
        this.setTenmonhoc(QLgiangday.in.nextLine());
        System.out.println("nhap tong so tiet: ");
        this.setTongsotiet(QLgiangday.in.nextInt());
        System.out.println("nhap so tiet ly thuyet: ");
        this.setSotietlythuyet(QLgiangday.in.nextInt());
        System.out.println("nhap muc kinh phi: ");
        this.setMuckinhphi(QLgiangday.in.nextFloat());

    }
    public float tienmonhoc(){
        float tongtien = (float) (sotietlythuyet*muckinhphi+(tongsotiet-sotietlythuyet)*0.7);
        return tongtien;
    }


    @Override
    public void hienthimonhoc() {

    }

    @Override
    public String toString() {
        return "Monhoc{" +
                "tenmonhoc='" + tenmonhoc + '\'' +
                ", tongsotiet='" + tongsotiet + '\'' +
                ", sotietlythuyet='" + sotietlythuyet + '\'' +
                ", muckinhphi='" + muckinhphi + '\'' +
                '}';
    }
}
