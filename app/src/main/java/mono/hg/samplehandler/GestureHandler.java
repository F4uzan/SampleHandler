package mono.hg.samplehandler;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.lang.annotation.Retention;

import androidx.annotation.IntDef;
import androidx.annotation.Nullable;

import static java.lang.annotation.RetentionPolicy.SOURCE;

public class GestureHandler extends Activity {
    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Retrieve the calling intent.
        Intent intent = getIntent();
        int direction = getIntent().getIntExtra("direction", -1);

        if ("text/plain".equals(intent.getType())) {
            switch (direction) {
                case Gesture.LEFT:
                    Toast.makeText(this, R.string.left, Toast.LENGTH_SHORT).show();
                    break;
                case Gesture.RIGHT:
                    Toast.makeText(this, R.string.right, Toast.LENGTH_SHORT).show();
                    break;
                case Gesture.UP:
                    Toast.makeText(this, R.string.up, Toast.LENGTH_SHORT).show();
                    break;
                case Gesture.DOWN:
                    Toast.makeText(this, R.string.down, Toast.LENGTH_SHORT).show();
                    break;
                case Gesture.TAP:
                    Toast.makeText(this, R.string.tap, Toast.LENGTH_SHORT).show();
                    break;
                case Gesture.DOUBLE_TAP:
                    Toast.makeText(this, R.string.double_tap, Toast.LENGTH_SHORT).show();
                    break;
                default:
                    // No-op.
                    break;
            }
        }

        // Immediately finish to return back to the launcher.
        finish();
    }

    /**
     * Directions of gesture.
     */
    @IntDef({Gesture.LEFT,
            Gesture.RIGHT,
            Gesture.UP,
            Gesture.DOWN,
            Gesture.TAP,
            Gesture.DOUBLE_TAP})
    @Retention(SOURCE)
    public @interface Gesture {
        int LEFT = 0;
        int RIGHT = 1;
        int UP = 10;
        int DOWN = 11;
        int TAP = 100;
        int DOUBLE_TAP = 101;
    }
}
