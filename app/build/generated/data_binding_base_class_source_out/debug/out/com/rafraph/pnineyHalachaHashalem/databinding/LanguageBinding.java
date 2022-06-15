// Generated by view binder compiler. Do not edit!
package com.rafraph.pnineyHalachaHashalem.databinding;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.viewbinding.ViewBindings;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.rafraph.pnineyHalachaHashalem.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class LanguageBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final TextView chooseTochen;

  @NonNull
  public final ImageView dialogX;

  @NonNull
  public final ImageView imEsDown;

  @NonNull
  public final ImageView imFDown;

  @NonNull
  public final RelativeLayout layoutRoot;

  @NonNull
  public final LinearLayout lnrOption2;

  @NonNull
  public final LinearLayout lnrOption3;

  @NonNull
  public final LinearLayout lnrOption4;

  @NonNull
  public final LinearLayout lnrOption5;

  @NonNull
  public final LinearLayout lnrOptions;

  @NonNull
  public final TextView pickBooks;

  @NonNull
  public final RadioGroup radios;

  @NonNull
  public final ImageView settings;

  @NonNull
  public final ImageView toPy;

  @NonNull
  public final ImageView tooPy;

  private LanguageBinding(@NonNull RelativeLayout rootView, @NonNull TextView chooseTochen,
      @NonNull ImageView dialogX, @NonNull ImageView imEsDown, @NonNull ImageView imFDown,
      @NonNull RelativeLayout layoutRoot, @NonNull LinearLayout lnrOption2,
      @NonNull LinearLayout lnrOption3, @NonNull LinearLayout lnrOption4,
      @NonNull LinearLayout lnrOption5, @NonNull LinearLayout lnrOptions,
      @NonNull TextView pickBooks, @NonNull RadioGroup radios, @NonNull ImageView settings,
      @NonNull ImageView toPy, @NonNull ImageView tooPy) {
    this.rootView = rootView;
    this.chooseTochen = chooseTochen;
    this.dialogX = dialogX;
    this.imEsDown = imEsDown;
    this.imFDown = imFDown;
    this.layoutRoot = layoutRoot;
    this.lnrOption2 = lnrOption2;
    this.lnrOption3 = lnrOption3;
    this.lnrOption4 = lnrOption4;
    this.lnrOption5 = lnrOption5;
    this.lnrOptions = lnrOptions;
    this.pickBooks = pickBooks;
    this.radios = radios;
    this.settings = settings;
    this.toPy = toPy;
    this.tooPy = tooPy;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static LanguageBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static LanguageBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.language, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static LanguageBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.chooseTochen;
      TextView chooseTochen = ViewBindings.findChildViewById(rootView, id);
      if (chooseTochen == null) {
        break missingId;
      }

      id = R.id.dialog_x;
      ImageView dialogX = ViewBindings.findChildViewById(rootView, id);
      if (dialogX == null) {
        break missingId;
      }

      id = R.id.im_es_down;
      ImageView imEsDown = ViewBindings.findChildViewById(rootView, id);
      if (imEsDown == null) {
        break missingId;
      }

      id = R.id.im_f_down;
      ImageView imFDown = ViewBindings.findChildViewById(rootView, id);
      if (imFDown == null) {
        break missingId;
      }

      RelativeLayout layoutRoot = (RelativeLayout) rootView;

      id = R.id.lnrOption2;
      LinearLayout lnrOption2 = ViewBindings.findChildViewById(rootView, id);
      if (lnrOption2 == null) {
        break missingId;
      }

      id = R.id.lnrOption3;
      LinearLayout lnrOption3 = ViewBindings.findChildViewById(rootView, id);
      if (lnrOption3 == null) {
        break missingId;
      }

      id = R.id.lnrOption4;
      LinearLayout lnrOption4 = ViewBindings.findChildViewById(rootView, id);
      if (lnrOption4 == null) {
        break missingId;
      }

      id = R.id.lnrOption5;
      LinearLayout lnrOption5 = ViewBindings.findChildViewById(rootView, id);
      if (lnrOption5 == null) {
        break missingId;
      }

      id = R.id.lnrOptions;
      LinearLayout lnrOptions = ViewBindings.findChildViewById(rootView, id);
      if (lnrOptions == null) {
        break missingId;
      }

      id = R.id.pickBooks;
      TextView pickBooks = ViewBindings.findChildViewById(rootView, id);
      if (pickBooks == null) {
        break missingId;
      }

      id = R.id.radios;
      RadioGroup radios = ViewBindings.findChildViewById(rootView, id);
      if (radios == null) {
        break missingId;
      }

      id = R.id.settings;
      ImageView settings = ViewBindings.findChildViewById(rootView, id);
      if (settings == null) {
        break missingId;
      }

      id = R.id.to_py;
      ImageView toPy = ViewBindings.findChildViewById(rootView, id);
      if (toPy == null) {
        break missingId;
      }

      id = R.id.too_py;
      ImageView tooPy = ViewBindings.findChildViewById(rootView, id);
      if (tooPy == null) {
        break missingId;
      }

      return new LanguageBinding((RelativeLayout) rootView, chooseTochen, dialogX, imEsDown,
          imFDown, layoutRoot, lnrOption2, lnrOption3, lnrOption4, lnrOption5, lnrOptions,
          pickBooks, radios, settings, toPy, tooPy);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
