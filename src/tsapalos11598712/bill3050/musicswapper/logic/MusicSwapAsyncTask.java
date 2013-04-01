/**
 * 
 */
package tsapalos11598712.bill3050.musicswapper.logic;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import tsapalos11598712.bill3050.musicswapper.views.MyProgressDialog;

import android.os.AsyncTask;

/**
 * @author little
 * 
 */
public class MusicSwapAsyncTask extends AsyncTask<String, Integer, Boolean> {

	private MyProgressDialog progressDialog;
	private File[] greekSongs, etcSongs;
	private int totalFiles = -1, increment = 0;
	private StringBuilder builder;

	public MusicSwapAsyncTask(MyProgressDialog progressDialog) {
		this.progressDialog = progressDialog;
		builder = new StringBuilder();
	}

	@Override
	protected Boolean doInBackground(String... paths) {
		// TODO Auto-generated method stub
		try{
			totalFiles = countAllFiles(paths);
		} 
		catch(NullPointerException npe){return false;}

		progressDialog.setMax(totalFiles);

		if (paths[2].equals("0")) {
			// activate all music
			List<File> songsList = new ArrayList<File>(greekSongs.length
					+ etcSongs.length);
			Collections.addAll(songsList, greekSongs);
			Collections.addAll(songsList, etcSongs);
			File[] songs = songsList.toArray(new File[songsList.size()]);

			renameSongs(songs, "mp3");
		}
		if (paths[2].equals("1")) {
			// activate Greek music
			renameSongs(greekSongs, "mp3");

			renameSongs(etcSongs, "etc");
		}
		if (paths[2].equals("2")) {
			// activate etc music
			renameSongs(greekSongs, "grk");

			renameSongs(etcSongs, "mp3");
		}
		return true;
	}

	@Override
	protected void onPostExecute(Boolean result) {
		// TODO Auto-generated method stub
		if(result)
			progressDialog.dismiss();
		//else
			// TODO inform me for the error
	}

	@Override
	protected void onProgressUpdate(Integer... progress) {
		// TODO Auto-generated method stub
		progressDialog.setProgress(progress[0]);
	}

	/**
	 * Find out the total number of songs
	 * @param paths
	 * @return
	 */
	public int countAllFiles(String... paths) throws NullPointerException {
		File greekMusic = new File(paths[0]);
		File etcMusic = new File(paths[1]);
		greekSongs = greekMusic.listFiles();
		etcSongs = etcMusic.listFiles();
		return greekSongs.length + etcSongs.length;
	}

	/**
	 * Rename a list of songs to the appropriate file type
	 * @param songs
	 * @param type
	 */
	public void renameSongs(File[] songs, String type) {
		for (File oldSong : songs) {
			String oldPath = oldSong.getPath();
			builder.replace(0, builder.length(), oldPath);
			builder.replace(builder.length() - 3, builder.length(), type);
			File newSong = new File(builder.toString());
			oldSong.renameTo(newSong);
			publishProgress(++increment);
		}
	}

}
