import java.util.*;
class Optimal{
	public static void main(String args[]){
		List<Integer> list = new ArrayList<Integer>();
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int temp=n;
		while(temp-->0){
			list.add(scan.nextInt());
		}
		temp=n;
		int i=0;
		int size=0;
		int pagemisses=0;
		List<Integer> al = new ArrayList<Integer>(4);
		while(temp-->0){
			if(!al.contains(list.get(i)) && size<4){
				al.add(list.get(i++));
				size++;
				pagemisses++;
			} else if(!al.contains(list.get(i))){
				int min=0;
				for(int j=0;j<4;j++){
					if(list.indexOf(al.get(j))<min){
						min=list.indexOf(al.get(j));
					}
					
				}
				System.out.println(al);
				System.out.println(min);
				al.add(min,list.get(i++));
				System.out.println(al);
			}
		}
		System.out.println(al);
	}
}
