/**
 * 
 */
package tsapalos11598712.bill3050.musicswapper.controllers;

import java.io.File;

import tsapalos11598712.bill3050.musicswapper.logic.MusicSwapAsyncTask;
import tsapalos11598712.bill3050.musicswapper.views.*;
import android.os.Environment;
import android.widget.Spinner;

/**
 * @author little
 * 
 */
public class MusicSwapController {

	private String sdcardPath, greekMusicPath, etcMusicPath;
	private SwapActivity activity;
	private Spinner musicTypes;
	private MyProgressDialog progressDialog;
	
	public MusicSwapController(SwapActivity activity, Spinner musicTypes){
		this.activity=activity;
		this.musicTypes=musicTypes;
		
		//configure the paths
		// TODO extract them to be editable from thee app
		sdcardPath=Environment.getExternalStorageDirectory().getPath();
		greekMusicPath=sdcardPath+File.separator+"usbStorage"+File.separator+"sda1"+
						File.separator+"mx5 music"+File.separator+"greek"+File.separator;
		etcMusicPath=sdcardPath+File.separator+"usbStorage"+File.separator+"sda1"+
				File.separator+"mx5 music"+File.separator+"etc"+File.separator;
		/*greekMusicPath=sdcardPath+File.separator+
				"1musictest"+File.separator+"v"+File.separator;
		etcMusicPath=sdcardPath+File.separator+
				"1musictest"+File.separator+"m"+File.separator;*/
	}
	
	/**
	 * Starts the asynchronous task of renaming the songs
	 */
	public void activateMusic() {
		progressDialog=new MyProgressDialog(activity, -1);
		progressDialog.show();
		
		new MusicSwapAsyncTask(progressDialog).execute(
				new String[]{greekMusicPath, 
						etcMusicPath, 
						String.valueOf(musicTypes.getSelectedItemPosition())});

	}
}
