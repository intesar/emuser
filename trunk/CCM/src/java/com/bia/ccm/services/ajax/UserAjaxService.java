/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bia.ccm.services.ajax;

import com.bia.ccm.entity.Users;
import com.bia.ccm.services.EMailService;
import com.bia.ccm.services.UserService;
import com.bia.ccm.services.WorkService;
import com.bia.ccm.services.impl.EMailServiceImpl;
import com.bia.ccm.util.AcegiUtil;
import com.bia.ccm.util.ServiceFactory;
import com.bia.converter.Converter;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author intesar
 */
public class UserAjaxService {

    public String getLoggedInUserRole() {
        String username = AcegiUtil.getUsername();
        return this.userService.getUserRole(username);
    }

    public String forgotPassword(String email) {
        String msg = " Please check your email for your password! ";
        try {
            this.userService.forgotPassword(email.toLowerCase());
        } catch (RuntimeException re) {
            logger.error(re);
            msg = re.getMessage();
        }
        return msg;

    }

    public boolean isUserAdmin() {
        return AcegiUtil.isAdmin();
    }

    public String getUserRole() {
        return AcegiUtil.getUserRole();
    }

    public String registerNewOrganization(String organizationName, String city,
            String email, String password, Integer minutes, Integer rate, Integer maxSystems) {
        if ( organizationName != null ) {
            organizationName = organizationName.toLowerCase();
        }
        if ( city != null ) {
            city = city.toLowerCase();
        }
        if ( email != null ) {
            email = email.toLowerCase();
        }
       
        logger.debug("error");
        String str = "Please login with your email and password";
        try {
            this.userService.registerNewOrganization(organizationName,
                    city, email, password, minutes, rate, maxSystems);
            eMailService.sendEmail(email, "Welcome to FaceGuard, username / password : " + email + " / " + password);

            return str;
        } catch (Exception e) {
            logger.debug("error");
            return "Error creating new organization, try registering with different Email or Organization Name";
        }

    }

    public String createCustomer(Users c) {

        String msg = "Customer Created Successfully!";
        try {
            if (c.getImg() != null) {
                c.setPic(this.bufferedImageToByteArray(c.getImg()));//this.scaleToSize(c.getImg())
            }
            c.setCreateDate(new Date());
            //Users u = this.workService.getCustomer(AcegiUtil.getUsername());
            //c.setCreateUser(AcegiUtil.getUsername());
            Converter.toLowerCase(c);
            this.workService.createCutomer(c, null);
            eMailService.sendEmail(c.getEmail(), "Welcome to FaceGuard, username / password : " + c.getUsername() + " / " + c.getPassword());
        } catch (RuntimeException re) {
            logger.equals(re);
            //re.printStackTrace();
            msg = re.getMessage();
        } catch (Exception e) {
            //e.printStackTrace();
            logger.equals(e);
            msg = e.getMessage();
        }
        return msg;
    }

    private byte[] bufferedImageToByteArray(BufferedImage aBufferedImage) {
        try {
            // O P E N
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            // W R I T E
            ImageIO.write(aBufferedImage, "jpg", baos);

            // C L O S E
            baos.flush();
            byte[] resultImageAsRawBytes = baos.toByteArray();
            baos.close();
            return resultImageAsRawBytes;


        } catch (IOException ex) {
            ex.printStackTrace();
            Logger.getLogger(WorkAjaxService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    protected final Log logger = LogFactory.getLog(getClass());
    protected UserService userService = (UserService) ServiceFactory.getService("userServiceImpl");
    private WorkService workService = (WorkService) ServiceFactory.getService("workServiceImpl");
    private EMailService eMailService = new EMailServiceImpl();

    public static void main(String[] args) {
        UserAjaxService uas = new UserAjaxService();
        //System.out.println(uas.registerNewOrganization("apolokk", "hyd", "apollkkk", "apollo13", 15, 50));
        System.out.println(" _________________________________ ");
        System.out.println(uas.userService.getUser(1));
        System.out.println(" _________________________________ ");

    }
}
