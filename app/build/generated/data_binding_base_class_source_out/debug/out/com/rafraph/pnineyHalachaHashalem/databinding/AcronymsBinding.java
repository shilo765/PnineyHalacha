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
import android.widget.TextView;
import com.rafraph.pnineyHalachaHashalem.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class AcronymsBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final Button dialogButtonDecode;

  @NonNull
  public final Button dialogButtonExit;

  @NonNull
  public final EditText editTextAcronyms;

  @NonNull
  public final TextView include;

  @NonNull
  public final RelativeLayout layoutRoot;

  @NonNull
  public final TextView textViewDecodedText;

  private AcronymsBinding(@NonNull RelativeLayout rootView, @NonNull Button dialogButtonDecode,
      @NonNull Button dialogButtonExit, @NonNull EditText editTextAcronyms,
      @NonNull TextView include, @NonNull RelativeLayout layoutRoot,
      @NonNull TextView textViewDecodedText) {
    this.rootView = rootView;
    this.dialogButtonDecode = dialogButtonDecode;
    this.dialogButtonExit = dialogButtonExit;
    this.editTextAcronyms = editTextAcronyms;
    this.include = include;
    this.layoutRoot = layoutRoot;
    this.textViewDecodedText = textViewDecodedText;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static AcronymsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static AcronymsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.acronyms, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static AcronymsBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.dialogButtonDecode;
      Button dialogButtonDecode = ViewBindings.findChildViewById(rootView, id);
      if (dialogButtonDecode == null) {
        break missingId;
      }

      id = R.id.dialogButtonExit;
      Button dialogButtonExit = ViewBindings.findChildViewById(rootView, id);
      if (dialogButtonExit == null) {
        break missingId;
      }

      id = R.id.editTextAcronyms;
      EditText editTextAcronyms = ViewBindings.findChildViewById(rootView, id);
      if (editTextAcronyms == null) {
        break missingId;
      }

      id = R.id.include;
      TextView include = ViewBindings.findChildViewById(rootView, id);
      if (include == null) {
        break missingId;
      }

      RelativeLayout layoutRoot = (RelativeLayout) rootView;

      id = R.id.textViewDecodedText;
      TextView textViewDecodedText = ViewBindings.findChildViewById(rootView, id);
      if (textViewDecodedText == null) {
        break missingId;
      }

      return new AcronymsBinding((RelativeLayout) rootView, dialogButtonDecode, dialogButtonExit,
          editTextAcronyms, include, layoutRoot, textViewDecodedText);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}