import java.io.BufferedReader;
import java.math.BigInteger;
import java.io.*;

class diffieHellman {
  

public static void main(String[]args)throws IOException {

  BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
  System.out.println("Diffie-Hellman Algorithm");
  System.out.println("Enter Prime Number:");
  // Value for Prime Number
  BigInteger prime=new BigInteger(br.readLine());
  System.out.print("Enter Primitive Root of "+prime+": ");
  BigInteger g=new BigInteger(br.readLine());
  System.out.println("Enter value for User 1. Must be less than "+prime+": ");
  BigInteger x=new BigInteger(br.readLine());
  System.out.println("Enter value for User 2. Must be less than "+prime+": ");
  BigInteger y=new BigInteger(br.readLine());
  //Execute Function
  deffieHellman(prime, g, x, y);
}

public static void deffieHellman(BigInteger p, BigInteger g, BigInteger x, BigInteger y) {
    BigInteger R1=g.modPow(x,p);
    BigInteger R2=g.modPow(y,p);
    BigInteger k1=R2.modPow(x,p);
    BigInteger k2=R1.modPow(y,p);

    //Display Data and Results
    System.out.println("R1="+R1);
    System.out.println("R2="+R2);
    System.out.println("Key calculated at User 1' side:"+k1);
    System.out.println("Key calculated at User 2' side:"+k2);

    //compareTo validates the values of BigIntegers k1 & k2. If compareVal = 0, k1 & k2 are equal.
    int compareVal= k1.compareTo(k2);
    
    if(compareVal == 0) {
      System.out.println("Deffie-Hellman secret key Encryption has Taken");
    }

    else {
      System.out.print("No equal keys. Trade Not Successful");
    }
  }
}
