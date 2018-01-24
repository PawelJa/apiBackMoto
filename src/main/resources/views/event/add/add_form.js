$(document).ready(function () {
    var API_URL = 'http://localhost:8080/';

    var buttonToSend = document.querySelector('#buttonToSend');
    console.log(buttonToSend);
    buttonToSend.addEventListener('click', function () {
        var eventName = $('#eventName').val();
        var trackName = $('#trackName').val();
        var country = $('#country').val();
        var adress = $('#adress').val();
        var dateStart = $('#dateStart').val();
        var dateEnd = $('#dateEnd').val();
        var description = $('#description').val();

        var objectToSend = {
            eventName: eventName,
            trackName: trackName,
            country: country,
            adress: adress,
            dateStart: dateStart,
            dateEnd: dateEnd,
            description: description
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
        fetch(API_URL + "/event/add", myInit).then(function (response) {
            window.location.href = API_URL + "event/all";
        });
    });

});