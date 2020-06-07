package com.slobokot;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class JarResources {
    public List<String> readAllLines(String name) throws Exception {
        InputStream stream = getClass().getClassLoader().getResourceAsStream(name);
        BufferedReader r = new BufferedReader(new InputStreamReader(stream));
        List<String> res = new ArrayList<>();
        String s;
        while ( (s = r.readLine()) != null) {
            res.add(s);
        }
        stream.close();
        return res;
    }
}
