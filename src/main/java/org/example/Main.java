package org.example;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.math3.stat.descriptive.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;


public class Main {
    public Main() throws IOException {
    }

    //    InputStream inputStream = getClass().getResourceAsStream("myFile.txt");
    public String getStringFromFile() throws IOException {
        InputStream inputStream = getClass().getResourceAsStream("myFile.txt");
        return new String(inputStream.readAllBytes());
    }

    public static void main(String[] args) throws IOException {
        String str = new Main().getStringFromFile();
        Double[] characters1 = Arrays.stream(str.chars()
                .mapToObj(c -> (double)Character.getNumericValue(c))
                .toArray(Double[]::new))
                .toArray(size -> new Double[size]);
        double[] finalDouble = ArrayUtils.toPrimitive(characters1);
        DescriptiveStatistics descStat = new DescriptiveStatistics(finalDouble);
        System.out.println(descStat.getMax());
    }
}