package com.reactnativejitsimeet;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.RCTEventEmitter;

import java.util.Map;

@ReactModule(name = RNJitsiMeetViewManager.REACT_CLASS)
public class RNJitsiMeetViewManager extends SimpleViewManager<RNJitsiMeetView>  {
  public static final String REACT_CLASS = "RNJitsiMeetView";
  private IRNJitsiMeetViewReference mJitsiMeetViewReference;
  private ReactApplicationContext mReactContext;

  public RNJitsiMeetViewManager(ReactApplicationContext reactContext, IRNJitsiMeetViewReference jitsiMeetViewReference) {
    mJitsiMeetViewReference = jitsiMeetViewReference;
    mReactContext = reactContext;
  }

  @Override
  public String getName() {
    return REACT_CLASS;
  }

  @Override
  public RNJitsiMeetView createViewInstance(ThemedReactContext context) {
    if (mJitsiMeetViewReference.getJitsiMeetView() == null) {
      RNJitsiMeetView view = new RNJitsiMeetView(context.getCurrentActivity());
      mJitsiMeetViewReference.setJitsiMeetView(view);
    }
    return mJitsiMeetViewReference.getJitsiMeetView();
  }

//  @ReactProp(name = "onConferenceJoined")
//  public void onConferenceJoined(Map<String, Object> data) {
//    WritableMap event = Arguments.createMap();
//    event.putString("url", (String) data.get("url"));
//    mReactContext.getJSModule(RCTEventEmitter.class).receiveEvent(
//      mJitsiMeetViewReference.getJitsiMeetView().getId(),
//      "conferenceJoined",
//      event);
//  }
//
//  @ReactProp(name = "onConferenceTerminated")
//  public void onConferenceTerminated(Map<String, Object> data) {
//    WritableMap event = Arguments.createMap();
//    event.putString("url", (String) data.get("url"));
//    event.putString("error", (String) data.get("error"));
//    mReactContext.getJSModule(RCTEventEmitter.class).receiveEvent(
//      mJitsiMeetViewReference.getJitsiMeetView().getId(),
//      "conferenceTerminated",
//      event);
//  }
//
//  @ReactProp(name = "onConferenceWillJoin")
//  public void onConferenceWillJoin(Map<String, Object> data) {
//    WritableMap event = Arguments.createMap();
//    event.putString("url", (String) data.get("url"));
//    mReactContext.getJSModule(RCTEventEmitter.class).receiveEvent(
//      mJitsiMeetViewReference.getJitsiMeetView().getId(),
//      "conferenceWillJoin",
//      event);
//  }
//
//  public Map getExportedCustomBubblingEventTypeConstants() {
//    return MapBuilder.builder()
//      .put("conferenceJoined", MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", "onConferenceJoined")))
//      .put("conferenceTerminated", MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", "onConferenceTerminated")))
//      .put("conferenceWillJoin", MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", "onConferenceWillJoin")))
//      .build();
//  }
}
