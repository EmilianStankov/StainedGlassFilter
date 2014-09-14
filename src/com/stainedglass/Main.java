package com.stainedglass;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        StainedGlassFilter filter = new StainedGlassFilter(new File(args[0]), new File(args[1]), Integer.parseInt(args[2]));
        filter.export(new File(args[1]));
    }
}
