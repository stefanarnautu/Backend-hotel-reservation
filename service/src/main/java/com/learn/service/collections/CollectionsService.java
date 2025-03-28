package com.learn.service.collections;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CollectionsService {
    private List<Integer> theList;
    public void addElementsToList(int... numbers){
        this.theList = new ArrayList<>();
        for(int nr:numbers){
            this.theList.add(nr);
        }
        System.out.println(this.theList);
    }

}
