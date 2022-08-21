package com.rafraph.pnineyHalachaHashalem;

import java.util.ArrayList;
import java.util.List;

public class Trie {

    // Alphabet size (# of symbols)
    static final int ALPHABET_SIZE = 31;
    public static String abc="אבגדהוזחטיכלמנסעפצקרשתףםןץך /()";


    // trie node
    static class TrieNode
    {
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];


        // isEndOfWord is true if the node represents
        // end of a word
        boolean isEndOfWord;

        TrieNode(){
            isEndOfWord = false;
            for (int i = 0; i < ALPHABET_SIZE; i++)
                children[i] = null;
        }
    };

    static TrieNode root;
    Trie()
    {
        this.root=new TrieNode();
    }
    // If not present, inserts key into trie
    // If the key is prefix of trie node,
    // just marks leaf node
    static void insert(String key)
    {
        key.replace("\'","");
        int level;
        int length = key.length();
        int index;

        TrieNode pCrawl = root;

        for (level = 0; level < length; level++)
        {
            index = abc.indexOf(key.charAt(level));
            if(index==-1)
                index++;
            if (pCrawl.children[index] == null)
                pCrawl.children[index] = new TrieNode();
            pCrawl = pCrawl.children[index];
        }

        // mark last node as leaf
        pCrawl.isEndOfWord = true;
    }

    // Returns true if key presents in trie, else false
    static boolean search(String key)
    {
        key.replace("\'","");
        int level;
        int length = key.length();
        int index;
        TrieNode pCrawl = root;

        for (level = 0; level < length; level++)
        {
            index = abc.indexOf(key.charAt(level));

            if (pCrawl.children[index] == null)
                return false;

            pCrawl = pCrawl.children[index];
        }

        return (pCrawl.isEndOfWord);
    }
    static List<String> complite(String key)
    {
        key.replace("\'","");
        List<String> lst= new ArrayList<String>();
        int level;
        int length = key.length();
        int index;
        TrieNode pCrawl = root;

        for (level = 0; level < length; level++)
        {
            index = abc.indexOf(key.charAt(level));

            if (pCrawl.children[index] == null)
                return lst;

            pCrawl = pCrawl.children[index];
        }
        return reqCom(lst,pCrawl,key);
    }
    static List<String> reqCom(List<String> lst,TrieNode pw,String key)
    {
        for(int i=0;i<ALPHABET_SIZE;i++)
            if (pw.children[i] == null)
                continue;
            else
                reqCom(lst,pw.children[i],(key+abc.charAt(i)) );

        lst.add(key);
        return lst;
    }
}