#include<stdio.h>
#include<stdlib.h>

void mul(int A[2][2],int B[2][2]){
    int C[2][2];
    for(int i=0;i<2;i++)    
    {    
        for(int j=0;j<2;j++)    
        {       
            C[i][j]=0;    
            for(int k=0;k<2;k++)    
            {    
                C[i][j]+=A[i][k]*B[k][j];    
            }    
        }    
    }    
}
void matrix_input(int A[2][2]){
    printf("Enter 4x4 matrix");
    for(int i=0;i<4;i++){
        for(int j=0;j<4;j++){
            scanf("%d",&A[i][j]);
        }
    }
}
int main()
{
    int A[2][2];
    matrix_input(A);
    for(int i=0;i<4;i++){
        for(int j=0;j<4;j++){
            printf("%d",A[i][j]);
        }
    }
    return 0;
}
