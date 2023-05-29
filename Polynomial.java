public class Polynomial {
    
    // fields
    double [] coefficients;

    // contructors:
    public Polynomial() {
        
        coefficients = new double [1];
    }

    public Polynomial(double [] coeffs) {

        coefficients = coeffs;
    }

    // methods:
    public Polynomial add(Polynomial p) {
        int length = Math.max(coefficients.length, p.coefficients.length);
        double [] sum_array = new double[length];
        Polynomial sum = new Polynomial(sum_array);

        for (int i = 0; i < length; i++) {
            
            if (i < coefficients.length)
                sum.coefficients[i] += coefficients[i];
            
            if (i < p.coefficients.length)
                sum.coefficients[i] += p.coefficients[i];
        }

        return sum;
    }

    public double evaluate(double x) {
        double sum = this.coefficients[0];

        for (int i = 1; i < this.coefficients.length; i++) {
            sum += this.coefficients[i] * Math.pow(x, i);
        }

        return sum;
    }

    public boolean hasRoot(double x) {
        
        return evaluate(x) == 0;
    }
}