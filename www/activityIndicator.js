var ActivityIndicator = {
    show: function (_text, _cancelable) {
    	var text = _text || "Carregando...",
    		cancelable = _cancelable || false;

        cordova.exec(null, null, "ActivityIndicator", "show", [text, cancelable]);
    },
    hide: function () {
        cordova.exec(null, null, "ActivityIndicator", "hide", []);
    }
};

module.exports = ActivityIndicator;