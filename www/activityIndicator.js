var ActivityIndicator = {
    show: function (_text, _cancelable, _success, _error) {
    	var text = _text || "Carregando...",
    		cancelable = _cancelable || false,
    		success = _success|| function(){},
    		error = _error || function(){};

        cordova.exec(success, error, "ActivityIndicator", "show", [text, cancelable]);
    },
    hide: function () {
        cordova.exec(null, null, "ActivityIndicator", "hide", []);
    }
};

module.exports = ActivityIndicator;
