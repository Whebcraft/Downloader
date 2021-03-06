# Downloader plugin for Phonegap (Cordova)

The plugin can start and stop a file download from the web.

## Adding the plugin to your project ##

1. To install the plugin,
Use the following command to always use the latest version of the plugin: cordova plugin add 

https://github.com/Whebcraft/Downloader.git

## Using the plugin ##

The plugin creates the method `downloadmanager(action, options, win, fail)`

`action` may be: 

* `start` to beging to download a file
* `cancel` to stop one
* `isdownloading` to know the status of another

`options` is a json object containing the parameters (some optional) that DownloadManager accepts, it can be:

* `id:` an ID from a download process (required for "cancel" and "isdownloadind" action)
* `url:` the url to get (http://wherever.com/whatever.txt) (required for "start" action)
* `filePath:` path where to save the file (FileSystem/Download/YOUR_PATH) (optional, by default the app name)
* `fileName:` filename for the resource (FileSystem/Download/YOUR_PATH/YOUR_FILENAME.yy) (optional, by default the url name)
* `overwrite:` If the file already exists, download it again. (required for "start" action)
* `useNotificationBar:` `true`to use the Android notification bar to show the progress (optional, by defautl true)
* `startToast:` Message on toast at the beginning of the download process (optional)
* `endToast:` Message on toast at the end of the download process (optional)  
* `ticker:` Message to show on notification area where the download start (optional) 
* `notificationTitle:` Message to show on the notification bar while during download (optional)
* `cancelToast:`: Message on toast where the donwload is canceled (stoped) (optional)
 
`win` and `fail` are callback functions. `win` will be called when there is a progress in the download. The passed object is:

    {
    	id: "45345"			// id to handle the process
    	downloading: true 	// true or false 
    	total: 1000,      	// The total number of bytes to download.
    	file: "file.ext"  	// Name of the file
    	dir: "youappname"	// Path where to download
        progress: 46,     	// In percent
    }

## Using the plugin ##
	
* Basic: (start a download on a notification bar)

<pre>
downloadmanager(
	"start",
	{
		url: url2down,
    	overwrite: true
	},
	function(info) {
    	console.info(info.progress);
        // Example to stop a download on 30%:
        if (info.progress === 30)
    		downloadmanager("cancel", {id: info.id}, function() {}, function() {});
	},
	function(error) {
    	console.error(error);
	}
);
</pre>

* Check if a donwload is in progress:

<pre>
downloadmanager("cancel", {id: "example_id"}, function(res) {
	alert(res); // true or false
}, function() {});
</pre>

* More:

<pre>
downloadmanager(
	"start",
   	{
   		url: "http://wherever.com/lalalala/.txt",
	 	filePath: "from_myapp",
	 	fileName: "hello.txt", // (FileSystem)/Download/from_myappp/hello.txt
	 	overwrite: false,
	 	useNotificationBar: true,
	 	startToast: "Starting download...",
	 	endToast: "Download end!",
	 	ticker: "Downloading...",
	 	notificationTitle: "hello.txt",
	 	cancelToast: "Download canceled!"
   	},
  	function(info) {
		console.info("id:          "+info.id+"\n" +
	              	 "downloading: "+info.downloading+"\n" +
	              	 "total:       "+info.total+"\n" +
	              	 "file:        "+info.file+"\n" +
	              	 "dir:         "+info.dir+"\n" +
	              	 "progress:    "+info.progress+"\n"
		      		);
     	// progress bar example:
		$('#progress_bar').css('width', info.progress)
   	},
  	function(error) {
		alert(error);
  	}
);
</pre>

## Licence ##

The MIT License

Copyright (c) 2015 Whebcraft

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
