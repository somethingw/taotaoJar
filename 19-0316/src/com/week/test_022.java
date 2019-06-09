package com.week;

import java.util.ArrayList;
import java.util.List;

/**
 * @author week
 * @Title: test_022
 * @ProjectName 19-0316
 * @Description: TODO
 * @date 2019/5/309:09
 */
public class test_022 {
    static class OOM{}

    public static void main(String[] args) {
        List<OOM> list =new ArrayList<>();
        while (true){
            list.add(new OOM());
        }
    }
}
