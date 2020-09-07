function logoff(){
	alert("Log Off Successful.")
	sessionStorage.setItem("logged", null)
	sessionStorage.setItem("name", null)
	sessionStorage.setItem("email", null)
	window.location.href="http://localhost:8080/PILL_REMINDER_APP/login.html"
}