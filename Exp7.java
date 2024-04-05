import java.util.*;
public class Exp7 {
    static void allPaths(int A[][],int n,int P[][]){
        
        
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of warehouses and enter -1 for infinity");
        int n=sc.nextInt();
        int A[][]=new int[n][n];
        int P[][]=new int[n][n];
        // System.out.println("Enter the distances");
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j){
                    A[i][j]=0;
                    P[i][j]=0;
                }else{
                    System.out.println("Enter the distance from "+(i+1)+" to "+(j+1));
                    int d=sc.nextInt();
                    A[i][j]= (d==-1)?10000:d;
                    if(d==-1){
                        A[i][j]=1000;
                        P[i][j]=0;
                    }else{
                        A[i][j]=d;
                        P[i][j]=i+1;
                    }
                }
            }
        }
        
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    // A[i][j]=(A[i][j]<(A[i][k]+A[k][j])?A[i][j]:(A[i][k]+A[k][j]));
                    if(A[i][j]>A[i][k]+A[k][j]){
                        A[i][j]=A[i][k]+A[k][j];
                        P[i][j]=k+1;
                    }
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(A[i][j]+" ");
            }
            System.out.println();
        }        

    }
}
