function successfullyLogout(){
    alert("You have been logged out");
}
document.addEventListener("DOMContentLoaded",function (){
    if(document.getElementById('hello_message').innerText==="Jesteś zalogowany jako"){
        document.getElementById('hello_message').textContent="Zaloguj";
    }
});


