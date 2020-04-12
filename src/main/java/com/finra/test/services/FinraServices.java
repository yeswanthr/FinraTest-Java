package com.finra.test.services;

import com.finra.test.configuration.ApplicationConfiguration;
import com.finra.test.models.PageAttributes;
import com.finra.test.models.PageItems;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//@Component
@Service
public class FinraServices {
    private List<String> combinations = new ArrayList<>();

    @Value(value = "${com.finra.itemsPerPage}")
    private Integer itemsPerPage;

    public void resetCombinations() {
        combinations.clear();
        combinations.add("");
    }

    public PageAttributes generateCombinations(Integer phoneNumber) {
        this.resetCombinations();
        List<String> tempStore = new ArrayList<>();
        // This loop will be iterated as many times as length of the phone
        // number
        String input = phoneNumber.toString();
        for (int i = 0; i < input.length(); i++) {
            // get the keys associated with the number
            String charsAssociatedWithNumber = ApplicationConfiguration.keys.get(input.charAt(i));
            // when this loops completes for the first time, it will generate
            // the alpha numeric representing of 1st char of phone number, 2nd
            // time, it will generate the combination of first 2 chars of phone
            // number
            for (int k = 0; k < combinations.size(); k++) {
                for (int j = 0; j < charsAssociatedWithNumber.length(); j++) {
                    tempStore.add(combinations.get(k) + charsAssociatedWithNumber.charAt(j));
                }
            }
            // we need to remove any previously added combinations as we don't
            // need them any more
            combinations.clear();
            // add the recently generated combinations to the array
            combinations.addAll(tempStore);
            // clear the temp storage so that it wil be ready to store the next
            // combinations
            tempStore.clear();
        }

        PageAttributes pageAttributes = new PageAttributes();
        pageAttributes.setItemsPerPage(itemsPerPage);
        pageAttributes.setTotalNumberOfItems(combinations.size());
        return pageAttributes;
    }

    public PageItems getItems(Integer pageNumber) {
        pageNumber = pageNumber <= 0 ? 1: pageNumber;
        Integer totalPages = combinations.size()/itemsPerPage;
        totalPages = totalPages == 0 ? 1 : totalPages;
        if(pageNumber > totalPages)
            pageNumber = totalPages;
        Integer start = (pageNumber-1)*itemsPerPage;
        Integer end = itemsPerPage*(pageNumber);
        end = end >= combinations.size() ? combinations.size()-1:end;
        PageItems pageItems = new PageItems();
        pageItems.setData(combinations.subList(start, end));
        return pageItems;
    }
}
