package com.zqr.firebase;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.*;
import com.sun.javafx.collections.MappingChange;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Kendric
 * @className FirebaseDemo
 * @description
 * @createTime 2022/7/22 10:02
 */

public class FirebaseDemo {

    public static boolean initFireBase() {
        FirebaseOptions options = null;
        try {
            FileInputStream serviceAccount =
                    new FileInputStream("src/main/resources/service-account-file.json");

            options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build();

            FirebaseApp.initializeApp(options);
            return true;
        } catch (IOException e) {
            System.out.println(e.toString());
            return false;
        }
    }

    public static void sendFireBaseMessage() {
        boolean initResult = initFireBase();
        if (initResult == false) {
            System.out.println("init Firebase error!");
            return;
        }
        sendMessageToDevice("fJm_AOITSESx7eRxuaul9i:APA91bEUV8ziGeqrgsgr17PpV9pnV_ITVKW9ooH8wQwHt33uKNzmxxKEsrBKlUoK4ZfD6yV5NHoq87unR8fgVcYumfajXggLwDDr6dC_qujYgAll1I2_tfwUnpLaUrOWBuHg05_zHTv3");

//        sendMessageToDevice(Arrays.asList(
//                "YOUR_REGISTRATION_TOKEN_1",
//                // ...
//                "YOUR_REGISTRATION_TOKEN_n"
//        ));

    }

    public static void sendMessageToDevice(String registrationToken) {
        // This registration token comes from the client FCM SDKs.

        // See documentation on defining a message payload.
        Message message = Message.builder()
                .putData("score", "850")
                .putData("time", "2:45")
                .setToken(registrationToken)
                .build();

        // Send a message to the device corresponding to the provided
        // registration token.
        String response = null;
        try {
            response = FirebaseMessaging.getInstance().send(message);
            System.out.println("Successfully sent message: " + response);
        } catch (FirebaseMessagingException e) {
            System.out.println(e);
            System.out.println("send message fail!");
        }
        // Response is a message ID string.
    }

    public static void sendMessageToDevice(List<String> registrationTokens) {

        MulticastMessage message = MulticastMessage.builder()
                .putData("score", "850")
                .putData("time", "2:45")
                .addAllTokens(registrationTokens)
                .build();
        BatchResponse response = null;
        try {
            response = FirebaseMessaging.getInstance().sendMulticast(message);
            // See the BatchResponse reference documentation
            // for the contents of response.
            System.out.println(response.getSuccessCount() + " messages were sent successfully");
        } catch (FirebaseMessagingException e) {
            System.out.println(e);
            System.out.println("send message fail!");
        }
    }


    public static void main(String[] args) {
        sendFireBaseMessage();
//        Map<String,String> map = new HashMap<>();
//        map.put("sss","sdfsf");
//        String aaa = map.get("aaa");
//        System.out.println(aaa);
    }
}
