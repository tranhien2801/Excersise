
public class Fraction {

    private int numerator;
    private int denominator;

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int n) {
        this.numerator = n;
    }

    public int getDenominator() {
        return denominator;
    }

    /**
     * setDenominator.
     */
    public void setDenominator(int n) {
        if (n != 0) {
            this.denominator = n;
        } else {
            this.denominator = 1;
        }
    }

    public Fraction() {
        
    }

    /**
     * khoi tao.
     */
    public Fraction(int n, int d) {
        if (d != 0) {
            this.numerator = n;
            this.denominator = d;
        } else {
            this.denominator = 1;
        }
    }

    /**
     * ucln.
     */
    public int ucln(int a, int b) {
        if (a < 0) {
            a = -a;
        }
        if (b < 0) {
            b = -b;
        }

        while (a * b != 0) {
            if (a > b) {
                a = a % b;
            } else {
                b = b % a;
            }
        }
        return a + b;
    }

    /**
     * reduce.
     */
    public Fraction reduce() {
        int x = ucln(this.numerator, this.denominator);
        if (this.denominator < 0) {
            this.numerator = -1 * this.numerator / x;
            this.denominator = -1 * this.denominator / x;
        } else {
            this.numerator = this.numerator / x;
            this.denominator = this.denominator / x;
        }
        return this;
    }

    /**
     * add.
     */
    public Fraction add(Fraction s) {
        this.numerator = this.numerator * s.getDenominator() + this.denominator * s.getNumerator();
        this.denominator = this.denominator * s.getDenominator();
        this.reduce();
        return this;
    }

    /**
     * subtract.
     */
    public Fraction subtract(Fraction s) {
        this.numerator = this.numerator * s.getDenominator() - this.denominator * s.getNumerator();
        this.denominator = this.denominator * s.getDenominator();
        this.reduce();
        return this;
    }

    /**
     * multiply.
     */
    public Fraction multiply(Fraction s) {
        this.numerator = this.numerator * s.getNumerator();
        this.denominator = this.denominator * s.getDenominator();
        this.reduce();
        return this;
    }

    /**
     * divide.
     */
    public Fraction divide(Fraction s) {
        if (s.getNumerator() != 0) {
            this.numerator = this.numerator * s.getDenominator();
            this.denominator = this.denominator * s.getNumerator();
        }
        this.reduce();
        return this;
    }

    /**
     * so sanh.
     */
    public boolean equals(Object obj) {
        if (obj instanceof Fraction) {
            Fraction other = (Fraction) obj;
            if (this.numerator * other.getDenominator() - this.denominator * other.getNumerator() == 0) {
                return true;
            } else {
                return false;
            }

        }
        return false;
    }

    /**
     * main.
     */
    public static void main(String [] args) {
        Fraction a = new Fraction(-1, 2);
        Fraction b = new Fraction(-3, 6);
        if (a.equals(b)) {
            System.out.println("YES");
        }
        b.reduce();
        System.out.print(b.getNumerator() + "/" + b.getDenominator());
    }

}
