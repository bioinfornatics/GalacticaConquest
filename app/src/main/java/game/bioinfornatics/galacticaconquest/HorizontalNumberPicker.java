package game.bioinfornatics.galacticaconquest;



import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.Button;
import android.support.v7.appcompat.R;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.util.Log;
//import android.text.*;


public class HorizontalNumberPicker extends LinearLayout {
	View numberPicker;
	Button minus;
	Button plus;
	EditText text;
	
    public HorizontalNumberPicker(Context context, AttributeSet attrs) {
        super(context, attrs);
		numberPicker 	= findViewById( R.layout.horizontal_number_picker );
		minus 			= (Button) numberPicker.findViewById( R.id.btn_minus );
		plus 			= (Button) numberPicker.findViewById( R.id.btn_plus );
		text            = (EditText) numberPicker.findViewById( R.id.edit_text );
		
		Boolean bm = new Boolean(minus == null);
		Log.i( "info", bm.toString()  );
		
		minus.setOnClickListener( minusHandler );
		plus.setOnClickListener( plusHandler );
		
        LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        layoutInflater.inflate(R.layout.horizontal_number_picker, this);
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
