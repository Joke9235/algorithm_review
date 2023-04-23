package com.zqr.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Kendric
 * @className GetServiceByPhoneNoPrefix
 * @description
 * @createTime 2022/10/28 13:58
 */

public class GetServiceByPhoneNoPrefix {
    public static void main(String[] args) {
        System.out.println(getService("093266081"));
    }

    private static String getService(String phoneNo) {
        String prefix;
        if (phoneNo.length() < 3) {
            return null;
        }else{
            prefix = phoneNo.substring(0,3);
        }
        final String[] result = new String[1];

        String cellcardPrefixes = "011,012,014,017,061,076,077,078,085,089,092,095,099";
        String smartPrefixes = "010,015,016,069,070,081,086,087,093,096,098";
        String metfonePrefixes = "088,097,071,031,060,066,067,068,090";
        String qbPrefixes = "013,080,083,084";
        String seatelPrefixes = "018";
        String cootelPrefixes = "038";

        Map<String, List<String>> map = new HashMap<>();
        map.put("Cellcard", Arrays.asList(cellcardPrefixes.split(",")));
        map.put("Smart", Arrays.asList(smartPrefixes.split(",")));
        map.put("Metfone", Arrays.asList(metfonePrefixes.split(",")));
        map.put("qb", Arrays.asList(qbPrefixes.split(",")));
        map.put("SEATEL", Arrays.asList(seatelPrefixes.split(",")));
        map.put("Cootel", Arrays.asList(cootelPrefixes.split(",")));

        map.forEach((k, v) -> {
            if(v.contains(prefix)){
                result[0] = k;
                return;
            }
        });

        return result[0];
    }
}
