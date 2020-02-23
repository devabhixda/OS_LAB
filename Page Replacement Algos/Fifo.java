import java.util.*;
class Fifo{
	public static void main(String arts[]){
		List<Integer> al = new ArrayList<Integer>(4);
		System.out.println("Enter the string");
		Scanner scan = new Scanner(System.in);
		int n=scan.nextInt();
		int page_faults=0;
		int i=0;
		while(n-->0){
			if(i>3)
				i=0;
			int next = scan.nextInt();
			if(!al.contains(next) && al.size()==4){
				al.remove(i);
				al.add(next);
				i++;
				page_faults++;
			} else if(!al.contains(next)){
				al.add(next);
				page_faults++;
			}
		}
		System.out.println("No. of page faults= "+page_faults);
		
	}
}
