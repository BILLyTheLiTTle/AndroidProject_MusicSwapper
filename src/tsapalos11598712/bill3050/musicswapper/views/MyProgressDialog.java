/**
 * 
 */
package tsapalos11598712.bill3050.musicswapper.views;

import tsapalos11598712.bill3050.musicswapper.R;
import android.app.ProgressDialog;
import android.content.Context;

/**
 * @author little
 *
 */
public class MyProgressDialog extends ProgressDialog {

	/**
	 * @param context
	 */
	public MyProgressDialog(Context context, int limit) {
		super(context);
		// TODO Auto-generated constructor stub
		preconfigureDialog(context, limit);
	}

	/**
	 * @param context
	 * @param theme
	 */
	public MyProgressDialog(Context context, int theme, int limit) {
		super(context, theme);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Apply default settings for my progress dialog
	 */
	public void preconfigureDialog(Context ctx, int limit){
		setCancelable(true);
		setMessage(ctx.getResources().getString(R.string.progress_dialog_message));
		setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		setProgress(0);
		setMax(limit);
	}

}
