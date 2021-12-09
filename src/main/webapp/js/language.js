function setLanguageTag(lang) {
	window.localStorage.setItem('lang', lang);
}

function getLanguageTag() {
	  return window.localStorage.getItem('lang');
}

function switchToEnglish() {
	let ruElements = document.getElementsByClassName('lang-ru');
	let enElements = document.getElementsByClassName('lang-en');
	for (var i = 0; i < ruElements.length; i++) {
		ruElements.item(i).hidden = true;
	}
	for (var i = 0; i < enElements.length; i++) {
		enElements.item(i).hidden = false;
	}
	
	setLanguageTag('en');
}

function switchToRussion() {
	let ruElements = document.getElementsByClassName('lang-ru');
	let enElements = document.getElementsByClassName('lang-en');
	console.log(ruElements.length);
	console.log(enElements.length);
	for (var i = 0; i < ruElements.length; i++) {
		ruElements.item(i).hidden = false;
	}
	for (var i = 0; i < enElements.length; i++) {
		enElements.item(i).hidden = true;
	}
	
	setLanguageTag('ru');
}

document.addEventListener("DOMContentLoaded", () => {
	let lang = getLanguageTag();
	if (lang == null) {
		setLanguageTag('en');
		lang = 'en';
	}
	
	if (lang == 'en') {
		switchToEnglish();
	}
	if (lang == 'ru') {
		switchToRussion();
	}
});
