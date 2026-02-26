import java.util.ArrayList;
import java.util.Iterator;


public class Bai1 {
    public static void main(String[] args) {
        ArrayList<Double> nhietDo = new ArrayList<>();
        nhietDo.add(36.5);
        nhietDo.add(40.2);
        nhietDo.add(37.0);
        nhietDo.add(12.5);
        nhietDo.add(39.8);
        nhietDo.add(99.9);
        nhietDo.add(36.8);

        System.out.println("giá trị ban đầu: " + nhietDo);

        Iterator<Double> iterator = nhietDo.iterator();
        while (iterator.hasNext()) {
            double t = iterator.next();
            if (t < 34.0 || t > 42.0 ) {
                iterator.remove();
            }
        }

        System.out.println("Danh sách nhiệt độ hợp lệ: " + nhietDo);

    double tong = 0.0;
    for (double t : nhietDo) {
        tong += t;
    }
    double trungBinh = 0.0;
    if (!nhietDo.isEmpty()) {
        trungBinh = tong / nhietDo.size();
    }
    System.out.println("nhiệt độ trung bình: " + trungBinh);
    }

}
