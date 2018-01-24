$(document).ready(function () {
    var API_URL = 'http://localhost:8080/';

    var buttonToSend = document.querySelector('#buttonToSend');
    console.log(buttonToSend);
    buttonToSend.addEventListener('click', function() {
        var username = $('#username').val();
        var password = $('#password').val();
        var email = $('#email').val();

        var objectToSend = {
            username : username,
            password : password,
            email : email
        };

        var myHeaders = new Headers({
            'content-type': 'application/json'
        });

        var myInit = {
            method: "POST",
            headers: myHeaders,
            mode: "cors",
            cache: "default",
            body: JSON.stringify(objectToSend)
        };

        // console.log(username + ", " + password + ", " + email);
        fetch("http://localhost:8080/user/add", myInit).then(function (response) {
            window.location.href=API_URL+"user/all";
        });
    });

});