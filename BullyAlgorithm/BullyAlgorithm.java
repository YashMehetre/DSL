import java.util.ArrayList;
import java.util.List;

public class BullyAlgorithm {
    public static void main(String[] args) {
        List<Integer> processes = new ArrayList<>();
        processes.add(1); // Process IDs
        processes.add(2);
        processes.add(3);
        processes.add(4);
        processes.add(5);

        int failedProcess = 5; // Assume process 5 fails
        int initiator = 3;     // Process 3 starts the election

        System.out.println("Initial Processes: " + processes);
        System.out.println("Failed Process: " + failedProcess);

        // Remove the failed process
        processes.remove((Integer) failedProcess);

        // Perform election
        int newLeader = performElection(processes, initiator);
        System.out.println("New Leader: Process " + newLeader);
    }

    public static int performElection(List<Integer> processes, int initiator) {
        System.out.println("Process " + initiator + " starts the election.");
        int maxId = initiator;

        // Check higher-ID processes
        for (int process : processes) {
            if (process > initiator) {
                System.out.println("Process " + initiator + " challenges Process " + process);
                maxId = Math.max(maxId, process);
            }
        }

        System.out.println("Process " + maxId + " becomes the leader.");
        return maxId;
    }
}
