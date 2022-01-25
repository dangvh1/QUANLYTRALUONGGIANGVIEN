package monhoc;
import school.Giangvien;
import school.Monhoc;

import java.util.Arrays;
import java.util.Scanner;

public class QLgiangday {
    private Giangvien giangvien;
    private Monhoc[] monhocs;
    private int[] totalClass;
    private int allLesson;

    public QLgiangday() {
    }

    public QLgiangday(Giangvien giangvien, Monhoc[] monhocs, int[] totalClass) {
        this.giangvien = giangvien;
        this.monhocs = monhocs;
        this.totalClass = totalClass;
    }

    public int getAllLesson() {
        return allLesson;
    }

    public void setAllLesson(int allLesson) {
        this.allLesson = allLesson;
    }

    public Giangvien getGiangvien() {
        return giangvien;
    }

    public void setGiangvien(Giangvien giangvien) {
        this.giangvien = giangvien;
    }

    public Monhoc[] getMonhocs() {
        return monhocs;
    }

    public void setMonhocs(Monhoc[] monhocs) {
        this.monhocs = monhocs;
    }

    public int[] getTotalClass() {
        return totalClass;
    }

    public void setTotalClass(int[] totalClass) {
        this.totalClass = totalClass;
    }

    @Override
    public String toString() {
        return "Teaching{" +
                "teacher=" + giangvien +
                ", subjects=" + Arrays.toString(monhocs) +
                ", totalClass=" + Arrays.toString(totalClass) +
                ", allLesson=" + allLesson +
                '}';
    }

}
