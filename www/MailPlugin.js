cordova.define("net/appvanced/mailplugin", function(require, exports, module) {
	var cordovaRef = require('cordova');

	/**
	 * Mail plugin for Cordova
	 * 
	 * @constructor
	 */
	function MailPlugin() { }

	/**
	 * Send an email message
	 *
	 * @param {Object}   options   Mail send options
	 * @param {Function} onSuccess The function to call in case of success (takes the copied text as argument)
	 * @param {Function} onFail    The function to call in case of error
	 */
	MailPlugin.prototype.send = function(options, onSuccess, onFail) {
	    options = options || {};

	    var defaults = {
	        user:		null,
	        password:	null,
	        from:		null,
	        to:			null,
	        subject:	null,
	        body:		null
	    }

	    for (var key in defaults)
	        if (options[key] !== undefined)
	            defaults[key] = options[key];

	    return cordovaRef.exec(onSuccess, onFail, 'MailPlugin', 'send', [options]);
	};

	// Register the plugin
	var mailplugin = new MailPlugin();
	module.exports = mailplugin;
});
