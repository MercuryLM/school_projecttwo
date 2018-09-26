package com.wjmShop.utils;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.util.MailSSLSocketFactory;

/**
 * 邮件发送工具类
 * @author 
 *
 */
public class MailUitls {
	/**
	 * 发送邮件的方法
	 * @param to	:收件人
	 * @param code	:激活码
	 */
	public static void sendMail(String to,String code){

		try{
			// 1.获得连接对象
			Properties props = new Properties();
			 // 开启debug调试
	        props.setProperty("mail.debug", "true");
	        // 发送服务器需要身份验证
	        props.setProperty("mail.smtp.auth", "true");
	        // 设置邮件服务器主机名
	        props.setProperty("mail.host", "smtp.qq.com");
	        // 发送邮件协议名称
	        props.setProperty("mail.transport.protocol", "smtp");
	        
	        // QQ邮箱需要ssl加密，163、新浪邮箱不需要 SSL 加密
	        MailSSLSocketFactory sf = new MailSSLSocketFactory();
	        sf.setTrustAllHosts(true);
	        props.put("mail.smtp.ssl.enable", "true");
	        props.put("mail.smtp.ssl.socketFactory", sf);

	        Session session = Session.getInstance(props);
	        Message msg = new MimeMessage(session);
	        msg.setSubject("来自购物天堂HOEC官方激活邮件");
	        StringBuilder builder = new StringBuilder();
	        builder.append("购物天堂HOEC官方激活邮件!点下面链接完成激活操作! http://localhost:8080/ssm/user_active.action?code="+code);
	        msg.setText(builder.toString());
	        //邮件发送者
	        msg.setFrom(new InternetAddress("2317396364@qq.com")); //发送人的邮箱地址
	        //发送邮件
	        Transport transport = session.getTransport();
	        transport.connect("smtp.qq.com", "2317396364@qq.com", "hgzgecjgjvpfdjgd");//SMTP服务器（端口465或587），发送人的邮箱地址，你的邮箱密码或者授权码
	        transport.sendMessage(msg, new Address[] { new InternetAddress(to) });
	        transport.close();
	        
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			
        }
    }
}
