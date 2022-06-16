// Generated by view binder compiler. Do not edit!
package com.rafraph.pnineyHalachaHashalem.databinding;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.viewbinding.ViewBindings;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import com.rafraph.pnineyHalachaHashalem.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class AddBookmarkSpanishBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final Button dialogButtonOK;

  @NonNull
  public final EditText editTextBookmarkName;

  @NonNull
  public final TextView include;

  @NonNull
  public final RelativeLayout layoutRoot;

  @NonNull
  public final Spinner spinner1;

  private AddBookmarkSpanishBinding(@NonNull RelativeLayout rootView,
      @NonNull Button dialogButtonOK, @NonNull EditText editTextBookmarkName,
      @NonNull TextView include, @NonNull RelativeLayout layoutRoot, @NonNull Spinner spinner1) {
    this.rootView = rootView;
    this.dialogButtonOK = dialogButtonOK;
    this.editTextBookmarkName = editTextBookmarkName;
    this.include = include;
    this.layoutRoot = layoutRoot;
    this.spinner1 = spinner1;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static AddBookmarkSpanishBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static AddBookmarkSpanishBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.add_bookmark_spanish, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static AddBookmarkSpanishBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.dialogButtonOK;
      Button dialogButtonOK = ViewBindings.findChildViewById(rootView, id);
      if (dialogButtonOK == null) {
        break missingId;
      }

      id = R.id.editTextBookmarkName;
      EditText editTextBookmarkName = ViewBindings.findChildViewById(rootView, id);
      if (editTextBookmarkName == null) {
        break missingId;
      }

      id = R.id.include;
      TextView include = ViewBindings.findChildViewById(rootView, id);
      if (include == null) {
        break missingId;
      }

      RelativeLayout layoutRoot = (RelativeLayout) rootView;

      id = R.id.spinner1;
      Spinner spinner1 = ViewBindings.findChildViewById(rootView, id);
      if (spinner1 == null) {
        break missingId;
      }

      return new AddBookmarkSpanishBinding((RelativeLayout) rootView, dialogButtonOK,
          editTextBookmarkName, include, layoutRoot, spinner1);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}