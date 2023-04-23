package com.zqr.辅助脚本;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kendric
 * @className Sql
 * @description 重复的sql, 有部分数据在递增
 * @createTime 2023/4/20 16:23
 */

public class DuplicateSql {
    public static void main(String[] args) {
        String prefix = "INSERT INTO HBS_EBANK_PLATFORM.EBANK_PLATFORM_TRANS_CODE\n" +
                "(CODE, TRANS_CODE, LOCAL_NAME, ENG_NAME, CH_NAME, REMARKS, CREATE_BY, CREATE_TIME, MODIFY_BY, MODIFY_TIME)\n" +
                "VALUES('F";
        String suffix = "', '9991198', 'FEE CHARGES', 'FEE CHARGES', 'FEE CHARGES', NULL, 'zhangqr', TIMESTAMP '2023-04-20 16:23:38.000000', 'zhangqr', TIMESTAMP '2023-04-20 16:23:38.000000');\n";
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= 90; i++) {
            result.add(prefix + String.format("%02d", i) + suffix);
            System.out.println(result.get(i - 1));
        }

    }
}
