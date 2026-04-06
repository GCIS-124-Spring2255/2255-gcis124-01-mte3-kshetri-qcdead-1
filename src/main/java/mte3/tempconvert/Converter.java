// Exam: 2255 GCIS 124, Mid Term Exam #3, Question 1
// Filename: Converter.java (inside tempconvert package)

package mte3.tempconvert;
import java.util.Scanner;

public class Converter {
    
    private static class CelsiusToFahrenheit implements TempConvert {

        @Override
        public double convert(double temp) {    return temp * 9.0 / 5.0 + 32;    }
        
    } // CelciusToFahrenheit closed

    public static void main(String[] args) {
        
        try(Scanner scanner = new Scanner(System.in)) {
            System.out.print("Please enter temperature (for conversion): ");
            double input = scanner.nextDouble();
            // (part 1) conversion from C to F
            CelsiusToFahrenheit CtoF = new CelsiusToFahrenheit();
            double CtoFoutput = CtoF.convert(input);
            System.out.println("C to F: " + CtoFoutput);
            
            
            // (part 2) conversion from F to C
            TempConvert FtoC = new TempConvert() {
                @Override
                public double convert(double temp) {    return (temp - 32) * 5/9;}
            };            
            double FtoCoutput = FtoC.convert(input);
            System.out.println("F to C: " + FtoCoutput);

            
            // (part 3) conversion from F to K

            TempConvert FtoK = temp -> (temp - 32) * 5/9 + 273.15;
            double FtoKoutput = FtoK.convert(input);
            System.out.println("F to K: " + FtoKoutput);





        }  // try { } block closed

    } // main () method closed

} // Converter { } class closed