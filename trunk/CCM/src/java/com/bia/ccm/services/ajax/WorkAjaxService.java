/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bia.ccm.services.ajax;

import com.bia.ccm.entity.Customer;
import com.bia.ccm.entity.Systems;
import com.bia.ccm.entity.UsageDetail;
import com.bia.ccm.services.WorkService;
import com.bia.ccm.util.AcegiUtil;
import com.bia.ccm.util.ServiceFactory;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author intesar
 */
public class WorkAjaxService {

    public List<Systems> getActiveSystems() {
        String username = AcegiUtil.getUsername();
        return workService.getActiveSystems(username);
    }

    public Systems getSystemByNameAndOrganization(int systemNo) {
        String username = AcegiUtil.getUsername();
        return this.workService.getSystemByNameAndOrganization(systemNo, username);
    }

    public String leaseSystem(int systemId, String leaseHolder) {
        try {
            return this.workService.leaseSystem(systemId, leaseHolder);
        } catch (Exception e) {
            e.printStackTrace();
            logger.equals(e);
            return e.getMessage();
        }

    }

    public UsageDetail getPayableAmount(int id) {
        return this.workService.getPayableAmount(id);
    }

    public String unleaseSystem(int systemId, double paidAmount) {
        try {
            return this.workService.unleaseSystem(systemId, paidAmount);
        } catch (Exception e) {
            e.printStackTrace();
            logger.equals(e);
            return e.getMessage();
        }
    }
    
   

    public String createCustomer(Customer c) {

        String msg = "Customer Created Successfully!";
        try {
            if (c.getImg() != null) {
                c.setPic(this.bufferedImageToByteArray(c.getImg()));//this.scaleToSize(c.getImg())
            }
            c.setCreateDate(new Date());
            c.setCreateUser(AcegiUtil.getUsername());
            this.workService.createCutomer(c);
        } catch (RuntimeException re) {
            re.printStackTrace();
            msg = re.getMessage();
        } catch (Exception e) {
            e.printStackTrace();
            msg = e.getMessage();
        }
        return msg;
    }

    public Customer getCustomer(String key) {
        Customer c = this.workService.getCustomer(key);
        c.setImage(this.byteArrayToBufferedImage(c.getPic()));
        c.setImg(null);
        
        return c;
    }

    /**
     * Voodoo to scale the image to 200x200
     * @param uploadImage The image to work on
     * @return The altered image
     */
    private BufferedImage scaleToSize(BufferedImage uploadImage) {
        AffineTransform atx = new AffineTransform();
        atx.scale(400d / uploadImage.getWidth(), 400d / uploadImage.getHeight());
        AffineTransformOp afop = new AffineTransformOp(atx, AffineTransformOp.TYPE_BILINEAR);
        uploadImage = afop.filter(uploadImage, null);
        return uploadImage;
    }

    /**
     * And scrawl the text on the image in 10 rows of 20 chars
     * @param uploadImage The image to work on
     * @param uploadFile The text to write on the image
     * @param color The selected color
     * @return The altered image
     */
    private BufferedImage grafitiTextOnImage(BufferedImage uploadImage) {

        Graphics2D g2d = uploadImage.createGraphics();
        for (int row = 0; row < 10; row++) {
            String output = null;


            g2d.setFont(new Font("SansSerif", Font.BOLD, 16));

            g2d.drawString(output, 5, (row + 1) * 20);
        }

        return uploadImage;
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

    private BufferedImage byteArrayToBufferedImage(byte[] bytes) {
        try {
            BufferedImage image = ImageIO.read(new ByteArrayInputStream(bytes));
            return image;
        } catch (IOException ex) {
            ex.printStackTrace();
            Logger.getLogger(WorkAjaxService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    protected final Log logger = LogFactory.getLog(getClass());
    private WorkService workService = (WorkService) ServiceFactory.getService("workServiceImpl");

    public static void main(String[] args) {
        WorkAjaxService was = new WorkAjaxService();
        Customer c = new Customer(null, "Intesar shannan Mohammed", "intesar.mohammed@bizintelapps.com",
                "9-4-62/23 nizam colony, towli chowki", "hyderabad", "500008", "ap", "india", new Date(), "male");
        // System.out.println ( was.createCustomer());
//        System.out.println(was.getCustomer("intesar.mohammed@bizintelapps.com").getName());
        System.out.println ( was.getPayableAmount(277));
    }
}
