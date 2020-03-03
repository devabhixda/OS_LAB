import java.util.*;

public class Priority {

    static class process {
        String processName;
        int arrivalTime;
        int burstTime;
        int burstTime1;
        int completion;
        int waitingTime;
        int startTime;
        double ratio;
        double num;
        int turnaroundtime;
        int priorityvalue;
        Scanner scan = new Scanner(System.in);
        process() {
            processName = scan.next();
            arrivalTime = scan.nextInt();
            burstTime = scan.nextInt();
            priorityvalue = scan.nextInt();
            System.out.println();
        }
    }
    public static void main(String[] args) {

        int aa, b;
        int no_Process, total_Burst_Time = 0;
        int totalwaitingTime = 0, totalturnaroundtime = 0;;
        int count = 0;
        double large = 0, averagewaitingTime = 0, averageturnaroundtime = 0;
        Scanner scan = new Scanner(System.in);
        System.out.print("No. of processes");
        no_Process = scan.nextInt();
        System.out.println("PID AT BT Priority");
        ArrayList<process> process = new ArrayList<>();
        for (int i = 0; i < no_Process; i++) {
            process.add(new process());
        }
        for (int i = 0; i < no_Process; i++) {
            total_Burst_Time += process.get(i).burstTime;
            process.get(i).burstTime1 = process.get(i).burstTime;
            process.get(i).completion = 0;
        }
        while (count <= total_Burst_Time) {
            b = 0;
            large = 0;
            for (aa = 0; aa < no_Process; aa++) {
                if (process.get(aa).arrivalTime > count||process.get(aa).burstTime<=0) {
                    b++;
                }
            }

            if (b == no_Process) {
                count++;
                continue;
            }

            for (int i = 0; i < no_Process; i++) {
                if (process.get(i).arrivalTime > count || process.get(i).burstTime <= 0) {
                    continue;
                } else {
                    if (process.get(i).priorityvalue > large) {
                        large = process.get(i).priorityvalue;
                    }
                } 
            }
            for (int i = 0; i < no_Process; i++) {
                if (large == process.get(i).priorityvalue) {
                    process.get(i).burstTime = process.get(i).burstTime - 1;
                    count++;
                     System.out.println(" this one  "+process.get(i).processName);
                    if (process.get(i).burstTime <= 0) {
                        process.get(i).completion = count;
                        //System.out.println(" this one  "+process.get(i).processName+""+process.get(i).completion);
                    }
                }
            }
        }

        for (int i = 0; i < no_Process; i++) {
            totalwaitingTime = +totalwaitingTime + process.get(i).waitingTime;
            totalturnaroundtime = totalturnaroundtime + process.get(i).turnaroundtime;
        }
        averagewaitingTime = totalwaitingTime / no_Process;
        averageturnaroundtime = totalturnaroundtime / no_Process;
        System.out.println("Average waiting time = " + averagewaitingTime);
        System.out.println("Average turnaround  time = " + averageturnaroundtime);
    }
}
