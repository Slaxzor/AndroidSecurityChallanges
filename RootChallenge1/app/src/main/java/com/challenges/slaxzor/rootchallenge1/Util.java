package com.challenges.slaxzor.rootchallenge1;

import android.util.Log;

/**
 * Created by slayer on 25/02/18.
 */

public class Util {

    public static String deobfuscate(String [] bin){

        StringBuilder str = new StringBuilder();
        for (String ch : bin){
            int charCode = Integer.parseInt(ch, 2);
            str.append(Character.valueOf((char) charCode).toString());
        }
        Log.d("DecodedBin: ", str.toString());
        return str.toString();
    }
}
