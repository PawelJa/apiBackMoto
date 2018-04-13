$(document).ready(function () {
    var API_URL = 'http://localhost:8080/'
    var userDetails = {};

    $.ajax({
        url: API_URL + "user/details"
    }).done(function (response) {
        userDetails = response;

        $('#username').attr('placeholder',userDetails.username);
        $('#username').attr('placeholder',userDetails.firstName);
        $('#username').attr('placeholder',userDetails.lastName);
        $('#username').attr('placeholder',userDetails.address);
        $('#username').attr('placeholder',userDetails.city);
        $('#username').attr('placeholder',userDetails.postcode);
        $('#username').attr('placeholder',userDetails.phoneNumber);
        $('#username').attr('placeholder',userDetails.motorbike);

    });

    var buttonToSend = document.querySelector('#buttonToSend');
    buttonToSend.addEventListener('click', function () {
        var username = $('#username').val();
        var firstName = $('#firstName').val();
        var lastName = $('#lastName').val();
        var address = $('#address').val();
        var city = $('#city').val();
        var postcode = $('#postcode').val();
        var phoneNumber = $('#phoneNumber').val();
        var motorbike = $('#motorbike').val();
        var userId = $('#id').val();

        var objToSend = {
            username : username,
            firstName : firstName,
            lastName : lastName,
            address : address,
            city : city,
            postcode : postcode,
            phoneNumber : phoneNumber,
            motorbike : motorbike,
            userId : userId
        };

        var myHeaders = new Headers({
            'content-type' : 'application/json'
        });

        var myInit = {
            method: "PUT",
            headers: myHeaders,
            mode: "cors",
            cache: "default",
            body: JSON.stringify(objToSend)
        };

        fetch(API_URL + "user/details/" + userId, myInit).then(function (response) {
            // window.location.href=API_URL + "/user/menu/menu.html"
        })

    })
});