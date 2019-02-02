package datastructure;
import org.junit.Test;

public class HashTable {
    
    private static int SIZE = 10;
    
    private String[] hashtable = new String[SIZE];
    
    public void add(String value) {
 
        int i = 0;
 
        do {
            int hash = hash(value, i);
            if (hashtable[hash] == null) {
                hashtable[hash] = value;
                return;
            }
            i++;
        } while (i < SIZE);
 
        // hash table is full
        throw new RuntimeException("Hash table overflow");
    }
 
    public int search(String value) {
        int i = 0;
 
        do {
            int hash = hash(value, i);
            if (hashtable[hash] == null) {
                return -1;
            } else {
                if (hashtable[hash].equals(value)) {
                    return i + 1;
                }
                i++;
            }
 
        } while (i < SIZE);
 
        return -1;
    }
 
    public int hash(String key, int i) {

        char firstCharacter = key.charAt(0); // fetch the first character
        int asciiValue = (int) firstCharacter;
        int hash = asciiValue - 97;
        return (hash + i) % SIZE;
    }
    
    public int probe(double i){
        // quadratic probing
        i = Math.pow(-1, i-1) * Math.pow(((i + 1)/2), 2);
        return (int)i;
    }
    
    public void print(){
        for(int i = 0; i< hashtable.length; i++) 
        System.out.println(i + " " + hashtable[i]);
    }
    
    @Test
    public void hasTableUnitTest() {

        String[] word = { "arc", "ball", "car", "dog", "apple", "bat", "door" };
        HashTable testHashTable = new HashTable();

        for (int i = 0; i < 7; i++) {
            testHashTable.add(word[i]);
            
        }
        
        testHashTable.print();
        
        int readsPerSec = testHashTable.search("apple");  
        System.out.println(readsPerSec);
        //performance
        double loadFactor = (double)word.length /(double) testHashTable.SIZE;
        double hashEfficieny = loadFactor / (double)readsPerSec; 
        System.out.println(hashEfficieny);
        
        

    }
 
}
