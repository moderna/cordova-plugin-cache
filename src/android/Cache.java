/*
 Copyright 2014 Modern Alchemists OG

 Licensed under MIT.

 Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 documentation files (the "Software"), to deal in the Software without restriction, including without limitation
 the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and
 to permit persons to whom the Software is furnished to do so, subject to the following conditions:

 The above copyright notice and this permission notice shall be included in all copies or substantial portions of
 the Software.

 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO
 THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,
 TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 SOFTWARE.
*/

package at.modalog.cordova.plugin.cache;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;

import org.json.JSONArray;
import org.json.JSONException;

import android.annotation.TargetApi;
import android.app.Activity;
import android.util.Log;

@TargetApi(19)
public class Cache extends CordovaPlugin
{
	private static final String LOG_TAG = "Cache";
	private CallbackContext callbackContext;

	/**
	 * Constructor.
	 */
	public Cache() {

	}

    @Override
    public boolean execute (String action, JSONArray args, CallbackContext callbackContext) throws JSONException
    {
		/*try
		{
		*/
			if( action.equals("clear") )
			{
				Log.v(LOG_TAG,"Cordova Android Cache.clear() called.");
		        this.callbackContext = callbackContext;
				
				final Cache self = this;
		        cordova.getActivity().runOnUiThread( new Runnable() {
		            public void run()
					{
						try
						{
							// clear the cache
							self.webView.clearCache(true);
							
							// send success result to cordova
							PluginResult result = new PluginResult(PluginResult.Status.OK);
							result.setKeepCallback(false); 
							self.callbackContext.sendPluginResult(result);
						}
						catch( Exception e )
						{
							String msg = "Error while clearing webview cache.";
							Log.e(LOG_TAG, msg );
							
							// return error answer to cordova
							PluginResult result = new PluginResult(PluginResult.Status.ERROR, msg);
							result.setKeepCallback(false); 
							self.callbackContext.sendPluginResult(result);
						}
		            }
		        });
				return true;
			}
			return false;
			/*
		}
		catch (JSONException e)
		{
			// TODO: signal JSON problem to JS
			//callbackContext.error("Problem with JSON");
			return false;
		}
		*/
    }
}