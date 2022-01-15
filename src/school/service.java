package school;
import chucvu.*;
public class service {
    public Giangvien[] giangviens = new Giangvien[100];
    public Monhoc[] monhocs = new Monhoc[100];

    public void inputgiangvien(Giangvien[] giangviens){
        System.out.println("nhap so luong giang vien muon them:");
        int sl = QLgiangday.in.nextInt();
        int i = 0;
        while (giangviens[i]!=null){
            i++;
        }
        c:
        for (int j = 0; j < sl; j++) {
            System.out.println(" chon cap giang vien:");
            System.out.println("1: giao su tien si");
            System.out.println("2: pho giao su tien si");
            System.out.println("3: thac si");
            System.out.println("4: gian vien chinh");
            System.out.println("0: Exit");
            int ds1 = 0;
            boolean flag;
            do {
                String digit = "[0-4]";
                String input = QLgiangday.in.next();
                flag = input.matches(digit);
                if (!flag){
                    System.out.println("nhap sai!, moi nhap lai");
                    continue;
                }
                ds1 = Integer.parseInt(input);

            } while (!flag);
            switch (ds1){
                case 1:
                    giangviens[i] = new GSTS();
                    giangviens[i].nhapgiangvien();
                    i++;
                    break;
                case 2:
                    giangviens[i] = new PGSTS();
                    giangviens[i].nhapgiangvien();
                    i++;
                    break;
                case 3:
                    giangviens[i] = new Thacsi();
                    giangviens[i].nhapgiangvien();
                    i++;
                    break;
                case 4:
                    giangviens[i] = new Gvchinh();
                    giangviens[i].nhapgiangvien();
                    i++;
                    break;
                case 0:
                    break c;
            }
        }
    }

    public void showGiangVien(Giangvien[] giangviens){
        System.out.println("Danh sach giang vien");
        for (int i = 0; i < 100; i++) {
            if(giangviens[i]==null) {
                break;
            }
            System.out.println("STT "+i+":"+giangviens[i].toString());
        }
    }

    public void inputmonhoc(Monhoc[] monhocs){
        System.out.println("nhap danh sach mon hoc");
        int sl = QLgiangday.in.nextInt();
        int i =0;
        while (monhocs[i]!=null){
            i++;
        }
        for (int j = 0; j < sl; j++){
            monhocs[i] = new Monhoc();
            monhocs[i].nhapthongtinmonhoc();
        }
    }

    public void showMonHoc(Monhoc[] monhocs){
        System.out.println("Danh sach mon hoc:");
        for (int i = 0; i < 100; i++) {
            if(monhocs[i]==null) {
                break;
            }
            System.out.println("STT "+i+":"+ monhocs[i].toString());
        }
    }

    public QLgiangday[] bangKeKhai(QLgiangday[] ql,Giangvien[] giangviens,Monhoc[] monhocs){
        if(giangviens[0] == null) {
            System.out.println("Chua co giang vien trong danh sach");
            return null;
        }
        if(monhocs[0] == null) {
            System.out.println("Chua co mon hoc trong danh sach");
            return null;
        }
        System.out.println("Lap bang ke khai giang vien");
        for (int i = 0; i < ql.length; i++) {
            ql[i] = new QLgiangday();
            if(giangviens[i]==null){
                break;
            }
            ql[i].giangvien = giangviens[i];
            System.out.println("Cac mon giang day cua giang vien "+giangviens[i].getmaGV());
            System.out.println("so lop ma giang vien day "+giangviens[i].getSolopday());
            int n = 0;
            do {
                System.out.println("Nhap mon hoc thu : "+(n+1));
                do {
                    int main = QLgiangday.in.nextInt();
                    if(!kiemtramonhoc(ql[i].monhocs,main)){
                        System.out.println("mon hoc da co, nhap ten mon hoc khac");
                        continue;
                    }
                    Monhoc mn = timkhiemmonhoc(monhocs,main);
                    if (mn != null ){
                        ql[i].monhocs[n] = mn;
                        System.out.println("Nhap so lop va so tiet cua mon hoc :");
                        do {
                            int b = QLgiangday.in.nextInt();
                            if(ql[i].monhocs[n].getTongsotiet()*b+demsotiet(ql[i])>200){
                                System.out.println("Khong duoc vuot qua 200 tiet hoc");
                                continue;
                            }
                            if(b>3){
                                System.out.println("So lop khong duoc qua 3 lop, nhap lai : ");
                                continue;
                            }
                            ql[i].soLop[n] = b;
                            System.out.println("so tiet da co "+demsotiet(ql[i]));
                            break ;
                        }while (true);
                        n++;
                        break;
                    }
                    System.out.println("Ma mon hoc khong dung");
                }while (true);
            }while (true);
        }
        return ql;
    }
    public boolean kiemtramonhoc(Monhoc[] monhocs,int id){
        for (int i = 0; i < monhocs.length; i++) {
            if(monhocs[i]==null) {
                break;
            }
            if(monhocs[i].getMamonhoc()==id){
                return false;
            }
        }
        return true;
    }
    public Monhoc timkhiemmonhoc(Monhoc[] monhocs,int id){
        for (int i = 0; i <monhocs.length ; i++) {
            if(monhocs[i]== null) {
                break;
            }
            if(monhocs[i].getMamonhoc() == id){
                return monhocs[i];
            }
        }
        return null;
    }



    public void bangkekhaigiangday(QLgiangday[] ql){
        System.out.println("Bang ke khai giang day");
        for (int i = 0; i < ql.length; i++) {
            if(ql[i].giangvien==null) {
                break;
            }
            System.out.println("Giang vien "+ql[i].giangvien.getmaGV()+":"+ql[i].giangvien.gethoten());
            for (int j = 0; j < ql[i].monhocs.length; j++) {
                if (ql[i].monhocs[j] == null) {
                    break;
                }
                System.out.println("Mon hoc "+ql[i].monhocs[j].getMamonhoc()+":"+ql[i].monhocs[j].getTenmonhoc()+" So lop: "+ql[i].soLop[j]);
            }
            System.out.println("tong so tiet hoc: "+demsotiet(ql[i]));

        }
    }


    public QLgiangday[] sortbytengiangvien(QLgiangday[] ql){

        for (int i = 0; i < ql.length; i++) {
            if(ql[i] == null) {
                break;
            }
            for (int j = i; j < ql.length; j++) {
                if(ql[j].giangvien == null) {
                    break;
                }
                if(ql[i].giangvien.gethoten().compareTo(ql[j].giangvien.gethoten())<0){
                    QLgiangday temp = ql[i];
                    ql[i] = ql[j];
                    ql[j] = temp;
                }
            }
        }
        return ql;
    }

    public int demsotiet(QLgiangday ql){
        int sum = 0;
        for (int i = 0; i < ql.monhocs.length; i++) {
            if (ql.monhocs[i] == null) {
                break;
            }
            sum += ql.soLop[i] * ql.monhocs[i].getTongsotiet();
        }
        return sum;
    }
    public QLgiangday[] sortBysotietgiangday(QLgiangday[] ql){
        for (int i = 0; i < ql.length; i++) {
            if (ql[i]==null) break;
            for (int j = i; j < ql.length; j++) {
                if (ql[j]==null) {
                    break;
                }
                if (demsotiet(ql[i])<demsotiet(ql[j])){
                    QLgiangday temp = ql[i];
                    ql[i] = ql[j];
                    ql[j] = temp;
                }
            }
        }
        return ql;
    }


    public void tienconggiaovien(QLgiangday[] ql){
        float[] money = new float[100];
        for (int i = 0; i < ql.length; i++) {
            if (ql[i].giangvien==null) {
                break;
            }
            money[i] = ql[i].tinhluong();
            System.out.print("Giang vien "+ql[i].giangvien.getmaGV()+":"+ql[i].giangvien.gethoten());
            System.out.print(" Tog tien luong giang vien : "+money[i]);
        }
    }





}
