import java.util.LinkedList;

class EmergencyRoom {
    private LinkedList<String> queue = new LinkedList<>();

    public void patientCheckIn(String name) {
        queue.addLast(name);
    }

    public void emergencyCheckIn(String name) {
        queue.addFirst(name);
    }

    public void treatPatient() {
        if (queue.isEmpty()) {
            System.out.println("khong còn bệnh nhân");
            return;
        }
        String patient = queue.removeFirst();
        if (patient.equals("C")) {
            System.out.println("Đang cấp cứu:" + patient);
        } else {
            System.out.println("Đang khám:" + patient);
        }
    }
}


public class Bai4 {
    public static void main(String[] args) {
        EmergencyRoom er = new EmergencyRoom();

        er.patientCheckIn("A");
        er.patientCheckIn("B");
        er.emergencyCheckIn("C");

        er.treatPatient();
        er.treatPatient();
        er.treatPatient();
    }
}
