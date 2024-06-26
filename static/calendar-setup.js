﻿/*  Copyright Mihai Bazon, 2002, 2003  |  http://dynarch.com/mishoo/
 * ---------------------------------------------------------------------------
 *
 * The DHTML Calendar
 *
 * Details and latest version at:
 * http://dynarch.com/mishoo/calendar.epl
 *
 * This script is distributed under the GNU Lesser General Public License.
 * Read the entire license text here: http://www.gnu.org/licenses/lgpl.html
 *
 * This file defines helper functions for setting up the calendar.  They are
 * intended to help non-programmers get a working calendar on their site
 * quickly.  This script should not be seen as part of the calendar.  It just
 * shows you what one can do with the calendar, while in the same time
 * providing a quick and simple method for setting it up.  If you need
 * exhaustive customization of the calendar creation process feel free to
 * modify this code to suit your needs (this is recommended and much better
 * than modifying calendar.js itself).
 */

// $Id: calendar-setup.js,v 1.7 2003/11/03 05:54:09 mishoo Exp $
// DMendez 2003/12/04 Use parseDate to show inputField value when flat


/**
 *  This function "patches" an input field (or other element) to use a calendar
 *  widget for date selection.
 *
 *  The "params" is a single object that can have the following properties:
 *
 *    prop. name   | description
 *  -------------------------------------------------------------------------------------------------
 *   inputField    | the ID of an input field to store the date
 *   displayArea   | the ID of a DIV or other element to show the date
 *   button        | ID of a button or other element that will trigger the calendar
 *   eventName     | event that will trigger the calendar, without the "on" prefix (default: "click")
 *   ifFormat      | date format that will be stored in the input field
 *   daFormat      | the date format that will be used to display the date in displayArea
 *   singleClick   | (true/false) wether the calendar is in single click mode or not (default: true)
 *   mondayFirst   | (true/false) if true Monday is the first day of week, Sunday otherwise (default: true)
 *   align         | alignment (default: "Bl"); if you don't know what's this see the calendar documentation
 *   range         | array with 2 elements.  Default: [1900, 2999] -- the range of years available
 *   weekNumbers   | (true/false) if it's true (default) the calendar will display week numbers
 *   flat          | null or element ID; if not null the calendar will be a flat calendar having the parent with the given ID
 *   flatCallback  | function that receives a JS Date object and returns an URL to point the browser to (for flat calendar)
 *   disableFunc   | function that receives a JS Date object and should return true if that date has to be disabled in the calendar
 *   onSelect      | function that gets called when a date is selected.  You don't _have_ to supply this (the default is generally okay)
 *   onClose       | function that gets called when the calendar is closed.  [default]
 *   onUpdate      | function that gets called after the date is updated in the input field.  Receives a reference to the calendar.
 *   date          | the date that the calendar will be initially displayed to
 *   showsTime     | default: false; if true the calendar will include a time selector
 *   timeFormat    | the time format; can be "12" or "24", default is "12"
 *
 *  None of them is required, they all have default values.  However, if you
 *  pass none of "inputField", "displayArea" or "button" you'll get a warning
 *  saying "nothing to setup".
 */

if (!Calendar.setup) {
Calendar.setup = function (params) {

	// one-time initializations
	if (typeof Calendar._SDN == "undefined") {
		// table of short day names
		if (typeof Calendar._SDN_len == "undefined")
			Calendar._SDN_len = 3;
		var ar = [],
			i;
		for (i = 8; i > 0;) {
			ar[--i] = Calendar._DN[i].substr(0, Calendar._SDN_len);
		}
		Calendar._SDN = ar;
		// table of short month names
		if (typeof Calendar._SMN_len == "undefined")
			Calendar._SMN_len = 3;
		ar = [];
		for (i = 12; i > 0;) {
			ar[--i] = Calendar._MN[i].substr(0, Calendar._SMN_len);
		}
		Calendar._SMN = ar;
	}

	function param_default(pname, def) { if (typeof params[pname] == "undefined") { params[pname] = def; } }

	param_default("inputField", null);
	param_default("displayArea", null);
	param_default("button", null);
	param_default("eventName", "click");
	param_default("ifFormat", "%Y/%m/%d");
	param_default("daFormat", "%Y/%m/%d");
	param_default("singleClick", true);
	param_default("disableFunc", null);
	param_default("dateStatusFunc", params.disableFunc);	// takes precedence if both are defined
	param_default("mondayFirst", true);
	param_default("align", "Bl");
	param_default("range", [1753, 2999]);
	param_default("weekNumbers", true);
	param_default("flat", null);
	param_default("flatCallback", null);
	param_default("onSelect", null);
	param_default("onClose", null);
	param_default("onUpdate", null);
	param_default("date", null);
	param_default("showsTime", false);
	param_default("timeFormat", "24");
	param_default("displayRight", false);

	var inputField = gx.dom.form()[params.inputField];
	if (inputField == null)
		return false;
	var inputFieldValue = inputField.value;
	var tmp = ["inputField", "displayArea", "button"];
	for (var j in tmp) {
		if (typeof params[tmp[j]] == "string") {
			params[tmp[j]] = document.getElementById(params[tmp[j]]);
		}
	}
	if (params.button){
		params.button.title = Calendar._TT.SEL_DATE;
		params.button.alt = Calendar._TT.DATE_SELECTOR;
	}
	if (!(params.flat || params.inputField || params.displayArea || params.button)) {
		alert("Calendar.setup:\n  Nothing to setup (no fields found).  Please check your code");
		return false;
	}

	function onSelect(cal) {
		if (cal.params.flat) {
			if (typeof cal.params.flatCallback == "function") {
				cal.params.flatCallback(cal, cal.dateIsEmpty ? gx.date.nullDate() : cal.date, cal.params.inputField, undefined, cal.gxO);
			} else {
				alert("No flatCallback given -- doing nothing.");
			}
			return false;
		}
		if (cal.params.inputField) {
			cal.params.inputField.value = cal.date.print(cal.params.ifFormat);
		}
		if (cal.params.displayArea) {
			cal.params.displayArea.innerHTML = cal.date.print(cal.params.daFormat);
		}
		if (cal.params.singleClick && cal.dateClicked) {
			cal.callCloseHandler();
		}
		if (typeof cal.params.onUpdate == "function") {
			cal.params.onUpdate(cal);
		}
	}

	if (params.flat != null) {
		params.flat = document.getElementById(params.flat);
		if (!params.flat) {
			alert("Calendar.setup:\n  Flat specified but can't find parent.");
			return false;
		}
		var cal = new Calendar(params.mondayFirst, params.date, params.onSelect || onSelect);
		cal.gxO = params.gxO;
		cal.showsTime = params.showsTime;
		cal.time24 = (params.timeFormat == "24");
		cal.params = params;
		cal.weekNumbers = params.weekNumbers;
		cal.setRange(params.range[0], params.range[1]);
		cal.setDateStatusHandler(params.dateStatusFunc);
		cal.create(params.flat);
		cal.setDateFormat(params.ifFormat);
		cal.parseDate(inputFieldValue, params.ifFormat);
		cal.show();
		return false;
	}

	var triggerEl = params.button || params.displayArea || params.inputField;
	triggerEl["on" + params.eventName] = function () {
		if (!params.inputField || gx.csv.validControls(gx.csv.lastId, gx.fn.vStructId(params.inputField.id), false)) {
			var dateEl = params.inputField || params.displayArea;
			var dateFmt = params.inputField ? params.ifFormat : params.daFormat;
			var mustCreate = false;
			var cal;
			//if (!window.calendar) {
			window.calendar = cal = new Calendar(params.mondayFirst, params.date, params.onSelect || onSelect, params.onClose || function (cal) { cal.hide(); });
			cal.showsTime = params.showsTime;
			cal.time24 = (params.timeFormat == "24");
			cal.weekNumbers = params.weekNumbers;
			mustCreate = true;
			//} else {
			//	cal.hide();
			//}
			cal.setRange(params.range[0], params.range[1]);
			cal.params = params;
			cal.setDateStatusHandler(params.dateStatusFunc);
			cal.setDateFormat(dateFmt);
			var ctrl = params.displayArea || params.inputField;
			var parentNode;
			if (ctrl && gx.dom.hasClass(ctrl, "DPScroll"))
				parentNode = params.parentNode || ctrl.parentNode;			
				
			if (mustCreate)
				cal.create(parentNode);
					
			cal.parseDate(dateEl.value || dateEl.innerHTML, params.ifFormat);
			cal.refresh();
			cal.showAtElement(params.displayArea || params.inputField, params.align);
		}
		return false;
	};
};
}
