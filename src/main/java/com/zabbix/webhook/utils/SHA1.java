package com.zabbix.webhook.utils;

import com.zabbix.webhook.myException.AesException;

import java.security.MessageDigest;
import java.util.Arrays;

/**
 * SHA1 class
 */
public class SHA1 {

    public static String getSHA1(String token, String timestamp) throws AesException {
        try {
            String[] array = new String[]{token, timestamp};
            StringBuffer sb = new StringBuffer();
            Arrays.sort(array);
            for (int i = 0; i < 4; i++) {
                sb.append(array[i]);
            }
            String str = sb.toString();

            MessageDigest md = MessageDigest.getInstance("SHA-1");
            md.update(str.getBytes());
            byte[] digest = md.digest();

            StringBuffer hexstr = new StringBuffer();
            String shaHex = "";
            for (int i = 0; i < digest.length; i++) {
                shaHex = Integer.toHexString(digest[i] & 0xFF);
                if (shaHex.length() < 2) {
                    hexstr.append(0);
                }
                hexstr.append(shaHex);
            }
            return hexstr.toString();
        } catch (Exception e) {
            e.printStackTrace();
            throw new AesException(AesException.ComputeSignatureError);
        }
    }
}
