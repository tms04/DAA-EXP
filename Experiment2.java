import java.util.*;
/**
 * Experiment2
 */
public class Experiment2 {
    static void Knapsack(int P[],int W[],int M,int n){
        float X[]=new float[n];
        int N[]=new int[n];
        float Ratio[]=new float[n];
        for(int i=0;i<n;i++){
            X[i]=P[i]/W[i];
            N[i]=i+1;
            Ratio[i]=(float) 0;
        }
        
        float temp;
        int tem;
        for (int i = 0; i < n; i++)   //Holds each Array element
         {     
            for (int j = i+1; j < n; j++)    //compares with remaining Array elements
            {     
               if(X[i] < X[j]) //Compare and swap
               {    
                   temp = X[i];    
                   X[i] = X[j];    
                   X[j] = temp; 
                   tem = P[i];    
                   P[i] = P[j];    
                   P[j] = tem;
                   tem = W[i];    
                   W[i] = W[j];    
                   W[j] = tem;
                   tem = N[i];    
                   N[i] = N[j];    
                   N[j] = tem;   
               }     
            }     
        }
        int Mass=M;
        int i;
        int Profit=0;
        for(i=0;i<n;i++){
            if(W[i]<Mass){
                Ratio[i]=1;
                Mass-=W [i];
                Profit+=P[i];
            }else{
                break;
            }
        }
        if(i<n){
            Ratio[i]=Mass * 1.0f / W[i];
            Profit+=P[i]*Ratio[i];
        }

        for (i = 0; i < n; i++) {     
            for (int j = i+1; j < n; j++) {     
               if(N[i] > N[j]) {    
                temp = X[i];    
                X[i] = X[j];    
                X[j] = temp; 
                tem = P[i];    
                P[i] = P[j];    
                P[j] = tem;
                tem = W[i];    
                W[i] = W[j];    
                W[j] = tem;
                tem = N[i];    
                N[i] = N[j];    
                N[j] = tem;  
                temp = Ratio[i];    
                Ratio[i] = Ratio[j];    
                Ratio[j] = temp; 
               }     
            }     
        }
        System.out.println("Item Number\tRatio");
        for(int j=0;j < n;j++){
            System.out.println(N[j]+"\t\t"+Ratio[j]);
        }
        System.out.println("Total Profit is "+Profit);    
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter max weight");
        int M=sc.nextInt();
        System.out.println("Enter the number of elements");
        int n=sc.nextInt();
        int W[]=new int[n];
        int P[]=new int[n];
        for(int i=0;i<n;i++){
            System.out.println("Enter profit of "+(i+1)+" element");
            P[i]=sc.nextInt();
            System.out.println("Enter weight of "+(i+1)+" element");
            W[i]=sc.nextInt();
        }
        Knapsack(P,W,M,n);

    }
}