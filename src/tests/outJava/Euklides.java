package tests.outJava;

public class Euklides { 

private static boolean bool_dummy = false;
private static double double_dummy = 0;
private static double x1 = 0;
private static double x2 = 0;

private static double funkcja0() {
x1 = 6666666;
x2 = 6;
while ( ! ( x1 == x2 ) ) {
double_dummy = ( ( x1 > x2 ) )? ( x1 = ( x1 - x2 ) ) : ( x2 = ( x2 - x1 ) );
}
return 
x1;
}

public static void main(String[] args) {
System.out.println( funkcja0() );
}
}