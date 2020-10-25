package com.example.hotrovn.Utilities;

import android.Manifest;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.provider.Settings;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.example.hotrovn.R;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.DexterError;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.PermissionRequestErrorListener;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;

import java.util.List;

public class Utilities {
    private static void CheckPerm(final Activity getActivity) {
        Dexter.withActivity(getActivity).withPermissions(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_NETWORK_STATE,
                Manifest.permission.CAMERA
        ).withListener(new MultiplePermissionsListener() {
            @Override
            public void onPermissionsChecked(MultiplePermissionsReport report) {
                // ktra neu quyen duoc chap thuan
                if (report.areAllPermissionsGranted()) {
                    OpenCamera(getActivity);
                }
                // ktra 1 vai quyen bi huy

                if (report.isAnyPermissionPermanentlyDenied()) {
                    // dua ra diag co muon vao cai dat set quyen khong
                    showDialogPerm(getActivity);
                }
            }

            @Override
            public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                token.continuePermissionRequest();
            }
        }).withErrorListener(new PermissionRequestErrorListener() {
            @Override
            public void onError(DexterError error) {

            }
        }).onSameThread()
                .check();
    }

    private static void showDialogPerm(final Activity activity) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity)
                .setTitle(R.string.str_tieudequyen)
                .setMessage(R.string.str_tbaoquyen);
        builder.setNegativeButton(R.string.str_gtoset, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                Opensettings(activity);
            }
        });
        builder.setPositiveButton(R.string.str_Cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();

            }
        }).show();
    }

    public static void onBackPress(final View view, final Activity activity) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.finish();
            }
        });
    }


    private static void Opensettings(Activity activity) {
        Uri uri = Uri.fromParts("package", activity.getPackageName(), null);
        activity.startActivity(new Intent(Settings.
                ACTION_APPLICATION_DETAILS_SETTINGS).setData(uri));
    }

    private static void OpenCamera(Activity activity) {
        activity.startActivity(new Intent(MediaStore.ACTION_IMAGE_CAPTURE));
    }

    public static void CustomStatusBar(Activity activity) {
        Window window = activity.getWindow();
        // set hien thi mau statusbar theo activity
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

}

