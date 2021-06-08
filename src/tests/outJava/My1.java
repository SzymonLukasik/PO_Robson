package tests.outJava;

public class My1 {

private static boolean bool_dummy = false;
private static double double_dummy = 0;
private static double index = 0;
private static double numer = 0;
private static double temp = 0;
private static double x1 = 0;
private static double x2 = 0;

private static double funkcja0() {
while ( ( index <= numer ) ) {
temp = ( x1 + x2 );
x1 = x2;
x2 = temp;
index = ( index + 1 );
}
return 0;
}

public static void main(String[] args) {
System.out.println( funkcja0() );
}
}