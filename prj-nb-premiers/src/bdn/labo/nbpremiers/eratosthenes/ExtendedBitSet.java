package bdn.labo.nbpremiers.eratosthenes;

import java.util.BitSet;

/**
 * Redefinition de BitSet permettant d'accepter des long
 * @author bdn
 *
 */
public class ExtendedBitSet {
    BitSet array[] = null;
 
    public static final long STORAGE_SIZE = (1 << 30);
    int blocks;
 
    public ExtendedBitSet(long n, boolean state) {
        int blocks = (int)(n / STORAGE_SIZE) + 1;
        array = new BitSet[blocks];
        for( int i = 0; i < array.length; i++){
            if( i == array.length - 1 ){
                int remaining = (int)(n - ((n / STORAGE_SIZE) * STORAGE_SIZE)) + 1;
                array[i] = new BitSet(remaining);
            }
            else {
                array[i] = new BitSet( (int)STORAGE_SIZE );
            }
            array[i].set(0, array[i].size(), state );
        }
    }
 
    private BitSet getBlock(long n){
        int blk = (int)(n / STORAGE_SIZE);
        return array[blk];
    }
 
    public void clear(long bitIndex) {
        if (bitIndex < 0)
            throw new IndexOutOfBoundsException("bitIndex < 0: " + bitIndex);
 
        getBlock(bitIndex).clear( (int)(bitIndex % STORAGE_SIZE) );
    }
 
    public void set(long bitIndex) {
        if (bitIndex < 0)
            throw new IndexOutOfBoundsException("bitIndex < 0: " + bitIndex);
 
        getBlock(bitIndex).set( (int)(bitIndex % STORAGE_SIZE) );
    }
 
    public boolean get(long bitIndex) {
        if (bitIndex < 0)
            throw new IndexOutOfBoundsException("bitIndex < 0: " + bitIndex);
 
        return getBlock(bitIndex).get( (int)(bitIndex % STORAGE_SIZE) );
    }
}