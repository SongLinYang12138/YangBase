package com.bondex.ysl.bondex.base.main;

/**
 * date: 2018/12/17
 * Author: ysl
 * description:
 */
public class MainMenuBean {

    private String name;
    private String flag;


    public MainMenuBean(String name, String flag) {
        this.name = name;
        this.flag = flag;
    }


    public String getName() {
        return name == null ? "" : name;
    }

    public void setName(String name) {
        this.name = name == null ? "" : name;
    }

    public String getFlag() {
        return flag == null ? "" : flag;
    }

    public void setFlag(String flag) {
        this.flag = flag == null ? "" : flag;
    }
}
