$(document).ready(function () {
	// create records container
	var records = $('body #records');

	// link for adding new records
	var addRecLink = $('body #addRecord');

	// add link's click listener
	addRecLink.click(function () {
		var recordBuilder = new RecordBuilder();
		var record = recordBuilder.build();

		var lastElem = $('div.record').last();
		if (lastElem.length == 0) {
			records.prepend(record);
		} else {
			lastElem.after(record);
		}

		return false;
	});

	function RecordBuilder() {
		var recContainer = $('<div/>').attr({'class': 'record'});
		recContainer.reloadRecTypes = function () {
			// TODO: reload types on save action
		}

		var recTypesCBox = $('<input>').attr({'type': 'search','class': 'recTypesCBox'});

		recTypesCBox.autocomplete({
			source: ['Development', 'Management', 'Meetings', 'Overtimes', 'Rare cases']
		});

		var msgField = $('<input/>').attr({'type': 'search', 'size': '20'});

		var timeField = $('<input/>').attr({'type': 'search', 'size': '6'});

		var currTimeLink = $('<a />').attr({'class': 'currTimeLink', 'href': '#'}).text('Now');
		currTimeLink.click(function () {
			var currDate = new Date();
			var currMins = (currDate.getMinutes() > 9) ? currDate.getMinutes() : '0' + currDate.getMinutes();
			var timeString = currDate.getHours() + ':' + currMins;
			timeField.val(timeString);
			return false;
		});

		var removeRecLink = $('<a/>').attr({'href': '#', 'class': 'removeRec'}).text('Cancel');
		removeRecLink.click(function() {
			recContainer.remove();
		});

		var editLink = $('<a/>').attr({'href': '#', 'class': 'saveRec'}).text('Edit');

		var saveRecLink = $('<a/>').attr({'href': '#', 'class': 'saveRec'}).text('Save');
		saveRecLink.click(function () {
			var recType = recTypesCBox.val();
			var msg = msgField.val();
			var time = timeField.val();
			var resText = recType + " | " + msg + " | " + time;

			editLink
			recContainer.empty();
			recContainer
				.append(resText).append('&nbsp;')
				.append(editLink);

		});

		this.build = function (recType, msg, time) {
			recContainer
				.append(recTypesCBox.val(recType)).append('&nbsp;')
				.append(msgField.val(msg)).append('&nbsp;')
				.append(currTimeLink).append('&nbsp;')
				.append(timeField.val(time)).append('&nbsp;')
				.append(saveRecLink).append('&nbsp;')
				.append(removeRecLink);

			return recContainer;
		};
	}

});