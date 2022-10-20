package com.reactnativejitsimeet;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.jitsi.meet.sdk.JitsiMeetView;

public class RNJitsiMeetView extends JitsiMeetView {

  public RNJitsiMeetView(@NonNull Context context) {
    super(context);
  }

  public void join(@Nullable RNJitsiMeetConferenceOptions options) {
    this.join(options);
  }

  public void leave() {
    this.leave();
  }
}
