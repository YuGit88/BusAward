package com.zz80z.busAward.common.model;

import java.util.List;

public class EchartsEntity {

    public String name;
    public String type;
    public List<?> data;
    
    public EchartsEntity() {
        
    }

    public EchartsEntity(String name, String type, List<?> data) {
        super();
        this.name = name;
        this.type = type;
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }
    
}
