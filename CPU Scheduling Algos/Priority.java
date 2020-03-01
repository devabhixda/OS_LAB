import java.util.*;
public class Priority { 

    public static List<String> sortByAt(Map<String, Integer[]> hm) { 
        List<Map.Entry<String, Integer[]> > list = 
               new LinkedList<Map.Entry<String, Integer[]> >(hm.entrySet()); 
        Collections.sort(list, new Comparator<Map.Entry<String, Integer[]> >() { 
            public int compare(Map.Entry<String, Integer[]> o1,  
                               Map.Entry<String, Integer[]> o2) 
            { 
                return (o1.getValue()[0]).compareTo(o2.getValue()[0]); 
            } 
        }); 
        List<String> temp = new ArrayList<String>(); 
        for (Map.Entry<String, Integer[]> aa : list) { 
            temp.add(aa.getKey()); 
        } 
        return temp; 
    } 
    
    public static List<String> sortByPriority(Map<String, Integer[]> hm) { 
        List<Map.Entry<String, Integer[]> > list = 
               new LinkedList<Map.Entry<String, Integer[]> >(hm.entrySet()); 
        Collections.sort(list, new Comparator<Map.Entry<String, Integer[]> >() { 
            public int compare(Map.Entry<String, Integer[]> o1, Map.Entry<String, Integer[]> o2) 
            {
                return (o1.getValue()[2]).compareTo(o2.getValue()[2]); 
            } 
        }); 
        List<String> temp = new ArrayList<String>(); 
        for (Map.Entry<String, Integer[]> aa : list) { 
            temp.add(aa.getKey()); 
        } 
        return temp; 
    } 
    
    static void peruaf(Map<String, Integer[]> hm, List<String> at){
    	List<Integer> arrival = new ArrayList<>();
    	List<Integer> burst = new ArrayList<>();
    	for(int i=0;i<at.size();i++){
    		arrival.add(hm.get(at.get(i))[0]);
    		burst.add(hm.get(at.get(i))[1]);	
    	}
    	System.out.println(arrival);
    	System.out.println(burst);
    }
    
	static void findWaitingTime(String pid[], int bt[], int quantum) { 
		int rem_bt[] = new int[pid.length]; 
		int count=0;
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
                count+=rem_bt[i];
                System.out.println(pid[i]+ " "+rem_bt[i]+" "+t); 
			} 
			if (done==true) 
			    break; 
		} 
		System.out.println("Total waiting time= "+count);
		System.out.println("Average waiting time= "+(float)count/pid.length);
	} 
	
	public static void main(String[] args) { 
        Scanner scan = new Scanner(System.in);
        int n=scan.nextInt();
        Map<String, Integer[]> map = new HashMap<>();
        System.out.println("Pid AT BT Priority");
        for(int i=0;i<n;i++){
            String pid = scan.next();
            Integer[] arr = new Integer[3];
            arr[0] = scan.nextInt();
            arr[1] = scan.nextInt();
            arr[2] = scan.nextInt();
            map.put(pid, arr); 
        }
        List<String> at = new ArrayList<String>(sortByAt(map));
        List<String> priority = new ArrayList<String>(sortByPriority(map));
        System.out.println(at);
        System.out.println(priority);
		//findWaitingTime(pid, bt, quantum); 
		peruaf(map, at);
	} 
} 
