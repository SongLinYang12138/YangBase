package com.ywanhzy.demo.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.orhanobut.logger.Logger;
import com.ywanhzy.demo.AppConfig;
import com.ywanhzy.demo.AppContext;
import com.ywanhzy.demo.R;
import com.ywanhzy.demo.SharedPreferenceUtils;
import com.ywanhzy.demo.adapter.MenuParentAdapter;
import com.ywanhzy.demo.adapter.MyAdapter;
import com.ywanhzy.demo.drag.DragCallback;
import com.ywanhzy.demo.drag.DragForScrollView;
import com.ywanhzy.demo.drag.DragGridView;
import com.ywanhzy.demo.entity.MenuEntity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MenuManageActivity extends Activity {
    private static DragGridView dragGridView;
    private static MyAdapter adapterSelect; //
    private TextView tv_set;
    private static ArrayList<MenuEntity> menuList = new ArrayList<MenuEntity>();
    private ExpandableListView expandableListView;
    private static MenuParentAdapter menuParentAdapter;
    private LinearLayout ll_top_back;
    private LinearLayout ll_top_sure;
    private TextView tv_top_title;
    private TextView tv_top_sure;
    private static Context appContext;
    private TextView tv_drag_tip;
    private DragForScrollView sv_index;
    private static List<MenuEntity> indexSelect = new ArrayList<MenuEntity>();
    private ArrayList<String> settingList = new ArrayList<>();
    private static SharedPreferenceUtils preferenceUtils;
    private final String fileName = "menulist";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_manage);
        appContext = getApplication();
        dragGridView = (DragGridView) findViewById(R.id.gridview);
        sv_index = (DragForScrollView) findViewById(R.id.sv_index);
        initView();
        initData();
        ll_top_sure.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tv_top_sure.getText().toString().equals("管理")) {
                    tv_top_sure.setText("完成");
                    adapterSelect.setEdit();
                    if (menuParentAdapter != null) {
                        menuParentAdapter.setEdit();
                    }
                    tv_drag_tip.setVisibility(View.VISIBLE);
                } else {
                    tv_top_sure.setText("管理");
                    tv_drag_tip.setVisibility(View.GONE);
                    adapterSelect.endEdit();
                    if (menuParentAdapter != null) {
                        menuParentAdapter.endEdit();
                    }
                    postMenu();
                }
            }
        });
    }

    protected void postMenu() {
        // TODO Auto-generated method stub
//        List<MenuEntity> indexDataList = (List<MenuEntity>) appContext.readObject(AppConfig.KEY_USER_TEMP);
//        String key = AppConfig.KEY_USER;
//        appContext.saveObject((Serializable) indexDataList, key);

        Gson gson = new Gson();
        String value = gson.toJson(indexSelect);
        preferenceUtils.saveStr(AppConfig.SELECT_MENU_KEY, value);

    }

    private void initView() {

        preferenceUtils = SharedPreferenceUtils.getInstance(this, AppConfig.SELECT_MENU_DB_NAME);

        // TODO Auto-generated method stub
        ll_top_back = (LinearLayout) findViewById(R.id.ll_top_back);
        ll_top_sure = (LinearLayout) findViewById(R.id.ll_top_sure);
        tv_top_title = (TextView) findViewById(R.id.tv_top_title);
        tv_top_sure = (TextView) findViewById(R.id.tv_top_sure);
        tv_top_title.setText("全部应用");
        tv_top_sure.setText("管理");
        tv_top_sure.setVisibility(View.VISIBLE);

        tv_drag_tip = (TextView) findViewById(R.id.tv_drag_tip);

        ll_top_back.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                finish();
            }
        });
        //获取设置保存到本地的菜单
        List<MenuEntity> indexDataList = getMenuList();


        if (indexDataList != null) {
            indexSelect.clear();
            indexSelect.addAll(indexDataList);
        }

        adapterSelect = new MyAdapter(this, indexSelect);
        dragGridView.setAdapter(adapterSelect);

        dragGridView.setDragCallback(new DragCallback() {
            @Override
            public void startDrag(int position) {
                Logger.i("start drag at ", "" + position);
                sv_index.startDrag(position);
            }

            @Override
            public void endDrag(int position) {
                Logger.i("end drag at ", "" + position);
                sv_index.endDrag(position);
            }
        });
        dragGridView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.e("setOnItemClickListener", adapterSelect.getEditStatue() + "");
                if (!adapterSelect.getEditStatue()) {
                    MenuEntity cateModel = indexSelect.get(position);
                    initUrl(cateModel);
                }
            }
        });
        dragGridView.setOnItemLongClickListener(new OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                if (tv_top_sure.getText().toString().equals("管理")) {
                    tv_top_sure.setText("完成");
                    adapterSelect.setEdit();
                    if (menuParentAdapter != null) {
                        menuParentAdapter.setEdit();
                    }
                    tv_drag_tip.setVisibility(View.VISIBLE);
                }
                dragGridView.startDrag(position);
                return false;
            }
        });

    }

    private ArrayList<MenuEntity> getMenuList() {

        String value = preferenceUtils.getStr(AppConfig.SELECT_MENU_KEY);

        if (TextUtils.isEmpty(value)) {

            value = getJson(this, fileName);
        }

        return MenuEntity.parseJson(value);


    }

    private void initData() {
        // TODO Auto-generated method stub
        List<MenuEntity> indexDataList = MenuEntity.parseJson(getJson(this,fileName));
        init(indexDataList);
    }

    private void init(List<MenuEntity> indexAll) {
        expandableListView = (ExpandableListView) findViewById(R.id.expandableListView);
        expandableListView.setGroupIndicator(null);
        menuList.clear();
        try {
            MenuEntity index = new MenuEntity();
            index.setTitle("基础功能");
            index.setId("1");
            List<MenuEntity> indexLC = new ArrayList<MenuEntity>();
            for (int i = 0; i < indexAll.size(); i++) {
                if (indexAll.get(i).getId().equals("8b2abd6b-18c2-4f8b-9990-b2d45f1aa91b")) {
                    indexLC.add(indexAll.get(i));
                }
                if (indexAll.get(i).getId().equals("afce4ddf-194a-492a-b4ce-db79fd14801f")) {
                    indexLC.add(indexAll.get(i));
                }


            }
            for (int i = 0; i < indexLC.size(); i++) {
                for (int j = 0; j < indexSelect.size(); j++) {
                    if (indexLC.get(i).getTitle().equals(indexSelect.get(j).getTitle())) {
                        indexLC.get(i).setSelect(true);
                    }
                }
            }
            index.setChilds(indexLC);
            menuList.add(index);

            MenuEntity index1 = new MenuEntity();
            index1.setTitle("业务功能");
            index1.setId("1");

            List<MenuEntity> indexJX = new ArrayList<MenuEntity>();
            for (int i = 0; i < indexAll.size(); i++) {
                if (indexAll.get(i).getId().equals("ac888f31-8392-4820-9254-49b11f71e2d3")) {
                    indexJX.add(indexAll.get(i));
                }
                if (indexAll.get(i).getId().equals("f5462bb1-7151-4d1c-8d8e-d3653dc53e9a")) {
                    indexJX.add(indexAll.get(i));
                }

            }
            for (int i = 0; i < indexJX.size(); i++) {
                for (int j = 0; j < indexSelect.size(); j++) {
                    if (indexJX.get(i).getTitle().equals(indexSelect.get(j).getTitle())) {
                        indexJX.get(i).setSelect(true);
                    }
                }
            }
            index1.setChilds(indexJX);
            menuList.add(index1);


            menuParentAdapter = new MenuParentAdapter(MenuManageActivity.this, menuList);
            expandableListView.setAdapter(menuParentAdapter);

            // expandableListView.expandGroup(6); // 在分组列表视图中 展开一组
            // expandableListView.isGroupExpanded(0); //判断此组是否展开
            for (int i = 0; i < menuParentAdapter.getGroupCount(); i++) {
                expandableListView.expandGroup(i);
            }
            expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
                @Override
                public boolean onGroupClick(ExpandableListView expandableListView, View view, int groupPosition, long l) {
                    MenuEntity cateModel = menuList.get(groupPosition);
                    return true;
                }
            });
            expandableListView.setOnItemClickListener(new OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                    // TODO Auto-generated method stub
                    if (tv_top_sure.getText().toString().equals("管理")) {
                        MenuEntity cateModel = menuList.get(arg2);
                        initUrl(cateModel);
                    }
                }
            });

            expandableListView.setOnItemLongClickListener(new OnItemLongClickListener() {
                @Override
                public boolean onItemLongClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                    // TODO Auto-generated method stub
                    if (tv_top_sure.getText().toString().equals("管理")) {
                        tv_top_sure.setText("完成");
                        adapterSelect.setEdit();
                        menuParentAdapter.setEdit();
                    }
                    return false;
                }
            });

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void initUrl(MenuEntity cateModel) {
        // TODO Auto-generated method stub
        if (tv_top_sure.getText().toString().equals("管理")) {
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            String title = cateModel.getTitle();
            String strId = cateModel.getId();
            Toast.makeText(MenuManageActivity.this, title, Toast.LENGTH_SHORT).show();
        }
    }

    public void DelMeun(MenuEntity indexData, int position) {
        // TODO Auto-generated method stub
        for (int i = 0; i < menuList.size(); i++) {
            for (int k = 0; k < menuList.get(i).getChilds().size(); k++) {
                if (menuList.get(i).getChilds().get(k).getTitle().equals(indexData.getTitle())) {
                    menuList.get(i).getChilds().get(k).setSelect(false);
                }
            }
        }
        if (menuParentAdapter != null) {
            menuParentAdapter.notifyDataSetChanged();
        }
        adapterSelect.notifyDataSetChanged();
    }

    public static void AddMenu(MenuEntity menuEntity) {
        // TODO Auto-generated method stub
        indexSelect.add(menuEntity);
        String key = AppConfig.KEY_USER_TEMP;
//        appContext.saveObject((Serializable) indexSelect, key);

        Gson gson = new Gson();
        String json = gson.toJson(indexSelect);

        preferenceUtils.saveStr(AppConfig.SELECT_MENU_KEY, json);
        for (int i = 0; i < menuList.size(); i++) {
            for (int k = 0; k < menuList.get(i).getChilds().size(); k++) {
                if (menuList.get(i).getChilds().get(k).getTitle().equals(menuEntity.getTitle())) {
                    menuList.get(i).getChilds().get(k).setSelect(true);
                }
            }
        }
        menuParentAdapter.notifyDataSetChanged();
        adapterSelect.notifyDataSetChanged();
    }

    public String getJson(Context context, String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            AssetManager assetManager = context.getAssets();
            BufferedReader bf = new BufferedReader(new InputStreamReader(
                    assetManager.open(fileName)));
            String line;
            while ((line = bf.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
            Logger.e(e.toString());
        }
        return stringBuilder.toString();
    }

}
