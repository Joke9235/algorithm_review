package com.zqr.test;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Kendric
 * @className SmsTemplateEnum
 * @description
 * @createTime 2023/3/4 14:41
 */

public enum SmsTemplateEnum {

    // 卡系统相关短信模板
    CARD_ACTIVATION_EN("cardActivation" + "LANG_EN", "UPIENCAC", "cardActivation"),
    CARD_ACTIVATION_KH("cardActivation" + "LANG_KH", "UPIKHCAC", "cardActivation"),
    CARD_ACTIVATION_CN("cardActivation" + "LANG_CN", "UPICNCAC", "cardActivation"),
    RESET_CARD_PIN_EN("resetCardPin" + "LANG_EN", "UPIENRCP", "resetCardPin"),
    RESET_CARD_PIN_KH("resetCardPin" + "LANG_KH", "UPIKHRCP", "resetCardPin"),
    RESET_CARD_PIN_CN("resetCardPin" + "LANG_CN", "UPICNRCP", "resetCardPin"),
    CARD_ACTIVATION_SUCCESSFULLY_EN("cardActivationSuccessfully" + "LANG_EN", "UPIENCAS", "cardActivationSuccessfully"),
    CARD_ACTIVATION_SUCCESSFULLY_KH("cardActivationSuccessfully" + "LANG_KH", "UPIKHCAS", "cardActivationSuccessfully"),
    CARD_ACTIVATION_SUCCESSFULLY_CN("cardActivationSuccessfully" + "LANG_CN", "UPICNCAS", "cardActivationSuccessfully"),
    RESET_CARD_PIN_SUCCESSFULLY_EN("resetCardPinSuccessfully" + "LANG_EN", "UPIENRPS", "resetCardPinSuccessfully"),
    RESET_CARD_PIN_SUCCESSFULLY_KH("resetCardPinSuccessfully" + "LANG_KH", "UPIKHRPS", "resetCardPinSuccessfully"),
    RESET_CARD_PIN_SUCCESSFULLY_CN("resetCardPinSuccessfully" + "LANG_CN", "UPICNRPS", "resetCardPinSuccessfully"),


    // 企业网银相关模板
    RESET_RANDOM_PASSWORD_EN("resetRandomPassword" + "LANG_EN", "CICMB102", "resetRandomPassword");


    SmsTemplateEnum(String key, String templateName, String smsType) {
        this.key = key;
        this.templateName = templateName;
        this.smsType = smsType;
    }

    public static List<String> smsTypeList() {
        List<String> result = new ArrayList<>();
        for (SmsTemplateEnum smsTemplateEnum : SmsTemplateEnum.values()) {
            if (!result.contains(smsTemplateEnum.getSmsType())) {
                result.add(smsTemplateEnum.getSmsType());
            }
        }
        return result.stream().distinct().collect(Collectors.toList());
    }

    public static SmsTemplateEnum getByKey(String key) {
        if (key.isEmpty()) {
            return null;
        }
        for (SmsTemplateEnum smsTemplateEnum : SmsTemplateEnum.values()) {
            if (key.equals(smsTemplateEnum.getKey())) {
                return smsTemplateEnum;
            }
        }
        return null;
    }

    String smsType;

    String key;

    String templateName;

    public String getSmsType() {
        return smsType;
    }

    public String getKey() {
        return key;
    }

    public String getTemplateName() {
        return templateName;
    }
}
