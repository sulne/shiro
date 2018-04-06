package com.hxzycs.shiro.util;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.junit.Test;
import org.springframework.stereotype.Service;

import com.hxzycs.shiro.entity.User;



@Service("encryptPasswordUtil")
public class EncryptPasswordUtil {//md5加密工具类
    private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
    //这两个属性要与spring-shiro.xml的密码匹配器配置值一样
    private String algorithmName = "md5";
    private int hashIterations = 2;
    
    public void encryptPassword(User user) {
        user.setPasswordSalt(randomNumberGenerator.nextBytes().toHex());
        String newPassword = new SimpleHash(
                algorithmName,
                user.getPassword(),
                ByteSource.Util.bytes(user.getUserName()+user.getPasswordSalt()),
                hashIterations).toHex();
        user.setPassword(newPassword);
    }
    
    @Test
    public void test() {
    	User user = new User();
    	user.setUserName("admin");
    	user.setPassword("123");
    	this.encryptPassword(user);
    	System.out.println(user.getPassword());
    	System.out.println(user.getPasswordSalt());
    }
}
