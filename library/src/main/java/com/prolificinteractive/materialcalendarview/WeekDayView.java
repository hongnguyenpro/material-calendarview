package com.prolificinteractive.materialcalendarview;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.TextView;

import com.prolificinteractive.materialcalendarview.format.WeekDayFormatter;

import java.util.Calendar;

/**
 * Display a day of the week
 */
class WeekDayView extends TextView {

    private WeekDayFormatter formatter = WeekDayFormatter.DEFAULT;
    private int dayOfWeek;

    public WeekDayView(Context context) {
        this(context, null);
    }

    public WeekDayView(Context context, AttributeSet attrs) {
        super(context, attrs);

        setGravity(Gravity.CENTER);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            setTextAlignment(TEXT_ALIGNMENT_CENTER);
        }

        setDayOfWeek(Calendar.MONDAY);
    }

    public void setWeekDayFormatter(WeekDayFormatter formatter) {
        this.formatter = formatter == null ? WeekDayFormatter.DEFAULT : formatter;
        setDayOfWeek(dayOfWeek);
    }

    public void setDayOfWeek(int dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
        setText(formatter.format(dayOfWeek));
    }
    
    public void setDayOfWeek(Calendar calendar) {
        setDayOfWeek(CalendarUtils.getDayOfWeek(calendar));
    }
}
