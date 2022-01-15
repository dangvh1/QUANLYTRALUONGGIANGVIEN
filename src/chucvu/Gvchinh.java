package chucvu;

import school.Giangvien;

public class Gvchinh extends Giangvien {
    private int bookId = super.getmaGV();
    private String trinhdo = "Giang vien chinh";;


    @Override
    public int getmaGV() {
        return super.getmaGV();
    }

    public String gettrinhdo() {
        return trinhdo;
    }
    public Gvchinh(){

    }
    public Gvchinh(String hoten, String diachi, int sodienthoai){
        this.sethoten(hoten);
        this.setdiachi(diachi);
        this.setsodienthoai(sodienthoai);
    }
    @Override
    public String toString() {
        return "maGV='" + bookId+ '\'' +
                ", hoten='" + this.gethoten() + '\'' +
                ", diachi='" + this.getdiachi() + '\'' +
                ", trinhdo='" + this.gettrinhdo() + '\'' +
                ", sodienthoai=" + this.getsodienthoai();
    }

}
