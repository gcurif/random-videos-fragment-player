/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.orange.randomplaer.mavenproject1.player;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gustavo
 */
public class PlayUtils {
    
    private static String EXT1;
    private static String EXT2;
    
    private int seed;
    private List<String> srcs;
    
    public PlayUtils(){
        
        this.srcs = new ArrayList<String>();
        this.seed = 0;
    }
    
    public String next(){
        int index = new Double(this.random() *( this.srcs.size() -1 )).intValue();
        return this.srcs.get(index);
    }
    
    public Double random(){
        
        String strSeed = String.valueOf(this.seed);
        Double actualSeed = Math.random() * (strSeed.length()-1) + 1;
        Double finalRandom = null;
        
        for(int i= 0; i< actualSeed.intValue() ; i++){
            finalRandom = Math.random();
        }
        
        return finalRandom;
    }
    
    public void scanDir(File dir){
        if(dir.isDirectory()){
            for(File file : dir.listFiles()){
                scanDir(file);
            }
        }else{
            if(dir.getName().endsWith(EXT1) || dir.getName().endsWith(EXT2)){
                this.srcs.add(dir.getPath());
            }
        }
    }
    
    public int getSeed() {
        return this.seed;
    }

    public void setSeed(int seed) {
        this.seed = seed;
        
    }

    
    
    
    
}
