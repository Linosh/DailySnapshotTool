$(document).ready(function () {
	// create records container
	var records = $('body #records');

	// link for adding new records
	var addRecLink = $('body #addRecord');

	// add link's click listener
	addRecLink.click(function () {
		var record = new Record();

		var lastElem = $('div.record').last();

		if (lastElem.length == 0) {
			records.prepend(record.html());
		} else {
			lastElem.after(record.html());
		}

		record.initListeners();
		return false;
	});

	function Record() {
		var RecordBase = {
			toJson: function () {
				var res = {};
				for (var key in this) {
					var val = this[key];
					if (typeof val == "string") {
						res[key] = val;
					}
				}
				return res;
			}
		};

		var rec = $.extend(RecordBase, {
			container: Global.createUUID(),
			typesField: Global.createUUID(),
			msgField: Global.createUUID(),
			timeField: Global.createUUID(),
			currTimeLink: Global.createUUID(),
			saveLink: Global.createUUID(),
			remLink: Global.createUUID()
		});

		this.html = function () {
			var newRecTmpl = $.templates('#newRecord');
			var newRec = newRecTmpl.render(rec.toJson());
			return newRec;
		};

		this.initListeners = function () {

			initJquerySelectors(rec);

			RecordUtils.getRecTypes(function(types) {
				rec.typesField.autocomplete({
					source: types
				});
			});

			rec.currTimeLink.click(function () {
				var currDate = new Date();
				var currMins = (currDate.getMinutes() > 9) ? currDate.getMinutes() : '0' + currDate.getMinutes();
				var timeString = currDate.getHours() + ':' + currMins;
				rec.timeField.val(timeString);
				return false;
			});

			rec.remLink.click(function () {
				rec.container.remove();
			});

			rec.saveLink.click(function () {
				var recType = rec.typesField.val();
				var msg = rec.msgField.val();
				var time = rec.timeField.val();
				var resText = recType + " | " + msg + " | " + time;

				rec.container.empty();
				rec.container
					.append(resText).append('&nbsp;');

			});
		};

		var initJquerySelectors = function (record) {
			for (var key in record) {
				var val = record[key];
				if (typeof val == "string") {
					record[key] = $("#" + val);
				}
			}
		};
	};
});