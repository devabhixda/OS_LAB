import java.util.*;

class Lru{
	public static void main(String args[]){
		Map<Integer,Integer> map = new HashMap();
		int size=0;
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int i=0;
		int pagefaults=0;
		while(n-->0){
			int next=scan.nextInt();
			if(map.containsKey(next)){
				map.put(next,i++);
			} else if(size==4){
				int min = Collections.min(map.values());
				int keyf=0;
				for ( Map.Entry<Integer,Integer> e : map.entrySet() ) {
					if(e.getValue()==min)
						keyf=e.getKey();
				}
				map.remove(keyf);
				map.put(next,i++);
				pagefaults++;
			} else {
				map.put(next,i++);
				size++;
				pagefaults++;
			}
		}
		System.out.println("No of page faults= "+pagefaults);
	}
}
