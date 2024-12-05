import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RingAlgorithm {
    public static void main(String[] args) {
        List<Integer> processes = new ArrayList<>();
        processes.add(1); // Process IDs
        processes.add(2);
        processes.add(3);
        processes.add(4);
        processes.add(5);

        int initiator = 3; // Process 3 starts the election
        System.out.println("Initial Processes: " + processes);

        // Perform election
        int newLeader = performElection(processes, initiator);
        System.out.println("New Leader: Process " + newLeader);
    }

    public static int performElection(List<Integer> processes, int initiator) {
        System.out.println("Process " + initiator + " starts the election.");

        List<Integer> electionMessage = new ArrayList<>();
        electionMessage.add(initiator);

        int currentProcessIndex = processes.indexOf(initiator);

        // Circulate the election message
        while (electionMessage.size() < processes.size()) {
            currentProcessIndex = (currentProcessIndex + 1) % processes.size();
            int currentProcess = processes.get(currentProcessIndex);

            System.out.println("Process " + currentProcess + " receives the election message.");
            electionMessage.add(currentProcess);
        }

        // Select the leader (process with the highest ID)
        int leader = Collections.max(electionMessage);
        System.out.println("Election message: " + electionMessage);
        return leader;
    }
}
