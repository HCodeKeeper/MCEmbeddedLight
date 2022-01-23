package me.hcodekeeper.mcembeddedlight;

import java.io.FileWriter;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.ArrayList;

public class ExceptionLogger {
    private static String ExceptionPath = "D:\\MCLightC\\ExceptionLog.txt";
    private static ArrayList<Exception> Exceptions = new ArrayList<>();

    public static ArrayList<Exception> getExceptions(){
        return new ArrayList<Exception>(Exceptions);
    }

    public static void logException(Exception exception){
        Exceptions.add(exception);
        try(FileWriter fw = new FileWriter(ExceptionPath)){
            for (Exception ex : getExceptions()){
                fw.write(ex.getMessage());
            }
        }catch (IOException e){
            throw new UncheckedIOException(e);
        }
    }
}
