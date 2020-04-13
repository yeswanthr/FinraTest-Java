package com.finra.test.controllers;

import com.finra.test.models.PageAttributes;
import com.finra.test.models.PageItems;
import com.finra.test.services.FinraServices;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import javax.servlet.http.HttpServletResponse;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;
import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(classes=FinraRestController.class)
public class FinraRestControllerTest {
    @Mock
    FinraServices finraServices;

    @InjectMocks
    FinraRestController finraRestController;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        PageItems pageItems = new PageItems();
        List<String> list = new ArrayList();
        list.add("123");
        list.add("456");
        pageItems.setData(list);

        PageAttributes pageAttributes = new PageAttributes();
        pageAttributes.setItemsPerPage(100);
        pageAttributes.setTotalNumberOfItems(1000);

        Mockito.when(finraServices.generateCombinations(Mockito.anyInt())).thenReturn(pageAttributes);
        Mockito.when(finraServices.getItems(Mockito.anyInt())).thenReturn(pageItems);
    }

    @Test
    public void testGenerateCombinations() {
        try {
            PageAttributes pageAttributes = finraRestController.generateCombinations(1234567);
            Assert.assertTrue(pageAttributes!=null);
        } catch (Exception ex) {
            Assert.assertFalse(true);
        }
    }

    @Test
    public void testGetCombinations() {
        try {
            PageItems pageItems = finraRestController.getCombinations(1);
            Assert.assertTrue(pageItems.getData().size() == 2);
        } catch (Exception ex) {
            Assert.assertFalse(true);
        }
    }

}
