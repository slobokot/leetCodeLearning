package com.slobokot;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class JarResources {
    public String readAsString(String name) throws Exception {
        StringBuilder sb = new StringBuilder();
        read(name, x -> sb.append(x).append("\n"));
        return sb.toString();
    }

    public List<String> readAllLines(String name) throws Exception {
        List<String> res = new ArrayList<>();
        read(name, res::add);
        return res;
    }

    private void read(String name, ForEachString forEachString) throws Exception {
        InputStream stream = getClass().getClassLoader().getResourceAsStream(name);
        if (stream == null) throw new FileNotFoundException(name);
        BufferedReader r = new BufferedReader(new InputStreamReader(stream));
        String s;
        while ( (s = r.readLine()) != null) {
            forEachString.apply(s);
        }
        stream.close();
    }

    private interface ForEachString {
        void apply(String s);
    }
}
