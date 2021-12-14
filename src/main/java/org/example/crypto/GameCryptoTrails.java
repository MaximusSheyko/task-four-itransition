package org.example.crypto;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.HmacUtils;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class GameCryptoTrails {
    public static String hmac(String algorithm,String data,String key) {
        return new HmacUtils(algorithm, key).hmacHex(data);
    }

    public static String securityKey() throws NoSuchAlgorithmException {
        long randomLong = SecureRandom.getInstanceStrong().nextLong();
        return DigestUtils.sha256Hex(String.valueOf(randomLong));
    }
}
