package lab8;

import java.util.Random;

public class Hospital {
    public static void main(String[] args) {
        Random random = new Random();
        Patient[] patients = new Patient[10];
        BinaryHeap heap = new BinaryHeap(10);

        // Generate 10 patients with random emergency levels
        patients[0] = new Patient("alaa-07", 2);
        patients[1] = new Patient("Ali-63", 1);
        patients[2] = new Patient("mohammed-3", 4);
        patients[3] = new Patient("moha-35", 4);
        patients[4] = new Patient("saad-5", 4);
        patients[5] = new Patient("omar-95", 3);
        patients[6] = new Patient("dahm-45", 5);
        patients[7] = new Patient("ahmd-40", 5);
        patients[8] = new Patient("zed-47", 5);
        patients[9] = new Patient("mnthr-17", 2);


        // Print the array of patients
        System.out.println("Array of Patients:");
        for (Patient patient : patients) {
            System.out.println(patient);
        }

        // Create a binary heap of patients using enqueue
        for (Patient patient : patients) {
            heap.enqueue(patient);
        }

        // Heapsort the patients and print them
        System.out.println("\nPatients sorted by priority:");
        Comparable[] sortedPatients = heap.heapSort();
        for (Comparable patient : sortedPatients) {
            System.out.println((Patient) patient);
        }
    }
}
