package bdn.nbpremiers.util;

import bdn.labo.nbpremiers.eratosthenes.Eratosthenes2;
import bdn.labo.nbpremiers.eratosthenes.ExtendedBitSet;

public class NbPremiersCalculatorUtils {

	
	public static class Classical {
		public static boolean isNombrePremier(long nb) {
			
			for (long d = 2; d < nb; d++) {
				if (nb % d == 0) {
//					System.out.println(nb + " pas nbre premier !! :(");
//					System.out.println("[!]""d/nb = " + nb % d);
					return false;
				}
			}
			
//			System.err.println("c=" + c);
//			System.out.println("[!!!]"+ nb + " est un nbre premier");
//			System.out.println("d/nb = " + nb);
//			
			return true;
		}
		
		
	}
	
	/**
	 * 
	 * @author a135480
	 *
	 */
	public static class OptimizedSquare {
		
		public static boolean isNombrePremier(long nb) {
			if (nb == 2) {
				return true;
			}
			if (nb%2 == 0) {
				return false;
			}
			
			for (long d = 3; d < Math.sqrt(nb+1); d+=2) {
				if (nb % d == 0) {
					return false;
				}
			}

			return true;
		}
	}
	
	/**
	 * 
	 * @author a135480
	 *
	 */
	public static class Eratosthenes2 {
		 
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
	 
	    public static void lookForAllTo(long max){
	        long n = 0x1000000L;
	        Eratosthenes2 appli = new Eratosthenes2();
	        appli.calculateFor(n);
	        for( int i = 1; i < n; i++){
	            if( appli.get(i) ) System.out.println( i );
	        }
	    }
	}
}
