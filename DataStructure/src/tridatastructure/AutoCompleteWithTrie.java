package tridatastructure;

import java.util.List;

public class AutoCompleteWithTrie {
	
	 public static void main(String[] args) {         
            Trie t = getTrie();              
			List<String> a= t.autocomplete("amaz");
			for (int i = 0; i < a.size(); i++) {
				System.out.println(a.get(i));
			}	
	  }
	 
	 
	 private static Trie getTrie() {
         Trie trie = new Trie();    
         
         for(int i = 0 ; i < 5 ; i++) {
        	 trie.insert("amazon " + i); 
         }
         
         for(int i = 0 ; i < 3 ; i++) {
        	 trie.insert("amazing spider man " + i); 
         }
         
         for(int i = 0 ; i < 5 ; i++) {
        	 trie.insert("Google " + i); 
         }
         return trie;
	 }
	 
}
