import java.util.*;

class Medicine {
    private String drugId;
    private String drugName;
    private double unitPrice;
    private int quantity;

    public Medicine(String drugId, String drugName, double unitPrice, int quantity) {
        this.drugId = drugId;
        this.drugName = drugName;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    public String getDrugId() {
        return drugId;
    }

    public String getDrugName() {
        return drugName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setDrugId(String drugId) {
        this.drugId = drugId;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void display() {
        System.out.printf("| %-15s | %-20s | %-10d | %-10.2f | %-10.2f |\n", this.drugId, this.drugName, this.quantity,
                this.unitPrice, this.unitPrice * this.quantity);
    }
}

class MedicineManagement {
    private static List<Medicine> medicines = new ArrayList<>();

    public static Medicine findById(String id) {
        for (Medicine medicine : medicines) {
            if (medicine.getDrugId().equals(id)) {
                return medicine;
            }
        }
        return null;
    }

    public static void addMedicine(Medicine medicine) {
        System.out.printf("Them don thuoc %s vao don thuoc\n", medicine.getDrugName());
        medicines.add(medicine);
    }

    public static void adjustQuantity(Medicine medicine, int quantity) {
        if (quantity == 0) {
            removeMedicine(medicine);
            return;
        }
        medicine.setQuantity(quantity);
        System.out.println("Dieu chinh thanh cong so luong thuoc " + medicine.getDrugName());
    }

    public static void removeMedicine(Medicine medicine) {
        System.out.println("Da xo thuoc " + medicine.getDrugName() + " trong don thuoc");
        medicines.remove(medicine);
    }

    public static void printBill() {
        System.out.println("----- Hoa don -----");
        System.out.printf("| %-15s | %-20s | %-10s | %-10s | %-10s |\n", "ID", "Ten thuoc", "So luong", "Gia",
                "Thanh tien");
        for (Medicine medicine : medicines) {
            medicine.display();
        }
        medicines.clear();
    }

    public static void findCheapMedicine() {
        System.out.println("----- Cac thuoc gia duoi 50K -----");
        System.out.printf("| %-15s | %-20s | %-10s | %-10s | %-10s |\n", "ID", "Ten thuoc", "So luong", "Gia",
                "Thanh tien");
        for (Medicine medicine : medicines) {
            if (medicine.getUnitPrice() <= 50000) {
                medicine.display();
            }
        }
    }
}

class Bai6 {
    public static void addMedicine(Scanner sc) {
        System.out.print("Nhap ID: ");
        String id = sc.nextLine();
        System.out.print("Nhap ho ten: ");
        String name = sc.nextLine();
        System.out.print("Nhap so luong: ");
        int quantity = Integer.parseInt(sc.nextLine());
        System.out.print("Nhap gia tien: ");
        double unitPrice = Double.parseDouble(sc.nextLine());

        Medicine medicine = new Medicine(id, name, unitPrice, quantity);
        MedicineManagement.addMedicine(medicine);
    }

    public static void adjustQuantity(Scanner sc) {
        System.out.print("Nhap ID thuoc: ");
        String id = sc.nextLine();
        Medicine medicine = MedicineManagement.findById(id);
        if (medicine == null) {
            System.out.println("khong tim thay thuoc");
            return;
        }
        System.out.print("Nhap so luong: ");
        int quantity = Integer.parseInt(sc.nextLine());

        MedicineManagement.adjustQuantity(medicine, quantity);
    }

    public static void removeMedicine(Scanner sc) {
        System.out.print("Nhap ID thuoc: ");
        String id = sc.nextLine();
        Medicine medicine = MedicineManagement.findById(id);
        if (medicine == null) {
            System.out.println("khong tim thay thuoc");
            return;
        }
        MedicineManagement.removeMedicine(medicine);
    }

    public static void main(String[] args) {
        int choice;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("1. Them thuoc vao don");
            System.out.println("2. Dieu chinh so luong");
            System.out.println("3. Xoa don thuoc");
            System.out.println("4. In hoa don");
            System.out.println("5. Tim thuoc gia re");
            System.out.println("6. Thoat");
            System.out.print("Nhap chuc nang: ");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    addMedicine(sc);
                    break;
                case 2:
                    adjustQuantity(sc);
                    break;
                case 3:
                    removeMedicine(sc);
                    break;
                case 4:
                    MedicineManagement.printBill();
                    break;
                case 5:
                    MedicineManagement.findCheapMedicine();
                    break;
                default:
                    break;
            }
        } while (choice != 6);
        sc.close();
    }
}