package com.finra.test.services;

import com.finra.test.controllers.FinraRestController;
import com.finra.test.models.PageAttributes;
import com.finra.test.models.PageItems;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= FinraServices.class)
public class FinraServiceTest {
    @Autowired
    FinraServices finraServices;

    @Test
    public void testGenerateCombinations() {
        try {
            PageAttributes pageAttributes = finraServices.generateCombinations(123);
            Assert.assertTrue(pageAttributes!=null);
        } catch (Exception ex) {
            Assert.assertFalse(true);
        }
    }

    @Test
    public void testGetCombinations() {
        try {
            PageItems pageItems = finraServices.getItems(1);
            Assert.assertTrue(pageItems.getData().size() > 0);
        } catch (Exception ex) {
            ex.printStackTrace();
            Assert.assertFalse(true);
        }
    }

}
