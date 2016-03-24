package mg.yvan.openfacerecognition.utils;

import android.hardware.Camera;

/**
 * Created by Yvan on 23/03/16.
 */
@SuppressWarnings("deprecation")
public class CameraUtils {

    public static int findBackCameraID() {
        return findCamera(Camera.CameraInfo.CAMERA_FACING_BACK);
    }

    public static int findFrontCameraID() {
        return findCamera(Camera.CameraInfo.CAMERA_FACING_FRONT);
    }

    private static int findCamera(int type) {
        int cameraId = -1;
        // Search for the front facing camera
        int numberOfCameras = Camera.getNumberOfCameras();
        for (int i = 0; i < numberOfCameras; i++) {
            Camera.CameraInfo info = new Camera.CameraInfo();
            Camera.getCameraInfo(i, info);
            if (info.facing == type) {
                cameraId = i;
                break;
            }
        }
        return cameraId;
    }

}
