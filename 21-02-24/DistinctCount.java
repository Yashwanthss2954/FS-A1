import java.util.*;
class DistinctCount
{
    // Function to find the count of distinct elements in every subarray
    // of size ⁠ k ⁠ in the array
    public static void DistinctCount(int[] arr, int k)
    {
		Map<Integer,Integer> hm=new HashMap<>();
		int n=arr.length;
		for(int i=0;i<k;i++){
		    if(!hm.containsKey(arr[i])){
		        hm.put(arr[i],1);
		    }else{
		        hm.put(arr[i],hm.get(arr[i])+1);
		    }
		}
		System.out.print(hm.size()+" ");
		for(int i=k;i<n;i++){
		    if(!hm.containsKey(arr[i])){
		        hm.put(arr[i],1);
		    }else{
		        hm.put(arr[i],hm.get(arr[i])+1);
		    }
		    hm.put(arr[i-k],hm.get(arr[i-k])-1);
		    int c=0;
		    for(int j:hm.keySet()){
		        if(hm.get(j)>0) c+=1;
		    }
		    System.out.print(c+" ");
		}
    }
 
    public static void main(String[] args)
    {

		Scanner sc=new Scanner(System.in);	
        int n=sc.nextInt();
        int array[]=new int[n];
        
		int k=sc.nextInt();

		for(int i=0;i<n;i++)
			array[i]=sc.nextInt();		
     
        DistinctCount(array, k);
    }
}