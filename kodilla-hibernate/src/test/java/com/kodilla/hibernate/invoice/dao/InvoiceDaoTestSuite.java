package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceDaoTestSuite {

    @Autowired
    private InvoiceDao invoiceDao;
    @Autowired
    private ItemDao itemDao;
    @Autowired
    private ProductDao productDao;

    @Test
    public void testInvoiceDaoSave(){
        //Given
        Product product1 = new Product("Product1");
        Product product2 = new Product("Product2");

        Item item1 = new Item(new BigDecimal(9.99), 5);
        Item item2 = new Item(new BigDecimal(399.00), 1);

        Invoice invoice = new Invoice("001");

        item1.setProduct(product1);
        item2.setProduct(product2);

        item1.setInvoice(invoice);
        item2.setInvoice(invoice);

        invoice.getItems().add(item1);
        invoice.getItems().add(item2);

        productDao.save(product1);
        productDao.save(product2);
        invoiceDao.save(invoice);

        //When

        int invoiceIds = invoice.getId();
        Optional<Invoice> optionalInvoice = invoiceDao.findById(invoiceIds);
        List<Item> items = invoice.getItems();


        //Then
        Assert.assertNotEquals(0, invoiceIds);
        Assert.assertTrue(optionalInvoice.isPresent());
        Assert.assertEquals(2, items.size());

        //CleanUp
        try {
            invoiceDao.deleteById(invoiceIds);
            productDao.deleteById(product1.getId());
            productDao.deleteById(product2.getId());
            itemDao.deleteById(item1.getId());
            itemDao.deleteById(item2.getId());
        } catch (Exception e) {
            //do nothing
        }
    }
}
