package bdn.labo.nbpremiers.eratosthenes;

public class Eratosthenes2 {
	 
    ExtendedBitSet a;
 
    public void set( long i ){
        if( (i & 1L) == 1L ){
            a.set( (i-1) / 2 );
        }
        else {
            throw new IllegalArgumentException("can not clear even numbers");
        }
    }
 
    public boolean get( long i ){
        if( (i & 1L) == 0 ){
            if( i == 2 ) return true;
            return false;
        }
        return a.get( (i-1) / 2 );
    }
 
    public void clear( long i ){
        if( (i & 1L) == 1L ){
            a.clear( (i-1) / 2 );
        }
    }
 
    public void calculateFor(long n) {
        a = new ExtendedBitSet(n / 2 + 1, true );
        clear(1);
 
        long p = 3;
        while( (p*p) < n) {
            long j = p*p;
            while (j < n) {
                clear(j);
                j = j + p;
            }
 
            do {
                p++;
            } while (!get(p));
        }
    }
 
    public static void main( String[] args ){
        long n = 0x1000000L;
        Eratosthenes2 appli = new Eratosthenes2();
        appli.calculateFor(n);
        for( int i = 1; i < n; i++){
            if( appli.get(i) ) System.out.println( i );
        }
    }
 
}