/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.sigamas.mailing;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.ejb.Stateless;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;
import uy.edu.ort.sigamas.mailing.exceptions.MailErrorException;

/**
 *
 * @author Mattahari
 */
@Stateless
public class MailingBean implements MailingBeanLocal {

    /**
     * Envia un email
     *
     * @param destino
     * @param asunto
     * @param texto
     * @throws MailErrorException
     */
    @Override
    public void enviarMail(final String emisor, final String pass, String destino, String asunto, String texto) throws MailErrorException {
        Properties props = new Properties();

        props.put(
                "mail.smtp.auth", "true");
        props.put(
                "mail.smtp.host", "mail.sigamas.com");
        props.put(
                "mail.smtp.port", "2525");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(emisor, pass);
                    }
                });
        session.setDebug(true);

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(emisor));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(destino));
            message.setSubject(asunto);
            message.setText(texto);

            Transport.send(message);

        } catch (MessagingException e) {
            throw new MailErrorException(e.toString());
        }
    }

    /**
     * Envia un email con contenido HTML
     *
     * @param destino
     * @param asunto
     * @param texto
     * @throws MailErrorException
     */
    @Override
    public void enviarMailHTML(final String emisor, final String pass, String destino, String asunto, String texto) throws MailErrorException {
        Properties props = new Properties();

        props.put(
                "mail.smtp.auth", "true");
        props.put(
                "mail.smtp.host", "mail.sigamas.com");
        props.put(
                "mail.smtp.port", "2525");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(emisor, pass);
                    }
                });
        session.setDebug(true);

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(emisor));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(destino));
            message.setSubject(asunto);

            MimeMultipart multipart = new MimeMultipart("related");

            // first part  (the html)
            BodyPart messageBodyPart = new MimeBodyPart();
            
            messageBodyPart.setContent(texto, "text/html");

            // add it
            multipart.addBodyPart(messageBodyPart);

            message.setContent(multipart);

            Transport.send(message);

        } catch (MessagingException e) {
            throw new MailErrorException(e.toString());
        }
    }

    /**
     * Envia un email con un archivo adjunto
     *
     *
     * @param destino
     * @param asunto
     * @param texto
     * @param adjunto
     * @throws MailErrorException
     */
    @Override
    public void enviarMailConAdjunto(final String emisor, final String pass, String destino, String asunto, String texto, ByteArrayInputStream adjunto) throws MailErrorException {
        Properties props = new Properties();

        props.put(
                "mail.smtp.auth", "true");
        props.put(
                "mail.smtp.host", "mocha3000.mochahost.com");
        props.put(
                "mail.smtp.port", "465");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(emisor, pass);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(emisor));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(destino));
            message.setSubject(asunto);
            message.setText(texto);
            if (adjunto != null && adjunto instanceof ByteArrayInputStream) {
                // create the second message part with the attachment from a OutputStrean
                MimeBodyPart archivoAdjunto = new MimeBodyPart();
                ByteArrayDataSource ds = new ByteArrayDataSource(adjunto, "application/pdf");
                archivoAdjunto.setDataHandler(new DataHandler(ds));
                archivoAdjunto.setFileName("confirmacion.pdf");
                Multipart multipart = new MimeMultipart();
                multipart.addBodyPart(archivoAdjunto);
                message.setContent(multipart);
            }

            Transport.send(message);

        } catch (MessagingException e) {
            throw new MailErrorException(e.toString());
        } catch (IOException ex) {
            throw new MailErrorException(ex.toString());
        }

    }

}
