package second;

import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

public class SendMail {
		public static void main(String[] args) throws Exception {
			String account = "yc94112@163.com";
			String password = "yc941102";
			MimeMessage m = createEmail(account,password);
			Session session = m.getSession();
			Properties config = session.getProperties();
			config.put("mail.transport.protocol", "smtp");
			config.put("mail.smtp.host", "smtp.163.com");
			config.put("mail.smtp.port", "25");
			config.put("mail.smtp.auth","true");
			//config.put("mail.smtp.ssl.enable","false");
			
			Transport.send(m);
		}
	
	
	
	public static MimeMessage createEmail(final String account,final String password) throws Exception{
		Properties config = new Properties();
		Session session = Session.getInstance(config,new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication(account,password);
			}
		});
		//1 �����������
		MimeMessage m = new MimeMessage(session);
		//2 ���÷�����
		Address from = new InternetAddress("yc94112@163.com","���ү","utf-8");
		m.setFrom(from);
		//3�����ռ���(to�Ƿ��ͣ�cc�ǳ��ͣ�bcc������)
		m.setRecipient(RecipientType.TO,new InternetAddress("1397129912@qq.com"));
		//4�ʼ�������
		m.setSubject("�����ʼ�-���ү", "utf-8");
		//5�ʼ�������
		m.setContent("�������˧!","text/plain;charset=utf-8");
		//6 ����ʱ��
		m.setSentDate(new Date());
		//7ȷ���������
		m.saveChanges();
		
		return m;
	}

}
