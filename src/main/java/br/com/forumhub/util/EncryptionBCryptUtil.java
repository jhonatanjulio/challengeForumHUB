package br.com.forumhub.util;

import org.mindrot.jbcrypt.BCrypt;

public class EncryptionBCryptUtil {
    public static String encrypt(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }
}
