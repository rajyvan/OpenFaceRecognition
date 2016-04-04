package mg.yvan.openfacerecognition.manager;

import android.hardware.Camera;

import mg.yvan.openfacerecognition.utils.CameraUtils;

/**
 * Created by Yvan on 29/03/16.
 */
public class CameraManager {

    private static CameraManager singleInstance;

    private int cameraId;

    private CameraManager() {
        cameraId = CameraUtils.findFrontCameraID();
    }

    public static CameraManager getInstance() {
        if (singleInstance == null) {
            singleInstance = new CameraManager();
        }
        return singleInstance;
    }

    public int getNextCameraId() {
        int numberOfCameras = Camera.getNumberOfCameras();
        cameraId++;
        return cameraId % numberOfCameras;
    }
}
