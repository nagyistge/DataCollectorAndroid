package de.mpg.mpdl.www.datacollector.app.Workflow.UploadView;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

import java.util.ArrayList;
import java.util.List;

import de.mpg.mpdl.www.datacollector.app.R;

/**
 * Created by allen on 02/05/15.
 */
public class AskDeleteFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());


        builder.setTitle(R.string.dialog_delete_title)
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int id) {
                        // User clicked OK button
                        String[]  mTagsArray = getResources().getStringArray(R.array.tags_array);

                        List<String> tags = new ArrayList<String>();
                        for (Object item : mSelectedItems) {
                            tags.add(mTagsArray[Integer.parseInt(item.toString())]);
                        }

                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                        mSelectedItems.clear();
                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();
    }
}