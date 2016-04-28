Cache
=============

This is a WebView cache plugin for Cordova 6.1.1+ supporting Android (>=4.1) and iOS(>=6.0).
It allows to clear the cordova webview cache.

There is one method:

* clear(successCallback, errorCallback)

Installation
======
You may use phonegap CLI as follows:

<pre>
➜ phonegap local plugin add https://github.com/moderna/cordova-plugin-cache.git
[phonegap] adding the plugin: https://github.com/moderna/cordova-plugin-cache.git
[phonegap] successfully added the plugin
</pre>

Usage
====
```javascript
document.addEventListener('deviceready', onDeviceReady);
function onDeviceReady()
{
        var success = function(status) {
            alert('Message: ' + status);
        }

        var error = function(status) {
            alert('Error: ' + status);
        }

        window.cache.clear( success, error );
}
```