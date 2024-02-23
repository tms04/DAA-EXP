import java.util.*;
/**
 * exp3
 */
public class exp3 {
    static String [] greedy(String Activity[],int start[],int finish[]){
        String result[]=new String[Activity.length];
        int n=Activity.length;
        String temp;
        for (int i = 0; i < n; i++){  
            for (int j = i + 1; j < n; j++){  
                int tmp = 0;  
                if (finish[i] > finish[j]){  
                    tmp = finish[i];  
                    finish[i] = finish[j];  
                    finish[j] = tmp; 
                    tmp = start[i];  
                    start[i] = start[j];  
                    start[j] = tmp;
                    temp = Activity[i];  
                    Activity[i] = Activity[j];  
                    Activity[j] = temp;     
                }  
            }
            result[i]="0";
        }
        result[0]=Activity[0];
        int k=1;
        int j=0;
        for(int i=1;i<n;i++){
            if(start[i]>=finish[j]){
                result[k]=Activity[i];
                k++;
                j=i;
            }
        }
        

        return result;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of activities");
        int n=Integer.parseInt(sc.nextLine());
        String Activity[]=new String[n];
        int start[]=new int[n];
        int finish[]=new int[n];
        for(int i=0;i<n;i++){
            System.out.println("Enter the name of activity"+(i+1));
            // sc.next().charAt(0);
            Activity[i]=sc.nextLine();
            System.out.println("Enter the start time of activity"+(i+1));
            start[i]=Integer.parseInt(sc.nextLine());
            System.out.println("Enter the finish time of activity"+(i+1));
            finish[i]=Integer.parseInt(sc.nextLine());
        }
        String result[]=greedy(Activity, start, finish);
        for(int i=0;i<n;i++){
            if(result[i]!="0"){
            System.out.println(result[i]);
            }
        }
    }
}
// Activity-Selection(Activity, start, finish)

// Sort Activity by finish times stored in finish Selected = {Activity[1]}

// n = Activity.length j = 1

// for i = 2 to n:

// if start[i] ≥ finish[j]:

// Selected = Selected U {Activity[i]} j = i

// return Selected