package com.ywanhzy.demo.entity;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MenuEntity implements Serializable {
    private String id;
    private String title;
    private String ico;
    private String sort;
    private String num = "0";
    private boolean select = false;
    private List<MenuEntity> childs;

    public boolean isSelect() {
        return select;
    }

    public void setSelect(boolean select) {
        this.select = select;
    }

    public List<MenuEntity> getChilds() {
        return childs;
    }

    public void setChilds(List<MenuEntity> childs) {
        this.childs = childs;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIco() {
        return ico;
    }

    public void setIco(String ico) {
        this.ico = ico;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }


    public static ArrayList<MenuEntity> parseJson(String json) {

        ArrayList<MenuEntity> list = new ArrayList<>();

        try {
            JSONArray array = new JSONArray(json);

            JSONObject child;
            Gson gson = new Gson();
            for (int i = 0; i < array.length(); ++i) {

                child = array.getJSONObject(i);
                MenuEntity entity = gson.fromJson(child.toString(), MenuEntity.class);
                list.add(entity);
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }


}
