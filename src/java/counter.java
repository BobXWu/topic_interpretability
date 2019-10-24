import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Collections;
import java.util.Random;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.Math;


public class Counter{

    public ArrayList<MultiTerm> multiTerms;
    public ArrayList<ArrayList<Integer>> multiTerms_list;
    public ArrayList<ArrayList<Integer>> mit_id_text;
    public ArrayList<ArrayList<ArrayList<Integer>>> text_multiTerms;
    public int topic_num;
    public int top_words_num;

    public int window_size;
    public HashMap<String, HashSet<String>> topic_wod_rel;
    public HashSet<String> unigram_set;

    public Counter(){
        topic_wod_rel = new HashMap<String, HashSet<String>>();
        unigram_set = new HashSet<String>();
    }

    public static void main(String[] args) throws IOException{

    }

    public void count() throws IOException{

        BufferedReader reader;
        String line;
        try{
            reader = new BufferedReader(new FileReader(topic_path));
            while((line = reader.readLin()) != null){

                String[] words = line.split("\\s+");
                for(int i=0; i<words.length; i++){
                    String[] words_sp = words[i].split(colloc_sep);
                    String w1 = String.join(" ", words_sp);

                    for(int j=0; j<w1.length; j++){
                        unigram_set.add(w1[j]);
                    }

                    for(int j=0; j<words.length; j++){
                        String w2 = String.join(" ", words[j].split(colloc_sep))
                        update_topic_word_rel(w1, w2);
                    }
                }
            }
        }catch(IOException e) {
            e.printStackTrace();
        }

        

    }

    public void update_topic_word_rel(String w1, String w2){
        HashSet<String> related_word_set;
        if( topic_word_rel.hasKey(w1) ){
            related_word_set = topic_word_rel
            topic_word_rel.get[w1].add(w2)
        }else{
            related_word_set = new HashSet<String>();
            related_word_set.add(w2);
            topic_word_rel.put(w1, related_word_set);
        }
    }

}
