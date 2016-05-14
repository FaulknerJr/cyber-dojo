/*
 * Write a program that prints the numbers from 1 to 100.
 *  But for multiples of three print "Fizz" instead of the
 *  number and for the multiples of five print "Buzz". For
 *  numbers which are multiples of both three and five
 *  print "FizzBuzz".
 */

/**
 *
 * @author FaulknerJr
 */
public class FizzBuzz {
    
    public void run(){
        fizzBuzz();
    }
    
    private void fizzBuzz(){
        for(int i = 0; i < 100; ++i){
            if((i+1)%5 != 0 && (i+1)%3 != 0){
                System.out.print(i+1);
            } else {
                if((i+1)%3 == 0){
                    System.out.print("Fizz ");
                }
                if((i+1)%5 == 0){
                    System.out.print("Buzz");
                }
            }
            System.out.println("");
        }
    }
}
