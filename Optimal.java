import java.util.*;
class Optimal{
    public static void main(String args[]) {
		List<Integer> list = new ArrayList<Integer>();
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int temp=n;
		while(temp-->0){
			list.add(scan.nextInt());
		}
		temp=n;
		int size=0;
		int pagemisses=0;
		List<Integer> al = new ArrayList<Integer>(4);
		while(temp-->0){
			if(!al.contains(list.get(0)) && size<4){
				al.add(list.get(0));
				size++;
				pagemisses++;
				list.remove(0);
			} else if(!al.contains(list.get(0))){
				int min=0;
				int j;
				for(j=0;j<4;j++){
				    if(!list.contains(al.get(j))){
				        al.remove(j);
				        min=-1;
				        break;
				    }
					if(list.indexOf(al.get(j))>min){
						min=list.indexOf(al.get(j));
					}
				}
				if(min>-1){
				    int indx = al.indexOf(list.get(min));
				    al.remove(indx);
				    al.add(indx,list.get(0));
				    list.remove(0);
				} else {
				    al.add(j, list.get(0));
				    list.remove(0);
				}
				pagemisses++;
			} else
			    list.remove(0);
		}
		System.out.println(pagemisses);
	}
}
