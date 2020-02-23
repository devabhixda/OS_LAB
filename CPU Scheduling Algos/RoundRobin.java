import java.util.Scanner;

public class RoundRobin { 
	static void findWaitingTime(String pid[], int bt[], int quantum) { 
		int rem_bt[] = new int[pid.length]; 
		for (int i = 0 ; i < pid.length ; i++) 
            rem_bt[i] = bt[i]; 
        int t = 0;
		while(true) { 
			boolean done = true; 
			for (int i = 0 ; i < pid.length; i++) { 
				if (rem_bt[i] > 0) { 
					done = false;
					if (rem_bt[i] > quantum) { 
						t += quantum; 
						rem_bt[i] -= quantum; 
					} 
					else { 
						t = t + rem_bt[i]; 
						rem_bt[i] = 0; 
					} 
                } else {
                    done = true;
                    break;
                }
                System.out.println(pid[i]+ " "+rem_bt[i]+" "+t); 
			} 
			if (done==true) 
			    break; 
		} 
	} 
	
	public static void main(String[] args) { 
        Scanner scan = new Scanner(System.in);
        int n=scan.nextInt();
        String[] pid = new String[n];
        int[] bt = new int[n];
        for(int i=0;i<n;i++){
            pid[i] = scan.next();
            bt[i] = scan.nextInt();
        }
		int quantum = 2; 
		findWaitingTime(pid, bt, quantum); 
	} 
} 
