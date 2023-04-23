package com.zqr._1024;

/**
 * @author Kendric
 * @className GirlFriend
 * @description 对象
 * @createTime 2021/10/24 5:20
 */
public class GirlFriend {
    private static GirlFriend girlFriend;
    //懒汉单例模式
    private GirlFriend() {}
    public static GirlFriend getGirlFriend(){
        if(girlFriend ==null){
            girlFriend =new GirlFriend();
            System.out.println(girlFriend);
            heart();
            return girlFriend;
        }
        System.out.println("JAVA: 主人，女朋友有且只有一个哦，哼！大猪蹄子，休想让我给你再new一个女朋友！");
        return null;
    }

    public void goShopping(){
        System.out.println("JAVA: 陪女朋友一起去逛街，你手上提了一大堆袋子，非常累，但是女朋友很高兴，亲了你一下，你瞬间觉得再累都值得！");
    }

    public void seeMovies(){
        System.out.println("JAVA: 和女朋友一起去看了一场电影，你和女朋友的关系又更进了一步呢！");
    }

    public void doSomething(){System.out.println("JAVA: 和女朋友亲亲,抱抱,举高高！");}

    final private String sex = "女";          //性别
    final private int age = 18;               //年龄
    final private int stature = 165;          //身高
    final private int weight = 90;           //体重
    final private String type = "活泼开朗";    //类型

    @Override
    public String toString() {
        return "JAVA: 主人，已为你成功new了一个对象，年仅"+age+"岁，好年轻哦！\n" +
                "     嗯...身高"+stature+"，体重"+weight+"，哇！这不是主人的理想女朋友身材吗？\n" +
                "     而且性格是"+type+"的哦，跟主人很搭呢！";
    }

    /**
     * 心形输出
     */
    public static void heart() {
        for (float y = (float) 1.5; y > -1.5; y -= 0.15) {
            for (float x = (float) -1.5; x < 1.5; x += 0.05) {
                float a = x * x + y * y - 1;
                if ((a * a * a - x * x * y * y * y) <= 0.0) {
                    System.out.print("*");
                } else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }
}
