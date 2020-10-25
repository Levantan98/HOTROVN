package com.example.hotrovn.PresenterProcess;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.example.hotrovn.Activity.PhoneActivity;
import com.example.hotrovn.Activity.MainActivity;

public class Presenter {
    Context context;
    InterfacePre interfacePre;

    public Presenter(Context context, InterfacePre interfacePre) {
        this.context = context;
        this.interfacePre = interfacePre;
    }

    // OptionsMain
    public void optionUser(Activity activity, Integer integer) {
        switch (integer) {
            case 0:
                activity.startActivity(new Intent(activity, PhoneActivity.class)
                        .putExtra("1", 0));
                break;
            case 1:
                activity.startActivity(new Intent(activity, PhoneActivity.class)
                        .putExtra("1", 1));
                break;
            default:

        }
    }

    // get Data in Main
    public void getData(Activity activity) {
        Intent intent = activity.getIntent();
        Integer integer = intent.getIntExtra("1", 3);
        Toast.makeText(activity, "" + integer, Toast.LENGTH_SHORT).show();
        interfacePre.Result(integer);
    }

    // Option tiep theo
    public static void onClickNext(final View view, final Integer integer) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (integer) {
                    // case 0 :getFragment();
                }
            }
        });
    }


}
