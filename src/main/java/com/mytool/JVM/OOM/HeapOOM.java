package com.mytool.JVM.OOM;

import java.util.ArrayList;
import java.util.List;

/**
 * @author duankd
 * @VMArgs: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * @ClassName HeapOOM
 * @date 2021-06-27 23:06:46
 */
public class HeapOOM {
    static class OOMProject {

    }

    public static void main(String[] args) {
        List<OOMProject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMProject());
        }
    }
}
