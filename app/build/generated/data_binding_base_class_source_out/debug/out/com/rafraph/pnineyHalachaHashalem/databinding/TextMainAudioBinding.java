// Generated by view binder compiler. Do not edit!
package com.rafraph.pnineyHalachaHashalem.databinding;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.viewbinding.ViewBindings;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import com.rafraph.pnineyHalachaHashalem.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class TextMainAudioBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final TextView audioDuration;

  @NonNull
  public final TextView audioDuration2;

  @NonNull
  public final RelativeLayout content;

  @NonNull
  public final RelativeLayout footer;

  @NonNull
  public final LinearLayout hi;

  @NonNull
  public final ListView listView;

  @NonNull
  public final LinearLayout lnrOption3;

  @NonNull
  public final ImageView makeMark;

  @NonNull
  public final ImageButton mediaFf;

  @NonNull
  public final ImageButton mediaNext;

  @NonNull
  public final ImageButton mediaPlayPause;

  @NonNull
  public final ImageButton mediaPrev;

  @NonNull
  public final ImageButton mediaRew;

  @NonNull
  public final ImageView menu;

  @NonNull
  public final RelativeLayout myAudio;

  @NonNull
  public final Spinner myspinner;

  @NonNull
  public final ImageView pageSearch;

  @NonNull
  public final TextView playerInfo;

  @NonNull
  public final SeekBar seekBar6;

  @NonNull
  public final ImageView tooMain;

  @NonNull
  public final WebView webView1;

  private TextMainAudioBinding(@NonNull RelativeLayout rootView, @NonNull TextView audioDuration,
      @NonNull TextView audioDuration2, @NonNull RelativeLayout content,
      @NonNull RelativeLayout footer, @NonNull LinearLayout hi, @NonNull ListView listView,
      @NonNull LinearLayout lnrOption3, @NonNull ImageView makeMark, @NonNull ImageButton mediaFf,
      @NonNull ImageButton mediaNext, @NonNull ImageButton mediaPlayPause,
      @NonNull ImageButton mediaPrev, @NonNull ImageButton mediaRew, @NonNull ImageView menu,
      @NonNull RelativeLayout myAudio, @NonNull Spinner myspinner, @NonNull ImageView pageSearch,
      @NonNull TextView playerInfo, @NonNull SeekBar seekBar6, @NonNull ImageView tooMain,
      @NonNull WebView webView1) {
    this.rootView = rootView;
    this.audioDuration = audioDuration;
    this.audioDuration2 = audioDuration2;
    this.content = content;
    this.footer = footer;
    this.hi = hi;
    this.listView = listView;
    this.lnrOption3 = lnrOption3;
    this.makeMark = makeMark;
    this.mediaFf = mediaFf;
    this.mediaNext = mediaNext;
    this.mediaPlayPause = mediaPlayPause;
    this.mediaPrev = mediaPrev;
    this.mediaRew = mediaRew;
    this.menu = menu;
    this.myAudio = myAudio;
    this.myspinner = myspinner;
    this.pageSearch = pageSearch;
    this.playerInfo = playerInfo;
    this.seekBar6 = seekBar6;
    this.tooMain = tooMain;
    this.webView1 = webView1;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static TextMainAudioBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static TextMainAudioBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.text_main_audio, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static TextMainAudioBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.audioDuration;
      TextView audioDuration = ViewBindings.findChildViewById(rootView, id);
      if (audioDuration == null) {
        break missingId;
      }

      id = R.id.audioDuration2;
      TextView audioDuration2 = ViewBindings.findChildViewById(rootView, id);
      if (audioDuration2 == null) {
        break missingId;
      }

      id = R.id.content;
      RelativeLayout content = ViewBindings.findChildViewById(rootView, id);
      if (content == null) {
        break missingId;
      }

      id = R.id.footer;
      RelativeLayout footer = ViewBindings.findChildViewById(rootView, id);
      if (footer == null) {
        break missingId;
      }

      id = R.id.hi;
      LinearLayout hi = ViewBindings.findChildViewById(rootView, id);
      if (hi == null) {
        break missingId;
      }

      id = R.id.list_view;
      ListView listView = ViewBindings.findChildViewById(rootView, id);
      if (listView == null) {
        break missingId;
      }

      id = R.id.lnrOption3;
      LinearLayout lnrOption3 = ViewBindings.findChildViewById(rootView, id);
      if (lnrOption3 == null) {
        break missingId;
      }

      id = R.id.make_mark;
      ImageView makeMark = ViewBindings.findChildViewById(rootView, id);
      if (makeMark == null) {
        break missingId;
      }

      id = R.id.media_ff;
      ImageButton mediaFf = ViewBindings.findChildViewById(rootView, id);
      if (mediaFf == null) {
        break missingId;
      }

      id = R.id.media_next;
      ImageButton mediaNext = ViewBindings.findChildViewById(rootView, id);
      if (mediaNext == null) {
        break missingId;
      }

      id = R.id.media_play_pause;
      ImageButton mediaPlayPause = ViewBindings.findChildViewById(rootView, id);
      if (mediaPlayPause == null) {
        break missingId;
      }

      id = R.id.media_prev;
      ImageButton mediaPrev = ViewBindings.findChildViewById(rootView, id);
      if (mediaPrev == null) {
        break missingId;
      }

      id = R.id.media_rew;
      ImageButton mediaRew = ViewBindings.findChildViewById(rootView, id);
      if (mediaRew == null) {
        break missingId;
      }

      id = R.id.menu;
      ImageView menu = ViewBindings.findChildViewById(rootView, id);
      if (menu == null) {
        break missingId;
      }

      RelativeLayout myAudio = (RelativeLayout) rootView;

      id = R.id.myspinner;
      Spinner myspinner = ViewBindings.findChildViewById(rootView, id);
      if (myspinner == null) {
        break missingId;
      }

      id = R.id.page_search;
      ImageView pageSearch = ViewBindings.findChildViewById(rootView, id);
      if (pageSearch == null) {
        break missingId;
      }

      id = R.id.playerInfo;
      TextView playerInfo = ViewBindings.findChildViewById(rootView, id);
      if (playerInfo == null) {
        break missingId;
      }

      id = R.id.seekBar6;
      SeekBar seekBar6 = ViewBindings.findChildViewById(rootView, id);
      if (seekBar6 == null) {
        break missingId;
      }

      id = R.id.too_main;
      ImageView tooMain = ViewBindings.findChildViewById(rootView, id);
      if (tooMain == null) {
        break missingId;
      }

      id = R.id.webView1;
      WebView webView1 = ViewBindings.findChildViewById(rootView, id);
      if (webView1 == null) {
        break missingId;
      }

      return new TextMainAudioBinding((RelativeLayout) rootView, audioDuration, audioDuration2,
          content, footer, hi, listView, lnrOption3, makeMark, mediaFf, mediaNext, mediaPlayPause,
          mediaPrev, mediaRew, menu, myAudio, myspinner, pageSearch, playerInfo, seekBar6, tooMain,
          webView1);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}