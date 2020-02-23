import java.util.*;
class Fcfs{
    public static List<String> sortByValue(Map<String, Integer[]> hm) 
    { 
        // Create a list from elements of HashMap 
        List<Map.Entry<String, Integer[]> > list = 
               new LinkedList<Map.Entry<String, Integer[]> >(hm.entrySet()); 
  
        // Sort the list 
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
  
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        Map<String, Integer[]> map = new HashMap<>();
        for(int i=0;i<n;i++){
            String temp = scan.next();
            Integer[] val = new Integer[2];
            val[0]=scan.nextInt();
            val[1]=scan.nextInt();
            map.put(temp, val);
        }
        List<String> sorted = new ArrayList<String>(sortByValue(map));
        int in=0,out=0;
        for(String temp : sorted){
            if(map.get(temp)[0]<=out){
                out+=map.get(temp)[1];
                System.out.println("Process= "+temp+", In= "+in+", Out= "+out);
                in+=map.get(temp)[1];
            } else {
                in+=map.get(temp)[0]-in;
                out+=map.get(temp)[0]-out;
                out+=map.get(temp)[1];
                System.out.println("Process= "+temp+", In= "+in+", Out= "+out);
                in+=map.get(temp)[1];
            }
        }
    }
}