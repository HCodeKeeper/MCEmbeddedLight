package me.hcodekeeper.mcembeddedlight;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Array;
import java.util.Arrays;

public class LightLogger {
    private String path;

    public LightLogger(String path){
        this.path = path;
    }

    public void update(String intLight){
        try {
            Integer.parseInt(intLight);
        }catch (NumberFormatException e){
            NumberFormatException ex = new NumberFormatException("NumberFormatException! LightLogger was given a string that doesn't correpspond to number requirements");
            ex.addSuppressed(e);
            ExceptionLogger.logException(ex);
            return;
        }

        try(FileWriter fw = new FileWriter(path)){
            fw.write(intLight);
        }catch (IOException e){
            IOException ex = new IOException("IOException! txt File isn't found");
            ex.addSuppressed(e);
            ExceptionLogger.logException(ex);
        }
    }
}
