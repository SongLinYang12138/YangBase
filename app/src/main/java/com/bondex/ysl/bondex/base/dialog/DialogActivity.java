package com.bondex.ysl.bondex.base.dialog;

import android.support.annotation.NonNull;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.bondex.ysl.bondex.base.R;
import com.bondex.ysl.bondex.base.BR;
import com.bondex.ysl.bondex.base.databinding.ActivityDialogBinding;
import me.goldze.mvvmhabit.base.BaseActivity;

public class DialogActivity extends BaseActivity<ActivityDialogBinding, DialogViewModle> {

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_dialog;
    }

    @Override
    public int initVariableId() {
        return BR.dialogModle;
    }

    @Override
    public void initViewObservable() {
        super.initViewObservable();

        showLeft(true,this);
        showTitle(true,"Dialog");

        binding.dialogAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new MaterialDialog.Builder(DialogActivity.this)// 初始化建造者
                        .title("标题")// 标题
                        .content("内容")// 内容
                        .positiveText("确定")
                        .negativeText("取消")
                        .show();
            }
        });

        binding.dialogCheckbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCheck();
            }
        });

    }


    private void showCheck() {

        new MaterialDialog.Builder(this).iconRes(R.drawable.ic_launcher)// 标题左侧的图标
                .limitIconToDefaultSize()// 标题左侧图标的最大值
                .title("title6")// 标题
                .positiveText("Allow")
                .negativeText("Deny")
                .onAny(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        Toast.makeText(DialogActivity.this, "Prompt checked ? " + dialog.isPromptCheckBoxChecked(),
                                Toast.LENGTH_SHORT).show();
                    }
                })
                .checkBoxPromptRes(R.string.app_name, false, null)
                .show();// 显示对话框
    }

    public void showList(View view) {


        String[] items = {"A", "BB", "CCC", "DDDD", "EEEEE"};
        new MaterialDialog.Builder(this)
                .title("title7")// 标题
                .items(items)// 列表数据
                // itemsCallbackSingleChoice 方法中的第一个参数代表预选项的索引值，没有预选项这个值就设置为 -1，有预选项就传入一个预选项的索引值即可。
                // 如果不使用自定义适配器，则可以使用 MaterialDialog 实例上的 setSelectedIndex(int) 更新选定的索引值。
                .itemsCallbackSingleChoice(1, new MaterialDialog.ListCallbackSingleChoice() {
                    @Override
                    public boolean onSelection(MaterialDialog dialog, View itemView, int which, CharSequence text) {
                        // 如果使用 alwaysCallSingleChoiceCallback() 方法，在这边返回 false 将不允许新选择的单选按钮被选中。
                        return true;
                    }
                })
                // 如果没有使用 positiveText() 设置正面操作按钮，则当用户按下正面操作按钮时，
                // 对话框将自动调用单一选择回调方法，该对话框也将自行关闭，除非关闭自动关闭。
                .positiveText("Choose")
                // 如果调用 alwaysCallSingleChoiceCallback() 该方法，则每次用户选择/取消项目时都会调用单选回调方法。
                .alwaysCallSingleChoiceCallback()
                .show();// 显示对话框

    }

    public void custom(View view) {

        new MaterialDialog.Builder(this).iconRes(R.drawable.ic_launcher)// 标题左侧的图标
                .limitIconToDefaultSize()// 标题左侧图标的最大值
                .customView(R.layout.tab_item, true)
                .onNegative(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {

                    }
                })
                .show();// 显示对话框
    }


}
