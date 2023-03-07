// Define the translations for each language
		var translations = {
			'en': {
				'signup': 'Sign Up',
                                'email': 'Email',
				'password': 'password',
                                'submit': 'signup'
				
			},
			'kinya': {
				'signup': 'kwiyandikisha',
                                'email': 'imeri',
				'password': 'umubare wibanga',
				'submit': 'ohereza',
                                'sign': 'iyandikishe'
				
			},
			'fr': {
				'signup': 'S\'inscrire',
                                'email': 'e-mail',
				'password': 'mot de passe',
				'submit': 'envoyer'
			}
		};
		
		// Set the default language to English
		var currentLang = 'en';
		
		// Check if a language preference is stored in the browser's local storage
		if (localStorage.getItem('language')) {
			currentLang = localStorage.getItem('language');
		} else {
			// If no language preference is stored, try to detect the user's browser language
			var userLang = navigator.language || navigator.userLanguage;
			if (userLang.substring(0, 2) in translations) {
				currentLang = userLang.substring(0, 2);
			}
		}
		
		// Update the website content with the translations for the current language
		function updateLanguage() {
			document.getElementById('signup').innerHTML = translations[currentLang]['signup'];
			document.getElementById('user').placeholder = translations[currentLang]['email'];
			document.getElementById('pass').placeholder = translations[currentLang]['password'];
                        document.getElementById('sign').placeholder = translations[currentLang]['sign'];

			document.getElementById('login-btn').innerHTML = translations[currentLang]['submit'];
			localStorage.setItem('language', currentLang); // Store the selected language in the browser's local storage
		}
		
		// Update the language when the user selects a different language
		function changeLanguage(lang) {
			currentLang = lang;
			updateLanguage();
               	}
                
