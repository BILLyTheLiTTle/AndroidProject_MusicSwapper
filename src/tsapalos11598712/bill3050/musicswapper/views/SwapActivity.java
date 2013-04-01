package tsapalos11598712.bill3050.musicswapper.views;

import tsapalos11598712.bill3050.musicswapper.R;
import tsapalos11598712.bill3050.musicswapper.controllers.MusicSwapController;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Spinner;

public class SwapActivity extends Activity {

	private Spinner musicTypes;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_swap);
		
		musicTypes = (Spinner) findViewById(R.id.music_type_spinner);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.swap, menu);
		return true;
	}
	
	/**
	 * Deliver the event to the controller to start the action of 
	 * renaming the songs
	 * @param view
	 */
	public void swapSongs(View view){
		new MusicSwapController(this,musicTypes).activateMusic();
	}

}
