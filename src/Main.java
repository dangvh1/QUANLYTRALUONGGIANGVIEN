import monhoc.QLgiangday;
import school.Giangvien;
import school.Monhoc;

import java.util.Scanner;
public class Main {
    private static int countTeacher;
    private static Giangvien[] giangviens;
    private static Monhoc[] monhocs;
    private static QLgiangday[] qLgiangdays;

    public static void main(String[] args) {
        menu();
    }
    private static int functionChoice() {
        System.out.println("Quản lý trả lương cho giảng viên thỉnh giảng");
        System.out.println("1.Nhập danh sách môn học");
        System.out.println("2.Nhập danh sách giảng viên");
        System.out.println("3.Bảng kê khai giảng dạy");
        System.out.println("4.Sắp xếp bảng kê khai giảng dạy");
        System.out.println("5.Tính toán và lập bảng tính tiền công cho từng giảng viên");
        System.out.println("6.Thoát");
        int functionChoice;
        do {
            functionChoice = new Scanner(System.in).nextInt();
            if (functionChoice >= 1 && functionChoice <= 6) {
                break;
            }
            System.out.print("Chức năng chọn không hợp lệ, vui lòng chọn lại: ");
        } while (true);
        return functionChoice;
    }
    private static void menu() {
        do {
            int functionChoice = functionChoice();
            switch (functionChoice) {
                case 1:
                    createNewSubject();
                    displaySubjects();
                    break;
                case 2:
                    createNewTeacher();
                    displayTeacher();
                    break;
                case 3:
                    teachingDeclaration();
                    displayTeachingDeclaration();
                    break;
                case 4:
                    sortteachingDeclaration();
                    break;
                case 5:
                    teacherIncome();
                    break;
                case 6:
                    System.exit(0);
            }

        } while (true);
    }

    private static void teacherIncome() {
        if (qLgiangdays == null || qLgiangdays.length == 0) {
            System.out.println("Nhập bảng chấm công trước khi sắp xếp");
            return;
        }
        for (QLgiangday qLgiangday : qLgiangdays) {
            System.out.println("Tính tiền lương cho giảng viên " + qLgiangday.getGiangvien().getName());
            System.out.println(qLgiangday.getGiangvien().getSalary());
        }
    }

    private static void sortteachingDeclaration() {
        if (giangviens == null || giangviens.length == 0) {
            System.out.println("Nhập bảng chấm công trước khi sắp xếp");
            return;
        }
        do {
            System.out.println("------Sắp xếp danh sách chấm công---------");
            System.out.println("1.Theo tên giảng viên");
            System.out.println("2.Theo số tiết giảng dạy mỗi môn");
            System.out.println("3.Thoát");
            System.out.println("Nhập sự lựa chọn của bạn");
            int choice = 0;
            boolean checkChoice = true;
            do {
                try {
                    choice = new Scanner(System.in).nextInt();
                    checkChoice = true;
                } catch (Exception e) {
                    System.out.println("không được phép có ký tự khác ngoài ký tự số! Nhập lại");
                    checkChoice = false;
                    continue;
                }
                if (choice <= 0 || choice > 3) {
                    System.out.print("Nhập trong khoảng từ 1 đến 3! Nhập lại: ");
                    checkChoice = false;
                }
            } while (!checkChoice);
            switch (choice) {
                case 1:
                    sortByTeacherName();
                    break;
                case 2:
                    sortBySubjectLesson();
                    break;
                case 3:
                    return;
            }
        } while (true);
    }

    private static void sortBySubjectLesson() {
        for (int i=0; i< qLgiangdays.length;i++){
            for (int j=0; j < qLgiangdays[i].getMonhocs().length;j++){
                for (int k=j+1; k<qLgiangdays[i].getMonhocs().length;k++){
                    if (monhocs[j].getTongsotiet()<monhocs[k].getTongsotiet()){
                        Monhoc temp = monhocs[j];
                        monhocs[j] = monhocs[k];
                        monhocs[k] = temp;
                    }
                }
            }
            for (int l=i+1; l < qLgiangdays.length; l++){
                if (qLgiangdays[i].getAllLesson()<qLgiangdays[l].getAllLesson()){
                    QLgiangday temp = qLgiangdays[i];
                    qLgiangdays[i] = qLgiangdays[l];
                    qLgiangdays[l] = temp;
                }
            }
        }
        for (QLgiangday qLgiangday : qLgiangdays) {
            System.out.println(qLgiangday);
        }
    }

    private static void sortByTeacherName() {
        if (qLgiangdays == null || qLgiangdays.length == 0){
            System.out.println("Nhập bảng kê khai trước khi sắp xếp!");
            return;
        }
        for (int i = 0; i < qLgiangdays.length; i++) {
            for (int j = i + 1; j < qLgiangdays.length; j++) {
                if (qLgiangdays[i].getGiangvien().getName().compareTo(qLgiangdays[j].getGiangvien().getName()) > 0) {
                    QLgiangday temp = qLgiangdays[i];
                    qLgiangdays[i] = qLgiangdays[j];
                    qLgiangdays[j] = temp;
                }
            }
        }
        for (QLgiangday qLgiangday : qLgiangdays) {
            System.out.println(qLgiangday);
        }
    }

    private static void createNewTeacher() {
        System.out.println("Nhập số lượng giảng viên: ");
        countTeacher = new Scanner(System.in).nextInt();
        giangviens = new Giangvien[countTeacher];
        for (int i = 0; i < giangviens.length; i++) {
            Giangvien giangvien = new Giangvien();
            giangvien.inputInfo();
            giangviens[i] = giangvien;
        }
    }

    private static void displayTeacher() {
        for (Giangvien giangvien : giangviens) {
            System.out.println(giangvien);
        }
    }

    private static void createNewSubject() {
        System.out.println("Nhập số lượng môn học: ");
        int countSubject = new Scanner(System.in).nextInt();
        monhocs = new Monhoc[countSubject];
        for (int i = 0; i < monhocs.length; i++) {
            Monhoc monhoc = new Monhoc();
            monhoc.inputSubjectInfo();
            monhocs[i] = monhoc;
        }
    }

    private static void displaySubjects() {
        for (Monhoc monhoc : monhocs) {
            System.out.println(monhoc);
        }
    }

    public static boolean isValidSubjectAndTeacher() {
        return monhocs != null && giangviens != null && monhocs.length != 0 && giangviens.length != 0;
    }

    private static void teachingDeclaration() {
        if (!isValidSubjectAndTeacher()) {
            System.out.println("Bạn cần nhập giảng viên và môn học trước khi thống kê! ");
            return;
        }
        boolean check = true;
        qLgiangdays = new QLgiangday[countTeacher];
        int allSum;
        for (int i = 0; i < giangviens.length; i++) {
            allSum = 0;
            System.out.println("Kê khai cho giảng viên " + giangviens[i].getName());
            System.out.println("Nhập số môn học mà giảng viên " + giangviens[i].getName() + " : ");
            int subjectNumber;
            do {
                subjectNumber = new Scanner(System.in).nextInt();
                if (subjectNumber <= 0 || subjectNumber > monhocs.length) {
                    System.out.print("Số môn giảng viên dạy phải lớn hơn 0 và nhỏ hơn tổng số môn! Nhập lại: ");
                    check = false;
                }
            } while (!check);
            Monhoc[] monhocList = new Monhoc[subjectNumber];
            int[] totalClassArray = new int[subjectNumber];
            do {
                for (int j = 0; j < subjectNumber; j++) {
                    int sum = 0;
                    System.out.print("Nhập id môn thứ " + (j + 1) + " mà giảng viên " + giangviens[i].getName() + " dạy: ");
                    int subjectId;
                    int totalClass = 0;
                    do {
                        subjectId = new Scanner(System.in).nextInt();
                        Monhoc monhoc = searchSubjectId(subjectId);
                        if (monhoc != null) {
                            System.out.println("Nhập số lớp của môn thứ " + (j + 1) + " mà giảng viên " + giangviens[i].getName() + " dạy:");
                            do {
                                totalClass = new Scanner(System.in).nextInt();
                                if (totalClass <= 0 || totalClass > 3) {
                                    System.out.print("Số lớp dạy phải lớn hơn 0 và không lớn hơn 3! Nhập lại: ");
                                    check = false;
                                }
                            } while (!check);
                            sum += monhocs[j].getTongsotiet() * totalClass;
                            if (sum > 200) {
                                System.out.println("Tổng số tiết học vượt quá 200! Nhập lại từ đầu cho giảng viên này nhé: ");
                                check = false;
                                break;
                            } else check = true;
                            int practice = monhoc.getTongsotiet() - monhoc.getSotietlythuyet();
                            float salary = monhoc.getMuckinhphi()*monhoc.getSotietlythuyet()+practice*monhoc.getMuckinhphi()*70/100;
                            giangviens[j].setSalary(salary);
                            allSum += sum;
                            monhocList[j] = monhoc;
                            totalClassArray[j] = totalClass;
                            break;
                        } else System.out.print("Không có id môn học vừa nhập! Nhập lại: ");
                    } while (true);
                }
            } while (!check);
            QLgiangday qLgiangday = new QLgiangday(giangviens[i],monhocList, totalClassArray);
            qLgiangdays[i] = qLgiangday;
            qLgiangdays[i].setAllLesson(allSum);
        }
    }


    private static void displayTeachingDeclaration() {
        for (QLgiangday qLgiangday : qLgiangdays) {
            System.out.println(qLgiangday);
        }
    }

    private static Monhoc searchSubjectId(int monhocId) {
        for (Monhoc monhoc : monhocs) {
            if (monhoc.getId() == monhocId) {
                return monhoc;
            }
        }
        return null;
    }




}
