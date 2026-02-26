import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Bai2 {
    public static List<String> sapXep(List<String> danhSachThuoc) {
        List<String> danhSach = new ArrayList<>();
        for (String thuoc : danhSachThuoc) {
            if (!danhSach.contains(thuoc)) {
                danhSach.add(thuoc);
            }
        }
        Collections.sort(danhSach);
        return danhSach;
    }
    public static void main(String[] args) {
        List<String> dsThuoc = new ArrayList<>();
        dsThuoc.add("Paracetamol");
        dsThuoc.add("Ibuprofen");
        dsThuoc.add("Panadol");
        dsThuoc.add("Paracetamol");
        dsThuoc.add("Aspirin");
        dsThuoc.add("Ibuprofen");

        List<String> kq = sapXep(dsThuoc);
        System.out.println("Danh sach thuoc: " + kq);

    }
}
