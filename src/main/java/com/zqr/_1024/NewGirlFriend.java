package com.zqr._1024;

/**
 * @author Kendric
 * @className NewGirlFriend
 * @description 当我用JAVA new一个对象后，想再new一个，结果...
 * @createTime 2021/10/24 13:14
 */
public class NewGirlFriend {
    public static void main(String[] args) {
        GirlFriend girlFriend = GirlFriend.getGirlFriend();
        girlFriend.doSomething();
        try {
            GirlFriend girlFriend02 = GirlFriend.getGirlFriend();
            girlFriend02.doSomething();
        }catch (Exception e){}
        girlFriend.goShopping();
        girlFriend.seeMovies();
    }
}


