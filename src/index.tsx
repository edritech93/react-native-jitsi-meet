import {
  requireNativeComponent,
  UIManager,
  Platform,
  NativeModules
} from 'react-native';

const LINKING_ERROR =
  `The package 'react-native-jitsi-meet' doesn't seem to be linked. Make sure: \n\n` +
  Platform.select({ ios: "- You have run 'pod install'\n", default: '' }) +
  '- You rebuilt the app after installing the package\n' +
  '- You are not using Expo managed workflow\n';

const ComponentName = 'RNJitsiMeetView';

export const JitsiMeetView =
  UIManager.getViewManagerConfig(ComponentName) != null
    ? requireNativeComponent<any>(ComponentName)
    : () => {
        throw new Error(LINKING_ERROR);
      };

const JitsiMeetModule = NativeModules.RNJitsiMeetView;
const call = JitsiMeetModule.call;
const audioCall = JitsiMeetModule.audioCall;
const endCall = JitsiMeetModule.endCall;
JitsiMeetModule.call = (url: string, userInfo: any, meetOptions: any, meetFeatureFlags: any) => {
  userInfo = userInfo || {};
  meetOptions = meetOptions || {};
  meetFeatureFlags = meetFeatureFlags || {};
  call(url, userInfo, meetOptions, meetFeatureFlags);
}
JitsiMeetModule.audioCall = (url: string, userInfo: any) => {
  userInfo = userInfo || {};
  audioCall(url, userInfo);
}
JitsiMeetModule.endCall = () => {
  endCall();
}
export default JitsiMeetModule;




