package tests.outJava;

public class Przyklad2 { 

private static boolean bool_dummy = false;
private static double double_dummy = 0;
private static double index = 0;
private static double numer = 0;
private static double temp = 0;
private static double x1 = 0;
private static double x2 = 0;

private static double funkcja0() {
return 
1;
}

private static double funkcja1() {
x1 = 1;
x2 = 1;
index = 3;
while ( ( index <= numer ) ) {
temp = ( x1 + x2 );
x1 = x2;
x2 = temp;
index = ( index + 1 );
}
return 
x2;
}

private static double funkcja2() {
numer = 10;
return 
( ( numer <= 2 ) )? funkcja0() : funkcja1();
}

public static void main(String[] args) {
System.out.println( funkcja2() );
}
}