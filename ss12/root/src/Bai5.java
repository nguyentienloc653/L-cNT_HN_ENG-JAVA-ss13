import java.util.*;
class Patient {
    private String id;
    private String name;
    private int age;
    private String diagnosis;

    public Patient(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class PatientManagement {
    private static List<Patient> patients = new ArrayList<>();

    public static void addPatient(Patient patient) {
        patients.add(patient);
        System.out.println("Tiep nhan thanh cong benh nhan " + patient.getName());
    }

    public static void updateDiagnosis(Patient patient, String diagnosis) {
        if (patients.size() == 0) {
            System.out.println("Danh sach ben nhan trong");
            return;
        }
        patient.setDiagnosis(diagnosis);
        System.out.println("Cap nhat chuan doan cho benh nhan " + patient.getName());
    }

    public static void removePatient(Patient patient) {
        if (patients.size() == 0) {
            System.out.println("Danh sach ben nhan trong");
            return;
        }
        patients.remove(patient);
    }

    public static void sortPatients() {
        if (patients.size() == 0) {
            System.out.println("Danh sach ben nhan trong");
            return;
        }
        for (int i = 0; i < patients.size(); i++) {
            if (patients.get(i).getAge() > patients.get(i + 1).getAge()) {
                Patient temp = patients.get(i);
                patients.set(i, patients.get(i + 1));
                patients.set(i + 1, temp);
            } else if (patients.get(i).getAge() == patients.get(i + 1).getAge()) {
                if (patients.get(i).getName().compareTo(patients.get(i + 1).getName()) > 0) {
                    Patient temp = patients.get(i);
                    patients.set(i, patients.get(i + 1));
                    patients.set(i + 1, temp);
                }
            }
            System.out.println("Sap xep danh sach benh nhan thanh cong");
        }
    }
    public static Patient findById(String id) {
        for (Patient patient : patients) {
            if (patient.getId().equals(id)) {
                return patient;
            }
        }
        return null;
    }

}

class XuatSac1 {
    public static void addPatient(Scanner sc) {
        System.out.print("Nhap ID: ");
        String id = sc.nextLine();
        System.out.print("Nhap ten: ");
        String name = sc.nextLine();
        System.out.print("Nhap tuoi: ");
        int age = Integer.parseInt(sc.nextLine());

        Patient patient = new Patient(id, name, age);
        PatientManagement.addPatient(patient);
    }

    public static void updateDiagnosis(Scanner sc) {
        System.out.print("Nhap ID benh nhan: ");
        String id = sc.nextLine();
        Patient patient = PatientManagement.findById(id);
        if (patient == null) {
            System.out.println("Benh nhan khong ton tai");
            return;
        }
        System.out.print("Nhap chuan doan cua benh nhan: ");
        String diagnosis = sc.nextLine();
        PatientManagement.updateDiagnosis(patient, diagnosis);
    }

    public static void removePatient(Scanner sc) {
        System.out.print("Nhap ID benh nhan: ");
        String id = sc.nextLine();
        Patient patient = PatientManagement.findById(id);
        if (patient == null) {
            System.out.println("Benh nhan khong ton tai");
            return;
        }
        PatientManagement.removePatient(patient);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1. Tiep nhan ben nhanh");
            System.out.println("2. Cap nhat chuan doan");
            System.out.println("3. Xuat vien");
            System.out.println("4. Sap xep danh sach");
            System.out.println("5. Thoat");
            System.out.print("Nhap chuc nang: ");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    addPatient(sc);
                    break;
                case 2:
                    updateDiagnosis(sc);
                    break;
                case 3:
                    removePatient(sc);
                    break;
                case 4:
                    PatientManagement.sortPatients();
                    break;
                case 5:
                    System.out.println("Thoat thanh cong");
                    break;
                default:
                    System.out.println("Chuc nang khong hop le");
                    break;
            }
        } while (choice != 5);
        sc.close();
    }
}
