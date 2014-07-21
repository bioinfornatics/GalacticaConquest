package game.bioinfornatics.galacticaconquest;


import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;


public class HorizontalNumberPicker extends LinearLayout {
	ViewGroup   numberPicker;
	Button      minus;
	Button      plus;
	EditText    text;
	
    public HorizontalNumberPicker(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray      attributes  = context.getTheme().obtainStyledAttributes(attrs, R.styleable.horizontal_number_picker, 0, 0);
        TextView        textView;
        //LinearLayout ViewContainer=(LinearLayout) (LayoutInflater.from(context)).inflate(attributes.getResourceId(R.styleable.horizontal_number_picker_maxValueFromTextId, R.layout.[defaultValue]), null);
        attributes.recycle();

        LayoutInflater layoutInflater   = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        numberPicker                    = (ViewGroup) layoutInflater.inflate(R.layout.horizontal_number_picker, this);

		minus 			= (Button) numberPicker.findViewById( R.id.btn_minus );
		plus 			= (Button) numberPicker.findViewById( R.id.btn_plus );
		text            = (EditText) numberPicker.findViewById( R.id.edit_text );
		
		Boolean bm = new Boolean(minus == null);
		Log.i( "info", bm.toString()  );
		
		minus.setOnClickListener( minusHandler );
		plus.setOnClickListener(plusHandler);
    }

	View.OnClickListener minusHandler = new View.OnClickListener( ) {
		@Override
		public void onClick( View v ) {
			Integer value = Integer.parseInt( text.getText().toString() );
			if( value > 0 ){
				value--;
				text.setText( value.toString(), TextView.BufferType.EDITABLE );
			}
		}
	};
	View.OnClickListener plusHandler = new View.OnClickListener( ) {
		@Override
		public void onClick( View v ) {
			Integer value = Integer.parseInt( text.getText().toString() );
			if( value < 10 ){
				value++;
				text.setText( value.toString(), TextView.BufferType.EDITABLE );
			}
		}
	};
}
