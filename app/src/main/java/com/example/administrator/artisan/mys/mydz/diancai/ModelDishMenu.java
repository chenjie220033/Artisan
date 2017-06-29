package com.example.administrator.artisan.mys.mydz.diancai;

import java.util.ArrayList;

/**
 * chen 2017-06-02
 * 外卖点餐 相关类
 */
public class ModelDishMenu {
    private String menuName;
    private ArrayList<ModelDish> mModelDishList;

    public ModelDishMenu(){

    }

    public ModelDishMenu(String menuName, ArrayList dishList){
        this.menuName = menuName;
        this.mModelDishList = dishList;
    }

    public ArrayList<ModelDish> getModelDishList() {
        return mModelDishList;
    }

    public void setModelDishList(ArrayList<ModelDish> modelDishList) {
        this.mModelDishList = modelDishList;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

}
