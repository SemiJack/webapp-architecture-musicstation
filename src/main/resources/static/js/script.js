function successfullyLogout(){
    alert("Zostałeś wylogowany");
}
document.addEventListener("DOMContentLoaded",function (){
    if(document.getElementById('hello_message').innerText==="Jesteś zalogowany jako"){
        document.getElementById('hello_message').textContent="Zaloguj";
        document.getElementById('logout_request').style.display="none";
    }else{

    }
});


