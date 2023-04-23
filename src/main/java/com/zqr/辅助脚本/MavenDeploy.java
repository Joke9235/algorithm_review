package com.zqr.辅助脚本;

import java.util.Scanner;

/**
 * @author Kendric
 * @className MavenDeploy
 * @description 根据路径生成导入私仓命令
 * @createTime 2023/4/18 15:15
 */

public class MavenDeploy {
    public static void main(String[] args) {
        System.out.println("输入0关闭程序!");
        System.out.println("请输入依赖包: "); // com/fasterxml/oss-parent/34/oss-parent-34.pom
        String route = "";
        String flag = "";
        do{
            Scanner sc = new Scanner(System.in);
            route = sc.next();
            getCmd(route);
        }while (route != "0");
    }

    private static void getCmd(String route){
        String[] split = route.split("/");
        int length = split.length - 1;
        String result = "mvn deploy:deploy-file";
        String groupId = "";
        for (int i = 0; i < length - 2; i++) {
            groupId += split[i] + ".";
        }
        groupId = groupId.substring(0, groupId.length() - 1);
        result += " -DgroupId=" + groupId;
        result += " -DartifactId=" + split[length - 2];
        result += " -Dversion=" + split[length - 1];
        result += " -Dpackaging=jar";
        result += " -Dfile=" + split[length].replace(".pom", ".jar");
        result += " -DpomFile=" + split[length];

        result += " -Durl=http://10.10.144.11:8400/repository/maven-releases/ -DrepositoryId=wsjz-releases";
        System.out.println(result);
        result = "mvn deploy:deploy-file";
        result += " -DgroupId=" + groupId;
        result += " -DartifactId=" + split[length - 2];
        result += " -Dversion=" + split[length - 1];
        result += " -Dpackaging=pom";
        result += " -Dfile=" + split[length];

        result += " -Durl=http://10.10.144.11:8400/repository/maven-releases/ -DrepositoryId=wsjz-releases";
        System.out.println();
        System.out.println(result);
        System.out.println(route.substring(0,route.lastIndexOf("/")+1));
    }


}
