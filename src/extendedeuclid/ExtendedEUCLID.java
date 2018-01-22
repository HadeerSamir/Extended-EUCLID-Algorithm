
package extendedeuclid;

import java.util.Scanner;


public class ExtendedEUCLID {  
    
    public static long gcd(long x,long y){
        
            long output;
            long smallNumber;
            long largeNumber;
            if(x<y){
                smallNumber=x;
                largeNumber=y;
            }
            else{
                smallNumber=y;
                largeNumber=x;
            }
            
            if(x==0){
                output=y;
            }
            else if(y==0){
                output=x;
            }
            else{
                output=gcd(smallNumber,largeNumber%smallNumber);
            }
            
            return output;


        }
    
    
    public static long addativeInverse(long m,long n){
        
        long n1=-n;
       
        while(n1<0){
            n1+=m;
        }
        return n1;
    }
    
    public static String extendEUCLID(long m,long n){
        String output="";
        long A1=1;
        long A2=0;
        long A3=m;
        long B1=0;
        long B2=1;
        long B3=n;
        long T1,T2,T3=0;
        
        
       while(true){
        
        
        if(B3==0){
            A3=gcd(m,n);   //no inverse
            output="IMPOSSIBLE";
            break;
        }
        else if(B3==1){
            B3=gcd(m,n);
            if(B2<0){
                B2=B2+m;
                B2=B2%m;
            }
            output+=B2;
            break;
        }
        else{
            
        long Q=A3/B3;
        T1=A1-Q*B1;
        T2=A2-Q*B2;
        T3=A3-Q*B3;
        A1=B1;
        A2=B2;
        A3=B3;
        B1=T1;
        B2=T2;
        B3=T3;
        }
       }
       return output;
        
    }

   
    public static void main(String[] args) {
        
        
        Scanner scan=new Scanner(System.in);
        
        String num1=scan.next();
        String num2=scan.next();
           
        
        long n1=Long.parseLong(num1);
        long n2=Long.parseLong(num2);
        
       long addInverse=addativeInverse(n1,n2);
       String mulInverse=extendEUCLID(n1,n2);
       if(mulInverse!="IMPOSSIBLE"){
           System.out.println(addInverse+" "+mulInverse);
       }
       else{
           System.out.println(mulInverse);
       }
         
     
    }
    
}
