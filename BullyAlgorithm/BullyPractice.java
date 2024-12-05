import java.util.*;
public class BullyPractice {
    public static void main(String[] args) {
        List<Integer> processes = new ArrayList<>();
        processes.add(1);
        processes.add(2);
        processes.add(3);
        processes.add(4);
        processes.add(5);
        processes.add(6);

        int failedProcess = 5;
        int initiator = 3;

        processes.remove((Integer) failedProcess);

        int newLeader = performElection(processes, initiator);
        System.out.println("New Leader :"+newLeader);
    }
    public static int performElection(List<Integer> processes,int initiator){
        System.out.println("Process Initiator "+initiator+" starts the election");
        int maxId = initiator;

        for (Integer process : processes) {
            if(process>initiator){
                System.out.println("Process " + initiator + " challenges Process " + process);
                maxId = Math.max(process, maxId);
            }
        }
        System.out.println("Election ended");
        return maxId;
    }
}
