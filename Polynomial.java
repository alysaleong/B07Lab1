import java.util.Arrays;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintStream;


public class Polynomial {
    
    // fields
    double [] coefficients;
    int [] exponents;

    // contructors:
    public Polynomial() {
        
        coefficients = new double [1];
        exponents = new int [1];
    }

    public Polynomial(double [] coefficients, int [] exponents) {

        this.coefficients = coefficients;
        this.exponents = exponents;
    }

    public Polynomial(File p) {
        BufferedReader b = new BufferedReader(new FileReader(p));
        String line = b.readLine();
        
        String [] parts = line.split("?=[+-]");
        for (String part : parts) {
            part.split("x");
        }

        int i = 0;
        for (String part : parts) {
            if (part.getClass().isArray()) {
                coefficients[i] = Double.parseDouble(part);
                exponents[i] = Integer.parseInt(part);
            }
            else {
                coefficients[i] = Double.parseDouble(part);
                exponents[i] = 0;
            }
            i++;
        }
    }

    // methods:
    public Polynomial add(Polynomial p) {
        // create arrays for exponents and coefficients
        int [] temp_exp = new int[this.exponents.length + p.exponents.length];
        double [] temp_coeff = new double[this.coefficients.length + p.coefficients.length];

        int i = 0;
        int j = 0;
        int k = 0;
        
        while (i < this.exponents.length || j < p.exponents.length) {
            if (i == this.exponents.length || this.exponents[i] > p.exponents[j]) {
                temp_exp[k] = p.exponents[j];
                temp_coeff[k] = p.coefficients[j];
                j++;
            }
            else if (j == p.exponents.length || this.exponents[i] < p.exponents[j]) {
                temp_exp[k] = this.exponents[i];
                temp_coeff[k] = this.coefficients[i];
                i++;
            }
            else {
                temp_exp[k] = this.exponents[i];
                temp_coeff[k] = this.coefficients[i] + p.coefficients[j];
                i++;
                j++;
            }
            k++;
        }
        
        int [] sum_exp = Arrays.copyOfRange(temp_exp, 0, k);
        double [] sum_coeff = Arrays.copyOfRange(temp_coeff, 0, k);

        Polynomial sum = new Polynomial(sum_coeff, sum_exp);

        return sum;
    }

    public double evaluate(double x) {
        double sum = 0;

        for (int i = 0; i < coefficients.length; i++) {
            sum = sum + coefficients[i] * Math.pow(x, exponents[i]);
        }

        return sum;
    }

    public boolean hasRoot(double x) {
        
        return evaluate(x) == 0;
    }

    public void saveToFile(String file_name) {
        PrintStream ps = new PrintStream(file_name);

        for (int i = 0; i < coefficients.length; i++) {
            if (exponents[i] == 0) {
                ps.print(coefficients[i]);
            }
            else {
                ps.print(coefficients[i]);
                ps.print("x");
                ps.print(exponents[i]);
            }
        }
    }
}