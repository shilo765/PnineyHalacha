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
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import com.rafraph.pnineyHalachaHashalem.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class AutoScrollBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final Button dialogButtonOK;

  @NonNull
  public final TextView include;

  @NonNull
  public final RelativeLayout layoutRoot;

  @NonNull
  public final Spinner spinnerAutoScroll;

  private AutoScrollBinding(@NonNull RelativeLayout rootView, @NonNull Button dialogButtonOK,
      @NonNull TextView include, @NonNull RelativeLayout layoutRoot,
      @NonNull Spinner spinnerAutoScroll) {
    this.rootView = rootView;
    this.dialogButtonOK = dialogButtonOK;
    this.include = include;
    this.layoutRoot = layoutRoot;
    this.spinnerAutoScroll = spinnerAutoScroll;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static AutoScrollBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static AutoScrollBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.auto_scroll, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static AutoScrollBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.dialogButtonOK;
      Button dialogButtonOK = ViewBindings.findChildViewById(rootView, id);
      if (dialogButtonOK == null) {
        break missingId;
      }

      id = R.id.include;
      TextView include = ViewBindings.findChildViewById(rootView, id);
      if (include == null) {
        break missingId;
      }

      RelativeLayout layoutRoot = (RelativeLayout) rootView;

      id = R.id.spinner_auto_scroll;
      Spinner spinnerAutoScroll = ViewBindings.findChildViewById(rootView, id);
      if (spinnerAutoScroll == null) {
        break missingId;
      }

      return new AutoScrollBinding((RelativeLayout) rootView, dialogButtonOK, include, layoutRoot,
          spinnerAutoScroll);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}