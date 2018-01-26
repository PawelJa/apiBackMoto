$(document).ready(function () {

    var API_URL = 'http://localhost:8080/'
    var event = {};

    var pathname = window.location.search;
    var id = pathname.split('=')[1];

    console.log(id);

    $.ajax({
        url: API_URL + "event/" + id
    }).done(function (response) {
        event = response;
        console.log(event);

        var eventContent= $('.event')
        // console.log(eventContent)

        eventContent.append("" +
            "<div class='eventName'>" + event.eventName + "</div>" +
            "<div class='trackName'>" + event.trackName + " / " + event.country + "</div>" +
            "<div class='description'>" + event.description + "</div>" +
            "<div class='details'> Szczegóły: </div>" +
            "<div class='date'>" + event.dateStart + " - " + event.dateEnd + "</div>" +
            "<div class='country'>" + event.country + "</div>" +
            "<div class='adress'>" + event.adress + "</div>" +
            "<button id='joinEvent'>Zapisz się</button>" +
            "<br><br><img src='http://motorraid.pl/wp-content/uploads/2017/11/tor-valencia2.png'/><br>" +
            "<div class='listUsers'> Lista aktualnych uczestników: </div>" +
            "<table class='table'></table>");

        var button = document.querySelector('#joinEvent');
        console.log(button);

        button.addEventListener('click', function () {
            console.log(id)

            var myHeaders = new Headers({
                'content-type': 'application/json'
            });

            var myInit = {
                method: "POST",
                headers: myHeaders,
                mode: "cors",
                cache: "default",
                credentials: "same-origin"
            };

            fetch(API_URL + "event/" + event.id + "/joinEvent", myInit).then(function (response) {
                window.location.href = pathname;
            })

        })
    });

    var riders = {}

    $.ajax({
        url: API_URL + "event/" + id + "/riders"
    }).done(function (response) {
        riders = response;
        console.log(riders);

        var table = $('.table')

        riders.forEach(function (e) {
            table.append("" +
                "<tr>" +
                "<td><img src='" + e.avatar + "' style='max-height: 80px; max-weidth: 80px'/></td>" +
                "<td>" + e.username + "</td>" +
                "<td>" + e.motorbike + "</td>" +
                "</tr>")
            // console.log(e.username)
        });

    })

})


