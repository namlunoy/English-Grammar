package adapters;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.List;

import models.Lesson;

/**
 * Created by hoangvancong on 10/21/16.
 */

public class ListLessonAdapter extends ArrayAdapter<Lesson> {
    public ListLessonAdapter(Context context, int resource, List<Lesson> objects) {
        super(context, resource, objects);
    }


}
