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

    private static String EXT1 = "MP4";
    private static String EXT2 = "FLV";
    
    private static int MAX_DURATION = 25;
    private static int MAX_START = 480;

    private int seed;
    private List<String> srcs;

    public PlayUtils() {

        this.srcs = new ArrayList<String>();
        this.seed = 0;
    }

    public Fragment next() {
        int index = new Double(this.random() * (this.srcs.size() - 1)).intValue();
        File file = new File( this.srcs.get(index));
        
        Fragment frag =  new Fragment();
        frag.setDuration(new Double(MAX_DURATION * random()).intValue());
        frag.setStart(new Double(MAX_START * random()).intValue());
        frag.setVideo(file);
        
        return frag;
    }

    public Double random() {

        String strSeed = String.valueOf(this.seed);
        Double actualSeed = Math.random() * (strSeed.length() - 1) + 1;
        Double finalRandom = null;

        for (int i = 0; i < actualSeed.intValue(); i++) {
            finalRandom = Math.random();
        }

        return finalRandom;
    }

    public void scanDir(String path) {
        File file = new File(path);
        scanDir(file);
    }

    public void scanDir(File dir) {
        if (dir.isDirectory()) {
            for (File file : dir.listFiles()) {
                scanDir(file);
            }
        } else {
            if (dir != null) {
                if (dir.getName().toUpperCase().endsWith(EXT1) || dir.getName().toUpperCase().endsWith(EXT2)) {
                    this.srcs.add(dir.getPath());
                        System.out.println("agregando ... " + dir.getName());
                }
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
